;;; Sierra Script 1.0 - (do not remove this comment)
(script# 790)
(include sci.sh)
(use Main)
(use VelocityMover)
(use genetix)
(use Scaler)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm790 0
	sUseComm 20
)

(local
	local0
	theGPEventX
	theGPEventY
)
(procedure (localproc_00f0)
	(gEgo moveSpeed: 5 cycleSpeed: 7 setStep: 3 3)
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm790 of Rm
	(properties
		noun 13
		picture 116
	)
	
	(method (init)
		(proc958_0 143 number)
		(proc0_2 64)
		(self setRegions: 31)
		(if (not (proc0_1 22))
			(proc958_0 128 618 619 620 621 518 520)
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							218
							46
							197
							47
							188
							51
							164
							69
							120
							105
							69
							115
							57
							127
							52
							129
							53
							158
							190
							157
							215
							147
							210
							144
							182
							145
							148
							122
							123
							124
							105
							131
							65
							130
							86
							120
							116
							114
							119
							112
							200
							56
							214
							51
							254
							51
							255
							46
						yourself:
					)
			)
		)
		(super init:)
		(proc0_3 121)
		(computerFlashing init:)
		(if gRegister
			(computerFlashing init: setLoop: 9)
		else
			(computerFlashing init: setCycle: Fwd)
		)
		(botCageF init:)
		(otherCageF init:)
		(topCageButF init:)
		(creatureM init: setCycle: Fwd)
		(creatureL init: setScript: sWoscillate)
		(creatureR init: setCycle: Fwd)
		(steamPuff init: hide: setScript: sSteamPuff)
		(crFeatureM init:)
		(crFeatureR init:)
		(crFeatureL init:)
		(bigForceField init: setCycle: Fwd)
		(gSQ5 handsOn:)
		(theMusic3 number: 101 flags: 1 loop: -1 play:)
		(if (proc0_1 22)
			(gSq5Music2 number: 600 loop: -1 play:)
			(gSq5Music2
				setVol: (proc999_2 127 (proc999_3 30 (- (gEgo y?) 32)))
			)
			(Door1 init: stopUpd:)
			(gOldWH addToFront: self)
			(gOldWH addToFront: computerFlashing)
			(if (== gGModNum 770)
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(proc31_1 224 24)
			else
				(gSq5IconBar enable: 7)
				(proc31_1 224 124)
			)
			(gOldWH addToFront: doorLock)
			(doorLock init:)
		else
			(if (proc0_1 83)
				(fog init: setLoop: 5 setCycle: Fwd)
				(nitroDoor init: setLoop: 2 cel: 2 addToPic:)
				(if (not (proc0_1 125)) (nitro init:))
			else
				(nitroDoorBut init:)
			)
			(topCageBut init:)
			(bottomCageBut init:)
			(gOldWH addToFront: self)
			(gOldWH addToFront: Door1)
			(switch gGModNum
				(730
					(global2 setScript: sWalkIn)
				)
				(750
					(global2 setScript: sBackFromComputer)
				)
				(else 
					(global2 setScript: sWalkIn)
				)
			)
		)
	)
	
	(method (doit)
		(if (proc0_1 22)
			(gEgo setLoop: (/ (+ (gEgo heading?) 90) 180))
			(gSq5Music2
				setVol: (proc999_2 127 (proc999_3 30 (- (gEgo y?) 32)))
			)
		)
		(if (not (if script else (proc0_1 22)))
			(switch (gEgo onControl: 1)
				(64
					(global2 setScript: sUpStairs)
				)
				(32
					(global2 setScript: sDownStairs)
				)
				(1024
					(if (> (gEgo y?) 100) (global2 setScript: sToComputer))
				)
				(16384
					(global2 setScript: sUpSmallStairs)
				)
				(128
					(global2 setScript: sDownSmallStairs)
				)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(gOldWH delete: self)
		(gOldWH delete: computerFlashing)
		(gOldWH delete: doorLock)
		(gOldWH delete: Door1)
		(DisposeScript 29)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (proc0_1 22)
					(proc31_2 gPEventY)
					(gEgo setMotion: VelocityMover gPEventX gPEventY self 0)
				else
					(= theGPEventX gPEventX)
					(= theGPEventY gPEventY)
					(gEgo setMotion: PolyPath gPEventX gPEventY)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sToComputer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 518
					setLoop: 0
					cycleSpeed: 12
					setStep: 1 1
					setMotion: PolyPath 230 160 self
				)
			)
			(1
				(proc0_6 0)
				(gEgo setMotion: MoveTo 253 160 self)
			)
			(2
				(gEgo setHeading: 0)
				(= seconds 2)
			)
			(3
				(gSQ5 handsOn:)
				(global2 newRoom: 750)
			)
		)
	)
)

(instance sBackFromComputer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(Door1 init: stopUpd:)
				(proc0_6 0)
				(gEgo
					init:
					ignoreActors:
					posn: 253 160
					setMotion: MoveTo 230 160 self
					setScale: Scaler 100 70 141 123
				)
			)
			(1
				(gEgo
					view: 520
					setLoop: 1
					cycleSpeed: 12
					setStep: 1 1
					setMotion: MoveTo 211 148 self
				)
			)
			(2
				(proc0_6 0)
				(gEgo setMotion: MoveTo 187 150 self)
			)
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setCycle: 0)
				(if (gEgo looper?) ((gEgo looper?) dispose:))
				(= cycles 2)
			)
			(1
				(gEgo
					view: 520
					setLoop: 2
					setStep: 3 2
					moveSpeed: 3
					cycleSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 173 74 self
				)
			)
			(2
				(gEgo
					setScale: 0
					scaleX: 128
					scaleY: 128
					setMotion: MoveTo 215 51 self
				)
			)
			(3
				(proc0_6 0)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpSmallStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(localproc_00f0)
				(gEgo
					setLoop: -1
					view: 520
					setLoop: 2
					setHeading: 45
					setMotion: MoveFwd 27 self
				)
			)
			(1
				(proc0_6 0)
				(if (< theGPEventY 116)
					(gEgo setMotion: PolyPath theGPEventX theGPEventY)
				)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(localproc_00f0)
				(gEgo
					setLoop: -1
					view: 518
					setLoop: 1
					setMotion: MoveTo 116 107 self
				)
				(= seconds 2)
			)
			(1
				(gEgo setScale: Scaler 100 70 141 123)
			)
			(2
				(proc0_6 0)
				(if (> theGPEventY 110)
					(gEgo setMotion: PolyPath theGPEventX theGPEventY)
				)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownSmallStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					setLoop: -1
					view: 518
					setLoop: 1
					setStep: 3 4
					setHeading: 235
					setMotion: MoveFwd 22 self
				)
			)
			(1
				(proc0_6 0)
				(if (> theGPEventY 130)
					(gEgo setMotion: PolyPath theGPEventX theGPEventY)
				else
					(gEgo setMotion: MoveTo 70 138)
				)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSteamPuff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 8 20)))
			(1
				(steamPuff show: setCycle: End self)
			)
			(2
				(steamPuff hide:)
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sFlyToComputer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc31_2 145)
				(gEgo setMotion: VelocityMover 245 145 self 1)
			)
			(1
				(gSq5Music2 stop:)
				(gSQ5 handsOn:)
				(global2 newRoom: 750)
			)
		)
	)
)

(instance sWoscillate of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 15)))
			(1 (client setCycle: End self))
			(2 (= seconds (Random 4 15)))
			(3 (client setCycle: Beg self))
			(4 (= cycles 1) (= state -1))
		)
	)
)

(instance sWalkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(Door1 init: setCycle: End self)
				(theMusic4 number: 103 loop: 1 play:)
			)
			(1
				(proc0_6 0)
				(gEgo
					init:
					ignoreActors:
					posn: 274 50
					setScale: 0
					setMotion: MoveTo 224 50 self
					illegalBits: 0
				)
			)
			(2 (Door1 setCycle: Beg self))
			(3
				(Door1 stopUpd:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTornado of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo y?) 130)
					(gEgo setMotion: PolyPath 173 141 self)
					(gSQ5 handsOff:)
				else
					(gTestMessager say: 4 0 0 0)
					(self dispose:)
				)
			)
			(1
				(gEgo
					view: 619
					ignoreActors: 1
					setLoop: -1
					setCycle: 0
					posn: 173 141
					loop: 0
					init:
				)
				(= ticks 9)
			)
			(2 (gEgo setCycle: End self))
			(3 (= seconds 2))
			(4
				(topForceField init:)
				(= seconds 2)
			)
			(5
				(gSq5Music2 number: 616 loop: 1 play:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 103 137 self
				)
			)
			(7 (= seconds 1))
			(8
				(tornado init: setMotion: MoveTo 2 127 setCycle: Fwd)
				(gEgo setLoop: 2 setCycle: End self)
			)
			(9 (gEgo setCycle: End self))
			(10 (gEgo setCycle: End self))
			(11 (gEgo setCycle: End self))
			(12
				(gEgo setCycle: CT 4 1 self)
			)
			(13
				(gEgo setLoop: 3 cel: 0 setCycle: CT 4 1 self)
			)
			(14
				(gEgo setCycle: End self)
				(ShakeScreen 1)
				(theMusic3 number: 136 loop: 1 play: self)
			)
			(15
				(proc0_9 27)
				(self dispose:)
			)
		)
	)
)

(instance sBlood of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo y?) 130)
					(gEgo setMotion: PolyPath 169 141 self)
					(gSQ5 handsOff:)
				else
					(gTestMessager say: 4 0 0 0)
					(self dispose:)
				)
			)
			(1
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					setCycle: 0
					view: 620
					setLoop: 0
					cel: 0
					setPri: 7
					cycleSpeed: 12
					ignoreActors: 1
				)
				(= ticks 9)
			)
			(2 (gEgo setCycle: End self))
			(3
				(bottomForceField init:)
				(= ticks 9)
			)
			(4
				(gEgo setLoop: 1)
				(= ticks 9)
			)
			(5
				(gEgo setCycle: End self)
				(gSq5Music2 number: 228 loop: 1 play:)
			)
			(6
				(gEgo setLoop: 2 setCycle: End self)
				(gSq5Music2 number: 228 loop: 1 play:)
			)
			(7
				(gSq5Music2 number: 228 loop: 1 play:)
				(gEgo setLoop: 2 setCycle: End self)
				(blood init: setCycle: End)
			)
			(8
				(gEgo setLoop: 2 setCycle: End self)
				(blood setCycle: End)
			)
			(9
				(gEgo setMotion: MoveTo 178 141 self)
			)
			(10
				(gEgo setLoop: 2 setCycle: End self)
				(blood setCycle: End)
			)
			(11
				(gEgo setLoop: 2 setCycle: End self)
				(blood setCycle: End)
			)
			(12
				(gEgo cel: 3 setMotion: MoveTo 206 141 self)
			)
			(13
				(gEgo dispose:)
				(blood setCycle: End self)
			)
			(14
				(blood dispose:)
				(= seconds 2)
			)
			(15
				(gSq5Music2 number: 502 loop: 1 play: self)
			)
			(16 (proc0_9 27))
		)
	)
)

(instance sOpenNitroDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_2 83)
				(gEgo setMotion: PolyPath 73 117 self)
			)
			(1
				(gEgo view: 621 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(nitroDoor init: setCycle: End self)
				(theMusic4 number: 108 setLoop: 1 play:)
			)
			(3
				(fog init: setCycle: End self)
			)
			(4
				(fog setLoop: 5 setCycle: Fwd)
				(proc0_6 0)
				(gEgo setMotion: MoveTo 92 112 self)
			)
			(5
				(gEgo setHeading: 0)
				(nitro init: setPri: 1)
				(nitroDoor dispose:)
				(nitroDoorBut dispose:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveFly of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: VelocityMover 238 25 self 1)
			)
			(1 (= seconds 2))
			(2
				(gEgo dispose:)
				(gSQ5 handsOn:)
				(global2 newRoom: 770)
			)
		)
	)
)

(instance Door1 of Prop
	(properties
		x 242
		y -10
		noun 2
		view 618
		signal $5000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (< (gEgo y?) 60)
					(Door1 startUpd: setCycle: End)
					(theMusic4 number: 103 loop: 1 play:)
					(global2 setScript: (ScriptID 31 3) 0 9)
				else
					(gEgo setMotion: PolyPath 232 51)
				)
			)
			(4
				(if (< (gEgo y?) 60)
					(Door1 startUpd: setCycle: End)
					(global2 setScript: (ScriptID 31 3) 0 9)
				else
					(gTestMessager say: 4 0 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nitro of MyProp
	(properties
		x 63
		y 73
		noun 12
		onMeCheck $0800
		view 621
		loop 1
		cel 6
		priority 7
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (gEgo has: 16))
					(self loop: 2 cel: 2)
					(proc0_10 234 50)
					(gEgo get: 16)
					(proc0_2 125)
					(proc0_2 102)
				)
			)
			(1
				(if (proc0_1 82)
					(gTestMessager say: 12 1 1)
				else
					(gTestMessager say: 12 1 2)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance creatureM of MyProp
	(properties
		x 68
		y 163
		noun 6
		nsTop 155
		nsLeft 58
		nsBottom 189
		nsRight 112
		view 618
		loop 1
		cel 2
		priority 14
		signal $4010
		cycleSpeed 60
	)
)

(instance creatureR of MyProp
	(properties
		x 296
		y 107
		noun 7
		nsTop 100
		nsLeft 286
		nsBottom 162
		nsRight 319
		view 618
		loop 2
		cel 1
		priority 14
		signal $4010
		cycleSpeed 20
	)
)

(instance creatureL of MyProp
	(properties
		x 2
		y 120
		noun 5
		nsTop 110
		nsBottom 149
		nsRight 32
		view 618
		loop 3
		cel 2
		priority 14
		signal $4010
	)
)

(instance crFeatureL of MyFeature
	(properties
		x 2
		y 120
		noun 5
		nsTop 110
		nsBottom 149
		nsRight 32
	)
)

(instance crFeatureM of MyFeature
	(properties
		x 68
		y 163
		noun 6
		nsTop 155
		nsLeft 58
		nsBottom 189
		nsRight 112
	)
)

(instance crFeatureR of MyFeature
	(properties
		x 296
		y 107
		noun 7
		nsTop 100
		nsLeft 286
		nsBottom 162
		nsRight 319
	)
)

(instance doorF of MyFeature
	(properties
		x 255
		y 22
		noun 2
		nsLeft 248
		nsBottom 45
		nsRight 265
	)
)

(instance topCageButF of MyFeature
	(properties
		x 192
		y 89
		noun 15
		nsTop 85
		nsLeft 181
		nsBottom 99
		nsRight 196
		onMeCheck $0100
	)
)

(instance botCageF of MyFeature
	(properties
		x 190
		y 110
		noun 1
		nsTop 103
		nsLeft 181
		nsBottom 119
		nsRight 197
		onMeCheck $0100
	)
)

(instance otherCageF of MyFeature
	(properties
		x 140
		y 111
		noun 3
		nsTop 89
		nsLeft 158
		nsBottom 114
		nsRight 180
		onMeCheck $0100
	)
)

(instance nitroDoorBut of MyFeature
	(properties
		x 57
		y 89
		onMeCheck $0004
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(if (& (= temp0 (gEgo onControl: 1)) $0010)
					(global2 setScript: sOpenNitroDoor)
				else
					(gTestMessager say: 4 0 0 0)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance doorLock of MyFeature
	(properties
		x 238
		y 25
		noun 14
		onMeCheck $0008
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(global2 setScript: sLeaveFly)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance topCageBut of MyFeature
	(properties
		x 257
		y 100
		onMeCheck $1000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (> (gEgo y?) 70)
					(global2 setScript: sTornado)
				else
					(gTestMessager say: 4 0 0 0)
				)
			)
			(3
				(if (< (gEgo y?) 60) (global2 setScript: sTornado))
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance bottomCageBut of MyFeature
	(properties
		x 257
		y 120
		onMeCheck $0200
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 setScript: sBlood))
			(3
				(global2 setScript: sTornado)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance steamPuff of MyProp
	(properties
		x 113
		y -6
		view 618
		loop 5
	)
)

(instance computerFlashing of MyProp
	(properties
		x 243
		y 141
		noun 16
		onMeCheck $0002
		view 618
		loop 6
		cycleSpeed 20
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (not (global2 script?))
					(global2 setScript: sFlyToComputer)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance nitroDoor of MyActor
	(properties
		x 63
		y 73
		noun 8
		view 621
		loop 1
		cel 1
		signal $4000
	)
)

(instance bigForceField of MyActor
	(properties
		x 156
		y 83
		view 618
		loop 4
		cel 1
		signal $4000
	)
)

(instance tornado of MyActor
	(properties
		x 103
		y 137
		view 619
		loop 4
		signal $0800
	)
)

(instance blood of MyProp
	(properties
		x 187
		y 110
		view 620
		loop 3
		cel 6
		priority 15
		signal $0010
	)
)

(instance topForceField of View
	(properties
		x 179
		y 84
		view 618
		loop 7
		priority 6
		signal $0010
	)
)

(instance bottomForceField of View
	(properties
		x 184
		y 103
		view 618
		loop 8
	)
)

(instance fog of MyProp
	(properties
		x 67
		y 98
		noun 11
		view 621
		loop 4
	)
)

(instance sUseComm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 setLoop: 1 play:)
			)
			(1 (= seconds 2))
			(2
				(gTestMessager say: 17 0 0 0 self)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(proc0_6 0)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)
