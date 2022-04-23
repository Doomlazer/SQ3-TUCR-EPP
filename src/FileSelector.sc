;;; Sierra Script 1.0 - (do not remove this comment)
(script# 944)
(include sci.sh)
(use DIcon)


(procedure (localproc_0151 param1 param2 &tmp temp0 temp1 [temp2 13] temp15 temp16 temp17)
	(= temp0 (- param2 1))
	(while (> temp0 0)
		(= temp15 0)
		(= temp1 0)
		(while (< temp1 temp0)
			(= temp17 (+ (= temp16 (+ param1 (* temp1 13))) 13))
			(if (< (StrCmp temp17 temp16) 0)
				(StrCpy @temp2 temp16)
				(StrCpy temp16 temp17)
				(StrCpy temp17 @temp2)
				(= temp15 1)
			)
			(++ temp1)
		)
		(breakif (not temp15))
		(-- temp0)
	)
)

(class FileSelector of DSelector
	(properties
		type $0006
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		font 0
		x 13
		y 6
		text 0
		cursor 0
		topString 0
		mark 0
		mask 0
		nFiles 0
		sort 1
	)
	
	(method (dispose)
		(if text (Memory memFREE text) (= text 0))
		(super dispose:)
	)
	
	(method (setSize &tmp [temp0 4])
		(super setSize:)
		(TextSize @[temp0 0] {M} font)
		(= nsRight (+ nsLeft (* [temp0 3] x)))
	)
	
	(method (readFiles theMask &tmp [temp0 7] temp7 theText temp9)
		(if (> argc 0) (= mask theMask))
		(if (not mask) (= mask {*.*}))
		(if text (Memory memFREE text) (= text 0))
		(= nFiles 0)
		(= temp9 (FileIO fiFIND_FIRST mask @temp0 0))
		(while temp9
			(++ nFiles)
			(= temp9 (FileIO fiFIND_NEXT @temp0))
		)
		(if
			(not
				(= text (Memory memALLOC_NONCRIT (+ (* nFiles 13) 1)))
			)
			(return 0)
		)
		(= temp7 0)
		(= theText text)
		(= temp9 (FileIO fiFIND_FIRST mask @temp0 0))
		(while (and temp9 (< temp7 nFiles))
			(StrCpy theText @temp0)
			(++ temp7)
			(= theText (+ theText 13))
			(= temp9 (FileIO fiFIND_NEXT @temp0))
		)
		(StrAt text (* nFiles 13) 0)
		(if sort (localproc_0151 text nFiles))
		(return 1)
	)
)
