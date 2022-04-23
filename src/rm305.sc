;;; Sierra Script 1.0 - (do not remove this comment)
(script# 305)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm305 0
)

(local
	[local0 3]
	local3
	local4
	local5
	local6
	local7
	[local8 6] = [160 161 161 160 158 156]
	[local14 6] = [-50 -5 17 44 73 88]
	[local20 6] = [218 189 157 140 128 128]
	local26
)
(instance rm305 of Rm
	(properties
		noun 21
		picture 62
		vanishingY 80
	)
	
	(method (init)
		(self setRegions: 350)
		(proc958_0
			128
			400
			416
			402
			401
			412
			413
			411
			410
			414
			417
			426
		)
		(proc0_6 0)
		(gEgo actions: (ScriptID 350 1))
		(switch gGModNum
			(310
				(= style 12)
				(gEgo
					posn: 20 144
					loop: 0
					setScale: Scaler 100 65 172 105
					init:
					edgeHit: 0
				)
			)
			(315
				(if (proc0_1 21)
					(proc0_3 21)
					(= style 13)
					(gEgo init: hide:)
					(sRogInTrunk state: 1)
					(global2 setScript: sRogInTrunk)
				else
					(= style -32758)
					(global2 setScript: sFrom315)
				)
			)
			(320
				(= style 11)
				(global2 setScript: sFrom320)
			)
			(else 
				(gEgo
					posn: 20 144
					loop: 0
					setScale: Scaler 100 65 172 105
					init:
				)
			)
		)
		(if (not (proc0_1 10)) (treeBranch init: stopUpd:))
		(fruitGrabArea init:)
		(if (and (proc0_1 16) (not (proc0_1 210)))
			(wdHead init:)
		)
		(vine init: stopUpd:)
		(fruit init: stopUpd:)
		(treeTrunk init: setOnMeCheck: 1 8192)
		(wd40 init:)
		(cave315 init: setOnMeCheck: 1 128)
		(cave320 init: setOnMeCheck: 1 512)
		(extraFruit init: setOnMeCheck: 1 2)
		(mountains init: setOnMeCheck: 1 256)
		(pond init: setOnMeCheck: 1 16)
		(roots init: setOnMeCheck: 1 64)
		(tree init: setOnMeCheck: 1 32)
		(wfall init: setOnMeCheck: 1 8)
		(rightLedge init:)
		(leftLedge init:)
		(super init:)
		(theMusic3
			number: 403
			owner: self
			flags: 1
			init:
			setLoop: -1
			play: 75
		)
		(gOldWH addToFront: pond tree)
		(if (not (proc0_1 10)) (gOldWH addToFront: treeBranch))
		(falls init: setCycle: Fwd)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init: 0 153 55 135 77 118 127 100 119 99 100 106 51 116 24 135 0 142
					yourself:
				)
				((Polygon new:)
					type: 3
					init: 73 123 97 135 156 140 160 133 104 130 80 119
					yourself:
				)
				((Polygon new:)
					type: 3
					init:
						282
						141
						249
						141
						244
						159
						274
						168
						317
						158
						312
						125
						304
						119
						301
						113
						296
						122
						295
						136
					yourself:
				)
				((Polygon new:)
					type: 3
					init: 255 103 255 106 270 106 270 103
					yourself:
				)
		)
		(if (not (global2 script?)) (gSQ5 handsOn:))
	)
	
	(method (doit &tmp temp0)
		(asm
			pushi    #doit
			pushi    0
			super    Rm,  4
			pushi    7
			pushi    6
			pushi    240
			pushi    248
			pushi    5
			pushi    249
			pushi    255
			pushi    65528
			callk    Palette,  14
			pushi    #onControl
			pushi    1
			pushi    1
			lag      gEgo
			send     6
			sat      temp0
			push    
			ldi      128
			eq?     
			bnt      code_04ad
			pushi    90
			pushi    #heading
			pushi    0
			lag      gEgo
			send     4
			lt?     
			bnt      code_048d
			pprev   
			ldi      270
			lt?     
code_048d:
			not     
			bnt      code_04ad
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_04ad
			pushi    #setScript
			pushi    3
			lofsa    sExitRight
			push    
			pushi    0
			pushi    1
			lag      global2
			send     10
			jmp      code_05c6
code_04ad:
			lst      temp0
			ldi      512
			eq?     
			bnt      code_04e6
			pushi    90
			pushi    #heading
			pushi    0
			lag      gEgo
			send     4
			lt?     
			bnt      code_04c6
			pprev   
			ldi      270
			lt?     
code_04c6:
			not     
			bnt      code_04e6
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_04e6
			pushi    #setScript
			pushi    3
			lofsa    sExitRight
			push    
			pushi    0
			pushi    0
			lag      global2
			send     10
			jmp      code_05c6
code_04e6:
			lst      temp0
			ldi      1024
			eq?     
			bnt      code_050d
			pushi    #script
			pushi    0
			lag      global2
			send     4
			push    
			lofsa    sRogSlip
			eq?     
			not     
			bnt      code_050d
			pushi    #setScript
			pushi    1
			lofsa    sRogSlip
			push    
			lag      global2
			send     6
			jmp      code_05c6
code_050d:
			lst      temp0
			ldi      2048
			eq?     
			bnt      code_053d
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_053d
			pushi    #heading
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      180
			lt?     
			bnt      code_053d
			pushi    #setScript
			pushi    1
			lofsa    sRogInTrunk
			push    
			lag      global2
			send     6
			jmp      code_05c6
code_053d:
			lst      temp0
			ldi      4096
			eq?     
			bnt      code_056c
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_056c
			pushi    #heading
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      180
			gt?     
			bnt      code_056c
			pushi    #setScript
			pushi    1
			lofsa    sRogInTrunk
			push    
			lag      global2
			send     6
			jmp      code_05c6
code_056c:
			lst      temp0
			ldi      16384
			eq?     
			bnt      code_05a8
			pushi    #script
			pushi    0
			lofsa    wd40
			send     4
			not     
			bnt      code_05a8
			lsg      gGModNum
			ldi      320
			ne?     
			bnt      code_05a8
			pushi    1
			pushi    14
			callb    proc0_1,  2
			not     
			bt       code_0599
			pushi    1
			pushi    15
			callb    proc0_1,  2
			bnt      code_05a8
code_0599:
			pushi    #setScript
			pushi    1
			lofsa    sWD40LandAndAttack
			push    
			lofsa    wd40
			send     6
			jmp      code_05c6
code_05a8:
			lst      temp0
			ldi      4
			eq?     
			bnt      code_05c6
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_05c6
			pushi    #setScript
			pushi    1
			lofsa    sExitViaScroll
			push    
			lag      global2
			send     6
code_05c6:
			pushi    5
			pushi    132
			pushi    125
			pushi    165
			pushi    145
			lsg      gEgo
			calle    proc999_4,  10
			bnt      code_060a
			pushi    #script
			pushi    0
			lag      global2
			send     4
			not     
			bnt      code_060a
			pushi    #script
			pushi    0
			lofsa    wd40
			send     4
			not     
			bnt      code_060a
			pushi    1
			pushi    14
			callb    proc0_1,  2
			not     
			bnt      code_060a
			pushi    #setScript
			pushi    1
			lofsa    sKnockRogOffTrunk
			push    
			lofsa    wd40
			send     6
code_060a:
			ret     
		)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(gOldWH delete: pond tree leftLedge)
		(if (gOldWH contains: treeBranch)
			(gOldWH delete: treeBranch)
		)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_1 16)
					(gTestMessager say: noun theVerb 2 0)
				else
					(gTestMessager say: noun theVerb 1 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFrom315 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					posn: 275 100
					scaleSignal: 1
					scaleX: 51
					scaleY: 51
					init:
					setPri: 1
					setMotion: MoveTo 262 105 self
				)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaScroll of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo -12 147 self)
			)
			(1 (global2 newRoom: 310))
		)
	)
)

(instance sWD40LandAndAttack of Script
	(properties)
	
	(method (doit)
		(if (and (> (gEgo y?) 136) (not local7))
			(= seconds 0)
			(= local7 1)
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 35 loop: -1 play:)
				(= local26 0)
				(if (proc0_1 15)
					(wd40
						view: 416
						loop: 3
						cel: 0
						scaleSignal: 1
						scaleX: [local20 local26]
						scaleY: [local20 local26]
						x: [local8 local26]
						y: [local14 local26]
					)
					(= ticks 10)
				else
					(++ state)
					(= ticks 1)
				)
			)
			(1
				(wd40
					scaleX: [local20 local26]
					scaleY: [local20 local26]
					x: [local8 local26]
					y: [local14 local26]
				)
				(if (> (++ local26) 5)
					(++ state)
					(= ticks 1)
				else
					(-- state)
					(= ticks 10)
				)
			)
			(2
				(wd40
					view: 416
					loop: 1
					cel: 0
					x: 161
					y: 133
					setCycle: End self
				)
			)
			(3
				(wd40
					view: 416
					loop: 2
					cel: 0
					x: 161
					y: 133
					setCycle: End self
				)
			)
			(4
				(proc0_2 66)
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 175
					y: 89
					setStep: 15 5
					moveSpeed: 0
					init:
					setMotion: MoveTo (+ (gEgo x?) 7) (- (gEgo y?) 10) self
				)
			)
			(5
				(gSq5Music2 number: 4021 setLoop: 1 play:)
				(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
			)
			(6 (= seconds 5))
			(7
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 175
					y: 89
					setStep: 15 5
					moveSpeed: 0
					setMotion: MoveTo (+ (gEgo x?) 2) (- (gEgo y?) 18) self
				)
			)
			(8
				(fireBall dispose:)
				(cond 
					(
					(and (<= 45 (gEgo heading?)) (<= (gEgo heading?) 135)) (gEgo loop: 3))
					(
						(and
							(<= 136 (gEgo heading?))
							(<= (gEgo heading?) 225)
						)
						(gEgo loop: 0)
					)
					(
						(and
							(<= 226 (gEgo heading?))
							(<= (gEgo heading?) 315)
						)
						(gEgo loop: 2)
					)
					(else (gEgo loop: 1))
				)
				(gEgo view: 401 cel: 0 setCycle: End self)
			)
			(9
				(proc0_9 17)
				(self dispose:)
			)
		)
	)
)

(instance sWD40LandOverRog of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(gSq5Music2
					number: 401
					setLoop: 1
					play: 0
					fade: 127 10 10 0
				)
				(= local26 0)
				(wd40
					view: 416
					loop: 3
					cel: 0
					scaleSignal: 1
					scaleX: [local20 local26]
					scaleY: [local20 local26]
					x: [local8 local26]
					y: [local14 local26]
				)
				(= ticks 10)
			)
			(2
				(wd40
					scaleX: [local20 local26]
					scaleY: [local20 local26]
					x: [local8 local26]
					y: [local14 local26]
				)
				(if (> (++ local26) 5)
					(= ticks 1)
				else
					(-- state)
					(= ticks 10)
				)
			)
			(3
				(gSq5Music2 stop:)
				(wd40
					view: 416
					loop: 0
					cel: 0
					x: 164
					y: 132
					setCycle: End self
				)
			)
			(4
				(if (not (proc0_1 19))
					(proc0_2 19)
					(gTestMessager say: 26 0 0 0 self)
				else
					(= cycles 1)
				)
			)
			(5
				(theMusic3 play: 75)
				(= seconds 5)
			)
			(6
				(gSq5IconBar enable: 0)
				(gSq5Music2 number: 401 setLoop: 1 play:)
				(wd40
					view: 400
					setStep: 5 10
					moveSpeed: 0
					signal: (| (wd40 signal?) $6000)
					setMotion: MoveTo 250 -40 self
				)
			)
			(7
				(gSq5Music2 fade:)
				(theMusic3 play: 75)
				(if (proc0_1 21)
					(global2 newRoom: 315)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sFruitUpWD40 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogEyes hide:)
				(gEgo put: 18)
				(gEgo
					view: 412
					loop: 4
					cel: 0
					x: 173
					y: 140
					show:
					setCycle: CT 7 1 self
				)
			)
			(1
				(gSq5Music2 number: 227 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(proc0_2 21)
				(proc0_10 209 200)
				(rogEyes show:)
				(self dispose:)
			)
		)
	)
)

(instance sSwingFruit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 306 141 self)
			)
			(1
				(gEgo
					view: 413
					setLoop: 0
					cel: 1
					x: 306
					y: 141
					setCycle: End self
				)
			)
			(2
				(proc0_6 0 1)
				(gSQ5 handsOn:)
				(= local5 1)
				(fruit setCycle: CT 0 -1 self)
			)
			(3 (fruit setCycle: Osc 3 self))
			(4
				(fruit setCycle: End self)
				(= local5 0)
				(if local4
					(gEgo view: 413 setLoop: 1 cel: 0 setCycle: CT 3 1)
				)
			)
			(5
				(if local4
					(gEgo get: 18 setCycle: End)
					(proc0_10 207 25)
				)
				(fruit setCycle: CT 1 -1 self)
			)
			(6
				(if local4
					(proc0_6 0 1)
					(gSQ5 handsOn:)
					(gTestMessager say: 13 0 0 0)
				)
				(= local4 0)
				(fruit setCycle: CT 5 1 self)
			)
			(7
				(fruit setCycle: CT 2 -1 self)
			)
			(8
				(fruit setCycle: CT 4 1 self)
			)
			(9
				(fruit setCel: 3 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sVineSwing of Script
	(properties)
	
	(method (doit)
		(if (and (== (vine loop?) 0) (== state 5))
			(gEgo cel: (vine cel?))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 161 137 self)
			)
			(1
				(gEgo
					view: 411
					loop: 1
					cel: 0
					x: 166
					y: 132
					setScale: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(vine setCycle: End self)
			)
			(4 0)
			(5
				(gEgo loop: 3 cel: 0 x: 207 y: 93 setCycle: End self)
				(vine loop: 0 cel: 0 setCycle: End self)
			)
			(6 0)
			(7
				(proc0_6 0)
				(gEgo
					x: 264
					y: 106
					setPri: 1
					scaleSignal: 1
					scaleX: 51
					scaleY: 51
				)
				(= local6 0)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if register
					(gEgo setMotion: MoveTo 278 101 self)
				else
					(gEgo setMotion: MoveTo 319 118 self)
				)
			)
			(1
				(if register
					(global2 newRoom: 315)
				else
					(gEgo hide:)
					(global2 newRoom: 320)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRogInTrunk of Script
	(properties)
	
	(method (doit)
		(if (and (not (gEgo isNotHidden:)) (gEgo mover?))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (gEgo looper?) ((gEgo looper?) dispose:))
				(gEgo setCycle: 0 setLoop: -1)
				(if (proc0_1 15) (wd40 setScript: sWD40LandOverRog))
				(if (< (gEgo x?) 160)
					(gEgo
						view: 410
						setLoop: 2
						cel: 0
						scaleX: 128
						scaleY: 128
						setScale: 0
						x: 69
						y: 135
						setCycle: End self
					)
				else
					(gEgo
						view: 410
						setLoop: 0
						setPri: -1
						cel: 0
						scaleX: 128
						scaleY: 128
						setScale: 0
						x: 249
						y: 163
						setCycle: End self
					)
				)
			)
			(1 (gEgo hide:) (= seconds 3))
			(2
				(rogEyes init: setScript: sEyes)
				(gSQ5 handsOn:)
				(if (wd40 script?) (gSq5IconBar disable: 0))
			)
			(3
				(gSQ5 handsOff:)
				(rogEyes dispose:)
				(= seconds 3)
			)
			(4
				(if (< gPEventX 160)
					(gEgo
						view: 410
						setLoop: 3
						cel: 0
						x: 64
						y: 136
						show:
						setCycle: End self
					)
				else
					(gEgo
						view: 410
						setLoop: 1
						cel: 0
						x: 255
						y: 162
						show:
						setCycle: End self
					)
				)
			)
			(5
				(proc0_6 0)
				(if (< (gEgo x?) 160)
					(gEgo
						x: 64
						y: 136
						setLoop: -1
						loop: 1
						setScale: Scaler 100 65 172 105
						setMotion: MoveTo 36 131 self
					)
				else
					(gEgo
						x: 255
						y: 162
						setLoop: -1
						loop: 0
						setScale: Scaler 95 57 148 111
						setMotion: MoveTo 291 152 self
					)
				)
			)
			(6
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogSlip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (proc0_1 10)
					(gTestMessager say: 1 0 0 0)
					(gEgo setMotion: MoveTo 93 112 self)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
			(2
				(gSq5Music2 number: 102 setLoop: 1 play:)
				(gEgo
					view: 414
					setLoop: -1
					setLoop: 0
					cel: 0
					x: 118
					y: 102
					setPri: 9
					ignoreActors:
					scaleX: 128
					scaleY: 128
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(gSq5Music2 number: 417 setLoop: 1 play:)
				(= seconds 2)
			)
			(4
				(gEgo
					view: 414
					setLoop: -1
					setLoop: 0
					cel: (gEgo lastCel:)
					scaleX: 128
					scaleY: 128
					setScale: 0
					setStep: 2 6
					moveSpeed: 0
					setMotion: MoveTo 118 150 self
				)
				(treeBranch
					setLoop: -1
					setLoop: 1
					setCel: 0
					setCycle: 0
					setStep: 2 6
					moveSpeed: 0
					setMotion: MoveTo 127 150
				)
			)
			(5
				(gSq5Music2 number: 411 setLoop: 1 play:)
				(gEgo
					view: 417
					setLoop: -1
					setLoop: 2
					cel: 0
					x: 146
					y: 158
					setCycle: Fwd
					setStep: 4 6
					setMotion: MoveTo 63 172 self
					cycleSpeed: 6
					moveSpeed: 6
				)
			)
			(6
				(gEgo
					view: 417
					setLoop: -1
					setLoop: 1
					cel: 0
					x: 47
					y: 169
					setStep: 3 7
					setCycle: 0
					setMotion: MoveTo 47 205 self
				)
			)
			(7
				(gSq5Music2 number: 411 setLoop: 1 play: self)
				(treeBranch
					setLoop: -1
					setLoop: 1
					setCel: 0
					setCycle: 0
					setStep: 4 6
					setMotion: MoveTo 40 169 self
					moveSpeed: 6
				)
			)
			(8
				(treeBranch
					setLoop: 1
					setCel: 0
					setCycle: 0
					setStep: 4 6
					setMotion: MoveTo 40 210 self
				)
			)
			(9
				(treeBranch dispose:)
				(proc0_2 11)
				(proc0_2 10)
				(global2 newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sRogClimbOnOffTrunk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (not register)
					(gEgo setMotion: PolyPath 78 121 self)
				else
					(gEgo setMotion: PolyPath 65 132 self)
				)
			)
			(1
				(if (not register) (= state 3))
				(= cycles 1)
			)
			(2
				(gOldWH addToFront: leftLedge)
				(gEgo
					view: 410
					setLoop: -1
					setLoop: 4
					cel: 0
					x: 74
					y: 132
					scaleX: 128
					scaleY: 128
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(proc0_6 0)
				(gEgo x: 78 y: 121 loop: 4 setPri: 15 setScale: myScaler)
				(= local6 1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
			(4
				(gEgo
					view: 410
					setLoop: -1
					setLoop: 4
					cel: (gEgo lastCel:)
					x: 74
					y: 132
					scaleX: 128
					scaleY: 128
					setScale: 0
					setPri: -1
					setCycle: Beg self
				)
				(gOldWH delete: leftLedge)
			)
			(5
				(proc0_6 0)
				(gEgo
					x: 70
					y: 126
					setScale: Scaler 100 65 172 105
					setMotion: MoveTo 41 130 self
				)
				(= local6 0)
			)
			(6
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local3 0)
					(rogEyes setLoop: (Random 0 3) setCel: 0)
				else
					(rogEyes setLoop: 0 setCel: 0)
				)
				(= ticks (Random 25 40))
			)
			(1
				(rogEyes setCel: 1)
				(= ticks 10)
			)
			(2 (= state -1) (= cycles 1))
		)
	)
)

(instance sKnockRogOffTrunk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(if (not (proc999_4 132 125 165 145 gEgo))
					(self dispose:)
				else
					(gSQ5 handsOff:)
					(gEgo
						view: 411
						setLoop: -1
						setLoop: 4
						cel: 0
						x: 140
						y: 143
						setCycle: End self
					)
					(gSq5Music2 number: 416 setLoop: 1 play:)
				)
			)
			(2
				(gEgo
					setLoop: -1
					setLoop: 4
					setCycle: 0
					setStep: 3 10
					setMotion: MoveTo 140 215 self
				)
			)
			(3 (global2 newRoom: 300))
		)
	)
)

(instance sGetHead of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 37 134 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gEgo view: 19 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo get: 20)
				(proc0_10 210 25)
				(wdHead dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_6 0)
				(gEgo loop: 1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkToTree of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 113 98 self)
			)
			(1 (self dispose:))
		)
	)
)

(instance sFrom320 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					posn: 318 118
					setScale: Scaler 95 57 148 111
					init:
					setPri: 8
					setMotion: MoveTo 296 125 self
				)
			)
			(1
				(gEgo setPri: -1 setMotion: MoveTo 306 140 self)
			)
			(2 (gEgo setHeading: 180 self))
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wd40 of Actor
	(properties
		x 20
		y 20
		noun 4
		modNum 301
		view 400
		loop 8
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(22
				(if
					(and
						(not (proc0_1 21))
						(== (wd40 x?) 164)
						(== (wd40 y?) 132)
					)
					(gEgo setScript: sFruitUpWD40)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogEyes of Prop
	(properties
		x 158
		y 142
		view 412
		priority 15
		signal $4010
	)
)

(instance fireBall of Actor
	(properties
		x 175
		y 89
		view 402
		signal $4000
	)
)

(instance treeBranch of Actor
	(properties
		x 127
		y 99
		noun 2
		view 414
		loop 1
		priority 8
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (< (gEgo x?) 128)
					(global2 setScript: sWalkToTree)
				else
					(gTestMessager say: 12 0 0 0)
				)
			)
			(3
				(if (< (gEgo x?) 128)
					(global2 setScript: sWalkToTree)
				else
					(gTestMessager say: 12 0 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance falls of Prop
	(properties
		x 40
		y 169
		noun 16
		view 417
		priority 1
		signal $4010
	)
)

(instance vine of Prop
	(properties
		x 220
		y 8
		noun 24
		view 415
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if local6
					(global2 setScript: sVineSwing)
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

(instance fruit of Prop
	(properties
		x 280
		y 48
		noun 15
		view 413
		loop 2
		cel 3
		priority 8
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(21
				(cond 
					(
						(and
							(not (proc0_1 207))
							(proc999_4 280 122 319 189 gEgo)
						)
						(global2 setScript: sSwingFruit)
					)
					((proc0_1 207) (gTestMessager say: 14 0 0 0))
					(else (gTestMessager say: 6 0 0 0))
				)
			)
			(4
				(if (fruit cycler?)
					(fruitGrabArea doVerb: theVerb)
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

(instance wdHead of Prop
	(properties
		x 19
		y 137
		noun 27
		view 426
		loop 3
		cel 2
		priority 1
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if
				(and (not local6) (proc999_4 0 0 120 189 gEgo))
					(global2 setScript: sGetHead)
				else
					(gTestMessager say: 6 0 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance treeTrunk of Feature
	(properties
		x 200
		y 155
		noun 17
		onMeCheck $2000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					(local6 (global2 setScript: sRogClimbOnOffTrunk 0 0))
					((> (gEgo x?) 60) (gTestMessager say: 7 0 0 0))
					(else (global2 setScript: sRogClimbOnOffTrunk 0 1))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fruitGrabArea of Feature
	(properties
		x 280
		noun 15
		nsTop 89
		nsLeft 256
		nsBottom 100
		nsRight 300
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (fruit cycler?)
					(if
						(and
							(== local5 1)
							(== (gEgo x?) 306)
							(== (gEgo y?) 141)
						)
						(= local4 1)
						(gSQ5 handsOff:)
					else
						(gTestMessager say: 11 0 0 0)
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

(instance cave315 of Feature
	(properties
		x 262
		y 98
		noun 3
		onMeCheck $0080
	)
)

(instance cave320 of Feature
	(properties
		x 304
		y 110
		noun 4
		onMeCheck $0200
	)
)

(instance extraFruit of Feature
	(properties
		x 293
		y 70
		noun 8
		onMeCheck $0002
	)
)

(instance mountains of Feature
	(properties
		x 229
		y 111
		noun 18
		onMeCheck $0100
	)
)

(instance pond of Feature
	(properties
		x 111
		y 162
		noun 20
		onMeCheck $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(gTestMessager say: noun 4 0 0)
			)
			(4
				(gTestMessager say: noun theVerb 0 0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roots of Feature
	(properties
		x 267
		y 139
		noun 22
		onMeCheck $0040
	)
)

(instance tree of Feature
	(properties
		x 115
		y 103
		noun 23
		onMeCheck $0020
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (< (gEgo x?) 128)
					(global2 setScript: sWalkToTree)
				else
					(gTestMessager say: 12 0 0 0)
				)
			)
			(3
				(if (< (gEgo x?) 128)
					(global2 setScript: sWalkToTree)
				else
					(gTestMessager say: 12 0 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wfall of Feature
	(properties
		x 146
		y 81
		noun 25
		onMeCheck $0008
	)
)

(instance leftLedge of Feature
	(properties
		x 25
		y 112
		nsTop 112
		nsBottom 189
		nsRight 50
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((proc999_4 265 119 319 189 gEgo) (gTestMessager say: 19 1 0 0))
					((proc0_1 16) (gTestMessager say: 21 theVerb 2 0))
					(else (gTestMessager say: 21 theVerb 1 0))
				)
			)
			(4
				(if local6
					(global2 setScript: sRogClimbOnOffTrunk 0 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(3
				(if local6
					(global2 setScript: sRogClimbOnOffTrunk 0 0)
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

(instance rightLedge of Feature
	(properties
		x 295
		y 119
		nsTop 119
		nsLeft 265
		nsBottom 189
		nsRight 319
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((proc999_4 0 112 50 189 gEgo) (gTestMessager say: 19 1 0 0))
					((proc0_1 16) (gTestMessager say: 21 theVerb 2 0))
					(else (gTestMessager say: 21 theVerb 1 0))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myScaler of Scaler
	(properties)
	
	(method (init theClient)
		(if argc (= client theClient))
		(self doit:)
	)
	
	(method (doit)
		(if (> (gEgo x?) 142)
			(gEgo scaleSignal: 1 scaleX: 128 scaleY: 128)
		else
			(gEgo
				scaleSignal: 1
				scaleX: (- 128 (/ (- 142 (gEgo x?)) 2))
				scaleY: (gEgo scaleX?)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties
		flags $0001
	)
)
