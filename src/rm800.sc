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
	mineToggle = 1
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

(instance mine1 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine2 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine3 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine4 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine5 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine6 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine7 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine8 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance mine9 of Actor
	
	(method (init)
		(super init:)
		(self
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
	
	(method (doit)
		(super doit:)
		(if (checkMine self)
			(ego setScript: mineDeath)
			(self dispose:)
		)
		(if (== (Random 0 100) 69)
			(self setMotion: MoveTo (Random maxLeft maxRight) (Random maxUp maxDown))
		else
			(if
				(and
					mineToggle
					(< (ego y?) maxDown)
				)
				(self show:)
				(self setMotion: MoveTo (ego x?) (ego y?))
			)
		)
	)
)

(instance ship of Actor)

(instance shadow of Actor)

(instance cockPit of Prop)

(instance ramp of Prop)

(instance bigRoger of Actor)

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
		(mine1 init:)
		(mine2 init:)
		(mine3 init:)
		(mine4 init:)
		(mine5 init:)
		(mine6 init:)
		(mine7 init:)
		(mine8 init:)
		(mine9 init:)
	)

	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look/mine')
			(if mineToggle
				(= mineToggle 0)
				(mine1 show:)
				(mine2 show:)
				(mine3 show:)
				(mine4 show:)
				(mine5 show:)
				(mine6 show:)
				(mine7 show:)
				(mine8 show:)
				(mine9 show:)
			else
				(= mineToggle 1)
				(mine1 hide:)
				(mine2 hide:)
				(mine3 hide:)
				(mine4 hide:)
				(mine5 hide:)
				(mine6 hide:)
				(mine7 hide:)
				(mine8 hide:)
				(mine9 hide:)
			)
			(pEvent claimed: 1)		
		)
		
		(if (Said 'look>')
			(pEvent claimed: 1)
			(cond 
				((Said '/sign') (Print 800 0))
				((Said '/building') (Print 800 2))
				(else
					(Print 800 1)
				)
			)
		)
		(if (Said 'read/sign')
			(pEvent claimed: 1)
			(Print 800 0)
		)
	)
	
	(method (newRoom n)
		(super newRoom: n)
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
