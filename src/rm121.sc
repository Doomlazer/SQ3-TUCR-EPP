;;; Sierra Script 1.0 - (do not remove this comment)
(script# 121)
(include sci.sh)
(use Main)
(use Scaler)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm121 0
)

(instance rm121 of Rm
	(properties
		picture 21
		style $800a
		horizon -20
		vanishingX 140
		vanishingY -5
	)
	
	(method (init)
		(self setRegions: 109)
		(if (proc0_1 1)
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							72
							189
							285
							189
							243
							154
							212
							131
							162
							110
							176
							109
							176
							108
							154
							108
							143
							106
							136
							105
							137
							111
							126
							123
							124
							130
							141
							132
							137
							148
							126
							152
							97
							155
						yourself:
					)
			)
		else
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							51
							189
							285
							189
							243
							154
							212
							131
							162
							110
							176
							109
							176
							108
							154
							108
							143
							106
							136
							105
							137
							111
							126
							123
							93
							155
						yourself:
					)
			)
		)
		(proc958_0 128 140 108 113 110)
		(proc958_0 143 121)
		(super init:)
		(proc0_6 1)
		(gEgo setScale: Scaler 130 24 157 106 init:)
		(switch gGModNum
			(125
				(global2 setScript: (ScriptID 109 5))
				(if (not (proc0_1 107))
					(darth init: setScript: sStarWars)
				)
			)
			(117
				(if (and (proc0_1 6) (not (proc0_1 7)))
					(gEgo setScript: sMouseRun)
				)
				(gEgo posn: 178 108 hide:)
				(global2 setScript: sEnterFromHallway)
			)
			(else 
				(global2 setScript: (ScriptID 109 6))
			)
		)
		(exitToCrest init: approachVerbs: 3 4 addToPic:)
		(extraPanel init: addToPic:)
		(ratHole init: setOnMeCheck: 26505)
		(ship1 init: addToPic:)
		(ship2 init: addToPic:)
		(ship3 init: addToPic:)
		(shipLight1 setCycle: Fwd init:)
		(shipLight2 setCycle: Fwd init:)
		(shipLight3 setCycle: Fwd init:)
		(guy1 setCycle: Fwd init:)
		(guy2 setCycle: Fwd init:)
		(guy3 setCycle: Fwd init:)
		(guy4 init:)
		(guy5 init:)
		(guy6 init:)
		(guy7 init: setScript: sBayGuys)
		(gOldWH addToFront: exitToCrest)
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
				(global2 setScript: (ScriptID 109 3) 0 125)
			)
			(
			(and (proc0_5 gEgo 8192) (< (gEgo heading?) 180)) (global2 setScript: sExitToCrest))
			((< (gEgo y?) 108) (global2 setScript: (ScriptID 109 4) 0 122))
		)
	)
	
	(method (dispose)
		(gOldWH delete: exitToCrest)
		(super dispose: &rest)
	)
)

(instance sStarWars of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(darth
					setLoop: -1
					setLoop: 1
					setMotion: MoveTo (+ (darth x?) 42) (darth y?) self
				)
			)
			(2 (= seconds 5))
			(3
				(proc0_2 107)
				(darth dispose:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToCrest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 168 108 self)
			)
			(1
				(gEgo setMotion: MoveTo 178 108 self)
			)
			(2 (global2 newRoom: 117))
		)
	)
)

(instance sMouseRun of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo loop: 3 posn: 160 160 setMotion: MoveTo 160 145)
				(gSq5Music2 number: 141 setLoop: -1 play:)
				(mouse
					init:
					setCycle: Fwd
					setStep: 13 13
					moveSpeed: 0
					cycleSpeed: 0
					setMotion: MoveTo 262 179 self
				)
			)
			(1
				(gSq5Music2 stop:)
				(mouse setLoop: 1 setCel: 0 setCycle: 0)
				(= seconds 2)
			)
			(2 (mouse setCycle: End self))
			(3
				(gSQ5 handsOn:)
				(global2 newRoom: 133)
			)
		)
	)
)

(instance sEnterFromHallway of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= ticks 10)
			)
			(1
				(gEgo show: posn: 178 108 setMotion: MoveTo 150 108 self)
			)
			(2
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
					setMotion: MoveTo 42 94 self
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
				(guy4 setLoop: 8 setCycle: Fwd setMotion: MoveTo 0 89)
				(guy1 setCycle: 0)
				(= seconds (Random 4 7))
			)
			(5
				(guy5 setLoop: 4 setCel: 0 setMotion: MoveTo 50 99)
				(guy2 setCycle: 0)
				(= seconds (Random 4 7))
			)
			(6
				(guy6 setLoop: 5 setCel: 0 setMotion: MoveTo 3 136)
				(= seconds (Random 4 7))
			)
			(7
				(guy5 setLoop: 5 setMotion: MoveTo 0 82)
				(guy3 setCycle: 0)
				(guy1 setCycle: Fwd)
				(= seconds (Random 3 5))
			)
			(8
				(guy4 setMotion: MoveTo 57 39)
				(= seconds (Random 4 7))
			)
			(9
				(guy6 setLoop: 4 setMotion: MoveTo 29 136)
				(guy2 setCycle: Fwd)
				(guy3 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(10
				(= state (Random 3 5))
				(= cycles 1)
			)
		)
	)
)

(instance mouse of Actor
	(properties
		x 196
		y 119
		noun 2
		view 140
		scaleSignal $0001
	)
	
	(method (init)
		(super init: &rest)
		(self setScale: Scaler 100 25 179 116)
	)
)

(instance guy1 of Prop
	(properties
		x 87
		y 86
		noun 8
		view 108
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy2 of Prop
	(properties
		x 47
		y 136
		noun 8
		view 108
		loop 2
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy3 of Prop
	(properties
		x 66
		y 82
		noun 8
		view 108
		loop 7
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy4 of Actor
	(properties
		x 57
		y 39
		noun 8
		yStep 1
		view 108
		loop 8
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy5 of Actor
	(properties
		y 82
		noun 8
		yStep 1
		view 108
		loop 4
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy6 of Actor
	(properties
		x 29
		y 136
		noun 8
		yStep 1
		view 108
		loop 5
		priority 7
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy7 of Actor
	(properties
		x -5
		y 79
		noun 8
		yStep 1
		view 108
		loop 11
		priority 13
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance shipLight1 of Prop
	(properties
		x 63
		y 70
		noun 5
		view 113
		loop 4
		priority 14
		signal $6010
		cycleSpeed 12
		detailLevel 2
	)
)

(instance shipLight2 of Prop
	(properties
		x 10
		y 68
		noun 6
		view 113
		loop 5
		priority 14
		signal $6010
		cycleSpeed 9
		detailLevel 2
	)
)

(instance shipLight3 of Prop
	(properties
		x 21
		y 124
		noun 7
		view 113
		loop 6
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance darth of Actor
	(properties
		x 141
		y 108
		view 144
		loop 1
		priority 6
		signal $6010
		xStep 2
	)
	
	(method (init)
		(obiwan init: setCycle: RTRandCycle)
		(super init:)
		(self setCycle: RTRandCycle)
	)
)

(instance obiwan of Prop
	(properties
		view 144
		priority 6
		signal $6010
	)
	
	(method (doit)
		(self x: (+ (darth x?) 30) y: (+ (darth y?) 2))
		(if (> (self x?) 187) (self dispose:))
		(super doit:)
	)
)

(instance ship1 of View
	(properties
		x 43
		y 56
		noun 5
		view 113
		signal $5000
	)
)

(instance ship2 of View
	(properties
		x 9
		y 67
		noun 6
		view 113
		cel 1
		signal $5000
	)
)

(instance ship3 of View
	(properties
		x 2
		y 118
		noun 7
		view 113
		cel 2
		signal $5000
	)
)

(instance exitToCrest of View
	(properties
		x 165
		y 113
		noun 4
		approachX 170
		approachY 110
		view 110
		loop 1
		priority 5
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(global2 setScript: sExitToCrest)
			)
			(4
				(global2 setScript: sExitToCrest)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance extraPanel of View
	(properties
		x 245
		y 135
		noun 1
		view 110
		loop 11
		priority 14
		signal $4000
	)
)

(instance ratHole of Feature
	(properties
		noun 3
		nsTop 158
		nsLeft 278
		nsBottom 168
		nsRight 289
	)
)
