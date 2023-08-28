;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
(include game.sh)
(include keys.sh)
(use Main)
(use Intrface)
(use Sound)
(use Game)
(use System)
(use Actor)

(public
	Room823 0
)

(local
	textColor = 1
	textFont = 1
	itr
	selected
	allowInput
	curPage
	bSel = 0
	menuLevel
	
)

(instance button1 of Prop
	(properties
		view 322
		loop 0
		cel 0
		x 285
		y 50
	)
)

(instance button2 of Prop
	(properties
		view 322
		loop 2
		cel 0
		x 285
		y 70
	)
)

(instance button3 of Prop
	(properties
		view 322
		loop 1
		cel 0
		x 285
		y 90
	)
)

(instance button4 of Prop
	(properties
		view 322
		loop 3
		cel 0
		x 285
		y 110
	)
)

(instance button5 of Prop
	(properties
		view 322
		loop 5
		cel 0
		x 285
		y 130
	)
)


(instance Room823 of Room
	(properties
		picture 905
	)
	
	(method (init)
		(super init:)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(button5 init:)
		(self setScript: RoomScript)

	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		; handle Said's, etc...
		(switch (event type?)
			(saidEvent
				(cond 
					((or (Said 'disembark,quit') (Said '/bye'))
						(curRoom newRoom: prevRoomNum)
					)
				)
			)
			(keyDown
				(if allowInput
					(cond
						((== (event message?) KEY_RETURN)
							(doButt)
						)
					)
				)
			)
			(direction
				(if allowInput
					(switch (event message?)
						(dirS
							(++ bSel)
							(if (> bSel 4)
								(= bSel 4)
							)
							(changeButt)
						)
						(dirN
							(-- bSel)
							(if (< bSel 0)
								(= bSel 0)
							)
							(changeButt)
						)
					)
				)
			)
			(mouseDown
				(if
					(and
						(ClickedInRect button1 event)
						(== allowInput 1)
					)
					(= bSel 0)
					(RoomScript changeState: 100)
				)
				(if
					(and
						(ClickedInRect button2 event)
						(== allowInput 1)
					)
					(= bSel 1)
					(RoomScript changeState: 100)
				)
				(if
					(and
						(ClickedInRect button3 event)
						(== allowInput 1)
					)
					(= bSel 2)
					(RoomScript changeState: 100)
				)
				(if
					(and
						(ClickedInRect button4 event)
						(== allowInput 1)
					)
					(= bSel 3)
					(RoomScript changeState: 100)
				)
				(if
					(and
						(ClickedInRect button5 event)
						(== allowInput 1)
					)
					(= bSel 4)
					(RoomScript changeState: 100)
				)	
			)
		)
	)
	
	(method (doit)
		(super doit:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp i)
		(= state newState)
		(switch state
			(0
				(= allowInput FALSE)
				(Display
					300 3 ;booting...
					p_width 250
					p_at 30 15
					p_mode teJustLeft
					p_font textFont
					p_color textColor
				)
				(= cycles 10)
			)
			(1
				(Display
					300 3 
					p_width 250
					p_at 30 15
					p_mode teJustLeft
					p_font textFont
					p_color 7 ;vlitegray
				)
				(= cycles 10)
				(if (< itr 1)
					(= state -1)
					(++ itr)
				)
			)
			(2
				(= itr 0)
				(Display
					300 1
					p_width 200
					p_at 30 15
					p_mode teJustLeft
					p_font textFont
					p_color textColor
				)
				(= cycles 10)
			)
			(3
				(Display
					300 2
					p_width 200
					p_at 30 35
					p_mode teJustLeft
					p_font textFont
					p_color textColor
				)
				(= cycles 5)
			)
			(4
				(Display
					(if (== [owned itr] 0) 300 else [owned itr]) 0 ;title
					p_width 200
					p_at 35 (+ 50 (* itr 10))
					p_mode teJustLeft
					p_font textFont
					p_color 
						(if (== [owned itr] 0)
							(if (== selected itr) 4 else 0) ;red if non-selectable, black for empty slots
						else
							(if (== selected itr) 2 else textColor)
						)
				)
				(if (< itr 11)
					(++ itr)
					(= state 3)
				)
				(= cycles 2)
			)
			(5
				(= allowInput TRUE)
				;(= bSel 2)
				;(button3 cel: 1)
				;(button5 cel: 0)
				(changeButt)
			)
			(100
				(changeButt)
				(= cycles 1)
			)
			(101
				(doButt)
			)
		)
	)
)

(procedure (redrawTitles &tmp i)
	(while (< i 12)
		(Display
			(if (== [owned i] 0) 300 else [owned i]) 0
			p_width 200
			p_at 35 (+ 50 (* i 10))
			p_mode teJustLeft
			p_font textFont
			p_color 
				(if (== [owned i] 0)
					(if (== selected i) 4 else 0) ;red if non-selectable, black for empty slots
				else
					(if (== selected i) 2 else textColor)
				)
		)
		(++ i)
	)
)

(procedure (displayPage &tmp [str 30])
	(DrawPic 905 5)
	(Display
		[owned selected] 0
		p_width 200
		p_at 35 15
		p_mode teJustCenter
		p_font textFont
		p_color 15 ;textColor
	)
	(Display
		[owned selected] curPage
		p_width 210
		p_at 35 35
		p_mode teJustLeft
		p_font textFont
		p_color textColor
	)
	(Display
		(Format @str {Page %d} (- curPage 2))
		p_width 200
		p_at 35 170
		p_mode teJustCenter
		p_font textFont
		p_color 8 ;textColor
	)
)

(procedure (changeButt)
	(button1 cel: 0)
	(button2 cel: 0)
	(button3 cel: 0)
	(button4 cel: 0)
	(button5 cel: 0)	
	(switch bSel
		(0 (button1 cel: 1))
		(1 (button2 cel: 1))
		(2 (button3 cel: 1))
		(3 (button4 cel: 1))
		(4 (button5 cel: 1))
	)
)

(procedure (doButt &tmp i)
	(switch bSel
		(0
			(curRoom newRoom: prevRoomNum)
		)
		(1 ;previous
			(switch menuLevel
				(0
					(-- selected)
					(if (< selected 0)
						(= selected 0)
					)
					(redrawTitles)
				)
				(1
					(if (> curPage 3)
						(-- curPage)
						(= [bookmark selected] curPage)
						(displayPage)
					)
				)
			)
		)
		(2 ;next
			(switch menuLevel
				(0
					(++ selected)
					(if (> selected 11)
						(= selected 11)
					)
					(redrawTitles)
				)
				(1
					(if (not (finalPage))
						(++ curPage)
						(= [bookmark selected] curPage)
						(displayPage)
					)
				)
			)
		)
		(3 ;select
			(switch menuLevel
				(0
					(if (not (== [owned selected] 0))
						(= curPage [bookmark selected])
						(= menuLevel 1)
						(button5 loop: 4) ;view selected
						(displayPage)
					)
				)
				(1 ;advance page
					(if (not (finalPage))
						(++ curPage)
						(= [bookmark selected] curPage)
						(displayPage)
					)
				)
			)
		)
		(4 ;back/delte button
			(switch menuLevel
				(0
					(if (not (== [owned selected] 0))
						(= i selected)
						(while (< i 11)
							(= [owned i] [owned (+ i 1)])
							(= [bookmark i] [bookmark (+ i 1)])
							(++ i)
						)
						(= [owned 11] 0)
						(= [bookmark 11] 3)
						(DrawPic 905 5)
						(RoomScript changeState: 2)
					)
					
				)
				(1
					(= menuLevel 0)
					(= bSel 3)
					(DrawPic 905 5)
					(button5 loop: 5) ;delete
					(RoomScript changeState: 2)
				)
			)
		)
	)
)

(procedure (finalPage &tmp [str 500])
	;(StrCpy str [owned selected] curPage)
    (if (== 0 (StrCmp (Format @str [owned selected] (+ curPage 1)) "ENDOFDOC")) ;strings are equal
    	(return 1)
    else
    	(return 0)
    )
)

(procedure (ClickedInRect button event)
	(if
		(and
			(>= (event x?) (button nsLeft?)) ;left edge
			(<= (event x?) (button nsRight?)) ;right edge
			(>= (event y?) (button nsTop?)) ;top edge
			(<= (event y?) (button nsBottom?)) ;bottom edge
		)
		
		(return TRUE)
	else
		(return FALSE)	
	)
)