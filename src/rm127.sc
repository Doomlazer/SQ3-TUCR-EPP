;;; Sierra Script 1.0 - (do not remove this comment)
(script# 127)
(include sci.sh)
(use Main)
(use Blink)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm127 0
	danteTalker 3
	beaTalker 10
	quirkTalker 14
)

(local
	local0
	local1
)
(procedure (localproc_006e)
	(bobHead setCel: 0)
	(danteHead setCel: 1)
	(kaarenHead setCel: 0)
	(quirkHead setCel: 0)
	(randyHead setCel: 0)
)

(procedure (localproc_00a1)
	(bobHead setCel: 2)
	(danteHead setCel: 0)
	(kaarenHead setCel: 3)
	(randyHead setCel: 3)
)

(procedure (localproc_00cc)
	(quirkHead setLoop: 2 setCel: 1)
	(bobHead setCel: 1)
	(danteHead setCel: 1)
	(kaarenHead setCel: 1)
	(quirkHead setCel: 1)
	(randyHead setCel: 1)
)

(instance rm127 of Rm
	(properties
		picture 34
		style $000a
	)
	
	(method (init)
		(self setRegions: 109)
		(proc958_0 128 150 151 153 152)
		(proc958_0 143 127)
		(confDoor init: setPri: 9)
		(beaBody init:)
		(beaHead init:)
		(kaarenHead init:)
		(oldMan init:)
		(quirkHead init:)
		(danteHead init:)
		(randyHead init:)
		(super init:)
		(gSq5Music1 number: 15 loop: -1 play:)
		(self setScript: sArgument)
	)
	
	(method (dispose)
		(gSq5Music1 stop:)
		(super dispose:)
	)
)

(instance sArgument of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 145 setLoop: -1 play:)
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(2
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(3
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(4
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 5)
			)
			(5
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(6
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(7
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(8
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(9
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(10
				(Palette palSET_INTENSITY 1 254 100)
				(gSq5Music2 stop:)
				(= cycles 2)
			)
			(11
				(= local0 0)
				(gTestMessager say: 1 0 0 1 self)
			)
			(12
				(localproc_00cc)
				(= cycles 2)
			)
			(13
				(gTestMessager say: 1 0 0 2 self)
			)
			(14
				(gTestMessager say: 1 0 0 3 self)
			)
			(15
				(beaBody setCycle: End self)
				(rog
					loop: 4
					cel: 0
					init:
					posn: 115 119
					setCycle: End self
				)
			)
			(16 0)
			(17
				(localproc_006e)
				(= cycles 2)
			)
			(18
				(gTestMessager say: 1 0 0 4 self)
			)
			(19
				(gTestMessager say: 1 0 0 5 self)
			)
			(20
				(beaBody setCycle: Beg self)
				(rog loop: 5 cel: 0 posn: 249 120 setCycle: End self)
			)
			(21 0)
			(22
				(gTestMessager say: 1 0 0 6 self)
			)
			(23
				(localproc_00cc)
				(= cycles 2)
			)
			(24
				(gTestMessager say: 1 0 0 7 self)
			)
			(25
				(rog loop: 0 cel: 0 posn: 249 119 setCycle: End self)
			)
			(26
				(localproc_00a1)
				(= cycles 2)
			)
			(27
				(= local0 2)
				(gTestMessager say: 1 0 0 8 self)
			)
			(28
				(beaHead hide:)
				(beaBody loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(29
				(beaBody setCel: 5)
				(beaHead setCel: 0 posn: 176 97 show:)
				(localproc_006e)
				(= cycles 2)
			)
			(30
				(gTestMessager say: 1 0 0 9 self)
			)
			(31
				(rog loop: 1 cel: 0 setCycle: End self)
				(gSq5Music2 number: 152 setLoop: 1 play:)
			)
			(32
				(localproc_00a1)
				(= cycles 2)
			)
			(33
				(= local0 2)
				(gTestMessager say: 1 0 0 10 self)
			)
			(34
				(gTestMessager say: 1 0 0 11 self)
			)
			(35
				(localproc_006e)
				(= cycles 2)
			)
			(36
				(gTestMessager say: 1 0 0 12 self)
			)
			(37
				(localproc_00cc)
				(= cycles 2)
			)
			(38
				(gTestMessager say: 1 0 0 13 self)
			)
			(39
				(localproc_006e)
				(= cycles 2)
			)
			(40
				(gTestMessager say: 1 0 0 14 self)
			)
			(41
				(localproc_00cc)
				(= cycles 2)
			)
			(42
				(gTestMessager say: 1 0 0 15 self)
			)
			(43
				(localproc_00a1)
				(= cycles 2)
			)
			(44
				(= local0 1)
				(gTestMessager say: 1 0 0 16 self)
			)
			(45
				(localproc_006e)
				(= cycles 2)
			)
			(46
				(gTestMessager say: 1 0 0 17 self)
			)
			(47
				(localproc_00cc)
				(= cycles 2)
			)
			(48
				(gTestMessager say: 1 0 0 18 self)
			)
			(49
				(localproc_006e)
				(= cycles 2)
			)
			(50
				(gTestMessager say: 1 0 0 19 self)
			)
			(51
				(beaHead dispose:)
				(beaBody setLoop: 3 setCel: 0 setCycle: End self)
			)
			(52
				(beaBody setLoop: 4 setCel: 0 setCycle: End self)
			)
			(53
				(confDoor setCycle: End self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(54
				(gSq5Music2 number: 102 setLoop: 1 play:)
				(beaBody setLoop: 5 setCel: 0 setCycle: End)
				(rog
					loop: 2
					cel: 0
					setPri: 10
					posn: 180 146
					setCycle: End self
				)
			)
			(55
				(gSq5Music2 number: 136 setLoop: 1 play: self)
			)
			(56
				(= local1 1)
				(localproc_006e)
				(= cycles 2)
			)
			(57
				(gTestMessager say: 1 0 0 20 self)
			)
			(58
				(beaBody setLoop: 6 setCel: 0 setCycle: End self)
			)
			(59
				(beaBody setCycle: Beg self)
			)
			(60
				(beaBody
					setLoop: 7
					setCel: 0
					setPri: 5
					signal: 16
					setCycle: End self
				)
			)
			(61 (= seconds 2))
			(62
				(oldMan setCel: 1 posn: 48 116)
				(rog setLoop: 3 cel: 0 setCycle: End self)
				(beaBody
					setLoop: 8
					setCel: 0
					posn: 100 102
					setCycle: End self
				)
			)
			(63 0)
			(64
				(confDoor setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(65
				(gTestMessager say: 1 0 0 21 self)
			)
			(66
				(proc0_2 2)
				(global2 newRoom: 125)
				(self dispose:)
			)
		)
	)
)

(instance beaBody of Actor
	(properties
		x 182
		y 139
		view 150
		priority 11
		signal $0010
	)
)

(instance beaHead of Actor
	(properties
		x 178
		y 95
		view 150
		loop 10
		cel 1
		priority 12
		signal $0010
	)
)

(instance rog of Actor
	(properties
		view 151
		priority 15
		cycleSpeed 8
	)
)

(instance confDoor of Prop
	(properties
		x 181
		y 134
		view 152
		priority 11
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 8
		nsLeft 3
		view 150
		loop 2
		signal $4000
	)
)

(instance danteMouth of Prop
	(properties
		nsTop 25
		nsLeft 5
		view 153
		loop 6
		signal $4000
	)
)

(instance quirkMouth of Prop
	(properties
		view 153
		signal $4000
	)
)

(instance beaTalker of Talker
	(properties
		view 150
		loop 10
		talkWidth 200
		textX -120
		textY -80
	)
	
	(method (init)
		(if (== (beaBody loop?) 0)
			(self cel: 1 x: 174 y: 87)
		else
			(self cel: 0 x: 172 y: 89)
		)
		(if (== local1 1)
			(self loop: 11 cel: 0 x: 180 y: 110)
			(beaMouth loop: 11 cel: 1)
		)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 171
			tailY: 75
			xOffset: 0
		)
		(super init: 0 0 beaMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance danteTalker of Talker
	(properties
		x 260
		y 105
		view 153
		loop 5
		cel 1
		talkWidth 200
		textX -240
	)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 244
			tailY: 82
			xOffset: -40
		)
		(super init: 0 0 danteMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance quirkTalker of Talker
	(properties
		view 153
		loop 2
		talkWidth 170
	)
	
	(method (init)
		(switch local0
			(0
				(self cel: 3 x: 79 y: 101)
				(quirkMouth loop: 13 nsLeft: 0 nsTop: 12)
				(quirkHead setCel: 3)
			)
			(1
				(self cel: 1 x: 80 y: 100)
				(quirkMouth loop: 3 nsLeft: 2 nsTop: 13)
				(quirkHead setCel: 1)
			)
			(else 
				(self cel: 0 x: 81 y: 101)
				(quirkMouth loop: 8 nsLeft: 7 nsTop: 8)
				(quirkHead setCel: 0)
			)
		)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 100
			tailY: 82
			xOffset: 13
		)
		(super init: 0 0 quirkMouth &rest)
	)
	
	(method (dispose)
		(if (== local0 0)
			(randyHead setCel: 3 posn: 218 114)
			(bobHead init:)
		)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance kaarenHead of View
	(properties
		x 20
		y 110
		view 153
		cel 4
		priority 15
		signal $4010
	)
)

(instance oldMan of View
	(properties
		x 45
		y 112
		view 153
		loop 1
		cel 2
		priority 12
		signal $4010
	)
)

(instance quirkHead of View
	(properties
		x 88
		y 115
		view 153
		loop 2
		cel 3
		priority 15
		signal $4010
	)
)

(instance danteHead of View
	(properties
		x 260
		y 106
		view 153
		loop 5
		cel 2
		priority 8
		signal $4010
	)
)

(instance randyHead of View
	(properties
		x 223
		y 104
		view 153
		loop 4
		cel 4
		priority 15
		signal $4010
	)
)

(instance bobHead of View
	(properties
		x 222
		y 105
		view 153
		loop 7
		cel 2
		priority 15
		signal $4010
	)
)
