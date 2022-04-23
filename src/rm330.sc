;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use Scaler)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm330 0
)

(local
	local0
)
(instance rm330 of Rm
	(properties
		noun 6
		picture 66
		style $800a
		vanishingY 30
	)
	
	(method (init)
		(self setRegions: 350)
		(proc958_0 128 0 446 445)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						70
						91
						75
						106
						63
						111
						60
						140
						113
						139
						110
						129
						127
						117
						200
						113
						204
						118
						188
						129
						139
						130
						128
						139
						131
						153
						161
						161
						261
						160
						264
						146
						229
						136
						237
						121
						274
						131
						304
						126
						188
						99
						172
						99
						173
						94
						147
						88
						136
						88
						163
						98
						162
						105
						168
						107
						123
						111
						94
						103
						81
						89
						68
						90
					yourself:
				)
		)
		(lights1 init: setCycle: Fwd)
		(lights2 init: setCycle: Fwd)
		(lights3 init: setCycle: Fwd)
		(gSq5Music2 number: 430 setLoop: -1 play:)
		(elevator init:)
		(cloakPanel init: approachVerbs: 4)
		(pilotArea init: approachVerbs: 3 4 setOnMeCheck: 1 2)
		(leftDwoot init: setOnMeCheck: 1 64)
		(rightDwoot init: setOnMeCheck: 1 512)
		(screen init: setOnMeCheck: 1 16)
		(viewWindow init: setOnMeCheck: 1 1024)
		(switch gGModNum
			(335
				(countdown1
					init:
					setCycle: RTRandCycle
					setScript: sShipBlow
				)
				(countdown2 init: setCycle: RTRandCycle)
				(elevator x: 183 y: 138)
				(cloakPanel cel: 2)
				(proc0_6 0)
				(gEgo
					x: 225
					y: 115
					loop: 5
					setScale: Scaler 100 53 121 83
					actions: (ScriptID 350 1)
					init:
				)
				(gSq5Music1 number: 124 setLoop: -1 play:)
				(gSQ5 handsOn:)
			)
			(else 
				(global2 setScript: sRogEnters)
				(gEgo actions: (ScriptID 350 1))
			)
		)
		(super init:)
		(gOldWH addToFront: pilotArea)
	)
	
	(method (doit)
		(Palette palANIMATE 225 234 2)
		(if
		(and (proc0_5 gEgo 4) (not (global2 script?)))
			(global2 setScript: sRogExits)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(gOldWH delete: pilotArea)
		(PalVary pvUNINIT)
		(super dispose: &rest)
	)
)

(instance sShipBlow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 20))
			(1
				(gSQ5 handsOff:)
				(PalVary pvUNINIT)
				(PalVary pvINIT 921 1)
				(theMusic3 number: 203 setLoop: 1 play: self)
			)
			(2 (proc0_9 22))
		)
	)
)

(instance sRogEnters of Script
	(properties)
	
	(method (doit)
		(if (> (gEgo y?) 146)
			(elevator posn: 183 (- (gEgo y?) 9))
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 0
					setCel: 2
					posn: 191 216
					priority: 4
					signal: 16
					setScale: Scaler 100 53 121 83
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 8
				)
				(= ticks 10)
			)
			(1
				(theMusic3 number: 128 setLoop: -1 play:)
				(gEgo setMotion: MoveTo 191 147 self)
			)
			(2
				(theMusic3 stop:)
				(proc0_6 0)
				(gEgo setMotion: MoveTo 209 136 self)
			)
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogExits of Script
	(properties)
	
	(method (doit)
		(if (> (gEgo y?) 146)
			(elevator x: 183 y: (- (gEgo y?) 9))
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (countdown1 script?) (sShipBlow dispose:))
				(gEgo setMotion: MoveTo 191 147 self)
			)
			(1
				(theMusic3 number: 128 setLoop: -1 play:)
				(gEgo
					setPri: 4
					setCycle: 0
					setLoop: -1
					setLoop: 2
					setMotion: MoveTo 191 216 self
				)
			)
			(2
				(gSq5Music2 fade:)
				(global2 newRoom: 325)
			)
		)
	)
)

(instance sRogSitAndFry of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 446
					setLoop: -1
					setLoop: 0
					setCel: 5
					x: 86
					y: 88
					setScale: 0
					setPri: 3
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: Fwd)
				(theMusic3 number: 432 setLoop: -1 play:)
				(electric init: setCycle: RTRandCycle)
				(= seconds 5)
			)
			(2
				(theMusic3 fade:)
				(proc0_9 20)
				(self dispose:)
			)
		)
	)
)

(instance sOpenPanel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(cloakPanel setCycle: End self)
				(theMusic3 number: 431 setLoop: 1 play:)
			)
			(1
				(theMusic3 fade:)
				(global2 newRoom: 335)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lights1 of Prop
	(properties
		x 76
		y 67
		view 445
	)
)

(instance lights2 of Prop
	(properties
		x 105
		y 74
		view 445
		loop 1
	)
)

(instance lights3 of Prop
	(properties
		x 113
		y 77
		view 445
		loop 2
	)
)

(instance countdown1 of Prop
	(properties
		x 122
		y 44
		view 445
		loop 3
	)
)

(instance countdown2 of Prop
	(properties
		x 122
		y 44
		view 445
		loop 4
	)
)

(instance electric of Prop
	(properties
		x 64
		y 56
		view 446
		loop 2
	)
)

(instance elevator of Actor
	(properties
		x 183
		y 192
		noun 4
		view 445
		loop 5
		priority 4
		signal $4010
	)
)

(instance cloakPanel of Prop
	(properties
		x 236
		y 88
		noun 2
		approachX 225
		approachY 115
		view 445
		loop 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (proc0_1 212))
					(global2 setScript: sOpenPanel)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pilotArea of Feature
	(properties
		x 100
		y 70
		noun 1
		onMeCheck $0002
		approachX 80
		approachY 91
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== local0 0)
					(gTestMessager say: 1 theVerb 0 0)
					(++ local0)
				else
					(global2 setScript: sRogSitAndFry)
				)
			)
			(3
				(global2 setScript: sRogSitAndFry)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDwoot of Feature
	(properties
		x 88
		y 47
		noun 3
		onMeCheck $0040
	)
)

(instance rightDwoot of Feature
	(properties
		x 173
		y 51
		noun 5
		onMeCheck $0200
	)
)

(instance screen of Feature
	(properties
		x 125
		y 44
		noun 7
		onMeCheck $0010
	)
)

(instance viewWindow of Feature
	(properties
		x 99
		y 67
		noun 8
		onMeCheck $0400
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== local0 0)
					(gTestMessager say: 1 theVerb 0 0)
					(++ local0)
				else
					(global2 setScript: sRogSitAndFry)
				)
			)
			(3
				(global2 setScript: sRogSitAndFry)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties
		flags $0001
	)
)
