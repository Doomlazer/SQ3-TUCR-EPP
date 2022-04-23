;;; Sierra Script 1.0 - (do not remove this comment)
(script# 938)
(include sci.sh)
(use Cycle)


(class ROsc of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		cycles -1
		firstC 0
		lastC 0
	)
	
	(method (init param1 theCycles theFirstC theLastC theCaller)
		(if (>= argc 2) (= cycles theCycles))
		(if (>= argc 5) (= caller theCaller))
		(super init: param1)
		(if (>= argc 3)
			(= firstC theFirstC)
			(if (>= argc 4)
				(if theLastC
					(= lastC theLastC)
				else
					(= lastC (client lastCel:))
				)
			else
				(= lastC (client lastCel:))
			)
		)
		(client cel: firstC)
	)
	
	(method (doit &tmp rOscNextCel)
		(if
			(or
				(> (= rOscNextCel (self nextCel:)) lastC)
				(< rOscNextCel firstC)
			)
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: rOscNextCel)
		)
	)
	
	(method (cycleDone)
		(if cycles
			(client cel: (self nextCel:))
			(if (> cycles 0) (-- cycles))
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)
