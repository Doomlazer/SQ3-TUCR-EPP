;;; Sierra Script 1.0 - (do not remove this comment)
(script# 204)
(include sci.sh)
(use Main)
(use sPushButtons)
(use eureka)
(use Osc)
(use Cycle)
(use View)
(use Obj)

(public
	sStartEggTimer 0
	proc204_1 1
	proc204_2 2
	sShowEggTimer 3
	eggTimer 4
	sStopEggTimer 5
)

(local
	local0
	[local1 16] = [234 80 238 77 243 82 242 82 235 82 227 83 227 83 228 83]
	[local17 2] = [219 235]
)
(procedure (proc204_1)
	(waddle init:)
	(lid init:)
	(chickenHead init:)
	(theButton init: hide:)
	(eggTimer init:)
)

(procedure (proc204_2)
	(theButton dispose:)
	(eggTimer dispose:)
	(chickenHead dispose:)
	(waddle dispose:)
	(lid dispose:)
	(sStartEggTimer dispose:)
	(if (gOldCast contains: d0)
		(d0 dispose:)
		(d1 dispose:)
		(d2 dispose:)
		(d3 dispose:)
	)
	(gOldCast eachElementDo: #startUpd)
)

(procedure (localproc_00fa)
	(d3 startUpd:)
	(d2 startUpd:)
	(d1 startUpd:)
	(d0 startUpd:)
	(if (and (< 0 (d0 cel?)) (< (d0 cel?) 10))
		(d0 cel: (- (d0 cel?) 1))
	else
		(if (== (d1 cel?) 10)
			(d0 cel: 10 stopUpd:)
		else
			(d0 cel: 9)
		)
		(if (and (< 0 (d1 cel?)) (< (d1 cel?) 6))
			(d1 cel: (- (d1 cel?) 1))
		else
			(if (== (d2 cel?) 10)
				(d1 cel: 10 stopUpd:)
			else
				(d1 cel: 5)
			)
			(if (and (< 1 (d2 cel?)) (< (d2 cel?) 10))
				(d2 cel: (- (d2 cel?) 1))
			else
				(cond 
					((== (d3 cel?) 10) (d2 cel: 10 stopUpd:))
					((== (d2 cel?) 1) (d2 cel: 0))
					(else (d2 cel: 9))
				)
				(if (and (< 0 (d3 cel?)) (< (d3 cel?) 10))
					(d3 cel: (- (d3 cel?) 1))
				else
					(d3 cel: 10 stopUpd:)
				)
			)
		)
	)
)

(procedure (localproc_0265 param1 &tmp temp0 temp1)
	(d0 cel: 10)
	(d1 cel: 10)
	(d2 cel: 10)
	(d3 cel: 10)
	(= temp0 (/ param1 60))
	(= temp1 (mod param1 60))
	(if temp0
		(d2 cel: (mod temp0 10))
		(if (= temp0 (/ temp0 10)) (d3 cel: (mod temp0 10)))
		(d0 cel: 0)
		(d1 cel: 0)
	)
	(if temp1
		(d0 cel: (mod temp1 10))
		(if (= temp1 (/ temp1 10)) (d1 cel: (mod temp1 10)))
	)
)

(instance sStopEggTimer of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(lid setMotion: MoveTo 209 56 self)
				(d0 dispose:)
				(d1 dispose:)
				(d2 dispose:)
				(d3 dispose:)
				(waddle setCycle: 0)
			)
			(1 (proc204_2) (= seconds 1))
			(2 (proc202_1) (= seconds 2))
			(3 (self dispose:))
		)
	)
)

(instance sStartEggTimer of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (proc0_1 84)
					(= cycles 1)
				else
					(eureka setScript: (ScriptID 210 9))
					(lid setMotion: MoveTo 209 27 self)
					(gSq5Music2 number: 219 loop: 1 play:)
					(if (>= (eureka puke?) 4) (proc0_10 201 100))
				)
			)
			(1
				(= next sShowEggTimer)
				((ScriptID 202 13) init:)
				((ScriptID 202 15) init:)
				(if (gOldCast contains: (ScriptID 202 14))
					((ScriptID 202 14) dispose:)
				)
				(gSq5Music2 number: 105 loop: -1 play:)
				(proc0_2 84)
				(gSq5Music1 number: 42 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sShowEggTimer of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(d0 init:)
				(d1 init:)
				(d2 init:)
				(d3 init:)
				(localproc_0265 global136)
				(theButton dispose:)
				(= cycles 1)
			)
			(1
				(if (not (proc0_1 61))
					(eggTimer addToPic:)
					(lid addToPic:)
				)
				(waddle setCycle: Osc)
				(= ticks 50)
			)
			(2
				(= temp0 (mod (+ (chickenHead cel?) 1) 8))
				(chickenHead setCel: temp0)
				(waddle
					x: [local1 (* temp0 2)]
					y: [local1 (+ (* temp0 2) 1)]
					setLoop: (+ temp0 1)
				)
				(localproc_00fa)
				(gSq5Music2 number: 220 loop: 1 play:)
				(= ticks 50)
			)
			(3
				(if (-- global136) (= state (- state 2)))
				(= cycles 1)
			)
			(4
				(waddle setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance sShowKey of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(theButton hide:)
				(self dispose:)
			)
		)
	)
)

(instance d0 of Prop
	(properties
		x 245
		y 98
		view 351
		loop 12
		cel 10
		priority 15
		signal $4011
	)
	
	(method (init)
		(self cel: 10 signal: 16401)
		(super init: &rest)
	)
)

(instance d1 of Prop
	(properties
		x 237
		y 99
		view 351
		loop 12
		cel 10
		priority 15
		signal $4011
	)
	
	(method (init)
		(self cel: 10 signal: 16401)
		(super init: &rest)
	)
)

(instance d2 of Prop
	(properties
		x 227
		y 99
		view 351
		loop 12
		cel 10
		priority 15
		signal $4011
	)
	
	(method (init)
		(self cel: 10 signal: 16401)
		(super init: &rest)
	)
)

(instance d3 of Prop
	(properties
		x 219
		y 98
		view 351
		loop 12
		cel 10
		priority 15
		signal $4011
	)
	
	(method (init)
		(self cel: 10 signal: 16401)
		(super init: &rest)
	)
)

(instance chickenHead of Prop
	(properties
		x 235
		y 82
		noun 44
		view 351
		priority 11
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1 setLoop: 0 setCel: 0)
		(super init: &rest)
	)
)

(instance waddle of Prop
	(properties
		x 234
		y 80
		noun 44
		view 351
		loop 1
		cel 1
		priority 12
		signal $4010
	)
	
	(method (init)
		(self cel: 0 posn: 234 80 cycleSpeed: 2 setLoop: 1)
		(super init: &rest)
	)
)

(instance eggTimer of Prop
	(properties
		x 188
		y 185
		z 160
		noun 44
		view 351
		loop 10
		priority 10
		signal $4010
	)
	
	(method (init)
		(if (proc0_1 84) (waddle setScript: sShowEggTimer))
		(self ignoreActors: 1 stopUpd:)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					((proc999_4 220 121 235 135 gPEventX gPEventY)
						(if (not (proc0_1 84))
							(theButton show: 0)
							(waddle setScript: sStartEggTimer)
						)
					)
					((proc999_4 235 121 248 135 gPEventX gPEventY)
						(if (not (proc0_1 84))
							(theButton show: 1)
							(global2 setScript: sStopEggTimer)
						else
							(gTestMessager say: 8 4 0 1 self 202)
						)
					)
					(else (super doVerb: theVerb))
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance lid of Actor
	(properties
		x 209
		y 56
		noun 44
		view 351
		loop 9
		priority 13
		signal $4010
	)
	
	(method (init)
		(if (proc0_1 84)
			(lid setLoop: 9 x: 209 y: 27 stopUpd:)
		else
			(lid setLoop: 9 x: 209 y: 56 moveSpeed: 0 stopUpd:)
		)
		(super init: &rest)
	)
)

(instance theButton of Prop
	(properties
		x 219
		y 111
		noun 44
		view 351
		loop 11
		priority 15
		signal $4010
	)
	
	(method (show param1)
		(self cel: param1 x: [local17 param1] setScript: sShowKey)
		(super show: &rest)
	)
)
