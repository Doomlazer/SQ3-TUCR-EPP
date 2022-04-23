;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use Blink)
(use RandCycle)
(use Obj)


(class AnimDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gLastTicks (+ global86 (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem (theItem select: 0))
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem (theItem select: 1))
		(if (not theItem)
			(= eatTheMice gEatTheMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(cond 
				((IsObject gNewEventHandler) (gNewEventHandler eachElementDo: #doit))
				((IsObject gTheDoits) (gTheDoits eachElementDo: #doit))
			)
			(= gLastTicks (+ global86 (GetTime)))
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type?) 1) (temp0 type: 0))
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(self eachElementDo: #perform checkHiliteCode self temp0)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:) (break))
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)
)

(instance checkHiliteCode of Code
	(properties)
	
	(method (doit param1 param2 param3)
		(if
			(and
				(& (param1 state?) $0001)
				(param1 check: param3)
				(not (& (param1 state?) $0008))
			)
			((param2 theItem?) select: 0)
			(param2 theItem: param1)
			(param1 select: 1)
		)
	)
)

(class ChoiceNarrator of Narrator
	(properties
		x -1
		y -1
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
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
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
		caller 0
		disposeWhenDone 1
		ticks 0
		talkWidth 0
		keepWindow 0
		modeless 0
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		color 0
		back 5
		curVolume 0
		saveCursor 0
		whichSelect 0
		normal 0
		curNoun 0
		curVerb 0
		curCase 0
	)
	
	(method (display theText &tmp theTalkWidth newGSq5Win temp2 temp3 temp4 temp5 newPrint)
		(if normal
			(super display: theText &rest)
		else
			(if (> (+ x talkWidth) 318)
				(= theTalkWidth (- 318 x))
			else
				(= theTalkWidth talkWidth)
			)
			((= newGSq5Win (gSq5Win new:)) color: color back: back)
			(if
			(and (not (HaveMouse)) (!= gCursorNumber 996))
				(= saveCursor gCursorNumber)
				(gSQ5 setCursor: 996)
			else
				(= saveCursor 0)
			)
			(if showTitle (Print addTitle: name))
			((= newPrint (Print new:))
				dialog: (AnimDialog new:)
				window: newGSq5Win
				posn: x y
				font: font
				width: theTalkWidth
				addText: theText
				modeless: 0
			)
			(if (not normal)
				(= temp3
					(+
						(-
							((= temp2 (NodeValue ((newPrint dialog?) last:)))
								nsBottom?
							)
							(temp2 nsTop?)
						)
						4
						y
					)
				)
				(= temp4 2)
				(while
					(= temp5
						(Message msgSIZE modNum curNoun curVerb curCase temp4)
					)
					(newPrint
						addColorButton: (- temp4 1) curNoun curVerb curCase temp4 x temp3 modNum
					)
					(= temp2 (NodeValue ((newPrint dialog?) last:)))
					(= temp3
						(+ temp3 (- (temp2 nsBottom?) (temp2 nsTop?)) 4)
					)
					(++ temp4)
				)
				(= whichSelect (newPrint init:))
				(self dispose: 1)
			else
				(newPrint init:)
			)
		)
	)
)

(class ChoiceTalker of Talker
	(properties
		x -1
		y -1
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
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
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
		caller 0
		disposeWhenDone 1
		ticks 0
		talkWidth 318
		keepWindow 0
		modeless 0
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		color 0
		back 5
		curVolume 0
		saveCursor 0
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		useFrame 0
		blinkSpeed 100
		verb 0
		case 0
		whichSelect 0
		normal 0
		curNoun 0
		curVerb 0
		curCase 0
	)
	
	(method (show &tmp temp0 temp1)
		(if normal
			(super show: &rest)
		else
			(= temp1 (GetPort))
			(SetPort 0)
			(if (not underBits)
				(= underBits
					(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1)
				)
			)
			(= temp0 (PicNotValid))
			(PicNotValid 1)
			(if bust
				(DrawCel
					(bust view?)
					(bust loop?)
					(bust cel?)
					(+ (bust nsLeft?) nsLeft)
					(+ (bust nsTop?) nsTop)
					-1
				)
			)
			(if eyes
				(DrawCel
					(eyes view?)
					(eyes loop?)
					(eyes cel?)
					(+ (eyes nsLeft?) nsLeft)
					(+ (eyes nsTop?) nsTop)
					-1
				)
			)
			(if mouth
				(DrawCel
					(mouth view?)
					(mouth loop?)
					(mouth cel?)
					(+ (mouth nsLeft?) nsLeft)
					(+ (mouth nsTop?) nsTop)
					-1
				)
			)
			(DrawCel view loop cel nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(SetPort temp1)
			(PicNotValid temp0)
		)
	)
	
	(method (say param1 param2)
		(return
			(if normal
				(super say: param1 param2 &rest)
			else
				(if (and (> view 0) (not underBits)) (self init:))
				(if gSq5IconBar (gSq5IconBar disable:))
				(if (not initialized) (self init:))
				(= caller (if (and (> argc 1) param2) param2 else 0))
				(if (IsObject gNewEventHandler)
					(gNewEventHandler add: self)
				else
					((= gNewEventHandler (EventHandler new:))
						name: {fastCast}
						add: self
					)
				)
				(if (& global90 $0002) (self startAudio:))
				(if (& global90 $0001) (self startText: param1))
				(= ticks (+ ticks 60 gLastTicks))
				(return 1)
			)
		)
	)
	
	(method (startText param1 &tmp temp0)
		(return
			(if normal
				(super startText: param1 &rest)
			else
				(if (not viewInPrint) (self show:))
				(if (not (& global90 $0002))
					(= ticks
						(proc999_3 240 (* 8 (= temp0 (StrLen param1))))
					)
				)
				(if mouth (mouth setCycle: RandCycle (* 4 temp0) 0 1))
				(if (and eyes (not (eyes cycler?)))
					(eyes setCycle: Blink blinkSpeed)
				)
				(if gDialog (gDialog dispose:))
				(self display: param1)
				(return temp0)
			)
		)
	)
	
	(method (display theText &tmp temp0 theTalkWidth temp2 newGSq5Win temp4 temp5 temp6 temp7 newPrint)
		(if normal
			(super display: theText &rest)
		else
			((= newGSq5Win (gSq5Win new:)) color: color back: back)
			(if
			(and (not (HaveMouse)) (!= gCursorNumber 996))
				(= saveCursor gCursorNumber)
				(gSQ5 setCursor: 996)
			else
				(= saveCursor 0)
			)
			(= newPrint (Print new:))
			(if viewInPrint
				(= temp0 (if useFrame loop else (bust loop?)))
				(if showTitle (newPrint addTitle: name))
				(newPrint
					window: newGSq5Win
					dialog: (AnimDialog new:)
					posn: x y
					modeless: 0
					font: font
					addIcon: view temp0 cel 0 0
					addText: theText (+ x textX)
					width: theTalkWidth
				)
			else
				(if (not (+ textX textY))
					(= textX (+ (- nsRight nsLeft) 5))
				)
				(if
				(> (+ (= temp2 (+ nsLeft textX)) talkWidth) 318)
					(= theTalkWidth (- 318 temp2))
				else
					(= theTalkWidth talkWidth)
				)
				(if showTitle (newPrint addTitle: name))
				(newPrint
					window: newGSq5Win
					dialog: (AnimDialog new:)
					posn: (+ x textX) (+ y textY)
					modeless: 0
					font: font
					addText: theText 4
					width: theTalkWidth
				)
			)
			(if (not normal)
				(= temp5
					(+
						(-
							((= temp4 (NodeValue ((newPrint dialog?) last:)))
								nsBottom?
							)
							(temp4 nsTop?)
						)
						4
					)
				)
				(= temp6 2)
				(while
					(= temp7
						(Message msgSIZE modNum curNoun curVerb curCase temp6)
					)
					(newPrint
						addColorButton: (- temp6 1) curNoun curVerb curCase temp6 4 temp5 modNum
					)
					(= temp4 (NodeValue ((newPrint dialog?) last:)))
					(= temp5
						(+ temp5 (- (temp4 nsBottom?) (temp4 nsTop?)) 4)
					)
					(++ temp6)
				)
				(= whichSelect (newPrint init:))
				(self dispose: 1)
			else
				(newPrint width: theTalkWidth init:)
			)
		)
	)
	
	(method (cycle param1 &tmp temp0 [temp1 100] temp101)
		(cond 
			(normal (super cycle: param1 &rest))
			((and param1 (param1 cycler?))
				(= temp101 (GetPort))
				(SetPort 0)
				(= temp0 (param1 cel?))
				((param1 cycler?) doit:)
				(if (!= temp0 (param1 cel?))
					(DrawCel
						(param1 view?)
						(param1 loop?)
						(param1 cel?)
						(+ (param1 nsLeft?) nsLeft)
						(+ (param1 nsTop?) nsTop)
						-1
					)
					(param1
						nsRight:
							(+
								(param1 nsLeft?)
								(CelWide (param1 view?) (param1 loop?) (param1 cel?))
							)
					)
					(param1
						nsBottom:
							(+
								(param1 nsTop?)
								(CelHigh (param1 view?) (param1 loop?) (param1 cel?))
							)
					)
					(Graph
						grUPDATE_BOX
						(+ (param1 nsTop?) nsTop)
						(+ (param1 nsLeft?) nsLeft)
						(+ (param1 nsBottom?) nsTop)
						(+ (param1 nsRight?) nsLeft)
						1
					)
				)
				(SetPort temp101)
			)
		)
	)
)
