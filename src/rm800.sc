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

(instance Room800 of Room
	(properties
		picture 800
		north 813
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
		(= horizon 69) ;-4000)
		(theGame setSpeed: 5)
		(HandsOff)
		(= inCartoon TRUE)
		(super init:)
		(switch prevRoomNum
			(813
				(ego
					view: 68
					;setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 160 70
					setMotion: MoveTo 160 72 self ;176
					init:
				)
				(HandsOn)
			)
			(else
				(self setScript: Actions)
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
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					ignoreHorizon:
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(theMusic number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 50 self) ;was 92
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 80 self) ;was 132
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 191
					ignoreActors:
					setPri: 0
					setStep: 2 4
					setMotion: MoveTo 5 105 ;165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 100 self) ;was 158
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
					posn: 67 110 ;169
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
					posn: 70 99 ;157
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
					posn: 64 107;157
					setMotion: MoveTo 87 126 self ;176
					init:
				)
			)
			(8
				(ego 
					setLoop: -1
				)	;setMotion: MoveTo 117 130 self)
				(HandsOn)
			)
;;;			(9
;;;				(Scott ;now astro chicken
;;;					view: 290 ;215
;;;					setLoop: 8
;;;					setCycle: EndLoop
;;;					setStep: 1 10
;;;					setPri: 12
;;;					posn: 117 0
;;;					setMotion: MoveTo 117 135 self
;;;					init:
;;;				)
;;;				(= seconds 2)	
;;;			)
;;;			(10
;;;				(Mark dispose:) 
;;;				(Scott ;now astro chicken
;;;					view: 291
;;;					setLoop: 0
;;;					ignoreActors:
;;;					ignoreHorizon:
;;;					ignoreControl: 
;;;					setCycle: EndLoop self
;;;					setPri: 15
;;;					posn: 117 135
;;;				)
;;;			)
;;;			(11
;;;				(Scott ;now astro chicken
;;;					view: 291 ;215
;;;					setLoop: 1
;;;					setCycle: EndLoop self
;;;					setPri: 15
;;;					posn: 117 135
;;;				)
;;;			
;;;			)
;;;			(12
;;;				(Scott dispose:)
;;;				(Print {Suddenly, from out of the sky comes an astro chicken careening towards you at supersonic speed. Both you and the chicken are vaporied on impact.})
;;;				(EgoDead 0 0 8 16)
;;;				(= inCartoon FALSE)
;;;				(HandsOn)
;;;			)
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
