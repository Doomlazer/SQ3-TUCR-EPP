;;; Sierra Script 1.0 - (do not remove this comment)
(script# regtrail)
(include game.sh)
(use Main)
(use Intrface)
(use Game)
(use Actor)
(use System)
(use Motion)
(use Sound)

(public
	regtrail 0
	cleanup 1
)

(local
	count1
;	count2
	count3
;	count4
	count5
	randy
	drep
)

(instance trail0 of Actor
        (properties
                signal $4000
        )
)

(instance trail1 of Actor
        (properties
                signal $4000
        )
)
;;;(instance trail2 of Actor
;;;        (properties
;;;                signal $4000
;;;        )
;;;)
(instance trail3 of Actor
        (properties
                signal $4000
        )
)
;;;(instance trail4 of Actor
;;;        (properties
;;;                signal $4000
;;;        )
;;;)
(instance trail5 of Actor
        (properties
                signal $4000
        )
)


(instance cleanup of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(trail0 hide:)
				(HandsOff)
				(ego
					loop: tdl
					setCel: -1
				)
				(= seconds 3)
			)
			(1
				(ego
					view: 294
					posn: tdx tdy
					loop: tdl
					xStep: tdxs
					yStep: tdys	
					setPri: -1
					cycleSpeed: tdcs
					illegalBits: tdill
					ignoreControl: tdicon
					observeControl: tdobc
					setCycle: BegLoop self
				)	
				(hit number: 79 play:)
			)
			(2 
				(ego
					view: tdv
					setCycle: Walk
					setLoop: -1
				)
				(= seconds 2)
			)
			(3
				(hit stop:)
				(RedrawCast)
				(HandsOn)
				(if (< drep 1) 
					(Print 0 42 #icon 242 1 1)
				)
				(if (== drep 10) 
					(Print 0 44)	
				)
				(++ drep)
				
				(cleanup dispose:)
			)
		)
	)
)

(instance hit of Sound
	(properties
		priority 15 ;5
	)
)

(instance regtrail of Region
 	(method (init)
		(super init:)
		(= tdx (ego x?)) 
		(= tdy (ego y?))
		(= tdv (ego view?))
		(= tdxs (ego xStep?))
		(= tdys (ego yStep?))
		(= tdl (ego loop?))
		(= tdcs (ego cycleSpeed?))
		(= tdill (ego illegalBits?))
		(= tdicon (ego ignoreControl?))
		(= tdobc (ego observeControl?))
		(trail0
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			setPri: (ego priority?)
			init:
		)
		(trail1
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			setPri: (ego priority?)
			init:
		)
		(= count1 4)
;;;		(trail2
;;;			x: (ego x?)
;;;			y: (ego y?)
;;;			view: (ego view?)
;;;			loop: (ego loop?)
;;;			cel: (ego cel?)
;;;			setPri: (ego priority?)
;;;			init:
;;;		)
;;;		(= count2 8)
		(trail3
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			setPri: (ego priority?)
			init:
		)
		(= count3 12)
;;;		(trail4
;;;			x: (ego x?)
;;;			y: (ego y?)
;;;			view: (ego view?)
;;;			loop: (ego loop?)
;;;			cel: (ego cel?)
;;;			setPri: (ego priority?)
;;;			init:
;;;		)
;;;		(= count4 16)
		(trail5
			x: (ego x?)
			y: (ego y?)
			view: (ego view?)
			loop: (ego loop?)
			cel: (ego cel?)
			setPri: (ego priority?)
			init:
		)
		(= count5 20)
	)
	
	(method (doit &tmp [str 40])
		(super doit:)
		(= randy 20) ;(Random 19 20))
		(-- count1)
		(if (<= count1 0) 
			(trail1 
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
				setPri: (ego priority?)
			)
			(= count1 randy)
		)
;;;		(-- count2)
;;;		(if (<= count2 0) 
;;;			(trail2
;;;				x: (ego x?)
;;;				y: (ego y?)
;;;				view: (ego view?)
;;;				loop: (ego loop?)
;;;				cel: (ego cel?)
;;;				setPri: (ego priority?)
;;;			)
;;;			(= count2 randy)
;;;		)
		(-- count3)
		(if (<= count3 0) 
			(trail3
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
				setPri: (ego priority?)
			)
			(= count3 randy)
		)
;;;		(-- count4)
;;;		(if (<= count4 0) 
;;;			(trail4
;;;				x: (ego x?)
;;;				y: (ego y?)
;;;				view: (ego view?)
;;;				loop: (ego loop?)
;;;				cel: (ego cel?)
;;;				setPri: (ego priority?)
;;;			)
;;;			(= count4 randy)
;;;		)
		(-- count5)
		(if (<= count5 0) 
			(trail5
				x: (ego x?)
				y: (ego y?)
				view: (ego view?)
				loop: (ego loop?)
				cel: (ego cel?)
				setPri: (ego priority?)
			)
			(= count5 randy)
		)
	)
)
