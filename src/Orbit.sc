;;; Sierra Script 1.0 - (do not remove this comment)
(script# 986)
(include sci.sh)
(use Main)
(use Cycle)
(use Obj)


(class Orbit of Motion
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		centerObj 0
		radius 50
		xTilt 0
		yTilt 0
		angleStep 10
		winding 1
		curAngle 0
	)
	
	(method (init theClient theCenterObj theRadius theXTilt theYTilt theAngleStep theWinding theCurAngle &tmp centerObjX centerObjY temp2 temp3)
		(if (>= argc 1)
			(= client theClient)
			(if (>= argc 2)
				(= centerObj theCenterObj)
				(if (>= argc 3)
					(= radius theRadius)
					(if (>= argc 4)
						(= xTilt theXTilt)
						(if (>= argc 5)
							(= yTilt theYTilt)
							(if (>= argc 6)
								(= angleStep theAngleStep)
								(if (>= argc 7)
									(= winding theWinding)
									(if (>= argc 8) (= curAngle theCurAngle))
								)
							)
						)
					)
				)
			)
		)
		(if centerObj
			(= centerObjX (centerObj x?))
			(= centerObjY (centerObj y?))
		else
			(= centerObjX 160)
			(= centerObjY 100)
		)
		(= temp2 (SinMult curAngle radius))
		(= temp3
			(CosMult (+ yTilt gPicAngle) (CosMult curAngle radius))
		)
		(if xTilt
			(= temp2 (CosMult xTilt temp2))
			(= temp3 (+ temp3 (SinMult xTilt temp2)))
		)
		(= x (+ centerObjX temp2))
		(= y (- centerObjY temp3))
		(= curAngle
			(proc999_1 (+ curAngle (* winding angleStep)) 360)
		)
		(super init: client x y)
	)
	
	(method (moveDone)
		(self init:)
	)
)
