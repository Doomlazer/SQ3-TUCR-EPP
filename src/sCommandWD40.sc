;;; Sierra Script 1.0 - (do not remove this comment)
(script# 219)
(include sci.sh)
(use Main)
(use eureka)
(use Print)
(use Obj)

(public
	sCommandWD40 0
)

(instance sCommandWD40 of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 219)
		(DisposeScript 205)
	)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				((ScriptID 202 14) setScript: 0)
				((ScriptID 1887 24) disposeWhenDone: 0)
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
						addColorButton: 0 1 0 0 24 0 0 205 13 29 31 0 0 0
						addColorButton: 1 1 0 0 25 0 10 205 13 29 31 0 0 0
						addColorButton: 2 1 0 0 26 0 20 205 13 29 31 0 0 0
						addColorButton: 3 1 0 0 27 0 30 205 13 29 31 0 0 0
						addColorButton: 4 1 0 0 28 0 40 205 13 29 31 0 0 0
						init:
					)
				)
				(= cycles 1)
			)
			(2
				(switch register
					(0
						(self setScript: sScanPlanet self)
					)
					(1
						(self setScript: sScanShips self)
					)
					(2
						(self setScript: sStatusReport self)
					)
					(3
						(self setScript: sRecommendation self)
					)
					(4
						(self setScript: sBelayThatOrder self)
					)
					(else  (= cycles 1))
				)
			)
			(3
				(if (!= register 4)
					(gTestMessager say: 43 0 0 2 self)
					(= state 0)
				else
					(= cycles 1)
				)
			)
			(4
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982 1)
				((ScriptID 1887 24) disposeWhenDone: 1)
				(self dispose:)
			)
		)
	)
)

(instance sScanPlanet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gEurekaCurLocation
					(1
						(gTestMessager say: 33 0 48 1 self)
					)
					(2
						(gTestMessager say: 33 0 48 1 self)
					)
					(5
						(if (proc0_1 30)
							(gTestMessager say: 33 0 27 1 self)
						else
							(gTestMessager say: 33 0 27 2 self)
						)
					)
					(3
						(gTestMessager say: 33 0 56 1 self)
					)
					(6
						(gTestMessager say: 33 0 30 1 self)
					)
					(7
						(gTestMessager say: 33 0 28 1 self)
					)
					(8
						(gTestMessager say: 33 0 28 2 self)
					)
					(9
						(gTestMessager say: 33 0 31 1 self)
					)
					(10
						(gTestMessager say: 33 0 31 2 self)
					)
					(11
						(gTestMessager say: 33 0 31 3 self)
					)
					(12
						(gTestMessager say: 33 0 31 4 self)
					)
					(13
						(gTestMessager say: 33 0 31 5 self)
					)
					(14
						(gTestMessager say: 33 0 5 2 self)
					)
					(else 
						(gTestMessager say: 33 0 5 (Random 1 3) self)
					)
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sScanShips of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gEurekaCurLocation
					(6
						(if (proc0_1 42)
							(if (eureka damaged?)
								(gTestMessager say: 34 0 20 1 self)
							else
								(gTestMessager say: 34 0 22 1 self)
							)
						else
							(gTestMessager say: 34 0 30 1 self)
						)
					)
					(14
						(if (proc0_1 39)
							(gTestMessager say: 34 0 49 4 self)
						else
							(gTestMessager say: 34 0 49 3 self)
						)
					)
					(else 
						(cond 
							((proc0_1 37)
								(if (proc0_1 39)
									(gTestMessager say: 34 0 49 4 self)
								else
									(gTestMessager say: 34 0 49 3 self)
								)
							)
							((proc0_1 75) (gTestMessager say: 34 0 49 1 self))
							(else (gTestMessager say: 34 0 5 (Random 1 3) self))
						)
					)
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sStatusReport of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (eureka puke?) 4)
					(gTestMessager say: 41 0 16 1 self)
				else
					(gTestMessager say: 41 0 5 (Random 1 3) self)
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sRecommendation of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					(
						(and
							(== gEurekaCurLocation 5)
							(proc0_1 30)
							(== global142 0)
						)
						(gTestMessager say: 30 0 27 1 self)
					)
					(
						(and
							(== gEurekaCurLocation 6)
							(proc0_1 94)
							(not (proc0_1 63))
						)
						(gTestMessager say: 30 0 30 0 self)
					)
					((proc0_1 42)
						(if (eureka hits?)
							(switch (Random 1 2)
								(1
									(gTestMessager say: 30 0 11 1 self)
								)
								(2
									(gTestMessager say: 30 0 20 1 self)
								)
							)
						else
							(gTestMessager say: 30 0 49 1 self)
						)
					)
					(
					(and (== gEurekaCurLocation 15) (not (proc0_1 87))) (gTestMessager say: 30 0 40 0 self))
					(
					(and (== gEurekaCurLocation 8) (not (proc0_1 75))) (gTestMessager say: 30 0 28 0 self))
					((eureka damaged?) (gTestMessager say: 30 0 11 1 self))
					((== gEurekaCurLocation 14) (gTestMessager say: 30 0 50 0 self))
					(else (gTestMessager say: 30 0 5 (Random 1 3) self))
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sBelayThatOrder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 3 0 5 (Random 1 3) self)
			)
			(1 (self dispose:))
		)
	)
)
