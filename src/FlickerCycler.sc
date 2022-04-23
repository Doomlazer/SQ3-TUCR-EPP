;;; Sierra Script 1.0 - (do not remove this comment)
(script# 21)
(include sci.sh)
(use Main)
(use Cycle)


(class FlickerCycler of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		cycleSpeed 8
	)
	
	(method (doit &tmp temp0)
		(self nextCel:)
	)
	
	(method (nextCel)
		(if (< (Abs (- gLastTicks cycleCnt)) cycleSpeed)
			(client cel?)
		else
			(= cycleSpeed (Random 5 30))
			(client cel?)
			(= cycleCnt gLastTicks)
			(if (client isNotHidden:)
				(client hide:)
			else
				(client show:)
			)
		)
	)
)
