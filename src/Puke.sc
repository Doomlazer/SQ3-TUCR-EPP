;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1010)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm1010 0
)

(local
	[local0 20] = [3 37 57 115 142 175 227 21 61 84 103 130 182 223 254 29 144 162 256]
	[local20 20] = [21 50 92 100 88 37 7 26 88 97 96 32 7 70 75 124 114 101 37]
	[local40 20] = [4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 4]
	[local60 22] = [0 1 2 3 4 5 6 0 1 2 3 4 5 6 7 8 9 10 11 7]
	local82
	local83
)
(class Puke of View
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
		view 674
		loop 0
		cel 0
		priority 14
		underBits 0
		signal $4010
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
		array_index 19
	)
	
	(method (init)
		(self
			loop: [local40 array_index]
			cel: [local60 array_index]
			x: [local0 array_index]
			y: [local20 array_index]
		)
		(super init: &rest)
		(self addToPic:)
	)
)

(instance rm1010 of Rm
	(properties
		noun 5
		picture 122
		style $800a
	)
	
	(method (init)
		(proc958_0 128 672 664 673 678)
		(super init:)
		(if (!= (gSq5Music1 number?) 101)
			(gSq5Music1 number: 101 setLoop: -1 play: setVol: 65)
		else
			(gSq5Music1 setVol: 65)
		)
		(if (== global133 0)
			(= global133 8)
			(= global134 1)
			(= global135 13)
		)
		(puke5 array_index: 19)
		(puke6 array_index: 19)
		(switch (mod global135 6)
			(0
				(puke1 array_index: 0)
				(puke5 array_index: 1)
				(puke3 array_index: 9)
			)
			(1
				(puke1 array_index: 7)
				(puke3 array_index: 10)
			)
			(2
				(puke1 array_index: 11)
				(puke3 array_index: 3)
			)
			(3
				(puke1 array_index: 12)
				(puke3 array_index: 8)
			)
			(4
				(puke1 array_index: 5)
				(puke5 array_index: 6)
				(puke3 array_index: 15)
			)
			(5
				(puke1 array_index: 18)
				(puke3 array_index: 2)
			)
		)
		(switch (/ global135 6)
			(0
				(puke2 array_index: 13)
				(puke4 array_index: 11)
			)
			(1
				(puke2 array_index: 14)
				(puke4 array_index: 12)
			)
			(2
				(puke2 array_index: 13)
				(puke6 array_index: 14)
				(puke4 array_index: 8)
			)
			(3
				(puke2 array_index: 17)
				(puke4 array_index: 11)
				(puke6 array_index: 12)
			)
			(4
				(puke2 array_index: 4)
				(puke4 array_index: 2)
			)
			(5
				(puke2 array_index: 16)
				(puke4 array_index: 15)
			)
		)
		(puke1 init:)
		(puke2 init:)
		(puke3 init:)
		(puke4 init:)
		(puke5 init:)
		(puke6 init:)
		(switch (mod global135 4)
			(0
				(leftExit loop: 1 cel: 1 x: 41 y: 90)
				(rightExit loop: 0 cel: 2 x: 144 y: 93)
			)
			(1
				(leftExit loop: 1 cel: 1 x: 41 y: 90)
				(rightExit loop: 2 cel: 0 x: 139 y: 99 priority: 7)
				(if (== gGModNum 1000)
					(engineRoomOpening setCel: (engineRoomOpening lastCel:))
				)
				(engineRoomOpening init:)
				(rightDoorLeft init:)
			)
			(2
				(leftExit loop: 0 cel: 0 x: 43 y: 97)
				(rightExit loop: 0 cel: 2 x: 144 y: 93)
			)
			(3
				(leftExit loop: 0 cel: 0 x: 43 y: 97)
				(rightExit loop: 2 cel: 0 x: 139 y: 99 priority: 7)
				(if (== gGModNum 1000)
					(engineRoomOpening setCel: (engineRoomOpening lastCel:))
				)
				(engineRoomOpening init:)
				(rightDoorLeft init:)
			)
		)
		(leftExit init:)
		(rightExit init:)
		(if (> global135 17)
			(extraPanel1 loop: 0 cel: 4 x: 178 y: 133)
		else
			(extraPanel1 loop: 0 cel: 3 x: 173 y: 110)
		)
		(if (< (mod global135 6) 3)
			(extraPanel2 loop: 1 cel: 0 x: 17 y: 130)
		else
			(extraPanel2 loop: 1 cel: 3 x: 122 y: 105)
		)
		(if (mod global135 2)
			(extraPanel3 loop: 1 cel: 2 x: 81 y: 106)
		else
			(extraPanel3 loop: 4 cel: 7 x: 0 y: 0)
		)
		(extraPanel1 init: addToPic:)
		(extraPanel2 init: addToPic:)
		(extraPanel3 init: addToPic:)
		(if
			(or
				(and (== global133 1) (== global135 7))
				(and (== global133 2) (== global135 2))
				(and (== global133 3) (== global135 1))
				(and (== global133 4) (== global135 0))
				(and (== global133 4) (== global135 15))
				(and (== global133 5) (== global135 0))
				(and (== global133 6) (== global135 2))
				(and (== global133 6) (== global135 14))
				(and
					(== global133 7)
					(== global135 0)
					(== global134 1)
				)
				(and
					(== global133 7)
					(== global135 2)
					(!= global134 1)
				)
				(and
					(== global133 7)
					(== global135 7)
					(!= global134 1)
				)
				(and (== global133 8) (== global135 2) (< global134 2))
				(and (== global133 8) (== global135 0) (> global134 1))
				(and (== global133 9) (== global135 0))
			)
			(= local82 1)
			(turboBack init: addToPic:)
			(turboDoor init:)
			(floorNum x: 119 y: 108 loop: 6 init: addToPic:)
		else
			(= local82 0)
			(floorDeck init: addToPic:)
			(floorNum init: addToPic:)
		)
		(switch gGModNum
			(1020
				(global2 setScript: sLeaveSubfloor)
			)
			(else 
				(global2 setScript: sExitEngineRoom)
			)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						167
						189
						167
						185
						191
						179
						129
						124
						120
						124
						113
						112
						88
						112
						79
						124
						71
						124
						0
						183
						0
						189
					yourself:
				)
		)
		(grateArea init: setOnMeCheck: 1 2)
	)
	
	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(
				(and
					(proc999_4 0 179 319 189 gEgo)
					(not (global2 script?))
					(not local83)
				)
				(if local82
					(global2 setScript: sTurboPukoid 0 0)
				else
					(global2 setScript: sBackPukoid 0 0)
				)
			)
			(
				(and
					(== temp0 8)
					(not (global2 script?))
					(not local83)
				)
				(if local82
					(global2 setScript: sTurboPukoid 0 1)
				else
					(global2 setScript: sBackPukoid 0 1)
				)
			)
			(
				(and
					(== temp0 16)
					(not (global2 script?))
					(not local83)
				)
				(global2 setScript: sFrontPukoid 0 1)
			)
			(
				(and
					(== temp0 32)
					(not (global2 script?))
					(not local83)
				)
				(global2 setScript: sFrontPukoid 0 0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTestMessager say: noun 1 0 (Random 1 3))
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sEnterGrate of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 98 139 self)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(gEgo
					view: 672
					setLoop: -1
					setLoop: 1
					cel: 0
					x: 96
					y: 142
					setCycle: CT 3 1 self
				)
			)
			(3
				(gEgo setCel: 4)
				(grate init:)
				(= ticks 20)
			)
			(4
				(gEgo setCel: 5)
				(grate setCel: 1)
				(= ticks 20)
			)
			(5
				(gEgo setCel: 6)
				(grate setCel: 2)
				(= ticks 20)
			)
			(6 (gEgo setCycle: End self))
			(7
				(gEgo hide:)
				(grate setCel: 3)
				(= ticks 20)
			)
			(8
				(gSq5Music2 number: 517 setLoop: 1 play: self)
				(grate setCel: 0)
			)
			(9 (= ticks 10))
			(10
				(proc0_10 246 100)
				(global2 newRoom: 1020)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveSubfloor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 672
					setLoop: -1
					setLoop: 1
					setScale: Scaler 177 26 189 108
					setCycle: 0
					setCel: 6
					x: 96
					y: 142
					init:
				)
				(grate cel: 2 init:)
				(= seconds 2)
			)
			(1
				(gEgo setCel: 5)
				(grate setCel: 1)
				(= ticks 15)
			)
			(2
				(gEgo setCel: 4)
				(grate setCel: 0)
				(= ticks 15)
			)
			(3
				(gEgo setCycle: Beg self)
				(grate dispose:)
			)
			(4
				(gEgo
					view: 664
					cel: 0
					setLoop: -1
					loop: 2
					setCycle: Walk
					setScale: Scaler 177 26 189 108
				)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEngineRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 664
					cel: 0
					setLoop: -1
					loop: 2
					posn: 161 132
					setPri: -1
					setCycle: Walk
					setScale: Scaler 177 26 189 108
					init:
					setMotion: MoveTo 130 132 self
				)
			)
			(1
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(engineRoomOpening setCycle: Beg self)
			)
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEngineRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(engineRoomOpening setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 161 132 self)
			)
			(2
				(global2 newRoom: 1000)
				(self dispose:)
			)
		)
	)
)

(instance sBackPukoid of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gTestMessager say: 3 0 0 0 self)
			)
			(1
				(gEgo view: 6501 cel: 0 setCycle: CT 1 1)
				(guard
					view: 673
					x: 135
					y: 121
					init:
					setPri: 1
					setStep: 8 2
					setCel: 0
					setScale: Scaler 177 26 189 108
					setMotion: MoveTo 117 121 self
				)
			)
			(2
				(if register
					(guard setLoop: 5)
					(pukeShot
						x: (+ (guard x?) (/ (* 9 (guard scaleX?)) 128))
						y: (- (guard y?) (/ (* 38 (guard scaleY?)) 128))
					)
				else
					(guard setLoop: 2)
					(pukeShot
						x: (- (guard x?) (/ (* 10 (guard scaleX?)) 128))
						y: (- (guard y?) (/ (* 43 (guard scaleY?)) 128))
					)
				)
				(guard cel: 0 setCycle: End)
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(pukeShot
					init:
					setPri: 6
					setLoop: -1
					setLoop: 8
					setCel: 0
					setCycle: 0
					setStep: 20 10
					setMotion:
						MoveTo
						(- (gEgo x?) (/ (* 5 (gEgo scaleX?)) 128))
						(- (gEgo y?) (/ (* 29 (gEgo scaleY?)) 128))
						self
				)
			)
			(3
				(pukeShot setLoop: 9 setCycle: End self)
				(gEgo setCycle: End self)
				(= local83 1)
			)
			(4 0)
			(5
				(proc0_9 33)
				(self dispose:)
			)
		)
	)
)

(instance sTurboPukoid of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(guard
					view: 673
					x: 100
					y: 122
					init:
					setPri: 1
					setScale: Scaler 177 26 189 108
					setCel: 0
				)
				(if register (guard setLoop: 5) else (guard setLoop: 2))
				(turboDoor setCycle: End self)
			)
			(1
				(gTestMessager say: 3 0 0 0 self)
			)
			(2
				(gEgo view: 6501 cel: 0 setCycle: CT 1 1)
				(if register
					(pukeShot
						x: (+ (guard x?) (/ (* 9 (guard scaleX?)) 128))
						y: (- (guard y?) (/ (* 38 (guard scaleY?)) 128))
					)
				else
					(pukeShot
						x: (- (guard x?) (/ (* 10 (guard scaleX?)) 128))
						y: (- (guard y?) (/ (* 43 (guard scaleY?)) 128))
					)
				)
				(guard setCycle: End)
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(pukeShot
					init:
					setPri: 4
					setLoop: -1
					setLoop: 8
					setCel: 0
					setCycle: 0
					setStep: 20 10
					setMotion:
						MoveTo
						(- (gEgo x?) (/ (* 5 (gEgo scaleX?)) 128))
						(- (gEgo y?) (/ (* 29 (gEgo scaleY?)) 128))
						self
				)
			)
			(3
				(pukeShot setLoop: 9 setCycle: End self)
				(gEgo setCycle: End self)
				(= local83 1)
			)
			(4 0)
			(5
				(proc0_9 33)
				(self dispose:)
			)
		)
	)
)

(instance sFrontPukoid of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gTestMessager say: 3 0 0 0 self)
			)
			(1
				(gEgo view: 6501 cel: 0 setCycle: CT 1 1)
				(guard
					view: 672
					x: (+ 43 (* register 105))
					y: 190
					init:
					setPri: 15
					setStep: 8 12
					setLoop: 3
					setCel: 0
					setMotion: MoveTo (+ 43 (* register 105)) 138 self
				)
			)
			(2
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(pukeShot
					x: (+ (guard x?) 12)
					y: 180
					init:
					setPri: 14
					setLoop: -1
					setLoop: 8
					setCel: 0
					setCycle: 0
					setStep: 20 10
					setMotion:
						MoveTo
						(- (gEgo x?) (/ (* 5 (gEgo scaleX?)) 128))
						(- (gEgo y?) (/ (* 29 (gEgo scaleY?)) 128))
						self
				)
			)
			(3
				(pukeShot setLoop: 9 setCycle: End self)
				(gEgo setCycle: End self)
				(= local83 1)
			)
			(4 0)
			(5
				(proc0_9 33)
				(self dispose:)
			)
		)
	)
)

(instance grate of View
	(properties
		x 73
		y 159
		noun 2
		view 672
		loop 2
		signal $4000
	)
)

(instance guard of Actor
	(properties
		x 21
		y 189
		noun 4
		view 672
		loop 4
		signal $4000
	)
)

(instance pukeShot of Actor
	(properties
		yStep 24
		view 678
		signal $4000
		xStep 12
		moveSpeed 0
	)
	
	(method (init)
		(super init: &rest)
		(self setScale: Scaler 177 26 189 108)
	)
)

(instance engineRoomOpening of Prop
	(properties
		x 140
		y 96
		view 674
		loop 3
		priority 4
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== gGModNum 1000)
					(global2 setScript: sEnterEngineRoom)
				else
					(gTestMessager say: 1 4 1 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance puke1 of Puke
	(properties)
)

(instance puke2 of Puke
	(properties)
)

(instance puke3 of Puke
	(properties)
)

(instance puke4 of Puke
	(properties)
)

(instance puke5 of Puke
	(properties)
)

(instance puke6 of Puke
	(properties)
)

(instance leftExit of View
	(properties
		noun 1
		view 674
		signal $4000
	)
)

(instance rightExit of View
	(properties
		noun 1
		view 674
		priority 3
		signal $5010
	)
)

(instance rightDoorLeft of View
	(properties
		x 139
		y 99
		view 674
		loop 10
		priority 3
		signal $5010
	)
)

(instance extraPanel1 of View
	(properties
		view 674
		signal $4000
	)
)

(instance extraPanel2 of View
	(properties
		view 674
		signal $4000
	)
)

(instance extraPanel3 of View
	(properties
		view 674
		signal $4000
	)
)

(instance floorDeck of View
	(properties
		x 269
		y 107
		view 674
		cel 5
		priority 5
		signal $4010
	)
)

(instance floorNum of View
	(properties
		x 281
		y 124
		view 674
		loop 7
		cel 5
		priority 3
		signal $4010
	)
	
	(method (init)
		(if (and (< 0 global133) (< global133 10))
			(self cel: (- global133 1))
		else
			(self cel: 7)
		)
		(super init: &rest)
	)
)

(instance turboBack of View
	(properties
		x 74
		y 100
		view 674
		loop 8
		priority 1
		signal $4010
	)
)

(instance turboDoor of Prop
	(properties
		x 90
		y 95
		view 674
		loop 9
		priority 2
		signal $4010
	)
)

(instance grateArea of Feature
	(properties
		x 106
		y 137
		noun 2
		onMeCheck $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sEnterGrate)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
