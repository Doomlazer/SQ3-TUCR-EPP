;;; Sierra Script 1.0 - (do not remove this comment)
(script# 216)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Print)
(use Sound)
(use Obj)

(public
	sCommandFlo 0
	sTalkToFlo 1
)

(local
	local0
	local1
)
(procedure (localproc_008f param1)
	(if (proc0_1 30)
		(gTestMessager say: 28 0 4 (Random 1 3) param1)
	else
		(gTestMessager say: 28 0 3 (Random 1 3) param1)
	)
)

(procedure (localproc_00ca param1)
	(if (proc0_1 30)
		(gTestMessager say: 4 0 3 (Random 1 3) param1)
	else
		(gTestMessager say: 4 0 4 (Random 1 3) param1)
	)
)

(procedure (localproc_05bd param1)
	(cond 
		((>= (eureka puke?) 4) (gTestMessager say: 18 0 16 1 (if argc param1 else 0)))
		((proc0_1 61) (gTestMessager say: 18 0 13 1 (if argc param1 else 0)))
		((< global127 3)
			(if (proc0_1 31)
				(gTestMessager
					say: 25 0 21 1 (if argc param1 else 0) 202
				)
			else
				(gTestMessager
					say: 18 0 4 (Random 1 3) (if argc param1 else 0)
				)
			)
		)
		((not (proc0_1 30))
			(gTestMessager
				say: 25 0 22 1 (if argc param1 else 0) 202
			)
		)
		((not (proc0_1 93))
			(gTestMessager
				say: 25 0 26 1 (if argc param1 else 0) 202
			)
		)
		((== global142 1)
			(if (not (proc0_1 94))
				(gTestMessager
					say: 25 0 24 0 (if argc param1 else 0) 202
				)
			else
				(gTestMessager say: 18 0 33 1 (if argc param1 else 0))
			)
		)
		((== global142 2)
			(if
			(and (not (proc0_1 75)) (!= gEurekaCurLocation 8))
				(gTestMessager
					say: 25 0 25 0 (if argc param1 else 0) 202
				)
			else
				(gTestMessager say: 18 0 33 1 (if argc param1 else 0))
			)
		)
		((proc0_1 30)
			(gTestMessager
				say: 18 0 3 (Random 1 3) (if argc param1 else 0)
			)
		)
		(else
			(gTestMessager
				say: 18 0 4 (Random 1 3) (if argc param1 else 0)
			)
		)
	)
)

(instance sAbandonShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (eureka puke?) 4)
					(proc0_2 85)
					(proc0_10 200 10)
					(gTestMessager say: 1 0 2 1 self)
				else
					(gTestMessager say: 1 0 1 1 self)
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance sHailPlanet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 201 4) self 3)
			)
			(1
				(switch gEurekaCurLocation
					(0
						(gTestMessager say: 20 0 32 1 self)
					)
					(3
						(gTestMessager say: 20 0 31 1 self)
					)
					(32
						(gTestMessager say: 20 0 29 1 self)
					)
					(5
						(if (proc0_1 30)
							(switch global142
								(0
									(gTestMessager say: 20 0 27 1 self)
								)
								(else 
									(gTestMessager say: 20 0 54 1 self)
								)
							)
						else
							(gTestMessager say: 20 0 27 2 self)
						)
					)
					(6
						(cond 
							((proc0_1 42) (gTestMessager say: 20 0 54 1 self))
							((== global142 1) (gTestMessager say: 20 0 30 1 self))
							((== global142 2) (gTestMessager say: 21 0 33 1 self))
							(else (gTestMessager say: 20 0 31 1 self))
						)
					)
					(7
						(gTestMessager say: 20 0 28 1 self)
					)
					(8
						(gTestMessager say: 20 0 28 2 self)
					)
					(else 
						(cond 
							((proc999_5 gEurekaCurLocation 9 10 11 12 13) (gTestMessager say: 20 0 31 1 self))
							((proc0_1 30) (gTestMessager say: 20 0 3 (Random 1 3) self))
							(else (gTestMessager say: 20 0 4 (Random 1 3) self))
						)
					)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance sHailShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gEurekaCurLocation 0) (proc0_1 34))
					(= cycles 1)
				else
					(self setScript: (ScriptID 201 4) self 1)
				)
			)
			(1
				(switch gEurekaCurLocation
					(0
						(if (proc0_1 34)
							(gTestMessager say: 21 0 34 0 self)
						else
							(self setScript: (ScriptID 211 0) self)
						)
					)
					(5
						(if
						(and (not (proc0_1 92)) (proc0_1 93) (< global142 1))
							(gTestMessager say: 21 0 0 1 self)
							(= local1 1)
						else
							(gTestMessager say: 21 0 3 3 self)
						)
					)
					(6
						(cond 
							((proc0_1 42)
								(if (eureka damaged?)
									(gTestMessager say: 21 0 20 1 self)
								else
									(gTestMessager say: 21 0 22 1 self)
								)
							)
							((proc0_1 33) (gTestMessager say: 21 0 33 1 self))
							((proc0_1 30) (gTestMessager say: 21 0 3 (Random 1 3) self))
							(else (gTestMessager say: 21 0 4 (Random 1 3) self))
						)
					)
					(14
						(gTestMessager say: 21 0 33 1 self)
					)
					(else 
						(if (proc0_1 30)
							(gTestMessager say: 21 0 3 (Random 1 3) self)
						else
							(gTestMessager say: 21 0 4 (Random 1 3) self)
						)
					)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance starConMusic of Sound
	(properties)
)

(instance sHailStarcon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gEurekaCurLocation 0) (proc0_1 31))
					(= cycles 1)
				else
					(self setScript: (ScriptID 201 4) self 2)
				)
			)
			(1
				(cond 
					((== gEurekaCurLocation 0)
						(if (proc0_1 31)
							(gTestMessager say: 22 0 36 1 self)
						else
							(gTestMessager say: 22 0 37 0 self)
							(= local0 1)
							(proc0_2 31)
						)
					)
					((== gEurekaCurLocation 5)
						(gSQ5Narrator keepWindow: 1)
						(gSq5Music2 setVol: 5)
						(starConMusic loop: -1 number: 223 play:)
						(gTestMessager say: 22 0 27 1 self)
					)
					((proc0_1 33) (gTestMessager say: 22 0 33 1 self))
					((proc0_1 30) (gTestMessager say: 22 0 3 (Random 1 3) self))
					(else (gTestMessager say: 22 0 4 (Random 1 3) self))
				)
			)
			(2
				(gSQ5Narrator keepWindow: 0)
				(starConMusic dispose:)
				(gSq5Music2 setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance sCommandFlo of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 205)
		(DisposeScript 216)
	)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc201_6 self)
			)
			(1
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982 1)
				(switch
					(Print
						mode: 1
						window: (ScriptID 205 0)
						font: gFont
						width: 125
						addColorButton: 0 1 0 0 12 0 0 205 13 29 31 0 0 0
						addColorButton: 1 1 0 0 13 0 10 205 13 29 31 0 0 0
						addColorButton: 2 1 0 0 14 0 20 205 13 29 31 0 0 0
						addColorButton: 3 1 0 0 15 0 30 205 13 29 31 0 0 0
						addColorButton: 4 1 0 0 16 0 40 205 13 29 31 0 0 0
						addColorButton: 5 1 0 0 17 0 50 205 13 29 31 0 0 0
						addColorButton: 6 1 0 0 18 0 60 205 13 29 31 0 0 0
						init:
					)
					(0
						(gSQ5 handsOff:)
						(self setScript: sHailShip self)
					)
					(1
						(gSQ5 handsOff:)
						(self setScript: sHailStarcon self)
					)
					(2
						(gSQ5 handsOff:)
						(self setScript: sHailPlanet self)
					)
					(3
						(gSQ5 handsOff:)
						(localproc_05bd self)
					)
					(4
						(gSQ5 handsOff:)
						(localproc_008f self)
					)
					(5
						(gSQ5 handsOff:)
						(self setScript: sAbandonShip self)
					)
					(6
						(gSQ5 handsOff:)
						(localproc_00ca self)
					)
					(else 
						(gSQ5 handsOff:)
						(= ticks 5)
					)
				)
			)
			(2
				(self setScript: (ScriptID 201 4) self 0)
			)
			(3
				(gSQ5 handsOff:)
				(cond 
					((proc0_1 85) (= next (ScriptID 201 23)) (self dispose:))
					(local0 (= local0 0) (= next (ScriptID 214 4)) (self dispose:))
					(local1 (= next (ScriptID 211 2)) (self dispose:))
					(else (= cycles 1))
				)
			)
			(4
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 4))
				(gSQ5 setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToFlo of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 220)
		(DisposeScript 216)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= cycles 1)
			)
			(1 (proc201_6 self))
			(2
				(cond 
					((== gEurekaCurLocation 0) (self setScript: (ScriptID 220 1) self))
					((== global126 1) (self setScript: (ScriptID 220 6) self))
					(
						(and
							(not (proc0_1 30))
							(< 8 gEurekaCurLocation)
							(< gEurekaCurLocation 14)
						)
						(self setScript: (ScriptID 220 8) self)
					)
					((proc0_1 61) (gTestMessager say: 12 0 89 0 self 202))
					(
						(and
							(proc0_1 36)
							(not (proc0_1 30))
							(or
								(== (eureka prevLocation?) 2)
								(== (eureka curLocation?) 2)
							)
						)
						(self setScript: (ScriptID 220 4) self)
					)
					((and (proc0_1 30) (not (proc0_1 93))) (self setScript: (ScriptID 220 5) self))
					(
						(and
							(== gEurekaCurLocation 5)
							(proc0_1 93)
							(not (proc0_1 76))
						)
						(if (proc0_1 92)
							(gTestMessager say: 12 0 61 0 self 202)
						else
							(gTestMessager say: 12 0 62 0 self 202)
						)
					)
					((and (== global142 1) (not (proc0_1 94))) (self setScript: (ScriptID 220 13) self))
					(
					(and (== gEurekaCurLocation 15) (not (proc0_1 87))) (gTestMessager say: 11 2 59 1 self 202))
					((and (== global142 2) (not (proc0_1 75))) (self setScript: (ScriptID 220 10) self))
					((>= (eureka puke?) 4) (gTestMessager say: 12 0 9 3 self 202))
					((and (proc0_1 75) (!= gEurekaCurLocation 14)) (self setScript: (ScriptID 220 12) self))
					((and (proc0_1 75) (== gEurekaCurLocation 14)) (gTestMessager say: 12 0 91 0 self 202))
					(else (self setScript: (ScriptID 220 7) self))
				)
			)
			(3
				(self setScript: (ScriptID 201 4) self 0)
			)
			(4
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 3))
				(gSQ5 setCursor: 983 1)
				(self dispose:)
			)
		)
	)
)
