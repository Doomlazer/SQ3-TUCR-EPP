;;; Sierra Script 1.0 - (do not remove this comment)
(script# 227)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	cliffy 0
	sMeetCliffy 1
	cliffySound 2
	sCliffyNoise 3
	sSpikeComments 4
)

(instance sSpikeComments of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 1)
			)
			(1
				(gTestMessager say: 11 0 0 0 self)
			)
			(2
				((ScriptID 225 1) setCycle: End self)
				(cliffy setMotion: MoveTo 66 133 self)
			)
			(3 0)
			(4
				((ScriptID 225 1) setCycle: Beg self)
			)
			(5
				(gSQ5 handsOn:)
				(cliffy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMeetCliffy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_2 60)
				(= cycles 1)
			)
			(1
				(gTestMessager say: 7 0 0 1 self)
			)
			(2
				(gEgo setMotion: MoveTo 141 134 self)
			)
			(3
				(gEgo hide:)
				(cliffy
					view: 231
					setLoop: 0
					cel: 0
					cycleSpeed: 15
					posn: 151 138
				)
				(= cycles 1)
			)
			(4 (cliffy setCycle: End self))
			(5
				(gTestMessager say: 7 0 0 2 self)
			)
			(6
				(cliffy setLoop: 1 setCycle: ForwardCounter 3 self)
			)
			(7
				(gTestMessager say: 7 0 0 3 self)
			)
			(8
				(cliffy setLoop: 2 setCycle: End self)
			)
			(9
				(gTestMessager say: 7 0 0 4 self)
			)
			(10
				(cliffy setLoop: 3 setCycle: ForwardCounter 3 self)
			)
			(11
				(gTestMessager say: 7 0 0 5 self)
			)
			(12
				(cliffy setCel: 0)
				(= seconds 2)
			)
			(13
				(gTestMessager say: 7 0 0 6 self)
			)
			(14
				(cliffy
					setLoop: 4
					setCycle: 0
					ignoreActors: 1
					posn: 166 138
				)
				(gEgo
					view: 231
					setLoop: 5
					cel: 0
					show:
					setScale: 0
					x: 151
					y: 135
					setCycle: End self
				)
			)
			(15 (= seconds 1))
			(16
				(proc0_6 0 4)
				(gEgo x: 138 y: 135 setScale: Scaler 153 42 168 107)
				(cliffy
					view: 20
					loop: 8
					cel: 7
					posn: 170 138
					setStep: 3 3
					cycleSpeed: 7
					moveSpeed: 7
					setLoop: Grooper
					setScale: Scaler 153 42 168 107
					setCycle: StopWalk -1
					signal: (| $0004 (cliffy signal?))
				)
				(= cycles 2)
			)
			(17
				(cliffy setMotion: MoveTo 143 122 self)
			)
			(18
				(cliffy setMotion: MoveTo 142 111 self)
			)
			(19
				(cliffy heading: 90)
				(= seconds 1)
			)
			(20
				(cliffy
					view: 191
					loop: 6
					x: 142
					y: 111
					setScale: 0
					cycleSpeed: 12
					setPri: 6
					setScript: sCliffyNoise
				)
				(= global130 (= seconds 1))
			)
			(21
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cliffySound of Sound
	(properties)
)

(instance sCliffyNoise of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 10 15))
				(cliffy cel: 0 setLoop: (Random 6 9))
				(= cycles 1)
			)
			(1
				(cliffy cel: 0 setCycle: End self)
			)
			(2
				(cliffySound
					number:
					(switch (cliffy loop?)
						(6 2422)
						(7 230)
						(8 232)
						(9 233)
					)
					loop: 1
					play:
				)
				(if (-- register)
					(= state (- state 2))
				else
					(= state (- state 3))
				)
				(= cycles 1)
			)
		)
	)
)

(instance sTalkAboutSpike of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1884 23) disposeWhenDone: 0)
				(gTestMessager say: 4 2 7 0 self)
			)
			(1
				(if (== global126 3)
					(gTestMessager say: 4 2 8 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 1884 23) disposeWhenDone: 1)
				(self dispose:)
			)
		)
	)
)

(instance cliffy of Actor
	(properties
		x 142
		y 111
		noun 4
		view 191
		loop 1
		cel 2
		signal $4000
		scaleSignal $0001
	)
	
	(method (init)
		(cond 
			((and (not (proc0_1 60)) (not (proc0_1 86)))
				(self view: 231 setLoop: 4 setCel: 0 posn: 166 138)
				(super init: &rest)
			)
			((== global130 1)
				(self ignoreActors: 1)
				(switch
					(if
					(or (== gGModNum 228) (== global126 1) (proc0_1 61))
						1
					else
						(Random 1 2)
					)
					(1
						(self
							view: 191
							setLoop: (Random 6 9)
							posn: 142 111
							cycleSpeed: 12
							setCycle: Osc
							setPri: 6
							setScale: 0
						)
						(if (!= global126 1) (self setScript: sCliffyNoise))
					)
					(2
						(self
							view: 241
							setLoop: 0
							posn: 148 114
							cycleSpeed: 15
							setScale: 0
							setCycle: End
						)
					)
				)
				(super init: &rest)
			)
			(
				(and
					(== global130 4)
					(== global126 1)
					(proc999_5 gGModNum 100 200)
				)
				(self
					view: 20
					posn: 96 133
					loop: 8
					cel: 0
					setStep: 3 3
					cycleSpeed: 7
					moveSpeed: 7
					setLoop: Grooper
					setScale: Scaler 153 42 168 107
					setCycle: StopWalk -1
					signal: (| $0004 (cliffy signal?))
				)
				(super init: &rest)
			)
		)
	)
	
	(method (dispose)
		(cliffySound dispose:)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(global2 setScript: sTalkToCliffy)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sTalkToCliffy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(cond 
					((proc0_1 61)
						(if (proc0_1 116)
							(gTestMessager say: 4 2 10 0 self)
						else
							(proc0_2 116)
							(gTestMessager say: 4 2 9 0 self)
						)
					)
					((proc0_1 115) (proc0_3 115) (gTestMessager say: 4 2 6 0 self))
					((== global126 1) (gTestMessager say: 11 0 0 0 self))
					(
						(and
							(> global126 1)
							(not (proc0_1 56))
							(!= gGModNum 230)
						)
						(self setScript: sTalkAboutSpike self)
					)
					(else (gTestMessager say: 4 2 0 0 self))
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)
