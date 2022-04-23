;;; Sierra Script 1.0 - (do not remove this comment)
(script# 620)
(include sci.sh)
(use Main)
(use AnimDialog)
(use Blink)
(use Scaler)
(use Osc)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm620 0
	floTalker 13
	myRogTalker 15
	sUseComm 20
)

(local
	local0
	local1
	local2
	local3
	local4 =  1
)
(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

(instance rm620 of Rm
	(properties
		noun 14
		picture 100
	)
	
	(method (init)
		(proc958_0 143 number)
		(proc958_0 128 22 18)
		(= style
			(switch gGModNum
				(640 12)
				(else  -32758)
			))
		(super init:)
		(gEgo edgeHit: 0)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						0
						142
						19
						144
						47
						150
						149
						181
						176
						189
						319
						189
						319
						123
						281
						126
						258
						126
						189
						126
						177
						129
						227
						132
						241
						143
						239
						158
						232
						164
						213
						168
						177
						169
						118
						159
						100
						153
						80
						150
						49
						142
						0
						132
						0
						141
					yourself:
				)
				((Polygon new:)
					type: 3
					init:
						0
						113
						50
						110
						89
						113
						127
						105
						104
						94
						121
						91
						148
						96
						198
						88
						182
						77
						171
						70
						154
						77
						141
						80
						110
						75
						95
						66
						65
						69
						98
						85
						83
						87
						0
						73
						0
						112
					yourself:
				)
		)
		(if (!= global142 0)
			(pod init:)
			(podDoor init: setOnMeCheck: 1 (podDoor onMeCheck?))
			(mist1 init:)
			(mist2 init:)
			(stems init: setOnMeCheck: 1 (stems onMeCheck?))
			(path init: setOnMeCheck: 1 (path onMeCheck?))
			(bigStem init: setOnMeCheck: 1 (bigStem onMeCheck?))
			(chasm init: setOnMeCheck: 1 (chasm onMeCheck?))
			(if (== global142 1) (podHeat init:))
		)
		(switch gGModNum
			(640
				(if (proc0_1 91)
					(self setScript: sEnterHigh)
				else
					(self setScript: sEnterLow)
				)
			)
			(else 
				(if (proc0_1 109)
					(global2 setScript: sFromShip)
				else
					(global2 setScript: sNoMask)
				)
			)
		)
	)
	
	(method (doit)
		(if (not script)
			(cond 
				((& (= local3 (gEgo onControl: 1)) $0008) (global2 setScript: sExitLow))
				((& local3 $0004) (global2 setScript: sExitHigh))
			)
		)
		(super doit:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (global2 curPic?) 101)
					(gTestMessager say: 5 1 0 0)
				else
					(gTestMessager say: 14 1 0 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sYourDead of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_6 553)
				(gEgo
					init:
					setLoop: 9
					cel: 0
					x: 119
					y: 75
					setCycle: End self
				)
			)
			(1
				(theMusic3 number: 260 setLoop: 1 play:)
				(puker1 init: setCycle: End self)
				(puker2 init: setCycle: End self)
				(puker3 init: setCycle: End self)
			)
			(2 0)
			(3 0)
			(4
				(puker1 setLoop: 3 setCel: 0)
				(puker2 setLoop: 1 setCel: 0)
				(puker3 setLoop: 0 setCel: 0)
				(= seconds 2)
			)
			(5
				(gSq5Music1 number: 102 setLoop: 1 play:)
				(theMusic3 number: 32 setLoop: 1 play:)
				(gEgo setLoop: 10 cel: 0 setCycle: End self)
			)
			(6 (= seconds 1))
			(7
				(gSq5Music1 number: 519 setLoop: 1 play:)
				(thePuke init: setCycle: End self)
			)
			(8
				(gEgo setLoop: 11 cel: 0 setCycle: End self)
			)
			(9 (= seconds 2))
			(10 (proc0_9 29))
		)
	)
)

(instance sFromShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music1 number: 30 setLoop: -1 play:)
				(= seconds 4)
			)
			(1
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(slug init:)
				(proc0_6 22)
				(gEgo
					init:
					ignoreActors: 1
					posn: 231 132
					setCycle: End self
				)
			)
			(2
				(gEgo setScript: sBreath)
				(if (and (!= global142 0) (not (proc0_1 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(proc0_6 18)
				(gEgo setHeading: 180)
				(gSQ5 handsOn:)
				(gSq5IconBar curIcon: (gSq5IconBar at: 0))
				(gSQ5 setCursor: 980)
				(self dispose:)
			)
		)
	)
)

(instance sNoMask of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 4)
			)
			(1
				(theMusic3 number: 260 setLoop: 1 play:)
				(proc0_6 6)
				(gEgo
					init:
					ignoreActors: 1
					setScale: Scaler 100 87 181 123
					posn: 231 132
					setCycle: End self
				)
			)
			(2
				(proc0_6 553 5)
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					setHeading: 180
				)
				(= seconds 1)
			)
			(3 (gEgo setCycle: End self))
			(4 (= seconds 2))
			(5 (proc0_9 28))
		)
	)
)

(instance sExitLow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3 91)
				(global2 newRoom: 640)
			)
		)
	)
)

(instance sExitHigh of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_2 91)
				(gEgo setMotion: MoveTo -20 100 self)
			)
			(1
				(gSQ5 handsOn:)
				(global2 newRoom: 640)
			)
		)
	)
)

(instance sEnterHigh of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (and (!= global142 0) (not (proc0_1 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(proc0_6 18 0)
				(gEgo
					edgeHit: 0
					init:
					ignoreActors: 1
					setScript: sBreath
					posn: 6 100
					setScale: Scaler 93 71 122 75
					setMotion: MoveTo 75 89 self
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterLow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (and (!= global142 0) (not (proc0_1 29)))
					(myBut init: hide:)
					(pod setScript: sBeep)
				)
				(proc0_6 18 0)
				(gEgo
					init:
					ignoreActors: 1
					posn: -30 140
					setScale: Scaler 100 87 181 123
					setScript: sBreath
					setMotion: MoveTo 31 140 self
				)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLocateTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 10))
			(1 (if local0 (self dispose:)))
		)
	)
)

(instance sFinishLook of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1 (gEgo setCycle: Beg self))
			(2
				(proc0_6 18)
				(gEgo setScale: Scaler 93 71 122 75 setHeading: 180)
				(gEgo setScript: sBreath)
				(self dispose:)
			)
		)
	)
)

(instance sMoveSlug of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1 (slug show:) (= seconds 1))
			(2 (slug setCycle: End self))
			(3
				(slugEyes init: setCycle: Osc 3 self)
			)
			(4
				(slugEyes dispose:)
				(slug setLoop: 4 setCycle: End self)
			)
			(5 (slug dispose:))
		)
	)
)

(instance sBurnMe of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (& $0040 (gEgo onControl: 1))
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 104 82 self)
				)
			)
			(1
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					view: 553
					loop: 3
					cel: 1
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 4 cel: 0 setCycle: End self)
				(gSq5Music1 number: 31 setLoop: 1 play:)
				(theMusic3 number: 102 setLoop: 1 play:)
			)
			(3 (= seconds 2))
			(4
				(if (< global145 3) (++ global145))
				(proc0_6 18)
				(gEgo setScale: Scaler 93 71 122 75)
				(theMusic3 stop:)
				(gSq5Music1 number: 30 setLoop: -1 play:)
				(gTestMessager say: 12 4 0 global145 self)
			)
			(5
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseComm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= local2
					(if (or (== global142 0) (proc0_1 104)) 8 else 10)
				)
				(theMusic3 number: 603 setLoop: 1 play:)
				(gEgo view: 553 loop: 8 cel: 0 setCycle: End self)
			)
			(1
				(floTalker
					normal: 0
					keepWindow: 1
					curNoun: local2
					curVerb: 0
					curCase: 4
				)
				(= cycles 1)
			)
			(2
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982)
				(gTestMessager say: local2 0 4 0 self)
			)
			(3
				(floTalker normal: 1 keepWindow: 0)
				(= local1
					(switch (floTalker whichSelect?)
						(1 1)
						(2 2)
						(3 3)
					)
				)
				(gTestMessager say: local2 0 local1 0 self)
			)
			(4 (gEgo setCycle: Beg self))
			(5
				(proc0_6 18)
				(gEgo setHeading: 180)
				(if (not (if (== local1 1) (== local2 8)))
					(gSQ5 handsOn:)
					(self dispose:)
				else
					(= seconds 1)
				)
			)
			(6
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
			)
			(7
				(gEgo dispose:)
				(= seconds 2)
			)
			(8
				(gSQ5 handsOn:)
				(global2 newRoom: 240)
			)
		)
	)
)

(instance sPodScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 103 78 self)
			)
			(1
				(gEgo
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					view: 553
					loop: 6
					cel: 4
					setCycle: End self
				)
			)
			(2 (= seconds 2))
			(3
				(gOldCast eachElementDo: #hide)
				(gEgo dispose:)
				(global2 drawPic: 101 100)
				(if
				(and (not (gEgo has: 19)) (not (proc0_1 29)))
					(frock init:)
				)
				(beltRight init: cycleSpeed: 16 setCycle: Fwd)
				(dashLights init: cycleSpeed: 8 setCycle: Fwd)
				(beltLeft init: cycleSpeed: 17 setCycle: Fwd)
				(gSQ5 handsOn:)
				(= ticks 20)
			)
			(4
				(outside init: setOnMeCheck: 1 (outside onMeCheck?))
			)
			(5
				(gSQ5 handsOff:)
				(if (not (proc0_1 29)) (= next sYourDead))
				(global2 drawPic: 100 100)
				(gOldCast eachElementDo: #show)
				(frock dispose:)
				(myBut dispose:)
				(beltRight dispose:)
				(dashLights dispose:)
				(beltLeft dispose:)
				(outside dispose:)
				(= cycles 1)
			)
			(6
				(if (proc0_1 29) (gEgo init: setScript: sFinishLook))
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance frock of View
	(properties
		x 92
		y 123
		noun 3
		view 565
		loop 4
		signal $5000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_10 223 10)
				(gEgo get: 19)
				(self dispose:)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance myBut of Prop
	(properties
		x 74
		y 140
		noun 1
		view 565
		loop 3
		priority 3
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(sBeep dispose:)
				(proc0_10 224 35)
				(proc0_2 29)
				(self dispose:)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (hide)
		(if (== (global2 curPic?) 101)
			(= cel 1)
		else
			(= cel 1)
			(super hide:)
		)
	)
	
	(method (show)
		(if (== (global2 curPic?) 101)
			(= cel 0)
			(super show:)
		else
			(= cel 0)
		)
	)
)

(instance pod of Prop
	(properties
		x 109
		y 69
		z 20
		noun 12
		view 554
		loop 5
		signal $5000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (< (gEgo y?) 120)
					(if (== global142 1)
						(global2 setScript: sBurnMe)
					else
						(global2 setScript: sPodScript)
					)
				else
					(gTestMessager say: 4 4 0 0)
				)
			)
			(1 (gTestMessager say: 4 1 0 0))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance outside of Feature
	(properties
		x 180
		y 130
		onMeCheck $1000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (sPodScript cue:))
			(4 (sPodScript cue:))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mist1 of Prop
	(properties
		x 177
		y 156
		view 554
		loop 3
		cel 3
		cycleSpeed 15
		detailLevel 3
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance mist2 of Prop
	(properties
		x 92
		y 189
		view 554
		loop 2
		cel 1
		cycleSpeed 15
		detailLevel 3
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance slug of Prop
	(properties
		x 277
		y 139
		noun 16
		view 554
		priority 15
		signal $0010
		cycleSpeed 60
	)
	
	(method (init)
		(super init:)
		(self hide: setScript: sMoveSlug)
	)
)

(instance slugEyes of Prop
	(properties
		x 296
		y 135
		view 554
		loop 1
		cel 1
		priority 15
		signal $0010
		cycleSpeed 15
		detailLevel 3
	)
)

(instance puker1 of Actor
	(properties
		x 158
		y 83
		view 561
		loop 9
	)
)

(instance puker2 of Actor
	(properties
		x 84
		y 90
		view 561
		loop 8
	)
)

(instance puker3 of Actor
	(properties
		x 73
		y 72
		view 561
		loop 7
	)
)

(instance podHeat of Prop
	(properties
		x 136
		y 54
		noun 17
		view 553
		cel 1
		signal $5000
		detailLevel 3
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance chasm of Feature
	(properties
		x 124
		y 113
		noun 2
		onMeCheck $0100
	)
)

(instance stems of Feature
	(properties
		x 24
		y 57
		noun 18
		onMeCheck $1000
	)
)

(instance bigStem of Feature
	(properties
		x 285
		y 59
		noun 19
		onMeCheck $0800
	)
)

(instance path of Feature
	(properties
		x 79
		y 154
		noun 9
		onMeCheck $2000
	)
)

(instance podDoor of Feature
	(properties
		x 120
		y 155
		z 100
		noun 9
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (< (gEgo y?) 120)
					(global2 setScript: sPodScript)
				else
					(gTestMessager say: 4 1 0 0)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance thePuke of Actor
	(properties
		x 124
		y 56
		view 561
		loop 11
		priority 15
		signal $0010
	)
)

(instance dashLights of Prop
	(properties
		x 212
		y 41
		noun 11
		view 565
		cel 3
	)
)

(instance beltLeft of Prop
	(properties
		x 123
		y 95
		noun 15
		view 565
		loop 1
		cel 2
		cycleSpeed 15
	)
)

(instance beltRight of Prop
	(properties
		x 209
		y 94
		noun 15
		view 565
		loop 2
		cel 2
		cycleSpeed 20
	)
)

(instance floTalker of ChoiceTalker
	(properties
		x 10
		y 15
		view 1008
		signal $0010
		talkWidth 180
		keepWindow 1
		textX 100
		normal 1
	)
	
	(method (init)
		(= font gFont)
		(super init: floBust floEyes floMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance floBust of Prop
	(properties
		view 1008
	)
)

(instance floEyes of Prop
	(properties
		nsTop 33
		nsLeft 39
		view 1008
		loop 2
		signal $4000
	)
)

(instance floMouth of Prop
	(properties
		nsTop 43
		nsLeft 45
		view 1008
		loop 1
		signal $4000
	)
)

(instance sBreath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 550 setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= seconds (Random 2 4))
			)
		)
	)
)

(instance sBeep of Script
	(properties)
	
	(method (dispose)
		(theMusic4 dispose:)
		(myBut dispose:)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (global2 curPic?) 101) (myBut show:))
				(theMusic4
					number: 124
					setLoop: 1
					play: self
					setVol: (proc999_2
						127
						(proc999_3 40 (- 130 (gEgo distanceTo: pod)))
					)
				)
			)
			(1
				(myBut hide:)
				(= state -1)
				(= seconds 2)
			)
		)
	)
)

(instance myRogTalker of Talker
	(properties
		x 10
		y 25
		view 556
		loop 5
		talkWidth 150
		back 5
		textX 120
		textY 2
	)
	
	(method (init)
		(= font gFont)
		(super init: rogBust 0 rogMouth &rest)
	)
	
	(method (dispose)
		(super dispose: &rest)
	)
)

(instance rogBust of Prop
	(properties
		view 556
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 18
		nsLeft 43
		view 556
		loop 2
	)
)
