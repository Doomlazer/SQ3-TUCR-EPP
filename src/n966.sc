;;; Sierra Script 1.0 - (do not remove this comment)
(script# 966)
(include sci.sh)
(use Obj)

(public
	proc966_0 0
)

(procedure (proc966_0 param1 param2 &tmp temp0 temp1 temp2 newList)
	(= newList (List new:))
	(while (= temp1 (FirstNode (param1 elements?)))
		(= temp2 (NodeValue temp1))
		(while temp1
			(if
			(param2 doit: (= temp0 (NodeValue temp1)) temp2 &rest)
				(= temp2 temp0)
			)
			(= temp1 (NextNode temp1))
		)
		(TE doit: temp2 param1 newList)
	)
	(newList
		eachElementDo: #perform TE newList param1
		dispose:
	)
)

(instance TE of Code
	(properties)
	
	(method (doit param1 param2 param3)
		(param3 addToEnd: param1)
		(param2 delete: param1)
	)
)
