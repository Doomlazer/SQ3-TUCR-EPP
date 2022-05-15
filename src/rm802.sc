;;; Sierra Script 1.0 - (do not remove this comment)
(script# 802)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room802 0
)

(local
	local0
)

(instance Room802 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(if towed
			(= picture 805)	
		)
		(super init:)
		(switch prevRoomNum
			(14
				(ego view: 63)
				(self setScript: RoomScript)
			)
			(803
				(ego posn: 266 182 loop: 3)
			)
			(else 
				(ego posn: 150 100 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(if
			(and
				(& (ego onControl:) $4000)
				(== script 0)
			)
			(curRoom newRoom: 14)
		)
		(if
			(and
				(& (ego onControl:) 2) ;darkblue
				(== script 0)
			)
			(curRoom setScript: FallDown)
		)
		(if
			(and
				(& (ego onControl:) 4) ;green
				(== script 0)
			)
			(ego setPri: 2)
			(curRoom setScript: FallDown)
		)
		(if
			(and
				(> (ego y?) 194)
				(== script 0)
			)
			(curRoom newRoom: 803)
		)	
	)
	
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look,read/sign')
			(if towed
				(Print {It's the intergalactic symbol for restricted parking. It certainly would have been nice to see that earlier!})
			else 
				(Print {What sign?})
			)	
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look,read/sign')
			(if towed
				(Print {It certainly would have been nice to see that earlier!})
			else 
				(Print {What sign?})
			)	
		)
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					posn: 157 147 
					ignoreControl:
					setMotion: MoveTo 190 174 self
				)
			)
			(1
				(RedrawCast)
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)

(instance FallDown of Script
	(method (doit)
		(super doit:)
		(if (== (fallSound prevSignal?) -1)
			(= local0 1)
		)
		(if (or local0 (== (fallSound state?) 0))
			(= local0 0)
			
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(ego setLoop: setCel: 0 setStep: 6 12 setCycle: 0)
				(RedrawCast)
				(ego setMotion: MoveTo (ego x?) 229)
				(ohnoScript changeState: 0)
			)
			(1
				(EgoDead 0 0 1 2)
			)
		)
	)
)

(instance ohnoScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ohno init: setCycle: EndLoop self)
			)
			(1
				(ohno dispose:)
			)
		)
	)
)

(instance ohno of Prop
	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (ego priority?)
			posn: (ego x?) (- (ego y?) 40)
			ignoreActors: TRUE
		)
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

;;;(instance boom of Sound
;;;	(properties
;;;		number 78
;;;		priority 1
;;;	)
;;;)
;;;
