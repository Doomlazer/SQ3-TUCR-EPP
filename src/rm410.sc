;;; Sierra Script 1.0 - (do not remove this comment)
(script# 410)
(include sci.sh)
(use Main)
(use PAvoider)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Grooper)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm410 0
	sUseComm 20
)

(local
	local0
	[local1 3]
)
(instance theMusic3 of Sound
	(properties)
)

(instance rm410 of Rm
	(properties
		noun 12
		picture 80
	)
	
	(method (init)
		(proc958_0 128 450 0 2)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						291
						101
						290
						98
						264
						98
						236
						104
						211
						113
						232
						127
						260
						139
						219
						142
						142
						141
						124
						144
						124
						141
						124
						138
						165
						134
						177
						128
						154
						125
						146
						119
						161
						114
						173
						112
						191
						113
						200
						106
						169
						106
						157
						109
						155
						112
						98
						119
						78
						119
						78
						127
						39
						131
						0
						133
						0
						137
						115
						137
						114
						144
						62
						149
						3
						160
						61
						162
						222
						152
						262
						174
						319
						176
						319
						132
						265
						132
						255
						131
						238
						125
						232
						119
						241
						112
						258
						105
						290
						102
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 130 121 132 128 104 128 111 121
					yourself:
				)
		)
		(theOffPath init:)
		(theGreenhouse init: setOnMeCheck: 1 32)
		(theBuilding1 init:)
		(theBuilding2 init:)
		(theBuilding3 init:)
		(theBuilding4 init:)
		(theLandingPad init:)
		(theMoon init:)
		(theTools init: setOnMeCheck: 1 128)
		(theRocks init: setOnMeCheck: 1 4096)
		(super init: &rest)
		(gOldWH addToFront: theGreenhouse)
		(gEgo view: 0)
		(switch gGModNum
			(400
				(global2 style: 11 setScript: sRoomInit)
			)
			(420
				(gSq5Music2 setVol: 127)
				(global2 style: 10 setScript: sRoomInit)
				(if (proc0_1 101)
					(proc0_3 101)
					(proc0_6 0 2)
					(gEgo init: setScale: Scaler 34 34 163 99 x: 92 y: 120)
				else
					(proc0_6 0 2)
					(gEgo init: setScale: Scaler 34 34 163 99 x: 123 y: 118)
				)
			)
			(else 
				(= local0 1)
				(proc958_0 128 500 30 0)
				(global2 style: 10 setScript: sBeamIn)
			)
		)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(if
		(and (proc0_5 gEgo 4) (not (global2 script?)))
			(= global131 2)
			(global2 newRoom: 400)
		)
		(if
		(and (proc0_5 gEgo 2) (not (global2 script?)))
			(gSQ5 handsOff:)
			(global2 newRoom: 400)
		)
		(if
		(and (proc0_5 gEgo 256) (not (global2 script?)))
			(proc0_2 100)
			(global2 newRoom: 400)
		)
		(if
		(and (proc0_5 gEgo 8) (not (global2 script?)))
			(switch global131
				(0
					(global2 setScript: sGotoTop)
				)
				(1
					(global2 setScript: sGotoBottom)
				)
			)
		)
	)
	
	(method (dispose)
		(gOldWH delete: theGreenhouse)
		(super dispose: &rest)
	)
)

(instance sRoomInit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(heat init:)
				(heat2 init:)
				(heat3 init:)
				(metal init:)
				(plastic init:)
				(tumweed init: setScript: sTumbleweed)
				(if (== local0 0)
					(switch global131
						(0
							(proc0_6 0 2)
							(gEgo init: setScale: Scaler 100 48 163 99 x: 123 y: 118)
							(= cycles 1)
						)
						(1
							(if (proc0_1 100)
								(proc0_6 0 1)
								(gEgo
									init:
									setScale: Scaler 100 48 163 99
									x: 325
									y: 101
									setPri: -1
									setMotion: MoveTo 257 100 self
								)
								(proc0_3 100)
							else
								(proc0_6 0 1)
								(gEgo
									init:
									setScale: Scaler 100 48 163 99
									x: (+ (gEgo x?) 320)
									y: (gEgo y?)
									setPri: -1
									setMotion: MoveTo 278 150 self
								)
							)
						)
						(2
							(= global131 1)
							(proc0_6 0 1)
							(gEgo
								init:
								setScale: Scaler 100 48 163 99
								x: 0
								y: 155
								setMotion: MoveTo 50 155 self
							)
						)
						(else  (= cycles 1))
					)
				else
					(= cycles 5)
				)
			)
			(1 (= seconds 2))
			(2
				(if (!= client sBeamIn) (gSQ5 handsOn:))
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
				(theMusic3 number: 603 loop: 1 play:)
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
				(theMusic3 number: 260 loop: 1 play:)
			)
			(5
				(gSq5Music1 fade:)
				(global2 newRoom: 240)
			)
		)
	)
)

(instance sGotoBottom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setLoop: 3 setPri: 8 setMotion: MoveTo 125 188 self)
			)
			(1
				(proc0_6 0)
				(gEgo
					setPri: 8
					setScale: Scaler 34 34 163 99
					setMotion: MoveTo 105 136 self
				)
			)
			(2
				(gEgo setPri: -1)
				(= global131 0)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGotoTop of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setPri: 8 loop: 2 setMotion: MoveTo 125 170 self)
			)
			(1
				(gEgo
					hide:
					setPri: 8
					setScale: Scaler 100 48 163 99
					setCycle: 0
					setLoop: -1
				)
				(= seconds 2)
			)
			(2
				(gEgo
					show:
					view: 0
					x: 138
					y: 188
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 131 149 self
				)
			)
			(3
				(proc0_6 0)
				(gEgo setPri: -1 setHeading: 180)
				(= cycles 2)
			)
			(4
				(= global131 1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBeamIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 30 loop: -1 play: 0 fade: 127 25 10 0)
				(gSq5Music2 number: 450 loop: -1 play:)
				(= global131 1)
				(self setScript: sRoomInit self)
			)
			(1
				(proc0_10 218 5)
				(if (not (proc0_1 76))
					(droole init: setScript: sDrooleBeamIn)
					(self setScript: sDrooleBeamIn self)
				else
					(= cycles 1)
				)
				(gEgo
					init:
					view: 500
					setLoop: 0
					cel: 0
					x: 230
					y: 122
					setScale: Scaler 100 48 163 99
					setCycle: End self
				)
				(theMusic3 number: 260 setLoop: 1 play:)
			)
			(2 0)
			(3
				(proc0_6 0 1)
				(gEgo x: 230 y: 122 setPri: -1 setAvoider: PAvoider)
				(= seconds 3)
			)
			(4
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrooleBeamIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2 76)
				(proc0_2 97)
				(= cycles 1)
			)
			(1
				(droole
					init:
					view: 500
					setLoop: 3
					cel: 0
					x: 225
					y: 112
					setScale: Scaler 100 48 163 99
					setCycle: End self
				)
			)
			(2 (= seconds 3))
			(3
				(gTestMessager say: 1 0 0 0 self)
			)
			(4
				(droole
					view: 30
					x: 225
					y: 112
					setCycle: Walk
					setLoop: Grooper
					setHeading: 90
					loop: 0
					setMotion: MoveTo 250 110 self
				)
			)
			(5
				(droole setMotion: MoveTo 299 120 self)
			)
			(6
				(proc0_2 76)
				(proc0_2 97)
				(droole dispose:)
				(= cycles 1)
			)
			(7 (self dispose:))
		)
	)
)

(instance sGreenhouse of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (== global131 1)
					(gEgo setMotion: PolyPath 124 141 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== global131 1)
					(self setScript: sGotoBottom self)
				else
					(= cycles 1)
				)
			)
			(2
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 123 118 self)
			)
			(3 (gEgo setHeading: 0 self))
			(4 (global2 newRoom: 420))
		)
	)
)

(instance sTumbleweed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gSQ5 detailLevel:) (tumweed detailLevel:))
					(tumweed stopUpd:)
					(-- state)
				)
				(= seconds (Random 5 15))
			)
			(1
				(tumweed
					x: 330
					y: 115
					setPri: 10
					setLoop: 4
					setCycle: Fwd
					cycleSpeed: 8
					setMotion: MoveTo 293 129 self
				)
			)
			(2
				(tumweed setMotion: MoveTo 266 126 self)
			)
			(3
				(tumweed setMotion: MoveTo 245 136 self)
			)
			(4
				(tumweed setMotion: MoveTo 222 144 self)
			)
			(5
				(tumweed setMotion: MoveTo 195 135 self)
			)
			(6
				(tumweed setMotion: MoveTo 168 130 self)
			)
			(7
				(tumweed setMotion: MoveTo 144 139 self)
			)
			(8
				(tumweed setMotion: MoveTo 121 145 self)
			)
			(9
				(tumweed setMotion: MoveTo 30 149 self)
			)
			(10 (= state -1) (= cycles 2))
		)
	)
)

(instance droole of Actor
	(properties
		x 225
		y 112
		view 30
		loop 8
		cel 1
	)
)

(instance skyline of Prop
	(properties
		x 194
		y 61
		view 450
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 0 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat of Prop
	(properties
		x 129
		y 81
		view 450
		loop 1
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat2 of Prop
	(properties
		x 156
		y 81
		view 450
		loop 2
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 2 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance heat3 of Prop
	(properties
		x 206
		y 81
		view 450
		loop 3
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 3 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance metal of Prop
	(properties
		x 89
		y 55
		view 450
		loop 5
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 5 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance plastic of Prop
	(properties
		x 111
		y 101
		view 450
		loop 6
		detailLevel 2
	)
	
	(method (init)
		(self setLoop: 6 setCycle: Fwd cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance tumweed of Actor
	(properties
		x 330
		y 115
		noun 15
		view 450
		loop 4
		priority 14
		signal $6000
		detailLevel 2
		illegalBits $0000
	)
	
	(method (init)
		(self
			x: 330
			y: 115
			setPri: 10
			setLoop: 4
			setCycle: Fwd
			cycleSpeed: 8
		)
		(super init: &rest)
	)
)

(instance theGreenhouse of Feature
	(properties
		x 123
		y 113
		noun 7
		onMeCheck $0020
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(global2 setScript: sGreenhouse)
			)
			(4
				(global2 setScript: sGreenhouse)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theOffPath of Feature
	(properties
		x 100
		y 25
		nsBottom 109
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== global131 0) (gTestMessager say: 10 1 0 0))
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBuilding1 of Feature
	(properties
		x 24
		y 100
		noun 2
		nsTop 101
		nsLeft 24
		nsBottom 121
		nsRight 63
	)
)

(instance theBuilding2 of Feature
	(properties
		y 28
		noun 3
		nsTop 78
		nsLeft 187
		nsBottom 104
		nsRight 210
	)
)

(instance theBuilding3 of Feature
	(properties
		y 28
		noun 4
		nsTop 84
		nsLeft 148
		nsBottom 105
		nsRight 166
	)
)

(instance theBuilding4 of Feature
	(properties
		y 28
		noun 5
		nsTop 64
		nsLeft 13
		nsBottom 84
		nsRight 32
	)
)

(instance theLandingPad of Feature
	(properties
		y 28
		noun 8
		nsTop 108
		nsLeft 155
		nsBottom 123
		nsRight 190
	)
)

(instance theMoon of Feature
	(properties
		y 28
		noun 9
		nsTop 12
		nsLeft 167
		nsBottom 79
		nsRight 245
	)
)

(instance theTools of Feature
	(properties
		y 28
		noun 14
		onMeCheck $0080
	)
)

(instance theRocks of Feature
	(properties
		x 160
		y 200
		noun 16
		onMeCheck $1000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager say: 16 1 0 (Random 1 3) 0)
			)
			(else  (super doVerb: &rest))
		)
	)
)
