;;; Sierra Script 1.0 - (do not remove this comment)
(script# 166)
(include sci.sh)
(use Main)
(use CueObj)
(use ForwardCounter)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm166 0
)

(local
	local0
	[local1 200]
	local201
)
(instance rm166 of Rm
	(properties
		picture 36
		style $800a
	)
	
	(method (init)
		(super init:)
		(self setScript: sDoAll)
	)
)

(instance sDoAll of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music1 number: 17 loop: -1 play:)
				(if (gEgo has: 1) (gEgo put: 1))
				(head init:)
				(shirt init:)
				(= seconds 2)
			)
			(1
				(hands
					init:
					setLoop: 4
					setStep: 6 6
					setMotion: MoveTo 117 114 self
				)
			)
			(2
				(eyess init: setCycle: ForwardCounter 4 self)
			)
			(3
				(gSQ5 handsOn:)
				(= local201 1)
				(gSq5IconBar disable: 0 3 4 5 6)
				(DrawPic 38 dpOPEN_PIXELATION)
				(Message msgGET 166 1 0 0 1 @local1)
				(Display
					@local1
					dsCOORD
					40
					45
					dsCOLOR
					1
					dsFONT
					999
					dsWIDTH
					240
				)
				(Message msgGET 166 1 0 0 2 @local1)
				(Display
					@local1
					dsCOORD
					40
					109
					dsCOLOR
					1
					dsFONT
					999
					dsWIDTH
					240
				)
				(testResults init:)
			)
			(4
				(gSQ5 handsOff:)
				(= local201 0)
				(DrawPic 36 dpOPEN_PIXELATION)
				(hands
					setLoop: 4
					setStep: 6 6
					setMotion: MoveTo 114 148 self
				)
			)
			(5
				(eyess dispose:)
				(hands dispose:)
				(head setLoop: 2)
				(= seconds 5)
			)
			(6
				(head setLoop: 3)
				(= seconds 1)
			)
			(7
				(proc0_10 162 100)
				(PalVary pvUNINIT)
				(PalVary pvINIT 1602 1)
				(= seconds 1)
			)
			(8
				(shirt setCel: 1)
				(PalVary pvUNINIT)
				(PalVary pvINIT 1603 1)
				(= seconds 1)
			)
			(9 (hall init:) (= seconds 1))
			(10
				(PalVary pvUNINIT)
				(PalVary pvINIT 1604 3)
				(= seconds 4)
			)
			(11
				(gSq5Music1 fade: 80 10 5 0 self)
			)
			(12
				(PalVary pvUNINIT)
				(global2 newRoom: 165)
			)
		)
	)
)

(instance hall of View
	(properties
		x 82
		y 26
		view 160
		loop 7
		priority 3
		signal $4010
	)
)

(instance shirt of Prop
	(properties
		x 159
		y 146
		view 160
		loop 5
		priority 5
		signal $4010
	)
)

(instance head of Prop
	(properties
		x 139
		y 38
		view 160
		priority 5
		signal $4010
	)
)

(instance eyess of Prop
	(properties
		x 151
		y 67
		view 160
		loop 1
		priority 7
		signal $4010
		cycleSpeed 20
	)
)

(instance hands of Actor
	(properties
		x 117
		y 149
		view 160
		loop 4
		priority 7
		signal $4010
		moveSpeed 1
	)
)

(instance testResults of Feature
	(properties
		y 189
		noun 2
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (if local201 (sDoAll cue:)))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
