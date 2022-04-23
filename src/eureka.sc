;;; Sierra Script 1.0 - (do not remove this comment)
(script# 210)
(include sci.sh)
(use Main)
(use Print)
(use Sound)
(use Game)
(use Obj)

(public
	eureka 0
	sGoliathTimer 1
	sLiteSpeedTimer 2
	sBlowUpEureka 3
	sApproachTimer 4
	sBlobTimer 5
	sWD40Timer 6
	sTrashRunsTimer 8
	sEggTimer 9
	sAsteroidNoise 10
)

(class eureka of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		state $0000
		destination 0
		curLocation 0
		prevLocation 0
		warnings 0
		hits 0
		gdoor 0
		garbage 0
		puke 0
		damaged 0
	)
	
	(method (init)
		(super init: &rest)
		(if
			(not
				(proc999_5
					gGModNum
					106
					107
					200
					201
					202
					203
					204
					205
					206
					212
					213
					215
					222
					225
					226
					228
					230
					240
					250
					280
					290
					295
				)
			)
			(self curLocation: gEurekaCurLocation)
			(if (proc999_5 gEurekaCurLocation 5 6 3 8 15 14)
				(eureka state: 3)
			)
		)
	)
	
	(method (doit)
		(if
		(and (== gEurekaCurLocation 15) (not (eureka script?)))
			(eureka setScript: sAsteroidNoise)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(hailSound dispose:)
		(super dispose: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5
				newRoomNumber
				106
				107
				200
				201
				202
				203
				204
				205
				206
				212
				213
				215
				222
				225
				226
				228
				230
				240
				250
				280
				290
				295
			)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sLiteSpeedTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(eureka timer: 1)
				(self dispose:)
			)
		)
	)
)

(instance hailSound of Sound
	(properties)
)

(instance sMessage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc999_5 gModNum 226 228)) (gSQ5 handsOff:))
				(hailSound number: 234 loop: 1 play: self)
			)
			(1
				(gTestMessager say: 11 0 14 5 self 201)
			)
			(2
				(if (not (proc999_5 gModNum 226 228)) (gSQ5 handsOn:))
				(self dispose:)
			)
		)
	)
)

(instance sApproachTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(cond 
					((== gModNum 201) (= cycles 1) (eureka timer: 2) (proc0_3 115))
					((global2 script?) (= state (- state 2)) (= register 5) (= cycles 1))
					((proc0_1 37)
						(= gEurekaCurLocation 14)
						(eureka
							timer: 0
							warnings: 0
							state: 3
							destination: 0
							curLocation: 14
						)
						(proc0_3 37)
						(if (not (proc0_1 39))
							(client setScript: sBlowUpEureka 0 12)
							(self dispose:)
						else
							(= cycles 1)
						)
					)
					((== gModNum 200)
						(if (>= (eureka warnings?) 2)
							(gTestMessager say: 11 0 14 3 self 201)
							(eureka timer: 0 warnings: 0 state: 1 destination: 0)
							(proc0_3 38)
						else
							(gTestMessager say: 11 0 14 1 self 201)
							(eureka timer: 2)
							(= register 30)
							(= state (- state 2))
						)
					)
					(else
						(global2 setScript: sMessage self)
						(proc0_2 115)
						(eureka timer: 2)
						(= register 30)
						(= state (- state 2))
					)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance sGoliathTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(cond 
					((== gModNum 201) (eureka timer: 5) (= cycles 1))
					((global2 script?) (= state (- state 2)) (= register 5) (= cycles 1))
					(else (client setScript: sBlowUpEureka 0 12) (self dispose:))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance sWD40Timer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(cond 
					((== gModNum 201) (eureka timer: 3) (= cycles 1))
					((global2 script?) (= register 5) (= state (- state 2)) (= cycles 1))
					((== (eureka warnings?) 0)
						(if (== gModNum 200)
							(gTestMessager say: 11 0 14 1 self 201)
						else
							(gTestMessager say: 11 0 14 5 self 201)
						)
						(eureka timer: 3 warnings: 0)
						(= register 30)
						(= state (- state 2))
					)
					(else (client setScript: sBlowUpEureka 0 6) (self dispose:))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance sTrashRunsTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(proc921_0
					{You didn't complete your mission in time! You're fired!}
				)
				(= cycles 1)
			)
			(2 (self dispose:))
		)
	)
)

(instance sEggTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2 84)
				(gSq5IconBar disable: 4)
				(= global136 600)
				(= cycles 1)
			)
			(1 (= seconds 1))
			(2
				(if
				(and (proc0_1 61) (<= global136 180) (== gModNum 201))
					(gSQ5 handsOff:)
					(client setScript: (ScriptID 208 1))
					(self dispose:)
				)
				(if (!= gModNum 201) (-- global136))
				(if global136
					(if (== global136 60)
						(gSq5Music1 number: 43 loop: -1 play:)
					)
					(= state (- state 2))
				)
				(= cycles 1)
			)
			(3
				(client setScript: sBlowUpEureka 0 11)
				(self dispose:)
			)
		)
	)
)

(instance sBlowUpEureka of Script
	(properties)
	
	(method (doit)
		(switch state
			(0
				(if (>= (PalVary pvGET_CURRENT_STEP) 63) (self cue:))
			)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary pvUNINIT)
				(PalVary pvINIT 2100 1)
				(gEgo hide:)
				(gSq5Music2 number: 203 setLoop: 1 play:)
				(ShakeScreen 6 3)
			)
			(1
				(proc0_9 register)
				(self dispose:)
			)
		)
	)
	
	(method (cue)
		(self changeState: (+ state 1) &rest)
	)
)

(instance sBlobTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds register))
			(1
				(cond 
					((and (== gModNum 201) (< (eureka puke?) 4)) (eureka timer: 6) (self dispose:))
					((global2 script?) (= state (- state 2)) (= register 5) (= cycles 1))
					((== (eureka puke?) 1) (client setScript: sBlowUpEureka 0 43) (self dispose:))
					((>= (eureka puke?) 2) (client setScript: sBlowUpEureka 0 7) (self dispose:))
					(else (= cycles 1))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance theMusic5 of Sound
	(properties)
)

(instance sAsteroidNoise of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(ShakeScreen 1 (Random 1 3))
				(theMusic5 number: 202 setLoop: 1 play: 80)
				(= seconds (Random 2 20))
			)
			(2
				(if (not (eureka destination?)) (= state (- state 2)))
				(= cycles 1)
			)
			(3
				(theMusic5 stop:)
				(self dispose:)
			)
		)
	)
)
