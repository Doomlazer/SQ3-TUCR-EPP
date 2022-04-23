;;; Sierra Script 1.0 - (do not remove this comment)
(script# 730)
(include sci.sh)
(use Main)
(use VelocityMover)
(use AnimDialog)
(use genetix)
(use Print)
(use Blink)
(use Scaler)
(use PolyPath)
(use Polygon)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm730 0
	cliffyTalker 11
	rogTalker 15
	sUseComm 20
)

(local
	local0
	[local1 2]
	local3
)
(instance theMusic3 of Sound
	(properties)
)

(instance rm730 of Rm
	(properties
		noun 21
		picture 112
	)
	
	(method (init)
		(= style
			(switch gGModNum
				(760 11)
				(740 -32758)
				(790 -32758)
				(770 -32758)
			)
		)
		(if (proc0_1 22) (exit740 init:))
		(self setRegions: 31)
		(proc958_0 143 number)
		(proc958_0 128 1003)
		(bigWF init:)
		(bridge init:)
		(domeBack init:)
		(pondF init:)
		(smallFalls init:)
		(gEgo edgeHit: 0)
		(plant init: setScript: swOscilate)
		(super init:)
		(if (not (proc0_1 28)) (bigDoor init: stopUpd:))
		(if (not (proc0_1 22))
			(if (proc0_1 28)
				(global2
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								0
								148
								0
								169
								319
								164
								319
								125
								308
								129
								279
								148
								257
								148
								205
								150
								166
								154
								131
								148
								61
								151
								49
								147
								50
								141
								80
								128
								90
								123
								98
								119
								111
								112
								142
								109
								149
								102
								180
								102
								195
								102
								257
								104
								258
								100
								209
								99
								198
								98
								188
								97
								173
								97
								135
								95
								129
								104
								111
								110
								98
								113
								83
								114
								84
								119
								82
								124
								71
								128
								56
								127
								35
								123
							yourself:
						)
				)
			else
				(controlPanel init:)
				(global2
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								0
								148
								0
								169
								319
								164
								319
								125
								308
								129
								279
								148
								257
								148
								205
								150
								166
								154
								131
								148
								61
								151
								49
								147
								50
								141
								80
								128
								90
								123
								98
								119
								111
								112
								142
								109
								149
								102
								180
								102
								195
								102
								257
								104
								258
								100
								209
								99
								198
								98
								188
								97
								173
								97
								135
								95
								129
								104
								111
								110
								98
								113
								83
								114
								84
								119
								82
								124
								71
								128
								56
								127
							yourself:
						)
				)
			)
		else
			(gSq5Music2 number: 600 setLoop: -1 play:)
			(gSq5Music2
				setVol: (proc999_2 127 (proc999_3 30 (- (gEgo y?) 32)))
			)
			(controlPanel init:)
			(gOldWH addToFront: self)
			(gOldWH addToFront: exit740)
			(gOldWH addToFront: controlPanel)
			(if (and (proc0_1 26) (not (proc0_1 117)))
				(gOldWH addToFront: myCliffy)
			)
		)
		(cond 
			((proc0_1 22)
				(if (and (proc0_1 26) (not (proc0_1 117)))
					(myCliffy init:)
					(if (not (proc0_1 79)) (wd40 init:))
				)
			)
			((proc0_1 23) (cliffy init:))
		)
		(switch gGModNum
			(240
				(global2 setScript: sFromShipMore)
			)
			(760
				(if (proc0_1 22)
					(proc31_1 230 150)
					(gSQ5 handsOn:)
				else
					(global2 setScript: sHuman760)
				)
			)
			(740
				(if (proc0_1 22)
					(global2 setScript: sFly740)
				else
					(global2 setScript: sHuman740)
				)
			)
			(770
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(proc31_1 67 95)
			)
			(790
				(global2 setScript: sHuman790)
			)
			(else 
				(proc0_2 22)
				(proc0_2 23)
				(proc0_2 24)
				(proc0_2 79)
				(proc0_2 82)
				(proc0_2 25)
				(proc0_2 26)
				(proc0_2 27)
				(global2 setScript: sHuman760)
			)
		)
	)
	
	(method (doit)
		(Palette palANIMATE 225 233 -1)
		(Palette palANIMATE 234 240 -1)
		(if (proc0_1 22)
			(gEgo setLoop: (/ (+ (gEgo heading?) 90) 180))
			(gSq5Music2
				setVol: (proc999_2 127 (proc999_3 30 (- (gEgo y?) 32)))
			)
		)
		(if (and (not script) (not (proc0_1 22)))
			(cond 
				((& (= local0 (gEgo onControl: 1)) $0002) (global2 setScript: (ScriptID 31 3) 0 0))
				((& local0 $1000) (global2 setScript: (ScriptID 31 3) 0 1))
				((& local0 $2000) (global2 setScript: (ScriptID 31 3) 0 2))
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(gOldWH delete: controlPanel)
		(gOldWH delete: self)
		(gOldWH delete: exit740)
		(gOldWH delete: myCliffy)
		(rogTalker dispose:)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(if (proc0_1 22)
			(switch theVerb
				(3
					(proc31_2 gPEventY)
					(if (> 300 gPEventX)
						(gEgo setMotion: VelocityMover gPEventX gPEventY 0 0)
					else
						(global2 setScript: sExitRight)
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sFlyLeave740 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 234 84 self)
			)
			(1
				(gSQ5 handsOn:)
				(global2 newRoom: 740)
			)
		)
	)
)

(instance sGetSlapped of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: VelocityMover 178 60 self 1)
			)
			(1
				(gSq5Music2 stop:)
				(= seconds 2)
			)
			(2
				(myCliffy setCycle: End self)
			)
			(3
				(gSq5Music2 number: 620 setLoop: -1 play:)
				(= seconds 2)
			)
			(4 (proc0_9 41))
		)
	)
)

(instance sUseComm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 setLoop: 1 play:)
			)
			(1
				(gTestMessager say: 4 32 4 0 self 701)
			)
			(2 (gEgo setCycle: Beg self))
			(3
				(proc0_6 0)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToCliffy of Script
	(properties)
	
	(method (dispose)
		(gEgo setMotion: VelocityMover 178 60 0 0)
		(gSq5Music2 play:)
		(gSQ5 handsOn:)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc31_2 60)
				(gEgo setMotion: VelocityMover 178 60 self 1)
			)
			(1
				(gSq5Music2 pause: 1)
				(if (proc0_1 79)
					(gTestMessager say: 24 0 0 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (proc0_1 79) (self dispose:) else (= cycles 1))
			)
			(3
				(proc0_10 235 5)
				(proc0_2 79)
				(= seconds 2)
			)
			(4
				(gEgo stopUpd:)
				(= seconds 1)
			)
			(5
				(cliffOverlay init:)
				(flyOL init: setCycle: Fwd)
				(= seconds 1)
			)
			(6
				(gTestMessager say: 17 0 0 0 self)
			)
			(7
				(cliffOverlay dispose:)
				(flyOL dispose:)
				(gEgo startUpd:)
				(= seconds 2)
			)
			(8
				(gTestMessager say: 23 0 0 0 self)
			)
			(9
				(theMusic3 init: number: 156 flags: 1 setLoop: -1 play:)
				(wd40
					view: 6000
					setLoop: 0
					cel: 0
					x: 207
					y: 103
					setPri: 15
					setStep: 8 2
					setCycle: End self
				)
			)
			(10
				(wd40 setMotion: MoveTo 360 103 self)
				(theMusic3 fade:)
			)
			(11
				(wd40 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFly740 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc31_1 250 60)
				(= cycles 1)
			)
			(1 (self dispose:))
		)
	)
)

(instance sFlyToLock of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc31_2 95)
				(proc0_10 230 20)
				(gEgo setMotion: VelocityMover 67 95 self 1)
				(gSq5Music2 stop:)
			)
			(1
				(gSQ5 handsOn:)
				(global2 newRoom: 770)
			)
		)
	)
)

(instance sHuman760 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_6 0)
				(gEgo
					init:
					posn: 305 144
					signal: 16384
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 277 149 self
				)
				(if (not (gEgo has: 10)) (= next sGiveCommBack))
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHuman740 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_6 0)
				(gEgo
					init:
					setScale: Scaler 124 55 167 80
					posn: 261 101
					setMotion: MoveTo 180 101 self
				)
				(if (not (gEgo has: 10)) (= next sGiveCommBack))
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveCommBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(wd40
					init:
					view: 6000
					setLoop: 1
					cel: 0
					setStep: 8 2
					moveSpeed: 1
					x: 311
					y: 139
				)
				(theMusic3 init: number: 156 setLoop: -1 play:)
				(= cycles 2)
			)
			(1
				(wd40 setMotion: MoveTo 311 139 self)
			)
			(2
				(wd40 setMotion: MoveTo 282 137 self)
			)
			(3
				(wd40 setMotion: MoveTo 248 134 self)
			)
			(4
				(wd40 setMotion: MoveTo 215 130 self)
			)
			(5
				(wd40 setMotion: MoveTo 184 134 self)
			)
			(6
				(theMusic3 fade:)
				(wd40 setMotion: MoveTo 153 138 self)
			)
			(7
				(wd40 setMotion: MoveTo 123 134 self)
			)
			(8
				(wd40 setMotion: MoveTo 97 128 self)
			)
			(9
				(wd40 setMotion: MoveTo 80 136 self)
			)
			(10 (wd40 setCycle: End self))
			(11
				(if (or (!= (gEgo x?) 51) (!= (gEgo y?) 134))
					(gEgo setMotion: PolyPath 51 134 self)
				else
					(= cycles 3)
				)
			)
			(12
				(gEgo
					view: 6000
					setLoop: 4
					setCel: 0
					setCycle: 0
					x: 51
					y: 134
				)
				(wd40 setLoop: 2 setCycle: End self)
			)
			(13 (= seconds 2))
			(14
				(gTestMessager say: 13 0 0 0 self)
			)
			(15 (gEgo setCycle: End self))
			(16
				(wd40 setLoop: 3 setCel: 0)
				(= seconds 2)
			)
			(17
				(gTestMessager say: 13 0 3 0 self)
			)
			(18
				(wd40 view: 34 x: 66 y: 131 setCel: 15)
				(= seconds 3)
			)
			(19
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(wd40 setCycle: Beg self)
			)
			(20
				(wd40 dispose:)
				(= seconds 4)
			)
			(21
				(gEgo get: 10)
				(proc0_6 0)
				(sHuman790 cue:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHuman790 of Script
	(properties)
	
	(method (dispose)
		(proc0_6 0)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_6 0)
				(gEgo
					init:
					posn: 10 134
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 50 134 self
				)
				(if (proc0_1 23) (cliffy init:))
			)
			(1
				(if (proc0_1 23)
					(= seconds 2)
				else
					(gSQ5 handsOn:)
					(self dispose:)
				)
			)
			(2
				(if (not (gEgo has: 10))
					(self setScript: sGiveCommBack)
				else
					(= ticks 1)
				)
			)
			(3
				(= local3
					(if (not (proc0_1 102))
						6
					else
						(proc0_3 102)
						(cond 
							((gEgo has: 16) (gEgo put: 16) (if (proc0_1 82) 4 else 7))
							((proc0_1 82) 5)
							(else 8)
						)
					)
				)
				(gTestMessager say: 14 0 local3 0 self 730)
			)
			(4
				(cliffyTalker
					normal: 0
					keepWindow: 1
					curNoun: 2
					curVerb: 0
					curCase: 2
				)
				(= cycles 1)
			)
			(5
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 999 1)
				(gTestMessager say: 2 0 2 1 self)
			)
			(6
				(cliffyTalker normal: 1 keepWindow: 0)
				(= cycles 1)
			)
			(7
				(if (== (cliffyTalker whichSelect?) 1)
					(= next sBeamMeUp)
					(= cycles 1)
				else
					(gSq5IconBar select: (gSq5IconBar at: 0))
					(gSQ5 setCursor: 980 1)
					(self dispose:)
				)
			)
			(8 (self dispose:))
		)
	)
)

(instance sCommandCliffy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(cliffyTalker
					normal: 0
					keepWindow: 1
					curNoun: 1
					curVerb: 24
					curCase: 1
				)
				(= cycles 1)
			)
			(1
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 2))
				(gSQ5 setCursor: 982)
				(gTestMessager say: 1 24 1 0 self)
			)
			(2
				(cliffyTalker normal: 1 keepWindow: 0)
				(= cycles 1)
			)
			(3
				(if (== (cliffyTalker whichSelect?) 1)
					(= next sBeamMeUp)
				else
					(gSq5IconBar select: (gSq5IconBar at: 0))
					(gSQ5 setCursor: 980 1)
				)
				(= cycles 1)
			)
			(4 (self dispose:))
		)
	)
)

(instance sFly790 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc31_1 70 0)
				(= cycles 1)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCardNLock of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 84 125 self)
			)
			(1 (gEgo setHeading: 290 self))
			(2
				(gEgo view: 611 loop: 5 cel: 0 setCycle: End self)
				(gSQ5 handsOn:)
				(gSQ5 setCursor: 999 1)
			)
			(3
				(proc0_6 0)
				(if (!= global129 341)
					(if (< global165 5)
						(if global129
							(cond 
								((& global129 $feaa)
									(Print addText: 5 0 0 0 addButton: 0 8 0 0 0 120 44 init:)
									(= global129 0)
									(++ global165)
								)
								(
									(Print
										addText: 16 35 0 1
										addButton: 1 6 0 0 0 15 44
										addButton: 0 7 0 0 0 120 44
										init:
									)
									(= global129 0)
									(++ global165)
								)
							)
						else
							(Print addText: 16 43 0 1 init:)
							(++ global165)
						)
					else
						(proc0_9 42)
					)
					(gSQ5 handsOn:)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(4
				((global2 obstacles?) dispose:)
				(global2
					addObstacle:
						((Polygon new:)
							type: 3
							init:
								0
								148
								0
								169
								319
								164
								319
								125
								308
								129
								279
								148
								257
								148
								205
								150
								166
								154
								131
								148
								61
								151
								49
								147
								50
								141
								80
								128
								90
								123
								98
								119
								111
								112
								142
								109
								149
								102
								180
								102
								195
								102
								257
								104
								258
								100
								209
								99
								198
								98
								188
								97
								173
								97
								135
								95
								129
								104
								111
								110
								98
								113
								83
								114
								84
								119
								82
								124
								71
								128
								56
								127
								35
								123
							yourself:
						)
				)
				(proc0_2 28)
				(controlPanel dispose:)
				(bigDoor startUpd: setCycle: End)
				(gSq5Music2 number: 108 setLoop: 1 play: self)
			)
			(5
				(switch global165
					(0 (proc0_10 239 500))
					(1 (proc0_10 240 300))
					(2 (proc0_10 241 100))
					(3 (proc0_10 242 50))
					(else  (proc0_10 243 25))
				)
				(= cycles 1)
			)
			(6 (= seconds 2))
			(7
				(gTestMessager say: 9 1 0 0 self)
			)
			(8
				(gSQ5 handsOn:)
				(bigDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 400 100 self)
			)
			(1
				(gSQ5 handsOn:)
				(global2 newRoom: 760)
			)
		)
	)
)

(instance swOscilate of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 15)))
			(1 (client setCycle: End self))
			(2 (= seconds (Random 4 15)))
			(3 (client setCycle: Beg self))
			(4 (= cycles 1) (= state -1))
		)
	)
)

(instance plant of MyProp
	(properties
		x 271
		y 189
		noun 19
		view 610
		loop 1
		priority 14
		signal $0010
		cycleSpeed 50
	)
)

(instance bigDoor of MyProp
	(properties
		x 14
		y 102
		noun 12
		view 610
		signal $4000
	)
)

(instance controlPanel of MyFeature
	(properties
		x 271
		y 189
		noun 16
		onMeCheck $0400
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(proc31_2 gPEventY)
				(global2 setScript: sFlyToLock)
			)
			(35
				(global2 setScript: sCardNLock)
			)
			(1
				(if (proc0_1 22)
					(gTestMessager say: 16 1 10 0)
				else
					(gTestMessager say: 16 1 11 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myCliffy of MyActor
	(properties
		x 179
		y 104
		noun 17
		modNum 701
		view 626
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if
				(and (proc0_1 24) (not (proc0_1 23)) (proc0_1 22))
					(proc31_2 gPEventY)
					(global2 setScript: sTalkToCliffy)
				)
				(if (not (proc0_1 24))
					(proc31_2 gPEventY)
					(global2 setScript: sGetSlapped)
				)
			)
			(2 (myCliffy doVerb: 3 &rest))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wd40 of MyActor
	(properties
		x 202
		y 102
		noun 23
		view 13
		loop 2
		cel 4
		signal $4000
		moveSpeed 2
	)
	
	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_1 22)
					(gTestMessager say: 23 4 10 0 self)
				else
					(gTestMessager say: 23 4 11 0 self)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit740 of MyFeature
	(properties
		x 271
		y 79
		onMeCheck $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(proc31_2 gPEventY)
				(global2 setScript: sFlyLeave740)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogTalker of Narrator
	(properties)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 99
			tailY: 70
			xOffset: 10
			isBottom: 0
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance bigWF of MyFeature
	(properties
		x 133
		y 90
		noun 3
		onMeCheck $0008
	)
)

(instance bridge of MyFeature
	(properties
		x 302
		y 136
		noun 4
		onMeCheck $0002
	)
)

(instance domeBack of MyFeature
	(properties
		x 200
		y 11
		noun 11
		onMeCheck $0010
	)
)

(instance pondF of MyFeature
	(properties
		x 208
		y 124
		noun 20
		onMeCheck $0020
	)
)

(instance smallFalls of MyFeature
	(properties
		x 282
		y 79
		noun 22
		onMeCheck $0040
	)
)

(instance cliffOverlay of View
	(properties
		x 10
		y 25
		view 1003
		loop 7
		priority 15
		signal $0010
	)
)

(instance cliffyTalker of ChoiceTalker
	(properties
		x 10
		y 25
		view 1003
		talkWidth 150
		keepWindow 1
		textX 120
		textY 10
		normal 1
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gSq5Win_2)
		(super init: 0 cliffyEyes cliffyMouth &rest)
		(if (not (proc0_1 22))
			(cliffyEyes setLoop: (Random 2 3))
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance cliffyEyes of Prop
	(properties
		nsTop 14
		nsLeft 58
		view 1003
		loop 5
	)
)

(instance cliffyMouth of Prop
	(properties
		nsTop 32
		nsLeft 52
		view 1003
		loop 1
	)
)

(instance flyOL of MyActor
	(properties
		x 87
		y 254
		z 200
		view 1003
		loop 6
		priority 15
		signal $0010
		cycleSpeed 15
	)
)

(instance sBeamMeUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 15 0 0 0 self)
				(gSQ5 handsOff:)
			)
			(1
				(cliffy view: 604 loop: 2 cel: 0)
				(gEgo setHeading: 180)
				(= seconds 1)
			)
			(2
				(cliffy setCel: 1)
				(= seconds 3)
			)
			(3
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo view: 6 cel: 15 setCycle: Beg self)
				(cliffy view: 33 cel: 15 setCycle: Beg self)
			)
			(4 0)
			(5
				(cliffy dispose:)
				(gEgo dispose:)
				(= seconds 2)
			)
			(6 (global2 newRoom: 240))
		)
	)
)

(instance cliffy of MyActor
	(properties
		x 75
		y 145
		noun 17
		view 20
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setHeading: 300 setScale: Scaler 124 55 167 80)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond 
					((proc0_1 22) (gTestMessager say: 17 2 10 1))
					((not (gEgo has: 10)) (gTestMessager say: 1 2 0 0 0 701))
					(else (global2 setScript: sCommandCliffy))
				)
			)
			(24
				(if (not (gEgo has: 10))
					(gTestMessager say: 1 24 2 0 0 701)
				else
					(global2 setScript: sCommandCliffy)
				)
			)
			(35
				(= local3 (if global129 15 else 14))
				(gTestMessager say: 17 35 local3 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFromShipMore of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(theMusic3 number: 260 setLoop: 1 play:)
				(cliffy view: 33 init: cel: 0 setCycle: End)
				(proc0_6 6)
				(gEgo
					init:
					posn: 50 134
					loop: 0
					cel: 0
					setScale: Scaler 124 55 167 80
					setCycle: End self
				)
			)
			(1
				(proc0_6 0)
				(gEgo setScale: Scaler 124 55 167 80 setHeading: 180)
				(cliffy view: 604 loop: 2 cel: 0)
				(= seconds 2)
			)
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)
