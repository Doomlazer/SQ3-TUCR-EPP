;;; Sierra Script 1.0 - (do not remove this comment)
(script# 802)
(include sci.sh)
(use Main)
(use Scaler)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm802 0
)

(local
	local0 =  -1
)
(instance rm802 of Rm
	(properties
		noun 14
		picture 48
		style $000a
	)
	
	(method (init)
		(super init: &rest)
		(gSq5Music1 number: 37 loop: -1 play:)
		(lever1 addToPic:)
		(lever2 addToPic:)
		(hand1 addToPic:)
		(hand2 addToPic:)
		(goliath addToPic:)
		(panel1 addToPic:)
		(panel2 addToPic:)
		(panel3 addToPic:)
		(arm addToPic:)
		(self setScript: doAnimation)
	)
)

(instance doAnimation of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(gTestMessager say: 14 0 1 0 self)
			)
			(2 (gSQ5 handsOn:))
			(3
				(gSQ5 handsOff:)
				(global2 drawPic: 134)
				(= cycles 3)
			)
			(4
				(pod
					init:
					setScale: Scaler 182 100 189 121
					setMotion: MoveTo 216 123 self
				)
			)
			(5 (pod setCycle: CT 7 1 self))
			(6
				(pod setScale: Scaler 100 18 123 99)
				(switch local0
					(0
						(pod setMotion: MoveTo 227 98 self)
					)
					(1
						(pod setMotion: MoveTo 171 107 self)
					)
					(2
						(pod setMotion: MoveTo 201 104 self)
					)
				)
			)
			(7 (pod setCycle: End self))
			(8
				(global2 drawPic: 135 -32758)
				(pod
					view: 711
					loop: 0
					cel: 0
					x: 160
					y: 144
					setScale: Scaler 100 77 144 116
				)
				(= seconds 3)
			)
			(9
				(gSq5Music2 number: 106 loop: 1 play:)
				(pod setCycle: End self)
			)
			(10
				(pod setMotion: MoveTo 160 134 self)
			)
			(11
				(gSq5Music2 number: 233 loop: 1 play:)
				(= seconds 2)
			)
			(12 (global2 newRoom: 800))
		)
	)
)

(instance pod of Actor
	(properties
		x 150
		y 189
		view 655
		signal $6000
		scaleSignal $0005
	)
)

(instance goliath of View
	(properties
		x 145
		y -50
		z -100
		view 698
		priority 5
		signal $5010
	)
)

(instance panel1 of View
	(properties
		x 199
		y 44
		noun 16
		view 698
		loop 1
		priority 15
		signal $6010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(= local0 0)
			(proc0_3 68)
			(doAnimation cue:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance panel2 of View
	(properties
		x 109
		y 46
		noun 17
		view 698
		loop 1
		cel 1
		priority 15
		signal $6010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(= local0 1)
			(proc0_2 68)
			(doAnimation cue:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance panel3 of View
	(properties
		x 163
		y 46
		noun 18
		view 698
		loop 1
		cel 2
		priority 15
		signal $4010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(= local0 2)
			(proc0_3 68)
			(doAnimation cue:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lever1 of View
	(properties
		x 54
		y 135
		noun 20
		view 270
		cel 1
		signal $4000
	)
)

(instance lever2 of View
	(properties
		x 270
		y 135
		noun 1
		view 270
		loop 1
		cel 1
		signal $4000
	)
)

(instance hand1 of View
	(properties
		y 125
		view 270
		cel 2
		priority 15
		signal $4010
	)
)

(instance hand2 of View
	(properties
		x 322
		y 124
		view 270
		loop 1
		cel 2
		priority 15
		signal $4010
	)
)

(instance arm of View
	(properties
		x 319
		y 27
		noun 2
		view 269
		priority 6
		signal $5010
	)
)
