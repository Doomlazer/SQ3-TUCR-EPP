;;; Sierra Script 1.0 - (do not remove this comment)
(script# 109)
(include sci.sh)
(use Main)
(use Blink)
(use CueObj)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	starCon 0
	sTestTimer 1
	sCrestTimer 2
	sExitSouth 3
	sExitNorth 4
	sEnterSouth 5
	sEnterNorth 6
	cadetsTalker 7
)

(local
	local0
	local1 =  -1
)
(class starCon of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
	)
	
	(method (init)
		(super init: &rest)
		(gSQ5Narrator y: 20)
		(if (proc999_5 gModNum 121 125 122 123 117 115)
			(gEgo baseSetter: myBaseSetter)
		else
			(gEgo baseSetter: 0)
		)
		(cond 
			((proc999_5 gModNum 115 117 119 121 122 123 125)
				(if
					(not
						(proc999_5 gGModNum 115 117 119 121 122 123 125 135)
					)
					(gSq5Music1 number: 5 setLoop: -1 play:)
				)
			)
			((proc999_5 gGModNum 115 117 119 121 122 123 125) (gSq5Music1 fade: 0 10 5 1))
		)
		(if (proc999_5 gModNum 121 122 123 125)
			(hallPeople init:)
			(bayFeature init: setOnMeCheck: 1 64)
		)
	)
	
	(method (dispose)
		(gSQ5Narrator y: -1)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc999_5 gModNum 121 122 123 125)
					(gTestMessager
						say: 3 1 0 (+ (= local1 (mod (++ local1) 4)) 1) 0 109
					)
				)
			)
			(18
				(gTestMessager say: 0 18 1 0 0 109)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5
				newRoomNumber
				110
				115
				117
				119
				121
				122
				123
				125
				127
				132
				133
				135
				137
				165
				166
				195
			)
		)
		(= initialized 0)
		(if (proc999_5 gModNum 121 125 122 123)
			(hallPeople dispose:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance hallPeople of Prop
	(properties
		noun 2
		view 147
		signal $4000
	)
	
	(method (init)
		(switch gModNum
			(121
				(self
					loop: 0
					cel: 0
					x: 110
					y: 146
					approachX: 130
					approachY: 151
				)
				(= local0 1)
			)
			(122
				(self
					loop: 1
					cel: 0
					x: 127
					y: 130
					approachX: 131
					approachY: 138
				)
				(= local0 2)
			)
			(123
				(self
					loop: 3
					cel: 0
					x: 219
					y: 135
					approachX: 218
					approachY: 142
				)
				(= local0 3)
				(super init:)
				(self approachVerbs: 4 24 2 setScript: sHallPeople)
			)
			(125
				(self
					loop: 2
					cel: 0
					x: 105
					y: 148
					approachX: 126
					approachY: 142
				)
				(= local0 4)
			)
		)
		(if
		(and (proc0_1 1) (proc999_5 gModNum 121 122 125))
			(super init:)
			(self approachVerbs: 4 24 2 setScript: sHallPeople)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: noun theVerb 0 local0 0 109)
			)
			(1
				(gTestMessager say: noun theVerb 0 local0 0 109)
			)
			(2
				(gTestMessager say: noun theVerb 0 local0 0 109)
			)
			(24
				(gTestMessager say: noun theVerb 0 local0 0 109)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bayFeature of Feature
	(properties
		x 5
		y 5
		noun 1
		modNum 109
		onMeCheck $0040
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager
					say: 1 1 0 (+ (= local1 (mod (++ local1) 4)) 1) 0 109
				)
			)
			(18
				(gTestMessager say: 0 18 1 0 0 109)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myBaseSetter of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0
			(/ (- (param1 nsBottom?) (param1 nsTop?)) 20)
		)
		(= temp1
			(/
				(*
					(CelWide (param1 view?) (param1 loop?) (param1 cel?))
					(param1 scaleX?)
				)
				140
			)
		)
		(= temp2 (- (param1 x?) (/ temp1 2)))
		(= temp3 (- (param1 y?) (/ temp0 2)))
		(param1
			brLeft: temp2
			brRight: (+ temp2 temp1)
			brTop: temp3
			brBottom: (+ temp3 temp0)
		)
	)
)

(instance sHallPeople of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hallPeople setCycle: End self)
			)
			(1 (= seconds (Random 1 2)))
			(2
				(hallPeople setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 4 7))
			)
			(4 (self dispose:))
		)
	)
)

(instance sTestTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 300))
			(1
				(gTestMessager say: 4 0 2 1 self 109)
			)
			(2 (= seconds 180))
			(3
				(gTestMessager say: 4 0 2 2 self 109)
			)
			(4 (= seconds 60))
			(5
				(gTestMessager say: 4 0 2 3 self 109)
			)
			(6 (= seconds 30))
			(7
				(global2 newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sCrestTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 300))
			(1
				(gTestMessager say: 4 0 3 1 self 109)
			)
			(2 (= seconds 180))
			(3
				(gTestMessager say: 4 0 3 2 self 109)
			)
			(4 (= seconds 60))
			(5
				(gTestMessager say: 4 0 3 3 self 109)
			)
			(6 (= seconds 30))
			(7
				(global2 newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(global2 newRoom: register)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					setPri: -1
					setLoop: 3
					posn: 160 160
					setMotion: MoveTo 160 140 self
				)
			)
			(1
				(gEgo setLoop: -1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					setPri: 0
					x: 115
					y: 105
					setMotion: MoveTo 143 107 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 147 112 self)
			)
			(2
				(gEgo setPri: -1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setPri: 0 setMotion: MoveTo 115 105 self)
			)
			(1 (global2 newRoom: register))
		)
	)
)

(instance cadetsTalker of Narrator
	(properties)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(switch gModNum
			(121
				(gSq5Win tailX: 100 tailY: 90 xOffset: 0)
			)
			(122
				(gSq5Win tailX: 110 tailY: 90 xOffset: 0)
			)
			(123
				(gSq5Win tailX: 225 tailY: 90 xOffset: 1)
			)
			(125
				(gSq5Win tailX: 104 tailY: 85 xOffset: 6)
			)
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)
