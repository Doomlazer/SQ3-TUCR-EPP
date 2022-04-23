;;; Sierra Script 1.0 - (do not remove this comment)
(script# 951)
(include sci.sh)
(use PolyPath)


(class MoveFwd of PolyPath
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
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)
	
	(method (init param1 param2 param3)
		(if argc
			(super
				init:
					param1
					(+ (param1 x?) (SinMult (param1 heading?) param2))
					(- (param1 y?) (CosMult (param1 heading?) param2))
					(if (>= argc 3) param3 else 0)
			)
		else
			(super init:)
		)
	)
)
