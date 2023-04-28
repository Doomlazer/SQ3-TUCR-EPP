;;; Sierra Script 1.0 - (do not remove this comment)
(script# 813)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room813 0
)

(local
)

(procedure (checkPad pad)
	(if
		(and
			(< tdx (pad nsRight?))
			(> tdx (pad nsLeft?))
			(< tdy (pad nsBottom?))
			(> tdy (pad nsTop?))
		)
		(return)
	)
	(if
		(and
			(< (ego x?) (pad nsRight?))
			(> (ego x?) (pad nsLeft?))
			(< (ego y?) (pad nsBottom?))
			(> (ego y?) (pad nsTop?))
		)
		(return)
	)	
)

(instance door of Actor
	
	(method (init)
		(super init:)
		(self
			view: 303
			;ignoreActors:
			setLoop: 1
			setCel: 0
			setPri: 10
			x: 160
			y: 150
		)
	)
	
	(method (doit)
		(super doit:)
		(self setPri: 10)
		(if 
			(and
				(== (pad1 cel?) 2)
				(== (pad2 cel?) 2)
			)
			(self setStep: 2 3 setMotion: MoveTo (self x?) 80)	
		else
			(self setStep: 2 1 setMotion: MoveTo (self x?) 150)
		)
		(if (< (door y?) 115)
			(ego illegalBits: cRED)
		else
			(ego illegalBits: (| cGREEN cRED))
			(if
				(and
					(& (ego onControl:) cGREEN)
					(< (door y?) 120)
					(> (door y?) 115)
				)
				(Print {the door crushes your skull.})
				(EgoDead 901 0 15 1)
			)
		)
	)
)

(instance pad1 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 303
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 3
			x: 73
			y: 169
		)
	)
	
	(method (doit)
		(super doit:)
		(if (checkPad self)
			(if (== (self cel?) 0)
				(self setCycle: EndLoop)
			)
		else
			(if (== (self cel?) 2)
				(self setCycle: BegLoop)
			)
		)
	)
)

(instance pad2 of Prop
	(method (init)
		(super init:)
		(self
			view: 303
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 3
			x: 240
			y: 169
		)
	)
	
	(method (doit)
		(super doit:)
		(if (checkPad self)
			(if (== (self cel?) 0)
				(self setCycle: EndLoop)
			)
		else
			(if (== (self cel?) 2)
				(self setCycle: BegLoop)
			)
		)
	)
)

(instance Room813 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(= tdx 0)
		(= tdy 0)
		(ego
			view: 0
			setStep: 3 2
			init:
		)	
		(pad1 init:)
		(pad2 init:)
		(door init:)
		(ego get: 18)
		(switch prevRoomNum
			(814
				(ego posn: 163 151 loop: 3)
			)
			(else
				(ego posn: 160 200)
				(self setScript: RoomScript)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look')
			(= temp0 (GetNumber {Program number:}))
			(DrawPic temp0 8)
		)	
	)
	
	(method (doit)
		(super doit:)
		(if (< (ego y?) 140)
			(curRoom newRoom: 800) ;814)	
		)
		(if (> (ego y?) 205)
			(curRoom newRoom: 800)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look')
			(DrawPic 804 9)
		)	
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					setMotion: MoveTo 160 180 self
				)
			)
			(1
				(RedrawCast)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

;;;(instance winScript of Script
;;;	(method (changeState newState)
;;;		(switch (= state newState)
;;;			(0
;;;				(ChickenNPC setScript: 0)
;;;				;(ChickenHero setScript: 0)
;;;				;(Print {0})
;;;				(if (> heroHP 0)
;;;					(ChickenHero loop: 6 cel: 0 setCycle: EndLoop)
;;;					(ChickenNPC view: 291 loop: 0 cel: 0 setCycle: EndLoop)
;;;				else
;;;					(ChickenNPC loop: 6 cel: 0 setCycle: EndLoop )
;;;					(ChickenHero view: 291 loop: 0 cel: 0 setCycle: EndLoop)
;;;				)
;;;				(= seconds 2)
;;;				
;;;			)
;;;			(1
;;;				;(Print {1})
;;;				(if (> heroHP 0)
;;;					(ChickenNPC loop: 1 cel: 0 setCycle: EndLoop winScript)
;;;				else
;;;					(ChickenHero loop: 1 cel: 0 setCycle: EndLoop winScript)
;;;				)
;;;			)
;;;			(2
;;;				;(Print {2})
;;;				;(ChickenHero dispose:)
;;;				;(ChickenNPC dispose:)
;;;				(= seconds 2)
;;;			)
;;;			(3
;;;				;(Print {3})
;;;				(ChickenNPC setScript: 0)
;;;				(ChickenHero setScript: 0)
;;;				(ChickenInit)
;;;				(= state -1)
;;;				;(self dispose:)
;;;			)
;;;		)
;;;	)
;;;)