;;; Sierra Script 1.0 - (do not remove this comment)
(script# 984)
(include sci.sh)
(use Main)
(use Print)
(use Cycle)


(class RegionPath of MoveTo
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
		completed 1
		xLast 0
		yLast 0
		currentRoom 0
		value -1
		endType 1
		intermediate 0
		initialized 0
		savedOldStuff 0
		theRegion 0
		theOldBits 0
		theOldSignal 0
	)
	
	(method (init theClient theCaller theIntermediate)
		(if (>= argc 4)
			(= value -1)
			(= initialized 0)
			(= completed 1)
		)
		(if completed
			(if argc
				(= client theClient)
				(if (>= argc 2)
					(= caller theCaller)
					(if (>= argc 3) (= intermediate theIntermediate))
				)
			)
			(if (not initialized)
				(if (not savedOldStuff)
					(= theOldBits (client illegalBits?))
					(= theOldSignal (client signal?))
					(= savedOldStuff 1)
				)
				(if (& endType $0002)
					(self findPathend: next:)
					(client posn: x y)
				else
					(self value: 0 nextRoom:)
				)
				(= initialized 1)
				(client illegalBits: 0 ignoreActors: ignoreHorizon:)
			)
			(= completed 0)
			(self next:)
		)
		(super init:)
		(self curRoomCheck:)
	)
	
	(method (dispose)
		(if theRegion
			(if (not ((ScriptID theRegion) keep?))
				(super dispose:)
			)
		else
			(proc921_1 {%s theRegion: not defined.} name)
		)
	)
	
	(method (moveDone)
		(= completed 1)
		(if (self atEnd:)
			(self value: -1 initialized: 0)
			(if (& endType $0001)
				(self init:)
			else
				(super moveDone:)
			)
		else
			(if intermediate (intermediate cue: (/ value 2)))
			(if (== (self at: (self nextValue:)) 32767)
				(self next: nextRoom:)
			)
			(self init:)
		)
	)
	
	(method (next)
		(= x (self at: (self nextValue: 1)))
		(= y (self at: (+ value 1)))
	)
	
	(method (atEnd)
		(return
			(if (and (& endType $0002) (<= (- value 2) 0))
			else
				(== (self at: (+ value 2)) -32768)
			)
		)
	)
	
	(method (nextRoom)
		(if (& endType $0002)
			(self findPrevroom:)
		else
			(= currentRoom (self at: (+ value 1)))
		)
		(self next: curRoomCheck:)
		(client posn: x y)
	)
	
	(method (at)
		(proc921_1 {%s needs an 'at:' method.} name)
		(return 0)
	)
	
	(method (nextValue &tmp temp0)
		(= temp0 (- (* (not (& endType $0002)) 4) 2))
		(return
			(if argc
				(return (= value (+ value temp0)))
			else
				(return (+ value temp0))
			)
		)
	)
	
	(method (findPathend)
		(= value 0)
		(while (!= (self at: value) -32768)
			(if (== (self at: value) 32767)
				(= currentRoom (self at: (+ value 1)))
			)
			(++ value)
		)
	)
	
	(method (findPrevroom &tmp temp0)
		(= temp0 0)
		(while (< temp0 value)
			(if (== (self at: temp0) 32767)
				(= currentRoom (self at: (+ temp0 1)))
			)
			(++ temp0)
		)
	)
	
	(method (curRoomCheck &tmp clientZ)
		(= clientZ (client z?))
		(if (== currentRoom gModNum)
			(client
				z: (if (>= clientZ 1000) (- clientZ 1000) else clientZ)
				illegalBits: theOldBits
				signal: theOldSignal
			)
		else
			(client
				z: (if (< clientZ 1000) (+ clientZ 1000) else clientZ)
				illegalBits: 0
				ignoreActors: 1
				ignoreHorizon:
			)
		)
	)
)
