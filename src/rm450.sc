;;; Sierra Script 1.0 - (do not remove this comment)
(script# 450)
(include sci.sh)
(use Main)
(use Print)
(use Blink)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm450 0
	genTalker 15
	pTalker 19
)

(instance rm450 of Rm
	(properties
		picture 84
		style $000a
	)
	
	(method (init)
		(gEgo view: 0 init: hide: stopUpd:)
		(switch gGModNum
			(420
				(global2 setScript: sInitRoom)
			)
			(else 
				(global2 setScript: sInitRoom)
			)
		)
		(super init:)
		(gSQ5 handsOff:)
	)
	
	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sInitRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(pHead init:)
				(pArm init:)
				(= cycles 1)
			)
			(1 (= seconds 3))
			(2
				(pHead setLoop: 0 cycleSpeed: 15 setCycle: CT 2 1 self)
			)
			(3
				(gTestMessager say: 1 0 0 0 self)
			)
			(4 (= seconds 2))
			(5 (pArm cel: 1) (= seconds 1))
			(6
				(gTestMessager say: 1 0 1 0 self)
			)
			(7
				(pArm cel: 0)
				(pHead cel: 3)
				(= seconds 2)
			)
			(8 (global2 newRoom: 420))
		)
	)
)

(instance pHead of Actor
	(properties
		x 143
		y 70
		view 460
	)
)

(instance pArm of Actor
	(properties
		x 118
		y 153
		view 460
		loop 1
	)
)

(instance pTalker of Talker
	(properties
		x 134
		y 36
		view 460
		cel 2
		talkWidth 200
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 120
			tailY: 36
			xOffset: -5
			isBottom: 1
		)
		(self cel: 2 loop: 0)
		(super init: 0 pEyes pMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
	
	(method (display theText &tmp theTalkWidth newGSq5Win)
		(= theTalkWidth talkWidth)
		((= newGSq5Win (gSq5Win new:)) color: color back: back)
		(if
		(and (not (HaveMouse)) (!= gCursorNumber 996))
			(= saveCursor gCursorNumber)
			(gSQ5 setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if showTitle (Print addTitle: name))
		(Print
			window: newGSq5Win
			posn: x y
			font: font
			width: theTalkWidth
			addText: theText
			modeless: 1
			init:
		)
	)
)

(instance pEyes of Actor
	(properties
		nsTop 11
		nsLeft 31
		view 460
		loop 2
		cel 1
		priority 6
		signal $0010
	)
)

(instance pMouth of Actor
	(properties
		nsTop 34
		nsLeft 30
		view 460
		loop 3
		cel 4
		priority 6
		signal $4010
	)
)

(instance genTalker of Narrator
	(properties
		talkWidth 200
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(switch global122
			(19
				(gSq5Win tailX: 160 tailY: 180 xOffset: 0 isBottom: 1)
			)
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)
