;;; Sierra Script 1.0 - (do not remove this comment)
(script# 400)
(include sci.sh)
(use Main)
(use Scaler)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm400 0
	sUseComm 20
)

(local
	[local0 2]
)
(instance rm400 of Rm
	(properties
		noun 5
		picture 81
	)
	
	(method (init)
		(proc958_0 128 451)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						0
						176
						301
						172
						301
						153
						193
						98
						168
						99
						157
						91
						144
						95
						113
						96
						79
						93
						81
						99
						95
						99
						119
						100
						99
						115
						63
						129
						33
						135
						0
						133
					yourself:
				)
		)
		(gEgo view: 0 init:)
		(theExit init:)
		(theCanister init: setOnMeCheck: 1 4)
		(theHeatwaves init:)
		(theMoon init:)
		(theRocks init: setOnMeCheck: 1 4096)
		(switch gGModNum
			(240
				(global2 style: 7 setScript: sInitRoom)
			)
			(410
				(global2 style: 12 setScript: sInitRoom)
			)
			(else 
				(global2 style: 7 setScript: sInitRoom)
			)
		)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(proc0_5 gEgo 2)
				(== global131 1)
				(not (global2 script?))
			)
			(proc0_3 100)
			(global2 newRoom: 410)
		)
		(if
		(and (proc0_5 gEgo 8) (not (global2 script?)))
			(proc0_2 100)
			(global2 newRoom: 410)
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sInitRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(sun init:)
				(dust init:)
				(dust2 init:)
				(dust3 init:)
				(switch global131
					(1
						(canCoverL init: stopUpd:)
						(canCoverR init: stopUpd:)
						(if (proc0_1 100)
							(proc0_6 0 0)
							(gEgo
								init:
								x: 79
								y: 93
								setScale: Scaler 100 48 163 99
								setMotion: MoveTo 124 101 self
							)
						else
							(proc0_6 0 0)
							(gEgo
								init:
								x: (- (gEgo x?) 320)
								y: (gEgo y?)
								setScale: Scaler 100 48 163 99
								setMotion: MoveTo 60 145 self
							)
						)
					)
					(2
						(gEgo hide: dispose:)
						(roger init: x: -40 y: 75 hide:)
						(rogblink init: hide:)
						(self setScript: sCanister self)
					)
					(else  (= cycles 1))
				)
				(= seconds 1)
			)
			(1 (= seconds 3))
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseComm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo view: 14 setLoop: 0 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 loop: 1 play:)
			)
			(1
				(gTestMessager say: 2 32 0 0 self 401)
			)
			(2 (gEgo setCycle: Beg self))
			(3
				(proc0_6 0)
				(gEgo loop: 2)
				(= seconds 1)
			)
			(4
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
				(gSq5Music2 number: 260 loop: 1 play:)
			)
			(5
				(gSq5Music1 fade:)
				(global2 newRoom: 240)
			)
		)
	)
)

(instance sCanister of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(roger show: setPri: 14 setMotion: MoveTo 0 75 self)
				(rogblink show:)
			)
			(2 (self dispose:))
		)
	)
)

(instance sExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger setMotion: MoveTo -50 75 self)
			)
			(1
				(roger hide:)
				(rogblink hide:)
				(= cycles 2)
			)
			(2 (global2 newRoom: 410))
		)
	)
)

(instance roger of Actor
	(properties
		y 75
		view 451
		loop 2
		signal $6000
		illegalBits $0000
	)
	
	(method (init)
		(super init: &rest)
		(self setLoop: 2 setCel: 0)
	)
)

(instance rogblink of Prop
	(properties
		x 36
		y 112
		view 451
		loop 3
	)
	
	(method (init)
		(super init: &rest)
		(self setLoop: 3 cycleSpeed: 100 setPri: 15 setCycle: Fwd)
	)
	
	(method (doit)
		(self x: (+ (roger x?) 36) y: 112)
		(super doit: &rest)
	)
)

(instance sun of Prop
	(properties
		x 88
		y 57
		view 451
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 0 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust of Prop
	(properties
		x 265
		y 28
		view 451
		loop 1
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust2 of Prop
	(properties
		x 253
		y 36
		view 451
		loop 1
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance dust3 of Prop
	(properties
		x 10
		y 11
		view 451
		loop 1
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance canCoverL of View
	(properties
		x 191
		y 114
		view 451
		loop 4
		cel 1
		priority 15
		signal $0010
	)
)

(instance canCoverR of View
	(properties
		x 4
		y 126
		view 451
		loop 4
		priority 15
		signal $0010
	)
)

(instance theExit of Feature
	(properties
		x 10
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (global2 setScript: sExit))
			(4 (global2 setScript: sExit))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCanister of Feature
	(properties
		x 200
		y 150
		noun 1
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== global131 2)
					(proc0_10 222 50)
					(gTestMessager say: 1 1 0 0)
				else
					(gTestMessager say: 4 1 0 0)
				)
			)
			(3
				(if (== global131 2) (gTestMessager say: 1 3 0 0))
			)
			(4
				(if (== global131 2) (gTestMessager say: 1 4 0 0))
			)
			(else  (super doVerb: &rest))
		)
	)
)

(instance theMoon of Feature
	(properties
		x 100
		y 28
		noun 3
		nsTop 9
		nsLeft 66
		nsBottom 58
		nsRight 151
	)
)

(instance theHeatwaves of Feature
	(properties
		x 100
		y 100
		noun 2
		nsTop 60
		nsLeft 91
		nsBottom 70
		nsRight 142
	)
)

(instance theRocks of Feature
	(properties
		x 160
		y 100
		noun 6
		onMeCheck $1000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager say: 6 1 0 (Random 1 3) 0)
			)
			(else  (super doVerb: &rest))
		)
	)
)
