;;; Sierra Script 1.0 - (do not remove this comment)
(script# regtrail)
(include game.sh)
(use Main)
(use Intrface)
(use Game)
(use Actor)

(public
	regtrail 0
)

(local
	count1
	count2
	count3
	count4
	count5
	randy
)

(instance trail1 of Actor
        (properties
                signal $4000
        )
)
(instance trail2 of Actor
        (properties
                signal $4000
        )
)
(instance trail3 of Actor
        (properties
                signal $4000
        )
)
(instance trail4 of Actor
        (properties
                signal $4000
        )
)
(instance trail5 of Actor
        (properties
                signal $4000
        )
)


(instance regtrail of Region
 	(method (init)
		(super init:)
		(trail1
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			init:
		)
		(= count1 4)
		(trail2
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			init:
		)
		(= count2 8)
		(trail3
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			init:
		)
		(= count3 12)
		(trail4
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			init:
		)
		(= count4 16)
		(trail5
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			init:
		)
		(= count5 20)
	)
	
	(method (doit &tmp [str 40])
		(super doit:)
		(= randy (Random 19 20)) ;20
		; code executed each game cycle
		(-- count1)
		(if (<= count1 0) 
			(trail1 
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
			)
			(= count1 randy)
		)
		(-- count2)
		(if (<= count2 0) 
			(trail2
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
			)
			(= count2 randy)
		)
		(-- count3)
		(if (<= count3 0) 
			(trail3
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
			)
			(= count3 randy)
		)
		(-- count4)
		(if (<= count4 0) 
			(trail4
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
			)
			(= count4 randy)
		)
		(if (<= count5 0) 
			(trail5
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
			)
			(= count5 randy)
		)
	)
)
