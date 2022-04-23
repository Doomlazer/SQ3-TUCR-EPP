;;; Sierra Script 1.0 - (do not remove this comment)
(script# 233)
(include sci.sh)
(use Main)
(use rm201)
(use ScaleTo)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	sApproachClorox 1
	sApproachThrakus 2
	sBeaDies 3
	sSquishMonkeys 8
)

(local
	[local0 4] = [0 159 192 91]
	[local4 4] = [0 169 200 100]
)
(instance monkeySound of Sound
	(properties)
)

(instance sSquishMonkeys of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 3)
				(gSQ5 handsOff:)
				(= cycles 1)
			)
			(1 (= seconds 2))
			(2
				(scraper init:)
				(monkey
					init:
					show:
					x: [local0 register]
					y: 65
					setScale: ScaleTo 128 10 self
				)
			)
			(3
				(monkeySound number: 519 setLoop: 1 play:)
				(monkey setCycle: End self)
			)
			(4
				(scraper
					moveSpeed: 2
					setStep: 5
					setMotion: MoveTo [local4 register] 49 self
				)
				(gSq5Music2 number: 423 loop: 1 play:)
			)
			(5
				(monkey hide:)
				(scraper
					setLoop: 1
					cel: 0
					cycleSpeed: 15
					setCycle: End
					setMotion: MoveTo 40 49 self
				)
				(monkeySound number: 228 loop: 1 play:)
			)
			(6
				(monkeySound stop:)
				(= ticks 20)
			)
			(7
				(scraper
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 275 49 self
				)
				(gSq5Music2 number: 423 loop: 1 play:)
			)
			(8
				(gSq5Music2 stop:)
				(if (-- register) (= state (- state 8)))
				(= seconds 1)
			)
			(9
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self setScript: sStarConMessage self)
			)
			(10
				(scraper dispose:)
				(monkey dispose:)
				(monkeySound dispose:)
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 3))
				(gSQ5 setCursor: 983 1)
				(self dispose:)
			)
		)
	)
)

(instance sStarConMessage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc201_6 self))
			(1
				(gTestMessager say: 20 0 0 0 self 202)
			)
			(2
				(self setScript: (ScriptID 201 4) self)
			)
			(3 (self dispose:))
		)
	)
)

(instance sBeaDies of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 202 13) init:)
				(= seconds 1)
			)
			(2
				(if (== gEurekaCurLocation 6)
					(gTestMessager say: 6 0 6 1 self)
					(= register 37)
				else
					(gTestMessager say: 6 0 7 1 self)
					(= register 38)
				)
			)
			(3
				(proc0_9 register)
				(self dispose:)
			)
		)
	)
)

(instance sApproachClorox of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(proc201_5 0)
				(gTestMessager say: 1 0 0 1 self 202)
			)
			(2
				(proc201_7 self)
				(proc0_2 93)
			)
			(3
				(gTestMessager say: 1 0 0 2 self 202)
			)
			(4
				(self setScript: (ScriptID 201 8) self)
			)
			(5 (self dispose:))
		)
	)
)

(instance sApproachThrakus of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(proc201_5 0)
				(gTestMessager say: 5 0 0 1 self 202)
				(proc0_2 94)
			)
			(2 (self dispose:))
		)
	)
)

(instance monkey of Prop
	(properties
		x 159
		y 65
		view 219
		loop 2
	)
	
	(method (init)
		(self
			scaleX: 20
			scaleY: 20
			maxScale: 20
			scaleSignal: 1
			setCel: 0
			setLoop: 2
		)
		(super init: &rest)
	)
)

(instance scraper of Actor
	(properties
		x 275
		y 49
		view 219
		priority 6
		signal $0010
	)
	
	(method (init)
		(self x: 275 y: 49 setLoop: 0 setCel: 0)
		(super init: &rest)
	)
)
