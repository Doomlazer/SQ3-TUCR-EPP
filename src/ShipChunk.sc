;;; Sierra Script 1.0 - (do not remove this comment)
(script# 850)
(include sci.sh)
(use Main)
(use Blink)
(use Scaler)
(use CueObj)
(use MoveFwd)
(use n958)
(use SysWindow)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm850 0
	dTalker 1
	quirkTalker 14
	rogerTalker 15
)

(local
	local0
	local1
	local2
	theTheRegister_2
	theTheRegister
	theRegister
	local6 =  -1
	local7
	theShipNum
	local9
	local10
	theShip
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	clientX
	clientY
	local22
	local23
	local24
	local25
	local26
	[local27 2]
	local29 =  2
	local30
	local31
	local32
	[local33 30] = [9 5 3 5 0 0 0 0 0 0 0 0 6 7 8 9]
	[local63 16] = [-6934 -10288 -20914 -16720 17632 -29056 -7104 11808 17472 3584 17472 3584 20032 20032 20032 20032]
	[local79 6] = [120 134 158 150 190 120]
	[local85 300]
)
(procedure (localproc_055b param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (/ gPEventX 9) 9) 2))
	(= temp1 (- (* (/ gPEventY 8) 8) 3))
	(= temp2 0)
	(= temp3 0)
	(switch param1
		(1 (= temp3 -1))
		(5 (= temp3 1))
		(3 (= temp2 1))
		(7 (= temp2 -1))
		(2 (= temp2 1) (= temp3 -1))
		(8 (= temp2 -1) (= temp3 -1))
		(4 (= temp2 1) (= temp3 1))
		(6 (= temp2 -1) (= temp3 1))
	)
	(= temp2 (* temp2 9))
	(= temp3 (* temp3 8))
	(SetCursor (+ temp0 temp2) (+ temp1 temp3))
)

(procedure (localproc_0614 param1 param2 &tmp temp0)
	(return
		(==
			[local33 param1]
			[local33 (+
				temp0
				(= [local33 (+ temp0 param1)]
					(+
						[local33 (+ (= temp0 (if (== param2 0) 4 else 8)) param1)]
						1
					)
				)
			)]
		)
	)
)

(procedure (localproc_0641)
	(gSQ5 handsOn:)
	(gSq5IconBar disable: 0 3 4 5 6)
	((gSq5IconBar at: 2) cursor: 999)
	(gSq5IconBar curIcon: (gSq5IconBar at: 2))
)

(procedure (localproc_067d param1)
	(return (<= [local33 param1] [local33 (+ param1 4)]))
)

(procedure (localproc_0689 param1 param2 param3 &tmp temp0 temp1)
	(= temp0 (- param1 1))
	(while (<= temp0 (+ param1 1))
		(= temp1 (- param2 1))
		(while (<= temp1 (+ param2 1))
			(if
				(and
					(or (== temp1 param2) (== temp0 param1))
					(proc999_4 0 0 9 9 temp0 temp1)
					(not (& $0008 (localproc_07ef temp0 temp1 param3 0)))
				)
				(= local22 temp0)
				(= local23 temp1)
				(= local24 param3)
				(return 1)
			)
			(++ temp1)
		)
		(++ temp0)
	)
	(return 0)
)

(procedure (localproc_06fc &tmp temp0 temp1 temp2 temp3)
	(= temp2 0)
	(while (< temp2 3)
		(= temp0 0)
		(while (<= temp0 9)
			(= temp1 0)
			(while (<= temp1 9)
				(if
					(and
						(>
							(& $000f (= temp3 (localproc_07ef temp0 temp1 temp2 0)))
							8
						)
						(not (localproc_067d (- (& $0007 temp3) 1)))
						(localproc_0689 temp0 temp1 temp2)
					)
					(return 1)
				)
				(++ temp1)
			)
			(++ temp0)
		)
		(++ temp2)
	)
	(return 0)
)

(procedure (localproc_076b &tmp [temp0 3] temp3 temp4)
	(if (localproc_06fc)
		(= local13 local22)
		(= local12 local23)
	else
		(repeat
			(= local13 (* (Random 0 4) 2))
			(if (& (= local12 (Random 0 9)) $0001) (++ local13))
			(= local24 (Random 0 2))
			(if
				(not
					(&
						$0008
						(= temp3 (localproc_07ef local13 local12 local24 0))
					)
				)
				(break)
			)
		)
	)
	(return local24)
)

(procedure (localproc_07bd param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0 -32768)
	(= param2 (* param2 4))
	(= temp0 (>> temp0 (+ param1 param2)))
	(= temp1 [local63 (+ (* param3 4) param4)])
	(return (& [local63 (+ (* param3 4) param4)] temp0))
)

(procedure (localproc_07ef param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0 (+ (* param3 50) (* param2 5) (/ param1 2)))
	(= temp1 (if (& param1 $0001) 255 else -256))
	(= temp0 (& [local85 (+ param4 temp0)] temp1))
	(return (if (& param1 $0001) temp0 else (>> temp0 $0008)))
)

(procedure (localproc_0834 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(= temp0 (+ (* param3 50) (* param2 5) (/ param1 2)))
	(= temp1 (if (& param1 $0001) -256 else 255))
	(= [local85 (+ param4 temp0)]
		(& [local85 (+ param4 temp0)] temp1)
	)
	(= param5 (& param5 $00ff))
	(= temp1
		(if (& param1 $0001) param5 else (<< param5 $0008))
	)
	(= [local85 (+ param4 temp0)]
		(| [local85 (+ param4 temp0)] temp1)
	)
)

(procedure (localproc_089b &tmp temp0)
	(= temp0 0)
	(while (< temp0 300)
		(= [local85 temp0] 0)
		(++ temp0)
	)
)

(procedure (localproc_08b3 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 4)
		(= temp1 0)
		(while (< temp1 4)
			(if (localproc_07bd temp1 temp0 param1 param2)
				(cond 
					(
						(not
							(proc999_4
								0
								0
								9
								9
								(- (+ temp1 param4) 1)
								(- (+ temp0 param5) 1)
							)
						)
						(return 0)
					)
					(
						(localproc_07ef
							(- (+ temp1 param4) 1)
							(- (+ temp0 param5) 1)
							param3
							param6
						)
						(return 0)
					)
				)
			)
			(++ temp1)
		)
		(++ temp0)
	)
	(return 1)
)

(procedure (localproc_0935 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 4)
		(= temp1 0)
		(while (< temp1 4)
			(if (localproc_07bd temp1 temp0 param1 param2)
				(localproc_0834
					(- (+ temp1 param4) 1)
					(- (+ temp0 param5) 1)
					param3
					param6
					param7
				)
			)
			(++ temp1)
		)
		(++ temp0)
	)
)

(procedure (localproc_0987)
	(shipSelector loop: (+ theShipNum 6))
	(if
		((= theShip
			(switch theShipNum
				(0 ship1)
				(1 ship2)
				(2 ship3)
				(3 ship4)
			)
		)
			inPlace?
		)
		(specialCursor view: 999 loop: 0 cel: 0)
		(= theShip 0)
	else
		(specialCursor
			view: (theShip view?)
			loop: (theShip loop?)
			setCel: (theShip cel?)
		)
	)
)

(procedure (localproc_0a0a &tmp temp0 temp1)
	(= temp0 0)
	(= temp1 1)
	(while (< temp0 10)
		(DrawCel 537 temp1 0 (+ 114 (* temp0 9)) 89 14)
		(++ temp0)
		(++ temp1)
	)
	(= temp0 0)
	(= temp1 1)
	(while (< temp0 10)
		(DrawCel 539 temp1 0 106 (+ 97 (* temp0 8)) 14)
		(++ temp0)
		(++ temp1)
	)
	(Graph grUPDATE_BOX 88 115 95 205 1)
	(Graph grUPDATE_BOX 97 106 176 113 1)
)

(procedure (localproc_0a89 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 0)
	(while (< temp0 10)
		(= temp1 0)
		(while (< temp1 10)
			(cond 
				(
					(&
						(= temp2 (localproc_07ef temp1 temp0 param1 param2))
						$0008
					)
					(if (& temp2 $0007) (= temp3 0) else (= temp3 1))
					(DrawCel
						537
						12
						temp3
						(+ 115 (* temp1 9))
						(+ 97 (* temp0 8))
						14
					)
				)
				((& temp2 $0010)
					(DrawCel
						537
						12
						2
						(+ 115 (* temp1 9))
						(+ 97 (* temp0 8))
						14
					)
				)
			)
			(++ temp1)
		)
		(++ temp0)
	)
)

(procedure (localproc_0b1d param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(= temp1 (- param2 2))
	(while (< temp1 (+ param2 2))
		(= temp0 (- param1 2))
		(while (< temp0 (+ param1 2))
			(= temp2 (localproc_07ef temp0 temp1 param3 param4))
			(if
			(and (proc999_4 0 0 9 9 temp0 temp1) (& temp2 $0007))
				(= temp2 (| temp2 $0010))
				(localproc_0834 temp0 temp1 param3 param4 temp2)
			)
			(++ temp0)
		)
		(++ temp1)
	)
)

(procedure (localproc_0b8c &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(while (< temp3 3)
		(= temp1 0)
		(while (< temp1 10)
			(= temp0 0)
			(while (< temp0 10)
				(if
					(&
						(= temp2 (localproc_07ef temp0 temp1 temp3 150))
						$0007
					)
					(localproc_0834 temp0 temp1 temp3 150 (| temp2 $0010))
				)
				(++ temp0)
			)
			(++ temp1)
		)
		(++ temp3)
	)
)

(procedure (localproc_0beb &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 0)
	(while (< temp0 4)
		(repeat
			(= temp3 (Random 0 9))
			(= temp4 (Random 0 9))
			(= temp2 (Random 0 2))
			(= temp1 (Random 0 3))
			(breakif (localproc_08b3 temp0 temp1 temp2 temp3 temp4 150))
		)
		(localproc_0935
			temp0
			temp1
			temp2
			temp3
			temp4
			150
			(+ temp0 1)
		)
		(= [local33 (+ 16 temp0)] temp1)
		(= [local33 (+ 20 temp0)] (+ (* (+ temp3 13) 9) 2))
		(= [local33 (+ 24 temp0)] (- (* (+ temp4 13) 8) 3))
		(++ temp0)
	)
)

(procedure (localproc_0c87 param1 &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 (gOldCast size?))
		(if
			(and
				((= temp1 (gOldCast at: temp0)) isKindOf: Ship)
				(temp1 inPlace?)
			)
			(if (== (temp1 lev?) param1)
				(temp1 show: startUpd:)
				(if (>= (gSQ5 _detailLevel?) 3)
					(temp1 setScale: ShipScaler)
				else
					(temp1 scaleX: 127 scaleY: 127)
				)
			else
				(temp1 hide:)
			)
		)
		(++ temp0)
	)
)

(class ShipChunk of Actor
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
		view 533
		loop 0
		cel 0
		priority 13
		underBits 0
		signal $5810
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
		xStep 3
		origStep 770
		moveSpeed 1
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
	)
	
	(method (init param1 param2)
		(self x: param1 y: param2)
		(super init: &rest)
		(self setCycle: Fwd setMotion: MoveFwd 50 self)
	)
	
	(method (cue)
		(self dispose:)
	)
)

(class Ship of Prop
	(properties
		x 0
		y 0
		z 50
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
		view 538
		loop 0
		cel 0
		priority 13
		underBits 0
		signal $5018
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0001
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		shipNum -1
		col -1
		row -1
		lev -1
		inPlace 0
	)
	
	(method (init)
		(super init: &rest)
		(self hide:)
	)
	
	(method (doit)
		(cond 
			((and (== local31 3) (== local32 0)) (self hide:))
			(
			(or (== theShip self) (not (gUser canControl:))) 0)
			(
				(and
					inPlace
					(== theRegister lev)
					(not (self isNotHidden:))
				)
				(self show:)
			)
			((and (!= theRegister lev) (self isNotHidden:)) (self hide:))
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(if (== local31 0)
						(if (not theShip)
							(= theShipNum shipNum)
							(= inPlace 0)
							(self hide:)
							(= theShip self)
							(localproc_0935 shipNum cel lev col row 0 0)
							(localproc_0987)
						else
							(grid doVerb: 4)
						)
					)
				)
				(else 
					(gTestMessager say: noun 0 0 0)
				)
			)
		else
			(gTestMessager say: noun 0 0 0)
		)
	)
	
	(method (onMe)
		(if
			(or
				(not (proc999_4 116 97 206 177 gPEventX gPEventY))
				(!= (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
			)
			(super onMe: &rest)
		else
			(if
				(and
					(<= nsLeft (specialCursor x?))
					(<= (specialCursor x?) nsRight)
					(<= nsTop (specialCursor y?))
					(<= (specialCursor y?) nsBottom)
				)
				(self isNotHidden:)
			)
			(return)
		)
	)
	
	(method (place)
		(if (localproc_08b3 shipNum cel lev col row 0)
			(self inPlace: 1 show: normalize:)
			(localproc_0935 shipNum cel lev col row 0 (+ shipNum 1))
			(= theShip 0)
		)
	)
	
	(method (normalize)
		(self
			x: (+ (* (+ col 13) 9) 2)
			y: (+ (- (* (+ row 13) 8) 3) z)
			scaleX: 128
			scaleY: 128
		)
	)
)

(instance rm850 of Rm
	(properties
		noun 13
		picture 75
	)
	
	(method (init)
		(quirkHead init:)
		(gSq5Music1 number: 27 vol: 127 loop: -1 play:)
		(proc958_0 128 537 531 538 539 533)
		(proc958_0 132 202 203 27)
		(super init: &rest)
		(cheat1f init: setOnMeCheck: 26505)
		(cheat2f init: setOnMeCheck: 26505)
		(gOldDH addToFront: controlBar)
		(self overlay: 175 setScript: playGame)
	)
	
	(method (doit)
		(if (GameIsRestarting)
			(localproc_0a0a)
			(localproc_0a89
				theRegister
				(if (== local32 0) 150 else 0)
			)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		((gSq5IconBar at: 2) cursor: 982)
		(gOldDH delete: controlBar)
		(controlBar dispose:)
		(DisposeScript 951)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
)

(class Bar of EventHandler
	(properties
		elements 0
		size 0
		curButton 0
		selectCount 0
		initialized 0
	)
	
	(method (init)
		(if (not initialized)
			(super init: &rest)
			(gTheDoits addToFront: self)
			(gOldMH addToFront: self)
			(gOldKH addToFront: self)
			(= initialized 1)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(not selectCount)
				(== (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
				(gUser canControl:)
				(= temp0
					(self firstTrue: #onMe gPEventX (- gPEventY 10))
				)
			)
			(self highLight: temp0)
		)
	)
	
	(method (dispose)
		(gTheDoits delete: self)
		(gOldMH delete: self)
		(gOldKH delete: self)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(= temp1 ((gSq5IconBar curIcon?) message?))
		(cond 
			((and selectCount (& (pEvent type?) $4002))
				(self highLight: curButton)
				(= selectCount 0)
				(pEvent claimed: 1)
			)
			(
				(or
					(pEvent claimed?)
					(not (gUser canControl:))
					(!= (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
				)
				0
			)
			((& (pEvent type?) evJOYSTICK)
				(localproc_055b (pEvent message?))
				(pEvent claimed: 1)
				(return 1)
			)
			(
				(and
					(& (pEvent type?) $4001)
					(proc999_4 116 97 206 177 pEvent)
					(!= local31 1)
				)
				(return 0)
			)
			(
				(and
					(& (pEvent type?) evMOUSEBUTTON)
					(not (pEvent modifiers?))
					(not selectCount)
				)
				(if (= temp0 (self firstTrue: #onMe pEvent))
					(self select: temp0)
					(temp0 doVerb: temp1)
					(pEvent claimed: 1)
				else
					(pEvent claimed: 0)
				)
			)
			((& (pEvent type?) $4004)
				(switch (pEvent message?)
					(KEY_RETURN
						(if (= temp0 (self firstTrue: #onMe pEvent))
							(self select: temp0)
							(temp0 doVerb: temp1)
							(self highLight: curButton)
							(= selectCount 0)
							(pEvent claimed: 1)
						else
							(pEvent claimed: 0)
						)
					)
					(KEY_SHIFTTAB
						(self retreat:)
						(pEvent claimed: 1)
					)
					(KEY_TAB
						(self advance:)
						(pEvent claimed: 1)
					)
				)
			)
			(else (pEvent claimed: 0))
		)
		(return (pEvent claimed?))
	)
	
	(method (select theCurButton)
		(curButton setCel: 0)
		(if (and argc theCurButton)
			(theCurButton setCel: 1)
			(= curButton theCurButton)
			(gSq5Music2 number: 124 loop: 1 play:)
			(= selectCount 1)
		else
			(= curButton 0)
		)
	)
	
	(method (highLight theCurButton)
		(curButton highLight:)
		(if (and argc theCurButton)
			(theCurButton highLight: 1)
			(= curButton theCurButton)
		else
			(= curButton 0)
		)
	)
	
	(method (advance &tmp temp0 temp1)
		(= temp0 (self indexOf: curButton))
		(if (== (++ temp0) size) (= temp0 0))
		(= temp1 (self at: temp0))
		(SetCursor (+ (temp1 x?) 3) (+ (temp1 y?) 3))
		(= gPEventX (+ (temp1 x?) 3))
		(= gPEventY (+ (temp1 y?) 3))
	)
	
	(method (retreat &tmp temp0 temp1)
		(= temp0 (self indexOf: curButton))
		(if (== (-- temp0) -1) (= temp0 (- size 1)))
		(= temp1 (self at: temp0))
		(SetCursor (+ (temp1 x?) 3) (+ (temp1 y?) 3))
		(= gPEventX (+ (temp1 x?) 3))
		(= gPEventY (+ (temp1 y?) 3))
	)
	
	(method (hide)
		(self eachElementDo: #hide)
	)
	
	(method (show)
		(self eachElementDo: #show)
	)
)

(instance controlBar of Bar
	(properties)
	
	(method (init)
		(super init:)
		(self release:)
		(switch local31
			(0
				(playBut dispose:)
				(directionBut dispose:)
				(self
					add: nextBut rotateBut doneBut sector1But sector2But sector3But quitBut
					curButton: sector1But
				)
			)
			(1
				(self add: playBut directionBut curButton: playBut)
			)
			(else 
				(switch local32
					(150
						(self add: doneBut)
						(weaponBut dispose:)
						(probeBut dispose:)
						(numProbes startUpd: dispose: delete:)
						(firePanel startUpd: dispose: delete:)
					)
					(0
						(doneBut dispose:)
						(self add: weaponBut)
						(weaponBut init: current: 1)
						(if local29
							(probeBut init: current: 0)
							(self add: probeBut)
							(numProbes init: stopUpd:)
						else
							(probeBut startUpd: dispose: delete:)
							(numProbes startUpd: dispose: delete:)
						)
						(firePanel init: stopUpd:)
					)
				)
				(nextBut dispose:)
				(rotateBut dispose:)
				(shipSelector dispose:)
				(self
					add: sector1But sector2But sector3But quitBut
					curButton: sector1But
				)
				(= theShip 0)
			)
		)
		(self eachElementDo: #init)
	)
)

(class Button of View
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
		view 538
		loop 0
		cel 0
		priority 14
		underBits 0
		signal $4010
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
		current 0
	)
	
	(method (init)
		(self setCel: (if current 3 else 0))
		(super init: &rest)
	)
	
	(method (doit)
		(cond 
			((and current (< cel 3)) (self setCel: (+ cel 3)))
			((and (not current) (> cel 2)) (self setCel: (- cel 3)))
		)
		(super doit: &rest)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (== (pEvent message?) JOY_DOWNRIGHT)
			(controlBar handleEvent: pEvent)
		else
			(super handleEvent: pEvent &rest)
		)
	)
	
	(method (highLight &tmp theParamTotal temp1)
		(if argc
			(= theParamTotal argc)
		else
			(= theParamTotal 0)
		)
		(= temp1
			(+ (if theParamTotal 2 else 0) (if current 3 else 0))
		)
		(self setCel: temp1)
	)
)

(instance doneBut of Button
	(properties
		x 73
		y 174
		noun 3
		loop 3
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(cond 
						((== local31 3)
							(if (== local32 150)
								(quirksTurn cue:)
							else
								(rogersTurn cue:)
							)
						)
						(
							(and
								(ship1 inPlace?)
								(ship2 inPlace?)
								(ship3 inPlace?)
								(ship4 inPlace?)
							)
							((global2 script?) cue:)
						)
						(else (gTestMessager say: noun 4 1 0))
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sector1But of Button
	(properties
		x 206
		y 104
		noun 15
	)
	
	(method (doit)
		(= current (== theRegister 0))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(grid setScript: changeGrid 0 0)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sector2But of Button
	(properties
		x 206
		y 116
		noun 16
		loop 1
	)
	
	(method (doit)
		(= current (== theRegister 1))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(grid setScript: changeGrid 0 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sector3But of Button
	(properties
		x 206
		y 128
		noun 17
		loop 2
	)
	
	(method (doit)
		(= current (== theRegister 2))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(grid setScript: changeGrid 0 2)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance nextBut of Button
	(properties
		x 73
		y 115
		noun 7
		loop 11
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(= theShipNum (mod (-- theShipNum) 4))
					(localproc_0987)
					(grid setScript: showShip)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance quitBut of Button
	(properties
		x 73
		y 104
		noun 11
		loop 12
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 (grid setScript: iQuit))
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance playBut of Button
	(properties
		x 140
		y 120
		view 539
		loop 11
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(= local31 0)
					((global2 script?) cue:)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance directionBut of Button
	(properties
		x 140
		y 135
		view 539
		loop 12
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(= local31 2)
					((global2 script?) cue:)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance rotateBut of Button
	(properties
		x 73
		y 126
		noun 14
		loop 10
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(if theShip
						(if (not (theShip inPlace?))
							(theShip setCel: (mod (- (theShip cel?) 1) 4))
							(specialCursor
								view: (theShip view?)
								loop: (theShip loop?)
								cel: (theShip cel?)
							)
						)
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance weaponBut of Button
	(properties
		x 212
		y 149
		noun 18
		loop 14
		current 1
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(= current 1)
					(probeBut current: 0)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance probeBut of Button
	(properties
		x 212
		y 162
		noun 9
		loop 15
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(= current 1)
					(weaponBut current: 0)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance numProbes of View
	(properties
		x 217
		y 173
		noun 8
		view 538
		loop 13
		priority 14
		signal $5810
	)
	
	(method (init)
		(self setCel: local29)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
)

(instance firePanel of View
	(properties
		x 209
		y 142
		noun 4
		view 538
		loop 12
		cel 3
		priority 13
		signal $4010
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
)

(instance lines of View
	(properties
		x 115
		y 97
		noun 5
		view 538
		loop 4
		cel 3
		priority 13
		signal $4810
	)
	
	(method (doit)
		(if (!= loop (grid loop?))
			(self setLoop: (grid loop?))
		)
		(cond 
			((>= (grid scaleX?) 127)
				(self x: (grid x?) y: (grid y?))
				(if
				(and (not (self isNotHidden:)) (grid isNotHidden:))
					(self show:)
				)
			)
			((self isNotHidden:) (self hide:))
		)
	)
	
	(method (doVerb)
		(grid doVerb: &rest)
	)
)

(instance grid of Actor
	(properties
		x 115
		y 97
		noun 5
		yStep 6
		view 538
		loop 4
		priority 12
		signal $4810
		scaleSignal $0005
		scaleX 127
		scaleY 127
		cycleSpeed 20
		xStep 8
		moveSpeed 0
	)
	
	(method (init)
		(if (== local31 0)
			(self setLoop: 4 posn: 120 134 scaleX: 10 scaleY: 10)
		else
			(if (== local32 0)
				(self setLoop: 5)
			else
				(self setLoop: 4)
			)
			(self setCel: theRegister)
			(if (< (gSQ5 _detailLevel?) 3)
				(grid setScale: 0 scaleX: 128 scaleY: 128 posn: 115 97)
			else
				(self
					x: [local79 (* theRegister 2)]
					y: [local79 (+ (* theRegister 2) 1)]
					scaleX: 10
					scaleY: 10
				)
			)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4
					(cond 
						((== local31 0)
							(if
								(and
									theShip
									(proc999_4 116 97 206 177 gPEventX (- gPEventY 10))
								)
								(theShip place:)
							)
						)
						(
							(and
								(not script)
								(== local32 0)
								(proc999_4 116 97 206 177 gPEventX (- gPEventY 10))
							)
							(cond 
								(
									(&
										$0008
										(localproc_07ef
											local13
											local12
											theRegister
											(if (== local32 0) 150 else 0)
										)
									)
									(gTestMessager say: noun 4 2 0)
								)
								((weaponBut current?) (self setScript: fire))
								(local29 (self setScript: launchProbe))
							)
						)
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
	
	(method (hide)
		(lines hide:)
		(super hide: &rest)
	)
)

(instance ship1 of Ship
	(properties
		noun 19
		loop 6
		shipNum 0
	)
)

(instance ship2 of Ship
	(properties
		noun 20
		loop 7
		shipNum 1
	)
)

(instance ship3 of Ship
	(properties
		noun 21
		loop 8
		shipNum 2
	)
)

(instance ship4 of Ship
	(properties
		noun 22
		loop 9
		shipNum 3
	)
)

(instance logo of View
	(properties
		x 118
		y 118
		view 537
		priority 14
		signal $4010
		scaleSignal $0001
	)
	
	(method (doit)
		(self x: (- 160 (/ (- nsRight nsLeft) 2)))
		(super doit: &rest)
	)
)

(instance shipSelector of View
	(properties
		x 87
		y 149
		noun 1
		view 538
		loop 6
		priority 13
		signal $5010
	)
	
	(method (doit)
		(if (and theShip (!= cel (theShip cel?)))
			(self setCel: (theShip cel?))
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
)

(instance extra1 of Actor
	(properties
		x 277
		y 162
		view 538
		loop 7
		cel 3
		priority 8
		signal $5810
	)
)

(instance extra2 of Actor
	(properties
		view 537
		loop 12
		cel 1
		priority 14
		signal $5810
	)
)

(instance chunk1 of ShipChunk
	(properties
		loop 1
	)
)

(instance chunk2 of ShipChunk
	(properties
		heading 60
		loop 2
	)
)

(instance chunk3 of ShipChunk
	(properties
		heading 120
		loop 3
	)
)

(instance chunk4 of ShipChunk
	(properties
		heading 180
		loop 4
	)
)

(instance chunk5 of ShipChunk
	(properties
		heading 240
		loop 5
	)
)

(instance chunk6 of ShipChunk
	(properties
		heading 320
		loop 6
	)
)

(instance hitMiss of Prop
	(properties
		y 93
		view 537
		loop 13
		priority 14
		signal $5810
		cycleSpeed 12
	)
	
	(method (init param1)
		(if (and argc param1)
			(self setLoop: 14 cel: 1 posn: 83 93)
		else
			(self setLoop: 13 cel: 1 posn: 211 93)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
)

(instance quirkHead of Prop
	(properties
		x 139
		y -2
		view 531
		priority 1
		signal $5810
	)
	
	(method (doVerb theVerb)
		(return
			(if (== theVerb 1)
				(super doVerb: theVerb &rest)
			else
				(return 1)
			)
		)
	)
	
	(method (show param1)
		(switch local30
			(0
				(self setLoop: 0 x: 139 y: -2)
			)
			(2
				(self setLoop: 1 x: 143 y: -5)
			)
			(1
				(self setLoop: 2 x: 134 y: -5)
			)
		)
		(super show: &rest)
	)
)

(instance specialCursor of View
	(properties
		view 999
		priority 15
		signal $5010
	)
	
	(method (doit &tmp temp0 temp1 theGPEventX temp3)
		(cond 
			(
			(and (not (gUser canControl:)) (self isNotHidden:)) (self hide:))
			(
			(== (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
				(= theGPEventX gPEventX)
				(= temp3 (- gPEventY 10))
				(if (proc999_4 116 97 206 177 theGPEventX temp3)
					(if (!= ((gSq5IconBar at: 2) cursor?) 996)
						((gSq5IconBar at: 2) cursor: 996)
						(gSq5IconBar curIcon: (gSq5IconBar at: 2))
						(gSQ5 setCursor: 996)
					)
					(if (< (= temp0 (/ (+ theGPEventX 1) 9)) 13)
						(= temp0 13)
					)
					(if (> temp0 22) (= temp0 22))
					(if (< (= temp1 (/ (+ temp3 7) 8)) 13) (= temp1 13))
					(if (> temp1 22) (= temp1 22))
					(= local13 (- temp0 13))
					(= local12 (- temp1 13))
					(if theShip
						(if
							(localproc_08b3
								theShipNum
								cel
								theRegister
								(- temp0 13)
								(- temp1 13)
								0
							)
							(self show: x: (+ (* temp0 9) 2) y: (- (* temp1 8) 3))
							(theShip col: local13 row: local12 lev: theRegister)
						)
					else
						(self
							view: 999
							show:
							x: (+ (* temp0 9) 2)
							y: (- (* temp1 8) 3)
						)
					)
				else
					(if (!= ((gSq5IconBar at: 2) cursor?) 999)
						((gSq5IconBar at: 2) cursor: 999)
						(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
					)
					(self hide:)
				)
			)
			(else
				(if (!= ((gSq5IconBar at: 2) cursor?) 999)
					((gSq5IconBar at: 2) cursor: 999)
					(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
				)
				(self hide:)
			)
		)
		(super doit: &rest)
	)
	
	(method (doVerb)
		(grid doVerb: 4)
	)
)

(instance changeGrid of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client grid) (gSQ5 handsOff:))
				(grid startUpd:)
				(lines startUpd:)
				(if (or (== local32 150) (== local31 0))
					(ship1 startUpd:)
					(ship2 startUpd:)
					(ship3 startUpd:)
					(ship4 startUpd:)
				)
				(cond 
					((== theRegister register) (= state (+ state 1)))
					((> register 3) (= register (- register 10)))
				)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(if (or (== local32 150) (== local31 0))
					(localproc_0c87 theRegister)
				)
				(if (< (gSQ5 _detailLevel?) 3)
					(grid setScale: 0 scaleX: 127 scaleY: 127 posn: 115 97)
					(= state (+ state 2))
					(= cycles 1)
				else
					(grid
						setMotion:
							MoveTo
							[local79 (* theRegister 2)]
							[local79 (+ (* theRegister 2) 1)]
							self
						setScale: gridScaler 100 10 97 [local79 (+ (* theRegister 2) 1)]
					)
				)
			)
			(3
				(if (!= theRegister register) (grid hide:))
				(= cycles 2)
			)
			(4
				(if (!= theRegister register)
					(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				)
				(= cycles 2)
			)
			(5
				(if (!= theRegister register)
					(= theRegister register)
					(grid show: setCel: theRegister)
					(= state (+ state 1))
				)
				(if (< (gSQ5 _detailLevel?) 3)
					(grid posn: 115 97 scaleX: 127 scaleY: 127)
					(= cycles 3)
				else
					(grid
						posn: [local79 (* theRegister 2)] [local79 (+ (* theRegister 2) 1)]
						setMotion: MoveTo 115 97 self
						setScale: gridScaler 100 10 97 [local79 (+ (* theRegister 2) 1)]
					)
				)
				(if (or (== local32 150) (== local31 0))
					(localproc_0c87 theRegister)
				)
			)
			(6 (lines show:) (= cycles 2))
			(7
				(if (or (== local32 150) (== local31 0))
					(ship1 setScale: 0 normalize: stopUpd:)
					(ship2 setScale: 0 normalize: stopUpd:)
					(ship3 setScale: 0 normalize: stopUpd:)
					(ship4 setScale: 0 normalize: stopUpd:)
				)
				(grid x: 115 y: 97 scaleX: 127 scaleY: 127)
				(lines stopUpd:)
				(grid stopUpd:)
				(= cycles 1)
			)
			(8
				(if (== local31 3)
					(localproc_0a89
						theRegister
						(if (== local32 0) 150 else 0)
					)
				)
				(if (== client grid) (localproc_0641))
				(self dispose:)
			)
		)
	)
)

(instance showShip of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== client grid) (gSQ5 handsOff:))
				(if
					((= temp0
						(switch theShipNum
							(0 ship1)
							(1 ship2)
							(2 ship3)
							(3 ship4)
						)
					)
						inPlace?
					)
					(self setScript: changeGrid self (temp0 lev?))
				else
					(if (== client grid) (localproc_0641))
					(self dispose:)
				)
			)
			(1
				(if (== client grid) (localproc_0641))
				(self dispose:)
			)
		)
	)
)

(instance shakeShip of Script
	(properties)
	
	(method (dispose)
		(client x: clientX y: clientY)
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd:)
				(= cycles 3)
			)
			(1
				(= clientX (client x?))
				(= clientY (client y?))
				(= cycles 1)
			)
			(2
				(client
					x: (+ clientX (* (- (Random 0 2) 1) 1))
					y: (+ clientY (* (- (Random 0 2) 1) 1))
				)
				(-- state)
				(= cycles 1)
			)
		)
	)
)

(instance blowUpShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc958_0 128 538 533)
				(proc958_0 132 203)
				(if theShip
					(extra1
						view: (theShip view?)
						loop: (theShip loop?)
						cel: (theShip cel?)
						x: (theShip x?)
						y: (- (theShip y?) (theShip z?))
						signal: 16400
						init:
					)
				else
					(extra1
						view: 538
						cel: [local33 (+ 15 (& local19 $0007))]
						signal: 16400
						loop: (+ 5 (& local19 $0007))
						x: [local33 (+ 19 (& local19 $0007))]
						y: [local33 (+ 23 (& local19 $0007))]
						init:
					)
				)
				(extra1 setPri: 15 setScript: shakeShip)
				(= seconds 4)
			)
			(1
				(gSq5Music2 number: 203 loop: 1 play:)
				(extra1
					view: 533
					loop: 0
					cel: 0
					cycleSpeed: 5
					setScript: 0
					setCycle: End self
				)
				(chunk1 init: (extra1 x?) (extra1 y?))
				(chunk2 init: (extra1 x?) (extra1 y?))
				(chunk3 init: (extra1 x?) (extra1 y?))
				(chunk4 init: (extra1 x?) (extra1 y?))
				(chunk5 init: (extra1 x?) (extra1 y?))
				(chunk6 init: (extra1 x?) (extra1 y?))
				(= seconds 4)
			)
			(2 (extra1 dispose:))
			(3
				(chunk1 dispose:)
				(chunk2 dispose:)
				(chunk3 dispose:)
				(chunk4 dispose:)
				(chunk5 dispose:)
				(chunk6 dispose:)
				(gTestMessager say: local2 0 local1 0 self)
			)
			(4
				(= register (if (== local32 150) 28 else 29))
				(if (== local32 0) (++ local29))
				(if
				(== (= [local33 register] (+ [local33 register] 1)) 4)
					(= local6 (if (== local32 0) 150 else 0))
				)
				(self dispose:)
			)
		)
	)
)

(instance launchProbe of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== local32 0)
					(-- local29)
					(numProbes setCel: local29)
				)
				(= theShip 0)
				(if (== client grid) (gSQ5 handsOff:))
				(= local16 local12)
				(= local17 local13)
				(extra1
					init:
					view: 537
					setLoop: 12
					cel: 1
					x: (+ 115 (* local17 9))
					y: 97
					setPri: 15
				)
				(extra2
					view: 537
					setLoop: 12
					cel: 1
					x: 115
					y: (+ 97 (* local16 8))
					init:
				)
				(gSq5Music2 number: 224 loop: -1 play:)
				(DrawCel
					537
					(+ local17 1)
					1
					(+ 114 (* local17 9))
					89
					14
				)
				(DrawCel
					539
					(+ local16 1)
					1
					106
					(+ 97 (* local16 8))
					14
				)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= local14 0)
				(= local15 0)
				(= cycles 2)
			)
			(1
				(if (!= local15 local17)
					(extra2 x: (+ (extra2 x?) 9) y: (+ 97 (* local16 8)))
					(++ local15)
					(= state 0)
				)
				(if (!= local14 local16)
					(extra1 x: (+ 115 (* local17 9)) y: (+ (extra1 y?) 8))
					(++ local14)
					(= state 0)
				)
				(= ticks 10)
			)
			(2
				(extra2 dispose:)
				(extra1 view: 537 setLoop: 15 cel: 0 setCycle: End self)
			)
			(3
				(DrawCel
					537
					(+ local17 1)
					0
					(+ 114 (* local17 9))
					89
					14
				)
				(DrawCel
					539
					(+ local16 1)
					0
					106
					(+ 97 (* local16 8))
					14
				)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= cycles 2)
			)
			(4
				(gSq5Music2 stop:)
				(localproc_0b1d
					local13
					local12
					theRegister
					(if (== local32 0) 150 else 0)
				)
				(localproc_0a89
					theRegister
					(if (== local32 0) 150 else 0)
				)
				(extra1 dispose:)
				(= seconds 4)
			)
			(5
				(if (== local32 0)
					(rogersTurn cue:)
				else
					(localproc_0641)
				)
				(self dispose:)
			)
		)
	)
)

(instance fire of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= theShip 0)
				(if (== client grid) (gSQ5 handsOff:))
				(= local16 local12)
				(= local17 local13)
				(gSq5Music2 number: 657 loop: 1 play:)
				(extra1
					init:
					view: 537
					setLoop: 12
					cel: 1
					x: (+ 115 (* local17 9))
					y: 97
					setPri: 15
				)
				(extra2
					view: 537
					setLoop: 12
					setCel: 1
					init:
					setCycle: 0
					x: 115
					y: (+ 97 (* local16 8))
					setPri: 15
				)
				(DrawCel
					537
					(+ local17 1)
					1
					(+ 114 (* local17 9))
					89
					14
				)
				(DrawCel
					539
					(+ local16 1)
					1
					106
					(+ 97 (* local16 8))
					14
				)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= local14 0)
				(= local15 0)
				(= cycles 4)
			)
			(1
				(if (!= local15 local17)
					(extra2 x: (+ (extra2 x?) 9) y: (+ 97 (* local16 8)))
					(++ local15)
					(= state 0)
				)
				(if (!= local14 local16)
					(extra1 x: (+ 115 (* local17 9)) y: (+ (extra1 y?) 8))
					(++ local14)
					(= state 0)
				)
				(= ticks 5)
			)
			(2
				(if
					(&
						(= local19
							(localproc_07ef
								local17
								local16
								theRegister
								(if (== local32 0) 150 else 0)
							)
						)
						$0007
					)
					(if (== local32 150)
						(= theShip
							(switch (- (& local19 $0007) 1)
								(0 ship1)
								(1 ship2)
								(2 ship3)
								(3 ship4)
							)
						)
						(theShip setScript: shakeShip)
					)
					(gSq5Music2 number: 202 loop: 1 play:)
					(hitMiss init: 1)
				else
					(hitMiss init: 0)
				)
				(extra2 dispose:)
				(extra1
					setLoop: 11
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3 (extra1 setCycle: Beg self))
			(4
				(if (and theShip (== local32 150))
					(theShip setScript: 0)
				)
				(hitMiss dispose:)
				(extra1 dispose:)
				(if (== local32 150) (= local2 12) else (= local2 10))
				(if (& local19 $0007)
					(if
						(localproc_0614
							(- (& local19 $0007) 1)
							(if (== local32 0) 150 else 0)
						)
						(= local1 [local33 (+ 11 (& local19 $0007))])
					else
						(= local1 4)
					)
				else
					(= local1 5)
				)
				(= cycles 4)
			)
			(5
				(DrawCel
					537
					(+ local17 1)
					0
					(+ 114 (* local17 9))
					89
					14
				)
				(DrawCel
					539
					(+ local16 1)
					0
					106
					(+ 97 (* local16 8))
					14
				)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= cycles 2)
			)
			(6
				(localproc_0834
					local17
					local16
					theRegister
					(if (== local32 0) 150 else 0)
					(| local19 $0008)
				)
				(localproc_0a89
					theRegister
					(if (== local32 0) 150 else 0)
				)
				(= cycles 4)
			)
			(7
				(if (proc999_5 local1 4 5)
					(= cycles 1)
				else
					(self setScript: blowUpShip self)
				)
			)
			(8
				(= theShip 0)
				(quirkHead show: 0)
				(if (== local6 -1)
					(if (== local32 0)
						(rogersTurn cue:)
					else
						(localproc_0641)
					)
				else
					(global2 setScript: endGame)
				)
				(self dispose:)
			)
		)
	)
)

(instance quirksTurn of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 30])
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= local32 150)
				(lines startUpd:)
				(grid startUpd: hide:)
				(firePanel startUpd: hide:)
				(numProbes startUpd: hide:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(controlBar init: show:)
				(DrawPic 175 dpOPEN_NO_TRANSITION dpNO_CLEAR)
				(= cycles 2)
			)
			(3
				(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				(= cycles 2)
			)
			(4
				(= theRegister theTheRegister)
				(grid init: show:)
				(= temp0 (localproc_076b))
				(self setScript: changeGrid self temp0)
			)
			(5
				(ship1 stopUpd:)
				(ship2 stopUpd:)
				(ship3 stopUpd:)
				(ship4 stopUpd:)
				(self setScript: fire self)
			)
			(6 (localproc_0641))
			(7
				(= theTheRegister theRegister)
				(self dispose:)
			)
		)
	)
)

(instance rogersTurn of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(ship1 hide:)
				(ship2 hide:)
				(ship3 hide:)
				(ship4 hide:)
				(lines startUpd:)
				(grid startUpd: hide:)
				(firePanel startUpd: show:)
				(numProbes startUpd: show:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(= local32 0)
				(controlBar init: show:)
				(= theRegister theTheRegister_2)
				(grid init: show:)
				(DrawPic 176 dpOPEN_NO_TRANSITION dpNO_CLEAR)
				(= cycles 2)
			)
			(3
				(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				(= cycles 2)
			)
			(4
				(self
					setScript:
						changeGrid
						self
						(if (< (gSQ5 _detailLevel?) 3)
							theTheRegister_2
						else
							(+ theTheRegister_2 10)
						)
				)
			)
			(5 (localproc_0641))
			(6
				(= theTheRegister_2 theRegister)
				(self dispose:)
			)
		)
	)
)

(instance endGame of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(ship1 hide:)
				(ship2 hide:)
				(ship3 hide:)
				(ship4 hide:)
				(grid startUpd: hide:)
				(firePanel startUpd: show:)
				(numProbes startUpd: show:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(if local6
					(proc0_10 215 (* (- 4 [local33 28]) 25))
					(gTestMessager say: 12 2 11 0 self)
				else
					(gTestMessager say: 10 2 11 0 self)
				)
			)
			(3 (global2 newRoom: 500))
		)
	)
)

(instance iQuit of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gTestMessager say: 10 2 10 0 self)
			)
			(1 (global2 newRoom: 500))
		)
	)
)

(instance doDirections of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(playBut dispose:)
				(directionBut dispose:)
				(global2 drawPic: 75 9)
				(= cycles 3)
			)
			(1
				(gTestMessager say: 2 0 0 0 self)
			)
			(2
				(= local31 0)
				(= gSq5Win gSq5Win_2)
				(global2 overlay: 175)
				(self dispose:)
			)
		)
	)
)

(instance playGame of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(logo init: scaleX: 0 scaleY: 0)
				(= seconds 2)
			)
			(1
				(if (< (logo scaleX?) 128)
					(logo
						scaleX: (+ (logo scaleX?) 3)
						scaleY: (+ (logo scaleY?) 3)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2 (= seconds 2))
			(3
				(extra1
					init:
					setCycle: 0
					setStep: 4 4
					moveSpeed: 0
					setMotion: MoveTo 47 162 self
				)
			)
			(4
				(extra1 dispose:)
				(= cycles 1)
			)
			(5
				(if (> (logo scaleX?) 0)
					(logo
						scaleX: (- (logo scaleX?) 3)
						scaleY: (- (logo scaleY?) 3)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(gSq5Music1 fade: 5 10 0 0)
				(localproc_0641)
				(logo dispose:)
				(= local31 1)
				(localproc_0641)
				(controlBar init:)
			)
			(7
				(gSQ5 handsOff:)
				(if (== local31 0)
					(= cycles 1)
				else
					(self setScript: doDirections self)
				)
			)
			(8
				(localproc_0641)
				(controlBar init:)
				(lines init:)
				(localproc_089b)
				(= theRegister 0)
				(grid init:)
				(changeGrid start: 1)
				(self setScript: changeGrid self 0)
				(changeGrid start: 0)
				(ship1 init:)
				(ship2 init:)
				(ship3 init:)
				(ship4 init:)
				(= theShipNum 0)
				(= theShip ship1)
				(ship1 hide:)
				(shipSelector init:)
				(specialCursor init:)
				(localproc_0a0a)
				(nextBut doVerb: 4)
				(= local31 0)
			)
			(9)
			(10
				(gSQ5 handsOff:)
				(localproc_0beb)
				(= local31 3)
				(shipSelector dispose:)
				(= cycles 2)
			)
			(11
				(controlBar init:)
				(self setScript: rogersTurn self)
			)
			(12
				(controlBar init:)
				(self setScript: quirksTurn self)
			)
			(13
				(= cycles 2)
				(= state (- state 3))
			)
		)
	)
)

(instance gridScaler of Scaler
	(properties)
	
	(method (doit &tmp clientY_2 theBackSize)
		(cond 
			((>= (= clientY_2 (client y?)) backY) (= theBackSize backSize))
			((<= clientY_2 frontY) (= theBackSize frontSize))
			(else
				(= theBackSize
					(+ (/ (* slopeNum clientY_2) slopeDen) const)
				)
			)
		)
		(= theBackSize (/ (* theBackSize 128) 100))
		(client scaleX: theBackSize scaleY: theBackSize)
	)
)

(class ShipScaler of Scaler
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
	)
	
	(method (init theClient)
		(= client theClient)
	)
	
	(method (doit &tmp temp0 temp1 temp2)
		(= temp0
			(/ (* (grid scaleX?) (+ (* (client col?) 9) 1)) 128)
		)
		(= temp1
			(/ (* (grid scaleX?) (+ (* (client row?) 8) 3)) 128)
		)
		(client
			x: (+ (grid x?) temp0 2)
			y: (+ (grid y?) temp1 (client z?) 1)
			scaleX: (grid scaleX?)
			scaleY: (grid scaleX?)
		)
	)
)

(instance rogerTalker of Narrator
	(properties
		talkWidth 100
	)
	
	(method (init)
		(= gSq5Win gNewSpeakWindow)
		(= font gFont)
		(gSq5Win tailX: 240 xOffset: 0 tailY: 150 isBottom: 1)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance quirkTalker of Talker
	(properties
		x 139
		y -2
		view 531
		talkWidth 120
	)
	
	(method (init)
		(= font gFont)
		(quirkHead startUpd: hide:)
		(switch global122
			(25
				(self loop: 0 x: 137 y: -2)
				(quirkMouth loop: 3 cel: 0 nsLeft: 22 nsTop: 24)
				(= local30 0)
			)
			(3
				(self loop: 1 x: 143 y: -5)
				(quirkMouth loop: 4 cel: 0 nsLeft: 12 nsTop: 30)
				(= local30 0)
			)
			(1
				(self loop: 2 x: 134 y: -5)
				(quirkMouth loop: 5 cel: 0 nsLeft: 18 nsTop: 27)
				(= local30 0)
			)
		)
		((= gSq5Win gNewSpeakWindow)
			tailX: 120
			xOffset: -25
			tailY: 40
			isBottom: 0
		)
		(super init: 0 0 quirkMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(quirkHead show:)
		(super dispose: &rest)
	)
)

(instance quirkMouth of Prop
	(properties
		view 531
		loop 3
	)
)

(instance dTalker of Narrator
	(properties
		y 90
		talkWidth 160
		color 15
		back 0
	)
	
	(method (init)
		(= gSq5Win (SysWindow new:))
		(self font: gFont)
		(super init: &rest)
	)
	
	(method (dispose)
		(if gSq5Win (gSq5Win dispose:))
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance cheat1f of Feature
	(properties
		nsTop 105
		nsLeft 31
		nsBottom 110
		nsRight 53
	)
	
	(method (doVerb theVerb)
		(if
		(and (== theVerb 1) (== local31 3) (== local32 0))
			(= local25 (mod (++ local25) 3))
			(if (== 4 (+ local25 local26)) (localproc_0b8c))
		)
	)
)

(instance cheat2f of Feature
	(properties
		nsTop 105
		nsLeft 266
		nsBottom 110
		nsRight 289
	)
	
	(method (doVerb theVerb)
		(asm
			lsp      theVerb
			ldi      1
			eq?     
			bnt      code_330c
			lsl      local31
			ldi      3
			eq?     
			bnt      code_330c
			lsl      local32
			ldi      0
			eq?     
			bnt      code_330c
			+al      local26
			push    
			ldi      3
			mod     
			sal      local26
			pushi    4
			lsl      local25
			add     
			eq?     
			bnt      code_330c
			pushi    0
			call     localproc_0b8c,  0
code_330c:
			ret     
		)
	)
)
