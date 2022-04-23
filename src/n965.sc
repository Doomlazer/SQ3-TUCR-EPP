;;; Sierra Script 1.0 - (do not remove this comment)
(script# 965)
(include sci.sh)

(public
	proc965_0 0
)

(procedure (proc965_0 param1 param2 &tmp temp0 temp1)
	(= temp1 (FirstNode (param1 elements?)))
	(= temp0 0)
	(while temp1
		(if (param2 doit: (NodeValue temp1) &rest) (++ temp0))
		(= temp1 (NextNode temp1))
	)
	(return temp0)
)
