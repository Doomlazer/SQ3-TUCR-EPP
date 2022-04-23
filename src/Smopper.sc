;;; Sierra Script 1.0 - (do not remove this comment)
(script# 17)
(include sci.sh)
(use Main)
(use PFollow)
(use Cycle)
(use Obj)

(public
	Smopper 0
)

(local
	[local0 8] = [2 6 4 0 3 5 1 7]
	[local8 8] = [3 6 0 4 2 5 1 7]
)
(class Smopper of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		vInMotion 0
		vStopped 0
		vSlow 0
		vStart 0
		stopState 0
		useSlow 0
		cSpeed 0
		oldSpeed 0
		newCel 0
		tempMover 0
	)
	
	(method (init theClient theVStopped theVSlow theVStart theCSpeed theCaller)
		(= useSlow
			(= cycleCnt
				(= vSlow (= vStart (= vStopped (= caller 0))))
			)
		)
		(= cSpeed ((= client theClient) cycleSpeed?))
		(= oldSpeed ((= client theClient) cycleSpeed?))
		(if argc
			(= vInMotion ((= client theClient) view?))
			(if (>= argc 2)
				(= vStopped theVStopped)
				(if (>= argc 3)
					(= vSlow theVSlow)
					(if (>= argc 4)
						(if (== theVStart -1)
							(= useSlow 1)
							(= vStart vSlow)
						else
							(= vStart theVStart)
						)
						(if (>= argc 5)
							(if (!= theCSpeed -1) (= cSpeed theCSpeed))
							(if (>= argc 6) (= caller theCaller))
						)
					else
						(= useSlow 1)
						(= vStart vSlow)
					)
				)
			)
		)
		(if (client isStopped:)
			(if vSlow (= stopState 1) else (= stopState 3))
		else
			(= stopState 7)
		)
		(super init: client)
	)
	
	(method (doit &tmp temp0 clientMover [temp2 10])
		(cond 
			(
				(or
					(client isStopped:)
					(client isBlocked:)
					(not (client mover?))
				)
				(if (== (client view?) vInMotion)
					(cond 
						((and vSlow (proc999_5 stopState 0)) (= stopState 1))
						(
							(and
								vSlow
								(== stopState 4)
								(== vStopped -1)
								(!= (client loop?) (- (NumLoops client) 1))
							)
							(= stopState 1)
						)
						((and (not vSlow) (proc999_5 stopState 0)) (= stopState 3))
						((not (proc999_5 stopState 2 3 1)) (= stopState 4))
					)
					(if
						(and
							(= clientMover (client mover?))
							(not (clientMover completed?))
							(not (clientMover isKindOf: PFollow))
						)
						(client setMotion: 0)
					)
				)
			)
			((proc999_5 stopState 4 2 3 1) (if vStart (= stopState 5) else (= stopState 7)))
		)
		(switch stopState
			(0
				(= cycleDir 1)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:)) (= newCel 0))
				(client cel: newCel)
			)
			(1
				(= cycleDir 1)
				(if (not vSlow)
					(if (!= vStopped -1) (client view: vStopped))
					(= stopState 3)
				else
					(= stopState 2)
					(if (== (client view?) vInMotion)
						(= newCel 0)
						(client cel: 0)
					)
					(client cycleSpeed: cSpeed view: vSlow)
				)
			)
			(2
				(client cycleSpeed: cSpeed)
				(client cel: newCel forceUpd:)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:))
					(= newCel 0)
					(= stopState 3)
				)
			)
			(3
				(client cycleSpeed: cSpeed)
				(= stopState 4)
				(= cycleDir 1)
				(if (== vStopped -1)
					(client view: vInMotion cel: (client loop?))
					(client loop: (- (NumLoops client) 1))
				else
					(client view: vStopped cel: 0)
				)
				(if caller (caller cue: 0))
			)
			(4
				(if (!= vStopped -1)
					(client cycleSpeed: cSpeed)
					(if (client lastCel:)
						(= newCel (self nextCel:))
						(if (> newCel (client lastCel:)) (= newCel 0))
						(client cel: newCel)
					else
						0
					)
				)
			)
			(5
				(if caller (caller cue: 1))
				(if (not vStart)
					(client view: vInMotion)
					(= stopState 7)
				else
					(= stopState 6)
					(if (== vStopped -1) (client loop: (client cel?)))
					(if useSlow
						(= cycleDir -1)
						(client cel: (client lastCel:) view: vSlow)
					else
						(= cycleDir 1)
						(client cel: 0 view: vStart)
					)
					(client cycleSpeed: cSpeed)
				)
			)
			(6
				(client cycleSpeed: cSpeed)
				(if useSlow
					(if (not newCel)
						(= stopState 7)
					else
						(client cel: newCel)
					)
					(= newCel (self nextCel:))
				else
					(= newCel (self nextCel:))
					(if (> newCel (client lastCel:))
						(= stopState 7)
					else
						(client cel: newCel)
					)
				)
			)
			(7
				(= stopState 0)
				(= cycleDir 1)
				(if (client mover?)
					(= cycleCnt ((client mover?) b-moveCnt?))
				)
				(if (== vStopped -1)
					(client setLoop: -1)
					(if (== (client loop?) (- (NumLoops client) 1))
						(client
							view: vInMotion
							loop: [local8 (/ (client heading?) 45)]
						)
					)
				)
				(= oldSpeed gGEgoMoveSpeed)
				(client view: vInMotion cycleSpeed: oldSpeed cel: 0)
			)
		)
	)
	
	(method (dispose)
		(client cycleSpeed: oldSpeed)
		(if (IsObject client) (client cycler: 0))
		(self client: 0)
		(super dispose: &rest)
	)
)
