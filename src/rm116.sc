;;; Sierra Script 1.0 - (do not remove this comment)
(script# 116)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)
(use pet)

(public
	Room116 0
)

(local
	[local0 2]
	numVoices
)
(instance ship of Actor)

(instance shadow of Actor)

(instance cockPit of Prop)

(instance Roger of Actor)

(instance Mark of Actor)

(instance Scott of Actor)

(instance ramp of Prop)

(instance Ken of Actor)

(instance bigRoger of Actor)

(instance sMouth of Prop)

(instance mMouth of Prop)

(instance kMouth of Prop)

(instance rMouth of Prop)

(instance Room116 of Room
	(properties
		picture 116
	)
	
	(method (init)
		(= numVoices (DoSound NumVoices))
		(Load SOUND 99)
		(Load SOUND 83)
		(Load SOUND 38)
		(Load SOUND 40)
		(if (== numVoices 1)
			(Load SOUND 16)
		)
		(= horizon -4000)
		(theGame setSpeed: 5)
		(HandsOff)
		(= inCartoon TRUE)
		(super init:)
		(= selectedSector 68) ; black hole
		(switch prevRoomNum
			(115
				(if completedEnding
					(self setScript: arriveActions)
				else
					(self setScript: Actions)
				)
			)
			(850
				(self setScript: leaveActions)
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance Actions of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= completedEnding 1)
				(= selectedSector 68) ; black hole
				(if petActive
					(WarpOffScreen)	
				)
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(theMusic number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 92 self)
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 132 self)
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 191
					ignoreActors:
					setPri: 0
					setStep: 2 1
					setMotion: MoveTo 5 165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 158 self)
			)
			(4
				(theMusic fade:)
				(shadow setMotion: 0)
				(= seconds 5)
			)
			(5
				(ship stopUpd:)
				(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 169
					cel: 255
					ignoreActors:
					setPri: 11
					setCycle: EndLoop self
					init:
				)
			)
			(6
				(theMusic number: 99 loop: -1 play:)
				(Mark
					view: 215
					setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 87 176 self
					init:
				)
			)
			(7
				(Mark setMotion: MoveTo 117 172)
				(Scott
					view: 215
					setLoop: 5
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 79 174 self
					init:
				)
			)
			(8
				(cockPit
					view: 215
					setLoop: 2
					cel: 255
					cycleSpeed: 3
					setPri: 13
					posn: 70 157
					setCycle: EndLoop
					init:
				)
				(Scott setMotion: MoveTo 109 166)
				(Ken
					view: 215
					setLoop: 6
					posn: 180 132
					setPri: 0
					setStep: 1 1
					setCycle: Walk
					setMotion: MoveTo 130 162 self
					init:
				)
			)
			(9
				(= seconds 2)
			)
			(10
				(curRoom drawPic: 117 DISSOLVE)
				(cast eachElementDo: #hide)
				(RedrawCast)
				(mMouth view: 136 loop: 0 posn: 42 74 setPri: 5 init:)
				(sMouth view: 136 loop: 1 posn: 158 109 setPri: 5 init:)
				(kMouth view: 136 loop: 2 posn: 237 157 setPri: 5 init:)
				(bigRoger
					view: 136
					setLoop: 3
					posn: -23 87
					setPri: 3
					ignoreActors:
					setMotion: MoveTo 19 87
					init:
				)
				(= seconds 3)
			)
			(11
				(if (== numVoices 1)
					(theMusic stop:)
					(theMusic number: 16 loop: -1 play:)
				)
				(mMouth setCycle: Forward)
				(Print 116 0 #title {Mark} #dispose #at -1 156 #width 320)
				(= seconds 8)
			)
			(12
				(cls)
				(RedrawCast)
				(mMouth setCel: 0)
				(rMouth
					view: 136
					setLoop: 4
					posn: (bigRoger x?) (bigRoger y?)
					setPri: 4
					ignoreActors:
					setCycle: Forward
					init:
				)
				(Print 116 1
					#title {Roger}
					#dispose
					#at -1 156
					#width 320
				)
				(= seconds 8)
				(if (< buckazoids 1000) ;if not easter egg do original ending
					(= state 49)
				)
			)
			(13
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				(kMouth setCycle: Forward)
				(Print 116 12 ;116 2
					#title {Ken Williams}
					#dispose
					#at -1 156
					#width 320
				)
				(= seconds 5)
			)
			(14
				(cls)
				(RedrawCast)
				(Print 116 13
					#title {Ken Williams}
					#dispose
					#at -1 156
					#width 320
				)
				(= seconds 7)
			)
			(15
				(cls)
				(RedrawCast)
				(Print 116 14 ;116 4
					#title {Ken Williams}
					#dispose
					#at -1 170
					#mode teJustCenter
				)
				(= seconds 5)
			)
			(16
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(mMouth setCycle: Forward)
				(sMouth setCycle: Forward)
				(Print {Yes, master.} ;116 7
					#title {Scott and Mark}
					#dispose
					#at -1 156
					#width 100
					#mode teJustCenter
				)
				(= seconds 1)
			)
			(17
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(mMouth setCel: 0)
				(kMouth setCycle: Forward)
				(Print
					116 15 ;116 6
					#title {Ken Williams}
					#dispose
					#at -1 170
				)
				(= seconds 3)
				(= state 19)
			)
			(20
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(rMouth setCycle: Forward)
				(Print
					116 17 ;116 9 
					#title {Roger}
					#dispose
					#at -1 170
				)
				(= seconds 3)
			)
			(21
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				;(kMouth cel: 255 setCycle: EndLoop self)
				(kMouth setCycle: Forward)
				(Print 116 16 ;116 4
					#title {Ken Williams}
					#dispose
					#at -1 170
					#mode teJustCenter
				)
				(= seconds 4)
			)
			(22
				(cls)
				(RedrawCast)
				(mMouth dispose:)
				(rMouth dispose:)
				(sMouth dispose:)
				(kMouth dispose:)
				(= cycles 2)
			)
			(23
				(theMusic fade:)
				(cast eachElementDo: #show)
				(bigRoger dispose:)
				(curRoom drawPic: 116 DISSOLVE)
				(ego
					view: 68
					setStep: 1 1
					posn: 110 176
					setPri: 12
					setLoop: -1
					loop: 0
					setCel: -1
					setCycle: Walk
					setAvoider: Avoider
					init:
				)
				(WarpToEgo)
				(RedrawCast)
				(Ken setScript: KenMoveIntoBuilding)
				(= seconds 1)
			)
			(24
				(Mark setScript: MarkMoveIntoBuilding)
				(= seconds 1)
			)
			(25
				(Scott setScript: ScottMoveIntoBuilding)
				(Print 116 10 #at -1 10 #width 310 #dispose)
				(ego setMotion: MoveTo 87 176 self)
			)
			(26
				(ego setMotion: MoveTo 54 157 self)
			)
			(27
				(= seconds 7)
				(WarpOffScreen)
			)
			(28
				(cockPit setCycle: BegLoop self)
			)
			(29
				(cls)
				(ego dispose:)
				(ramp setCycle: BegLoop)
				(= seconds 2)
			)
			(30
				(ramp dispose:)
				(cockPit dispose:)
				(ship setMotion: MoveTo 0 132 self)
				(Print 116 11 #at -1 10 #width 310 #time 12)
				(theMusic number: 40 loop: 1 play:)
				(shadow setMotion: MoveTo 5 199)
			)
			(31
				(shadow dispose:)
				(ship setStep: 1 5 setMotion: MoveTo 0 92 self)
			)
			(32
				(ship setCel: 1 setMotion: MoveTo 0 39 self)
			)
			(33
				(ship setCel: 0 setMotion: MoveTo 0 -20 self)
			)
			(34
				(theMusic number: 38 loop: 1 play:)
				(ship
					setLoop: 8
					setCel: 0
					posn: 279 -14
					setStep: 4 6
					setMotion: MoveTo 243 15 self
				)
			)
			(35
				(cls)
				(ship setCycle: EndLoop setMotion: MoveTo 215 43 self)
			)
			(36
				(ship setMotion: MoveTo 215 -5 self)
			)
			(37
				(= seconds 2)
			)
			(38
				(curRoom newRoom: 117)
			)
			(50 ;original ending
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				(kMouth setCycle: Forward)
				(Print 116 2
					#title {Ken Williams}
					#dispose
					#at -1 156
					#width 320
				)
				(= seconds 10)
			)
			(51
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(sMouth setCycle: Forward)
				(Print 116 3 #title {Scott} #dispose #at -1 170)
				(= seconds 5)
			)
			(52
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(kMouth cel: 255 setCycle: EndLoop self)
				(Print 116 4
					#title {Ken Williams}
					#dispose
					#at -1 170
					#mode teJustCenter
				)
			)
			(53
				(cls)
				(RedrawCast)
				(mMouth setCel: 0)
				(sMouth cel: 255 setCycle: EndLoop self)
				(Print 116 5 #title {Scott} #dispose #at -1 170 #mode 1)
			)
			(54
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(kMouth setCycle: Forward)
				(Print 116 6 #title {Ken Williams} #dispose #at -1 170)
				(= seconds 8)
			)
			(55
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(mMouth setCycle: Forward)
				(sMouth setCycle: Forward)
				(Print 116 7
					#title {Scott and Mark}
					#dispose
					#at -1 156
					#width 320
					#mode teJustCenter
				)
				(= seconds 5)
			)
			(56
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(mMouth setCel: 0)
				(kMouth cel: 255 setCycle: EndLoop self)
				(Print 116 8 #title {Ken Williams} #dispose #at -1 170)
			)
			(57
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(rMouth setCycle: Forward)
				(Print 116 9 #title {Roger} #dispose #at -1 170)
				(= seconds 7)
			)
			(58
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				(kMouth cel: 255 setCycle: EndLoop self)
				(Print 116 4
					#title {Ken Williams}
					#dispose
					#at -1 170
					#mode teJustCenter
				)
				(= state 21)
			)
		)
	)
)

(instance KenMoveIntoBuilding of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ken setLoop: 7 setMotion: MoveTo 180 132 self)
			)
			(1
				(Ken setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance MarkMoveIntoBuilding of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Mark setMotion: MoveTo 180 132 self)
			)
			(1
				(Mark setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance ScottMoveIntoBuilding of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Scott setMotion: MoveTo 180 132 self)
			)
			(1
				(Scott setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance arriveActions of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= completedEnding 1)
				(= selectedSector 68) ; black hole
				(if petActive
					(WarpOffScreen)	
				)
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(theMusic number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 92 self)
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 132 self)
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 191
					ignoreActors:
					setPri: 0
					setStep: 2 1
					setMotion: MoveTo 5 165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 158 self)
			)
			(4
				(theMusic fade:)
				(shadow setMotion: 0)
				(= seconds 5)
			)
			(5
				(ship stopUpd:)
				(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 169
					cel: 255
					ignoreActors:
					setPri: 11
					setCycle: EndLoop self
					init:
				)
			)
			(6
				(cockPit
					view: 215
					setLoop: 2
					cel: 255
					cycleSpeed: 3
					setPri: 13
					posn: 70 157
					setCycle: EndLoop self
					init:
				)
			)
			(7
				(ego
					view: 68
					setStep: 1 1
					posn: 54 167 ;110 176
					setPri: 12
					setLoop: -1
					loop: 0
					setCel: -1
					setCycle: Walk
					setAvoider: Avoider
					init:
				)
				(ego setMotion: MoveTo 90 176 self)
				(WarpToEgo)
			)
			(8
				(ego setMotion: MoveTo 180 130 self)
			)
			(9
				(curRoom newRoom: 850)
			)
		)
	)
)

(instance leaveActions of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship
					posn: 0 158
					view: 215
					setLoop: 0
					setCel: 2
					setPri: 13
					ignoreActors:
					init:
					stopUpd:
				)
				(shadow 
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 165
					ignoreActors:
					setPri: 0
					setStep: 2 1
					init:
					stopUpd:
				)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 169
					cel: -1
					ignoreActors:
					setPri: 11
					init:
				)
				(cockPit
					view: 215
					setLoop: 2
					cel: 4
					cycleSpeed: 3
					setPri: 13
					posn: 70 157
					init:
				)
				(ego
					view: 68
					posn: 180 130
					setCycle: Walk
					setAvoider: Avoider
					ignoreActors:
					setMotion: MoveTo 90 176 self
					init:
				)
				(WarpToEgo)
			)
			(1
				(ego setMotion: MoveTo 54 167 self)
			)
			(2
				(= seconds 7)
				(WarpOffScreen)
			)
			(3
				(cockPit setCycle: BegLoop self)
			)
			(4
				(cls)
				(ego dispose:)
				(ramp setCycle: BegLoop)
				(= seconds 2)
			)
			(5
				(ramp dispose:)
				(cockPit dispose:)
				(ship setMotion: MoveTo 0 132 self)
				(theMusic number: 40 loop: 1 play:)
				(shadow setMotion: MoveTo 5 199)
			)
			(6
				(shadow dispose:)
				(ship setStep: 1 5 setMotion: MoveTo 0 92 self)
			)
			(7
				(ship setCel: 1 setMotion: MoveTo 0 39 self)
			)
			(8
				(ship setCel: 0 setMotion: MoveTo 0 -20 self)
			)
			(9
				(theMusic number: 38 loop: 1 play:)
				(ship
					setLoop: 8
					setCel: 0
					posn: 279 -14
					setStep: 4 6
					setMotion: MoveTo 243 15 self
				)
			)
			(10
				(cls)
				(ship setCycle: EndLoop setMotion: MoveTo 215 43 self)
			)
			(11
				(ship setMotion: MoveTo 215 -5 self)
			)
			(12
				(= seconds 2)
			)
			(13
				(curRoom newRoom: 117)
			)
		)
	)
)