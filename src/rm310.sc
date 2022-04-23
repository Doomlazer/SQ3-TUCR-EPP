;;; Sierra Script 1.0 - (do not remove this comment)
(script# 310)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm310 0
)

(instance rm310 of Rm
	(properties
		noun 7
		picture 61
	)
	
	(method (init)
		(self setRegions: 350)
		(proc958_0 128 419 402 401)
		(proc0_6 0)
		(gEgo actions: (ScriptID 350 1))
		(switch gGModNum
			(300
				(= style -32758)
				(global2 setScript: sEnterFromTunnelA)
			)
			(305
				(= style 11)
				(gEgo
					setScale: Scaler 100 48 172 123
					init:
					edgeHit: 0
					posn: 308 159
				)
				(gSQ5 handsOn:)
			)
			(else 
				(= style -32758)
				(global2 setScript: sEnterFromTunnelB)
			)
		)
		(tunnelA init: setOnMeCheck: 1 2)
		(tunnelB init: setOnMeCheck: 1 4)
		(bush init: setOnMeCheck: 1 32)
		(fern init: setOnMeCheck: 1 64)
		(outcrop init: setOnMeCheck: 1 128)
		(path init: setOnMeCheck: 1 256)
		(wd40 init:)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						180
						122
						164
						129
						146
						148
						146
						176
						227
						182
						290
						173
						319
						149
						319
						138
						307
						145
						269
						125
						253
						132
						276
						147
						278
						150
						269
						154
						244
						159
						215
						159
						205
						150
						204
						135
						197
						127
						186
						123
						185
						98
						176
						105
					yourself:
				)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(cond 
			(
				(and
					(== (= temp0 (gEgo onControl: 1)) 8)
					(not (wd40 script?))
					(not (== gGModNum 315))
					(or (not (proc0_1 14)) (proc0_1 15))
				)
				(wd40 setScript: sWD40Appear)
			)
			((and (== temp0 2) (not (global2 script?))) (global2 setScript: sExitViaTunnelB))
			((and (== temp0 4) (not (global2 script?))) (global2 setScript: sExitViaTunnelA))
			(
			(and (== temp0 16384) (not (global2 script?))) (global2 setScript: sExitViaScroll))
		)
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

(instance sEnterFromTunnelA of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					x: 255
					y: 125
					setScale: Scaler 100 48 172 123
					init:
					setMotion: MoveTo 298 152 self
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelA of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 255 135 self)
			)
			(1
				(global2 newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromTunnelB of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					x: 178
					y: 110
					setScale: Scaler 100 48 172 123
					init:
					setMotion: MoveTo 186 131 self
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelB of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 182 109 self)
			)
			(1
				(global2 newRoom: 315)
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
				(gEgo setMotion: MoveTo 335 144 self)
			)
			(1 (global2 newRoom: 305))
		)
	)
)

(instance sWD40Appear of Script
	(properties)
	
	(method (doit)
		(if (> (gEgo y?) 144)
			(cond 
				((and (< 2 state) (< state 6)) (= ticks (= seconds 0)) (= state 5) (self cue:))
				((== state 0) (self dispose:))
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 7))
			(1
				(gSQ5 handsOff:)
				(gSq5Music1 number: 35 loop: -1 play:)
				(if (proc0_1 15)
					(wd40
						view: 419
						cel: 5
						x: 253
						y: 0
						setLoop: -1
						setLoop: 0
						setCycle: 0
						setMotion: MoveTo 255 43 self
					)
				else
					(gSq5Music2 number: 404 setLoop: 1 play:)
					(wd40 loop: 0 cel: 0 setCycle: CT 5 1 self)
				)
			)
			(2 (wd40 setCycle: End self))
			(3
				(gSQ5 handsOn:)
				(if (== (global2 script?) sExitViaTunnelB)
					(self dispose:)
				else
					(proc0_2 66)
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 245
						y: 19
						setStep: 15 5
						moveSpeed: 0
						init:
						setMotion: MoveTo (+ (gEgo x?) 7) (- (gEgo y?) 10) self
					)
				)
			)
			(4
				(gSq5Music2 number: 4021 setLoop: 1 play:)
				(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(fireBall dispose:)
				(= seconds 7)
			)
			(6
				(if (== (global2 script?) sExitViaTunnelB)
					(self dispose:)
				else
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 245
						y: 19
						setStep: 15 5
						moveSpeed: 0
						init:
						setMotion: MoveTo (+ (gEgo x?) 2) (- (gEgo y?) 18) self
					)
				)
			)
			(7
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
			(8
				(proc0_9 17)
				(self dispose:)
			)
		)
	)
)

(instance wd40 of Actor
	(properties
		x 257
		y 43
		yStep 6
		view 419
		priority 14
		signal $0010
	)
	
	(method (doVerb theVerb)
		(if
			(not
				(if
				(and (== (self view?) 419) (== (self loop?) 0))
					(== (self cel?) 0)
				)
			)
			(gTestMessager say: 4 theVerb 0 0 0 301)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fireBall of Actor
	(properties
		x 245
		y 19
		view 402
	)
)

(instance tunnelA of Feature
	(properties
		x 303
		y 128
		noun 3
		onMeCheck $0002
	)
)

(instance tunnelB of Feature
	(properties
		x 186
		y 114
		noun 2
		onMeCheck $0004
	)
)

(instance bush of Feature
	(properties
		x 174
		y 54
		noun 1
		onMeCheck $0020
	)
)

(instance fern of Feature
	(properties
		x 267
		y 166
		noun 4
		onMeCheck $0040
	)
)

(instance outcrop of Feature
	(properties
		x 259
		y 41
		noun 5
		onMeCheck $0080
	)
)

(instance path of Feature
	(properties
		x 206
		y 161
		noun 6
		onMeCheck $0100
	)
)
