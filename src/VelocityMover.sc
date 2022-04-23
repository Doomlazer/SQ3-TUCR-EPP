;;; Sierra Script 1.0 - (do not remove this comment)
(script# 25)
(include sci.sh)
(use Main)
(use Cycle)
(use Obj)


(class VelocityMover of MoveTo
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
		vel 30
		grav1x 160
		grav1y 100
		oldGravx 160
		oldGravy 100
		targetScale 0
		isScale 0
		willLand 0
		grav1 10
	)
	
	(method (init theClient theGrav1x theGrav1y theCaller theWillLand &tmp [temp0 3] clientCycler)
		(if argc
			(= vel 10)
			(= willLand (= isScale (= caller 0)))
			(= client theClient)
			(if (> argc 1)
				(= grav1x theGrav1x)
				(= grav1y theGrav1y)
				(= oldGravx theGrav1x)
				(= oldGravy theGrav1y)
				(if (> argc 3)
					(= caller theCaller)
					(if (> argc 4) (= willLand theWillLand))
				)
			)
			(self moveDone:)
		else
			(= yLast (= xLast (= completed 0)))
			(= b-moveCnt (+ 1 (client moveSpeed?) gLastTicks))
			(if (= clientCycler (client cycler?))
				(clientCycler cycleCnt: b-moveCnt)
			)
			(InitBresen self)
		)
	)
	
	(method (moveDone &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 100])
		(if
			(and
				willLand
				(<= (Abs (- (client x?) grav1x)) 5)
				(<= (Abs (- (client y?) grav1y)) 5)
			)
			(= completed 1)
			(if caller
				(= global37 1)
				(return)
			else
				(self motionCue:)
				(return)
			)
		)
		(if
		(>= (= temp2 (+ (- 360 (client heading?)) 90)) 360)
			(= temp2 (- temp2 360))
		)
		(if
			(>=
				(= temp1
					(+
						(-
							360
							(GetAngle (client x?) (client y?) grav1x grav1y)
						)
						90
					)
				)
				360
			)
			(= temp1 (- temp1 360))
		)
		(self readjustWell: temp1 temp2)
		(= temp3 (* (CosMult temp2 vel) 100))
		(= temp3
			(+
				(client x?)
				(if (> (mod temp3 100) 44) 1 else 0)
				(/ temp3 100)
			)
		)
		(= temp4 (* (SinMult temp2 vel) 100))
		(= temp4
			(-
				(client y?)
				(+ (if (> (mod temp4 100) 44) 1 else 0) (/ temp4 100))
			)
		)
		(= temp5
			(+
				(if
					(>
						(mod (= temp5 (* (CosMult temp1 grav1) 100)) 100)
						44
					)
					1
				else
					0
				)
				(/ temp5 100)
			)
		)
		(= temp6
			(+
				(if
					(>
						(mod (= temp6 (* (SinMult temp1 grav1) 100)) 100)
						44
					)
					1
				else
					0
				)
				(/ temp6 100)
			)
		)
		(= temp7 (+ temp5 temp3))
		(= temp8 (- temp4 temp6))
		(= vel
			(Sqrt
				(+
					(* (- temp7 (client x?)) (- temp7 (client x?)))
					(* (- (client y?) temp8) (- (client y?) temp8))
				)
			)
		)
		(client
			setHeading: (GetAngle (client x?) (client y?) temp7 temp8)
		)
		(self x: temp7 y: temp8)
		(self init:)
	)
	
	(method (onTarget)
		(return
			(if willLand
				(if
					(and
						(<= (Abs (- (client x?) grav1x)) 5)
						(<= (Abs (- (client y?) grav1y)) 5)
					)
					(= completed 1)
					(if caller
						(= global37 1)
						(return 1)
					else
						(self motionCue:)
						(return 1)
					)
				else
					(if (< vel 0)
						(= vel (+ vel 1))
					else
						(= vel (- vel 1))
					)
					(return 0)
				)
			else
				(return 0)
			)
		)
	)
	
	(method (motionCue)
		(client posn: grav1x grav1y)
		(super motionCue:)
	)
	
	(method (readjustWell param1 param2)
		(if (proc999_5 param1 0 90 180 270)
			(= grav1x (- oldGravx (- (Random 1 20) 10)))
		else
			(= grav1x oldGravx)
		)
		(if (proc999_5 param2 0 90 180 270)
			(= grav1y (- oldGravy (- (Random 1 20) 10)))
		else
			(= grav1y oldGravy)
		)
	)
)
