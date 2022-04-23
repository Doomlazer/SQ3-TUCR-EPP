;;; Sierra Script 1.0 - (do not remove this comment)
(script# 135)
(include sci.sh)
(use Main)
(use starCon)
(use SpeakWindow)
(use Blink)
(use Osc)
(use RandCycle)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm135 0
	smartTalker 1
	dumbTalker 2
	rogerTalker 15
)

(local
	[local0 10] = [3 4 4 2 4 2 4 3]
	[local10 10] = [2 3 0 4 1 4 1 1 2 4]
	local20
)
(instance rm135 of Rm
	(properties
		noun 11
		picture 22
		style $800a
	)
	
	(method (init)
		(self setRegions: 109)
		(proc958_0 128 120 121 122 123 124 128)
		(proc958_0 143 135)
		(gSQ5 handsOff:)
		(proc0_2 1)
		(proc0_10 160 5)
		(gEgo view: 121)
		(blobBody init: setOnMeCheck: 1 2)
		(blueGuyBody init: setOnMeCheck: 1 4)
		(dumbCadetBody init: setOnMeCheck: 1 8)
		(greenGirlBody init: setOnMeCheck: 1 16)
		(klingonBody init: setOnMeCheck: 1 32)
		(ramBody init: setOnMeCheck: 1 64)
		(smartCadetBody init: setOnMeCheck: 1 128)
		(rogDesk init: setOnMeCheck: 1 16384)
		(smartCadetDesk init: setOnMeCheck: 1 8192)
		(dumbCadetDesk init: setOnMeCheck: 1 -32768)
		(classDoor init: setOnMeCheck: 1 4096)
		(generalDesk init: setOnMeCheck: 1 512)
		(cyclopsEye init: setScript: sCyclopsEye)
		(hornedGuy init: setScript: sHornedGuy)
		(redGuy init:)
		(bubbleHead init:)
		(smartEyes init: setScript: sSmartEyes)
		(smartHand init: setCycle: RandCycle)
		(super init:)
		(switch gGModNum
			(137
				(if (> gState 9)
					(global2 setScript: sTestOver)
				else
					(cheatDroid
						posn: (Random 20 320) 55
						init:
						setLoop: 0
						setScript: sCheatDroid
					)
					(global2 setScript: sRogTakeTest)
				)
			)
			(else 
				(global2 setScript: sTalkToTeach)
			)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
)

(instance sTalkToTeach of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= global115 0)
				(= gState 0)
				(gEgo
					view: 120
					setLoop: 0
					setCel: 0
					posn: 96 41
					setPri: 14
					signal: 16400
					setScale: 0
					init:
				)
				(= seconds 1)
			)
			(1
				(gEgo view: 121 setLoop: 0 setCel: 0 posn: 104 49)
				(gSq5Music2 number: 123 setLoop: 1 play: self)
			)
			(2
				(gTestMessager say: 10 0 0 1 self)
			)
			(3
				(gSq5Music2 number: 1231 setLoop: 1 play: self)
			)
			(4
				(gEgo setLoop: 5 setCel: 0 posn: 104 48)
				(= local20 1)
				(gSq5Music1 number: 6 setLoop: -1 play:)
				(= ticks 10)
			)
			(5
				(gTestMessager say: 10 0 0 2 self)
			)
			(6
				(gSq5Music1 stop:)
				(gEgo setLoop: 0 setCel: 0 posn: 104 49)
				(= local20 0)
				(= cycles 1)
			)
			(7
				(gSq5Music2 number: 1232 setLoop: 1 play: self)
			)
			(8
				(gTestMessager say: 10 0 0 3 self)
			)
			(9
				(gSq5Music2 number: 1231 setLoop: 1 play: self)
			)
			(10
				(gTestMessager say: 10 0 0 4 self)
			)
			(11
				(gSq5Music1 number: 7 setLoop: -1 play:)
				(gEgo setLoop: 2 setCel: 0 posn: 111 71)
				(blueGuy init: setScript: sBlueGuy)
				(klingon init: setScript: sKlingon)
				(gSQ5 handsOn:)
				(global2 newRoom: 137)
				(self dispose:)
			)
		)
	)
)

(instance sRogTakeTest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 2 setCel: 0 posn: 111 71 init:)
				(rogShiftyEyes setCycle: Osc init:)
				(gSQ5 handsOn:)
				(gSq5IconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtSmart of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_10 161 5)
				(if (and (< 6 gState) (< gState 9))
					(cheatAnswer loop: 3)
				else
					(cheatAnswer loop: 2)
				)
				(cheatAnswer posn: 50 30 cel: [local0 gState] init:)
				(cheatQuestion posn: 46 16 cel: gState init:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 120 setLoop: 1 play: self)
				(cheatAnswer dispose:)
				(cheatQuestion dispose:)
			)
			(2
				(gEgo setScript: sRogTakeTest)
				(= seconds 1)
			)
			(3
				(bubbleHead setCel: 1 posn: 30 40)
				(smartEyes hide:)
				(smartHand hide:)
				(= seconds 2)
			)
			(4
				(bubbleHead setCel: 0 posn: 31 41)
				(smartEyes show:)
				(smartHand show:)
				(cheatDroid setScript: sCheatDroid)
				(gSQ5 handsOn:)
				(gSq5IconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtDumb of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< 6 gState) (< gState 9))
					(cheatAnswer loop: 3)
				else
					(cheatAnswer loop: 2)
				)
				(cheatAnswer posn: 250 30 cel: [local10 gState] init:)
				(cheatQuestion posn: 246 16 cel: gState init:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 120 setLoop: 1 play: self)
				(cheatAnswer dispose:)
				(cheatQuestion dispose:)
			)
			(2
				(gEgo setScript: sRogTakeTest)
				(= seconds 1)
			)
			(3
				(redGuy setCel: 1 posn: 266 49)
				(= seconds 2)
			)
			(4
				(redGuy setCel: 0 posn: 274 46)
				(cheatDroid setScript: sCheatDroid)
				(gSQ5 handsOn:)
				(gSq5IconBar disable: 0 4)
				(self dispose:)
			)
		)
	)
)

(instance sBlueGuy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(blueGuy show:)
				(= seconds (Random 3 6))
			)
			(1
				(blueGuy hide:)
				(= seconds (Random 3 6))
			)
			(2 (= state -1) (= cycles 1))
		)
	)
)

(instance sSmartEyes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* (Random 1 3) 3))
			)
			(1
				(smartEyes setCycle: Osc 1 self)
			)
			(2 (= state -1) (= cycles 1))
		)
	)
)

(instance sHornedGuy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hornedGuy show:)
				(= seconds (Random 1 4))
			)
			(1
				(hornedGuy hide:)
				(= seconds (Random 1 4))
			)
			(2 (= state -1) (= cycles 1))
		)
	)
)

(instance sKlingon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(klingon show:)
				(= seconds (Random 2 5))
			)
			(1
				(klingon hide:)
				(= seconds (Random 2 5))
			)
			(2 (= state -1) (= cycles 1))
		)
	)
)

(instance sCyclopsEye of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cyclopsEye setCycle: End self)
			)
			(1 (= seconds (Random 1 3)))
			(2
				(cyclopsEye setCycle: Beg self)
			)
			(3 (= seconds (Random 3 6)))
			(4 (= state -1) (= cycles 1))
		)
	)
)

(instance sCheatDroid of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cheatDroid cel: 3)
				(= seconds (Random 2 4))
			)
			(1
				(cheatDroid cel: 4)
				(= ticks 4)
			)
			(2
				(cheatDroid cel: 5)
				(= ticks 4)
			)
			(3
				(cheatDroid cel: 0)
				(= seconds (Random 2 4))
			)
			(4
				(cheatDroid cel: 1)
				(= ticks 4)
			)
			(5
				(cheatDroid cel: 2)
				(= state -1)
				(= ticks 4)
			)
		)
	)
)

(instance sCheatAlert of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(droidAmbient dispose:)
				(cheatDroid xStep: 10)
				(if (> (cheatDroid x?) 160)
					(cheatDroid setMotion: MoveTo 240 (cheatDroid y?) self)
				else
					(cheatDroid setMotion: MoveTo 80 (cheatDroid y?) self)
				)
			)
			(1
				(cond 
					((== (cheatDroid cel?) 2) (cheatDroid setCel: 1) (= cycles 1))
					((> (cheatDroid cel?) 3) (cheatDroid setCycle: End self))
					(else (= cycles 1))
				)
			)
			(2
				(gSq5Music2 number: 122 setLoop: -1 play:)
				(cheatDroid setLoop: 1 setCel: 0)
				(= ticks 4)
			)
			(3
				(cheatDroid setLoop: 1 setCel: 1)
				(= ticks 4)
			)
			(4
				(alertTop
					posn: (- (cheatDroid x?) 9) (- (cheatDroid y?) 16)
					init:
				)
				(alertEyes
					x: (- (cheatDroid x?) 9)
					y: (- (cheatDroid y?) 6)
					init:
					setCycle: Fwd
				)
				(alertBeacon
					posn: (- (cheatDroid x?) 4) (+ (cheatDroid y?) 10)
					init:
				)
				(alertBeaconLight
					posn: (- (cheatDroid x?) 2) (+ (cheatDroid y?) 15)
					init:
				)
				(alertBottom
					posn: (+ (cheatDroid x?) 2) (+ (cheatDroid y?) 37)
					init:
				)
				(= ticks 4)
			)
			(5
				(alertBeaconLight setCycle: Fwd)
				(alertBeacon setCycle: Fwd)
				(cyclopsEye dispose:)
				(klingon dispose:)
				(blueGuy dispose:)
				(hornedGuy dispose:)
				(= ticks 1)
			)
			(6
				(alertTop hide:)
				(alertBottom hide:)
				(= ticks 2)
			)
			(7
				(if (not (gEgo script?)) (gEgo setScript: sRogCaught))
				(alertTop show:)
				(alertBottom show:)
				(= ticks 2)
			)
			(8 (= state 3) (= cycles 1))
		)
	)
)

(instance sRogCaught of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogShiftyEyes hide:)
				(gSq5Music1 number: 8 setLoop: 1 play:)
				(gEgo loop: 5 cel: 1 posn: 113 75)
				(= seconds 3)
			)
			(1
				(gTestMessager say: 10 0 0 8 self)
			)
			(2
				(global2 newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sTestOver of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 fade:)
				(gEgo loop: 0 cel: 0 posn: 104 49 init:)
				(= seconds 3)
			)
			(1
				(gSq5Music1 number: 5 setLoop: -1 play:)
				(gTestMessager say: 10 0 0 5 self)
			)
			(2
				(gSq5Music2 number: 123 setLoop: 1 play: self)
			)
			(3
				(if (> global115 4)
					(gTestMessager say: 10 0 0 6 self)
				else
					(gTestMessager say: 10 0 0 7 self)
				)
			)
			(4
				(if (> global115 4)
					(starCon setScript: (ScriptID 109 2))
					(= cycles 2)
				else
					(global2 newRoom: 195)
					(self dispose:)
				)
			)
			(5
				(global2 newRoom: 123)
				(self dispose:)
			)
		)
	)
)

(instance rogShiftyEyes of Prop
	(properties
		x 169
		y 95
		noun 1
		modNum 1
		view 121
		loop 6
		priority 14
		signal $4010
	)
)

(instance hornedGuy of Prop
	(properties
		x 204
		y 50
		noun 9
		view 124
		loop 4
		priority 2
		signal $0010
		detailLevel 2
	)
)

(instance blueGuy of Prop
	(properties
		x 162
		y 38
		noun 2
		view 124
		loop 2
		priority 1
		signal $0010
		detailLevel 2
	)
)

(instance klingon of Prop
	(properties
		x 98
		y 49
		noun 8
		view 124
		loop 3
		priority 2
		signal $0010
		detailLevel 2
	)
)

(instance cyclopsEye of Prop
	(properties
		x 80
		y 77
		noun 1
		view 124
		loop 5
		priority 1
		signal $0010
		detailLevel 2
	)
)

(instance redGuy of Prop
	(properties
		x 274
		y 46
		noun 6
		view 124
		priority 6
		signal $0010
	)
)

(instance bubbleHead of Prop
	(properties
		x 31
		y 41
		noun 12
		view 123
		priority 6
		signal $0010
	)
)

(instance cheatDroid of Actor
	(properties
		x 350
		y 55
		noun 3
		view 122
		priority 4
		signal $0010
	)
	
	(method (init)
		(super init:)
		(droidAmbient init: setCycle: Fwd)
		(gSq5Music2 number: 121 setLoop: -1 play:)
	)
	
	(method (doit)
		(if
			(and
				(== (cheatDroid mover?) 0)
				(not (== (cheatDroid script?) sCheatAlert))
			)
			(if (> (cheatDroid x?) 300)
				(cheatDroid setMotion: MoveTo 20 55)
			else
				(cheatDroid setMotion: MoveTo 320 55)
			)
		)
		(super doit:)
		(cond 
			((== (self cel?) 0) (droidAmbient loop: 6 show:))
			((== (self cel?) 3) (droidAmbient loop: 7 show:))
			(else (droidAmbient hide:))
		)
		(droidAmbient x: (self x?) y: (self y?))
	)
	
	(method (dispose)
		(gSq5Music2 stop:)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (self cel?) 3)
					(gTestMessager say: noun 1 2 0 self)
				else
					(gTestMessager say: noun 1 1 0 self)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance droidAmbient of Prop
	(properties
		noun 3
		view 122
		loop 6
		priority 4
		signal $4010
	)
)

(instance alertTop of Prop
	(properties
		noun 3
		view 122
		loop 2
		priority 5
		signal $0010
	)
)

(instance alertEyes of Prop
	(properties
		noun 3
		view 122
		loop 5
		priority 5
		signal $0010
	)
)

(instance alertBeacon of Prop
	(properties
		noun 3
		view 122
		loop 4
		priority 5
		signal $0010
	)
)

(instance alertBottom of Prop
	(properties
		noun 3
		view 122
		loop 2
		cel 2
		priority 5
		signal $0010
	)
)

(instance alertBeaconLight of Prop
	(properties
		noun 3
		view 122
		loop 3
		priority 6
		signal $0010
		cycleSpeed 0
	)
)

(instance smartEyes of Prop
	(properties
		x -3
		y 93
		noun 12
		view 123
		loop 2
		priority 14
		signal $0010
		cycleSpeed 20
	)
)

(instance smartHand of Prop
	(properties
		x -10
		y 155
		noun 12
		view 123
		loop 1
		priority 15
		signal $0010
		cycleSpeed 15
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 11
		view 121
	)
)

(instance dumbMouth of Prop
	(properties
		nsTop 1
		nsLeft 1
		view 123
		loop 4
	)
)

(instance smartMouth of Prop
	(properties
		nsTop 1
		nsLeft 1
		view 123
		loop 4
	)
)

(instance rogerTalker of Talker
	(properties
		x 104
		view 121
		talkWidth 170
		textX -70
	)
	
	(method (init)
		(= talkWidth (proc0_12 250 170 250 170 170))
		(= font gFont)
		(= gSq5Win SpeakWindow)
		(gSq5Win
			tailX: (proc0_12 164 164 164 164 124)
			tailY: (proc0_12 42 46 42 46 46)
			xOffset: (proc0_12 5 5 5 5 -5)
		)
		(if local20
			(rogMouth loop: 7 nsTop: 13 nsLeft: 42)
			(self loop: 5 cel: 0 y: 46)
		else
			(rogMouth loop: 1 nsTop: 11 nsLeft: 43)
			(self loop: 0 cel: 0 y: 49)
		)
		(super init: 0 0 rogMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance dumbTalker of Talker
	(properties
		x 260
		y 49
		view 123
		loop 3
		talkWidth 130
		textX -100
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win SpeakWindow)
			tailX: 260
			tailY: 43
			xOffset: -45
		)
		(super init: 0 0 dumbMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance smartTalker of Talker
	(properties
		x 30
		y 49
		view 123
		loop 3
		talkWidth 170
		textX 40
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win SpeakWindow) tailX: 40 tailY: 43 xOffset: 60)
		(super init: 0 0 smartMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance cheatAnswer of View
	(properties
		x 50
		y 30
		view 128
		loop 2
		priority 15
		signal $0010
	)
)

(instance cheatQuestion of View
	(properties
		x 46
		y 16
		view 128
		priority 15
		signal $0010
	)
)

(instance rogDesk of Feature
	(properties
		x 157
		y 136
		noun 5
		onMeCheck $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 newRoom: 137))
			(1 (global2 newRoom: 137))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smartCadetDesk of Feature
	(properties
		x 12
		y 149
		noun 5
		onMeCheck $2000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSQ5 handsOff:)
				(cheatDroid setScript: 0)
				(rogShiftyEyes hide:)
				(gSq5Music2 number: 120 setLoop: 1 play:)
				(gEgo setLoop: 3 setCel: 0 posn: 107 46)
				(if (not (== (cheatDroid cel?) 3))
					(cheatDroid setScript: sCheatAlert)
				else
					(global2 setScript: sLookAtSmart)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dumbCadetDesk of Feature
	(properties
		x 304
		y 127
		noun 5
		onMeCheck $8000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSQ5 handsOff:)
				(cheatDroid setScript: 0)
				(rogShiftyEyes hide:)
				(gSq5Music2 number: 120 setLoop: 1 play:)
				(gEgo setLoop: 4 setCel: 0 posn: 117 61)
				(if (not (== (cheatDroid cel?) 3))
					(cheatDroid setScript: sCheatAlert)
				else
					(global2 setScript: sLookAtDumb)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blobBody of Feature
	(properties
		x 4
		y 20
		noun 1
		onMeCheck $0002
	)
)

(instance blueGuyBody of Feature
	(properties
		x 4
		y 20
		noun 2
		onMeCheck $0004
	)
)

(instance dumbCadetBody of Feature
	(properties
		x 4
		y 20
		noun 6
		onMeCheck $0008
	)
)

(instance greenGirlBody of Feature
	(properties
		x 4
		y 20
		noun 7
		onMeCheck $0010
	)
)

(instance klingonBody of Feature
	(properties
		x 4
		y 20
		noun 8
		onMeCheck $0020
	)
)

(instance ramBody of Feature
	(properties
		x 4
		y 20
		noun 9
		onMeCheck $0040
	)
)

(instance smartCadetBody of Feature
	(properties
		x 4
		y 20
		noun 12
		onMeCheck $0080
	)
)

(instance classDoor of Feature
	(properties
		x 4
		y 20
		noun 4
		onMeCheck $1000
	)
)

(instance generalDesk of Feature
	(properties
		x 4
		y 20
		noun 5
		onMeCheck $0200
	)
)
