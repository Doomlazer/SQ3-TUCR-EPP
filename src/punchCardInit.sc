;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2000)
(include sci.sh)
(use Main)
(use Inset)
(use View)
(use Obj)

(public
	punchCardInit 0
)

(local
	local0
	local1
	local2 =  10
)
(procedure (localproc_0036 &tmp temp0 temp1)
	(if
	(> 0 (= temp0 (- gPEventX (+ 5 (punchCard x?)))))
		(return -1)
	)
	(if (> (/ temp0 20) 2) (return -1))
	(= temp1 (/ temp0 20))
	(if
	(> 0 (= temp0 (- gPEventY (+ 5 (punchCard y?)))))
		(return -1)
	)
	(if (> (/ temp0 15) 2) (return -1))
	(return (+ (* (= temp0 (/ temp0 15)) 3) temp1))
)

(procedure (localproc_0097 param1)
	(= local1 (mod param1 3))
	(return (+ 5 (punchCard x?) (* (mod param1 3) 20)))
)

(procedure (localproc_00b4 param1)
	(= local0 (/ param1 3))
	(return (+ 5 (punchCard y?) (* (/ param1 3) 15)))
)

(procedure (localproc_00ff &tmp temp0)
	(= temp0 0)
	(while (< temp0 9)
		(if (& global129 (<< $0001 temp0))
			(DrawCel
				616
				1
				1
				(localproc_0097 temp0)
				(localproc_00b4 temp0)
				15
			)
		)
		(++ temp0)
	)
	(Graph
		grUPDATE_BOX
		(+ 5 (punchCard y?))
		(+ 5 (punchCard x?))
		(+ 5 (punchCard y?) 45)
		(+ 5 (punchCard x?) 60)
		1
	)
)

(procedure (localproc_0171 param1)
	(= global129 (| global129 (<< $0001 param1)))
	(localproc_00ff)
)

(instance punchCardInit of Code
	(properties)
	
	(method (doit)
		(if (not (global2 inset:))
			(global2 setInset: punchCard hl)
		)
	)
)

(instance punchCard of Inset
	(properties
		view 616
		x 110
		y 55
		priority 13
	)
	
	(method (init)
		(gUser canControl: 0 canInput: 0)
		(super init: &rest)
		(proc0_10 238 5)
		(hl init:)
		(theExit init:)
	)
	
	(method (doit)
		(if (GameIsRestarting)
			(localproc_00ff)
			(if oldCast (oldCast eachElementDo: #forceUpd))
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(gUser canControl: 1 canInput: 1)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(33
				(if (!= (= temp0 (localproc_0036)) -1)
					(localproc_0171 temp0)
				)
			)
		)
	)
)

(instance hl of Prop
	(properties
		x 110
		y 55
		view 616
		loop 2
		priority 14
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
	)
	
	(method (doit &tmp temp0)
		(if (< local2 1)
			(if (not local2)
				(= local2 -1)
				(localproc_00ff)
				(gUser canControl: 1 canInput: 1)
				(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
			)
		else
			(-- local2)
		)
		(if (!= (= temp0 (localproc_0036)) -1)
			(self
				x: (localproc_0097 temp0)
				y: (localproc_00b4 temp0)
			)
			(if (& global129 (<< $0001 temp0))
				(self cel: 1)
			else
				(self cel: 0)
			)
		)
		(super doit: &rest)
	)
	
	(method (cue)
		(UnLoad 128 616)
		(DisposeScript 2000)
	)
)

(instance theExit of View
	(properties
		x 146
		y 108
		view 616
		loop 3
		priority 14
		signal $4011
	)
	
	(method (doVerb &tmp temp0)
		(punchCard dispose:)
	)
)
