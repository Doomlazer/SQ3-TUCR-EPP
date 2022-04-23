;;; Sierra Script 1.0 - (do not remove this comment)
(script# 137)
(include sci.sh)
(use Main)
(use CueObj)
(use n958)
(use Game)
(use View)
(use Obj)

(public
	rm137 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 10] = [84 76 76 84 92 84 100 76 68 84]
	[local15 10] = [97 97 105 105 105 97 113 89 105 105]
	[local25 10] = [110 118 118 118 126 118 134 118 126 118]
	[local35 10] = [123 139 131 139 147 139 147 131 147 139]
	[local45 10] = [136 152 144 152 168 160 160 146 176 152]
	[local55 20] = [3 4 4 2 4 2 4 3 0 0 2 3 0 4 1 4 1 1 2 4]
	[local75 200]
)
(class AnswerBox of View
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		state $0000
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view 128
		loop 1
		cel 1
		priority 15
		underBits 0
		signal $0101
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		boxnum 0
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(DrawCel 128 1 0 x y)
				(if (== [local55 gState] boxnum) (++ global115))
				(gSq5Music2 number: 124 setLoop: 1 play:)
				(sTest setScript: sNextQuest)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm137 of Rm
	(properties
		picture 24
		style $800a
	)
	
	(method (init)
		(self setRegions: 109)
		(proc958_0 128 128)
		(gEgo view: 1)
		(exitTest init: setOnMeCheck: 1 4)
		(super init:)
		(gSQ5 handsOn:)
		(gSq5IconBar disable: 0 3 4)
		(global2 setScript: sTest)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(
				(and
					(proc999_4 20 0 300 200 gPEventX gPEventY)
					(!= (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
				)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982)
			)
			(
				(and
					(not (proc999_4 20 0 300 200 gPEventX gPEventY))
					(!= (gSq5IconBar curIcon?) (gSq5IconBar at: 1))
				)
				(gSq5IconBar select: (gSq5IconBar at: 1))
				(gSQ5 setCursor: 981)
			)
		)
	)
)

(instance sTest of Script
	(properties)
	
	(method (doit)
		(if (GameIsRestarting) (self changeState: 0))
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 [local5 gState])
				(= local1 [local15 gState])
				(= local2 [local25 gState])
				(= local3 [local35 gState])
				(= local4 [local45 gState])
				(box1 init:)
				(= state gState)
				(= cycles 1)
			)
			(1
				(Message msgGET 137 2 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 2 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 2 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 2 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 2 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 2 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(2
				(Message msgGET 137 3 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 3 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 3 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 3 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 3 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 3 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(3
				(Message msgGET 137 4 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 4 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 4 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 4 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 4 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 4 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(4
				(Message msgGET 137 5 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 5 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 5 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 5 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 5 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 5 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(5
				(Message msgGET 137 6 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 6 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 6 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 6 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 6 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 6 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(6
				(Message msgGET 137 7 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 7 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 7 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 7 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 7 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 7 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(7
				(Message msgGET 137 8 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 8 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 8 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 8 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 8 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 8 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(8
				(Message msgGET 137 9 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 9 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 9 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 9 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 9 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(9
				(Message msgGET 137 10 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 10 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 10 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 10 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 10 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(10
				(Message msgGET 137 1 0 0 1 @local75)
				(Display
					@local75
					dsCOORD
					38
					55
					dsCOLOR
					39
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					240
				)
				(Message msgGET 137 1 0 0 2 @local75)
				(Display
					@local75
					dsCOORD
					55
					local0
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 1 0 0 3 @local75)
				(Display
					@local75
					dsCOORD
					55
					local1
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 1 0 0 4 @local75)
				(Display
					@local75
					dsCOORD
					55
					local2
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 1 0 0 5 @local75)
				(Display
					@local75
					dsCOORD
					55
					local3
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
				(Message msgGET 137 1 0 0 6 @local75)
				(Display
					@local75
					dsCOORD
					55
					local4
					dsCOLOR
					36
					dsBACKGROUND
					1
					dsFONT
					1605
					dsWIDTH
					235
				)
			)
			(11
				(gSq5Music2 number: 125 setLoop: 1 play: self)
			)
			(12
				(global2 newRoom: 135)
				(self dispose:)
			)
		)
	)
)

(instance sNextQuest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(++ gState)
				(= ticks 45)
			)
			(1
				(box1 dispose:)
				(DrawPic 24 dpOPEN_PIXELATION)
				(= cycles 1)
			)
			(2
				(if (< gState 10)
					(= local0 [local5 gState])
					(= local1 [local15 gState])
					(= local2 [local25 gState])
					(= local3 [local35 gState])
					(= local4 [local45 gState])
					(box1 init:)
					(= cycles 15)
				else
					(= cycles 1)
				)
			)
			(3
				(sTest cue:)
				(gSQ5 handsOn:)
				(gSq5IconBar disable: 0 3 4)
				(self dispose:)
			)
		)
	)
)

(instance box1 of AnswerBox
	(properties)
	
	(method (init)
		(self cel: 1 posn: 37 (- local0 1))
		(super init:)
		(self stopUpd:)
		(self ignoreActors: 1)
		(box2
			cel: 1
			posn: 37 (- local1 1)
			init:
			ignoreActors: 1
			stopUpd:
		)
		(box3
			cel: 1
			posn: 37 (- local2 1)
			init:
			ignoreActors: 1
			stopUpd:
		)
		(box4
			cel: 1
			posn: 37 (- local3 1)
			init:
			ignoreActors: 1
			stopUpd:
		)
		(if (not (if (< 6 gState) (< gState 9)))
			(box5
				cel: 1
				posn: 37 (- local4 1)
				init:
				ignoreActors: 1
				stopUpd:
			)
		)
	)
	
	(method (dispose)
		(super dispose:)
		(box2 dispose:)
		(box3 dispose:)
		(box4 dispose:)
		(box5 dispose:)
	)
)

(instance box2 of AnswerBox
	(properties
		boxnum 1
	)
)

(instance box3 of AnswerBox
	(properties
		boxnum 2
	)
)

(instance box4 of AnswerBox
	(properties
		boxnum 3
	)
)

(instance box5 of AnswerBox
	(properties
		boxnum 4
	)
)

(instance exitTest of Feature
	(properties
		x 4
		y 20
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (global2 newRoom: 135))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
