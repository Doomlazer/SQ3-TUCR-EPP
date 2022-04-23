;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1030)
(include sci.sh)
(use Main)
(use Scaler)
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
	rm1030 0
)

(local
	[local0 2] = [210 192]
	[local2 2] = [141 108]
	local4
	local5
	local6
)
(procedure (localproc_0052)
	(= global144 (= global143 (Random 0 3)))
	(doortop setCel: (doortop lastCel:))
	(global2 setScript: sExitSubfloor 0 0)
)

(procedure (localproc_0080)
	(= global144 (= global143 (* 2 (Random 0 1))))
	(doorbtm setCel: (doorbtm lastCel:))
	(global2 setScript: sExitSubfloor 0 1)
)

(instance rm1030 of Rm
	(properties
		noun 5
		picture 124
		style $800a
		vanishingX 179
		vanishingY 83
	)
	
	(method (init)
		(proc958_0 128 670)
		(gEgo y: 189)
		(switch global133
			(1 (= local4 3) (= local5 4))
			(2 (= local4 3) (= local5 4))
			(3 (= local4 3) (= local5 4))
			(4
				(if (== global134 3)
					(= local4 3)
					(= local5 4)
				else
					(= local4 6)
					(= local5 7)
				)
			)
			(5 (= local4 6) (= local5 7))
			(6
				(if (== global134 2)
					(= local4 6)
					(= local5 7)
				else
					(= local4 8)
					(= local5 9)
				)
			)
			(7
				(cond 
					((== global134 3) (= local4 7) (= local5 8))
					((== global134 2) (= local4 6) (= local5 7))
					(else (= local4 8) (= local5 9))
				)
			)
			(8
				(if (== global134 3)
					(= local4 7)
					(= local5 8)
				else
					(= local4 8)
					(= local5 9)
				)
			)
			(9 (= local4 8) (= local5 9))
		)
		(switch gGModNum
			(1020
				(switch global133
					(3 (localproc_0052))
					(4 (localproc_0080))
					(6 (localproc_0052))
					(7
						(if (== global134 3)
							(localproc_0052)
						else
							(localproc_0080)
						)
					)
					(8
						(if (== global134 3)
							(localproc_0080)
						else
							(localproc_0052)
						)
					)
					(9 (localproc_0080))
				)
			)
			(else 
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 0
					cel: 0
					x: 218
					y: 159
					init:
					setScale: Scaler 111 26 158 96
					setCycle: Walk
				)
			)
		)
		(doortop init:)
		(doorbtm init:)
		(turbbtm init:)
		(turboDoors init: setOnMeCheck: 1 16384)
		(ladder init: setOnMeCheck: 1 64)
		(switch global143
			(0
				(liftTop scaleX: 90 scaleY: 90 init: setScript: sLift)
			)
			(1
				(liftTop scaleX: 160 scaleY: 160 init: setScript: sLift)
			)
			(else 
				(liftTop
					scaleX: 320
					scaleY: 320
					init:
					hide:
					setScript: sLift
				)
			)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init: 228 171 179 84 181 91 227 178
					yourself:
				)
		)
		(super init:)
		(gOldDH addToFront: doorbtm)
	)
	
	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 78 82 1 231 235 1)
		(cond 
			((and (!= global144 global143) (== local6 0)) (theMusic3 number: 128 setLoop: -1 play:) (= local6 1))
			((and (== global144 global143) (== local6 1)) (theMusic3 stop:) (= local6 0))
		)
		(cond 
			((proc0_5 gEgo 8192)
				(gEgo y: (+ (gEgo y?) 1) setMotion: 0)
				(gTestMessager say: 1 0 0 0)
			)
			(
				(and
					(> (gEgo y?) 160)
					(not (global2 script?))
					(not (gEgo script?))
				)
				(if (and (== global134 3) (> global133 6))
					(gTestMessager say: 2 0 0 0)
					(gEgo setMotion: 0 x: 215 y: 151)
				else
					(global2 newRoom: 1035)
				)
			)
		)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(gOldDH delete: doorbtm)
		(if (!= global144 global143)
			(= global144 0)
			(= global143 0)
		)
		(super dispose: &rest)
	)
)

(instance sEnterSubfloor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath [local0 register] [local2 (gSQ5 handsOff:)] self
				)
			)
			(1
				(gEgo setLoop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(if (== register 0)
					(doortop setCycle: End self)
				else
					(doorbtm setCycle: End self)
				)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(3 (gEgo setCycle: End self))
			(4
				(if (== register 0)
					(= global133 local4)
				else
					(= global133 local5)
				)
				(global2 newRoom: 1020)
				(self dispose:)
			)
		)
	)
)

(instance sExitSubfloor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 3)
			)
			(1
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 2
					setCel: (gEgo lastCel:)
					x: [local0 register]
					y: [local2 register]
					setScale: Scaler 111 26 158 96
					init:
					setCycle: CT 3 -1 self
				)
			)
			(2
				(if (== register 0)
					(doortop setCycle: Beg self)
				else
					(doorbtm setCycle: Beg self)
				)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gSQ5 handsOn:)
				(gEgo
					view: 670
					setLoop: -1
					setLoop: 0
					setCycle: Walk
					cel: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance sLift of Script
	(properties)
	
	(method (doit)
		(if
			(and
				(>
					(liftTop nsBottom?)
					(- (gEgo y?) (/ (gEgo scaleX?) 18))
				)
				(not (gEgo script?))
			)
			(if (== global144 global143)
				(= global144 3)
				(= seconds 0)
				(= state 1)
				(self cue:)
			)
			(gEgo setScript: sSquishRog)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo script?) (self dispose:) else (= seconds 15))
			)
			(1
				(switch global143
					(0 (= global144 (Random 1 3)))
					(1
						(if (Random 0 1)
							(= state 8)
							(= global144 0)
						else
							(= global144 (Random 2 (= state 3)))
						)
					)
					(else 
						(= state 5)
						(= global144 (Random 0 1))
					)
				)
				(= ticks 1)
			)
			(2
				(if (< (liftTop scaleX?) 160)
					(liftTop scaleX: (+ (liftTop scaleX?) 10))
					(liftTop scaleY: (+ (liftTop scaleY?) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(3
				(if (== (= global143 1) global144) (= state -1))
				(= cycles 1)
			)
			(4
				(if (< (liftTop scaleX?) 320)
					(liftTop scaleX: (+ (liftTop scaleX?) 10))
					(liftTop scaleY: (+ (liftTop scaleY?) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(5
				(= global143 global144)
				(liftTop hide:)
				(= state -1)
				(= cycles 1)
			)
			(6
				(liftTop show: scaleX: 320 scaleY: 320)
				(= cycles 1)
			)
			(7
				(if (> (liftTop scaleX?) 160)
					(liftTop scaleX: (- (liftTop scaleX?) 10))
					(liftTop scaleY: (- (liftTop scaleY?) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(8
				(if (== (= global143 1) global144) (= state -1))
				(= cycles 1)
			)
			(9
				(if (> (liftTop scaleX?) 90)
					(liftTop scaleX: (- (liftTop scaleX?) 10))
					(liftTop scaleY: (- (liftTop scaleY?) 10))
					(-- state)
				)
				(= ticks 10)
			)
			(10
				(= global143 0)
				(= state -1)
				(= cycles 1)
			)
			(11 (self dispose:))
		)
	)
)

(instance sSquishRog of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (> global143 global144)
					(= global144 0)
				else
					(= global144 3)
					(= state 1)
				)
				(= cycles 1)
			)
			(1
				(if (< (liftTop nsBottom?) (gEgo y?)) (-- state))
				(= cycles 1)
			)
			(2
				(gEgo view: 671 setLoop: -1 setLoop: 0 cel: 0 setCycle: 0)
				(= ticks 1)
			)
			(3
				(if (liftTop script?) (-- state))
				(= cycles 1)
			)
			(4 (gEgo setCycle: End self))
			(5
				(proc0_9 34)
				(self dispose:)
			)
		)
	)
)

(instance liftTop of Actor
	(properties
		x 167
		y 70
		noun 6
		view 670
		loop 5
		scaleSignal $0001
		scaleX 90
		scaleY 90
	)
	
	(method (doit)
		(super doit: &rest)
		(if (gEgo script?)
			(self setPri: 14)
		else
			(self setPri: (CoordPri nsBottom))
		)
	)
)

(instance doortop of Actor
	(properties
		x 157
		y 134
		noun 7
		view 670
		loop 7
		priority 1
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (gEgo script?))
					(global2 setScript: sEnterSubfloor 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorbtm of Actor
	(properties
		x 165
		y 106
		noun 7
		view 670
		loop 9
		priority 1
		signal $4010
	)
	
	(method (handleEvent pEvent)
		(return
			(if
				(and
					(gUser canControl:)
					(& (pEvent type?) evJOYSTICK)
					(== (gSq5IconBar curIcon?) (gSq5IconBar at: 0))
				)
				(switch (pEvent message?)
					(JOY_NULL (gEgo setMotion: 0))
					(JOY_UP
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 186 98)
						)
					)
					(JOY_UPRIGHT
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 186 98)
						)
					)
					(JOY_DOWNRIGHT
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 221 161)
						)
					)
					(JOY_DOWN
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 221 161)
						)
					)
					(JOY_DOWNLEFT
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 221 161)
						)
					)
					(JOY_UPLEFT
						(if (gEgo mover?)
							(gEgo setMotion: 0)
						else
							(gEgo setMotion: PolyPath 186 98)
						)
					)
				)
				(pEvent claimed: 1)
				(return 1)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (gEgo script?))
					(global2 setScript: sEnterSubfloor 0 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance turbbtm of View
	(properties
		x 176
		y 81
		view 670
		loop 11
	)
)

(instance turboDoors of Feature
	(properties
		x 160
		y 120
		noun 3
		onMeCheck $4000
	)
)

(instance ladder of Feature
	(properties
		x 220
		y 130
		noun 4
		onMeCheck $0040
	)
)

(instance theMusic3 of Sound
	(properties
		flags $0001
	)
)
