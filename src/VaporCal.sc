;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include game.sh)
(use Main)
(use System)
(use Actor)

(public
	calcScript 0
)

(local
	xPos = [131 142 153 164 175 186 131 142 153 164 175 186]
	yG = [54 58 61 67 71 75 79 83 87] ;row Y greater than
	yL = [58 60 64 71 75 79 83 87 91] ;row Y less than
)

(instance base of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 0
			setCel: 0
			ignoreActors: TRUE
			setPri: 15
			posn: 159 94
			stopUpd:
		)
	)
)

(instance t1 of Prop)
(instance t2 of Prop)
(instance t3 of Prop)
(instance t4 of Prop)
(instance t5 of Prop)
(instance t6 of Prop)
(instance b1 of Prop)
(instance b2 of Prop)
(instance b3 of Prop)
(instance b4 of Prop)
(instance b5 of Prop)
(instance b6 of Prop)

(procedure (GetView v)
	(return 
		(switch v
			(0 t1)
			(1 t2)
			(2 t3)
			(3 t4)
			(4 t5)
			(5 t6)
			(6 b1)
			(7 b2)
			(8 b3)
			(9 b4)
			(10 b5)
			(11 b6)
		)
	)
)

(instance calcScript of Script
	(properties)
	
	(method (init &tmp v)
		(= v 0)
		(while (< v 12)
			((GetView v)
				view: 27
				setLoop: (if (< v 6) 1 else 2)
				setCel: [VCCel v]
				ignoreActors: TRUE
				setPri: 15
				posn: [xPos v] (if (< v 6) 63 else 91)
				init:
			)
			(++ v)		
		)
		(base init:)
	)
	
	(method (handleEvent event &tmp i i2)
		(if (event claimed?) (return))
		(switch (event type?)
			(mouseDown
				(event claimed: TRUE)
				(if
					(and
						(>= (event x?) 120)
						(<= (event x?) 197)
						(>= (event y?) 52)
						(<= (event y?) 94)
					)
					(= i 0)
					(while (< i 6) ;iterate colums
						(if 
							(and
								(>= (event x?) (- [xPos i] 4))
								(<= (event x?) (+ [xPos i] 4))
							)
							(= i2 0)
							(while (< i2 9) ;iterate rows
								(if
									(and
										(>= (event y?) [yG i2])
										(<= (event y?) [yL i2])
									)
									((GetView (if (< i2 3) i else (+ i 6)))
										setCel: (if (< i2 3) i2 else (- i2 3))
									)
								)
								(++ i2)
							)
						)
						(++ i)
					)
				else
					(= calcOn FALSE)
				)
			)
			(keyDown
				(= calcOn FALSE)
			)
		)
	)
	
	(method (dispose &tmp v)
		(HandsOn)
		(= v 0)
		(while (< v 12) ;save current cels
			(= [VCCel v] ((GetView v) cel?))
			((GetView v) dispose:)	
			(++ v)
		)
		(base dispose:)
	)
)
