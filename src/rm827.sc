;;; Sierra Script 1.0 - (do not remove this comment)
(script# 827)
(include game.sh)
(include keys.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room827 0
)

(local
	i
	comMode
	amtLength
	amt
	[amtTable 5]
)

(instance logo of Prop
	(properties
		view 827
		x 150
		y 40
	)
)

(instance button1 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 85
		y 89
	)
)

(instance button2 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 85
		y 105
	)
)

(instance button3 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 218
		y 89
	)
)

(instance button4 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 218
		y 105
	)
)

(instance button5 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 85
		y 58
	)
)

(instance button6 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 85
		y 74
	)
)

(instance button7 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 218
		y 58
	)
)

(instance button8 of Prop
	(properties
		view 827
		loop 1
		cel 0
		x 218
		y 74
	)
)

(instance Room827 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(button5 init:)
		(button6 init:)
		(button7 init:)
		(button8 init:)
		(curRoom setScript: RoomScript)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type?)
			(saidEvent
				(cond
					(
						(or
							(Said 'disembark,quit[/atm,device]')
							(Said '/bye')
						)
						(curRoom newRoom: prevRoomNum)
					)
					((Said 'create/account')
						(if (== comMode 1)
							(RoomScript changeState: 102)
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'deposit')
						(if (== comMode 2)
							(= comMode 3)
							(RoomScript changeState: 200)
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'withdrawal')
						(if (== comMode 2)
							(= comMode 4)
							(RoomScript changeState: 200)
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'trade')
						(if (== comMode 2)
							
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'buy')
						(if (== comMode 5)
							
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'sell')
						(if (== comMode 5)
							
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'back')
						(if
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(RoomScript changeState: 5)
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'clear')
						(if
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(ClearAmt)
						else
							(Print {That is not currently an option.})
						)
					)
					((Said 'submit')
						(if
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(if (> amt 0)
								(Submit)
							else
								(Print {Enter an ammount greater that zero, Roger.})
							)
						else
							(Print {That is not currently an option.})
						)
					)	
				)
			)
			(keyDown
;;;				(Print {keyDown})
				(if
					(and
						(>= (ReturnNum (event message?)) 0) ; KEY_0)
						(<= (ReturnNum (event message?)) 9) ;KEY_9)
						(or
							(== comMode 3)
							(== comMode 4)
						)
					)
					;(Printf {(ReturnNum (event message?)): %d} (ReturnNum (event message?)))
					(event claimed: TRUE)
					(CalAmount (event message?))
				)
				(if
					(or
						(== comMode 3)
						(== comMode 4)
					)
					(if (== (event message?) KEY_RETURN)
						(if (> amt 0)
							(Submit)
						)
					)
					(if (== (event message?) KEY_BACK)
						(if (> amt 0)
							(ClearAmt)
						)
					)
				)
			)
			(mouseDown
				(if (ClickedInRect button1 event)
					(cond
						((== comMode 2) ;deposit
							(= comMode 3)
							(RoomScript changeState: 200)
						)
						(;submit
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(if (> amt 0)
								(Submit)
							else
								(Print {Enter an ammount greater that zero, Roger.})
							)
						)
					)
				)
				(if (ClickedInRect button2 event)
					(cond
						((== comMode 1) ;create account
							(RoomScript changeState: 102)
						)
						((== comMode 2) ;withdrawal
							(= comMode 4)
							(RoomScript changeState: 200)
						)
						(;clear
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(ClearAmt)
						)
					)
				)
				(if (ClickedInRect button3 event)
					(cond
						((== comMode 2) ;trade
							;not yet implemented
						)
					)
				)
				(if (ClickedInRect button4 event)
					(cond
						((== comMode 2)
							(curRoom newRoom: prevRoomNum)
						)
						(;back
							(or
								(== comMode 3)
								(== comMode 4)
							)
							(RoomScript changeState: 5)
						)
					)
				)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState &tmp [str 100])
		(= state newState)
		(switch state
			(0
				(logo init:)
				(= i 0)
				(= cycles 20)
			)
			(1
				(Display
					{Scanning user...}
					p_width 100
					p_at 115 50
					p_color vYELLOW ;vBLACK 
					p_font 600
				)
				(= cycles 10)
			)
			(2
				(Display
					{Scanning user...}
					p_width 100
					p_at 115 50
					p_color vBLACK 
					p_font 600
				)
				(if (< i 3)
					(= state 0) ;scanning loop
					(++ i)
				)
				(= cycles 10)
			)
			(3
				(Display
					{User identified: Roger Wilco}
					p_width 100
					p_at 115 50
					p_color vYELLOW 
					p_font 600
				)
				(if (== hBal -32768)
					(= state 99)
				)
				(= cycles 10)
			)
			(4
				(Display
					{Welcome back, Roger.}
					p_width 100
					p_at 115 70
					p_color vGREEN
					p_font 600
				)
				(= cycles 40)
			)
			(5
				(DrawPic 827 100) ;clear screen
				(Display
					{Roger Wilco #831734}
					p_width 150
					p_at 105 45
					p_color vCYAN 
					p_font 600
				)
				(Display
					{Acct. bal:}
					p_width 100
					p_at 110 55
					p_color vYELLOW 
					p_font 600
				)
				(Display
					(Format @str {%d} hBal)
					p_width 100
					p_at 160 55
					p_color (if (< hBal 0) vRED else vGREEN) 
					p_font 600
				)
				(Display
					{DEPOSIT}
					p_width 100
					p_at 100 83
					p_color 10 ;vLIME
					p_font 600
				)
				(button1 cel: 1)
				(Display
					{WITHDRAWAL}
					p_width 100
					p_at 100 99
					p_color 10
					p_font 600
				)
				(button2 cel: 1)
				(Display
					{TRADE}
					p_width 100
					p_at 178 83
					p_color 10 ;vLIME
					p_font 600
				)
				(button3 cel: 1)
				(Display
					{EXIT}
					p_width 100
					p_at 186 99
					p_color 10
					p_font 600
				)
				(button4 cel: 1)
				(= comMode 2) 
			)
			(100
				(Display
					{No account on file.}
					p_width 100
					p_at 105 70
					p_color vRED
					p_font 600
				)
				(= cycles 20)
			)
			(101
				(Display
					{CREATE ACCOUNT}
					p_width 100
					p_at 100 99
					p_color 10 ;vLIME
					p_font 600
				)
				(button2 cel: 1)
				(= comMode 1)
			)
			(102
				(DrawPic 827 100)
				(Display
					{Notice: all financial holdings above 32,000 are subject to a 100% tax rate as allowed by galactic law!}
					p_width 100
					p_at 105 50
					p_color vYELLOW
					p_font 600
				)
				(button2 cel: 0)
				(= hBal 0)
				(= cycles 180)
			)
			(103
				(DrawPic 827 100)
				(Display
					{Account created successfully!}
					p_width 100
					p_at 110 60
					p_color vGREEN 
					p_font 600
				)
				(= hBal 0)
				(= state 4) ;goto balance screen
				(= cycles 100)
			)
			(200
				(ClearAmt)
				(DrawPic 827 100) ;clear screen
				(Display
					{Roger Wilco #831734}
					p_width 150
					p_at 105 45
					p_color vCYAN 
					p_font 600
				)
				(Display
					(cond
						((== comMode 3) {Enter deposit amt.})
						((== comMode 4) {Enter wdrl. amt.})
					)
					p_width 150
					p_at 105 55
					p_color vYELLOW 
					p_font 600
				)
				(Display
					{(1-32k):}
					p_width 150
					p_at 105 65
					p_color vYELLOW 
					p_font 600
				)
				(Display
					(Format @str {%d} amt)
					p_width 100
					p_at 145 65
					p_color (if (< hBal 0) vRED else vGREEN) 
					p_font 600
				)
				(Display
					{SUBMIT}
					p_width 100
					p_at 100 83
					p_color 10 ;vLIME
					p_font 600
				)
				(button1 cel: 1)
				(Display
					{CLEAR}
					p_width 100
					p_at 100 99
					p_color 10
					p_font 600
				)
				(button2 cel: 1)
				(button3 cel: 0)
				(Display
					{BACK}
					p_width 100
					p_at 185 99
					p_color 10
					p_font 600
				)
				(button4 cel: 1)
			)
			(210
				(Display
					(Format @str {%d} amt)
					p_width 100
					p_at 145 65
					p_color vBLACK
					p_font 600
				)
				(Display
					(cond
						((== comMode 3) {insufficient buckazoids})
						((== comMode 4) {insufficient funds})
					)
					p_width 80
					p_at 145 65
					p_color vRED
					p_font 600
				)
				(= cycles 40)
			)
			(211
				(Display
					(cond
						((== comMode 3) {insufficient buckazoids})
						((== comMode 4) {insufficient funds})
					)
					p_width 80
					p_at 145 65
					p_color vBLACK
					p_font 600
				)
				(ClearAmt)
			)
			(220
				(= hBal (+ hBal amt))
				(if (<= buckazoids 0) (ego put: iBuckazoids -1))
				(ClearAmt)
				(DrawPic 827 100) ;clear screen
				(Display
					{Roger Wilco #831734}
					p_width 150
					p_at 105 45
					p_color vCYAN 
					p_font 600
				)
				(Display
					{Deposit Successful!}
					p_width 150
					p_at 105 55
					p_color vGREEN 
					p_font 600
				)
				(button1 cel: 0)
				(button2 cel: 0)
				(button3 cel: 0)
				(button4 cel: 0)
				(= state 4)
				(= cycles 40)
			)
			(230
				(= hBal (- hBal amt))
				(if (not (ego has: iBuckazoids))
					(ego get: iBuckazoids)
				)
				(ClearAmt)
				(DrawPic 827 100) ;clear screen
				(Display
					{Roger Wilco #831734}
					p_width 150
					p_at 105 45
					p_color vCYAN 
					p_font 600
				)
				(Display
					{Withdrawal Successful!}
					p_width 100
					p_at 105 55
					p_color vGREEN 
					p_font 600
				)
				(button1 cel: 0)
				(button2 cel: 0)
				(button3 cel: 0)
				(button4 cel: 0)
				(= state 4)
				(= cycles 40)
			)
		)
	)
)

(procedure (ClearAmt &tmp [str 50])
	(Display
		(Format @str {%d} amt)
		p_width 100
		p_at 145 65
		p_color vBLACK
		p_font 600
	)
	(= amtLength 0)
	(= amt 0)
	(= [amt 0] 0)
	(= [amt 1] 0)
	(= [amt 2] 0)
	(= [amt 3] 0)
	(= [amt 4] 0)
	(Display
		(Format @str {%d} amt)
		p_width 100
		p_at 145 65
		p_color vGREEN
		p_font 600
	)
)

(procedure (CalAmount event &tmp [str 50])
	(Display
		(Format @str {%d} amt)
		p_width 100
		p_at 145 65
		p_color vBLACK
		p_font 600
	)
	(if (< amtLength 5)
		(= amt 0)
		(if
			(and
				(== amtLength 0)
				(== (ReturnNum event) 0)
			)
			;first num can't be 0
		else
			(= [amtTable amtLength] (ReturnNum event))
		)
		(cond
			((< amtLength 1)
				(= amt [amtTable 0])
			)
			((< amtLength 2)
				(= amt [amtTable 1])
				(= amt (+ amt (* [amtTable 0] 10)))
			)
			((< amtLength 3)
				(= amt [amtTable 2])
				(= amt (+ amt (* [amtTable 1] 10)))
				(= amt (+ amt (* [amtTable 0] 100)))
			)
			((< amtLength 4)
				(= amt [amtTable 3])
				(= amt (+ amt (* [amtTable 2] 10)))
				(= amt (+ amt (* [amtTable 1] 100)))
				(= amt (+ amt (* [amtTable 0] 1000)))
			)
			((< amtLength 5)
				(= amt [amtTable 4])
				(= amt (+ amt (* [amtTable 3] 10)))
				(= amt (+ amt (* [amtTable 2] 100)))
				(= amt (+ amt (* [amtTable 1] 1000)))
				(= amt (+ amt (* [amtTable 0] 10000)))
			)
		)
		(if
			(and
				(== amtLength 0)
				(== (ReturnNum event) 0)
			)
			;ignore leading zeros
		else
			(++ amtLength)
		)
	)
	(if
		(or
			(> amt 32000)
			(< amt 0)
		)
		(= amt 32000)
	)
	(Display
		(Format @str {%d} amt)
		p_width 100
		p_at 145 65
		p_color vGREEN
		p_font 600
	)
)

(procedure (ReturnNum eNum)
	(return
		(cond
			((== eNum KEY_0) 0)
			((== eNum KEY_1) 1)
			((== eNum KEY_2) 2)
			((== eNum KEY_3) 3)
			((== eNum KEY_4) 4)
			((== eNum KEY_5) 5)
			((== eNum KEY_6) 6)
			((== eNum KEY_7) 7)
			((== eNum KEY_8) 8)
			((== eNum KEY_9) 9)
			(else 86)
		)
	)
)

(procedure (Submit)
	(if (== comMode 3)
		(if (>= buckazoids amt)
			(= buckazoids (- buckazoids amt))
			(RoomScript changeState: 220)
		else
			(RoomScript changeState: 210)
		)
	)
	(if (== comMode 4)
		(if (>= hBal amt)
			(if
				(or
					(< (+ buckazoids amt) 0)
					(> (+ buckazoids amt) 3200)
				)
				(= buckazoids 3200)
			else
				(+= buckazoids amt)
			)
			(RoomScript changeState: 230)
		else
			(RoomScript changeState: 210)
		)
	)
)

(procedure (ClickedInRect button event)
	(if
		(and
			(> (event x?) (button nsLeft?)) ;left edge
			(< (event x?) (button nsRight?)) ;right edge
			(> (event y?) (button nsTop?)) ;top edge
			(< (event y?) (button nsBottom?)) ;bottom edge
		)
		
		(return TRUE)
	else
		(return FALSE)	
	)
)