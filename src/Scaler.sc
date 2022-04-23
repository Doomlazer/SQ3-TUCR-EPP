;;; Sierra Script 1.0 - (do not remove this comment)
(script# 935)
(include sci.sh)
(use Print)
(use Obj)


(class Scaler of Code
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
	)
	
	(method (init theClient theFrontSize theBackSize theFrontY theBackY)
		(if argc
			(= client theClient)
			(= frontSize theFrontSize)
			(= backSize theBackSize)
			(= frontY theFrontY)
			(= backY theBackY)
		)
		(= slopeNum (- frontSize backSize))
		(if (not (= slopeDen (- frontY backY)))
			(proc921_0 {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= const (- backSize (/ (* slopeNum backY) slopeDen)))
		(return (self doit:))
	)
	
	(method (doit &tmp clientY theBackSize)
		(cond 
			((< (= clientY (client y?)) backY) (= theBackSize backSize))
			((> clientY frontY) (= theBackSize frontSize))
			(else
				(= theBackSize
					(+ (/ (* slopeNum clientY) slopeDen) const)
				)
			)
		)
		(= theBackSize (/ (* theBackSize 128) 100))
		(client scaleX: theBackSize scaleY: theBackSize)
	)
)
