;;; Sierra Script 1.0 - (do not remove this comment)
(script# 946)
(include sci.sh)
(use Obj)


(class Polygon of Obj
	(properties
		size 0
		points 0
		type $0001
		dynamic 0
	)
	
	(method (init param1 &tmp [temp0 2])
		(= size (/ argc 2))
		(= points (Memory memALLOC_CRIT (* 2 argc)))
		(StrCpy points @param1 (- (* argc 2)))
		(= dynamic 1)
	)
	
	(method (dispose)
		(if (and dynamic points) (Memory memFREE points))
		(super dispose:)
	)
)
