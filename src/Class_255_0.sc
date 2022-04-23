;;; Sierra Script 1.0 - (do not remove this comment)
(script# 255)
(include sci.sh)
(use Main)
(use Print)
(use Obj)

(public
	proc255_0 0
	proc255_1 1
	proc255_2 2
)

(procedure (proc255_0 &tmp newEvent temp1)
	(= temp1 (!= ((= newEvent (Event new:)) type?) 2))
	(newEvent dispose:)
	(return temp1)
)

(procedure (proc255_1 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1) (Format @temp0 {%d} param2))
	(return
		(if (proc921_2 @temp0 5 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (proc255_2 param1 param2)
	(return
		(if
			(and
				(< (param1 nsLeft?) (param2 x?))
				(< (param2 x?) (param1 nsRight?))
				(< (param1 nsTop?) (param2 y?))
			)
			(< (param2 y?) (param1 nsBottom?))
		else
			0
		)
	)
)

(class Class_255_0 of Obj
	(properties
		type $0000
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)
	
	(method (doit)
		(return value)
	)
	
	(method (enable param1)
		(if param1
			(= state (| state $0001))
		else
			(= state (& state $fffe))
		)
	)
	
	(method (select param1)
		(if param1
			(= state (| state $0008))
		else
			(= state (& state $fff7))
		)
		(self draw:)
	)
	
	(method (handleEvent pEvent &tmp temp0 pEventType temp2)
		(if (pEvent claimed?) (return 0))
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= pEventType (pEvent type?)) 4)
						(== (pEvent message?) key)
					)
					(and (== pEventType evMOUSEBUTTON) (self check: pEvent))
				)
			)
			(pEvent claimed: 1)
			(= temp0 (self track: pEvent))
		)
		(return temp0)
	)
	
	(method (check param1)
		(return
			(if
				(and
					(>= (param1 x?) nsLeft)
					(>= (param1 y?) nsTop)
					(< (param1 x?) nsRight)
				)
				(< (param1 y?) nsBottom)
			else
				0
			)
		)
	)
	
	(method (track param1 &tmp temp0 temp1)
		(return
			(if (== 1 (param1 type?))
				(= temp1 0)
				(repeat
					((= param1 (Event new: -32768)) localize:)
					(if (!= (= temp0 (self check: param1)) temp1)
						(HiliteControl self)
						(= temp1 temp0)
					)
					(param1 dispose:)
					(breakif (not (proc255_0)))
				)
				(if temp0 (HiliteControl self))
				(return temp0)
			else
				(return self)
			)
		)
	)
	
	(method (setSize)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (draw)
		(DrawControl self)
	)
	
	(method (isType param1)
		(return (== type param1))
	)
	
	(method (checkState param1)
		(return (& state param1))
	)
	
	(method (cycle)
	)
)

(class DText of Class_255_0
	(properties
		type $0002
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 1
		mode 0
		rects 0
	)
	
	(method (new &tmp temp0)
		((super new:) font: gFont yourself:)
	)
	
	(method (dispose param1)
		(if (and text (or (not argc) (not param1)))
			(Memory memFREE (self text?))
		)
		(if rects (Memory memFREE (self rects?)))
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1 temp2 temp3 temp4)
		(asm
			lag      global17
			bnt      code_0455
			pToa     rects
			bnt      code_0455
			pushi    3
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    1
			pushi    256
			calle    proc999_5,  6
			bt       code_03b6
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      4
			eq?     
			bnt      code_0455
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      13
			eq?     
			bnt      code_0455
code_03b6:
			ldi      65535
			sat      temp0
			pushi    #globalize
			pushi    0
			pushi    73
			pushi    1
			pushi    1
			lap      pEvent
			send     10
code_03c6:
			pushi    2
			pTos     rects
			lst      temp0
			ldi      1
			add     
			push    
			calle    proc999_6,  4
			push    
			ldi      30583
			ne?     
			bnt      code_0455
			pushi    2
			pTos     rects
			+at      temp0
			push    
			calle    proc999_6,  4
			sat      temp2
			pushi    2
			pTos     rects
			+at      temp0
			push    
			calle    proc999_6,  4
			sat      temp1
			pushi    2
			pTos     rects
			+at      temp0
			push    
			calle    proc999_6,  4
			sat      temp4
			pushi    2
			pTos     rects
			+at      temp0
			push    
			calle    proc999_6,  4
			sat      temp3
			lst      temp2
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			le?     
			bnt      code_03c6
			pprev   
			lat      temp4
			le?     
			bnt      code_03c6
			lst      temp1
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			le?     
			bnt      code_03c6
			pprev   
			lat      temp3
			le?     
			bnt      code_03c6
			pushi    57
			pushi    #x
			lst      temp0
			ldi      4
			div     
			push    
			lag      global17
			send     6
			pushi    #type
			pushi    1
			pushi    0
			pushi    73
			pushi    1
			pushi    0
			lap      pEvent
			send     12
			jmp      code_0455
			jmp      code_03c6
code_0455:
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			super    Class_255_0,  6
			ret     
		)
	)
	
	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft [temp0 3]))
	)
	
	(method (draw)
		(= rects (DrawControl self))
	)
)

(class Dialog of List
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gLastTicks (+ global86 (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem (theItem select: 0))
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem (theItem select: 1))
		(if (not theItem)
			(= eatTheMice gEatTheMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(= gLastTicks (+ global86 (GetTime)))
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type?) 1) (temp0 type: 0))
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(self eachElementDo: #perform checkHiliteCode self temp0)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:) (break))
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)
	
	(method (dispose &tmp theCaller)
		(self eachElementDo: #dispose release:)
		(if (== self gDialog)
			(SetPort global41)
			(= gDialog 0)
			(= global41 0)
		)
		(if window (window dispose:) (= window 0))
		(= theItem 0)
		(= theCaller caller)
		(super dispose:)
		(if theCaller (theCaller cue:))
	)
	
	(method (open param1 param2)
		(if (and (PicNotValid) gOldCast)
			(Animate (gOldCast elements?) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open:
		)
		(= seconds time)
		(self draw:)
	)
	
	(method (draw)
		(self eachElementDo: #draw)
	)
	
	(method (advance &tmp temp0 dialogFirst)
		(if theItem
			(theItem select: 0)
			(= dialogFirst (self contains: theItem))
			(repeat
				(if (not (= dialogFirst (self next: dialogFirst)))
					(= dialogFirst (self first:))
				)
				(= theItem (NodeValue dialogFirst))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
			(gSQ5
				setCursor:
					gCursorNumber
					1
					(+
						(theItem nsLeft?)
						(/ (- (theItem nsRight?) (theItem nsLeft?)) 2)
					)
					(- (theItem nsBottom?) 3)
			)
		)
	)
	
	(method (retreat &tmp temp0 dialogLast)
		(if theItem
			(theItem select: 0)
			(= dialogLast (self contains: theItem))
			(repeat
				(if (not (= dialogLast (self prev: dialogLast)))
					(= dialogLast (self last:))
				)
				(= theItem (NodeValue dialogLast))
				(if (& (theItem state?) $0001) (break))
			)
			(theItem select: 1)
			(gSQ5
				setCursor:
					gCursorNumber
					1
					(+
						(theItem nsLeft?)
						(/ (- (theItem nsRight?) (theItem nsLeft?)) 2)
					)
					(- (theItem nsBottom?) 3)
			)
		)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (center)
		(self
			moveTo:
				(+
					(window brLeft?)
					(/
						(-
							(- (window brRight?) (window brLeft?))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop?)
					(/
						(-
							(- (window brBottom?) (window brTop?))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)
	
	(method (setSize &tmp dialogFirst temp1 [theNsTop 4])
		(if text
			(TextSize @[theNsTop 0] text font -1 0)
			(= nsTop [theNsTop 0])
			(= nsLeft [theNsTop 1])
			(= nsBottom [theNsTop 2])
			(= nsRight [theNsTop 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(= dialogFirst (self first:))
		(while dialogFirst
			(if
			(< ((= temp1 (NodeValue dialogFirst)) nsLeft?) nsLeft)
				(= nsLeft (temp1 nsLeft?))
			)
			(if (< (temp1 nsTop?) nsTop) (= nsTop (temp1 nsTop?)))
			(if (> (temp1 nsRight?) nsRight)
				(= nsRight (temp1 nsRight?))
			)
			(if (> (temp1 nsBottom?) nsBottom)
				(= nsBottom (temp1 nsBottom?))
			)
			(= dialogFirst (self next: dialogFirst))
		)
		(= nsRight (+ nsRight 4))
		(= nsBottom (+ nsBottom 4))
		(self moveTo: 0 0)
	)
	
	(method (handleEvent pEvent &tmp theTheItem pEventType pEventMessage)
		(if (& (pEvent type?) evJOYSTICK)
			(switch (pEvent message?)
				(JOY_DOWN
					(pEvent type: 4 message: 20480)
				)
				(JOY_UP
					(pEvent type: 4 message: 18432)
				)
				(JOY_LEFT
					(pEvent type: 4 message: 19200)
				)
				(JOY_RIGHT
					(pEvent type: 4 message: 19712)
				)
			)
		)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(if
		(= theTheItem (self firstTrue: #handleEvent pEvent))
			(EditControl theItem 0)
			(if (not (theTheItem checkState: 2))
				(if theItem (theItem select: 0))
				((= theItem theTheItem) select: 1)
				(theTheItem doit:)
				(= theTheItem 0)
			else
				(return theTheItem)
			)
		else
			(= pEventType (pEvent type?))
			(= pEventMessage (pEvent message?))
			(= theTheItem 0)
			(cond 
				(
					(and
						(or
							(== pEventType evJOYDOWN)
							(and
								(== pEventType evKEYBOARD)
								(== pEventMessage KEY_RETURN)
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= theTheItem theItem)
					(EditControl theItem 0)
					(pEvent claimed: 1)
				)
				(
					(and
						(== pEventType evKEYBOARD)
						(== pEventMessage KEY_ESCAPE)
					)
					(pEvent claimed: 1)
					(= theTheItem -1)
				)
				(
					(and
						(not (self firstTrue: #checkState 1))
						(or
							(and
								(== pEventType evKEYBOARD)
								(== pEventMessage KEY_RETURN)
							)
							(proc999_5 pEventType 1 256)
						)
					)
					(pEvent claimed: 1)
					(= theTheItem -2)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== pEventType evKEYBOARD)
						(== pEventMessage KEY_RIGHT)
					)
					(if
					(>= (theItem cursor?) (StrLen (theItem text?)))
						(self advance:)
					else
						(EditControl theItem pEvent)
					)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== pEventType evKEYBOARD)
						(== pEventMessage KEY_NUMPAD4)
					)
					(if (<= (theItem cursor?) 0)
						(self retreat:)
					else
						(EditControl theItem pEvent)
					)
				)
				(
					(and
						(== pEventType evKEYBOARD)
						(proc999_5 pEventMessage 9 19712 20480)
					)
					(pEvent claimed: 1)
					(self advance:)
				)
				(
					(and
						(== pEventType evKEYBOARD)
						(proc999_5 pEventMessage 3840 19200 18432)
					)
					(pEvent claimed: 1)
					(self retreat:)
				)
				(else (EditControl theItem pEvent))
			)
		)
		(return theTheItem)
	)
	
	(method (check &tmp theLastSeconds)
		(return
			(if
				(and
					seconds
					(!= lastSeconds (= theLastSeconds (GetTime 1)))
				)
				(= lastSeconds theLastSeconds)
				(return (not (-- seconds)))
			else
				0
			)
		)
	)
)

(instance checkHiliteCode of Code
	(properties)
	
	(method (doit param1 param2 param3)
		(if
			(and
				(& (param1 state?) $0001)
				(param1 check: param3)
				(not (& (param1 state?) $0008))
			)
			((param2 theItem?) select: 0)
			(param2 theItem: param1)
			(param1 select: 1)
		)
	)
)
