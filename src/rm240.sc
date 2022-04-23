;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include sci.sh)
(use Main)
(use AnimDialog)
(use eureka)
(use Blink)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use StopWalk)
(use Grooper)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm240 0
	proc240_1 1
	bea 2
	getOffPad 3
	getOnPad 4
	chamber 5
	proc240_6 6
	proc240_7 7
	spike 8
	openTank 9
	beaTalker 10
	tkrCliffy 11
	tkrRoger 15
	bubbles 20
	cliffy 21
	northDoor 22
	bang 23
	tankTop 24
	proc240_25 25
	proc240_26 26
	tank 27
	proc240_28 28
	proc240_29 29
	proc240_30 30
)

(local
	[local0 20] = [20 123 148 85 154 30 135 140 164 144 189 123 123 123 123 13 120 141 73 145]
	[local20 24] = [111 134 180 4 110 135 115 133 79 138 90 0 104 136 109 135 155 139 270 1 131 137 126 136]
	[local44 24] = [5 113 135 3 116 133 111 125 2 94 139 1 70 141 38 142 3 139 139 0 164 141 180 141]
	[local68 6] = [112 133 106 135 123 136]
	local74
	theRegister
	theGPEventX
	theGPEventY
	local78
	local79
	local80
	local81
	[local82 4]
)
(procedure (proc240_1 param1)
	(if argc (= local74 param1))
	(return local74)
)

(procedure (proc240_6 theTheGPEventX theTheGPEventY)
	(= theGPEventX theTheGPEventX)
	(= theGPEventY theTheGPEventY)
)

(procedure (proc240_7 param1)
	(if argc (= local81 param1))
	(return local81)
)

(procedure (proc240_25 param1)
	(if argc (= local79 param1))
	(return local79)
)

(procedure (proc240_26 param1)
	(if argc (= local80 param1))
	(return local80)
)

(procedure (proc240_28 param1)
	(cliffy
		view: 20
		setLoop: -1
		loop: (if argc param1 else (cliffy loop?))
		setScript: 0
		setCycle: StopWalk -1
		setLoop: Grooper
		setScale: Scaler 116 71 149 123
		setStep: 2 2
		setPri: -1
		cycleSpeed: 6
		moveSpeed: 6
		detailLevel: 0
	)
)

(procedure (proc240_29 param1)
	(spike
		view: 242
		setLoop: -1
		loop: (if argc param1 else (spike loop?))
		setScript: 0
		setCycle: Walk
		setScale: Scaler 85 50 144 122
		setPri: -1
		detailLevel: 0
	)
)

(procedure (proc240_30)
	(cond 
		((proc0_1 61)
			(if (!= (gSq5Music1 number?) 20)
				(gSq5Music1 number: 20 loop: -1 play:)
			)
		)
		((proc0_1 84)
			(if (!= (gSq5Music1 number?) 42)
				(gSq5Music1 number: 42 loop: -1 play:)
			)
		)
		(else (gSq5Music1 number: 101 loop: -1 play: 90))
	)
)

(procedure (localproc_016a)
	(cond 
		((== gGModNum 246) (= global130 8))
		((!= (eureka puke?) 0) (= global130 0))
		(
			(and
				(== gEurekaCurLocation 4)
				(not (& global169 $0004))
				(>= global127 3)
			)
			(= global169 (| global169 $0004))
			(= global130 9)
		)
		(
			(and
				(== gEurekaCurLocation 8)
				(<= 700 gGModNum)
				(<= gGModNum 799)
			)
			(proc0_2 103)
			(= global130 11)
		)
		(
			(and
				(== gEurekaCurLocation 6)
				(!= gGModNum 225)
				(== global142 1)
				(not (proc0_1 45))
			)
			(= global130 2)
		)
		(
		(and (== gEurekaCurLocation 3) (== gGModNum 325))
			(cond 
				((gEgo has: 12)
					(proc0_2 80)
					(if (& global169 $0020)
						(if (== global170 1)
							(= global130 4)
						else
							(= global130 2)
						)
					else
						(= global130 10)
					)
				)
				((not (& global169 $0020)) (= global130 13))
				((== global170 1) (= global130 4))
				(else (= global130 2))
			)
		)
		(
			(or
				(== global130 7)
				(and (== global170 1) (!= global130 0))
				(and (== global130 6) (== gGModNum 225))
			)
			(= global170 1)
			(= global130 4)
		)
		(
		(and (== gEurekaCurLocation 14) (== (eureka puke?) 0)) (= global130 8))
	)
)

(instance rm240 of Rm
	(properties
		noun 19
		picture 43
		style $000a
		vanishingX 81
		vanishingY 87
	)
	
	(method (init &tmp temp0)
		(if (== (gSq5Music2 number?) 105)
			(theMusic3 number: 105 loop: -1 play:)
			(gSq5Music2 stop:)
		)
		(if (== gGModNum 1040) (eureka puke: 1))
		(proc958_0 128 0 259 250)
		(gEgo view: 0 actions: 0)
		(global2 setRegions: 210)
		(if (== gGModNum 246) (= style 100))
		(super init:)
		(if (proc0_1 57) (stain addToPic:))
		(tkrRoger normal: 1)
		(tkrCliffy normal: 1)
		((ScriptID 244 0) doit:)
		(tank init: setOnMeCheck: 1 8)
		(cryoDoor init:)
		(chamber init:)
		(cryoButton init: setOnMeCheck: 1 4)
		(thePad init: setOnMeCheck: 1 2)
		(tankTop init:)
		(gOldWH addToFront: self)
		(gOldWH addToFront: thePad)
		(gOldWH addToFront: northDoor)
		(gOldDH addToFront: self)
		(northDoor init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						19
						157
						82
						157
						84
						131
						144
						131
						174
						153
						233
						153
						233
						148
						202
						134
						161
						134
						150
						127
						181
						127
						175
						125
						154
						125
						150
						122
						128
						122
						132
						125
						113
						125
						112
						122
						94
						122
						94
						125
						19
						125
					yourself:
				)
		)
		(cliffy init:)
		(droole init:)
		(flo init:)
		(wd40 init:)
		(spike init:)
		(proc240_30)
		(if (== global164 9) (bea init:))
		(cond 
			((== gGModNum 246)
				(proc0_6 0 2)
				(gEgo init: x: 225 y: 146 setScale: Scaler 116 71 149 123)
				(gSQ5 handsOn:)
			)
			((== (eureka puke?) 7)
				(gEgo
					init:
					view: 239
					loop: 3
					cel: 0
					setPri: 1
					posn: 42 138
					setScale: 0
				)
				(self setScript: (ScriptID 245 0))
			)
			((== gGModNum 241)
				(proc0_6 0 2)
				(gEgo
					init:
					loop: 2
					posn: 170 126
					setScale: Scaler 116 71 149 123
				)
				(gSQ5 handsOn:)
			)
			((and (<= 300 gGModNum) (<= gGModNum 399))
				(switch gGModNum
					(300
						(proc0_10 175 175)
						(if (and (gEgo has: 20) (== global130 4))
							(global2 setScript: (ScriptID 243 14))
						else
							(= theRegister 2)
							(global2 setScript: beamRoger 0 1)
						)
					)
					(325
						(cond 
							((gEgo has: 12) (global2 setScript: (ScriptID 243 21)))
							((& global169 $0020) (= theRegister 2) (global2 setScript: beamRoger 0 1))
							(else (global2 setScript: (ScriptID 243 31)))
						)
					)
				)
			)
			(
			(and (== gEurekaCurLocation 6) (!= gGModNum 225))
				(if (and (== global142 1) (not (proc0_1 45)))
					(= local74 0)
					(proc958_0 128 256 255 257 258 259)
					(global2 setScript: (ScriptID 243 1))
				else
					(global2 setScript: (ScriptID 243 29))
				)
			)
			(
				(and
					(== gEurekaCurLocation 8)
					(!= gGModNum 225)
					(not (& global169 $0002))
				)
				(proc958_0 128 6 20 0)
				(self setScript: (ScriptID 243 23))
			)
			(
				(and
					(== gEurekaCurLocation 8)
					(<= 700 gGModNum)
					(<= gGModNum 799)
				)
				(self setScript: (ScriptID 243 31))
			)
			(
			(proc999_5 gGModNum 300 325 500 400 410 420 730 760 1040) (= theRegister 2) (global2 setScript: beamRoger 0 1))
			(else
				(proc0_6 0 2)
				(gEgo
					init:
					setLoop: 2
					posn: 41 119
					setPri: 1
					setScale: Scaler 116 71 149 123
				)
				(global2 setScript: enterRoom)
			)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script 0)
			((and (proc0_5 gEgo 16) (== global126 3)) (self setScript: (ScriptID 243 8)))
		)
	)
	
	(method (dispose)
		(gEgo setScript: 0)
		(gOldWH delete: northDoor)
		(gOldWH delete: self)
		(gOldWH delete: thePad)
		(gOldDH delete: self)
		(DisposeScript 956)
		(DisposeScript 969)
		(DisposeScript 991)
		(DisposeScript 243)
		(DisposeScript 244)
		(DisposeScript 245)
		(if (== (theMusic3 number?) 105)
			(gSq5Music2 number: 105 loop: -1 play:)
			(theMusic3 stop:)
		)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(= theGPEventX gPEventX)
		(= theGPEventY gPEventY)
		(return
			(switch theVerb
				(3
					(cond 
						(local81 (gTestMessager say: noun 3 13 0) (return 1))
						(local74
							(cond 
								((proc999_4 66 120 159 131 gPEventX gPEventY) (global2 setScript: getOffPad 0 0) (return 1))
								((< gPEventX 113) (global2 setScript: getOffPad 0 1) (return 1))
								(else (global2 setScript: getOffPad 0 2) (return 1))
							)
						)
						(else (super doVerb: theVerb &rest))
					)
				)
				(2
					(if local74
						(global2 setScript: beamRoger 0 0)
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
)

(instance droole of Actor
	(properties
		x 133
		y 140
		noun 13
		view 31
		signal $6000
	)
	
	(method (init)
		(cond 
			(
				(and
					(not (proc0_1 76))
					(== gEurekaCurLocation 5)
					(== gGModNum 225)
					(proc0_1 30)
				)
				(super init: &rest)
				(self cel: (self lastCel:))
			)
			(
				(and
					(not (proc0_1 74))
					(== gEurekaCurLocation 4)
					(>= global127 3)
				)
				(super init: &rest)
				(self cel: (self lastCel:))
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTestMessager say: noun 2 14 0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(cond 
			((and (<= 400 gGModNum) (<= gGModNum 499)) (self setScript: extraLeaves 0 self))
			((proc999_5 gEurekaCurLocation 4) (self dispose:))
		)
	)
)

(instance flo of Actor
	(properties
		x 126
		y 140
		view 32
		signal $6000
	)
	
	(method (init)
		(if
			(and
				(not (proc0_1 74))
				(== gEurekaCurLocation 4)
				(>= global127 3)
			)
			(super init: &rest)
			(self cel: (self lastCel:))
		)
	)
	
	(method (cue)
		(if (== gEurekaCurLocation 4) (self dispose:))
	)
)

(instance cliffy of Actor
	(properties
		x 122
		y 145
		noun 5
		yStep 1
		view 33
		signal $6000
		xStep 2
	)
	
	(method (init)
		(= local78 53)
		(localproc_016a)
		(cond 
			((== global130 9)
				(self
					view: 33
					loop: 0
					posn: 122 145
					cel: (self lastCel:)
					detailLevel: 0
				)
				(super init: &rest)
			)
			((== global130 11)
				(self
					view: 33
					loop: 0
					detailLevel: 0
					posn: 122 145
					cel: 0
				)
				(if (< global164 8) (= local78 5) else (= local78 53))
				(super init: &rest)
			)
			((== global130 13)
				(self
					view: 33
					loop: 0
					detailLevel: 0
					posn: 122 145
					cel: 0
				)
				(super init: &rest)
			)
			((== global130 2)
				(super init: &rest)
				(self
					view: 191
					loop: 0
					x: 239
					y: 164
					detailLevel: 2
					setPri: 13
					setScale: Scaler 116 71 149 123
					setScript: bang
				)
			)
			((== global130 4)
				(super init: &rest)
				(self
					view: 248
					loop: 0
					cel: 0
					x: 226
					y: 170
					detailLevel: 2
					setPri: 13
					setScale: Scaler 116 71 149 123
					setCycle: Fwd
					setScript: bang
				)
				(= local78 6)
			)
			((proc999_5 global130 5 12 8)
				(self
					view: 26
					loop: 0
					cel: 0
					posn: 238 162
					setScale: Scaler 116 71 149 123
					setScript: bang
				)
				(if (== global130 5) (= local78 5) else (= local78 8))
				(super init: &rest)
			)
			((== global130 10)
				(proc0_2 80)
				(self
					view: 21
					loop: 11
					cel: 0
					detailLevel: 0
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
					posn: 92 77
				)
				(super init: &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 2)
				(cond 
					((== global130 5) (global2 setScript: (ScriptID 243 27)))
					((== global130 8) (global2 setScript: (ScriptID 243 28)))
					((proc0_1 61) (gTestMessager say: 5 2 52 0))
					((Message msgSIZE 240 noun theVerb local78 1) (gTestMessager say: noun theVerb local78 0))
					(else (super doVerb: theVerb &rest))
				)
			)
			((Message msgSIZE 240 noun theVerb local78 1) (gTestMessager say: noun theVerb local78 0))
			(else (super doVerb: theVerb &rest))
		)
	)
	
	(method (cue)
		(if (== global130 9) (= global130 0) (self dispose:))
	)
)

(instance extraView of View
	(properties
		x 256
		y 143
		view 248
		loop 2
		cel 1
		priority 1
		signal $4010
	)
)

(instance stain of View
	(properties
		x 249
		y 87
		noun 23
		view 247
		loop 1
		priority 11
		signal $4010
	)
	
	(method (doVerb)
		(tank doVerb: &rest)
	)
)

(instance spike of Actor
	(properties
		noun 22
		view 244
		signal $4000
	)
	
	(method (init param1)
		(switch global126
			(7
				(self
					view: 245
					loop: 0
					cel: 0
					posn: 197 139
					setPri: 10
					x: 185
					y: 115
					setScale: Scaler 116 71 149 123
				)
				(super init: &rest)
			)
			(2
				(self
					view: 244
					loop: 2
					cel: 0
					x: 253
					y: 101
					setPri: 11
					setScale: 0
					detailLevel: 3
					setCycle: Fwd
				)
				(super init:)
				(bubbles setCycle: Fwd init:)
			)
			(3
				(spike view: 242 x: 146 y: 181)
			)
		)
		(if (and argc param1) (super init:))
	)
	
	(method (doVerb theVerb)
		(cond 
			((== global126 2) (tank doVerb: theVerb &rest))
			((and (== global126 7) (== theVerb 2)) (global2 setScript: (ScriptID 243 27)))
			(else (super doVerb: theVerb &rest))
		)
	)
)

(instance wd40 of Actor
	(properties
		x 113
		y 139
		noun 28
		view 248
		signal $6000
		detailLevel 3
	)
	
	(method (init)
		(cond 
			((== global170 1)
				(self
					view: 248
					loop: 2
					cel: 0
					x: 255
					y: 144
					setPri: 13
					noun: 27
				)
				(extraView noun: 19 addToPic:)
				(super init: &rest)
			)
			((and (== global170 2) (== (eureka puke?) 0))
				(self
					view: 265
					loop: 0
					x: 124
					y: 107
					setScale: 0
					cycleSpeed: 15
					noun: 28
					setCycle: Fwd
				)
				(super init: &rest)
				(extraView
					view: 265
					loop: 1
					cel: 0
					x: 124
					y: 107
					noun: 28
					addToPic:
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond 
					((== gEurekaCurLocation 5) (gTestMessager say: noun 2 50 0))
					(
						(and
							(== gEurekaCurLocation 6)
							(proc0_1 63)
							(< global164 1)
						)
						(gTestMessager say: noun 2 47 0)
					)
					(
					(and (== gEurekaCurLocation 8) (not (proc0_1 75))) (gTestMessager say: noun 2 45 0))
					((and (proc0_1 80) (== global164 8)) (gTestMessager say: noun 2 49 0))
					((and (not (proc0_1 80)) (== global164 8)) (gTestMessager say: noun 2 48 0))
					((== noun 28) (gTestMessager say: noun 2 41 0))
					(else (super doVerb: theVerb &rest))
				)
			)
			(else 
				(if (Message msgSIZE 240 noun theVerb 41 1)
					(gTestMessager say: noun theVerb 41 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance lookInChamber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 170 126 self)
			)
			(2
				(gSQ5 handsOn:)
				(global2 newRoom: 241)
			)
		)
	)
)

(instance chamber of Actor
	(properties
		x 241
		y 132
		view 259
		loop 2
		cel 1
		priority 9
		signal $5810
	)
	
	(method (init)
		(cond 
			(
				(and
					(== gEurekaCurLocation 14)
					(> (eureka puke?) 2)
					(proc999_5 global164 8 10)
				)
				(self view: 24 loop: 1 posn: 203 132 setCycle: Fwd)
				(= global164 10)
				(super init: &rest)
			)
			((proc0_1 44)
				(self
					view: 259
					loop: 2
					x: 202
					y: 132
					setPri: 10
					cel: (if (proc0_1 45) 0 else 1)
				)
				(super init: &rest)
				(self stopUpd:)
			)
			((== (global2 script?) openBox) (super init: &rest))
		)
		(= noun
			(switch global164
				(1 7)
				(8 8)
				(10 6)
				(2 12)
				(else  11)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((== global164 8) (gTestMessager say: 8 1 0 0))
					(local81 (gTestMessager say: 11 1 13 0))
					((== global164 9) (gTestMessager say: 11 1 0 0))
					((== global164 10) (gTestMessager say: 6 1 0 0))
					((and (proc0_1 45) (== view 259)) (global2 setScript: lookInChamber))
					(else (super doVerb: theVerb &rest))
				)
			)
			(4
				(cond 
					((== global164 8) (gTestMessager say: 8 4 0 0))
					((== global164 10) (global2 setScript: (ScriptID 245 1)))
					((== global164 9) (gTestMessager say: 7 4 11 0))
					((proc0_1 45)
						(if (== view 259)
							(cond 
								((== global130 5) (gTestMessager say: 7 4 8 0))
								((proc999_5 global164 2 1) (global2 setScript: (ScriptID 243 4)))
								(else (gTestMessager say: 7 4 11 0))
							)
						else
							(global2 setScript: (ScriptID 243 6))
						)
					)
					((or (gOldCast contains: bea) local81)
						(cond 
							((and (== view 259) (== cel 1))
								(if local81
									(gTestMessager say: 11 4 13 0)
								else
									(global2 setScript: (ScriptID 243 4))
								)
							)
							(local81 (global2 setScript: (ScriptID 243 2)))
							(else (gTestMessager say: 11 4 12 0))
						)
					)
					(else (gTestMessager say: 7 4 11 0))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (setCycle theCycler)
		(if theCycler (gSq5Music2 number: 103 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
	
	(method (setMotion theMover)
		(if theMover (gSq5Music2 number: 160 loop: 1 play:))
		(super setMotion: theMover &rest)
	)
)

(instance tankTop of Prop
	(properties
		x 233
		y 87
		view 244
		loop 4
		signal $4000
	)
	
	(method (init param1)
		(if (proc0_1 43)
			(= cel (self lastCel:))
			(super init: &rest)
			(self stopUpd:)
		else
			(= cel 0)
		)
		(if (and argc param1)
			(super init: &rest)
			(self startUpd:)
		)
	)
	
	(method (doVerb theVerb)
		(tank doVerb: theVerb &rest)
	)
	
	(method (setCycle theCycler)
		(if theCycler (gSq5Music2 number: 108 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
)

(instance bubbles of Prop
	(properties
		x 254
		y 101
		view 244
		loop 3
		priority 12
		signal $4010
		detailLevel 3
	)
)

(instance cryoDoor of Prop
	(properties
		x 224
		y 99
		noun 10
		view 259
		loop 1
		priority 10
		signal $5810
	)
	
	(method (init)
		(if (not (proc0_1 44))
			(if (== (global2 script?) closeBox)
				(self cel: (self lastCel:))
			)
			(super init: &rest)
		)
		(self stopUpd:)
	)
	
	(method (setCycle theCycler)
		(if theCycler (gSq5Music2 number: 103 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
)

(instance bea of Actor
	(properties
		x 97
		y 186
		z 50
		view 256
		loop 1
		priority 15
		signal $4010
	)
	
	(method (init)
		(if (== global164 9)
			(self
				view: 25
				loop: 0
				cel: 15
				posn: 128 143 0
				noun: 4
				setScale: Scaler 116 71 149 123
			)
		else
			(self stopUpd:)
			(= noun 3)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== global164 9)
					(super doVerb: theVerb)
				else
					(global2 setScript: (ScriptID 243 5))
				)
			)
			(2
				(if (== noun 4)
					(if (proc0_1 72)
						(gTestMessager say: noun 2 46 0)
					else
						(gTestMessager say: noun 2 58 0)
					)
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

(instance extraLeaves of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= temp0
					(switch register
						(cliffy 0)
						(droole 5)
						(wd40 15)
					)
				)
				(register
					view: [local0 (+ temp0 0)]
					loop: 2
					setCycle: StopWalk -1
					setLoop: Grooper
					setScale: Scaler 116 71 149 123
					posn: [local0 (+ temp0 1)] [local0 (+ temp0 2)]
					setMotion: MoveTo [local0 (+ temp0 3)] [local0 (+ temp0 4)] self
				)
			)
			(1
				(register setMotion: PolyPath 44 127 self)
			)
			(2
				(northDoor setCycle: End self)
			)
			(3
				(register setPri: 0 setMotion: MoveTo 45 120 self)
			)
			(4
				(northDoor setCycle: Beg self)
			)
			(5
				(northDoor stopUpd:)
				(gSQ5 handsOn:)
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 41 130 self)
			)
			(1
				(gEgo setPri: -1 setLoop: -1)
				(northDoor setCycle: Beg self)
			)
			(2
				(if (== global130 9)
					(gSq5Music2 number: 260 loop: 1 play:)
					(cliffy setCycle: Beg cliffy)
					(flo setCycle: Beg flo)
					(droole setCycle: Beg droole)
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(3
				(switch global130
					(5
						(gTestMessager say: 5 2 9 0 self)
					)
					(12
						(gTestMessager say: 5 2 10 0 self)
					)
					(else  (= cycles 1))
				)
			)
			(4
				(northDoor stopUpd:)
				(cond 
					((and (gEgo has: 20) (== global130 4)) (= next (ScriptID 243 14)))
					(
					(and (== global130 8) (not (& global169 $0008))) (= next (ScriptID 243 28)))
					(else (gSQ5 handsOn:))
				)
				(self dispose:)
			)
		)
	)
)

(instance bang of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gSQ5 detailLevel:) (cliffy detailLevel:))
					(cliffy stopUpd:)
					(-- state)
				else
					(cliffy startUpd:)
					(switch (cliffy view?)
						(191
							(cliffy setLoop: (Random 0 3))
							(if (== (cliffy loop?) 2) (cliffy setLoop: 4))
							(= register (Random 3 7))
						)
						(26
							(cliffy setLoop: (Random 0 2))
							(= register 1)
						)
						(else 
							(cliffy setLoop: (Random 0 1))
							(= register (Random 3 7))
						)
					)
				)
				(= cycles 1)
			)
			(1
				(cliffy cel: 0 setCycle: End self)
			)
			(2
				(if (-- register)
					(= state (- state 2))
				else
					(= state (- state 3))
				)
				(switch (cliffy view?)
					(191
						(theMusic3
							number:
							(switch (cliffy loop?)
								(3 2422)
								(4 233)
								(else  230)
							)
							loop: 1
							play: self
						)
					)
					(26 (= seconds 5))
					(else 
						(theMusic3
							number: (if (cliffy loop?) 230 else 232)
							loop: 1
							play: self
						)
					)
				)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if local74
					(self setScript: getOffPad self 1)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 41 130 self)
			)
			(2 (gEgo setHeading: 0 self))
			(3
				(cond 
					((gEgo has: 8)
						(= state 0)
						(if (not (proc0_1 56))
							(self setScript: (ScriptID 243 26) self)
						else
							(self setScript: putSpikeBack self)
						)
					)
					((and (== global126 2) (not (proc0_1 56))) (self setScript: (ScriptID 243 10) self))
					(else (= cycles 1))
				)
			)
			(4
				(northDoor setCycle: End self)
			)
			(5
				(gEgo setPri: 1 setLoop: 3 setMotion: MoveTo 41 119 self)
			)
			(6
				(if (gOldATPs contains: stain) (proc0_3 57))
				(switch global126
					(5 (= global126 4))
					(2
						(if (not (proc0_1 56)) (proc0_2 57) (= global126 4))
					)
				)
				(global2 newRoom: 225)
			)
		)
	)
)

(instance getOnPad of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client global2) (gSQ5 handsOff:))
				(= theRegister register)
				(gEgo
					setMotion:
						PolyPath
						[local20 register]
						[local20 (+ (= register (* register 8)) 1)]
						self
				)
			)
			(1
				(gEgo setHeading: [local20 (+ register 2)] self)
			)
			(2
				(gEgo
					view: 250
					cel: 0
					loop: [local20 (+ register 3)]
					posn: [local20 (+ register 4)] [local20 (+ register 5)]
					setCycle: End self
				)
			)
			(3
				(proc0_6 0 2)
				(gEgo
					setScale: 0
					heading: 180
					posn: [local20 (+ register 6)] [local20 (+ register 7)]
				)
				(= local74 1)
				(if (== client global2) (gSQ5 handsOn:))
				(self dispose:)
			)
		)
	)
)

(instance getOffPad of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= register (* register 8))
				(gEgo
					heading: 180
					setMotion: MoveTo [local20 (+ register 6)] [local20 (+ register 7)] self
				)
			)
			(1
				(gEgo
					view: 250
					cel: 0
					loop: [local44 register]
					posn: [local44 (+ register 1)] [local44 (+ register 2)]
					setCycle: End self
				)
			)
			(2
				(proc0_6 0 [local44 (+ register 3)])
				(gEgo
					setScale: Scaler 116 71 149 123
					setPri: 10
					posn: [local44 (+ register 4)] [local44 (+ register 5)]
					setMotion: MoveTo [local44 (+ register 6)] [local44 (+ register 7)] self
				)
			)
			(3
				(gEgo setPri: -1)
				(= local74 0)
				(if (== client global2)
					(gEgo setMotion: PolyPath theGPEventX theGPEventY)
					(gSQ5 handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance putSpikeBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 22 0 32 0 self)
			)
			(1
				(self setScript: (ScriptID 243 9) self)
			)
			(2
				(self setScript: openTank self)
			)
			(3 (self dispose:))
		)
	)
)

(instance beamRoger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if
					(and
						(gEgo has: 8)
						(not (proc999_5 gEurekaCurLocation 4 14))
					)
					(self setScript: putSpikeBack self)
				else
					(= state (+ state 1))
					(= cycles 2)
				)
			)
			(1
				(self setScript: getOnPad self 2)
			)
			(2
				(if (not register)
					(gTestMessager say: 18 2 26 0 self)
				else
					(= cycles 1)
				)
			)
			(3
				(cond 
					((and (!= gEurekaCurLocation 14) (proc0_1 84)) (= cycles 1))
					(
						(and
							(== (eureka puke?) 7)
							(== global126 2)
							(not register)
						)
						(self setScript: (ScriptID 245 2) self)
					)
					(
						(and
							(== gEurekaCurLocation 8)
							(proc0_1 75)
							(not register)
						)
						(self setScript: (ScriptID 243 24) self)
					)
					(
						(and
							(== gEurekaCurLocation 3)
							(proc0_1 9)
							(not (& global169 $0020))
							(not (proc0_1 80))
							(not register)
							(!= global130 0)
						)
						(self setScript: (ScriptID 243 24) self)
					)
					(else (= cycles 1))
				)
			)
			(4
				(gEgo
					view: 6
					loop: 0
					posn: [local68 (* theRegister 2)] [local68 (+ (* theRegister 2) 1)]
				)
				(if register
					(gEgo setScale: Scaler 116 71 149 123 init:)
					(if (Random 0 2)
						(gEgo cel: 0 cycleSpeed: 6 setCycle: End self)
						(gSq5Music2 number: 260 loop: 1 play:)
					else
						(self setScript: (ScriptID 243 30) self)
					)
				else
					(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
					(gSq5Music2 number: 260 loop: 1 play:)
					(if
						(and
							(gOldCast contains: droole)
							(== (droole view?) 31)
						)
						(droole setCycle: Beg droole)
					)
					(if
						(and
							(gOldCast contains: cliffy)
							(== (cliffy view?) 33)
						)
						(cliffy setCycle: Beg cliffy)
					)
					(if
					(and (== global164 9) (gOldCast contains: bea))
						(bea setCycle: Beg)
					)
				)
			)
			(5
				(gSq5Music2 stop:)
				(proc240_30)
				(cond 
					((and (!= gEurekaCurLocation 14) (proc0_1 84)) (proc0_9 11))
					(
					(and (== gEurekaCurLocation 8) (not (proc0_1 75))) (= next (ScriptID 243 13)) (self dispose:))
					(
						(and
							(== gEurekaCurLocation 14)
							(<= 2 (eureka puke?))
							(<= (eureka puke?) 6)
							(not register)
						)
						(= next (ScriptID 243 13))
						(self dispose:)
					)
					(
						(and
							(proc0_1 63)
							(proc0_1 76)
							(proc0_1 75)
							(== global164 1)
						)
						(= next (ScriptID 243 23))
						(self dispose:)
					)
					(register
						(proc0_6 0 2)
						(gEgo
							setScale: 0
							heading: 180
							posn:
								[local20 (+ (* theRegister 8) 6)]
								[local20 (+ (* theRegister 8) 7)]
						)
						(= local74 1)
						(if (not (extraLeaves client?)) (gSQ5 handsOn:))
						(if
						(and (== gEurekaCurLocation 14) (== (eureka puke?) 1))
							(gTestMessager say: 29 2 55 0)
						)
						(self dispose:)
					)
					(else (gEgo hide:) (= local74 0) (= seconds 3))
				)
			)
			(6
				(gEgo get: 10)
				(if (and (!= gEurekaCurLocation 14) (proc0_1 84))
					(proc0_9 11)
				else
					(switch gEurekaCurLocation
						(3
							(if (and (proc0_1 9) (not (proc0_1 89)))
								(global2 newRoom: 325)
							else
								(proc0_3 61)
								(global2 newRoom: 300)
							)
						)
						(4
							(if (< global127 3)
								(= next (ScriptID 243 25))
								(self dispose:)
							else
								(proc0_2 74)
								(global2 newRoom: 500)
							)
						)
						(5
							(if (not (proc0_1 30))
								(= next (ScriptID 243 25))
								(self dispose:)
							else
								(global2 newRoom: 410)
							)
						)
						(7
							(= next (ScriptID 243 25))
							(self dispose:)
						)
						(8
							(if (proc0_1 75)
								(global2 newRoom: 730)
							else
								(global2 newRoom: 760)
							)
						)
						(6 (global2 newRoom: 620))
						(14
							(cond 
								((== (eureka puke?) 7)
									(if (== global164 9)
										(if (proc0_1 59)
											(global2 newRoom: 1040)
										else
											(global2 newRoom: 1001)
										)
									else
										(proc0_9 37)
									)
								)
								(
								(and (< 0 (eureka puke?)) (< (eureka puke?) 7)) (proc0_9 48))
								(else (= next (ScriptID 243 25)) (self dispose:))
							)
						)
						(else 
							(if (proc999_5 gEurekaCurLocation 9 10 11 12 13)
								(proc0_9 50)
							else
								(proc0_9 45)
							)
						)
					)
				)
			)
		)
	)
)

(instance openTank of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client global2) (gSQ5 handsOff:))
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 223 146 self)
			)
			(2 (gEgo setHeading: 45 self))
			(3
				(gEgo
					view: 243
					loop: 0
					cel: 0
					posn: 222 145
					looper: 0
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play: self)
			)
			(5
				(gEgo setCycle: Beg self)
				(if (proc0_1 43)
					(tankTop setCycle: Beg self)
					(bubbles
						init:
						cel: (bubbles lastCel:)
						setCycle: Beg self
					)
				else
					(tankTop init: 1 setCycle: End self)
					(bubbles init: cel: 0 setCycle: End self)
				)
			)
			(6)
			(7)
			(8
				(bubbles dispose:)
				(proc0_6 0 6)
				(gEgo setScale: Scaler 116 71 149 123 posn: 223 146)
				(if (proc0_1 43)
					(proc0_3 43)
					(tankTop dispose:)
				else
					(proc0_2 43)
					(tankTop stopUpd:)
				)
				(if (== client global2)
					(if (and (== global126 2) (proc0_1 43))
						(= next (ScriptID 243 11))
					else
						(gSQ5 handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance openBox of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 205 139 self)
			)
			(2 (gEgo setHeading: 45 self))
			(3
				(gEgo
					view: 243
					loop: 2
					cel: 0
					posn: 205 139
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play:)
				(= seconds 2)
			)
			(5 (gEgo setCycle: Beg self))
			(6
				(proc0_6 0 6)
				(gEgo
					x: 205
					y: 139
					setScale: Scaler 116 71 149 123
					setHeading: 45 self
				)
			)
			(7
				(chamber init:)
				(cryoDoor setCycle: End self)
			)
			(8
				(chamber setPri: 9 setMotion: MoveTo 202 132 self)
			)
			(9 (gEgo setHeading: 0 self))
			(10
				(proc240_30)
				(proc0_2 44)
				(chamber init:)
				(cryoDoor dispose:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeBox of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if local74
					(self setScript: getOffPad self 2)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 205 139 self)
			)
			(2 (gEgo setHeading: 90 self))
			(3
				(gEgo
					view: 243
					loop: 2
					cel: 0
					posn: 205 139
					setCycle: End self
				)
			)
			(4
				(gSq5Music2 number: 124 loop: 1 play:)
				(= seconds 2)
			)
			(5 (gEgo setCycle: Beg self))
			(6
				(proc0_6 0 6)
				(gEgo
					x: 205
					y: 139
					setScale: Scaler 116 71 149 123
					setHeading: 45 self
				)
			)
			(7
				(chamber setPri: 9 setMotion: MoveTo 241 132 self)
			)
			(8 (gEgo setHeading: 90 self))
			(9
				(proc0_3 44)
				(cryoDoor init: setCycle: Beg self)
			)
			(10
				(chamber dispose:)
				(cryoDoor stopUpd:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance beaTalker of Talker
	(properties
		x 172
		y 55
		view 261
		loop 1
		signal $4000
		back 5
	)
	
	(method (init)
		(= font gFont)
		(if local80
			(= gSq5Win gNewSpeakWindow)
			(self
				view: 261
				loop: 1
				cel: 0
				x: 172
				y: 55
				textX: -172
				talkWidth: 150
				signal: 16384
				disposeWhenDone: 1
			)
			(gSq5Win tailX: 205 tailY: 93 isBottom: 0 xOffset: 20)
			(beaMouth
				view: 261
				loop: 0
				nsLeft: 3
				nsTop: 21
				signal: 16384
			)
			(super init: 0 0 beaMouth &rest)
		else
			(self
				view: 1001
				loop: 0
				x: 10
				y: 25
				textX: 120
				textY: 10
				talkWidth: 150
				disposeWhenDone: 1
			)
			(= gSq5Win gSq5Win_2)
			(beaMouth view: 1001 loop: 1 nsLeft: 47 nsTop: 34)
			(beaEyes setLoop: (Random 2 3))
			(super init: 0 beaEyes beaMouth &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance beaEyes of Prop
	(properties
		nsTop 20
		nsLeft 54
		view 1001
		loop 2
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 21
		nsLeft 3
		view 261
		signal $4000
	)
)

(instance tkrCliffy of ChoiceTalker
	(properties
		x 0
		y 5
		view 1003
		talkWidth 150
		keepWindow 1
		textX 115
		textY 20
	)
	
	(method (init)
		(= keepWindow (not normal))
		(= font gFont)
		(cliffyEyes setLoop: (Random 2 3))
		(super init: cliffyBust cliffyEyes cliffyMouth &rest)
	)
)

(instance cliffyBust of Prop
	(properties
		view 1003
	)
)

(instance cliffyEyes of Prop
	(properties
		nsTop 14
		nsLeft 58
		view 1003
		loop 2
	)
)

(instance cliffyMouth of Prop
	(properties
		nsTop 32
		nsLeft 52
		view 1003
		loop 1
	)
)

(instance tkrRoger of ChoiceTalker
	(properties
		x 0
		y 15
		view 1000
		talkWidth 150
		keepWindow 1
		textX 100
		textY 20
	)
	
	(method (init)
		(= font gFont)
		(if local79
			(self
				view: 261
				loop: 4
				cel: 0
				x: 115
				textX: -115
				textY: 10
				talkWidth: 250
				y: 40
			)
			((= gSq5Win gNewSpeakWindow)
				tailX: 160
				tailY: 40
				isBottom: 1
				xOffset: 1
			)
			(rogMouth view: 261 loop: 3 nsLeft: 7 nsTop: 28)
			(super init: 0 0 rogMouth &rest)
		else
			(self
				view: 1000
				loop: 0
				cel: 0
				x: 0
				textX: 112
				textY: 10
				talkWidth: 150
				y: 15
			)
			(rogMouth view: 1000 loop: 1 nsLeft: 44 nsTop: 35)
			(rogEyes setLoop: (Random 2 3))
			(= keepWindow (not normal))
			(super init: 0 rogEyes rogMouth &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance rogEyes of Prop
	(properties
		nsTop 21
		nsLeft 47
		view 1000
		loop 2
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 35
		nsLeft 44
		view 1000
		loop 1
	)
	
	(method (init)
		(if local79
			(self view: 261 loop: 3 nsLeft: 7 nsTop: 28)
		else
			(self view: 1000 loop: 1 nsLeft: 44 nsTop: 35)
		)
		(super init: &rest)
	)
)

(instance cryoButton of Feature
	(properties
		x 232
		y 104
		noun 9
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					((proc0_1 44)
						(cond 
							(local81 (gTestMessager say: 11 4 13 0))
							((proc0_1 45) (gTestMessager say: 11 4 12))
							((!= (chamber view?) 259) (gTestMessager say: 11 4 12))
							(else (global2 setScript: closeBox))
						)
					)
					(local81 (gTestMessager say: 11 4 13))
					(else (global2 setScript: openBox))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tank of Feature
	(properties
		x 232
		y 104
		onMeCheck $0008
	)
	
	(method (init)
		(= noun
			(switch global126
				(2 25)
				(else  24)
			))
		(if (gOldATPs contains: stain) (= noun 23))
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(cond 
			((not (proc999_5 theVerb 4 31 29)) (super doVerb: theVerb &rest))
			((proc0_1 57) (gTestMessager say: 23 0 0 0))
			(local81 (gTestMessager say: 24 0 13 0))
			(else
				(switch theVerb
					(4
						(global2 setScript: openTank)
					)
					(31
						(global2 setScript: (ScriptID 243 9))
					)
					(29
						(cond 
							((!= global126 2) (gTestMessager say: 24 29 0 0))
							((proc0_1 56) (gTestMessager say: 25 29 33 0))
							(else (global2 setScript: (ScriptID 243 12)))
						)
					)
					(else 
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)
)

(instance thePad of Feature
	(properties
		x 124
		y 145
		noun 26
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(cond 
					(local81 (self doVerb: 4))
					((not local74)
						(cond 
							((proc999_4 66 120 159 131 gEgo) (global2 setScript: getOnPad 0 0))
							((< (gEgo x?) 113) (global2 setScript: getOnPad 0 1))
							(else (global2 setScript: getOnPad 0 2))
						)
					)
				)
			)
			(4
				(if local81
					(global2 setScript: (ScriptID 243 7))
				else
					(super doVerb: theVerb)
				)
			)
			(24
				(if local74
					(cond 
						((== global130 6) (gTestMessager say: 26 24 38 0))
						(
							(or
								(and (gOldCast contains: bea) (!= global164 9))
								local81
								(and
									(proc0_1 63)
									(== gEurekaCurLocation 6)
									(not (proc999_5 global164 1 8))
								)
								(and
									(!= gGModNum 225)
									(== gEurekaCurLocation 8)
									(!= global164 8)
								)
							)
							(gTestMessager say: noun 24 13 0)
						)
						(else (global2 setScript: beamRoger 0 0))
					)
				else
					(gTestMessager say: noun 24 39 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance northDoor of Prop
	(properties
		x 23
		y 95
		noun 20
		view 259
		priority 5
		signal $5010
	)
	
	(method (init)
		(if (proc999_5 gGModNum 100 225)
			(= cel (self lastCel:))
		)
		(super init:)
		(self stopUpd:)
	)
	
	(method (doVerb theVerb)
		(if (proc999_5 theVerb 3 4)
			(cond 
				(local81 (gTestMessager say: noun 4 13 0))
				((and (proc0_1 75) (< global164 8)) (gTestMessager say: noun 4 25 0))
				((== (chamber view?) 280) (gTestMessager say: noun 4 57 0))
				(
					(and
						(== gEurekaCurLocation 6)
						(proc0_1 63)
						(or
							(and (proc0_1 45) (not (proc999_5 global164 1 8)))
							(gOldCast contains: bea)
						)
					)
					(gTestMessager say: noun 4 29 0)
				)
				(
					(and
						(== gEurekaCurLocation 4)
						(not (proc0_1 74))
						(>= global127 3)
					)
					(gTestMessager say: noun 4 30 0)
				)
				(
					(and
						(== gEurekaCurLocation 4)
						(or (not (proc0_1 54)) (proc0_1 49))
						(>= global127 3)
					)
					(gTestMessager say: noun 4 30 0)
				)
				(else (global2 setScript: exitRoom))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (setCycle theCycler)
		(if theCycler (gSq5Music2 number: 103 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
)

(instance theMusic3 of Sound
	(properties)
)
