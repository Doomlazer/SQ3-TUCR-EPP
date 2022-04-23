;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1005)
(include sci.sh)
(use Main)
(use Osc)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm1005 0
)

(instance rm1005 of Rm
	(properties
		noun 4
		picture 121
		style $800a
	)
	
	(method (init)
		(proc958_0 128 667)
		(proc0_6 0)
		(gEgo init: hide:)
		(if (proc0_1 59)
			(lightPulse loop: 4)
			(lightCurve loop: 5)
			(statusLight cel: 0)
			(onOffText cel: 1)
		)
		(lightPulse init:)
		(lightCurve init:)
		(statusLight init:)
		(onOffText init:)
		(recepticle init: setOnMeCheck: 1 1024)
		(if (proc0_1 59)
			(global2 setScript: sOnLine)
		else
			(global2 setScript: sOffLine)
		)
		(super init:)
		(gOldWH addToFront: self)
		(gSQ5 handsOn:)
	)
	
	(method (dispose)
		(gOldWH delete: self)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 59)
					(gTestMessager say: noun theVerb 1 0)
				else
					(gTestMessager say: noun theVerb 2 0)
				)
			)
			(else 
				(if (== gGModNum 1000)
					(global2 newRoom: 1000)
				else
					(global2 newRoom: 1001)
				)
			)
		)
	)
)

(instance sOffLine of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 3)
			)
			(1
				(lightPulse loop: 0 cel: 0 setCycle: End self)
				(lightCurve loop: 2 cel: 0 setCycle: End)
			)
			(2
				(lightFlash loop: 1 cel: 0 init: setCycle: Osc 1 self)
			)
			(3
				(lightFlash dispose:)
				(lightPulse setCycle: Osc)
				(lightCurve setCycle: Osc)
				(gSQ5 handsOn:)
			)
			(4
				(= next sInstallCap)
				(self dispose:)
			)
		)
	)
)

(instance sInstallCap of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cap init:)
				(proc0_10 245 100)
				(capTop
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 8
					setMotion: MoveTo 104 26 self
				)
			)
			(1
				(gSq5Music2 number: 651 setLoop: 1 play:)
				(proc0_2 59)
				(gEgo put: 3)
				(gTestMessager say: 1 0 0 0 self)
			)
			(2
				(gSQ5 handsOn:)
				(= next sOnLine)
				(self dispose:)
			)
		)
	)
)

(instance sOnLine of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(cap init:)
				(capTop x: 104 y: 26 init:)
				(lightPulse loop: 4 cel: 0 setCycle: End self)
				(lightCurve loop: 5 cel: 0 setCycle: End)
				(statusLight cel: 0 x: 210 y: 43)
				(onOffText cel: 1)
			)
			(1
				(lightFlash loop: 6 cel: 0 init: setCycle: Osc 1 self)
			)
			(2
				(lightFlash dispose:)
				(lightPulse setCycle: Osc)
				(lightCurve setCycle: Osc)
				(gSQ5 handsOn:)
			)
			(3 (self dispose:))
		)
	)
)

(instance lightPulse of Prop
	(properties
		x 121
		y 95
		noun 2
		view 667
		signal $4000
	)
)

(instance lightFlash of Prop
	(properties
		x 133
		y 96
		noun 2
		view 667
		loop 1
		signal $4000
	)
)

(instance lightCurve of Prop
	(properties
		x 172
		y 93
		noun 2
		view 667
		loop 2
		signal $4000
	)
)

(instance statusLight of View
	(properties
		x 224
		y 45
		noun 2
		view 667
		loop 9
		cel 1
		signal $4000
	)
)

(instance onOffText of View
	(properties
		x 134
		y 139
		noun 2
		view 667
		loop 3
		signal $4000
	)
)

(instance cap of Actor
	(properties
		x 113
		y 43
		noun 3
		view 667
		loop 7
		priority 6
		signal $6010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 59)
					(gTestMessager say: noun theVerb 1 0)
				else
					(gTestMessager say: noun theVerb 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance capTop of Actor
	(properties
		x 104
		y -10
		noun 3
		view 667
		loop 8
		priority 8
		signal $6010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 59)
					(gTestMessager say: noun theVerb 1 0)
				else
					(gTestMessager say: noun theVerb 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance recepticle of Feature
	(properties
		x 160
		y 95
		noun 3
		onMeCheck $0400
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(19 (sOffLine cue:))
			(1
				(if (proc0_1 59)
					(gTestMessager say: noun theVerb 1 0)
				else
					(gTestMessager say: noun theVerb 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
