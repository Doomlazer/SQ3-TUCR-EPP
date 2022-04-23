;;; Sierra Script 1.0 - (do not remove this comment)
(script# 100)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm100 0
)

(local
	[local0 2]
)
(instance myDialog of Dialog
	(properties)
	
	(method (handleEvent)
		(Palette palANIMATE 96 218 -1)
		(super handleEvent: &rest)
	)
)

(instance rm100 of Rm
	(properties
		picture 300
	)
	
	(method (init)
		(Palette palSET_FROM_RESOURCE 999 2)
		(if gDialog (gDialog dispose:))
		(super init:)
		(gOldMH addToFront: self)
		(gOldKH addToFront: self)
		(gSQ5 setCursor: 996 1)
		(gSq5IconBar hide: disable:)
		(gUser canInput: 1)
		(self setScript: rmScript)
	)
	
	(method (dispose)
		(gSq5IconBar hide: enable:)
		(= global20 999)
		(Palette palSET_FROM_RESOURCE 999 2)
		(gSQ5 setCursor: 996 1)
		(gOldKH delete: self)
		(gOldMH delete: self)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(!= (rmScript state?) 4)
				(& (pEvent type?) $4005)
			)
			(rmScript changeState: 4)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(Palette palANIMATE 96 218 -1)
		(super doit: &rest)
	)
	
	(method (changeState newState &tmp temp0 [temp1 10])
		(switch (= state newState)
			(0
				(gSq5Music1 number: 1001 loop: 1 play:)
				(sparkle init:)
				(= seconds 4)
			)
			(1
				(if (== (gSq5Music1 prevSignal?) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(if (== (gSq5Music1 prevSignal?) 30)
					(sparkle x: 60 y: 145 loop: 1 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3 (= seconds 3))
			(4
				(gSq5Music1 stop:)
				(sparkle hide:)
				(= cycles 5)
			)
			(5
				(sparkle dispose:)
				(= seconds 0)
				(= global20 999)
				(gSQ5 setCursor: 999 1)
				(Print
					dialog: myDialog
					font: gFont
					width: 150
					mode: 1
					addText: 8 1 0 4 0 0 0
					addText: 8 1 0 5 0 10 0
					addColorButton: 0 8 1 0 6 0 30 0 0 15 23 5 5 5
					addColorButton: 1 8 1 0 1 0 40 0 0 15 23 5 5 5
					addColorButton: 2 8 1 0 2 0 50 0 0 15 23 5 5 5
				)
				(switch
					(= temp0
						(Print
							addColorButton: 4 8 1 0 7 0 60 0 0 15 23 5 5 5
							addColorButton: 3 8 1 0 3 0 70 0 0 15 23 5 5 5
							init:
						)
					)
					(0 (global2 newRoom: 104))
					(1 (global2 newRoom: 110))
					(2
						(gSQ5 restore:)
						(self changeState: state)
					)
					(3 (= global4 1))
					(4
						(= state (- state 2))
						(gTestMessager say: 1 0 0 0 self 100)
					)
					(5
						(= temp1 0)
						(= temp0
							(Print
								addText: {Which room do you want?}
								addText: {Other} 110 25
								addEdit: @temp1 6 115 35
								posn: 50 30
								addButton: 100 {Start 100} 5 35
								init:
							)
						)
						(if temp1
							(= temp0 (ReadNumber @temp1))
							(global2 newRoom: temp0)
						else
							(self changeState: state)
						)
					)
				)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 121
		y 54
		view 3001
		priority 15
		signal $0010
	)
)
