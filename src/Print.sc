;;; Sierra Script 1.0 - (do not remove this comment)
(script# 921)
(include sci.sh)
(use Main)
(use DColorButton)
(use Class_255_0)
(use DIcon)
(use Obj)

(public
	proc921_0 0
	proc921_1 1
	proc921_2 2
	proc921_3 3
)

(procedure (proc921_0)
	(Print addText: &rest init:)
)

(procedure (proc921_1)
	(Print addTextF: &rest init:)
)

(procedure (proc921_2 param1 param2 param3 param4)
	(if
		(Print
			font: (if (> argc 3) param4 else gFont)
			addText: (if (and (> argc 2) param3) param3 else {})
			addEdit: param1 param2 0 12 param1
			init:
		)
		(StrLen param1)
	)
)

(procedure (proc921_3 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (= temp1 (StrLen param1)))
	(= temp2 0)
	(= temp3 0)
	(while (< temp3 temp1)
		(if (== (StrAt param1 temp3) 37)
			(switch (StrAt param1 (++ temp3))
				(100 (= temp0 (+ temp0 5)))
				(120 (= temp0 (+ temp0 4)))
				(115
					(= temp0 (+ temp0 (StrLen [param2 temp2])))
				)
			)
			(++ temp2)
		)
		(++ temp3)
	)
	(return (++ temp0))
)

(class Print of Obj
	(properties
		dialog 0
		window 0
		title 0
		mode 0
		font -1
		width 0
		x -1
		y -1
		ticks 0
		caller 0
		retValue 0
		modeless 0
		first 0
		saveCursor 0
	)
	
	(method (init theCaller)
		(= caller 0)
		(if argc (= caller theCaller))
		(if (> argc 1) (self addText: &rest))
		(if (not modeless)
			(if (not (IsObject global92))
				(= global92 ((EventHandler new:) name: {prints}))
			)
			(global92 add: self)
		)
		(self showSelf:)
	)
	
	(method (doit)
		(dialog eachElementDo: #doit)
	)
	
	(method (dispose)
		(if (and global92 (global92 contains: self))
			(global92 delete: self)
			(if (global92 isEmpty:)
				(global92 dispose:)
				(= global92 0)
			)
		)
		(if title (Memory memFREE title))
		(= width
			(= mode
				(= title (= first (= saveCursor (= window 0))))
			)
		)
		(= x (= y -1))
		(= modeless 0)
		(gSounds pause: 0)
		(super dispose:)
	)
	
	(method (showSelf &tmp theFirst temp1 temp2 temp3 temp4)
		(if saveCursor (gSQ5 setCursor: 999))
		(if (not dialog) (= dialog (Dialog new:)))
		(dialog
			window: (if window else gSq5Win)
			name: {PODialog}
			caller: self
		)
		(dialog text: title time: ticks setSize:)
		(dialog center:)
		(= temp3 (if (== x -1) (dialog nsLeft?) else x))
		(= temp4 (if (== y -1) (dialog nsTop?) else y))
		(dialog moveTo: temp3 temp4)
		(= temp1 (GetPort))
		(dialog open: (if title 4 else 0) 15)
		(return
			(if modeless
				(= global41 (GetPort))
				(SetPort temp1)
				(= gDialog dialog)
			else
				(gSounds pause: 1)
				(cond 
					((not (= theFirst first))
						(if
							(and
								(= theFirst (dialog firstTrue: #checkState 1))
								(not (dialog firstTrue: #checkState 2))
							)
							(theFirst state: (| (theFirst state?) $0002))
						)
					)
					((not (IsObject theFirst)) (= theFirst (dialog at: theFirst)))
				)
				(= retValue (dialog doit: theFirst))
				(SetPort temp1)
				(cond 
					((== retValue -1) (= retValue 0))
					(
					(and (IsObject retValue) (retValue isKindOf: DButton)) (= retValue (retValue value?)))
					((not (dialog theItem?)) (= retValue 1))
				)
				(if saveCursor
					(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
				)
				(dialog dispose:)
				(return retValue)
			)
		)
	)
	
	(method (addButton param1 theTheGModNum &tmp theTheTheGModNum theTheTheGModNum_2 theTheTheGModNum_3 temp3 theTheTheGModNum_4 theTheTheGModNum_5 theGModNum temp7 temp8)
		(if (not dialog) (= dialog (Dialog new:)))
		(if (== font -1) (= font gFont))
		(if (> argc 4)
			(= theTheTheGModNum [theTheGModNum 0])
			(= theTheTheGModNum_2 [theTheGModNum 1])
			(= theTheTheGModNum_3 [theTheGModNum 2])
			(= temp3 (if [theTheGModNum 3] [theTheGModNum 3] else 1))
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(= theGModNum gModNum)
			(if (> argc 5)
				(= theTheTheGModNum_4 [theTheGModNum 4])
				(if (> argc 6)
					(= theTheTheGModNum_5 [theTheGModNum 5])
					(if (> argc 7) (= theGModNum [theTheGModNum 6]))
				)
			)
			(if
				(= temp8
					(Message
						msgSIZE
						theGModNum
						theTheTheGModNum
						theTheTheGModNum_2
						theTheTheGModNum_3
						temp3
					)
				)
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if
					(not
						(Message
							msgGET
							theGModNum
							theTheTheGModNum
							theTheTheGModNum_2
							theTheTheGModNum_3
							temp3
							temp7
						)
					)
					(= temp7 0)
				)
			)
		else
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(if (> argc 2)
				(= theTheTheGModNum_4 [theTheGModNum 1])
				(if (> argc 3) (= theTheTheGModNum_5 [theTheGModNum 2]))
			)
			(= temp7
				(Memory memALLOC_CRIT (+ (StrLen [theTheGModNum 0]) 1))
			)
			(StrCpy temp7 [theTheGModNum 0])
		)
		(if temp7
			(dialog
				add:
					((DButton new:)
						value: param1
						font: font
						text: temp7
						setSize:
						moveTo: (+ 4 theTheTheGModNum_4) (+ 4 theTheTheGModNum_5)
						yourself:
					)
				setSize:
			)
		)
	)
	
	(method (addColorButton param1 theTheGModNum &tmp theTheTheGModNum theTheTheGModNum_2 theTheTheGModNum_3 temp3 theTheTheGModNum_4 theTheTheGModNum_5 theGModNum temp7 temp8 theTheTheGModNum_6 theTheTheGModNum_9 theTheTheGModNum_7 theTheTheGModNum_10 theTheTheGModNum_8 theTheTheGModNum_11)
		(if (not dialog) (= dialog (Dialog new:)))
		(if (== font -1) (= font gFont))
		(= theTheTheGModNum_6 0)
		(= theTheTheGModNum_7 15)
		(= theTheTheGModNum_8 31)
		(= theTheTheGModNum_9 5)
		(= theTheTheGModNum_10 5)
		(= theTheTheGModNum_11 5)
		(if (< (Abs [theTheGModNum 0]) 1000)
			(= theTheTheGModNum [theTheGModNum 0])
			(= theTheTheGModNum_2 [theTheGModNum 1])
			(= theTheTheGModNum_3 [theTheGModNum 2])
			(= temp3 (if [theTheGModNum 3] [theTheGModNum 3] else 1))
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(= theGModNum gModNum)
			(if (> argc 5)
				(= theTheTheGModNum_4 [theTheGModNum 4])
				(if (> argc 6)
					(= theTheTheGModNum_5 [theTheGModNum 5])
					(if (> argc 7)
						(= theGModNum [theTheGModNum 6])
						(if (> argc 8)
							(= theTheTheGModNum_6 [theTheGModNum 7])
							(if (> argc 9)
								(= theTheTheGModNum_7 [theTheGModNum 8])
								(if (> argc 10)
									(= theTheTheGModNum_8 [theTheGModNum 9])
									(if (> argc 11)
										(= theTheTheGModNum_9 [theTheGModNum 10])
										(if (> argc 12)
											(= theTheTheGModNum_10 [theTheGModNum 11])
											(if (> argc 13)
												(= theTheTheGModNum_11 [theTheGModNum 12])
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(if
				(= temp8
					(Message
						msgSIZE
						theGModNum
						theTheTheGModNum
						theTheTheGModNum_2
						theTheTheGModNum_3
						temp3
					)
				)
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if
					(not
						(Message
							msgGET
							theGModNum
							theTheTheGModNum
							theTheTheGModNum_2
							theTheTheGModNum_3
							temp3
							temp7
						)
					)
					(= temp7 0)
				)
			)
		else
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(if (> argc 2)
				(= theTheTheGModNum_4 [theTheGModNum 1])
				(if (> argc 3)
					(= theTheTheGModNum_5 [theTheGModNum 2])
					(if (> argc 4)
						(= theTheTheGModNum_6 [theTheGModNum 3])
						(if (> argc 5)
							(= theTheTheGModNum_7 [theTheGModNum 4])
							(if (> argc 6)
								(= theTheTheGModNum_8 [theTheGModNum 5])
								(if (> argc 7)
									(= theTheTheGModNum_9 [theTheGModNum 6])
									(if (> argc 8)
										(= theTheTheGModNum_10 [theTheGModNum 7])
										(if (> argc 9)
											(= theTheTheGModNum_11 [theTheGModNum 8])
										)
									)
								)
							)
						)
					)
				)
			)
			(= temp7
				(Memory memALLOC_CRIT (+ (StrLen [theTheGModNum 0]) 1))
			)
			(StrCpy temp7 [theTheGModNum 0])
		)
		(if temp7
			(dialog
				add:
					((DColorButton new:)
						value: param1
						font: font
						text: temp7
						mode: mode
						nfc: theTheTheGModNum_6
						nbc: theTheTheGModNum_9
						sfc: theTheTheGModNum_8
						sbc: theTheTheGModNum_11
						hfc: theTheTheGModNum_7
						hbc: theTheTheGModNum_10
						setSize: width
						moveTo: (+ 4 theTheTheGModNum_4) (+ 4 theTheTheGModNum_5)
						yourself:
					)
				setSize:
			)
		)
	)
	
	(method (addEdit param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not dialog) (= dialog (Dialog new:)))
		(StrCpy param1 (if (> argc 4) param5 else {}))
		(if (> argc 2)
			(= temp0 param3)
			(if (> argc 3) (= temp1 param4))
		)
		(dialog
			add:
				((DEdit new:)
					text: param1
					max: param2
					setSize:
					moveTo: (+ temp0 4) (+ temp1 4)
					yourself:
				)
			setSize:
		)
	)
	
	(method (addIcon param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not dialog) (= dialog (Dialog new:)))
		(if (> argc 3)
			(= temp0 param4)
			(= temp1 param5)
		else
			(= temp0 (= temp1 0))
		)
		(if (IsObject param1)
			(dialog
				add: (param1
					setSize:
					moveTo: (+ temp0 4) (+ temp1 4)
					yourself:
				)
				setSize:
			)
		else
			(dialog
				add:
					((DIcon new:)
						view: param1
						loop: param2
						cel: param3
						setSize:
						moveTo: (+ temp0 4) (+ temp1 4)
						yourself:
					)
				setSize:
			)
		)
	)
	
	(method (addText theTheGModNum &tmp theTheTheGModNum theTheTheGModNum_2 theTheTheGModNum_3 temp3 theTheTheGModNum_4 theTheTheGModNum_5 theGModNum temp7 temp8)
		(if (not dialog) (= dialog (Dialog new:)))
		(if (== font -1) (= font gFont))
		(if (> argc 3)
			(= theTheTheGModNum [theTheGModNum 0])
			(= theTheTheGModNum_2 [theTheGModNum 1])
			(= theTheTheGModNum_3 [theTheGModNum 2])
			(= temp3 (if [theTheGModNum 3] [theTheGModNum 3] else 1))
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(= theGModNum gModNum)
			(if (>= argc 5)
				(= theTheTheGModNum_4 [theTheGModNum 4])
				(if (>= argc 6)
					(= theTheTheGModNum_5 [theTheGModNum 5])
					(if (>= argc 7) (= theGModNum [theTheGModNum 6]))
				)
			)
			(if
				(= temp8
					(Message
						msgSIZE
						theGModNum
						theTheTheGModNum
						theTheTheGModNum_2
						theTheTheGModNum_3
						temp3
					)
				)
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if
					(Message
						msgGET
						theGModNum
						theTheTheGModNum
						theTheTheGModNum_2
						theTheTheGModNum_3
						temp3
						temp7
					)
					(dialog
						add:
							((DText new:)
								text: temp7
								font: font
								mode: mode
								setSize: width
								moveTo: (+ 4 theTheTheGModNum_4) (+ 4 theTheTheGModNum_5)
								yourself:
							)
						setSize:
					)
				)
			)
		else
			(= theTheTheGModNum_4 0)
			(= theTheTheGModNum_5 0)
			(if (>= argc 2)
				(= theTheTheGModNum_4 [theTheGModNum 1])
				(if (>= argc 3)
					(= theTheTheGModNum_5 [theTheGModNum 2])
				)
			)
			(= temp7
				(Memory memALLOC_CRIT (+ (StrLen [theTheGModNum 0]) 1))
			)
			(StrCpy temp7 [theTheGModNum 0])
			(dialog
				add:
					((DText new:)
						text: temp7
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 theTheTheGModNum_4) (+ 4 theTheTheGModNum_5)
						yourself:
					)
				setSize:
			)
		)
	)
	
	(method (addTextF &tmp temp0 temp1)
		(= temp0 (proc921_3 &rest))
		(= temp1 (Memory memALLOC_CRIT temp0))
		(Format temp1 &rest)
		(self addText: temp1)
		(Memory memFREE temp1)
	)
	
	(method (addTitle param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (> argc 1)
			(= temp0 [param1 0])
			(= temp1 [param1 1])
			(= temp2 [param1 2])
			(= temp3 [param1 3])
			(= temp4 [param1 4])
			(if
			(= temp5 (Message msgSIZE temp4 temp0 temp1 temp2 temp3))
				(= title (Memory memALLOC_CRIT temp5))
				(Message msgGET temp4 temp0 temp1 temp2 temp3 title)
			)
		else
			(= title
				(Memory memALLOC_CRIT (+ (StrLen [param1 0]) 1))
			)
			(StrCpy title [param1 0])
		)
	)
	
	(method (posn theX theY)
		(= x theX)
		(= y theY)
	)
	
	(method (handleEvent pEvent)
		(if (dialog handleEvent: pEvent) (dialog dispose:))
	)
	
	(method (cue &tmp theCaller)
		(= theCaller caller)
		(= dialog 0)
		(if window (window dispose:))
		(self dispose:)
		(if theCaller (theCaller cue:))
	)
)
