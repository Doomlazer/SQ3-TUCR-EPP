;;; Sierra Script 1.0 - (do not remove this comment)
(script# 218)
(include sci.sh)
(use Main)
(use eureka)
(use Print)
(use Sound)
(use Obj)

(public
	sCommandCliffy 0
)

(instance theMusic3 of Sound
	(properties)
)

(instance sCommandCliffy of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 218)
		(DisposeScript 205)
	)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				((ScriptID 202 13) setScript: 0)
				(= cycles 1)
			)
			(1
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982 1)
				(= register
					(Print
						mode: 1
						window: (ScriptID 205 0)
						width: 125
						addColorButton: 0 1 0 0 19 0 0 205 13 29 31 0 0 0
						addColorButton: 1 1 0 0 20 0 10 205 13 29 31 0 0 0
						addColorButton: 2 1 0 0 21 0 20 205 13 29 31 0 0 0
						addColorButton: 3 1 0 0 22 0 30 205 13 29 31 0 0 0
						addColorButton: 4 1 0 0 23 0 40 205 13 29 31 0 0 0
						init:
					)
				)
				(= cycles 1)
			)
			(2
				(switch register
					(0
						(self setScript: sStatusReport self)
					)
					(1
						(self setScript: sCloakShip self)
					)
					(2
						(self setScript: sDeCloakShip self)
					)
					(3
						(self setScript: sMorePower self)
					)
					(4
						(self setScript: sForgetIt self)
					)
					(else  (= cycles 1))
				)
			)
			(3
				(if
				(and (== gEurekaCurLocation 14) (not (proc0_1 39)))
					(eureka setScript: (ScriptID 210 1) 0 1)
				)
				(if (!= register 4)
					(gTestMessager say: 43 0 0 1 self)
					(= state 0)
				else
					(= cycles 1)
				)
			)
			(4
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982 1)
				(self dispose:)
			)
		)
	)
)

(instance sStatusReport of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((proc0_1 61) (gTestMessager say: 8 0 13 1 self))
					((and (> global126 1) (not (proc0_1 56))) (gTestMessager say: 8 0 12 1 self))
					((and (== gEurekaCurLocation 14) (proc0_1 39)) (gTestMessager say: 8 0 55 1 self))
					((eureka damaged?) (gTestMessager say: 8 0 11 1 self))
					((>= (eureka puke?) 4) (gTestMessager say: 8 0 16 1 self))
					((and (== global170 2) (not (proc0_1 47))) (gTestMessager say: 8 0 5 1 self) (proc0_2 47))
					((proc0_1 30) (gTestMessager say: 8 0 3 (Random 1 3) self))
					(else (gTestMessager say: 8 0 4 (Random 1 3) self))
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sCloakShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((proc0_1 39) (gTestMessager say: 7 0 9 1 self))
					((not (proc0_1 89))
						(if (proc0_1 30)
							(gTestMessager say: 7 0 3 (Random 1 3) self)
						else
							(gTestMessager say: 7 0 4 (Random 1 3) self)
						)
					)
					((proc0_1 32) (gTestMessager say: 7 0 45 1 self))
					((and (== global142 2) (proc0_1 75)) (proc0_2 39) (self setScript: sCloaking self))
					(else (gTestMessager say: 7 0 10 1 self))
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sCloaking of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gTestMessager say: 42 0 52 1 self)
			)
			(1 (= seconds 2))
			(2
				(if (proc0_1 37)
					(proc0_10 194 50)
					(eureka setScript: (ScriptID 210 4) 0 1)
				)
				(theMusic3 number: 106 loop: 1 play: self)
			)
			(3
				(theMusic3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDeCloakShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_1 39))
					(if (proc0_1 30)
						(gTestMessager say: 10 0 3 (Random 1 3) self)
					else
						(gTestMessager say: 10 0 4 (Random 1 3) self)
					)
				else
					(self setScript: sCloaking self)
					(proc0_3 39)
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sMorePower of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 26 0 0 0 self)
			)
			(1 (self dispose:))
		)
	)
)

(instance sForgetIt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc0_1 30)
					(gTestMessager say: 17 0 3 (Random 1 3) self)
				else
					(gTestMessager say: 17 0 4 (Random 1 3) self)
				)
			)
			(1 (self dispose:))
		)
	)
)
