;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use Cycle)
(use Obj)


(local
	[local0 8] = [7 9 11 13 0 2 3 5]
)
(class GravMover of Motion
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		curHeading 0
		b-moveCnt2 0
		theSpeed 0
	)
	
	(method (init theClient theCurHeading theY)
		(if argc
			(= client theClient)
			(if (> argc 1)
				(if (== argc 2)
					(= curHeading theCurHeading)
					(self setTarget:)
					(= theSpeed
						(/ (GetDistance x y (client x?) (client y?)) 10)
					)
				else
					(= curHeading
						(GetAngle (client x?) (client y?) theCurHeading theY)
					)
					(= x theCurHeading)
					(= y theY)
					(= theSpeed (GetDistance x y (client x?) (client y?)))
					(self setTarget:)
				)
			else
				(= curHeading (client heading?))
				(self setTarget:)
				(= theSpeed
					(/ (GetDistance x y (client x?) (client y?)) 10)
				)
			)
		)
		(= b-moveCnt2 (+ 1 theSpeed gLastTicks))
		(super init:)
	)
	
	(method (doit &tmp [temp0 8])
		(if (>= (Abs (- gLastTicks b-moveCnt2)) theSpeed)
			(= b-moveCnt2 gLastTicks)
			(if dx
				(if (> dx 0) (-- dx) else (++ dx))
			else
				(= dx (- (Random 1 3) 2))
			)
			(if dy
				(if (> dy 0) (-- dy) else (++ dy))
			else
				(= dy (- (Random 1 3) 2))
			)
		)
		(if
		(>= (Abs (- gLastTicks b-moveCnt)) (client moveSpeed?))
			(= b-moveCnt gLastTicks)
			(DoBresen self)
		)
	)
	
	(method (setTarget)
		(= x (+ (client x?) (SinMult curHeading 500)))
		(= y (- (client y?) (CosMult curHeading 500)))
	)
	
	(method (onTarget)
		(return 0)
	)
)

(class SpecialLooper of Code
	(properties
		oldDir -1
		client 0
		oldMover 0
	)
	
	(method (init theClient)
		(= client theClient)
		(client looper: self)
	)
	
	(method (doit theClient theOldDir)
		(= client theClient)
		(if (!= theOldDir oldDir)
			(client heading: theOldDir)
			(if
			(< [local0 (/ theOldDir 45)] [local0 (/ oldDir 45)])
				(client setCycle: CT [local0 (/ theOldDir 45)] -1)
			else
				(client setCycle: CT [local0 (/ theOldDir 45)] 1)
			)
			(= oldDir theOldDir)
		)
	)
	
	(method (dispose)
		(if client (client looper: 0))
		(super dispose:)
	)
)

(class SpecialCycler of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		theCycleSpeed 6
		isMover 0
	)
	
	(method (doit &tmp specialCyclerNextCel)
		(cond 
			(
				(and
					(not isMover)
					(client mover?)
					(< (+ ((client mover?) dx?) ((client mover?) dy?)) 3)
				)
				(= isMover 1)
				(= cycleDir (if (Random 0 1) 1 else -1))
				(= theCycleSpeed (Random 3 15))
			)
			(
				(and
					(client mover?)
					(>=
						(+ ((client mover?) dx?) ((client mover?) dy?))
						3
					)
				)
				(= theCycleSpeed
					(-
						15
						(+ ((client mover?) dx?) ((client mover?) dy?))
					)
				)
				(= isMover 0)
			)
		)
		(if
			(or
				(>
					(= specialCyclerNextCel (self nextCel:))
					(client lastCel:)
				)
				(< specialCyclerNextCel 0)
			)
			(self cycleDone: specialCyclerNextCel)
		else
			(client cel: specialCyclerNextCel)
		)
	)
	
	(method (nextCel)
		(return
			(if
			(< (Abs (- gLastTicks cycleCnt)) theCycleSpeed)
				(client cel?)
			else
				(= cycleCnt gLastTicks)
				(+ (client cel?) cycleDir)
			)
		)
	)
	
	(method (cycleDone param1)
		(if (> param1 (client lastCel:))
			(client cel: 0)
		else
			(client cel: (client lastCel:))
		)
	)
)
