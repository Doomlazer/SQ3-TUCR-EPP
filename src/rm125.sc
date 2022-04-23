;;; Sierra Script 1.0 - (do not remove this comment)
(script# 125)
(include sci.sh)
(use Main)
(use Blink)
(use Scaler)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm125 0
	daveTalker 1
	rogTalker 15
)

(instance rm125 of Rm
	(properties
		picture 21
		style $800a
		horizon -20
		vanishingX 140
		vanishingY -5
	)
	
	(method (init)
		(self setRegions: 109)
		(proc958_0 128 113 108 110 127)
		(proc958_0 143 125)
		(if (proc0_1 1)
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							287
							189
							245
							153
							219
							134
							186
							120
							157
							109
							143
							105
							136
							104
							137
							108
							133
							115
							117
							130
							138
							133
							130
							155
							92
							157
							53
							189
						yourself:
					)
			)
		else
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							36
							189
							287
							189
							245
							153
							219
							134
							186
							120
							157
							109
							143
							105
							136
							104
							137
							108
							133
							115
							104
							144
							71
							171
						yourself:
					)
			)
		)
		(super init:)
		(proc0_6 1)
		(switch gGModNum
			(123
				(gEgo setScale: Scaler 130 24 157 106 init:)
				(global2 setScript: (ScriptID 109 5))
			)
			(127
				(cadetDave setScale: Scaler 124 24 159 106 init:)
				(global2 setScript: sLeaveConfRoom)
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init: 144 120 159 120 166 124 162 129 147 129 142 125
							yourself:
						)
				)
			)
			(else 
				(gEgo setScale: Scaler 130 24 157 106 init:)
				(self setScript: (ScriptID 109 6))
			)
		)
		(confDoor init: stopUpd:)
		(confWindow init: setOnMeCheck: 26505)
		(doorFrameLeft init: addToPic:)
		(doorFrameRight init: addToPic:)
		(ship1 addToPic:)
		(ship2 addToPic:)
		(ship3 addToPic:)
		(shipLight1 setCycle: Fwd init:)
		(shipLight2 setCycle: Fwd init:)
		(shipLight3 init: setScript: sShipLights)
		(extraPanel addToPic:)
		(guy1 setCycle: Fwd init:)
		(guy2 setCycle: Fwd init:)
		(guy3 setCycle: Fwd init:)
		(guy4 init:)
		(guy5 init:)
		(guy6 init:)
		(guy7 init: setScript: sBayGuys)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script 0)
			(
				(and
					(> (gEgo y?) 157)
					(< 90 (gEgo heading?))
					(< (gEgo heading?) 270)
				)
				(global2 setScript: (ScriptID 109 3) 0 123)
			)
			((< (gEgo y?) 110) (global2 setScript: (ScriptID 109 4) 0 121))
		)
	)
)

(instance sLeaveConfRoom of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (< (gEgo x?) 204) (gEgo setPri: -1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 2)
			)
			(1
				(if (proc0_1 161)
					(gTestMessager say: 5 0 0 1 self 109)
				else
					(= cycles 1)
				)
			)
			(2
				(confDoor setCycle: End self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(3
				(if (proc0_1 161)
					(gTestMessager say: 5 0 0 2 self 109)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo
					setPri: 8
					posn: 229 121
					setScale: Scaler 130 24 157 106
					init:
					setMotion: MoveTo 187 129 self
				)
			)
			(5
				(confDoor setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(6
				(confDoor stopUpd:)
				(cadetDave setCycle: End self)
			)
			(7
				(gTestMessager say: 2 0 0 0 self)
			)
			(8
				(cadetDave setCycle: Beg self)
			)
			(9
				(gEgo setPri: -1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBayGuys of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 7)))
			(1
				(guy7
					setLoop: 11
					setCycle: Fwd
					setMotion: MoveTo 24 119 self
				)
			)
			(2
				(guy7 setLoop: 12 setCycle: End self)
			)
			(3
				(guy7 setLoop: 13 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(4
				(guy4 setMotion: MoveTo 0 103)
				(guy1 setCycle: 0)
				(= seconds (Random 4 7))
			)
			(5
				(guy5 setLoop: 4 setCel: 0 setMotion: MoveTo 97 87)
				(guy2 setCycle: 0)
				(guy3 setCycle: 0)
				(= seconds (Random 4 6))
			)
			(6
				(guy6 setLoop: 5 setCel: 0 setMotion: MoveTo 0 118)
				(guy1 setCycle: Fwd)
				(= seconds (Random 5 7))
			)
			(7
				(guy5 setLoop: 5 setMotion: MoveTo 0 80)
				(guy3 setCycle: Fwd)
				(= seconds (Random 3 5))
			)
			(8
				(guy4 setMotion: MoveTo 96 92)
				(guy2 setCycle: Fwd)
				(= seconds (Random 4 6))
			)
			(9
				(guy6 setLoop: 4 setMotion: MoveTo 111 108)
				(= seconds (Random 4 7))
			)
			(10
				(= state (Random 3 5))
				(= cycles 1)
			)
		)
	)
)

(instance sShipLights of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(shipLight4 init: hide:)
				(shipLight5 init: hide:)
				(shipLight6 init: hide:)
				(= cycles 1)
			)
			(1
				(shipLight3 hide:)
				(shipLight4 show:)
				(= ticks 120)
			)
			(2
				(shipLight4 hide:)
				(shipLight5 show:)
				(= ticks 120)
			)
			(3
				(shipLight5 hide:)
				(shipLight6 show:)
				(= ticks 120)
			)
			(4
				(shipLight6 hide:)
				(shipLight3 show:)
				(= ticks 120)
			)
			(5 (= state 0) (= cycles 1))
		)
	)
)

(instance confDoor of Prop
	(properties
		x 215
		y 83
		noun 3
		view 110
		loop 7
		priority 8
		signal $4010
	)
)

(instance cadetDave of Prop
	(properties
		x 153
		y 125
		noun 1
		view 127
		signal $4000
	)
)

(instance guy1 of Prop
	(properties
		x 30
		y 77
		noun 9
		view 108
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy2 of Prop
	(properties
		x 4
		y 56
		noun 9
		view 108
		loop 7
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy3 of Prop
	(properties
		x 56
		y 103
		noun 9
		view 108
		loop 2
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy4 of Actor
	(properties
		x 96
		y 92
		noun 9
		yStep 1
		view 108
		loop 8
		priority 2
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy5 of Actor
	(properties
		y 80
		noun 9
		yStep 1
		view 108
		loop 4
		priority 2
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy6 of Actor
	(properties
		x 111
		y 108
		noun 9
		yStep 1
		view 108
		loop 5
		priority 2
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy7 of Actor
	(properties
		y 127
		noun 9
		yStep 1
		view 108
		loop 11
		priority 2
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance shipLight1 of Prop
	(properties
		x 5
		y 142
		noun 7
		view 113
		loop 14
		priority 14
		signal $6010
		cycleSpeed 12
		detailLevel 2
	)
)

(instance shipLight2 of Prop
	(properties
		x 66
		y 77
		noun 8
		view 113
		loop 15
		priority 14
		signal $6010
		cycleSpeed 9
		detailLevel 2
	)
)

(instance shipLight3 of Prop
	(properties
		x 59
		y 124
		noun 6
		view 113
		loop 13
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance shipLight4 of Prop
	(properties
		x 37
		y 113
		noun 6
		view 113
		loop 13
		cel 1
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance shipLight5 of Prop
	(properties
		x 9
		y 88
		noun 6
		view 113
		loop 13
		cel 2
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance shipLight6 of Prop
	(properties
		x 4
		y 71
		noun 6
		view 113
		loop 13
		cel 3
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance daveMouth of Prop
	(properties
		view 127
		loop 3
	)
)

(instance daveTalker of Talker
	(properties
		x 100
		y 80
		view 127
		loop 2
		talkWidth 90
		textX 10
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(= talkWidth (proc0_12 150 150 150 150 90))
		(gSq5Win tailX: 152 tailY: 75 xOffset: 0)
		(super init: 0 0 daveMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance rogMouth of Prop
	(properties
		view 127
		loop 3
	)
)

(instance rogTalker of Talker
	(properties
		x 100
		y 80
		view 127
		loop 2
		talkWidth 130
		textX 30
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 182
			tailY: 85
			xOffset: 0
		)
		(super init: 0 0 rogMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance doorFrameLeft of View
	(properties
		x 215
		y 83
		noun 3
		view 110
		priority 8
		signal $4010
	)
)

(instance doorFrameRight of View
	(properties
		x 215
		y 83
		noun 3
		view 110
		loop 6
		priority 9
		signal $4010
	)
)

(instance ship1 of View
	(properties
		x 2
		y 67
		noun 6
		view 113
		loop 3
		signal $5000
	)
)

(instance ship2 of View
	(properties
		x 12
		y 136
		noun 7
		view 113
		loop 3
		cel 1
		signal $5000
	)
)

(instance ship3 of View
	(properties
		x 64
		y 72
		noun 8
		view 113
		loop 3
		cel 2
		priority 5
		signal $5010
	)
)

(instance extraPanel of View
	(properties
		x 274
		y 91
		noun 5
		view 110
		loop 8
		priority 14
		signal $4010
	)
)

(instance confWindow of Feature
	(properties
		x 240
		y 117
		noun 4
		nsTop 87
		nsLeft 231
		nsBottom 117
		nsRight 249
	)
)
