;;; Sierra Script 1.0 - (do not remove this comment)
(script# 980)
(include sci.sh)
(use Main)
(use Print)
(use Obj)


(class Tutorial of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
		nextItem 0
		nextAction 0
		numTries 0
	)
	
	(method (cue)
		(= numTries 0)
		(super cue: &rest)
	)
	
	(method (waitFor theNextItem theNextAction param3 param4 param5 param6 param7)
		(= nextItem theNextItem)
		(= nextAction theNextAction)
		(cond 
			((== argc 3) (proc921_0 param3))
			((> argc 3) (gTestMessager say: param3 param4 param5 param6 param7))
		)
	)
	
	(method (report)
	)
)
