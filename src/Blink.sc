;;; Sierra Script 1.0 - (do not remove this comment)
(script# 928)
(include sci.sh)
(use Main)
(use Print)
(use Sync)
(use RandCycle)
(use Cycle)
(use View)
(use Obj)


(class Blink of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		waitCount 0
		lastCount 0
		waitMin 0
		waitMax 0
	)
	
	(method (init param1 param2)
		(if argc
			(= waitMin (/ param2 2))
			(= waitMax (+ param2 waitMin))
			(super init: param1)
		else
			(super init:)
		)
	)
	
	(method (doit &tmp blinkNextCel)
		(cond 
			(waitCount
				(if (> (- gLastTicks waitCount) 0)
					(= waitCount 0)
					(self init:)
				)
			)
			(
				(or
					(> (= blinkNextCel (self nextCel:)) (client lastCel:))
					(< blinkNextCel 0)
				)
				(= cycleDir (- cycleDir))
				(self cycleDone:)
			)
			(else (client cel: blinkNextCel))
		)
	)
	
	(method (cycleDone)
		(if (== cycleDir -1)
			(self init:)
		else
			(= waitCount (+ (Random waitMin waitMax) gLastTicks))
		)
	)
)

(class Narrator of Prop
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
		back 7
		curVolume 0
		saveCursor 0
	)
	
	(method (init)
		(if global83
			(self curVolume: (gSQ5 masterVolume:))
			(if (>= (gSQ5 masterVolume:) 4)
				(gSQ5 masterVolume: (- curVolume 4))
			)
			(if (not modeless)
				(= saveCursor (gSQ5 setCursor: global21 1))
			)
		)
		(= initialized 1)
	)
	
	(method (doit)
		(if
		(and (!= ticks -1) (> (- gLastTicks ticks) 0))
			(if
				(and
					(if global83 (== (DoAudio 6) -1) else 1)
					(or (not keepWindow) global83)
				)
				(self dispose: disposeWhenDone)
				(return 0)
			)
		)
		(return 1)
	)
	
	(method (dispose param1)
		(= ticks -1)
		(if (or (not argc) param1)
			(cond 
				(modeless
					(gOldKH delete: self)
					(gOldMH delete: self)
					(gTheDoits delete: self)
				)
				(
				(and gNewEventHandler (gNewEventHandler contains: self))
					(gNewEventHandler delete: self)
					(if (gNewEventHandler isEmpty:)
						(gNewEventHandler dispose:)
						(= gNewEventHandler 0)
					)
				)
			)
			(if global83 (DoAudio 3))
			(= modNum -1)
			(= initialized 0)
		)
		(if gDialog (gDialog dispose:))
		(if global83 (gSQ5 masterVolume: curVolume))
		(if (and saveCursor (not (HaveMouse)))
			(gSQ5 setCursor: saveCursor)
		)
		(if caller (caller cue: cueVal))
		(= cueVal 0)
		(DisposeClone self)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?))
				((== ticks -1) (return 0))
				(else
					(if (not cueVal)
						(switch (pEvent type?)
							(evJOYDOWN (= cueVal 0))
							(evMOUSEBUTTON
								(= cueVal (& (pEvent modifiers?) emSHIFT))
							)
							(evKEYBOARD
								(= cueVal (== (pEvent message?) KEY_ESCAPE))
							)
						)
					)
					(if
						(or
							(& (pEvent type?) $4101)
							(and
								(& (pEvent type?) evKEYBOARD)
								(proc999_5 (pEvent message?) 13 27)
							)
						)
						(pEvent claimed: 1)
						(self dispose: disposeWhenDone)
					)
				)
			)
		)
	)
	
	(method (say param1 param2)
		(if gSq5IconBar (gSq5IconBar disable:))
		(if (not initialized) (self init:))
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& global90 $0001) (self startText: param1))
		(if (& global90 $0002) (self startAudio: param1))
		(cond 
			(modeless
				(gOldMH addToFront: self)
				(gOldKH addToFront: self)
				(gTheDoits add: self)
			)
			((IsObject gNewEventHandler) (gNewEventHandler add: self))
			(else
				((= gNewEventHandler (EventHandler new:))
					name: {fastCast}
					add: self
				)
			)
		)
		(= ticks (+ ticks 60 gLastTicks))
		(return 1)
	)
	
	(method (startText param1 &tmp temp0)
		(if (not (& global90 $0002))
			(= ticks
				(proc999_3
					240
					(* global94 2 (= temp0 (StrLen param1)))
				)
			)
		)
		(if gDialog (gDialog dispose:))
		(self display: param1)
		(return temp0)
	)
	
	(method (display theText &tmp theTalkWidth newGSq5Win)
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
		(Print
			window: newGSq5Win
			posn: x y
			font: font
			width: theTalkWidth
			addText: theText
			modeless: 1
			init:
		)
	)
	
	(method (startAudio param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (proc999_6 param1 0))
		(= temp1 (proc999_6 param1 1))
		(= temp2 (proc999_6 param1 2))
		(= temp3 (proc999_6 param1 3))
		(= temp4 (proc999_6 param1 4))
		(= ticks (DoAudio 2 temp0 temp1 temp2 temp3 temp4))
	)
)

(class Talker of Narrator
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
		back 7
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
	)
	
	(method (init theBust theEyes theMouth)
		(if argc
			(= bust theBust)
			(if (> argc 1)
				(= eyes theEyes)
				(if (> argc 2) (= mouth theMouth))
			)
		)
		(self setSize:)
		(super init:)
	)
	
	(method (doit)
		(if (and (super doit:) mouth) (self cycle: mouth))
		(if eyes (self cycle: eyes))
	)
	
	(method (dispose param1)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view?)
				(mouth loop?)
				0
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if (and eyes underBits)
				(eyes setCycle: 0 cel: 0)
				(DrawCel
					(eyes view?)
					(eyes loop?)
					0
					(+ (eyes nsLeft?) nsLeft)
					(+ (eyes nsTop?) nsTop)
					-1
				)
			)
			(self hide:)
		)
		(super dispose: param1)
	)
	
	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(if gSq5IconBar (gSq5IconBar enable:))
	)
	
	(method (show &tmp temp0)
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
		(PicNotValid temp0)
	)
	
	(method (say)
		(if (and (> view 0) (not underBits)) (self init:))
		(super say: &rest)
	)
	
	(method (startText &tmp temp0)
		(if (not viewInPrint) (self show:))
		(= temp0 (super startText: &rest))
		(if mouth (mouth setCycle: RandCycle (* 4 temp0) 0 1))
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)
	
	(method (display theText &tmp temp0 theTalkWidth temp2 newGSq5Win)
		((= newGSq5Win (gSq5Win new:)) color: color back: back)
		(if
		(and (not (HaveMouse)) (!= gCursorNumber 996))
			(= saveCursor gCursorNumber)
			(gSQ5 setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if viewInPrint
			(= temp0 (if useFrame loop else (bust loop?)))
			(if showTitle (Print addTitle: name))
			(Print
				window: newGSq5Win
				posn: x y
				modeless: 1
				font: font
				addText: theText
				addIcon: view temp0 cel 0 0
				init:
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
			(if showTitle (Print addTitle: name))
			(Print
				window: newGSq5Win
				posn: (+ x textX) (+ y textY)
				modeless: 1
				font: font
				width: theTalkWidth
				addText: theText
				init:
			)
		)
	)
	
	(method (startAudio param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(self show:)
		(super startAudio: param1)
		(if mouth
			(= temp0 (proc999_6 param1 0))
			(= temp1 (proc999_6 param1 1))
			(= temp2 (proc999_6 param1 2))
			(= temp3 (proc999_6 param1 3))
			(= temp4 (proc999_6 param1 4))
			(mouth setCycle: MouthSync temp0 temp1 temp2 temp3 temp4)
		)
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)
	
	(method (cycle param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 cycler?))
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
		)
	)
	
	(method (setSize)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight
			(+
				nsLeft
				(proc999_3
					(if view (CelWide view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsLeft?)
							(CelWide (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsLeft?)
							(CelWide (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsLeft?)
							(CelWide (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(proc999_3
					(if view (CelHigh view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsTop?)
							(CelHigh (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsTop?)
							(CelHigh (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsTop?)
							(CelHigh (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
	)
)
