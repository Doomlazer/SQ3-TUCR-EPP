;;; Sierra Script 1.0 - (do not remove this comment)
(script# 925)
(include sci.sh)
(use Main)
(use Print)
(use Obj)


(class MessageObj of Obj
	(properties
		modNum -1
		noun 0
		verb 0
		case 0
		sequence 0
		whoSays 0
		client 0
		caller 0
		font 0
		x 0
		y 0
	)
	
	(method (showSelf &tmp [temp0 40])
		(= whoSays
			(gTestMessager
				findTalker: (Message
					msgGET
					modNum
					noun
					verb
					case
					(if sequence else 1)
				)
			)
		)
		(if (not (IsObject whoSays))
			(Print
				addTextF:
					{<MessageObj> Message not found: %d - %d, %d, %d, %d}
					modNum
					noun
					verb
					case
					sequence
				init:
			)
			(= global4 1)
		else
			(if font (whoSays font: font))
			(if (or x y) (whoSays x: x y: y))
			(gTestMessager say: noun verb case sequence caller modNum)
		)
	)
)

(class Conversation of List
	(properties
		elements 0
		size 0
		script 0
		curItem -1
		caller 0
	)
	
	(method (init theCaller)
		(= curItem -1)
		(if (and argc (IsObject theCaller))
			(= caller theCaller)
		)
		(gTheDoits add: self)
		(self cue:)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (dispose &tmp theCaller)
		(self eachElementDo: #perform cleanCode)
		(gTheDoits delete: self)
		(if gDialog (gDialog dispose:))
		(if script (= script 0))
		(= theCaller caller)
		(super dispose:)
		(if theCaller (theCaller cue:))
	)
	
	(method (add theTheGModNum &tmp theGModNum theTheTheGModNum theTheTheGModNum_2 theTheTheGModNum_3 theTheTheGModNum_4 theTheTheGModNum_5 theTheTheGModNum_6 theTheTheGModNum_7)
		(= theGModNum
			(= theTheTheGModNum
				(= theTheTheGModNum_2
					(= theTheTheGModNum_3 (= theTheTheGModNum_4 0))
				)
			)
		)
		(= theTheTheGModNum_5
			(= theTheTheGModNum_6 (= theTheTheGModNum_7 0))
		)
		(if (and argc (not (IsObject [theTheGModNum 0])))
			(if (== (= theGModNum [theTheGModNum 0]) -1)
				(= theGModNum gModNum)
			)
			(if (> argc 1)
				(= theTheTheGModNum [theTheGModNum 1])
				(if (> argc 2)
					(= theTheTheGModNum_2 [theTheGModNum 2])
					(if (> argc 3)
						(= theTheTheGModNum_3 [theTheGModNum 3])
						(if (> argc 4)
							(= theTheTheGModNum_4 [theTheGModNum 4])
							(if (> argc 5)
								(= theTheTheGModNum_5 [theTheGModNum 5])
								(if (> argc 6)
									(= theTheTheGModNum_6 [theTheGModNum 6])
									(if (> argc 7) (= theTheTheGModNum_7 [theTheGModNum 7]))
								)
							)
						)
					)
				)
			)
			(if (not (IsObject [theTheGModNum 0]))
				(super
					add:
						((MessageObj new:)
							modNum: theGModNum
							noun: theTheTheGModNum
							verb: theTheTheGModNum_2
							case: theTheTheGModNum_3
							sequence: theTheTheGModNum_4
							x: theTheTheGModNum_5
							y: theTheTheGModNum_6
							font: theTheTheGModNum_7
							yourself:
						)
				)
			)
		else
			(super add: theTheGModNum &rest)
		)
	)
	
	(method (cue param1 &tmp temp0 temp1)
		(if (or (and argc param1) (== (++ curItem) size))
			(self dispose:)
		else
			(= temp0 (self at: curItem))
			(cond 
				((temp0 isKindOf: MessageObj) (temp0 caller: self showSelf:))
				((temp0 isKindOf: Script) (self setScript: temp0 self))
				((IsObject temp0) (temp0 doit: self))
				(else (self cue:))
			)
		)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (load param1 &tmp theGModNum temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= theGModNum (proc999_6 param1 0))
		(= temp1 (proc999_6 param1 1))
		(= temp2 (proc999_6 param1 2))
		(= temp3 (proc999_6 param1 3))
		(= temp4 (proc999_6 param1 4))
		(= temp5 (proc999_6 param1 5))
		(= temp6 (proc999_6 param1 6))
		(= temp7 (proc999_6 param1 7))
		(= temp8 7)
		(while theGModNum
			(if (== theGModNum -1) (= theGModNum gModNum))
			(self
				add: theGModNum temp1 temp2 temp3 temp4 temp5 temp6 temp7
			)
			(= theGModNum (proc999_6 param1 (++ temp8)))
			(= temp1 (proc999_6 param1 (++ temp8)))
			(= temp2 (proc999_6 param1 (++ temp8)))
			(= temp3 (proc999_6 param1 (++ temp8)))
			(= temp4 (proc999_6 param1 (++ temp8)))
			(= temp5 (proc999_6 param1 (++ temp8)))
			(= temp6 (proc999_6 param1 (++ temp8)))
			(= temp7 (proc999_6 param1 (++ temp8)))
		)
	)
)

(instance cleanCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 isKindOf: Script) (param1 caller: 0))
		(if
			(and
				(param1 isKindOf: MessageObj)
				(IsObject (= temp0 (param1 whoSays?)))
				(temp0 underBits?)
			)
			(temp0 dispose: 1)
		)
	)
)
