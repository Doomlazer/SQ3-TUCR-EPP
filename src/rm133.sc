;;; Sierra Script 1.0 - (do not remove this comment)
(script# 133)
(include sci.sh)
(use Main)
(use Scaler)
(use RandCycle)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm133 0
)

(local
	local0
	local1
	local2 =  4
	local3
	[local4 30]
	[local34 30]
)
(instance rm133 of Rm
	(properties
		picture 31
		style $800a
		horizon 50
		vanishingX 130
		vanishingY 50
	)
	
	(method (init)
		(gSQ5 handsOff:)
		(gSq5Music1 number: 140 setLoop: -1 play:)
		(Palette palANIMATE 32 34 1)
		(Palette palANIMATE 36 38 1)
		(Palette palANIMATE 44 46 1)
		(Palette palANIMATE 40 42 1)
		(tech1 init: setCycle: Fwd)
		(tech2 init: setCycle: Fwd)
		(tech3 init: setCycle: Fwd setScript: sDoLights)
		(super init:)
		(global2 setScript: sDoAll)
	)
)

(instance sDoLights of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 2 8)))
			(1
				(Palette palANIMATE 38 40 1)
				(Palette palANIMATE 44 46 1)
				(Palette palANIMATE 40 42 1)
				(= cycles (Random 2 8))
			)
			(2
				(Palette palANIMATE 38 40 1)
				(Palette palANIMATE 46 48 1)
				(Palette palANIMATE 42 44 1)
				(= cycles (Random 2 8))
			)
			(3
				(Palette palANIMATE 34 36 1)
				(Palette palANIMATE 36 38 1)
				(= cycles (Random 2 8))
			)
			(4 (= cycles 1) (= state -1))
		)
	)
)

(instance sDoAll of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(extMouse init:)
				(= ticks 10)
			)
			(1
				(extMouse loop: 1 cel: 0 x: 181 y: 187)
				(= ticks 10)
			)
			(2
				(extMouse setCel: 1)
				(= ticks 10)
			)
			(3
				(extMouse setCel: 0)
				(= ticks 10)
			)
			(4
				(extMouse setCel: 1)
				(= ticks 10)
			)
			(5
				(extMouse setLoop: 2 setCel: 0 x: 183 y: 185)
				(= ticks 10)
			)
			(6
				(gSq5Music2 number: 141 setLoop: -1 play:)
				(extMouse
					view: 143
					setLoop: -1
					setLoop: 0
					cel: 0
					setStep: 5 6
					cycleSpeed: 2
					x: 169
					y: 183
					setCycle: Fwd
					setMotion: MoveTo 169 134 self
				)
			)
			(7
				(gSq5Music2 number: 120 setLoop: 1 play:)
				(extMouse dispose:)
				(= cycles 2)
			)
			(8
				(= local3 6)
				(inbottom
					init:
					setScale: Scaler local3 local3 122 99
					scaleSignal: 1
				)
				(= cycles 1)
			)
			(9
				(= local3 (+ local3 local2))
				(inbottom setScale: Scaler local3 local3 122 99)
				(if (< local3 100) (= state (- state 1)))
				(= cycles 1)
			)
			(10
				(inbottom setScale: 0 scaleSignal: 0)
				(= cycles 1)
			)
			(11
				(tail init: setCycle: RandCycle)
				(= cycles 10)
			)
			(12
				(tail setLoop: 2 cel: 0)
				(= cycles 1)
			)
			(13 (tail setCycle: End self))
			(14
				(tail dispose:)
				(= cycles 1)
			)
			(15
				(inbottom
					setStep: 7 7
					setScale: 0
					setMotion: MoveTo 161 254 self
				)
				(intop init: setStep: 7 7 setMotion: MoveTo 161 146)
			)
			(16
				(inbottom stopUpd:)
				(intop stopUpd:)
				(= cycles 2)
			)
			(17
				(= local0 (Graph grSAVE_BOX 93 179 99 187 1))
				(Message msgGET 133 1 0 0 1 @local4)
				(Message msgGET 133 1 0 0 2 @local34)
				(= temp0 (proc0_12 116 116 116 116 116))
				(= temp1 (proc0_12 74 74 74 74 74))
				(Display
					@local4
					dsCOORD
					temp0
					temp1
					dsFONT
					1605
					dsCOLOR
					14
				)
				(= temp0 (proc0_12 163 136 136 136 136))
				(= temp1 (proc0_12 76 74 76 74 74))
				(Display @local34 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 5)
				(= ticks 40)
			)
			(18
				(Message msgGET 133 1 0 0 3 @local4)
				(Message msgGET 133 1 0 0 11 @local34)
				(= temp0 (proc0_12 116 116 116 116 116))
				(= temp1 (proc0_12 84 84 84 84 84))
				(Display
					@local4
					dsCOORD
					temp0
					temp1
					dsFONT
					1605
					dsCOLOR
					14
				)
				(= temp0 (proc0_12 163 186 163 186 186))
				(= temp1 (proc0_12 84 84 84 84 84))
				(Display
					@local34
					dsCOORD
					temp0
					temp1
					dsFONT
					1605
					dsCOLOR
					14
				)
				(= ticks 40)
			)
			(19
				(Message msgGET 133 1 0 0 4 @local4)
				(= temp0 (proc0_12 116 116 116 116 116))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 5)
				(= local1 (Graph grSAVE_BOX 90 163 100 211 1))
				(= ticks 40)
			)
			(20
				(Message msgGET 133 1 0 0 5 @local4)
				(= temp0 (proc0_12 163 173 173 173 173))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(21
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(22
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(23
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(24
				(Graph grRESTORE_BOX local1)
				(Graph grUPDATE_BOX 90 163 100 211 1)
				(Message msgGET 133 1 0 0 6 @local34)
				(= temp0 (proc0_12 163 186 163 186 186))
				(= temp1 (proc0_12 94 94 94 94 94))
				(Display @local34 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 9)
				(= ticks 40)
			)
			(25
				(Message msgGET 133 1 0 0 8 @local34)
				(= temp0 (proc0_12 116 116 116 116 116))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local34 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 5)
				(= local1 (Graph grSAVE_BOX 100 163 110 211 1))
				(= ticks 40)
			)
			(26
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(27
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(28
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(29
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(30
				(Graph grRESTORE_BOX local1)
				(Graph grUPDATE_BOX 100 163 110 211 1)
				(Message msgGET 133 1 0 0 6 @local34)
				(= temp0 (proc0_12 163 186 163 186 186))
				(= temp1 (proc0_12 104 104 104 104 104))
				(Display @local34 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 9)
				(= ticks 40)
			)
			(31
				(Message msgGET 133 1 0 0 7 @local34)
				(= temp0 (proc0_12 116 116 116 116 116))
				(= temp1 (proc0_12 114 114 114 114 114))
				(Display @local34 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 5)
				(= ticks 40)
			)
			(32
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 114 114 114 114 114))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(33
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 114 114 114 114 114))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(34
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 114 114 114 114 114))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 19)
				(= ticks 20)
			)
			(35
				(= temp0 (proc0_12 163 173 163 173 173))
				(= temp1 (proc0_12 114 114 114 114 114))
				(Display @local4 dsCOORD temp0 temp1 dsFONT 10 dsCOLOR 28)
				(= ticks 20)
			)
			(36
				(inbottom dispose:)
				(intop dispose:)
				(= cycles 2)
			)
			(37
				(gSq5Music2 stop:)
				(global2 newRoom: 132)
			)
		)
	)
)

(instance extMouse of Actor
	(properties
		x 181
		y 189
		view 141
	)
	
	(method (init)
		(super init: &rest)
		(self setScale: Scaler 100 11 189 129)
	)
)

(instance tail of Actor
	(properties
		x 178
		y 127
		view 142
		loop 1
		signal $6000
		cycleSpeed 0
		moveSpeed 0
	)
)

(instance tech1 of Actor
	(properties
		x 113
		y 125
		view 141
		loop 3
		priority 5
		signal $0010
		cycleSpeed 100
	)
)

(instance tech2 of Actor
	(properties
		x 219
		y 129
		view 141
		loop 4
		priority 5
		signal $0010
		cycleSpeed 100
	)
)

(instance tech3 of Actor
	(properties
		x 309
		y 86
		view 141
		loop 5
		priority 5
		signal $0010
		cycleSpeed 100
	)
)

(instance intop of Actor
	(properties
		x 161
		y 53
		view 142
		priority 6
		signal $6010
		moveSpeed 0
	)
)

(instance inbottom of Actor
	(properties
		x 161
		y 146
		view 142
		cel 1
		priority 6
		signal $6010
		moveSpeed 0
	)
)
