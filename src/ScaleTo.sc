;;; Sierra Script 1.0 - (do not remove this comment)
(script# 975)
(include sci.sh)
(use Main)
(use Scaler)


(class ScaleTo of Scaler
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
		caller 0
		endScale 0
		step 6
		waitCount 1
		scaleDir 0
		saveWaitCount 0
	)
	
	(method (init theClient theEndScale theCaller theCaller_2 theCaller_3)
		(if argc
			(= client theClient)
			(if (>= argc 2)
				(= endScale theEndScale)
				(if (>= argc 3)
					(if (IsObject theCaller)
						(= caller theCaller)
					else
						(= step theCaller)
						(if (>= argc 4)
							(if (IsObject theCaller_2)
								(= caller theCaller_2)
							else
								(= waitCount theCaller_2)
								(if (>= argc 5) (= caller theCaller_3))
							)
						)
					)
				)
			)
		)
		(= waitCount (+ (= saveWaitCount waitCount) gLastTicks))
		(= scaleDir
			(if (<= (client maxScale?) endScale) 1 else 0)
		)
	)
	
	(method (doit &tmp temp0)
		(if (> (- gLastTicks waitCount) 0)
			(= temp0
				(if scaleDir
					(+ (client maxScale?) step)
				else
					(- (client maxScale?) step)
				)
			)
			(client maxScale: temp0 scaleX: temp0 scaleY: temp0)
			(cond 
				(scaleDir (if (>= (client maxScale?) endScale) (self dispose:)))
				((<= (client maxScale?) endScale) (self dispose:))
			)
			(= waitCount (+ saveWaitCount gLastTicks))
		)
	)
	
	(method (dispose &tmp theCaller)
		(= endScale 0)
		(= step 6)
		(= waitCount 1)
		(client scaler: 0)
		(if caller
			(= theCaller caller)
			(= caller 0)
			(theCaller cue:)
		)
		(super dispose:)
	)
)
