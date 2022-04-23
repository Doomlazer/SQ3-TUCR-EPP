;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconI)
(use Tutorial)
(use SysWindow)
(use Obj)


(local
	local0
)
(procedure (localproc_0814 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp2
		(+
			(/ (- (param1 nsRight?) (param1 nsLeft?)) 2)
			(param1 nsLeft?)
		)
	)
	(= temp1 param2)
	(while (>= (Abs (- temp1 param3)) 4)
		(if
			(= temp0
				(self
					firstTrue: #onMe (((gUser curEvent?) new:) x: temp2 y: temp1 yourself:)
				)
			)
			(return)
		)
		(if (< param2 param3)
			(= temp1 (+ temp1 4))
		else
			(= temp1 (- temp1 4))
		)
	)
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 0
		modifiers $0000
		signal $0000
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		owner 0
		script 0
		value 0
	)
	
	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)
	
	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== highlightColor -1) (return))
		(= temp4
			(if (and argc param1) highlightColor else lowlightColor)
		)
		(= temp0 (- nsTop 2))
		(= temp1 (- nsLeft 2))
		(= temp2 (+ nsBottom 1))
		(= temp3 (+ nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph
			grUPDATE_BOX
			(- nsTop 2)
			(- nsLeft 2)
			(+ nsBottom 2)
			(+ nsRight 2)
			1
		)
	)
	
	(method (onMe param1)
		(return (if (super onMe: param1) (not (& signal $0004)) else 0))
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner theOwner)
		(if (and value (== theOwner gEgo))
			(gSQ5 changeScore: value)
			(= value 0)
		)
		(return self)
	)
	
	(method (doVerb theVerb &tmp gSQ5Script)
		(if (not modNum) (= modNum gModNum))
		(if
		(and global90 (Message msgGET modNum noun theVerb 0 1))
			(gTestMessager say: noun theVerb 0 0 0 modNum)
		)
		(if
			(and
				(= gSQ5Script (gSQ5 script?))
				(gSQ5Script isKindOf: Tutorial)
			)
			(cond 
				((!= (gSQ5Script nextItem?) self) (gSQ5Script report: self))
				((!= (gSQ5Script nextAction?) theVerb) (gSQ5Script report: theVerb))
				(else (gSQ5Script cue:))
			)
		)
	)
)

(class Inv of IconBar
	(properties
		elements 0
		size 0
		height 0
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		walkIconItem 0
		port 0
		window 0
		state $0400
		activateHeight 0
		y 0
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)
	
	(method (init)
		(= heading normalHeading)
	)
	
	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 temp8 temp9 [temp10 50] temp60)
		(asm
code_088d:
			pushi    #type
			pushi    0
			pushi    #new
			pushi    0
			pushi    #curEvent
			pushi    0
			lag      gUser
			send     4
			send     4
			sat      temp1
			send     4
			bnt      code_08a5
			jmp      code_088d
code_08a5:
			pTos     state
			ldi      32
			and     
			bnt      code_0d0f
			pushi    #new
			pushi    0
			pushi    #curEvent
			pushi    0
			lag      gUser
			send     4
			send     4
			sat      temp1
			pushi    #x
			pushi    0
			send     4
			sag      gPEventX
			pushi    #y
			pushi    0
			lat      temp1
			send     4
			sag      gPEventY
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			sat      temp2
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			sat      temp3
			pushi    #modifiers
			pushi    0
			lat      temp1
			send     4
			sat      temp4
			ldi      0
			sat      temp9
			pushi    #localize
			pushi    0
			lat      temp1
			send     4
			pToa     curIcon
			bnt      code_0956
			lat      temp4
			not     
			bnt      code_0956
			pTos     curIcon
			pToa     selectIcon
			ne?     
			bnt      code_0956
			lst      temp2
			ldi      1
			eq?     
			bt       code_092d
			lst      temp2
			ldi      4
			eq?     
			bnt      code_091f
			lst      temp3
			ldi      13
			eq?     
			bnt      code_091f
			ldi      1
			sat      temp9
			bt       code_092d
code_091f:
			lst      temp2
			ldi      256
			eq?     
			bnt      code_0956
			ldi      1
			sat      temp9
			bnt      code_0956
code_092d:
			pTos     curIcon
			pToa     helpIconItem
			ne?     
			bt       code_0941
			pushi    #signal
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			ldi      16
			and     
			bnt      code_0956
code_0941:
			pushi    #type
			pushi    1
			pushi    16384
			pushi    37
			pushi    1
			pushi    #message
			pushi    0
			pToa     curIcon
			send     4
			push    
			lat      temp1
			send     12
code_0956:
			pushi    1
			lst      temp1
			callk    MapKeyToDir,  2
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			sat      temp2
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			sat      temp3
			lag      gNewSet
			bnt      code_0979
			pushi    #eachElementDo
			pushi    1
			pushi    57
			send     6
code_0979:
			pushi    #script
			pushi    0
			lag      gSQ5
			send     4
			sat      temp60
			bnt      code_0998
			pushi    #isKindOf
			pushi    1
			class    Tutorial
			push    
			lat      temp60
			send     6
			bnt      code_0998
			pushi    #doit
			pushi    0
			lat      temp60
			send     4
code_0998:
			lag      gNewEventHandler
			bnt      code_09a7
			pushi    #handleEvent
			pushi    1
			lst      temp1
			send     6
			jmp      code_08a5
code_09a7:
			lst      temp2
			ldi      1
			eq?     
			bnt      code_09c3
			lat      temp4
			bnt      code_09c3
			pushi    #advanceCurIcon
			pushi    0
			self     4
			pushi    #claimed
			pushi    1
			pushi    1
			lat      temp1
			send     6
			jmp      code_08a5
code_09c3:
			lst      temp2
			ldi      0
			eq?     
			bnt      code_09e9
			pushi    #firstTrue
			pushi    2
			pushi    226
			lst      temp1
			self     8
			sat      temp0
			bnt      code_09e9
			push    
			pToa     highlightedIcon
			ne?     
			bnt      code_09e9
			pushi    #highlight
			pushi    1
			lst      temp0
			self     6
			jmp      code_08a5
code_09e9:
			lst      temp2
			ldi      1
			eq?     
			bt       code_0a07
			lst      temp2
			ldi      4
			eq?     
			bnt      code_09fe
			lst      temp3
			ldi      13
			eq?     
			bt       code_0a07
code_09fe:
			lst      temp2
			ldi      256
			eq?     
			bnt      code_0a94
code_0a07:
			pushi    1
			pTos     highlightedIcon
			callk    IsObject,  2
			bnt      code_08a5
			pushi    184
			pushi    #view
			pTos     highlightedIcon
			lst      temp2
			ldi      1
			eq?     
			push    
			self     8
			bnt      code_08a5
			pTos     highlightedIcon
			pToa     okButton
			eq?     
			bnt      code_0a2e
			jmp      code_0d0f
			jmp      code_08a5
code_0a2e:
			pTos     highlightedIcon
			pToa     helpIconItem
			eq?     
			bnt      code_0a7d
			pushi    #cursor
			pushi    0
			pToa     highlightedIcon
			send     4
			push    
			ldi      65535
			ne?     
			bnt      code_0a53
			pushi    #setCursor
			pushi    1
			pushi    #cursor
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			lag      gSQ5
			send     6
code_0a53:
			pTos     state
			ldi      2048
			and     
			bnt      code_0a64
			pushi    #noClickHelp
			pushi    0
			self     4
			jmp      code_08a5
code_0a64:
			pToa     helpIconItem
			bnt      code_08a5
			pushi    14
			pushi    #x
			pushi    #signal
			pushi    0
			send     4
			push    
			ldi      16
			or      
			push    
			pToa     helpIconItem
			send     6
			jmp      code_08a5
code_0a7d:
			pToa     highlightedIcon
			aTop     curIcon
			pushi    #setCursor
			pushi    1
			pushi    #cursor
			pushi    0
			pToa     curIcon
			send     4
			push    
			lag      gSQ5
			send     6
			jmp      code_08a5
code_0a94:
			lst      temp2
			ldi      64
			and     
			bnt      code_0b46
			lst      temp3
			dup     
			ldi      3
			eq?     
			bnt      code_0aad
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0b42
code_0aad:
			dup     
			ldi      7
			eq?     
			bnt      code_0abc
			pushi    #retreat
			pushi    0
			self     4
			jmp      code_0b42
code_0abc:
			dup     
			ldi      1
			eq?     
			bnt      code_0af2
			pToa     highlightedIcon
			bnt      code_0ae9
			pushi    3
			push    
			pushi    #nsTop
			pushi    0
			send     4
			push    
			ldi      1
			sub     
			push    
			pushi    0
			call     localproc_0814,  6
			sat      temp0
			bnt      code_0ae9
			pushi    #highlight
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0b42
code_0ae9:
			pushi    #retreat
			pushi    0
			self     4
			jmp      code_0b42
code_0af2:
			dup     
			ldi      5
			eq?     
			bnt      code_0b2f
			pToa     highlightedIcon
			bnt      code_0b27
			pushi    3
			push    
			pushi    #nsBottom
			pushi    0
			send     4
			push    
			ldi      1
			add     
			push    
			pushi    #bottom
			pushi    0
			pToa     window
			send     4
			push    
			call     localproc_0814,  6
			sat      temp0
			bnt      code_0b27
			pushi    #highlight
			pushi    2
			lst      temp0
			pushi    1
			self     8
			jmp      code_0b42
code_0b27:
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0b42
code_0b2f:
			dup     
			ldi      0
			eq?     
			bnt      code_0b42
			lst      temp2
			ldi      4
			and     
			bnt      code_0b42
			pushi    #advanceCurIcon
			pushi    0
			self     4
code_0b42:
			toss    
			jmp      code_08a5
code_0b46:
			lst      temp2
			ldi      4
			eq?     
			bnt      code_0b7a
			lst      temp3
			dup     
			ldi      9
			eq?     
			bnt      code_0b5e
			pushi    #advance
			pushi    0
			self     4
			jmp      code_0b76
code_0b5e:
			dup     
			ldi      3840
			eq?     
			bnt      code_0b6d
			pushi    #retreat
			pushi    0
			self     4
			jmp      code_0b76
code_0b6d:
			dup     
			ldi      27
			eq?     
			bnt      code_0b76
			jmp      code_0d0f
code_0b76:
			toss    
			jmp      code_08a5
code_0b7a:
			lst      temp2
			ldi      16384
			and     
			bnt      code_08a5
			pushi    #firstTrue
			pushi    2
			pushi    226
			lst      temp1
			self     8
			sat      temp0
			bnt      code_08a5
			lst      temp2
			ldi      8192
			and     
			bnt      code_0c36
			lat      temp0
			bnt      code_0c15
			pushi    #noun
			pushi    0
			send     4
			bnt      code_0c15
			pushi    7
			pushi    0
			pushi    #modNum
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    #noun
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    #helpVerb
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    0
			pushi    1
			lea      @temp10
			push    
			callk    Message,  14
			bnt      code_0c15
			pushi    #respondsTo
			pushi    1
			pushi    244
			lag      gSq5Win
			send     6
			bnt      code_0c0a
			pushi    #eraseOnly
			pushi    0
			lag      gSq5Win
			send     4
			sat      temp7
			pushi    #eraseOnly
			pushi    1
			pushi    1
			lag      gSq5Win
			send     6
			pushi    1
			lea      @temp10
			push    
			calle    proc921_0,  2
			pushi    #eraseOnly
			pushi    1
			lst      temp7
			lag      gSq5Win
			send     6
			jmp      code_0c15
code_0c0a:
			pushi    1
			lea      @temp10
			push    
			calle    proc921_0,  2
code_0c15:
			pushi    14
			pushi    #x
			pushi    #signal
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			ldi      65519
			and     
			push    
			pToa     helpIconItem
			send     6
			pushi    #setCursor
			pushi    1
			pushi    999
			lag      gSQ5
			send     6
			jmp      code_08a5
code_0c36:
			lst      temp0
			pToa     okButton
			eq?     
			bnt      code_0c43
			jmp      code_0d0f
			jmp      code_08a5
code_0c43:
			pushi    #isKindOf
			pushi    1
			class    InvI
			push    
			lat      temp0
			send     6
			not     
			bnt      code_0ca3
			pushi    #select
			pushi    2
			lst      temp0
			lat      temp9
			not     
			push    
			self     8
			bnt      code_08a5
			lat      temp0
			aTop     curIcon
			pushi    #setCursor
			pushi    1
			pushi    #cursor
			pushi    0
			pToa     curIcon
			send     4
			push    
			lag      gSQ5
			send     6
			lst      temp0
			pToa     helpIconItem
			eq?     
			bnt      code_08a5
			pTos     state
			ldi      2048
			and     
			bnt      code_0c8d
			pushi    #noClickHelp
			pushi    0
			self     4
			jmp      code_08a5
code_0c8d:
			pushi    14
			pushi    #x
			pushi    #signal
			pushi    0
			pToa     helpIconItem
			send     4
			push    
			ldi      16
			or      
			push    
			pToa     helpIconItem
			send     6
			jmp      code_08a5
code_0ca3:
			pToa     curIcon
			bnt      code_08a5
			pushi    #respondsTo
			pushi    1
			pushi    244
			lag      gSq5Win
			send     6
			bnt      code_0cc7
			pushi    #eraseOnly
			pushi    0
			lag      gSq5Win
			send     4
			sat      temp7
			pushi    #eraseOnly
			pushi    1
			pushi    1
			lag      gSq5Win
			send     6
code_0cc7:
			pushi    #isKindOf
			pushi    1
			class    InvI
			push    
			pToa     curIcon
			send     6
			bnt      code_0ce5
			pushi    #doVerb
			pushi    1
			pushi    #message
			pushi    0
			pToa     curIcon
			send     4
			push    
			lat      temp0
			send     6
			jmp      code_0cf5
code_0ce5:
			pushi    #doVerb
			pushi    1
			pushi    #message
			pushi    0
			lat      temp1
			send     4
			push    
			lat      temp0
			send     6
code_0cf5:
			pushi    #respondsTo
			pushi    1
			pushi    244
			lag      gSq5Win
			send     6
			bnt      code_08a5
			pushi    #eraseOnly
			pushi    1
			lst      temp7
			lag      gSq5Win
			send     6
			jmp      code_08a5
code_0d0f:
			pushi    #hide
			pushi    0
			self     4
			ret     
		)
	)
	
	(method (showSelf param1)
		(gSounds pause:)
		(if
		(and gPseudoMouse (gPseudoMouse respondsTo: #stop))
			(gPseudoMouse stop:)
		)
		(if (gSq5IconBar height?) (gSq5IconBar hide:))
		(if (not window) (= window (SysWindow new:)))
		(if (window window?) (window dispose:) (= window 0))
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(if (self show: (if argc param1 else gEgo))
			(self doit:)
		)
	)
	
	(method (show param1 &tmp temp0 temp1)
		(gSQ5
			setCursor: (if curIcon (curIcon cursor?) else (selectIcon cursor?))
		)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(= state (| state $0020))
		(if
			(not
				(= temp1
					(self
						drawInvWindow: (if argc param1 else gEgo) (gSq5IconBar curIcon?)
					)
				)
			)
			(= state (& state $ffdf))
		)
		(PicNotValid temp0)
		(return temp1)
	)
	
	(method (hide &tmp temp0)
		(if (& state $0020)
			(gSounds pause: 0)
			(= state (& state $ffdf))
		)
		(if window (window dispose:))
		(if
		(and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gSq5IconBar curInvIcon?))
				(gSq5IconBar enable: (gSq5IconBar useIconItem?))
			)
			(gSq5IconBar
				curIcon:
					((gSq5IconBar useIconItem?)
						cursor: (curIcon cursor?)
						yourself:
					)
				curInvIcon: curIcon
			)
			(if (= temp0 ((gSq5IconBar curIcon?) cursor?))
				(gSQ5 setCursor: temp0)
			)
		)
	)
	
	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(+ temp1 (= temp2 (self indexOf: highlightedIcon)))
		)
		(repeat
			(= temp0
				(self
					at: (if (<= temp3 size) temp3 else (mod temp3 (- size 1)))
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(++ temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(- (= temp2 (self indexOf: highlightedIcon)) temp1)
		)
		(repeat
			(= temp0 (self at: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (not (& (temp0 signal?) $0004)) (break))
			(-- temp3)
		)
		(self highlight: temp0 1)
	)
	
	(method (ownedBy param1)
		(self firstTrue: #ownedBy param1)
	)
	
	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 invFirst temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 invWindow [temp22 50])
		(= temp0
			(= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))
		)
		(= invFirst (self first:))
		(while invFirst
			(if
			((= temp9 (NodeValue invFirst)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal?) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal?) $0004))
				)
			else
				(++ temp3)
				(= temp5
					(+
						temp5
						(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
					)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
			(= invFirst (self next: invFirst))
		)
		(if (not temp0)
			(Print addTextF: {%s %s} normalHeading empty init:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3) (= temp16 3))
		(if
		(< (* temp16 (= local0 (/ temp0 temp16))) temp0)
			(++ local0)
		)
		(= temp10
			(proc999_3 (+ 4 temp5) (* local0 (+ 4 temp2)))
		)
		(= temp12
			(/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2)
		)
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= invWindow (self window?))
			(invWindow
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open:
			)
		)
		(= temp20 local0)
		(if temp0
			(= temp18
				(+
					2
					(if (invWindow respondsTo: #yOffset)
						(invWindow yOffset?)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (invWindow respondsTo: #xOffset)
							(invWindow xOffset?)
						else
							0
						)
					)
				)
			)
			(= invFirst (self first:))
			(while invFirst
				(if
					(and
						(not
							(& ((= temp9 (NodeValue invFirst)) signal?) $0004)
						)
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal?) $0080))
						(temp9
							nsLeft:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft?) temp6)
							nsBottom: (+ (temp9 nsTop?) temp7)
						)
						(if (-- temp20)
							(= temp17 (+ temp17 temp2))
						else
							(= temp20 local0)
							(= temp18 (+ temp18 temp1))
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft?))
						(= temp18 (temp9 nsTop?))
					)
					(temp9 show:)
					(if (== temp9 param2) (temp9 highlight:))
				)
				(= invFirst (self next: invFirst))
			)
		)
		(= temp17
			(/
				(- (- (invWindow right?) (invWindow left?)) temp5)
				2
			)
		)
		(= temp11 (- (invWindow bottom?) (invWindow top?)))
		(= temp18 32767)
		(= invFirst (self first:))
		(while invFirst
			(if
			(not ((= temp9 (NodeValue invFirst)) isKindOf: InvI))
				(temp9 nsTop: 0)
				(= temp6
					(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(= temp7
					(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
				)
				(if (not (& (temp9 signal?) $0080))
					(if (== temp18 32767) (= temp18 (- temp11 temp7)))
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft?) temp6))
				(= temp18 (temp9 nsTop?))
				(temp9 signal: (& (temp9 signal?) $fffb) show:)
			)
			(= invFirst (self next: invFirst))
		)
		(return 1)
	)
)
