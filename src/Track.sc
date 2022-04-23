;;; Sierra Script 1.0 - (do not remove this comment)
(script# 955)
(include sci.sh)
(use Cycle)


(class Track of Motion
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
		who 0
		xOffset 0
		yOffset 0
		zOffset 0
	)
	
	(method (init theClient theWho theXOffset theYOffset theZOffset theCaller)
		(= client theClient)
		(= who theWho)
		(if (>= argc 3)
			(= xOffset theXOffset)
			(if (>= argc 4)
				(= yOffset theYOffset)
				(if (>= argc 5)
					(= zOffset theZOffset)
					(if (>= argc 6) (= caller theCaller))
				)
			)
		)
		(client ignoreActors: illegalBits: 0)
		(self doit:)
	)
	
	(method (doit &tmp whoHeading)
		(= whoHeading (who heading?))
		(client
			heading: whoHeading
			x: (+ (who x?) xOffset)
			y: (+ (who y?) yOffset)
			z: (+ (who z?) zOffset)
		)
		(if (client looper?)
			((client looper?) doit: client whoHeading)
		else
			(DirLoop client whoHeading)
		)
	)
)
