;;; Sierra Script 1.0 - (do not remove this comment)
(script# 831)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Wander)

(public
	Room831 0
)

(local
	menuDepth
	currentBook
	availableBooks = [303 308 305 306 309 310]
	length = 6 ; must be set to number of AvailableBooks
)


(instance Room831 of Room
	(properties
		picture 831 ;scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(else 
				;(self setScript: RoomScript)
			)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		
		(if (Said 'disembark,quit,back')
			(switch menuDepth
				(0
					(curRoom newRoom: 830)
				)
				(10
					(DrawPic 831 0)
					(= menuDepth 0)
				)
				(20
					(DrawPic 831 0)
					(= menuDepth 0)
				)
			)
		)
		(if (Said 'look>')
			(cond 
				((Said '[/area,around]')
					(switch menuDepth
						(0
							(Print 831 0) ;device or books
						)
						(10
							(Print 831 8) ;device 
						)
						(20
							(Print 831 9) ;books
						)
					)
				)
			)
		)
		(if (Said 'buy>')
			(cond 
				((Said '/device,eslab')
					(switch menuDepth
						(0
							(DrawPic 832 0)
							(= menuDepth 10)
						)
					)
				)
				((Said '/book')
					(switch menuDepth
						(0
							(drawBookCover)
							(= menuDepth 20)
						)
					)
				)
				((Said '[/anyword]')
					(switch menuDepth
						(0
							(Print 831 1)
						)
						(10
							(if
								(or
									(ego has: iESlab)
									slabInChute
								)
								(Print 831 3) ;already have device or is in chute
							else
								(doBuy)
							)
						)
						(20
							(if (ego has: iESlab)
								(doBuy)
							else
								(Print 831 7)
							)
						)
					)
				)
			)
		)
		(if (Said 'next[/book]')
			(if (== menuDepth 20)
				(if (< currentBook length)
					(++ currentBook)
					
				else
					(= currentBook 0)
				)	
				(drawBookCover)
			else
				(Print 830 2) ; command unavail
			)
		)
		(if (Said 'previous[/book]')
			(if (== menuDepth 20)
				(if (> currentBook 0)
					(-- currentBook)
					
				else
					(= currentBook length)
				)	
				(drawBookCover)
			else
				(Print 830 2) ; command unavail
			)
		)
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
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					posn: 160 200
					setMotion: MoveTo 160 185 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(procedure (drawBookCover &tmp temp0)
	(= temp0 [availableBooks currentBook])
	(if
		(or
			(== temp0 308)
			(== temp0 308)
		)
		(DrawPic temp0 0)
	else	
		(DrawPic 833 0) ;default background
		(Display ;title
			temp0 0
			;p_width 110
			p_at 35 50
			p_color 0
			p_font 600
		)
		(Display ;title
			temp0 1
			;p_width 110
			p_at 35 60
			p_color 0
			p_font 600
		)
		(Display ;description
			temp0 2
			p_width 100
			p_at 40 75
			p_color 3
			p_font 600
		)
	)
)

(procedure (doBuy)
	(switch menuDepth
		(10
			(Print 831 4)
			(= slabInChute TRUE)
		)
		(20
			(if (syncDoc [availableBooks currentBook])
				(Print 831 5)  ;success
			else
				(Print 831 6) ;failed purchase
			)
		)
	)
)

(procedure (syncDoc book &tmp i r)
	(= i 0)
	(= r 0)
	(while (< i 12)
		(if (== [owned i] book) 
			(return 0) ;prevent duplicates
		)
		(if
			(and
				(== [owned i] 0)
				(not r)
			)
			(= r 1)
			(= [owned i] book) ;upload purchased book
		)
		(++ i)
	)
	(return r)
)