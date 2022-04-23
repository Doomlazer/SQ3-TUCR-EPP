;;; Sierra Script 1.0 - (do not remove this comment)
(script# 104)
(include sci.sh)
(use Main)
(use PriorityTalker)
(use Osc)
(use RandCycle)
(use MoveFwd)
(use n958)
(use Grooper)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm104 0
	quirkTalker 14
	proc104_15 15
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 =  160
	local7 =  100
	local8 =  4
	local9
	local10 =  6
	local11
	local12
	[local13 200]
	[local213 200]
	local413
	local414
	local415 =  1
	local416 =  6
	local417
	local418
	local419
	local420
	local421
	local422
	[local423 15] = [2 2 2 2 2 2 2 2 3 2 2 2 2 2 2]
	[local438 15] = [2 2 2 2 2 2 2 0 0 0 1 1 1 1 1]
	[local453 15] = [146 152 161 170 186 213 230 240 258 253 229 196 154 114 75]
	[local468 15] = [88 82 77 68 55 32 22 22 20 28 24 45 75 115 134]
	[local483 15] = [33 43 38 43 53 78 83 128 128 128 60 80 91 103 128]
)
(procedure (proc104_15)
)

(instance rm104 of Rm
	(properties
		picture 1
		style $800a
	)
	
	(method (init)
		(proc958_0 128 97 99 100 101 102 103)
		(proc958_0 129 1 5 7 8)
		(super init:)
		(global2 setScript: sGo)
		(gOldKH addToFront: self)
		(gOldMH addToFront: self)
	)
	
	(method (doit)
		(switch local417
			(1
				(Palette
					palANIMATE
					224
					226
					1
					226
					228
					1
					228
					230
					1
					232
					234
					1
					234
					236
					1
					240
					241
					1
					128
					144
					1
				)
			)
			(2
				(Palette palANIMATE 236 238 10)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DrawPic 0 dpOPEN_NO_TRANSITION dpCLEAR)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (global2 script?) sCaptainsLog)
				(== (sCaptainsLog state?) 0)
				(& (pEvent type?) $4005)
			)
			(sCaptainsLog changeState: 1)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gOldKH delete: self)
		(gOldMH delete: self)
		(FlushResources newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance sWaitNow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 0 7)))
			(1 (self dispose:))
		)
	)
)

(instance sGo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music1 number: 1 setLoop: -1 play:)
				(= seconds 3)
			)
			(1
				(space init: setCycle: CT 3 1 self)
			)
			(2 (= seconds 2))
			(3
				(Message msgGET 104 3 0 0 1 @local13)
				(Display
					@local13
					dsCOORD
					65
					180
					dsCOLOR
					207
					dsFONT
					1605
					dsWIDTH
					200
				)
				(= seconds 3)
			)
			(4
				(Display
					@local13
					dsCOORD
					65
					180
					dsCOLOR
					1
					dsFONT
					1605
					dsWIDTH
					200
				)
				(= seconds 3)
			)
			(5
				(theComet init:)
				(space setCycle: CT 10 1)
				(= local421 1)
				(= cycles 1)
			)
			(6
				(theComet
					setLoop: [local423 local421]
					setCel: [local438 local421]
					x: [local453 local421]
					y: [local468 local421]
					scaleX: [local483 local421]
					scaleY: [local483 local421]
				)
				(if (== (++ local421) 8) (theComet setPri: 15))
				(if (< local421 15)
					(if (== local421 8) (space setCycle: CT 9 -1))
					(-- state)
				)
				(= ticks 5)
			)
			(7
				(theComet dispose:)
				(space setCycle: End self)
			)
			(8
				(space dispose:)
				(= local417 1)
				(Palette palSET_INTENSITY 1 175 0)
				(Palette palSET_INTENSITY 240 242 0)
				(Palette palSET_INTENSITY 182 208 0)
				(= cycles 5)
			)
			(9
				(head init:)
				(lArm init:)
				(rArm init:)
				(ego1 init:)
				(ego1 addToPic:)
				(lArm addToPic:)
				(rArm addToPic:)
				(head addToPic:)
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(10
				((medStar new:) init:)
				((slowStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(11
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(12
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(13
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(14
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(15
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(16
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(17
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(18
				((commetStar new:) init:)
				((medStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(19
				((commetStar new:) init:)
				((medStar new:) init:)
				((slowStar new:) init:)
				((fastStar new:) init:)
				(= cycles 1)
			)
			(20 (= seconds 4))
			(21
				(= next sPixelIn)
				(self dispose:)
			)
		)
	)
)

(instance sPixelIn of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(switch local420
			(1
				(Palette palSET_INTENSITY 144 152 100)
				(Palette palSET_INTENSITY 152 160 0)
				(= local420 2)
			)
			(2
				(Palette palSET_INTENSITY 144 152 0)
				(Palette palSET_INTENSITY 152 160 100)
				(= local420 1)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOldCast eachElementDo: #setPri 1)
				(= local8 2)
				(= local420 1)
				(Palette palSET_INTENSITY 1 175 10)
				(Palette palSET_INTENSITY 240 242 10)
				(Palette palSET_INTENSITY 182 208 10)
				(Palette palSET_INTENSITY 1 175 20)
				(Palette palSET_INTENSITY 240 242 20)
				(Palette palSET_INTENSITY 182 208 20)
				(Palette palSET_INTENSITY 1 175 30)
				(Palette palSET_INTENSITY 240 242 30)
				(Palette palSET_INTENSITY 182 208 30)
				(Palette palSET_INTENSITY 1 175 40)
				(Palette palSET_INTENSITY 240 242 40)
				(Palette palSET_INTENSITY 182 208 40)
				(Palette palSET_INTENSITY 1 175 50)
				(Palette palSET_INTENSITY 240 242 50)
				(Palette palSET_INTENSITY 182 208 50)
				(Palette palSET_INTENSITY 1 175 60)
				(Palette palSET_INTENSITY 240 242 60)
				(Palette palSET_INTENSITY 182 208 60)
				(Palette palSET_INTENSITY 1 175 70)
				(Palette palSET_INTENSITY 240 242 70)
				(Palette palSET_INTENSITY 182 208 70)
				(Palette palSET_INTENSITY 1 175 80)
				(Palette palSET_INTENSITY 240 242 80)
				(Palette palSET_INTENSITY 182 208 80)
				(Palette palSET_INTENSITY 1 175 90)
				(Palette palSET_INTENSITY 240 242 90)
				(Palette palSET_INTENSITY 182 208 90)
				(Palette palSET_INTENSITY 1 175 100)
				(Palette palSET_INTENSITY 240 242 100)
				(Palette palSET_INTENSITY 182 208 100)
				(= cycles 25)
			)
			(1
				(headA init:)
				(lArmA init:)
				(rArmA init:)
				(ego1P init: addToPic:)
				(logo init: addToPic:)
				(mutation init: addToPic:)
				(enext init: addToPic:)
				(DrawPic 1 dpOPEN_LEFT)
				(= cycles 1)
			)
			(2
				(rArmA setCycle: End cycleSpeed: 10)
				(lArmA setCycle: End self cycleSpeed: 10)
			)
			(3
				(rArmA setCycle: CT 2 -1)
				(lArmA setCycle: CT 2 -1 self)
			)
			(4
				(rArmA setCycle: CT 3 1)
				(lArmA setCycle: CT 3 1 self)
			)
			(5
				(rArmA setCycle: Beg)
				(lArmA setCycle: Beg self)
			)
			(6
				(mutating2 init:)
				(gSq5Music2 number: 708 setLoop: 1 play:)
				(mutating init: setCycle: End self)
			)
			(7
				(headA cycleSpeed: 10 setCycle: End self)
			)
			(8
				(headA addToPic:)
				(lArmA addToPic:)
				(rArmA addToPic:)
				(= seconds 6)
			)
			(9
				(Palette palSET_INTENSITY 144 160 0)
				(mutating dispose:)
				(mutating2 dispose:)
				(DrawPic 1 dpOPEN_LEFT)
				(= seconds 3)
			)
			(10
				(= local417 0)
				(= next sCredits)
				(self dispose:)
			)
		)
	)
)

(instance sCredits of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 8 16 0)
				(= ticks 5)
			)
			(1
				(creditName setLoop: local9 init:)
				(= cycles 1)
			)
			(2
				(Palette palSET_INTENSITY 8 16 local12)
				(if (< (= local12 (+ local12 10)) 101) (-- state))
				(= ticks 5)
			)
			(3 (= seconds 2))
			(4
				(Palette palSET_INTENSITY 8 16 local12)
				(if (> (= local12 (- local12 10)) 0) (-- state))
				(= ticks 5)
			)
			(5
				(if (< (++ local9) local10) (= state (- state 6)))
				(= seconds 2)
			)
			(6
				(gSq5Music1 fade:)
				(creditName dispose:)
				(= seconds 3)
			)
			(7
				(gSq5Music1 number: 2 loop: -1 play: 0 fade: 127 10 5 0)
				(= next sCaptainsLog)
				(Palette palSET_INTENSITY 8 16 100)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (and (< state 6) (& (pEvent type?) $4005))
			(self changeState: 6)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance sCaptainsLog of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 104 1 0 0 local415 @local13)
				(= local413 (StrLen @local13))
				(= local414 0)
				(= cycles 1)
			)
			(1
				(repeat
					(StrAt @local213 local414 (StrAt @local13 local414))
					(StrAt @local213 (++ local414) 0)
					(if
						(or
							(== (StrAt @local13 (- local414 1)) 32)
							(== (StrAt @local13 (- local414 1)) 0)
						)
						(break)
					)
				)
				(Display
					@local213
					dsCOORD
					40
					10
					dsCOLOR
					254
					dsFONT
					1307
					dsWIDTH
					250
				)
				(if (< local414 local413) (-- state) (= ticks 15))
			)
			(2
				(= seconds 0)
				(Display
					@local213
					dsCOORD
					40
					10
					dsCOLOR
					0
					dsFONT
					1307
					dsWIDTH
					250
				)
				(if (> (++ local415) local416)
					(= cycles 1)
				else
					(= state -1)
					(= seconds 1)
				)
			)
			(3
				(Palette palSET_INTENSITY 0 175 0)
				(Palette palSET_INTENSITY 181 255 0)
				(= next sAttack)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (and (== state 1) (& (pEvent type?) $4005))
			(self changeState: 2)
			(pEvent claimed: 1)
			(return)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance sAttack of Script
	(properties)
	
	(method (doit)
		(Palette
			palSET_INTENSITY
			0
			175
			(/ (* 5 (- 220 (rogInChair y?))) 4)
		)
		(Palette
			palSET_INTENSITY
			181
			255
			(/ (* 5 (- 220 (rogInChair y?))) 4)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogInChair
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 1
					setMotion: MoveTo 160 140 self
				)
			)
			(1
				(rogInChair loop: 0 cel: 0 setCycle: Osc 1 self)
			)
			(2 (= seconds 3))
			(3
				(gSq5Music1 number: 3 setLoop: -1 play:)
				(talkBubble init:)
				(= seconds 4)
			)
			(4
				(talkBubble hide:)
				(gSq5Music2 number: 202 setLoop: 1 play:)
				(ShakeScreen 5 2)
				(= cycles 1)
			)
			(5
				(rogInChair loop: 2 cel: 2 setCycle: Beg self)
			)
			(6
				(rogInChair hide:)
				(DrawPic 5 dpOPEN_NO_TRANSITION dpCLEAR)
				(= local417 2)
				(= local419 1)
				(Palette palSET_INTENSITY 144 160 100)
				(gSq5Music2 number: 105 setLoop: -1 play:)
				(= seconds 5)
			)
			(7
				(rogCloseup init:)
				(rogMouth init: setCycle: RTRandCycle)
				(talkBubble view: 101 loop: 2 cel: 0 x: 80 y: 10 show:)
				(= seconds 4)
			)
			(8
				(rogMouth hide:)
				(talkBubble view: 101 loop: 3 cel: 0 x: 20 y: 10)
				(= seconds 4)
			)
			(9
				(rogCloseup view: 97)
				(rogMouth
					view: 97
					x: 123
					y: 89
					show:
					setCycle: RTRandCycle
				)
				(talkBubble view: 97 loop: 3 cel: 0 x: 80 y: 6)
				(= seconds 4)
			)
			(10
				(rogCloseup dispose:)
				(rogMouth dispose:)
				(talkBubble dispose:)
				(gSq5Music2 number: 202 setLoop: 1 play:)
				(DrawCel 97 2 0 81 38 15)
				(ShakeScreen 10 2)
				(= seconds 2)
			)
			(11
				(DrawPic 1 dpOPEN_NO_TRANSITION dpCLEAR)
				(rogInChair loop: 2 cel: 2 show: stopUpd: ignoreActors:)
				(= local417 0)
				(= seconds 2)
			)
			(12
				(gSq5Music2 stop:)
				(gSq5Music1 number: 10 setLoop: -1 play:)
				(DrawPic 7 dpOPEN_PIXELATION dpCLEAR)
				(= seconds 2)
			)
			(13
				(gTestMessager say: 2 0 0 5 self)
			)
			(14
				(gTestMessager say: 2 0 0 6 self)
			)
			(15
				(gTestMessager say: 2 0 0 7 self)
			)
			(16
				(DrawPic 8 dpOPEN_PIXELATION dpCLEAR)
				(= local417 0)
				(= seconds 6)
			)
			(17
				(global2 newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance space of Prop
	(properties
		x 120
		y 74
		view 96
	)
	
	(method (init)
		(super init: &rest)
		(quest init:)
	)
	
	(method (doit)
		(super doit: &rest)
		(quest cel: (self cel?))
	)
	
	(method (dispose)
		(super dispose: &rest)
		(quest dispose:)
	)
)

(instance quest of Prop
	(properties
		x 148
		y 79
		view 96
		loop 1
	)
)

(instance rogInChair of Actor
	(properties
		x 160
		y 220
		view 100
		loop 1
	)
)

(instance lArm of Prop
	(properties
		x 125
		y 85
		view 99
		priority 3
		signal $4010
	)
)

(instance lArmA of Actor
	(properties
		x 125
		y 85
		view 99
		priority 15
		signal $4010
	)
)

(instance rArm of Prop
	(properties
		x 214
		y 75
		view 99
		loop 1
		priority 3
		signal $4010
	)
)

(instance rArmA of Actor
	(properties
		x 214
		y 75
		view 99
		loop 1
		priority 15
		signal $4010
	)
)

(instance head of Prop
	(properties
		x 162
		y 72
		view 99
		loop 2
		cel 2
		priority 3
		signal $4010
	)
)

(instance headA of Actor
	(properties
		x 162
		y 72
		view 99
		loop 2
		cel 2
		priority 15
		signal $4010
	)
)

(instance ego1P of Prop
	(properties
		x 41
		y 72
		view 99
		loop 3
		priority 12
		signal $4010
	)
)

(instance commetStar of Actor
	(properties
		view 103
		signal $6010
		moveSpeed 0
	)
	
	(method (init)
		(self setScript: sWaitNow)
		(= local4 20)
		(= local5 (Random 0 7))
		(while (or (== local5 local2) (== local5 local3))
			(= local5 (Random 0 7))
		)
		(= local3 local2)
		(= local2 local5)
		(= local5 (* local5 45))
		(= local0 (+ local6 (CosMult local5 local4)))
		(= local1 (+ local7 (SinMult local5 local4)))
		(self
			setHeading: (+ local5 90)
			posn: local0 local1
			cycleSpeed: 10
			setStep: 8 8
			setCycle: End
			setLoop: Grooper
			setCel: 0
			setPri: local8
			setMotion: MoveFwd 150 self
		)
		(super init:)
	)
	
	(method (cue)
		(self setScript: sWaitNow)
		(if (not local419) ((commetStar new:) init:))
		(self dispose:)
	)
)

(instance fastStar of Actor
	(properties
		view 103
		priority 4
		signal $6010
		moveSpeed 0
	)
	
	(method (init)
		(self setScript: sWaitNow)
		(= local4 20)
		(= local5 (Random 0 359))
		(= local0 (+ local6 (CosMult local5 local4)))
		(= local1 (+ local7 (SinMult local5 local4)))
		(self
			setHeading: (+ local5 90)
			posn: local0 local1
			setStep: 5 5
			setLoop: 0
			setCycle: 0
			setCel: 2
			setPri: local8
			setMotion: MoveFwd 150 self
		)
		(super init:)
	)
	
	(method (cue)
		(if (not local419) ((fastStar new:) init:))
		(self dispose:)
	)
)

(instance medStar of Actor
	(properties
		view 103
		priority 4
		signal $6010
		moveSpeed 4
	)
	
	(method (init)
		(self setScript: sWaitNow)
		(= local4 20)
		(= local5 (Random 0 359))
		(= local0 (+ local6 (CosMult local5 local4)))
		(= local1 (+ local7 (SinMult local5 local4)))
		(self
			setHeading: (+ local5 90)
			posn: local0 local1
			setCycle: 0
			setLoop: 0
			setPri: local8
			setCel: 1
			setMotion: MoveFwd 100 self
		)
		(super init:)
	)
	
	(method (cue)
		(if (not local419) ((medStar new:) init:))
		(self dispose:)
	)
)

(instance slowStar of Actor
	(properties
		view 103
		priority 4
		signal $6010
		moveSpeed 10
	)
	
	(method (init)
		(self setScript: sWaitNow)
		(= local4 (Random 30 40))
		(= local5 (Random 0 359))
		(= local0 (+ local6 (CosMult local5 local4)))
		(= local1 (+ local7 (SinMult local5 local4)))
		(self
			setHeading: (+ local5 90)
			posn: local0 local1
			setPri: local8
			setLoop: 0
			setCycle: 0
			setMotion: MoveFwd 100 self
		)
		(super init:)
	)
	
	(method (cue)
		(if (not local419) ((slowStar new:) init:))
		(self dispose:)
	)
)

(instance quirkMouth of Prop
	(properties
		nsTop 69
		nsLeft 14
		view 102
		priority 6
		signal $4010
	)
)

(instance quirkTalker of PriorityTalker
	(properties
		x 100
		y 20
		view 102
		loop 2
		priority 6
		talkWidth 280
		textX -160
		textY -80
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 171
			tailY: 38
			xOffset: 0
		)
		(super init: 0 0 quirkMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance talkBubble of View
	(properties
		x 160
		y 8
		view 100
		loop 3
		cel 1
		priority 14
		signal $4010
	)
)

(instance rogCloseup of View
	(properties
		x 81
		y 38
		view 101
		priority 14
		signal $4010
	)
)

(instance rogMouth of Prop
	(properties
		x 134
		y 89
		view 101
		loop 1
		priority 15
		signal $4010
	)
)

(instance theComet of Prop
	(properties
		x 146
		y 88
		view 96
		loop 2
		cel 2
		priority 1
		signal $0010
		scaleSignal $0001
		scaleX 33
		scaleY 33
	)
)

(instance ego1 of View
	(properties
		x 41
		y 72
		view 99
		loop 3
		priority 3
		signal $4010
	)
)

(instance creditName of View
	(properties
		x 160
		y 85
		view 29
		signal $4000
	)
)

(instance logo of View
	(properties
		x 56
		y 5
		view 99
		loop 3
		cel 1
		priority 15
		signal $4010
	)
)

(instance enext of Actor
	(properties
		x 50
		y 169
		view 99
		loop 4
		priority 15
		signal $4010
		xStep 14
	)
)

(instance mutation of Actor
	(properties
		x 155
		y 172
		view 99
		loop 4
		cel 1
		priority 13
		signal $4010
	)
)

(instance mutating of Prop
	(properties
		x 155
		y 172
		view 99
		loop 5
		priority 15
		signal $4010
	)
)

(instance mutating2 of View
	(properties
		x 154
		y 172
		view 99
		loop 6
		priority 14
		signal $4010
	)
)
