;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
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
	rm300 0
)

(instance rm300 of Rm
	(properties
		noun 12
		picture 60
		vanishingX 80
		vanishingY -10
	)
	
	(method (init)
		(self setRegions: 350)
		(proc958_0 128 6 407 406 402 401 405 190 426)
		(wd40 view: 406 loop: 0 cel: 4 x: 283 y: 63 init: hide:)
		(proc0_6 0)
		(gEgo actions: (ScriptID 350 1))
		(switch gGModNum
			(305
				(gEgo edgeHit: 0)
				(if (proc0_1 11)
					(treeBranch
						x: 43
						y: 28
						setCycle: 0
						setLoop: -1
						setLoop: 6
						moveSpeed: 0
						setStep: 3 13
						init:
						setScript: sStickFalling
					)
				)
				(global2 setScript: sRogSwimToShore)
				(global2 style: 13)
			)
			(310
				(global2 setScript: sEnterFromTunnelA)
				(if
					(and
						(proc0_1 14)
						(not (proc0_1 15))
						(not (proc0_1 16))
					)
					(flash1 init: setCycle: Osc)
					(flash2 init: setCycle: Osc)
					(flash3 init: setCycle: Osc)
				)
			)
			(else 
				(if (or (not (proc0_1 20)) (proc0_1 212))
					(gSq5Music1 number: 15 loop: -1 play: 0 fade: 127 10 5 0)
					(global2 setScript: sBeamIn)
				else
					(gEgo
						posn: 243 150
						loop: 2
						setScale: Scaler 122 59 169 126
						init:
					)
					(gSQ5 handsOn:)
				)
			)
		)
		(gOldWH addToFront: pond)
		(super init:)
		(theMusic3
			number: 403
			owner: self
			flags: 1
			init:
			setLoop: -1
			play: 90
		)
		(reflection init:)
		(bubbles init:)
		(lowerFalls init:)
		(if (and (proc0_1 16) (not (proc0_1 17)))
			(wd40Parts init:)
			(sEnterFromTunnelA next: sCliffyHere)
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							140
							124
							147
							119
							157
							119
							200
							133
							213
							129
							182
							124
							189
							106
							186
							107
							160
							103
							154
							103
							145
							103
							131
							100
							124
							102
							120
							102
							79
							109
							73
							110
							40
							110
							34
							103
							39
							79
							30
							79
							0
							124
						yourself:
					)
			)
		else
			(global2
				addObstacle:
					((Polygon new:)
						type: 3
						init:
							152
							124
							213
							141
							218
							146
							198
							150
							204
							153
							178
							167
							249
							171
							284
							144
							250
							134
							232
							133
							215
							133
							182
							124
							189
							106
							186
							107
							160
							103
							154
							103
							145
							103
							131
							100
							124
							102
							120
							102
							79
							109
							73
							110
							40
							110
							34
							103
							39
							79
							30
							79
							0
							124
						yourself:
					)
			)
		)
		(if (proc0_1 12) (treeBranch init:))
		(tunnelA init: setOnMeCheck: 1 2)
		(bigTree init: setOnMeCheck: 1 64)
		(ferns init: setOnMeCheck: 1 128)
		(smallTree init: setOnMeCheck: 1 256)
		(pond init: setOnMeCheck: 1 512)
		(wfall init: setOnMeCheck: 1 1024)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(Palette palANIMATE 240 248 5 249 255 8)
		(cond 
			(
				(and
					(== (= temp0 (gEgo onControl: 1)) 2)
					(not (global2 script?))
				)
				(global2 setScript: sATunnel)
			)
			(
				(and
					(== temp0 16)
					(not (proc0_1 16))
					(not (wd40 script?))
				)
				(wd40 setScript: sWD40Land)
			)
		)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(gOldWH delete: pond)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager say: noun theVerb 0 (Random 1 3))
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sBeamIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_10 205 10)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo
					view: 6
					posn: 240 150
					scaleSignal: 1
					scaleX: 120
					scaleY: 120
					init:
					setCycle: End self
				)
			)
			(2
				(proc0_6 0)
				(gEgo
					posn: 243 150
					loop: 2
					setScale: Scaler 122 59 169 126
				)
				(= seconds 3)
			)
			(3
				(if (proc0_1 9) (= state (+ state 2)))
				(= cycles 1)
			)
			(4
				(gTestMessager say: 10 0 0 0 self)
			)
			(5 (global2 newRoom: 320))
			(6
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogSwimToShore of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 407
					loop: 0
					cel: 0
					x: 99
					y: 148
					setScale: 0
					init:
					setCycle: Osc 3 self
					cycleSpeed: 6
					moveSpeed: 6
				)
			)
			(1
				(gEgo loop: 4 cel: 0 x: 99 y: 148)
				(= ticks 5)
			)
			(2
				(gEgo
					cel: 0
					x: 103
					y: 150
					setCycle: Fwd
					setLoop: -1
					setLoop: 1
					setMotion: MoveTo 156 158 self
				)
			)
			(3
				(gEgo loop: 2 cel: 0 x: 199 y: 140 setCycle: End self)
			)
			(4
				(gEgo loop: 3 cel: 0 x: 212 y: 157 setCycle: CT 2 1 self)
			)
			(5
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(6 (gEgo setCycle: End self))
			(7
				(gEgo cel: 0 setCycle: CT 2 1 self)
			)
			(8
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(9 (gEgo setCycle: End self))
			(10
				(proc0_6 0)
				(gEgo loop: 2 setScale: Scaler 122 59 169 126)
				(if (not (treeBranch script?)) (gSQ5 handsOn:))
				(self dispose:)
			)
		)
	)
)

(instance sStickFalling of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(treeBranch setMotion: MoveTo 40 150 self)
			)
			(1
				(gSq5Music2 number: 411 setLoop: 1 play:)
				(proc0_3 11)
				(proc0_2 12)
				(treeBranch
					setLoop: 5
					x: 42
					y: 139
					setStep: 2 10
					moveSpeed: 7
					setMotion: MoveTo 174 142 self
				)
			)
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sATunnel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 40 104 self)
			)
			(1
				(gSQ5 handsOn:)
				(global2 newRoom: 310)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromTunnelA of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					posn: 40 104
					setScale: Scaler 122 59 169 126
					init:
					setMotion: MoveTo 24 122 self
				)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(cond 
					(
						(and
							(proc0_1 14)
							(not (proc0_1 15))
							(not (proc0_1 16))
						)
						(= next sWD40InPool)
						(self dispose:)
					)
					((and (proc0_1 16) (not (proc0_1 17))) (= next sCliffyHere) (self dispose:))
					(else (gSQ5 handsOn:) (self dispose:))
				)
			)
		)
	)
)

(instance sWD40Land of Script
	(properties)
	
	(method (doit)
		(if (proc0_5 gEgo 8192)
			(if (== state 0) (self dispose:))
			(if (fireBall mover?)
				(= state 20)
			else
				(= seconds 0)
				(= ticks 1)
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 7))
			(1
				(if (not (proc999_4 0 106 184 128 gEgo))
					(self dispose:)
				else
					(gSQ5 handsOff:)
					(if (== (global2 script?) sATunnel)
						(sATunnel dispose:)
					)
					(windyBranch init: setCycle: End self)
					(gSq5Music2
						number: 401
						setLoop: 1
						play: 0
						fade: 127 10 10 0
					)
				)
			)
			(2
				(windyBranch
					loop: 5
					cel: 0
					x: 166
					y: 8
					setCycle: End self
				)
			)
			(3
				(windyBranch
					loop: 6
					cel: 0
					x: 215
					y: 45
					setCycle: End self
				)
			)
			(4
				(windyBranch
					loop: 7
					cel: 0
					x: 189
					y: 36
					setCycle: End self
				)
			)
			(5
				(windyBranch
					loop: 8
					cel: 0
					x: 255
					y: 62
					setCycle: End self
				)
			)
			(6
				(windyBranch view: 406 loop: 3 cel: 0 x: 253 y: 165)
				(gSq5Music1 number: 35 loop: -1 play:)
				(if (proc0_1 15)
					(wd40 view: 406 loop: 0 cel: 4 x: 283 y: 63 show:)
					(= ticks 10)
				else
					(wd40
						view: 406
						loop: 0
						cel: 0
						x: 250
						y: 110
						show:
						setCycle: CT 2 1 self
					)
					(= state (+ state 2))
				)
			)
			(7
				(wd40 x: 276 y: 72)
				(= ticks 10)
			)
			(8
				(wd40 x: 267 y: 85)
				(= ticks 10)
			)
			(9
				(windyBranch setCel: 1)
				(if (proc0_1 15)
					(wd40 x: 258 y: 97)
				else
					(wd40 setCel: 3)
				)
				(= ticks 10)
			)
			(10
				(windyBranch setCel: 2)
				(if (proc0_1 15)
					(wd40 x: 250 y: 110)
				else
					(wd40 setCel: 4)
				)
				(= ticks 10)
			)
			(11
				(windyBranch dispose:)
				(wd40 loop: 2 cel: 0 x: 218 y: 152 setCycle: End self)
			)
			(12
				(gSq5Music2 stop:)
				(theMusic3 play: 90)
				(wd40 loop: 1 cel: 0 setCycle: End self)
			)
			(13
				(if (not (proc0_1 66))
					(gTestMessager say: 1 0 0 0 self)
				else
					(= cycles 1)
				)
			)
			(14
				(gSQ5 handsOn:)
				(proc0_2 66)
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 207
					y: 114
					setStep: 15 5
					moveSpeed: 0
					init:
					setMotion: MoveTo (+ (gEgo x?) 7) (- (gEgo y?) 10) self
				)
			)
			(15
				(gSq5Music2 number: 4021 setLoop: 1 play:)
				(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
			)
			(16
				(fireBall hide:)
				(= seconds 6)
			)
			(17
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 207
					y: 114
					show:
					setMotion: MoveTo (+ (gEgo x?) 7) (- (gEgo y?) 10) self
				)
			)
			(18
				(gSq5Music2 number: 4021 setLoop: 1 play:)
				(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
			)
			(19
				(fireBall hide:)
				(= seconds 4)
			)
			(20
				(gSq5Music2 number: 402 setLoop: 1 play:)
				(gSQ5 handsOff:)
				(fireBall
					view: 402
					loop: 0
					cel: 0
					x: 207
					y: 114
					show:
					setMotion: MoveTo (+ (gEgo x?) 2) (- (gEgo y?) 18) self
				)
			)
			(21
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
			(22
				(proc0_9 17)
				(self dispose:)
			)
		)
	)
)

(instance sWD40InPool of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2 15)
				(gSq5Music2 number: 145 setLoop: -1 play:)
				(= seconds 5)
			)
			(1
				(flash1 dispose:)
				(flash2 dispose:)
				(flash3 dispose:)
				(gSq5Music2 fade:)
				(= seconds 2)
			)
			(2 (splash init:) (= cycles 1))
			(3
				(splash cel: 1)
				(wd40
					view: 408
					loop: 6
					cel: 0
					x: 116
					y: 128
					setStep: 2 10
					moveSpeed: 0
					show:
				)
				(gSq5Music1 number: 35 loop: -1 play:)
				(gSq5Music2 number: 401 setLoop: 1 play:)
				(= ticks 5)
			)
			(4
				(splash cel: 2)
				(wd40 cel: 1 x: 120 y: 109)
				(= ticks 5)
			)
			(5
				(splash cel: 3)
				(wd40
					setLoop: -1
					setLoop: 6
					setCel: 2
					x: 128
					y: 86
					setMotion: MoveTo 159 -55 self
				)
				(= cycles 1)
			)
			(6 (splash dispose:))
			(7
				(gSq5Music2 stop:)
				(theMusic3 play: 90)
				(gTestMessager say: 17 0 0 0 self)
			)
			(8
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCliffyHere of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(cliffy init: setCycle: End self)
			)
			(1
				(cliffy view: 20 loop: 2 setHeading: 0 self)
			)
			(2
				(cliffy view: 190 loop: 6 cel: 0 setCycle: Osc 2 self)
			)
			(3
				(gEgo setMotion: PolyPath 172 128 self)
				(cliffy setScript: sCliffy)
			)
			(4 (gEgo setHeading: 180 self))
			(5
				(gTestMessager say: 8 0 0 0 self)
			)
			(6
				(gTestMessager
					say: 14 0 (if (gEgo has: 20) 3 else 4) 0 self
				)
			)
			(7
				(proc0_2 17)
				(if (gEgo has: 20)
					(gSq5Music2 number: 260 setLoop: 1 play:)
					(gEgo
						view: 6
						loop: 0
						cel: (gEgo lastCel:)
						setCycle: Beg self
					)
					(= global130 6)
				else
					(= global130 7)
					(gSQ5 handsOn:)
					(self dispose:)
				)
			)
			(8
				(proc0_2 9)
				(global2 newRoom: 240)
			)
		)
	)
)

(instance sCliffy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 5)))
			(1
				(cliffy view: 26 loop: (Random 0 2) cel: 0)
				(if (== (cliffy loop?) 1)
					(cliffy setCycle: End self)
				else
					(= state -1)
					(cliffy setCycle: Osc 1 self)
				)
			)
			(2 (= seconds 3))
			(3
				(= state -1)
				(cliffy setCycle: Beg self)
			)
			(4 (self dispose:))
		)
	)
)

(instance sGetBranch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 203 138 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gEgo view: 19 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo get: 17)
				(proc0_10 206 10)
				(proc0_3 12)
				(treeBranch dispose:)
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

(instance wd40 of Actor
	(properties
		x 10
		y 10
		noun 4
		modNum 301
		view 400
		priority 14
		signal $6010
	)
)

(instance treeBranch of Actor
	(properties
		x 174
		y 142
		noun 13
		yStep 6
		view 407
		loop 5
		priority 13
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sGetBranch)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireBall of Actor
	(properties
		x 273
		y 59
		yStep 5
		view 402
		xStep 15
		moveSpeed 0
	)
)

(instance bubbles of Prop
	(properties
		x 43
		y 137
		view 405
		loop 1
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance reflection of Prop
	(properties
		x 116
		y 133
		view 405
		priority 13
		signal $4010
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance lowerFalls of Prop
	(properties
		x 104
		y 184
		view 405
		loop 2
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance windyBranch of Prop
	(properties
		x 118
		y 27
		view 406
		loop 4
		signal $4000
	)
)

(instance splash of Prop
	(properties
		x 110
		y 144
		view 408
		priority 15
		signal $4010
	)
)

(instance flash1 of Prop
	(properties
		x 93
		y 151
		view 408
		loop 1
		cel 3
		cycleSpeed 15
	)
)

(instance flash2 of Prop
	(properties
		x 108
		y 165
		view 408
		loop 2
		cel 1
		cycleSpeed 10
	)
)

(instance flash3 of Prop
	(properties
		x 173
		y 174
		view 408
		loop 4
		cel 3
		cycleSpeed 5
	)
)

(instance cliffy of Actor
	(properties
		x 217
		y 139
		noun 6
		view 33
		scaleSignal $0001
	)
	
	(method (init)
		(super init: &rest)
		(self setScale: Scaler 96 49 154 117)
	)
)

(instance wd40Parts of View
	(properties
		x 181
		y 136
		noun 16
		view 426
		loop 2
		cel 9
	)
	
	(method (init)
		(super init:)
		(wd40Part1 init:)
		(wd40Part2 init:)
		(wd40Part3 init:)
		(wd40Part4 init:)
		(wd40Part5 init:)
		(wd40Part6 init:)
		(wd40Part7 init:)
		(wd40Part8 init:)
		(wd40Part9 init:)
	)
)

(instance wd40Part1 of View
	(properties
		x 156
		y 127
		noun 16
		view 426
		loop 2
	)
)

(instance wd40Part2 of View
	(properties
		x 197
		y 124
		noun 16
		view 426
		loop 2
		cel 1
	)
)

(instance wd40Part3 of View
	(properties
		x 208
		y 127
		noun 16
		view 426
		loop 2
		cel 2
	)
)

(instance wd40Part4 of View
	(properties
		x 255
		y 139
		noun 16
		view 426
		loop 2
		cel 3
	)
)

(instance wd40Part5 of View
	(properties
		x 221
		y 158
		noun 16
		view 426
		loop 2
		cel 4
	)
)

(instance wd40Part6 of View
	(properties
		x 199
		y 141
		noun 16
		view 426
		loop 2
		cel 5
	)
)

(instance wd40Part7 of View
	(properties
		x 247
		y 152
		noun 16
		view 426
		loop 2
		cel 6
	)
)

(instance wd40Part8 of View
	(properties
		x 273
		y 149
		noun 16
		view 426
		loop 2
		cel 7
	)
)

(instance wd40Part9 of View
	(properties
		x 225
		y 145
		noun 16
		view 426
		loop 2
		cel 8
	)
)

(instance tunnelA of Feature
	(properties
		x 25
		y 103
		noun 5
		onMeCheck $0002
	)
)

(instance bigTree of Feature
	(properties
		x 241
		y 105
		noun 2
		onMeCheck $0040
	)
)

(instance ferns of Feature
	(properties
		x 204
		y 166
		noun 7
		onMeCheck $0080
	)
)

(instance smallTree of Feature
	(properties
		x 153
		y 138
		noun 9
		onMeCheck $0100
	)
)

(instance pond of Feature
	(properties
		x 119
		y 133
		noun 11
		onMeCheck $0200
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

(instance wfall of Feature
	(properties
		x 57
		y 114
		noun 15
		onMeCheck $0400
	)
)

(instance theMusic3 of Sound
	(properties
		flags $0001
	)
)
