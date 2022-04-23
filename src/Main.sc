;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use n012)
(use Smopper)
(use SQEgo)
(use ScrollableInventory)
(use ScrollInsetWindow)
(use DColorButton)
(use SpeakWindow)
(use Print)
(use DIcon)
(use Messager)
(use Blink)
(use PseudoMouse)
(use Scaler)
(use BorderWindow)
(use IconI)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use Game)
(use User)
(use Obj)
(use ClickMenu)

(public
	SQ5 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
)

(local
	gEgo
	gSQ5
	global2
	global3
	global4
	gOldCast
	gRegions
	gTimers
	gSounds
	gSq5Inv
	gOldATPs
	gModNum
	gGModNum
	gNewRoomNumber
	global14
	global15
	global16
	global17
	gNewSet
	gCursorNumber
	global20 =  999
	global21 =  997
	gFont =  1
	global23 =  4
	gPEvent
	gDialog
	global26 =  1
	global27
	global28
	global29
	global30
	gPicAngle
	gOldFeatures
	global33
	global34
	global35
	gPicNumber =  -1
	global37
	gSq5Win
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50
	global51
	global52
	global53
	global54
	global55
	global56
	global57
	global58
	global59
	global60
	global61
	global62
	gGameControls
	gLb2FtrInit
	gLb2DoVerbCode
	gLb2ApproachCode
	global67 =  1
	global68
	gSq5IconBar
	gPEventX
	gPEventY
	gOldKH
	gOldMH
	gOldDH
	global75
	global76
	gPseudoMouse
	gTheDoits
	gEatTheMice =  60
	gUser
	global81
	gNewSync
	global83
	gNewEventHandler
	gFont_2
	global86
	global87
	gLastTicks
	gSQ5Narrator
	global90 =  1
	gTestMessager
	global92
	gOldWH
	global94 =  2
	global95
	global96
	global97
	global98
	global99
	global100
	global101 =  1234
	global102
	global103
	global104 =  100
	global105
	gStopGroop
	global107
	gGSq5IconBarCurIcon
	gGUserCanControl
	gGUserCanInput
	global111
	global112
	gEurekaCurLocation
	gState
	global115
	gNewSpeakWindow
	gSq5Win_2
	global118
	global119
	gSq5Music1
	gSq5Music2
	global122
	gGEgoMoveSpeed
	global124
	global125
	global126
	global127
	global128
	global129
	global130
	global131
	global132
	global133
	global134
	global135
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	global154
	global155
	global156
	global157
	global158
	global159
	gLowlightColor
	global161 =  1
	gRegister
	global163
	global164
	global165
	global166
	global167
	global168
	global169
	global170
	global171
	global172
	global173
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	global184
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
	global200
)
(procedure (proc0_1 param1)
	(return
		(&
			[global183 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
)

(procedure (proc0_2 param1 &tmp temp0)
	(= temp0 (proc0_1 param1))
	(= [global183 (/ param1 16)]
		(|
			[global183 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
	(return temp0)
)

(procedure (proc0_3 param1 &tmp temp0)
	(= temp0 (proc0_1 param1))
	(= [global183 (/ param1 16)]
		(&
			[global183 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
	(return temp0)
)

(procedure (proc0_4 &tmp temp0)
	(gUser
		canControl: gGUserCanControl
		canInput: gGUserCanInput
	)
	(= temp0 0)
	(while (< temp0 8)
		(if (& global111 (>> $8000 temp0))
			(gSq5IconBar disable: temp0)
		)
		(++ temp0)
	)
)

(procedure (proc0_5 param1 param2)
	(return (if (& (param1 onControl: 1) param2) (return 1) else 0))
)

(procedure (proc0_6 param1 param2)
	(if (and (> argc 0) (!= param1 -1))
		(gEgo view: param1)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	else
		(gEgo view: global161)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	)
	(if (gEgo looper?) ((gEgo looper?) dispose:))
	(gEgo
		setStep: 5 2
		illegalBits: 0
		ignoreActors: 0
		setSpeed: gGEgoMoveSpeed
		signal: (| (gEgo signal?) $1000)
		heading:
			(switch (gEgo loop?)
				(0 90)
				(1 270)
				(2 180)
				(3 0)
				(4 135)
				(5 225)
				(6 45)
				(7 315)
			)
	)
	(gEgo
		setLoop: -1
		setLoop: stopGroop
		setCycle: egoStopWalk -1 2 0
		setPri: -1
		setMotion: 0
		state: (| (gEgo state?) $0002)
	)
)

(procedure (proc0_8 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp3 0)
	(= temp4 0)
	(if (IsObject param2)
		(= temp1 (param2 x?))
		(= temp2 (param2 y?))
		(if (> argc 2)
			(if (IsObject param3)
				(= temp3 param3)
			else
				(= temp4 param3)
			)
			(if (== argc 4) (= temp3 param4))
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(if temp4 (proc0_8 param2 param1))
	(= temp0
		(GetAngle (param1 x?) (param1 y?) temp1 temp2)
	)
	(param1
		setHeading: temp0 (if (IsObject temp3) temp3 else 0)
	)
)

(procedure (proc0_9 param1)
	(if (not argc)
		(= global119 1)
	else
		(= global119 param1)
	)
	(global2 newRoom: 20)
)

(procedure (proc0_10 param1 param2)
	(if (not (proc0_1 param1))
		(= global15 (+ global15 param2))
		(sq5StatusLineCode doit:)
		(proc0_2 param1)
		(rm0Sound
			priority: 15
			number: 1000
			loop: 1
			flags: 1
			play:
		)
	)
)

(procedure (proc0_11 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort -1)
	(Graph grFILL_BOX 0 0 10 320 1 0 -1 -1)
	(Graph grUPDATE_BOX 0 0 10 320 1)
	(SetPort temp0)
)

(procedure (proc0_12 param1 param2 param3 param4 param5)
	(switch (gSQ5 printLang?)
		(49 param1)
		(34 param2)
		(33 param3)
		(39 param4)
		(else  param5)
	)
)

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

(instance sq5Music1 of Sound
	(properties
		flags $0001
	)
)

(instance sq5Music2 of Sound
	(properties
		flags $0001
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance egoStopWalk of FiddleStopWalk
	(properties)
)

(instance ego of SQEgo
	(properties)
)

(instance sq5StatusLineCode of Code
	(properties)
	
	(method (doit &tmp [temp0 50] [temp50 50] temp100)
		(= temp100 (GetPort))
		(SetPort -1)
		(Graph grFILL_BOX 0 0 10 320 1 5 -1 -1)
		(Graph grUPDATE_BOX 0 0 10 320 1)
		(Message msgGET 0 29 0 0 1 @temp0)
		(Format @temp50 {%s %d} @temp0 global15)
		(Display @temp50 dsCOORD 4 1 dsFONT gFont dsCOLOR 6)
		(Display @temp50 dsCOORD 6 3 dsFONT gFont dsCOLOR 4)
		(Display @temp50 dsCOORD 5 2 dsFONT gFont dsCOLOR 0)
		(Graph grDRAW_LINE 0 0 0 319 7 -1 -1)
		(Graph grDRAW_LINE 0 0 9 0 6 -1 -1)
		(Graph grDRAW_LINE 9 0 9 319 4 -1 -1)
		(Graph grDRAW_LINE 0 319 9 319 3 -1 -1)
		(Graph grUPDATE_BOX 0 0 10 319 1)
		(SetPort temp100)
	)
)

(instance sq5IconBar of IconBar
	(properties)
	
	(method (show)
		(if (IsObject curInvIcon) (curInvIcon loop: 2))
		(super show:)
		(if (IsObject curInvIcon) (curInvIcon loop: 1))
	)
	
	(method (hide)
		(super hide: &rest)
		(gSQ5 setCursor: gCursorNumber 1)
	)
	
	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 gSq5WinEraseOnly)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= gSq5WinEraseOnly (gSq5Win eraseOnly?))
		(gSq5Win eraseOnly: 1)
		(while
		(not ((= temp0 ((gUser curEvent?) new:)) type?))
			(if (not (self isMemberOf: IconBar)) (temp0 localize:))
			(cond 
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb?))
						(= temp1 temp2)
						(if gDialog (gDialog dispose:))
						(Print
							font: gFont
							width: 250
							addText: (temp2 noun?) (temp2 helpVerb?) 0 1 0 0 (temp2 modNum?)
							modeless: 1
							init:
						)
						(Animate (gOldCast elements?) 0)
						(SetPort temp3)
					)
				)
				(gDialog (gDialog dispose:) (Animate (gOldCast elements?) 0))
				(else (= temp1 0))
			)
			(temp0 dispose:)
		)
		(gSq5Win eraseOnly: gSq5WinEraseOnly)
		(gSQ5 setCursor: 999 1)
		(if gDialog
			(gDialog dispose:)
			(Animate (gOldCast elements?) 0)
		)
		(SetPort temp3)
		(if (not (helpIconItem onMe: temp0))
			(self dispatchEvent: temp0)
		)
	)
)

(class SQ5 of Game
	(properties
		script 0
		printLang 1
		_detailLevel 3
		panelObj 0
		panelSelector 0
		handsOffCode 0
		handsOnCode 0
	)
	
	(method (init &tmp [temp0 7] temp7)
		Print
		DButton
		DColorButton
		Smopper
		SQEgo
		StopWalk
		BorderWindow
		SpeakWindow
		Polygon
		PolyPath
		Timer
		IconBar
		ScrollInsetWindow
		ScrollableInventory
		(ScriptID 982)
		RTRandCycle
		Scaler
		Narrator
		((ScriptID 15 0) init:)
		(super init:)
		(= gEgo ego)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(= global90 1)
		(= global34 1)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global16 5000)
		(= gFont 1605)
		(= gGEgoMoveSpeed 6)
		(= gEatTheMice 30)
		(= global94 2)
		(= global102 (Graph grGET_COLOURS))
		(= gStopGroop stopGroop)
		(= gPseudoMouse PseudoMouse)
		(= global105 1)
		(gEgo setLoop: gStopGroop)
		(if (== global102 256) (proc0_2 0))
		(TextFonts 1605 999 1005 1007 1008 2106 1307 2306 5220)
		(TextColors 0 15 26 31 34 52 63)
		(= global27 {x.yyy.zzz})
		(= temp7 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING global27 11 temp7)
		(FileIO fiCLOSE temp7)
		(proc12_0)
		(DisposeScript 12)
		(= gSQ5Narrator sQ5Narrator)
		(= gSq5Win sq5Win)
		(= gSq5Win_2 sq5Win)
		(= gTestMessager testMessager)
		(= gNewSpeakWindow (SpeakWindow new:))
		(gSq5Win color: 0 back: global159)
		(gSQ5 setCursor: gCursorNumber 1 304 172 detailLevel: 3)
		((= gSq5Music1 sq5Music1)
			number: 1
			owner: self
			flags: 1
			init:
		)
		((= gSq5Music2 sq5Music2)
			number: 1
			owner: self
			flags: 1
			init:
		)
		(= gSq5IconBar sq5IconBar)
		(gSq5IconBar
			add: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 5
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			walkIconItem: icon0
			disable: 5
			state: 3072
			disable:
		)
		(= global20 999)
		(= global21 996)
		(= gLb2DoVerbCode lb2DoVerbCode)
		(= gLb2FtrInit lb2FtrInit)
		(= gLb2ApproachCode lb2ApproachCode)
		(self newRoom: 100)
	)
	
	(method (doit)
		(if (GameIsRestarting)
			(if (proc999_5 gModNum 100 104 110 106 107)
				(proc0_11)
			else
				(sq5StatusLineCode doit:)
			)
			(if (== (= global102 (Graph grGET_COLOURS)) 256)
				(proc0_2 0)
			)
		)
		(super doit: &rest)
	)
	
	(method (play)
		(= gSQ5 self)
		(= global29 (GetSaveDir))
		(if (not (GameIsRestarting)) (GetCWD global29))
		(self setCursor: global21 1 init:)
		(self setCursor: 996 1)
		(while (not global4)
			(self doit:)
		)
	)
	
	(method (startRoom param1 &tmp [temp0 4])
		(if (proc999_5 param1 100 104 110 106 107)
			(proc0_11)
		else
			(sq5StatusLineCode doit:)
		)
		(if gPseudoMouse (gPseudoMouse stop:))
		((ScriptID 11) doit: param1)
		(cond 
			(
				(proc999_5
					param1
					106
					107
					200
					201
					202
					203
					204
					205
					206
					212
					213
					215
					222
					225
					226
					228
					230
					240
					250
					280
					290
					295
				)
				(ScriptID 210)
			)
			(
				(proc999_5
					param1
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
				(ScriptID 109)
			)
			(
			(proc999_5 param1 300 305 310 315 320 325 330 335) (ScriptID 350))
			((proc999_5 param1 500 510 520 530) (ScriptID 505))
			((proc999_5 param1 730 740 750 760 770 790) (ScriptID 31))
		)
		(super startRoom: param1)
	)
	
	(method (restart &tmp temp0 temp1)
		(= temp1 ((gSq5IconBar curIcon?) cursor?))
		(gSQ5 setCursor: 999)
		(if
			(= temp0
				(Print
					font: gFont
					width: 75
					window: gSq5Win
					mode: 1
					addText: 20 1 0 1 0 0 0
					addColorButton: 1 20 1 0 2 0 40 0
					addColorButton: 0 20 1 0 3 0 50 0
					init:
				)
			)
			(super restart: &rest)
		else
			(gSQ5 setCursor: temp1)
		)
	)
	
	(method (restore &tmp [temp0 2])
		(super restore: &rest)
		(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
	)
	
	(method (save)
		(super save: &rest)
		(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
	)
	
	(method (handleEvent pEvent &tmp theGCursorNumber)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
;;;				(evMOUSEBUTTON
;;;					(if global105
;;;						((ScriptID 10) handleEvent: pEvent)
;;;						((ScriptID 10) dispose:)
;;;					else
;;;						(pEvent claimed: 0)
;;;					)
;;;				)
				(evKEYBOARD
					(switch (pEvent message?)
						(KEY_TAB
							(if (not (& ((gSq5IconBar at: 6) signal?) $0004))
								(if gNewEventHandler (return gNewEventHandler))
								(= theGCursorNumber gCursorNumber)
								(gSq5Inv showSelf: gEgo)
								(gSQ5 setCursor: theGCursorNumber 1)
								(pEvent claimed: 1)
							)
						)
						(KEY_CONTROL
							(if (not (& ((gSq5IconBar at: 7) signal?) $0004))
								(gSQ5 quitGame:)
								(pEvent claimed: 1)
							)
						)
						(JOY_RIGHT
							(if (not (& ((gSq5IconBar at: 7) signal?) $0004))
								(= theGCursorNumber ((gSq5IconBar curIcon?) cursor?))
								((ScriptID 24 0) doit:)
								(gGameControls dispose:)
								(gSQ5 setCursor: theGCursorNumber 1)
							)
						)
						(KEY_F2
							(cond 
								((gSQ5 masterVolume:) (gSQ5 masterVolume: 0))
								((> global103 1) (gSQ5 masterVolume: 15))
								(else (gSQ5 masterVolume: 1))
							)
							(pEvent claimed: 1)
						)
						(KEY_F5
							(if (not (& ((gSq5IconBar at: 7) signal?) $0004))
								(if gNewEventHandler (return gNewEventHandler))
								(= theGCursorNumber gCursorNumber)
								(gSQ5 save:)
								(gSQ5 setCursor: theGCursorNumber 1)
								(pEvent claimed: 1)
							)
						)
						(KEY_F7
							(if (not (& ((gSq5IconBar at: 7) signal?) $0004))
								(if gNewEventHandler (return gNewEventHandler))
								(= theGCursorNumber gCursorNumber)
								(gSQ5 restore:)
								(gSQ5 setCursor: theGCursorNumber 1)
								(pEvent claimed: 1)
							)
						)
						(KEY_EXECUTE
							(if (gUser controls?)
								(= gGEgoMoveSpeed (gEgo moveSpeed?))
								(= gGEgoMoveSpeed (proc999_3 0 (-- gGEgoMoveSpeed)))
								(gEgo setSpeed: gGEgoMoveSpeed)
							)
						)
						(KEY_SUBTRACT
							(if (gUser controls?)
								(= gGEgoMoveSpeed (gEgo moveSpeed?))
								(++ gGEgoMoveSpeed)
								(gEgo setSpeed: gGEgoMoveSpeed)
							)
						)
						(61
							(if (gUser controls?) (gEgo setSpeed: 6))
						)
						(KEY_ALT_v
							(Show 1) ;clear if needed
							(Print
								addText: {Version number:} 0 0
								addText: global27 0 14
								init:
							)
						)
						;(else  (pEvent claimed: 0))
						;Debugger
						(else 
							(if global105
								((ScriptID 10) handleEvent: pEvent)
								((ScriptID 10) dispose:)
							else
								(pEvent claimed: 0)
							)
						)
					)
				)
			)
		)
	)
	
	(method (setCursor cursorNumber param2 param3 param4 &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(if argc
			(if (IsObject cursorNumber)
				((= gCursorNumber cursorNumber) init:)
			else
				(SetCursor (= gCursorNumber cursorNumber) 0 0)
			)
		)
		(if (and (> argc 1) (not param2)) (SetCursor 996 0 0))
		(if (> argc 2) (SetCursor param3 param4))
		(return theGCursorNumber)
	)
	
	(method (quitGame &tmp temp0 temp1)
		(= temp1 ((gSq5IconBar curIcon?) cursor?))
		(gSQ5 setCursor: 999)
		(if
			(= temp0
				(Print
					font: gFont
					width: 75
					mode: 1
					addText: 19 1 0 1 0 0 0
					addColorButton: 1 19 1 0 2 0 25 0
					addColorButton: 0 19 1 0 3 0 35 0
					init:
				)
			)
			(Print addText: 19 1 0 4 0 0 0 init:)
			(super quitGame: &rest)
		else
			(gSQ5 setCursor: temp1)
		)
	)
	
	(method (pragmaFail)
		(if (User canControl:)
			(switch ((gUser curEvent?) message?)
				(4
					(gTestMessager say: 0 4 0 (Random 1 2) 0 0)
				)
				(2
					(gTestMessager say: 0 2 0 (Random 1 2) 0 0)
				)
				(24
					(gTestMessager say: 0 24 0 0 0 0)
				)
				(else 
					(if
					(not (proc999_5 ((gUser curEvent?) message?) 24 1))
						(gTestMessager say: 0 7 0 (Random 2 3) 0 0)
					)
				)
			)
		)
	)
	
	(method (handsOff)
		(if (not gGSq5IconBarCurIcon)
			(= gGSq5IconBarCurIcon (gSq5IconBar curIcon?))
		)
		(= gGUserCanControl (gUser canControl:))
		(= gGUserCanInput (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(= global111 0)
		(gSq5IconBar eachElementDo: #perform checkIcon)
		(gSq5IconBar curIcon: (gSq5IconBar at: 7))
		(gSq5IconBar disable:)
		(gSq5IconBar disable: 0 1 2 3 4 5 6 7)
		(gSQ5 setCursor: 996)
	)
	
	(method (handsOn param1)
		(gSq5IconBar enable:)
		(gUser canControl: 1 canInput: 1)
		(if (proc0_1 22)
			(gSq5IconBar enable: 0 1 3 7)
		else
			(gSq5IconBar enable: 0 1 2 3 4 5 6 7)
		)
		(if (and argc param1) (proc0_4))
		(if (not (gSq5IconBar curInvIcon?))
			(gSq5IconBar disable: 5)
		)
		(if gGSq5IconBarCurIcon
			(gSq5IconBar curIcon: gGSq5IconBarCurIcon)
			(gSQ5 setCursor: (gGSq5IconBarCurIcon cursor?))
			(= gGSq5IconBarCurIcon 0)
			(if
				(and
					(== (gSq5IconBar curIcon?) (gSq5IconBar at: 5))
					(not (gSq5IconBar curInvIcon?))
				)
				(gSq5IconBar advanceCurIcon:)
			)
		)
		(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?) 1)
		(= gCursorNumber ((gSq5IconBar curIcon?) cursor?))
	)
	
	(method (showAbout)
		((ScriptID 13 0) doit:)
		(DisposeScript 13)
	)
	
	(method (showControls &tmp temp0)
		(= temp0 ((gSq5IconBar curIcon?) cursor?))
		((ScriptID 24 0) doit:)
		(gGameControls dispose:)
		(gSQ5 setCursor: temp0 1)
	)
)

(instance walkCursor of Cursor
	(properties
		view 980
	)
	
	(method (init)
		(cond 
			((proc0_1 22) (= loop 1))
			((and (== gModNum 119) (== (gEgo view?) 136)) (= loop 3))
			(else (= loop 0))
		)
		(super init: &rest)
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 980
		type $5000
		message 3
		signal $0041
		maskView 990
		maskLoop 13
		noun 28
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(= cursor walkCursor)
		(super init:)
	)
	
	(method (show)
		(cond 
			((proc0_1 22) (= loop 14))
			((and (== gModNum 119) (== (gEgo view?) 136)) (= loop 15))
			(else (= loop 0))
		)
		(super show: &rest)
	)
	
	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(gSq5IconBar hide:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon1 of IconI
	(properties
		view 990
		loop 1
		cel 0
		cursor 981
		message 1
		signal $0041
		maskView 990
		maskLoop 13
		noun 16
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 982
		message 4
		signal $0041
		maskView 990
		maskLoop 13
		noun 6
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 983
		message 2
		signal $0041
		maskView 990
		maskLoop 13
		maskCel 4
		noun 26
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 10
		cel 1
		cursor 984
		message 24
		signal $0041
		maskView 990
		maskLoop 13
		maskCel 4
		noun 2
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		message 0
		signal $0041
		maskView 990
		maskLoop 13
		maskCel 4
		noun 4
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
	
	(method (select param1 &tmp newEvent temp1 gSq5IconBarCurInvIcon temp3 temp4)
		(return
			(cond 
				((& signal $0004) 0)
				((and argc param1 (& signal notUpd))
					(if
					(= gSq5IconBarCurInvIcon (gSq5IconBar curInvIcon?))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(gSq5IconBarCurInvIcon view?)
											2
											(gSq5IconBarCurInvIcon cel?)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gSq5IconBar y?)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(gSq5IconBarCurInvIcon view?)
											2
											(gSq5IconBarCurInvIcon cel?)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if
					(= gSq5IconBarCurInvIcon (gSq5IconBar curInvIcon?))
						(DrawCel
							(gSq5IconBarCurInvIcon view?)
							2
							(gSq5IconBarCurInvIcon cel?)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= newEvent (Event new:)) type?) 2)
						(newEvent localize:)
						(cond 
							((self onMe: newEvent)
								(if (not temp1)
									(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
									(if
									(= gSq5IconBarCurInvIcon (gSq5IconBar curInvIcon?))
										(DrawCel
											(gSq5IconBarCurInvIcon view?)
											2
											(gSq5IconBarCurInvIcon cel?)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if
								(= gSq5IconBarCurInvIcon (gSq5IconBar curInvIcon?))
									(DrawCel
										(gSq5IconBarCurInvIcon view?)
										2
										(gSq5IconBarCurInvIcon cel?)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(newEvent dispose:)
					)
					(newEvent dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if
						(= gSq5IconBarCurInvIcon (gSq5IconBar curInvIcon?))
							(DrawCel
								(gSq5IconBarCurInvIcon view?)
								2
								(gSq5IconBarCurInvIcon cel?)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance icon7 of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		type $0000
		message 0
		signal $0043
		maskView 990
		maskLoop 13
		noun 15
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
	
	(method (select &tmp theGCursorNumber)
		(return
			(if (super select: &rest)
				(gSq5IconBar hide:)
				(= theGCursorNumber gCursorNumber)
				(gSq5Inv showSelf: gEgo)
				(gSQ5 setCursor: theGCursorNumber 1)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 7
		signal $0043
		maskView 990
		maskLoop 13
		noun 3
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
	
	(method (select)
		(return
			(if (super select: &rest)
				(gSq5IconBar hide:)
				(gSQ5 showControls:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 990
		loop 9
		cel 0
		cursor 989
		type $2000
		message 5
		signal $0003
		maskView 990
		maskLoop 13
		noun 7
		helpVerb 5
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(if gDialog (gDialog dispose:))
		(super init:)
	)
)

(instance checkIcon of Code
	(properties)
	
	(method (doit param1)
		(if
			(and
				(param1 isKindOf: IconI)
				(& (param1 signal?) $0004)
			)
			(= global111
				(| global111 (>> $8000 (gSq5IconBar indexOf: param1)))
			)
		)
	)
)

(instance lb2DoVerbCode of Code
	(properties)
	
	(method (doit param1 param2)
		(if (User canControl:)
			(if (== param2 gEgo)
				(if (Message msgSIZE 0 22 param1 0 1)
					(gTestMessager say: 22 param1 0 0 0 0)
				else
					(gTestMessager say: 22 0 0 (Random 1 2) 0 0)
				)
			else
				(switch param1
					(4
						(gTestMessager say: 0 4 0 (Random 1 2) 0 0)
					)
					(2
						(gTestMessager say: 0 2 0 (Random 1 2) 0 0)
					)
					(24
						(gTestMessager say: 0 24 0 1 0 0)
					)
					(else 
						(if (not (proc999_5 param1 24 1))
							(gTestMessager say: 0 7 0 (Random 2 3) 0 0)
						)
					)
				)
			)
		)
	)
)

(instance lb2FtrInit of Code
	(properties)
	
	(method (doit param1)
		(if (== (param1 sightAngle?) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions?) 26505) (param1 actions: 0))
		(if
			(and
				(not (param1 approachX?))
				(not (param1 approachY?))
			)
			(param1 approachX: (param1 x?) approachY: (param1 y?))
		)
	)
)

(instance lb2ApproachCode of Code
	(properties)
	
	(method (doit param1)
		(switch param1
			(1 1)
			(2 2)
			(3 4)
			(4 8)
			(31 16)
			(24 32)
			(29 64)
			(25 128)
			(else  -32768)
		)
	)
)

(instance sq5Win of BorderWindow
	(properties)
)

(instance sQ5Narrator of Narrator
	(properties)
	
	(method (init)
		(= font gFont)
		(self back: global159)
		(super init: &rest)
	)
)

(instance testMessager of Messager
	(properties)
	
	(method (findTalker param1 &tmp temp0)
		(= global122 param1)
		(if
			(= temp0
				(switch param1
					(99
						(if (== gModNum 666) (ScriptID 666 1) else gSQ5Narrator)
					)
					(47
						(if (proc999_5 gModNum 201 206)
							(if (== gModNum 201)
								(ScriptID 209 18)
							else
								(ScriptID gModNum 18)
							)
						else
							(ScriptID 1882 26)
						)
					)
					(26
						(if (proc999_5 gModNum 119 127 240 1041 660)
							(ScriptID gModNum 10)
						else
							(ScriptID 1882 26)
						)
					)
					(8 (ScriptID 109 7))
					(29 (ScriptID 125 1))
					(23
						(if (proc999_5 gModNum 530 730 666 240)
							(ScriptID gModNum 11)
						else
							(ScriptID 1884 23)
						)
					)
					(18 (ScriptID 127 3))
					(4 (ScriptID 850 1))
					(21
						(if (proc999_5 gModNum 201 520 1041)
							(ScriptID gModNum 12)
						else
							(ScriptID 1885 21)
						)
					)
					(27 (ScriptID 135 2))
					(36
						(if (== gModNum 801)
							(ScriptID 801 1)
						else
							(ScriptID 109 7)
						)
					)
					(37
						(if (== gModNum 801)
							(ScriptID 801 2)
						else
							(ScriptID 109 7)
						)
					)
					(22
						(if
						(proc999_5 gModNum 201 760 520 620 640 660 1040 1041)
							(if (!= (global2 curPic?) 110)
								(ScriptID gModNum 13)
							else
								(ScriptID 1886 22)
							)
						else
							(ScriptID 1886 22)
						)
					)
					(25
						(if (proc999_5 gModNum 104 119 127 201 206 520 850)
							(if (== gModNum 201)
								(ScriptID 209 14)
							else
								(ScriptID gModNum 14)
							)
						else
							(ScriptID 1883 25)
						)
					)
					(3 (ScriptID gModNum 14))
					(1
						(if (== gModNum 119)
							(ScriptID 119 2)
						else
							(ScriptID gModNum 14)
						)
					)
					(7 (ScriptID 1040 5))
					(19
						(if
							(proc999_5
								gModNum
								104
								119
								125
								135
								165
								201
								228
								230
								240
								520
								530
								730
								750
								760
								1041
								666
								850
								660
								440
								450
								620
								640
							)
							(if
								(and
									(proc999_5 gModNum 730 740 760 790)
									(not (proc0_1 22))
								)
								(ScriptID 1880 19)
							else
								(ScriptID gModNum 15)
							)
						else
							(switch gModNum
								(510 (ScriptID 510 1))
								(else  (ScriptID 1880 19))
							)
						)
					)
					(17 (ScriptID 119 1))
					(28 (ScriptID 135 1))
					(24
						(if (proc999_5 gModNum 201 999)
							(if (== gModNum 201)
								(if (== global170 2)
									(ScriptID 1887 24)
								else
									(ScriptID 209 16)
								)
							else
								(ScriptID gModNum 16)
							)
						else
							(ScriptID 1887 24)
						)
					)
					(38
						(if (proc999_5 gModNum 520)
							(ScriptID gModNum 17)
						else
							(ScriptID 1891 38)
						)
					)
					(46
						(if (proc999_5 gModNum 450 440)
							(ScriptID gModNum 19)
						else
							(ScriptID 1895 46)
						)
					)
					(5 (ScriptID 115 2))
					(6 (ScriptID 117 2))
					(42 (ScriptID 510 1))
					(43 (ScriptID 510 1))
					(45 (ScriptID 520 1))
					(49 (ScriptID 500 10))
					(9 (ScriptID 500 10))
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)
