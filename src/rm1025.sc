;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1025)
(include sci.sh)
(use Main)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm1025 0
)

(instance rm1025 of Rm
	(properties
		noun 1
		picture 133
	)
	
	(method (init)
		(proc958_0 128 679)
		(= global133 2)
		(= global135 26)
		(bigarrow init: setCycle: Fwd)
		(shieldSwitch init:)
		(light init:)
		(super init:)
		(gOldWH addToFront: self)
		(gSQ5 handsOn:)
		(gSq5IconBar select: (gSq5IconBar at: 2))
		(gSQ5 setCursor: 982)
	)
	
	(method (dispose)
		(gOldWH delete: self)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager say: noun theVerb 0 0)
			)
			(else  (global2 newRoom: 1020))
		)
	)
)

(instance sFlipSwitch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(shieldSwitch setCel: 0)
				(light dispose:)
				(arrow init: setCycle: Fwd)
				(proc0_10 248 20)
				(= seconds 2)
			)
			(1
				(global2 newRoom: 1020)
				(self dispose:)
			)
		)
	)
)

(instance arrow of Prop
	(properties
		x 126
		y 116
		noun 3
		view 679
		loop 1
		cycleSpeed 8
	)
)

(instance bigarrow of Prop
	(properties
		x 150
		y 73
		noun 3
		view 679
	)
)

(instance shieldSwitch of View
	(properties
		x 160
		y 108
		noun 2
		view 679
		loop 2
		cel 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sFlipSwitch)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light of View
	(properties
		x 198
		y 117
		noun 3
		view 679
		loop 3
	)
)
