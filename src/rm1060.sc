;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1060)
(include sci.sh)
(use Main)
(use ScaleTo)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm1060 0
)

(procedure (localproc_0030 &tmp temp0)
	(= temp0 1)
	(while (< temp0 30)
		((star new:) init:)
		(++ temp0)
	)
	(star init:)
)

(instance rm1060 of Rm
	(properties
		picture 130
		style $000a
	)
	
	(method (init)
		(localproc_0030)
		(gSQ5 handsOff:)
		(gSq5Music2 number: 101 loop: -1 play:)
		(ship init:)
		(super init:)
	)
)

(instance sSoundStuff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 203 setLoop: 1 play: self)
			)
			(1
				(gSq5Music1 number: 44 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sEurekaExplodes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 128)
				(self setScript: sSoundStuff)
				(ship dispose:)
				(= cycles 1)
			)
			(1
				(Palette palANIMATE 128 255 -1)
				(if (-- register) (-- state))
				(= ticks 1)
			)
			(2 (= seconds 5))
			(3
				(global2 newRoom: 1041)
				(self dispose:)
			)
		)
	)
)

(instance ship of Prop
	(properties
		x 138
		y 58
		view 717
	)
	
	(method (init)
		(self setScale: ScaleTo 15 10 self)
		(super init:)
	)
	
	(method (cue)
		(gSq5Music1 fade:)
		(global2 setScript: sEurekaExplodes)
	)
)

(instance star of Actor
	(properties
		view 217
		priority 1
		signal $6010
		moveSpeed 0
	)
	
	(method (init &tmp temp0 temp1 temp2 temp3)
		(= temp0 (Random 100 250))
		(= temp1 (Random 0 359))
		(= temp2 (+ 140 (CosMult temp1 temp0)))
		(= temp3 (+ 58 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			x: temp2
			y: temp3
			setLoop: 1
			setCel: (Random 0 3)
			moveSpeed: 0
			setStep: 10 10
			setCycle: 0
			setPri: 4
			setMotion: MoveTo 140 58
		)
		(super init: &rest)
	)
	
	(method (doit)
		(if (self inRect: 120 38 160 78)
			(self setMotion: 0)
			(self init:)
		)
		(super doit: &rest)
	)
)
