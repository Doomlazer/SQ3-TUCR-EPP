;;; Sierra Script 1.0 - (do not remove this comment)
(script# 350)
(include sci.sh)
(use Main)
(use CueObj)
(use Cycle)
(use Game)
(use Obj)

(public
	kiz 0
	yoFlo 1
	sBeamOut 2
)

(class kiz of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		modnum 301
	)
	
	(method (init)
		(super init: &rest)
		(if (not (proc0_1 16)) (self setScript: sProdPlayer))
		(if
			(or
				(== (gSq5Music1 number?) 35)
				(and (== (gSq5Music1 number?) 124) (== gModNum 325))
				(and (== (gSq5Music1 number?) 17) (!= gModNum 305))
			)
			(gSq5Music1 number: 15 loop: -1 play: 0 fade: 127 10 5 0)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 300 305 310 315 320 325 330 335)
		)
		(= initialized 0)
		(if
			(or
				(== (gSq5Music1 number?) 35)
				(and
					(== (gSq5Music1 number?) 124)
					(== newRoomNumber 325)
				)
				(and
					(== (gSq5Music1 number?) 17)
					(!= newRoomNumber 305)
				)
			)
			(gSq5Music1 fade: 0 5 10 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance yoFlo of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(32
					(global2 setScript: sBeamOut)
					(return 1)
				)
				(else  (return 0))
			)
		)
	)
)

(instance sBeamOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(cond 
					((not (proc0_1 9))
						(cond 
							((not (proc0_1 16)) (= register 0) (gTestMessager say: 1 32 6 0 self 301))
							((!= gModNum 300) (= register 0) (gTestMessager say: 1 32 2 0 self 301))
							((not (gEgo has: 20)) (= register 0) (gTestMessager say: 1 32 3 0 self 301))
							(else (= register 1) (gTestMessager say: 1 32 4 0 self 301))
						)
					)
					((not (proc0_1 212))
						(if (!= gModNum 325)
							(= register 0)
							(gTestMessager say: 1 32 2 0 self 301)
						else
							(= register 1)
							(gTestMessager say: 1 32 4 0 self 301)
						)
					)
					((!= gModNum 300) (= register 0) (gTestMessager say: 1 32 2 0 self 301))
					(else (= register 1) (gTestMessager say: 1 32 4 0 self 301))
				)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(cond 
					((not register)
						(proc0_6 0)
						(gEgo loop: 2)
						(gSQ5 handsOn:)
						(self dispose:)
					)
					(
					(and (not (& global169 $0020)) (== gModNum 325))
						(if ((ScriptID 325 1) script?)
							(((ScriptID 325 1) script?) dispose:)
						)
						((ScriptID 325 1)
							view: 33
							setLoop: -1
							setLoop: 0
							cel: ((ScriptID 325 1) lastCel:)
							x: 293
							y: 165
							setCycle: CT 2 -1 self
						)
					)
					(else (= cycles 1))
				)
			)
			(5
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo
					view: 6
					loop: 0
					cel: (gEgo lastCel:)
					cycleSpeed: 6
					setCycle: Beg self
				)
				(if
				(and (not (& global169 $0020)) (== gModNum 325))
					((ScriptID 325 1) setCycle: Beg)
				)
				(if (gEgo has: 17) (gEgo put: 17))
			)
			(6
				(proc0_2 9)
				(if (gEgo has: 17) (gEgo put: 17))
				(global2 newRoom: 240)
			)
		)
	)
)

(instance sProdPlayer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(if (and (proc0_1 66) (not (proc0_1 67)))
					(proc0_2 67)
					(gTestMessager say: 3 0 0 0 self 301)
				else
					(= cycles 1)
				)
			)
			(2 (= seconds 180))
			(3
				(if (not (proc0_1 16))
					(gTestMessager say: 2 0 0 (Random 1 3) self 301)
				else
					(self dispose:)
				)
			)
			(4 (= state -1) (= cycles 1))
			(5 (self dispose:))
		)
	)
)
