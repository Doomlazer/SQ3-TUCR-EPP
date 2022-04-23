;;; Sierra Script 1.0 - (do not remove this comment)
(script# 801)
(include sci.sh)
(use Main)
(use Blink)
(use CueObj)
(use n958)
(use Rev)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm801 0
	alien1Tkr 1
	alien2Tkr 2
)

(local
	local0
	local1
	local2 =  1300
	local3
	local4
	local5
	local6 =  1
	local7
	local8
	local9
	local10
	local11 =  1300
	[local12 4]
	local16 =  -1
	local17
	local18
	local19
	local20
	local21
	local22
	[local23 3]
	local26
	local27
	[local28 50]
	[local78 9] = [4 5 6 7 8 9 10 11 12]
)
(procedure (localproc_027c)
	(gSQ5 handsOn:)
	(gSq5IconBar disable: 0 3 4 5 6)
)

(procedure (localproc_0297)
	(gSq5Music2 fade: 0 10 5 1)
	(= local26 0)
	(if (or local9 local10)
		(= local9 0)
		(= local10 0)
	else
		(return)
	)
)

(procedure (localproc_02be param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(if (< (= local2 (+ local2 (* param1 2))) 0)
		(= local2 3599)
	)
	(if (> local2 3599) (= local2 0))
	(= temp0 0)
	(while (< temp0 (gOldCast size?))
		(if
		((= temp1 (gOldCast at: temp0)) isKindOf: FloatObj)
			(if (not (if (== temp1 cliffy) (proc0_1 87)))
				(= temp5 local4)
				(= temp6 local5)
				(= temp3 (- (temp1 d3x?) temp5))
				(= temp4 (- (temp1 d3y?) temp6))
				(if
					(<
						(= temp2 (- 180 (GetAngle temp5 temp6 temp3 temp4)))
						0
					)
					(= temp2 (+ temp2 360))
				)
				(if (> (= temp2 (- 450 temp2)) 359)
					(= temp2 (- temp2 360))
				)
				(if (< (= temp2 (- temp2 (/ local2 10))) 0)
					(= temp2 (+ 360 temp2))
				)
				(if (> temp2 359) (= temp2 (- temp2 360)))
				(= temp7 (GetDistance temp5 temp6 temp3 temp4))
				(temp1
					startUpd:
					x: (+ 160 (* (SinMult temp2 temp7) 4))
				)
				(switch temp1
					(cliffy
						(if (proc0_1 87)
							(cliffyBlip x: 158 y: 120)
						else
							(cliffyBlip
								x: (+ 158 (/ (SinMult temp2 temp7) 20))
								y: (- 120 (/ (CosMult temp2 temp7) 20))
							)
							(if (not (proc999_4 136 100 180 130 cliffyBlip))
								(cliffyBlip hide:)
							else
								(cliffyBlip show:)
							)
						)
					)
					(yourShip
						(shipBlip
							x: (+ 158 (/ (SinMult temp2 temp7) 20))
							y: (- 120 (/ (CosMult temp2 temp7) 20))
						)
						(if (not (proc999_4 136 100 180 130 shipBlip))
							(shipBlip hide:)
						else
							(shipBlip show:)
						)
					)
				)
				(if (and (< 90 temp2) (< temp2 270))
					(if (temp1 isNotHidden:)
						(temp1 hide:)
						(if (and (== temp1 cliffy) local21)
							(= local21 0)
							(target dispose:)
						)
					)
				else
					(if (not (temp1 isNotHidden:)) (temp1 show:))
					(switch temp1
						(cliffy
							(if
								(and
									(< (GetDistance temp5 temp6 temp3 temp4) 60)
									(<= 200 (cliffy x?))
									(<= (cliffy x?) 210)
								)
								(= local18 1)
								(if (and (not (proc0_1 87)) (not local21))
									(= local21 1)
									(target init:)
								)
							else
								(= local18 0)
								(if local21 (= local21 0) (target dispose:))
							)
						)
						(yourShip
							(if (< (GetDistance temp5 temp6 temp3 temp4) 60)
								(= local19 1)
							else
								(= local19 0)
								(= local20 0)
							)
						)
					)
				)
				(if
					(<
						(= temp2 (- 220 (GetDistance temp5 temp6 temp3 temp4)))
						1
					)
					(= temp2 1)
				)
				(if (> temp2 200) (= temp2 200))
				(if (and (== temp1 cliffy) (> temp2 128))
					(= temp2 128)
				)
				(temp1 scaleX: temp2 scaleY: temp2 setPri: (/ temp2 44))
			)
		)
		(++ temp0)
	)
	(if (updateThrust client?) (updateThrust cue:))
)

(procedure (localproc_05ef param1 &tmp [temp0 3])
	(= local4
		(+ local4 (CosMult (/ local2 10) (/ param1 4)))
	)
	(= local5
		(+ local5 (SinMult (/ local2 10) (/ param1 4)))
	)
	(if
		(or
			(!= local16 (/ local4 300))
			(!= local17 (/ local5 300))
		)
		(= local16 (/ local4 300))
		(= local17 (/ local5 300))
		(ast0 init: 0)
		(ast1 init: 1)
		(ast2 init: 2)
		(ast3 init: 3)
		(if (>= (gSQ5 _detailLevel?) 2)
			(ast4 init: 4)
			(ast5 init: 5)
			(ast6 init: 6)
		)
		(if (>= (gSQ5 _detailLevel?) 3)
			(ast7 init: 7)
			(ast8 init: 8)
		)
	)
)

(procedure (localproc_06b6)
	(if (and (!= local8 0) (not local26))
		(= local26 1)
		(gSq5Music2 number: 156 loop: -1 vol: 64 play:)
	)
	(switch local8
		(1
			(if (> local10 -6) (= local10 (- local10 1)))
			(if local10 (= local11 (- local11 1)))
		)
		(2
			(if (< local10 6) (= local10 (+ local10 1)))
			(if local10 (= local11 (- local11 1)))
		)
		(3
			(if (< local9 10) (= local9 (+ local9 1)))
			(if 10 (= local11 (- local11 2)))
		)
		(4
			(if (> local9 -10) (= local9 (- local9 1)))
			(if 10 (= local11 (- local11 2)))
		)
		(0 (localproc_0297))
	)
	(fuel setCel: (- (fuel lastCel:) (/ local11 100)))
	(cond 
		(
			(and
				(== (fuel cel?) (fuel lastCel:))
				(not (global2 script?))
			)
			(= local10 0)
			(= local9 0)
			(global2 setScript: outOfFuel)
		)
		(
		(and local19 (not (global2 script?)) (not local20))
			(if (not (proc0_1 87))
				(global2 setScript: warning)
			else
				(global2 setScript: returnToEureka)
			)
		)
		((not (global2 script?)) (localproc_05ef local9) (localproc_02be local10))
	)
)

(class FloatObj of Prop
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
		view -1
		loop 0
		cel 0
		priority 2
		underBits 0
		signal $7810
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
		d3x 0
		d3y 0
	)
)

(class Asteroid of FloatObj
	(properties
		x 0
		y 70
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
		view 272
		loop 0
		cel 0
		priority 2
		underBits 0
		signal $7810
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
		detailLevel 3
		scaler 0
		d3x 0
		d3y 0
		oldD3x 0
		oldD3y 0
	)
	
	(method (init param1)
		(= d3y (+ (* local17 200) oldD3x))
		(= d3x (+ (* local16 200) oldD3y))
		(Random (/ (+ d3x (* 2 d3y)) 10))
		(if (not (gOldCast contains: self))
			(self setCycle: (if (Random 0 1) Fwd else Rev))
			(super init: &rest)
		)
		(if (>= (gSQ5 _detailLevel?) detailLevel)
			(self startUpd:)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager
					say: [local78 (= local27 (mod (++ local27) 9))] 1 0 0
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance updateThrust of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (localproc_06b6))
			(1 (= cycles 2))
			(2
				(hand1 stopUpd:)
				(lever1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance handCursor of Cursor
	(properties
		view 3270
		cel 6
	)
	
	(method (init)
		(cond 
			(
				(and
					(arm cel?)
					(proc999_4 203 124 226 149 gPEventX gPEventY)
				)
				(= cel 5)
			)
			((hand2 onMe: gPEventX gPEventY) (= cel (if (arm cel?) 3 else 1)))
			((proc999_4 62 134 104 160 gPEventX gPEventY) (= cel 4))
			((proc999_4 29 134 61 160 gPEventX gPEventY) (= cel 0))
			((proc999_4 105 134 139 160 gPEventX gPEventY) (= cel 2))
			((proc999_4 62 104 104 133 gPEventX gPEventY) (= cel 1))
			((proc999_4 62 161 104 189 gPEventX gPEventY) (= cel 3))
			(else (= cel 6))
		)
		(super init: &rest)
	)
)

(instance rm801 of Rm
	(properties
		picture 48
	)
	
	(method (init)
		(super init: &rest)
		(proc958_0
			128
			273
			272
			269
			270
			271
			570
			3270
			3271
			3272
			3273
		)
		(gSq5Music1 number: 37 loop: -1 play:)
		(if (Message msgSIZE 801 32 0 0 1)
			(Message msgGET 801 32 0 0 1 @local28)
		else
			(Format @local28 {%s} {Need Message})
		)
		(if (== gGModNum 100) (gEgo get: 9))
		((gSq5IconBar at: 2) cursor: handCursor)
		(radar init: setOnMeCheck: 1 8)
		(headsUp init: setOnMeCheck: 1 32)
		(directions init: setOnMeCheck: 1 2)
		(fuelF init: setOnMeCheck: 1 16)
		(oxygenF init: setOnMeCheck: 1 4)
		(= local22
			(cond 
				((== global137 2) 1)
				((not (gEgo has: 9)) 2)
				(else 0)
			)
		)
		(arm init: stopUpd:)
		(lever1 init: stopUpd:)
		(lever2 init: stopUpd:)
		(hand1 init: stopUpd:)
		(hand2 init: stopUpd:)
		(lthrust init:)
		(rthrust init:)
		(fthrust init:)
		(bthrust init:)
		(if (gEgo has: 9) (gEgo put: 9))
		(oxygen init: setScript: losingAir)
		(fuel init:)
		(clawButton init: setOnMeCheck: 26505)
		(cliffy init: setScript: breathing)
		(yourShip init: stopUpd:)
		(cliffyBlip init: setCycle: Fwd)
		(shipBlip init: setCycle: Fwd)
		(localproc_05ef 0)
		(localproc_02be 0)
		(gOldDH addToFront: lever1)
		(self setScript: startItAll)
	)
	
	(method (doit)
		(if
		(== (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
			(handCursor init:)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(PalVary pvUNINIT)
		(Palette palSET_FROM_RESOURCE 999 2)
		(gOldDH delete: lever1)
		((gSq5IconBar at: 2) cursor: 982)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					(local7 (local7 doVerb: 4))
					((proc999_4 62 134 104 160 gPEventX gPEventY) (lever1 handleEvent: 0))
					((proc999_4 29 134 61 160 gPEventX gPEventY) (lever1 handleEvent: 7))
					((proc999_4 105 134 139 160 gPEventX gPEventY) (lever1 handleEvent: 3))
					((proc999_4 62 104 104 133 gPEventX gPEventY) (lever1 handleEvent: 1))
					((proc999_4 62 161 104 189 gPEventX gPEventY) (lever1 handleEvent: 5))
					(else (super doVerb: theVerb &rest))
				)
			)
		)
	)
)

(instance ast0 of Asteroid
	(properties
		y 52
		noun 4
		d3x 100
		d3y 100
		oldD3x 100
		oldD3y 100
	)
)

(instance ast1 of Asteroid
	(properties
		y 59
		noun 5
		loop 2
		d3x 100
		d3y -100
		oldD3x 100
		oldD3y -100
	)
)

(instance ast2 of Asteroid
	(properties
		y 38
		noun 6
		loop 6
		d3y 300
		oldD3y 300
	)
)

(instance ast3 of Asteroid
	(properties
		y 43
		noun 7
		d3x -100
		d3y -100
		oldD3x -100
		oldD3y -100
	)
)

(instance ast4 of Asteroid
	(properties
		y 34
		noun 8
		loop 2
		d3x -150
		d3y 75
		oldD3x -150
		oldD3y 75
	)
)

(instance ast5 of Asteroid
	(properties
		y 50
		noun 9
		loop 6
		d3x 300
		d3y 200
		oldD3x 300
		oldD3y 200
	)
)

(instance ast6 of Asteroid
	(properties
		y 36
		noun 10
		d3x 200
		oldD3x 200
	)
)

(instance ast7 of Asteroid
	(properties
		y 22
		noun 11
		loop 2
		d3y -200
		oldD3y -200
	)
)

(instance ast8 of Asteroid
	(properties
		y 28
		noun 12
		loop 6
		d3x -200
		oldD3x -200
	)
)

(instance yourShip of FloatObj
	(properties
		y 60
		noun 20
		view 272
		loop 5
		d3y -200
	)
)

(instance cliffy of FloatObj
	(properties
		y 90
		noun 17
		view 272
		loop 1
		d3x 200
	)
)

(instance arm of Prop
	(properties
		x 319
		y 27
		noun 3
		view 269
		priority 6
		signal $5010
		cycleSpeed 12
	)
)

(instance claw of Prop
	(properties
		x 216
		y 81
		noun 15
		view 269
		loop 1
		priority 6
		signal $5010
		cycleSpeed 12
	)
)

(instance lever1 of Prop
	(properties
		x 54
		y 135
		noun 31
		view 270
		cel 1
		signal $4000
	)
	
	(method (doit &tmp [temp0 3])
		(if (!= local8 0) (localproc_06b6))
		(super doit: &rest)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(return
			(cond 
				(
					(and
						(not script)
						(gUser canControl:)
						(== (gSq5IconBar curIcon?) (gSq5IconBar at: 2))
						(proc999_4 29 104 139 189 gPEventX gPEventY)
						(not (IsObject pEvent))
					)
					(= temp0 pEvent)
					(self startUpd:)
					(hand1 startUpd:)
					(switch temp0
						(7
							(self x: 50 y: 135)
							(= temp1 1)
						)
						(3
							(self x: 59 y: 135)
							(= temp1 2)
						)
						(1
							(self x: 54 y: 130)
							(= temp1 3)
						)
						(5
							(self x: 54 y: 140)
							(= temp1 4)
						)
						(0
							(self x: 54 y: 135)
							(= temp1 0)
						)
					)
					(if (!= temp1 local8)
						(if (!= local8 0)
							(self x: 54 y: 135)
							(= local8 0)
						else
							(= local8 temp1)
						)
					)
					(self forceUpd: setScript: updateThrust)
					(return 1)
				)
				((IsObject pEvent) (super handleEvent: pEvent &rest))
			)
		)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(global2 doVerb: 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lever2 of View
	(properties
		x 270
		y 135
		noun 2
		view 270
		loop 1
		cel 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_1 87)
					(gTestMessager say: noun 4 2 0)
				else
					(global2 setScript: operateArm)
				)
			)
		)
	)
)

(instance hand1 of View
	(properties
		y 125
		noun 24
		view 270
		priority 15
		signal $4010
	)
	
	(method (doit)
		(self x: (- (lever1 x?) 54) y: (- (lever1 y?) 10))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(global2 doVerb: 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance hand2 of View
	(properties
		x 322
		y 124
		noun 28
		view 270
		loop 1
		priority 15
		signal $4010
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(lever2 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lthrust of Prop
	(properties
		x 144
		y 169
		noun 25
		view 271
		loop 8
		signal $4000
	)
	
	(method (doit)
		(cond 
			((== local8 1)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler)) (self setCycle: Beg))
		)
		(super doit: &rest)
	)
)

(instance rthrust of Prop
	(properties
		x 176
		y 169
		noun 30
		view 271
		loop 9
		signal $4000
	)
	
	(method (doit)
		(cond 
			((== local8 2)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler)) (self setCycle: Beg))
		)
		(super doit: &rest)
	)
)

(instance fthrust of Prop
	(properties
		x 156
		y 159
		noun 21
		view 271
		loop 10
		signal $4000
	)
	
	(method (doit)
		(cond 
			((== local8 3)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler)) (self setCycle: Beg))
		)
		(super doit: &rest)
	)
)

(instance bthrust of Prop
	(properties
		x 155
		y 175
		noun 13
		view 271
		loop 11
		signal $4000
	)
	
	(method (doit)
		(cond 
			((== local8 4)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler)) (self setCycle: Beg))
		)
		(super doit: &rest)
	)
)

(instance oxygen of Prop
	(properties
		x 125
		y 112
		noun 26
		view 271
		loop 1
		priority 15
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(self
			setCel: (if local22 (- (self lastCel:) 1) else 0)
		)
	)
)

(instance fuel of Prop
	(properties
		x 186
		y 112
		noun 22
		view 271
		priority 15
		signal $4010
	)
)

(instance cliffyBlip of Prop
	(properties
		noun 16
		view 272
		loop 3
		priority 7
		signal $4010
	)
)

(instance shipBlip of Prop
	(properties
		noun 19
		view 272
		loop 4
		priority 7
		signal $4010
	)
)

(instance target of Prop
	(properties
		view 272
		loop 7
		priority 14
		signal $4010
		detailLevel 3
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(Display
			@local28
			dsFONT
			gFont
			dsCOORD
			65
			25
			dsCOLOR
			global153
		)
	)
	
	(method (doit)
		(self x: (- (cliffy x?) 20) y: (- (cliffy y?) 34))
		(if local21
			(Display
				@local28
				dsFONT
				gFont
				dsCOORD
				65
				25
				dsCOLOR
				(if (= local1 (not local1)) global154 else global153)
			)
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(Display
			@local28
			dsFONT
			gFont
			dsCOORD
			65
			25
			dsCOLOR
			global151
		)
		(super dispose: &rest)
	)
)

(instance radar of Feature
	(properties
		y 10
		noun 27
		onMeCheck $0008
	)
)

(instance headsUp of Feature
	(properties
		y 5
		noun 23
		onMeCheck $0020
	)
)

(instance directions of Feature
	(properties
		y 200
		noun 18
		onMeCheck $0002
	)
)

(instance fuelF of Feature
	(properties
		y 100
		noun 22
		onMeCheck $0010
	)
)

(instance oxygenF of Feature
	(properties
		y 100
		noun 26
		onMeCheck $0004
	)
)

(instance clawButton of Feature
	(properties
		y 200
		noun 14
		nsTop 124
		nsLeft 203
		nsBottom 149
		nsRight 226
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					((proc0_1 87) (gTestMessager say: noun 4 2 0))
					((arm cel?) (arm setScript: operateClaw))
					(else (arm setScript: operateArm))
				)
			)
		)
	)
)

(instance operateArm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(lever2 startUpd:)
				(hand2 startUpd:)
				(= cycles 3)
			)
			(1
				(if (== (lever2 y?) 135)
					(lever2 y: 130)
					(hand2 y: 119)
				else
					(hand2 y: 124)
					(lever2 y: 135)
				)
				(= cycles 2)
			)
			(2
				(gSq5Music2 number: 106 loop: 1 play:)
				(if (== (lever2 y?) 130)
					(arm setCycle: CT 6 1 self)
					(lever2 y: 130)
					(hand2 y: 119)
				else
					(if (claw cel?)
						(claw setCycle: Beg self)
					else
						(= cycles 2)
					)
					(hand2 y: 124)
					(lever2 y: 135)
				)
			)
			(3
				(if (== (lever2 y?) 135)
					(claw dispose:)
					(arm setCel: 6 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(lever2 stopUpd:)
				(hand2 stopUpd:)
				(if (== (lever2 y?) 130)
					(claw init: stopUpd:)
					(arm setCel: 7)
				)
				(arm stopUpd:)
				(localproc_027c)
				(self dispose:)
			)
		)
	)
)

(instance operateClaw of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(claw startUpd:)
				(= cycles 2)
			)
			(1
				(gSq5Music2 number: 108 loop: 1 play:)
				(if (claw cel?)
					(if
						(and
							local18
							(<= 200 (cliffy x?))
							(<= (cliffy x?) 210)
						)
						(proc0_2 87)
						(= local21 0)
						(target dispose:)
						(claw setCel: (- (claw lastCel:) 1))
						(= cycles 2)
					else
						(claw setCycle: Beg self)
					)
				else
					(claw setCycle: End self)
				)
			)
			(2
				(if (proc0_1 87)
					(self setScript: getCliffy self)
				else
					(= cycles 1)
				)
			)
			(3
				(claw stopUpd:)
				(localproc_027c)
				(self dispose:)
			)
		)
	)
)

(instance getCliffy of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(claw setCel: (- (claw lastCel:) 1))
				(= cycles 2)
			)
			(1
				(proc0_10 192 100)
				(UnLoad 128 273)
				(cliffy
					view: 272
					loop: 1
					cel: 0
					setPri: (- (claw priority?) 1)
					stopUpd:
				)
				(gTestMessager say: 2 0 2 0 self)
			)
			(2
				(cliffy addToPic:)
				(claw addToPic:)
				(arm addToPic:)
				(hand2 addToPic:)
				(lever2 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance losingAir of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 20))
			(1
				(if (!= (oxygen cel?) (oxygen lastCel:))
					(oxygen setCel: (+ (oxygen cel?) 1))
					(if
					(and (> (oxygen cel?) 9) (!= (theMusic3 number?) 282))
						(theMusic3 number: 282 loop: -1 play:)
					)
					(= state -1)
				)
				(if (not (breathing state?)) (breathing seconds: 1))
				(= cycles 1)
			)
			(2
				(gSQ5 handsOff:)
				(gSq5Music1 fade: 0 10 5 1)
				(gSq5Music2 stop:)
				(switch local22
					(0
						(gTestMessager say: 26 0 3 0 self)
					)
					(1
						(gTestMessager say: 26 0 5 0 self)
					)
					(2
						(gTestMessager say: 26 0 4 0 self)
					)
				)
			)
			(3
				((gSq5IconBar at: 2) cursor: 982)
				(PalVary pvUNINIT)
				(aliens register: (if (== local22 2) 13 else 14))
				(global2 setScript: aliens)
				(self dispose:)
			)
		)
	)
)

(instance breathing of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* (- 14 (oxygen cel?)) 2))
			)
			(1
				(theMusic4 number: 550 loop: 1 play:)
				(= state (- state 2))
				(= seconds 1)
			)
		)
	)
)

(instance outOfFuel of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				((gSq5IconBar at: 2) cursor: 982)
				(gSq5Music1 fade: 0 10 5 1)
				(gSq5Music2 stop:)
				(PalVary pvINIT 48 5)
				(= register 30)
				(= cycles 1)
			)
			(1
				(= temp1 0)
				(while (< temp1 (gOldCast size?))
					(if
					((= temp0 (gOldCast at: temp1)) isKindOf: FloatObj)
						(if (not (if (== temp0 cliffy) (proc0_1 87)))
							(temp0 startUpd: y: (- (temp0 y?) 2))
						)
					)
					(++ temp1)
				)
				(if (-- register) (-- state))
				(= cycles 2)
			)
			(2
				(gTestMessager say: 22 0 3 0 self)
			)
			(3
				((gSq5IconBar at: 2) cursor: 982)
				(aliens register: 16)
				(PalVary pvUNINIT)
				(global2 setScript: aliens)
				(self dispose:)
			)
		)
	)
)

(instance startItAll of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 3)
			)
			(1
				(hand1 setCel: 2)
				(hand2 setCel: 2)
				(= cycles 3)
			)
			(2
				(localproc_027c)
				(self dispose:)
			)
		)
	)
)

(instance warning of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTestMessager say: 29 0 7 0 self)
				(= local20 1)
			)
			(1 (self dispose:))
		)
	)
)

(instance returnToEureka of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_10 193 50)
				(gTestMessager say: 29 0 6 0 self)
				(gSq5Music1 fade: 0 10 5 1)
			)
			(1
				((gSq5IconBar at: 2) cursor: 982)
				(= global137 2)
				(gSq5Music1 stop:)
				(gSq5Music2 stop:)
				(theMusic3 stop:)
				(global2 newRoom: 250)
			)
		)
	)
)

(instance shootingStar of Actor
	(properties
		x 233
		y 42
		view 570
		priority 1
		signal $6010
		moveSpeed 1
	)
)

(instance aliens of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music2 stop:)
				(theMusic3 stop:)
				(theMusic4 stop:)
				(gOldCast eachElementDo: #hide)
				(PalVary pvUNINIT)
				(= cycles 3)
			)
			(1
				(gOldCast eachElementDo: #dispose)
				(global2 drawPic: 56 -32758)
				(= seconds 3)
			)
			(2
				(shootingStar
					init:
					setCycle: Fwd
					setMotion: MoveTo 153 167 self
				)
			)
			(3
				(gTestMessager say: 1 2 1 0 self)
			)
			(4 (proc0_9 register))
		)
	)
)

(instance alien1Tkr of Narrator
	(properties
		talkWidth 100
	)
	
	(method (init)
		(= gSq5Win gNewSpeakWindow)
		(= font gFont)
		(gSq5Win tailX: 80 xOffset: -20 tailY: 80 isBottom: 1)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance alien2Tkr of Narrator
	(properties
		talkWidth 100
	)
	
	(method (init)
		(= gSq5Win gNewSpeakWindow)
		(= font gFont)
		(gSq5Win tailX: 180 xOffset: 20 isBottom: 1 tailY: 80)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)
