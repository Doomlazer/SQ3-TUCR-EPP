;;; Sierra Script 1.0 - (do not remove this comment)
(script# 976)
(include sci.sh)
(use Main)
(use Class_255_0)
(use View)
(use Obj)


(class Cat of Actor
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
		top -1
		left -1
		bottom -1
		right -1
		diagonal 0
		doCast 0
		outOfTouch 1
		caller 0
		active 0
		dx 0
		dy 0
	)
	
	(method (doit &tmp gUserCurEvent)
		(cond 
			((not doCast) (= active 0))
			(active
				(= gUserCurEvent (gUser curEvent?))
				(self
					posn: (+ (gUserCurEvent x?) dx) (+ (gUserCurEvent y?) dy) z
				)
			)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			(
			(and active (== (pEvent type?) evMOUSERELEASE))
				(= active 0)
				(pEvent claimed: 1)
				(LocalToGlobal pEvent)
				(self posn: (+ (pEvent x?) dx) (+ (pEvent y?) dy) z)
				(GlobalToLocal pEvent)
				(if caller (caller cue: self))
			)
			((proc255_2 self pEvent) (pEvent claimed: 1) (self track: pEvent))
		)
	)
	
	(method (posn theX theY theZ &tmp temp0)
		(if argc
			(= x theX)
			(if (>= argc 2)
				(= y theY)
				(if (>= argc 3) (= z theZ))
			)
		)
		(= temp0 (proc999_0 diagonal))
		(if
			(not
				(if
				(and (== -1 top) (== top bottom) (== bottom left))
					(== left right)
				)
			)
			(switch (Abs diagonal)
				(1
					(= y
						(+
							(if (> temp0 0) top else bottom)
							(/
								(* (- right x) (- bottom top) temp0)
								(- right left)
							)
						)
					)
				)
				(2
					(= x
						(+
							(if (> temp0 0) left else right)
							(/
								(* (- bottom y) (- right left) temp0)
								(- bottom top)
							)
						)
					)
				)
			)
			(= x (proc999_3 left (proc999_2 right x)))
			(= y (proc999_3 top (proc999_2 bottom y)))
		)
		(super posn: x y z)
	)
	
	(method (canBeHere)
		(return 1)
	)
	
	(method (findPosn)
		(return 1)
	)
	
	(method (track param1 &tmp newCollect)
		(LocalToGlobal param1)
		(= dx (- x (param1 x?)))
		(= dy (- y (param1 y?)))
		(if doCast
			(= active 1)
		else
			((= newCollect (Collect new:)) add: self)
			(while
				(and
					(!= 2 (param1 type?))
					(or
						outOfTouch
						(proc255_2 self (param1 type: 1 yourself:))
					)
				)
				(self posn: (+ (param1 x?) dx) (+ (param1 y?) dy) z)
				(Animate (newCollect elements?) 1)
				(GetEvent 32767 param1)
			)
			(newCollect release: dispose:)
			(if caller (caller cue: self))
			(GlobalToLocal param1)
		)
	)
)
