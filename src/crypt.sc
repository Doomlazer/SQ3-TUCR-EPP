;;; Sierra Script 1.0 - (do not remove this comment)
(script# 910)
(use Intrface)

(public
	CryptString	0
	test 1
)

(procedure (test decoderNum)
	(Print 0 1)
)
(procedure (CryptString decoderNum &tmp i j [str 500])
	;(StrCpy str {HELP US! WE ARE BEING HELD CAPTIVE BY SCUMSOFT ON THE SMALL MOON OF PESTULON.  AN INPENETRABLE FORCE FIELD SURROUNDS THE MOON.  IT MUST FIRST BE DEACTIVATED.  IT'S ORIGIN IS UNKNOWN TO US.  SCUMSOFT SECURITY IS ARMED WITH JELLO PISTOLS.  WE'RE COUNTING ON YOU WHOEVER YOU ARE.\n\n     TWO GUYS IN TROUBLE})
	(Format @str {HELP US! WE ARE BEING HELD CAPTIVE BY SCUMSOFT ON THE SMALL MOON OF PESTULON.  AN INPENETRABLE FORCE FIELD SURROUNDS THE MOON.  IT MUST FIRST BE DEACTIVATED.  IT'S ORIGIN IS UNKNOWN TO US.  SCUMSOFT SECURITY IS ARMED WITH JELLO PISTOLS.  WE'RE COUNTING ON YOU WHOEVER YOU ARE.\n\n     TWO GUYS IN TROUBLE})
	(Print @str)
	(= i 0)
	(= j 0)
	(while (< i (StrLen str))
		(if (or
				(== j 1)
				(== 92 (StrAt str i))
			)
			;skip \n
			(if (== j 1)
				(= j 0)
			else
				(= j 1)	
			)
		else
			(StrAt str i (+ (StrAt str i) decoderNum))
		)
		(++ i)
	)
	(return str)
)