;;; Sierra Script 1.0 - (do not remove this comment)
(script# 800)
(include game.sh)
(use Main)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)
(use User)

(public
	Room800 0
)

(local
	[local0 2]
	numVoices
	maxUp = 80
	maxDown = 110
	maxLeft = 20
	maxRight = 300
	maxDist = 60
	mineToggle = 1
	courtesy = 1
)

(procedure (checkMine mine)
	(if
		(and
			(< (ego x?) (mine nsRight?))
			(> (ego x?) (mine nsLeft?))
			(< (ego y?) (mine nsBottom?))
			(> (ego y?) (mine nsTop?))
		)
		(return)
	)
)

(procedure (MineShow &tmp i)
	(= i 1)
	(while (< i 10)
		((GetMine i) show:)
		(++ i)
	)
)

(procedure (GetMine i)
	(return
		(switch i
			(1 mine1)
			(2 mine2)
			(3 mine3)
			(4 mine4)
			(5 mine5)
			(6 mine6)
			(7 mine7)
			(8 mine8)
			(9 mine9)	
		)
	)
)

(procedure (MineInit mine)
	(mine
		view: 304
		ignoreHorizon:
		illegalBits: 0
		ignoreActors:
		setLoop: 1
		setCel: 0
		setCycle: Forward
		hide:
		x: (Random maxLeft maxRight)
		y: (Random maxUp maxDown)
	)
)

(procedure (MineDoit mine)
	(if (checkMine mine)
		(ego setScript: mineDeath)
		(mine dispose:)
	)
	(if (== (Random 0 100) 69)
		(mine setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
	else
		(if
			(and
				courtesy
				mineToggle
				(< (ego y?) maxDown)
			)
			(if (< (GetDistance (ego x?)(ego y?)(mine x?)(mine y?)) maxDist)
				(mine show:)
				(mine setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine1 of Actor

	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine2 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine3 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine4 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine5 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine6 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine7 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine8 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance mine9 of Actor
	
	(method (init)
		(super init:)
		(MineInit self)
	)
	
	(method (doit)
		(super doit:)
		(MineDoit self)
	)
)

(instance ship of Actor)

(instance shadow of Actor)

(instance cockPit of Prop)

(instance ramp of Prop)

(instance Room800 of Room
	(properties
		picture 800
		north 813
	)
	
	(method (init &tmp i)
		(= numVoices (DoSound NumVoices))
		(Load SOUND 99)
		(Load SOUND 83)
		(Load SOUND 38)
		(Load SOUND 40)
		(if (== numVoices 1)
			(Load SOUND 16)
		)
		(= horizon 69) ;-4000)
		(theGame setSpeed: 5)
		(HandsOff)
		(= inCartoon TRUE)
		(super init:)
		(= i 1)
		(while (< i 10)
			((GetMine i) init:)
			(++ i)
		)
		(switch prevRoomNum
			(813
				(ego
					view: 68
					;setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 160 70
					setScript: surfaceScript
					init:
				)
				(ship
					view: 215
					setLoop: 0
					posn: 0 150
					setCel: 2
					setPri: 13
					ignoreHorizon: 1
					init:
				)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 160
					cel: 2
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
					posn: 70 149
					init:
				)
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 155
					ignoreActors:
					ignoreControl: $0002 
					setPri: 0
					init:
				)
				(if (ego has: iGoggles)
					(Print 800 19)
					(= mineToggle 0)
					(DrawPic 901 100)
					(DrawPic 903 100)
					(ship cel: 4)
					(cockPit loop: 9)
					(shadow cel: 1)
					(ramp loop: 10)
					(= i 1)
					(while (< i 10)
						((GetMine i) loop: 2)
						(++ i)	
					)
					(MineShow)
				else
					(Print 800 20)
				)
				(HandsOn)
			)
			(else
				(ego posn: 160 300)
				(self setScript: Actions)
			)
		)
		(ego get: iGoggles)
		(ego get: iTime_Disruptor)
	)

	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
		
		(if (Said 'talk/mine')
			(if (not courtesy)
				(Print 800 17)
			else
				(MineShow)
				(= courtesy 0)
				(Print 800 13)
				(Print 800 14)
				(Print 800 15)
				(Print 800 16)
			)	
		)
		
		(if (Said 'look/mine')
			(if mineToggle
				(Print 800 3)
			else
				(Print 800 4)
			)	
		)
		
		(if (Said 'wear,use/glasses,goggles')
			(if (ego has: iGoggles)
				(if mineToggle
					(= mineToggle 0)
					(Print 800 5)
					(DrawPic 901 100)
					(DrawPic 903 100)
					(ship cel: 4)
					(cockPit loop: 9)
					(ramp loop: 10)
					(shadow cel: 1)
					(= i 1)
					(while (< i 10)
						((GetMine i) loop: 2)
						(++ i)
					)
					(MineShow)
				else
					(Print 800 6)
				)
			else
				(Print 800 11)
			)
		)
		
		(if (Said 'remove,take[<off]/glasses,goggles')
			(if (ego has: iGoggles)
				(if mineToggle
					(Print 800 7)				
				else
					(= mineToggle 1)
					(ship cel: 3)
					(shadow cel: 0)
					(ramp loop: 3)
					(cockPit loop: 2)
					(= i 1)
					(while (< i 10)
						((GetMine i) loop: 1 hide:)
						(++ i)
					)
					(DrawPic 902 100)(DrawPic 800 100)
				)
			else
				(Print 800 11)
			)
		)
		(if (Said 'read/sign')
			(if mineToggle
				(Print 800 0)
			else
				(Print 800 23) ;can't read sign
			)
		)
		(if (Said 'look>')
			(cond 
				((Said '/sign') (Print 800 0))
				((Said '/building') (Print 800 2))
				((Said '[<at,around,in][/area,!*]') (Print 800 1))
			)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
	)
)

(instance surfaceScript of Script
	(method (doit)
		(if (& (ego onControl:) $0002);water
			(if mineToggle
				(ego view: 305) ;water no glasses
			else
				(ego view: 307) ;water w/ glasses
			)
		else 
			(if mineToggle
				(ego view: 68) ;no water no glasses
			else
				(ego view: 306) ;no water w/ glasses
			)	
		)
		(if (ego inRect: 45 150 80 185) 
			(ego setScript: takeOff)
		)
		(if (< (ego x?) -5)
			(Print 800 21)
			(ego setMotion: MoveTo 10 (ego y?))
		)
		(if (> (ego x?) 325)
			(Print 800 21)
			(ego setMotion: MoveTo 315 (ego y?))
		)
		(if (> (ego y?) 195)
			(Print 800 21)
			(ego setMotion: MoveTo (ego x?) 185)
		)
	)
)

(instance mineDeath of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego view: 291 loop: 0 cel: 0 setMotion: 0 setCycle: EndLoop self)
			)
			(1
				(ego view: 291 loop: 1 cel: 0 setCycle: EndLoop self)
			)
			(2
				(if (not mineToggle)
					(DrawPic 902 100)
					(DrawPic 800 100)
				)
				(EgoDead)
			)
		)
	)
)

(instance Actions of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					ignoreHorizon: 1
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(theMusic number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 100 self) ;50 self) ;was 92
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 100 self) ;80 self) ;was 132
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 255
					ignoreActors:
					ignoreControl: $0002 
					setPri: 0
					;setStep: 2 4
					setMotion: MoveTo 5 155 ;105 ;165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 150 self) ;100 self) ;was 158
			)
			(4
				(theMusic fade:)
			;	(shadow setMotion: 0)
				(= seconds 5)
			)
			(5
				(ship stopUpd:)
			;	(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 160 ;110 ;169
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
					posn: 70 149 ;99 ;157
					setCycle: EndLoop self
					init:
				)
				;(theMusic number: 99 loop: -1 play:)
				
			)
			(7
				(ego
					view: 68
					setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 64 157 ;107 ;157
					setMotion: MoveTo 87 176 self ;126 ;176
					init:
				)
			)
			(8
				(ego setScript: surfaceScript)
				(ego 
					setLoop: -1
					setPri: -1
				)	;setMotion: MoveTo 117 130 self)
				(HandsOn)
			)
		)
	)
)

(instance takeOff of Script
	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					;posn: 87 176
					ignoreActors: TRUE
					setMotion: MoveTo 64 157 self 
				)
			)
			(1
				(cockPit
					view: 215
					cycleSpeed: 3
					setPri: 13
					posn: 70 149
					setCycle: BegLoop self
				)
			)
			(2
				(cockPit hide:)
				(ego
					ignoreActors: FALSE
					hide:
				)
				(if (not mineToggle)
					(Print 800 22)
					(= mineToggle 1)
					(ship cel: 3)
					(shadow cel: 0)
					(ramp loop: 3)
					(cockPit loop: 2)
					(= i 1)
					(while (< i 10)
						((GetMine i) hide:)
						(++ i)
					)
					(DrawPic 902 100)
					(DrawPic 800 100)
				)
				(ship startUpd:)
			;	(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 160 ;110 ;169
					cel: 255
					ignoreActors:
					setPri: 11
					setCycle: BegLoop self

				)
			)
			(3
				(ramp hide:)
				(theMusic number: 83 loop: 1 play:)
				(ship setCel: 2 setMotion: MoveTo 0 100 self) ;80 self) ;was 132
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 155
					ignoreActors:
					ignoreControl: $0002 
					setPri: 0
					;setStep: 2 4
					setMotion: MoveTo 5 255 ;105 ;165
				)
			)
			(4
				(curRoom newRoom: 14)
			)
		)
	)
)
