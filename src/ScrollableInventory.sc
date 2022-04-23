;;; Sierra Script 1.0 - (do not remove this comment)
(script# 26)
(include sci.sh)
(use Main)
(use Print)
(use InvI)
(use Obj)


(class ScrollableInventory of Inv
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
		normalHeading -1
		heading 0
		empty -1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
		curPos 0
		dispAmount 12
		items 0
		numCols 6
		numRows 2
		scrollAmount 6
		firstThru 1
		upIcon 0
		downIcon 0
	)
	
	(method (dispose)
		(if (IsObject items) (items dispose:) (= items 0))
		(super dispose: &rest)
	)
	
	(method (hide)
		(if (IsObject items) (items dispose:) (= items 0))
		(= firstThru 1)
		(super hide: &rest)
	)
	
	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3
			(mod
				(+ temp1 (= temp2 (self indexOf: highlightedIcon)))
				size
			)
		)
		(repeat
			(= temp0 (self at: temp3))
			(if
				(and
					(IsObject temp0)
					(not (& (temp0 signal?) $0004))
					(or
						(> (temp0 nsLeft?) -1)
						(not (temp0 isKindOf: InvI))
					)
				)
				(break)
			)
			(= temp3 (mod (+ temp3 1) size))
		)
		(self highlight: temp0 1)
	)
	
	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(asm
			lap      argc
			bnt      code_00f4
			lap      param1
			jmp      code_00f6
code_00f4:
			ldi      1
code_00f6:
			sat      temp1
			pushi    #indexOf
			pushi    1
			pTos     highlightedIcon
			self     6
			sat      temp2
			push    
			lat      temp1
			sub     
			sat      temp3
			push    
			ldi      0
			lt?     
			bnt      code_0115
			pTos     size
			ldi      1
			sub     
			sat      temp3
code_0115:
			pushi    #at
			pushi    1
			lst      temp3
			self     6
			sat      temp0
			pushi    1
			push    
			callk    IsObject,  2
			bnt      code_0151
			pushi    #signal
			pushi    0
			lat      temp0
			send     4
			push    
			ldi      4
			and     
			not     
			bnt      code_0151
			pushi    #nsLeft
			pushi    0
			lat      temp0
			send     4
			push    
			ldi      65535
			gt?     
			bt       code_014d
			pushi    #isKindOf
			pushi    1
			class    InvI
			push    
			lat      temp0
			send     6
			not     
			bnt      code_0151
code_014d:
			jmp      code_0162
			jmp      code_0115
code_0151:
			-at      temp3
			push    
			ldi      0
			lt?     
			bnt      code_0115
			pTos     size
			ldi      1
			sub     
			sat      temp3
			jmp      code_0115
code_0162:
			pushi    #highlight
			pushi    2
			lst      temp0
			pushi    1
			self     8
			ret     
		)
	)
	
	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 scrollableInventoryFirst temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 theNumCols theCurPos scrollableInventoryWindow)
		(= theCurPos
			(= temp0
				(= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0)))))
			)
		)
		(if firstThru
			(if (IsObject items) (items dispose:) (= items 0))
			(= items (Set new:))
		)
		(= scrollableInventoryFirst (self first:))
		(while scrollableInventoryFirst
			(if
				((= temp9 (NodeValue scrollableInventoryFirst))
					isKindOf: InvI
				)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal?) $fffb))
					(items add: temp9)
					(temp9 nsLeft: -5 nsRight: -5 nsTop: -5 nsBottom: -5)
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
			(= scrollableInventoryFirst
				(self next: scrollableInventoryFirst)
			)
		)
		(if (not (items size?))
			(if (and (<= 0 normalHeading) (<= 0 empty))
				(Print addText: empty 0 0 0 0 0 normalHeading init:)
			else
				(proc921_0 {You'll get nothing and like it!})
			)
			(if (IsObject items) (items dispose:))
			(return 0)
		)
		(= temp0
			(if (< (items size?) dispAmount)
				(items size?)
			else
				dispAmount
			)
		)
		(= temp10
			(proc999_3 (+ 4 temp5) (* numCols (+ 4 temp2)))
		)
		(= temp12
			(/ (- 190 (= temp11 (* numRows (+ 4 temp1)))) 2)
		)
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= scrollableInventoryWindow (self window?))
			(scrollableInventoryWindow
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open: (not firstThru)
			)
		)
		(= theNumCols numCols)
		(if temp0
			(= temp17
				(+
					2
					(if (scrollableInventoryWindow respondsTo: #yOffset)
						(scrollableInventoryWindow yOffset?)
					else
						0
					)
				)
			)
			(= temp18
				(= temp16
					(+
						4
						(if (scrollableInventoryWindow respondsTo: #xOffset)
							(scrollableInventoryWindow xOffset?)
						else
							0
						)
					)
				)
			)
			(= theCurPos curPos)
			(while
				(and
					(< theCurPos (+ curPos dispAmount))
					(< theCurPos (items size?))
				)
				(if
					(not
						(& ((= temp9 (items at: theCurPos)) signal?) $0080)
					)
					(temp9
						nsLeft:
							(+
								temp16
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
								temp17
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
					(if (-- theNumCols)
						(= temp16 (+ temp16 temp2))
					else
						(= theNumCols numCols)
						(= temp17 (+ temp17 temp1))
						(= temp16 temp18)
					)
				else
					(= temp16 (temp9 nsLeft?))
					(= temp17 (temp9 nsTop?))
				)
				(temp9 show:)
				(if (== temp9 param2) (temp9 highlight:))
				(++ theCurPos)
			)
		)
		(= temp16
			(/
				(-
					(-
						(scrollableInventoryWindow right?)
						(scrollableInventoryWindow left?)
					)
					temp5
				)
				2
			)
		)
		(= temp11
			(-
				(scrollableInventoryWindow bottom?)
				(scrollableInventoryWindow top?)
			)
		)
		(= temp17 32767)
		(if firstThru
			(= scrollableInventoryFirst (self first:))
			(while scrollableInventoryFirst
				(if
					(not
						((= temp9 (NodeValue scrollableInventoryFirst))
							isKindOf: InvI
						)
					)
					(= temp6
						(CelWide (temp9 view?) (temp9 loop?) (temp9 cel?))
					)
					(= temp7
						(CelHigh (temp9 view?) (temp9 loop?) (temp9 cel?))
					)
					(if (not (& (temp9 signal?) $0080))
						(if (== temp17 32767) (= temp17 (- temp11 temp7)))
						(temp9
							nsLeft: temp16
							nsTop: temp17
							nsBottom: (+ temp17 temp7)
							nsRight: (+ temp16 temp6)
						)
					)
					(= temp16 (+ (temp9 nsLeft?) temp6))
					(= temp17 (temp9 nsTop?))
					(temp9 signal: (& (temp9 signal?) $fffb))
					(temp9 show:)
				)
				(= scrollableInventoryFirst
					(self next: scrollableInventoryFirst)
				)
			)
		)
		(if (not curPos)
			(upIcon signal: (| (upIcon signal?) $0004))
		else
			(upIcon signal: (& (upIcon signal?) $fffb))
		)
		(if (>= curPos (- (items size?) dispAmount))
			(downIcon signal: (| (downIcon signal?) $0004))
		else
			(downIcon signal: (& (downIcon signal?) $fffb))
		)
		(upIcon show:)
		(downIcon show:)
		(return 1)
	)
	
	(method (scroll param1)
		(cond 
			((and argc (> 0 param1))
				(if (< (= curPos (- curPos scrollAmount)) 0)
					(= curPos 0)
				)
			)
			(
				(>
					(= curPos (+ curPos scrollAmount))
					(- size dispAmount)
				)
				(= curPos (- size dispAmount))
			)
		)
		(= firstThru 0)
		(selectIcon select:)
		(self show: gEgo)
	)
)
