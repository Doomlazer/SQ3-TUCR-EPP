;;; Sierra Script 1.0 - (do not remove this comment)
(script# 31)
(include sci.sh)
(use Main)
(use VelocityMover)
(use Scaler)
(use CueObj)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	genetix 0
	proc31_1 1
	proc31_2 2
	sGenInNout 3
)

(local
	[local0 11] = [354 259 6 126 -20 -20 16 90 281 280 99]
	[local11 11] = [120 103 123 104 128 150 100 53 126 43 99]
	[local22 11] = [760 740 790 730 760 730 740 790 730 730 99]
)
(procedure (proc31_1 param1 param2)
	(gEgo
		view: 600
		init:
		signal: 12290
		posn: param1 param2
		moveSpeed: 0
		ignoreActors: 1
		illegalBits: 0
		setLoop: 1
		setPri: 15
		cycleSpeed: 2
		setStep: 7 7
		setCycle: Fwd
		setMotion: VelocityMover param1 param2 0 0
		looper: 0
	)
	(switch (global2 picture?)
		(116
			(gEgo
				scaleSignal: (| (gEgo scaleSignal?) $0004)
				setScale: Scaler 64 17 139 24
			)
		)
		(112
			(gEgo
				scaleSignal: (| (gEgo scaleSignal?) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 8 8
			)
		)
		(110
			(gEgo
				scaleSignal: (| (gEgo scaleSignal?) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 3 3
				moveSpeed: 1
			)
		)
		(113
			(gEgo
				scaleSignal: (| (gEgo scaleSignal?) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 3 3
				moveSpeed: 0
			)
		)
	)
)

(procedure (proc31_2 param1 &tmp temp0 temp1 temp2)
	(= temp1
		(switch
			(= temp0
				(cond 
					((< 150 param1) 120)
					((< 100 param1) 33)
					((< 59 param1) 32)
					(else 31)
				)
			)
			(31 17)
			(32 17)
			(33 17)
			(120 70)
		)
	)
	(= temp2
		(switch temp0
			(31
				(if (proc999_5 (global2 picture?) 112 116) 9 else 13)
			)
			(32
				(if (proc999_5 (global2 picture?) 112 116) 9 else 13)
			)
			(33 13)
			(120 15)
		)
	)
	(gEgo setScale: Scaler temp0 temp1 167 80 setPri: temp2)
)

(class genetix of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
	)
	
	(method (dispose)
		(gSq5Music1 stop:)
		(gSq5Music2 stop:)
		(super dispose: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 730 740 750 760 770 790)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sGenInNout of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo [local0 register] [local11 (gSQ5 handsOff:)] self
				)
			)
			(1
				(if
					(and
						(proc0_1 23)
						(proc999_5 (global2 curPic?) 110 112 113)
					)
					(= seconds 2)
				else
					(= cycles 2)
				)
			)
			(2
				(if (== global2 [local22 register])
					(gSQ5 handsOn:)
					(self dispose:)
				else
					(gSQ5 handsOn:)
					(global2 newRoom: [local22 register])
				)
			)
		)
	)
)

(class MyFeature of Feature
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
	)
	
	(method (init &tmp theOnMeCheck)
		(= theOnMeCheck onMeCheck)
		(super init:)
		(self setOnMeCheck: 1 theOnMeCheck)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?) (return 1))
				((not (proc0_1 22)) (super handleEvent: pEvent &rest))
				(
					(and
						(& (pEvent type?) evVERB)
						(self onMe: pEvent)
						(self isNotHidden:)
						(proc0_1 22)
					)
					(pEvent claimed: 1)
					(self doVerb: (pEvent message?))
					(return (pEvent claimed?))
				)
			)
		)
	)
)

(class MyProp of Prop
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
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?) (return 1))
				((not (proc0_1 22)) (super handleEvent: pEvent &rest))
				(
					(and
						(& (pEvent type?) evVERB)
						(self onMe: pEvent)
						(self isNotHidden:)
						(proc0_1 22)
					)
					(pEvent claimed: 1)
					(self doVerb: (pEvent message?))
					(return (pEvent claimed?))
				)
			)
		)
	)
)

(class MyActor of Actor
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
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?) (return 1))
				((not (proc0_1 22)) (super handleEvent: pEvent &rest))
				(
					(and
						(& (pEvent type?) evVERB)
						(self onMe: pEvent)
						(self isNotHidden:)
						(proc0_1 22)
					)
					(pEvent claimed: 1)
					(self doVerb: (pEvent message?))
					(return (pEvent claimed?))
				)
			)
		)
	)
)

(instance cliffy of MyActor
	(properties
		noun 1
		view 20
		signal $4000
	)
)
