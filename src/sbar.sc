;;; Sierra Script 1.0 - (do not remove this comment)
(script# 505)
(include sci.sh)
(use Main)
(use Game)
(use Obj)

(public
	sbar 0
)

(class sbar of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		state $0000
	)
	
	(method (init)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (and (proc0_1 54) (not (self script?)))
			(self setScript: sWarningTimer)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep (proc999_5 newRoomNumber 500 510 520 530))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sWarningTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 100))
			(1
				(gTestMessager say: 1 0 0 1 self 501)
			)
			(2 (= seconds 50))
			(3
				(gTestMessager say: 1 0 0 2 self 501)
			)
			(4 (= seconds 50))
			(5
				(gTestMessager say: 1 0 0 3 self 501)
			)
			(6 (= seconds 50))
			(7 (global2 newRoom: 550))
		)
	)
)
