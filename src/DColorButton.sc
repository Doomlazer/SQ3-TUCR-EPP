;;; Sierra Script 1.0 - (do not remove this comment)
(script# 32)
(include sci.sh)
(use Class_255_0)
(use DIcon)
(use Obj)


(class DColorButton of DButton
	(properties
		type $0001
		state $0003
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
		mode 0
		nfc 0
		nbc 7
		hfc 15
		hbc 7
		sfc 7
		sbc 7
	)
	
	(method (track param1 &tmp temp0 temp1 theSfc theSbc)
		(return
			(if (== 1 (param1 type?))
				(= temp1 0)
				(repeat
					((= param1 (Event new: -32768)) localize:)
					(if (!= (= temp0 (self check: param1)) temp1)
						(if (& state $0008)
							(= theSfc sfc)
							(= theSbc sbc)
						else
							(= theSfc hfc)
							(= theSbc hbc)
						)
						(Display
							text
							dsCOORD
							nsLeft
							nsTop
							dsWIDTH
							(- nsRight nsLeft)
							dsFONT
							font
							dsCOLOR
							theSfc
							dsBACKGROUND
							theSbc
							dsALIGN
							mode
						)
						(= temp1 temp0)
					)
					(param1 dispose:)
					(breakif (not (proc255_0)))
				)
				(if temp0
					(if (& state $0008)
						(= theSfc sfc)
						(= theSbc sbc)
					else
						(= theSfc hfc)
						(= theSbc hbc)
					)
					(Display
						text
						dsCOORD
						nsLeft
						nsTop
						dsWIDTH
						(- nsRight nsLeft)
						dsFONT
						font
						dsCOLOR
						theSfc
						dsBACKGROUND
						theSbc
						dsALIGN
						mode
					)
				)
				(return temp0)
			else
				(return self)
			)
		)
	)
	
	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(= [temp0 2] (+ [temp0 2] 2))
		(= [temp0 3] (+ [temp0 3] 2))
		(= nsBottom (+ nsTop [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= nsRight (+ [temp0 3] nsLeft))
	)
	
	(method (draw &tmp theHfc theHbc)
		(if (& state $0008)
			(= theHfc hfc)
			(= theHbc hbc)
		else
			(= theHfc nfc)
			(= theHbc nbc)
		)
		(Display
			text
			dsCOORD
			nsLeft
			nsTop
			dsWIDTH
			(- nsRight nsLeft)
			dsFONT
			font
			dsCOLOR
			theHfc
			dsBACKGROUND
			theHbc
			dsALIGN
			mode
		)
	)
)
