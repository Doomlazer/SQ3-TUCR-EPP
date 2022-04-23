;;; Sierra Script 1.0 - (do not remove this comment)
(script# 24)
(include sci.sh)
(use Main)
(use Print)
(use Slider)
(use BorderWindow)
(use IconI)
(use GameControls)
(use Obj)

(public
	gameControlCode 0
	gcWin 1
)

(class SQ5ControlItem of ControlIcon
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state $0000
		cursor -1
		type $4000
		message -1
		modifiers $0000
		signal $0001
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		theObj 0
		selector 0
	)
	
	(method (select)
		(super select: &rest)
		(self doit:)
	)
)

(instance gameControls of GameControls
	(properties)
	
	(method (dispatchEvent pEvent &tmp gSq5WinEraseOnly temp1 temp2 [temp3 50] pEventType pEventMessage)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(return
			(cond 
				((& pEventType evHELP)
					(if
						(and
							(= temp1 (self firstTrue: #onMe pEvent))
							(temp1 helpVerb?)
						)
						(= temp2 (GetPort))
						(if (gSq5Win respondsTo: #eraseOnly)
							(= gSq5WinEraseOnly (gSq5Win eraseOnly?))
							(gSq5Win eraseOnly: 1)
							(Print
								font: gFont
								width: 250
								addText: (temp1 noun?) (temp1 helpVerb?) 0 1 0 0 (temp1 modNum?)
								init:
							)
							(gSq5Win eraseOnly: gSq5WinEraseOnly)
						else
							(Print
								font: gFont
								width: 250
								addText: (temp1 noun?) (temp1 helpVerb?) 0 1 0 0 (temp1 modNum?)
								init:
							)
						)
						(SetPort temp2)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal?) $ffef))
					)
					(gSQ5 setCursor: 999)
					(return 0)
				)
				((& pEventType evJOYSTICK)
					(switch pEventMessage
						(JOY_DOWN
							(cond 
								(
									(and
										(IsObject highlightedIcon)
										(highlightedIcon respondsTo: #retreat)
									)
									(highlightedIcon retreat:)
									(return 0)
								)
								(
									(or
										(not (IsObject highlightedIcon))
										(& (highlightedIcon signal?) $0100)
									)
									(self advance:)
									(return 0)
								)
							)
						)
						(JOY_UP
							(cond 
								(
									(and
										(IsObject highlightedIcon)
										(highlightedIcon respondsTo: #advance)
									)
									(highlightedIcon advance:)
									(return 0)
								)
								(
									(or
										(not (IsObject highlightedIcon))
										(& (highlightedIcon signal?) $0100)
									)
									(self retreat:)
									(return 0)
								)
							)
						)
						(else 
							(super dispatchEvent: pEvent)
						)
					)
				)
				(else (super dispatchEvent: pEvent))
			)
		)
	)
)

(instance gameControlCode of Code
	(properties)
	
	(method (doit)
		(= gGameControls gameControls)
		(gGameControls
			add:
				detailSlider
				(volumeSlider theObj: gSQ5 selector: 389 yourself:)
				(speedSlider theObj: gEgo selector: 324 yourself:)
				(iconSave theObj: gSQ5 selector: 75 yourself:)
				(iconRestore theObj: gSQ5 selector: 76 yourself:)
				(iconRestart theObj: gSQ5 selector: 101 yourself:)
				(iconQuit theObj: gSQ5 selector: 100 yourself:)
				iconOk
				(iconAbout theObj: gSQ5 selector: 668 yourself:)
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 4
			eachElementDo: #modNum 0
			eachElementDo: #helpVerb 5
			helpIconItem: iconHelp
			window: gcWin
			curIcon: iconSave
			state: 2048
			show:
		)
	)
)

(instance gcWin of BorderWindow
	(properties)
	
	(method (open &tmp temp0 [temp1 25] [temp26 25] temp51)
		(= temp51 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			left: (/ (- 320 (+ 151 (CelWide 995 0 1))) 2)
			bottom:
				(+
					(CelHigh 995 1 1)
					6
					(/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
				)
			right:
				(+
					151
					(CelWide 995 0 1)
					(/ (- 320 (+ 151 (CelWide 995 0 1))) 2)
				)
			priority: temp51
		)
		(super open:)
		(DrawCel
			995
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 995 0 1)) (+ 4 (CelWide 995 1 1)))
						(CelWide 995 0 5)
					)
					2
				)
				4
				(CelWide 995 1 1)
			)
			3
			temp51
		)
		(DrawCel 995 1 1 4 3 temp51)
		(DrawCel 995 1 0 94 38 temp51)
		(DrawCel 995 1 0 135 38 temp51)
		(DrawCel
			995
			0
			4
			63
			(proc0_12
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			0
			3
			101
			(proc0_12
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			0
			2
			(proc0_12 140 146 146 146 146)
			(proc0_12
				(- (- 37 (+ (CelHigh 995 0 4) 3)) 9)
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
				(- 37 (+ (CelHigh 995 0 4) 3))
			)
			temp51
		)
		(DrawCel
			995
			9
			0
			(+ 5 (CelWide 995 1 1))
			(+ 38 (CelHigh 995 0 1))
			temp51
		)
		(Graph grUPDATE_BOX 12 1 15 (+ 151 (CelWide 995 0 1)) 1)
		(Message msgGET 0 18 0 1 1 @temp1)
		(Format @temp26 {%d %s %d} global15 @temp1 global16)
		(Display
			@temp26
			dsFONT
			gFont
			dsCOORD
			(+ 5 (CelWide 995 1 1) 6)
			(+ 38 (CelHigh 995 0 1) 15)
		)
		(SetPort 0)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 139
		nsTop 73
		signal $0080
		noun 5
		helpVerb 5
		sliderView 995
		bottomValue 1
		topValue 3
	)
	
	(method (doit param1)
		(if argc (gSQ5 detailLevel: param1))
		(gSQ5 detailLevel:)
	)
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 179
		nsTop 73
		signal $0080
		noun 24
		helpVerb 5
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 219
		nsTop 73
		signal $0080
		noun 25
		helpVerb 5
		sliderView 995
		bottomValue 15
	)
	
	(method (doit param1)
		(if argc (gEgo setSpeed: param1))
		(return gGEgoMoveSpeed)
	)
	
	(method (show)
		(if (not (gUser controls?))
			(= signal 132)
		else
			(= signal 128)
		)
		(super show: &rest)
	)
	
	(method (mask)
	)
	
	(method (move)
		(if (gUser controls?) (super move: &rest))
	)
)

(instance iconSave of SQ5ControlItem
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 80
		nsTop 42
		message 8
		signal $01c3
		noun 23
		helpVerb 5
	)
)

(instance iconRestore of SQ5ControlItem
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 80
		nsTop 62
		message 8
		signal $01c3
		noun 21
		helpVerb 5
	)
)

(instance iconRestart of SQ5ControlItem
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 80
		nsTop 82
		message 8
		signal $01c3
		noun 20
		helpVerb 5
	)
)

(instance iconQuit of SQ5ControlItem
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 80
		nsTop 102
		message 8
		signal $01c3
		noun 19
		helpVerb 5
	)
)

(instance iconAbout of SQ5ControlItem
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 80
		nsTop 142
		message 8
		signal $01c3
		noun 1
		helpVerb 5
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 106
		nsTop 142
		cursor 989
		message 5
		signal $0183
		noun 7
		helpVerb 5
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 80
		nsTop 122
		cursor 989
		message 8
		signal $01c3
		noun 17
		helpVerb 5
	)
)
