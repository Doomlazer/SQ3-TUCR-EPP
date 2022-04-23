;;; Sierra Script 1.0 - (do not remove this comment)
(script# 122)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm122 0
)

(local
	newPolygon
)
(instance rm122 of Rm
	(properties
		picture 21
		style $800a
		horizon -20
		vanishingX 140
		vanishingY -5
	)
	
	(method (init)
		(self setRegions: 109)
		(proc958_0 128 111 112 113 108 110)
		(proc958_0 143 122)
		(if (proc0_1 1)
			(global2
				addObstacle:
					((= newPolygon (Polygon new:))
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
							129
							122
							151
							126
							141
							135
							104
							144
							71
							171
						yourself:
					)
			)
		else
			(global2
				addObstacle:
					((= newPolygon (Polygon new:))
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
		(gOldWH addToFront: closetDoor)
		(proc0_6 1)
		(gEgo setScale: Scaler 130 24 157 106 init:)
		(switch gGModNum
			(123
				(exitToSim init: addToPic:)
				(global2 setScript: (ScriptID 109 6))
			)
			(121
				(exitToSim init: addToPic:)
				(global2 setScript: (ScriptID 109 5))
			)
			(else 
				(exitToSim init:)
				(global2 setScript: sEnterFromSim)
			)
		)
		(extraPanel init: approachVerbs: 4 addToPic:)
		(if (and (proc0_1 163) (proc0_1 164))
			(closetDoor
				init:
				approachVerbs: 4
				ignoreActors: 1
				addToPic:
			)
		else
			(closetDoor
				init:
				approachVerbs: 4
				ignoreActors: 1
				stopUpd:
			)
		)
		(closetLeftEdge init: addToPic:)
		(closetRightEdge init: addToPic:)
		(ship1 init: addToPic:)
		(ship2 init: addToPic:)
		(ship3 init: addToPic:)
		(shipLight1 setCycle: Fwd init:)
		(shipLight2 setCycle: Fwd init:)
		(shipLight3 setCycle: Fwd init:)
		(guy1 setCycle: Fwd init:)
		(guy2 setCycle: Fwd init:)
		(guy4 init:)
		(guy5 init:)
		(guy6 init:)
		(guy3 init: setScript: sBayGuys)
		(if (or (proc0_1 4) (proc0_1 5))
			(closetDoor setCel: (closetDoor lastCel:))
			(closetGarbage init:)
			((global2 obstacles?) delete: newPolygon)
			(newPolygon dispose:)
			(global2
				addObstacle:
					((= newPolygon (Polygon new:))
						type: 3
						init:
							36
							189
							287
							189
							245
							153
							212
							149
							194
							133
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
							129
							122
							151
							126
							141
							135
							104
							144
							71
							171
						yourself:
					)
			)
			(if (proc0_1 5) (bucket setCel: 9 init:))
			(if (proc0_1 4) (cones setCel: 5 init:))
		)
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
				(global2 setScript: (ScriptID 109 3) 0 121)
			)
			((< (gEgo y?) 110) (global2 setScript: (ScriptID 109 4) 0 123))
		)
	)
	
	(method (dispose)
		(gOldWH delete: closetDoor)
		(super dispose: &rest)
	)
)

(instance sEnterFromSim of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setPri: 14 setHeading: 270)
				(= seconds 1)
			)
			(1
				(exitToSim setCycle: End self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(2
				(gEgo
					posn: 162 111
					setScale: Scaler 130 24 157 106
					init:
					setMotion: MoveTo 149 115 self
				)
			)
			(3
				(gEgo setPri: -1 setHeading: 180)
				(exitToSim setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(4
				(exitToSim addToPic:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGarbageFalls of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_2 3)
				(proc0_2 4)
				(proc0_2 5)
				(gEgo setMotion: MoveTo 238 140 self)
			)
			(1
				(closetDoor setCycle: End self)
				(gSq5Music2 number: 103 loop: 1 play:)
			)
			(2
				(gEgo
					view: 112
					setLoop: 1
					cel: 0
					setScale: 0
					x: 238
					y: 140
					cycleSpeed: 10
					setCycle: End self
				)
				(gSq5Music2 number: 116 setLoop: 1 play:)
				(cones init: setCycle: End)
				(bucket init: setCycle: End)
			)
			(3
				(gSq5Music2 number: 102 setLoop: 1 play:)
				(= seconds 4)
			)
			(4
				(closetGarbage init:)
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 227 142
					setCycle: End self
				)
			)
			(5
				(proc0_6 1 0)
				(gEgo
					posn: 240 142
					loop: 0
					cel: 0
					setScale: Scaler 130 24 157 106
					setMotion: MoveTo 200 142 self
				)
			)
			(6
				(gEgo setHeading: 90)
				((global2 obstacles?) delete: newPolygon)
				(newPolygon dispose:)
				(global2
					addObstacle:
						((= newPolygon (Polygon new:))
							type: 3
							init:
								36
								189
								287
								189
								245
								153
								212
								149
								194
								133
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
								129
								122
								151
								126
								141
								135
								104
								144
								71
								171
							yourself:
						)
				)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKickGarbage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(closetGarbage ignoreActors:)
				(gEgo setMotion: MoveTo 213 145 self)
			)
			(1 (gEgo setHeading: 90 self))
			(2
				(gEgo
					view: 112
					setLoop: 3
					cel: 0
					setScale: 0
					posn: 204 145
				)
				(= ticks 4)
			)
			(3 (gEgo setCycle: CT 8 1 self))
			(4
				(gEgo setCycle: End self)
				(closetGarbage setCel: 2 posn: 245 164)
				(gSq5Music2 number: 117 setLoop: 1 play:)
			)
			(5
				(closetGarbage setCel: 3 posn: 254 164)
				(gSq5Music2 number: 117 setLoop: 1 play:)
				(gEgo setCel: 8 setCycle: End self)
			)
			(6
				(closetGarbage setCel: 4 posn: 274 164)
				(gSq5Music2 number: 117 setLoop: 1 play:)
				(gEgo setCel: 8 setCycle: End self)
			)
			(7
				(closetDoor setCycle: Beg self)
				(closetGarbage dispose:)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(8
				(closetDoor addToPic:)
				(proc0_6 1)
				(gEgo
					posn: 219 143
					setHeading: 90
					setScale: Scaler 130 24 157 106
				)
				((global2 obstacles?) delete: newPolygon)
				(newPolygon dispose:)
				(global2
					addObstacle:
						((= newPolygon (Polygon new:))
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
								129
								122
								151
								126
								141
								135
								104
								144
								71
								171
							yourself:
						)
				)
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
				(guy5
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 66 94 self
				)
			)
			(2
				(guy5 setLoop: 9 setCycle: End self)
			)
			(3
				(guy5 setLoop: 10 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(4
				(guy3 setLoop: 4 setCel: 0 setMotion: MoveTo 87 112)
				(guy2 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(5
				(guy4 setLoop: 5 setCel: 0 setMotion: MoveTo 11 63)
				(= seconds (Random 2 5))
			)
			(6
				(guy6 setMotion: MoveTo 83 120)
				(guy1 setCycle: 0)
				(= seconds (Random 4 6))
			)
			(7
				(guy3 setLoop: 5 setMotion: MoveTo 1 78)
				(= seconds (Random 3 5))
			)
			(8
				(guy6 setMotion: MoveTo 4 67)
				(guy2 setCycle: 0)
				(= seconds (Random 1 3))
			)
			(9
				(guy4 setLoop: 4 setMotion: MoveTo 89 55)
				(guy1 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(10
				(= state (Random 3 5))
				(= cycles 1)
			)
		)
	)
)

(instance sPickupScrubber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 196 137 self)
			)
			(1
				(gEgo view: 19 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(bucket dispose:)
				(proc0_3 5)
				(gEgo get: 1)
				(proc0_10 164 10)
				(gTestMessager say: 1 4 0 0 self)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(proc0_6 1 0)
				(if (gEgo has: 2)
					(= next sKickGarbage)
				else
					(gSQ5 handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sPickupCones of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 189 133 self)
			)
			(1
				(gEgo view: 19 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(cones dispose:)
				(proc0_3 4)
				(gEgo get: 2)
				(proc0_10 163 10)
				(gTestMessager say: 3 4 0 0 self)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(proc0_6 1 0)
				(if (gEgo has: 1)
					(= next sKickGarbage)
				else
					(gSQ5 handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance closetGarbage of Actor
	(properties
		x 237
		y 164
		z 20
		noun 10
		view 112
		loop 4
		priority 10
		signal $5010
	)
)

(instance closetDoor of Prop
	(properties
		x 242
		y 142
		noun 2
		approachX 210
		approachY 140
		view 112
		priority 8
		signal $5010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(cond 
					((and (not (proc0_1 3)) (proc0_1 1)) (global2 setScript: sGarbageFalls))
					((== (closetDoor cel?) (closetDoor lastCel:)) (gTestMessager say: 2 4 1 0))
					(else (gTestMessager say: 2 4 0 0))
				)
			)
			(4
				(cond 
					((and (not (proc0_1 3)) (proc0_1 1)) (global2 setScript: sGarbageFalls))
					((== (closetDoor cel?) (closetDoor lastCel:)) (gTestMessager say: 2 4 1 0))
					(else (gTestMessager say: 2 4 0 0))
				)
			)
			(1
				(if (== (closetDoor cel?) (closetDoor lastCel:))
					(gTestMessager say: 2 1 1 0)
				else
					(gTestMessager say: 2 1 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of Prop
	(properties
		x 230
		y 140
		noun 1
		view 112
		loop 6
		priority 8
		signal $5010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sPickupScrubber)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cones of Prop
	(properties
		x 220
		y 134
		z 10
		noun 3
		view 112
		loop 5
		priority 8
		signal $5010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sPickupCones)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exitToSim of Prop
	(properties
		x 165
		y 112
		noun 8
		approachX 160
		approachY 108
		view 111
		priority 5
		signal $4010
	)
)

(instance guy1 of Prop
	(properties
		x 22
		y 79
		noun 9
		view 108
		loop 1
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy2 of Prop
	(properties
		x 73
		y 77
		noun 9
		view 108
		loop 2
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance guy3 of Actor
	(properties
		x 1
		y 78
		noun 9
		yStep 1
		view 108
		loop 4
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy4 of Actor
	(properties
		x 89
		y 55
		noun 9
		yStep 1
		view 108
		loop 5
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy5 of Actor
	(properties
		x 89
		y 116
		noun 9
		yStep 1
		view 108
		loop 8
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance guy6 of Actor
	(properties
		x 4
		y 67
		noun 9
		yStep 1
		view 108
		loop 11
		priority 1
		signal $6010
		detailLevel 2
		xStep 1
	)
)

(instance shipLight1 of Prop
	(properties
		x 14
		y 135
		noun 5
		view 113
		loop 7
		priority 14
		signal $6010
		cycleSpeed 12
		detailLevel 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 6)
					(gTestMessager say: 5 1 3 0)
				else
					(gTestMessager say: 5 1 4 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shipLight2 of Prop
	(properties
		x 15
		y 89
		noun 6
		view 113
		loop 8
		priority 14
		signal $6010
		cycleSpeed 9
		detailLevel 2
	)
)

(instance shipLight3 of Prop
	(properties
		x 31
		y 61
		noun 7
		view 113
		loop 9
		priority 14
		signal $6010
		detailLevel 2
	)
)

(instance ship1 of View
	(properties
		x 14
		y 131
		noun 5
		view 113
		loop 1
		signal $5000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 6)
					(gTestMessager say: 5 1 3 0)
				else
					(gTestMessager say: 5 1 4 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ship2 of View
	(properties
		x 2
		y 61
		noun 6
		view 113
		loop 1
		cel 1
		signal $5000
	)
)

(instance ship3 of View
	(properties
		x 32
		y 55
		noun 7
		view 113
		loop 1
		cel 2
		priority 5
		signal $5010
	)
)

(instance closetLeftEdge of View
	(properties
		x 242
		y 151
		noun 2
		approachX 240
		approachY 142
		view 112
		loop 8
		priority 8
		signal $5010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and (not (proc0_1 3)) (proc0_1 1))
					(global2 setScript: sGarbageFalls)
				else
					(gTestMessager say: 2 4 0 0)
				)
			)
			(1
				(if (== (closetDoor cel?) (closetDoor lastCel:))
					(gTestMessager say: 2 1 1 0)
				else
					(gTestMessager say: 2 1 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closetRightEdge of View
	(properties
		x 242
		y 151
		noun 2
		approachX 240
		approachY 142
		view 112
		loop 7
		priority 11
		signal $5010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and (not (proc0_1 3)) (proc0_1 1))
					(global2 setScript: sGarbageFalls)
				else
					(gTestMessager say: 2 4 0 0)
				)
			)
			(1
				(if (== (closetDoor cel?) (closetDoor lastCel:))
					(gTestMessager say: 2 1 1 0)
				else
					(gTestMessager say: 2 1 2 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance extraPanel of View
	(properties
		x 210
		y 99
		noun 4
		approachX 203
		approachY 128
		view 110
		loop 10
		priority 8
		signal $4010
	)
)
