;;; Sierra Script 1.0 - (do not remove this comment)
(script# 974)
(include sci.sh)
(use Obj)

(public
	proc974_0 0
)

(procedure (proc974_0 param1 param2)
	(param2 firstTrue: #perform NC param1)
)

(instance NC of Code
	(properties)
	
	(method (doit param1 param2)
		(return (== 0 (StrCmp (param1 name?) param2)))
	)
)
