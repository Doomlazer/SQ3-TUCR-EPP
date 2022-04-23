;;; Sierra Script 1.0 - (do not remove this comment)
(script# 226)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm226 0
)

(local
	theTool
)
(procedure (localproc_010c)
	(return
		(cond 
			((proc999_4 0 163 110 200 theTool) box1)
			((proc999_4 111 163 216 200 theTool) box2)
			((proc999_4 217 163 319 200 theTool) box3)
			(else 0)
		)
	)
)

(procedure (localproc_0162 &tmp [temp0 50])
	(Message msgGET 226 7 4 0 1 @temp0)
	(Display
		@temp0
		dsCOORD
		25
		173
		dsFONT
		1605
		dsWIDTH
		60
		dsALIGN
		1
		dsCOLOR
		global152
	)
	(Message msgGET 226 17 4 0 1 @temp0)
	(Display
		@temp0
		dsCOORD
		133
		169
		dsFONT
		1605
		dsWIDTH
		60
		dsALIGN
		1
		dsCOLOR
		global152
	)
	(Message msgGET 226 3 4 0 1 @temp0)
	(Display
		@temp0
		dsCOORD
		240
		169
		dsFONT
		1605
		dsWIDTH
		60
		dsALIGN
		1
		dsCOLOR
		global152
	)
)

(instance rm226 of Rm
	(properties
		noun 2
		picture 50
	)
	
	(method (init)
		(global2 setRegions: 210)
		(= theTool 0)
		(vac init:)
		(fuse init:)
		(welder init:)
		(dropper init:)
		(gizmo1 init:)
		(drill1 init:)
		(wrench1 init:)
		(fuse2 init:)
		(cutter init:)
		(drill2 init:)
		(screwdriver init:)
		(antacids init:)
		(gizmo2 init:)
		(gizmo3 init:)
		(soldergun init:)
		(pliers init:)
		(hammer init:)
		(gizmo4 init:)
		(gizmo5 init:)
		(holePunch init:)
		(super init: &rest)
		(box1 addToPic:)
		(box2 addToPic:)
		(box3 addToPic:)
		(localproc_0162)
		(gSQ5 handsOn:)
		(gSq5IconBar disable: 0 3 4 5 6)
	)
	
	(method (doit)
		(if (GameIsRestarting) (localproc_0162))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(if theTool
					(if (= temp0 (localproc_010c))
						(temp0 doVerb: 4)
					else
						(theTool drop:)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Tool of Actor
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
		yStep 15
		view 234
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $5800
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
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 15
		origStep 770
		moveSpeed 0
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		track 0
		origX 0
		origY 0
		invItem -1
	)
	
	(method (init)
		(if
		(or (== invItem -1) (not (gEgo has: invItem)))
			(super init: &rest)
			(self setCycle: 0)
			(= origX x)
			(= origY y)
			(self stopUpd:)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if track
			(if (and (< 30 gPEventX) (< gPEventX 290))
				(self x: gPEventX)
			)
			(if (and (< 15 gPEventY) (< gPEventY 180))
				(self y: gPEventY)
			)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(if theTool
					(if (= temp0 (localproc_010c))
						(temp0 doVerb: 4)
					else
						(theTool drop:)
					)
				else
					(self pickUp:)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self track: 0 stopUpd:)
		(= theTool 0)
	)
	
	(method (drop)
		(= track 0)
		(self stopUpd:)
		(= theTool 0)
		(self setPri: -1)
		((gSq5IconBar at: 2) cursor: 982)
		(gSq5IconBar enable: 1 7 8)
		(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
	)
	
	(method (pickUp)
		(= track 1)
		(self startUpd:)
		(= theTool self)
		(self setPri: 15)
		((gSq5IconBar at: 2) cursor: 996)
		(gSq5IconBar curIcon: (gSq5IconBar at: 2))
		(gSq5IconBar disable: 1 7 8)
		(gSQ5 setCursor: 996)
	)
)

(instance putToolBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client global2)
					(gSQ5 handsOn:)
					(gSQ5 handsOff:)
					(gTestMessager say: 22 0 1 0 self)
				else
					(= cycles 1)
				)
			)
			(1
				(theTool
					track: 0
					setMotion: MoveTo (theTool origX?) (theTool origY?) self
				)
			)
			(2
				(theTool cue:)
				(if (== client global2)
					(gSQ5 handsOn:)
					((gSq5IconBar at: 2) cursor: 982)
					(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
					(gSq5IconBar disable: 0 3 4 5 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance putAllBack of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOn:)
				(gSQ5 handsOff:)
				(gTestMessager say: 22 0 2 0 self)
				(= register (- (gOldCast size?) 1))
			)
			(1
				(if
					(or
						(!=
							((= theTool (gOldCast at: register)) origX?)
							(theTool x?)
						)
						(!= (theTool origY?) (theTool y?))
					)
					(self setScript: putToolBack self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register (-- register) (= state (- state 2)))
				(= cycles 1)
			)
			(3
				(= theTool 0)
				(gSQ5 handsOn:)
				((gSq5IconBar at: 2) cursor: 982)
				(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
				(gSq5IconBar disable: 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

(instance takeTool of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 22 0 3 0 self)
			)
			(1
				(gEgo get: (theTool invItem?))
				(theTool startUpd: hide: track: 0)
				(= cycles 4)
			)
			(2
				(theTool drop: dispose:)
				(= theTool 0)
				(gSQ5 handsOn:)
				((gSq5IconBar at: 2) cursor: 982)
				(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
				(gSq5IconBar disable: 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

(instance vac of Tool
	(properties
		x 154
		y 66
		noun 24
	)
)

(instance gizmo2 of Tool
	(properties
		x 162
		y 98
		noun 9
		cel 1
	)
)

(instance welder of Tool
	(properties
		x 126
		y 105
		noun 23
		loop 1
		invItem 7
	)
)

(instance dropper of Tool
	(properties
		x 112
		y 109
		noun 6
		loop 1
		cel 1
	)
)

(instance gizmo1 of Tool
	(properties
		x 189
		y 88
		noun 10
		loop 2
	)
)

(instance drill1 of Tool
	(properties
		x 154
		y 90
		noun 4
		loop 2
		cel 1
	)
)

(instance wrench1 of Tool
	(properties
		x 114
		y 75
		noun 25
		loop 3
	)
)

(instance fuse2 of Tool
	(properties
		x 160
		y 100
		noun 11
		loop 3
		cel 1
	)
)

(instance cutter of Tool
	(properties
		x 119
		y 81
		noun 18
		loop 4
	)
)

(instance drill2 of Tool
	(properties
		x 174
		y 102
		noun 5
		loop 4
		cel 1
	)
)

(instance screwdriver of Tool
	(properties
		x 182
		y 82
		noun 20
		loop 5
	)
)

(instance gizmo5 of Tool
	(properties
		x 103
		y 79
		noun 13
		loop 5
		cel 1
	)
)

(instance fuse of Tool
	(properties
		x 97
		y 92
		noun 8
		loop 11
		invItem 4
	)
)

(instance gizmo3 of Tool
	(properties
		x 164
		y 96
		noun 12
		loop 6
		cel 1
	)
)

(instance soldergun of Tool
	(properties
		x 203
		y 101
		noun 14
		loop 7
	)
)

(instance pliers of Tool
	(properties
		x 195
		y 61
		noun 19
		loop 7
		cel 1
	)
)

(instance hammer of Tool
	(properties
		x 188
		y 88
		noun 15
		loop 8
	)
)

(instance gizmo4 of Tool
	(properties
		x 136
		y 79
		noun 21
		loop 8
		cel 1
	)
)

(instance holePunch of Tool
	(properties
		x 103
		y 79
		noun 16
		loop 9
		invItem 11
	)
)

(instance antacids of Tool
	(properties
		x 187
		y 53
		noun 1
		loop 9
		cel 1
		invItem 5
	)
	
	(method (init)
		(if (not (proc0_1 170)) (super init: &rest))
	)
)

(instance box1 of View
	(properties
		x 17
		y 163
		noun 7
		view 234
		loop 10
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gSQ5 handsOn:)
				((gSq5IconBar at: 2) cursor: 982)
				(gSQ5 handsOff:)
				(global2 newRoom: 225)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box2 of View
	(properties
		x 123
		y 163
		noun 17
		view 234
		loop 10
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if theTool
					(if (!= (theTool invItem?) -1)
						(switch (theTool invItem?)
							(5 (proc0_10 170 15))
							(7 (proc0_10 173 5))
							(11 (proc0_10 172 5))
							(4 (proc0_10 251 5))
						)
						(global2 setScript: takeTool)
					else
						(global2 setScript: putToolBack)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box3 of View
	(properties
		x 229
		y 163
		noun 3
		view 234
		loop 10
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: putAllBack)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
