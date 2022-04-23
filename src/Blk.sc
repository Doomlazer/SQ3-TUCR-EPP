;;; Sierra Script 1.0 - (do not remove this comment)
(script# 949)
(include sci.sh)
(use Obj)


(class Blk of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
	)
	
	(method (doit param1)
		(return
			(if
				(or
					(<= (param1 brBottom?) top)
					(> (param1 brTop?) bottom)
					(< (param1 brRight?) left)
				)
			else
				(>= (param1 brLeft?) right)
			)
		)
	)
)

(class Cage of Blk
	(properties
		top 0
		left 0
		bottom 0
		right 0
	)
	
	(method (doit param1)
		(return
			(if
				(and
					(>= (param1 brTop?) top)
					(>= (param1 brLeft?) left)
					(<= (param1 brBottom?) bottom)
				)
				(<= (param1 brRight?) right)
			else
				0
			)
		)
	)
)
