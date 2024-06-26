;;; Sierra Script 1.0 - (do not remove this comment)
(script# 803)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room803 0
)

(local
	local0
)


(instance Room803 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(802
				(self setScript: RoomScript)
			)
			(804
				(ego posn: 310 198 loop: 1)
				(self setScript: fromSouthScript)
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
				(& (ego onControl:) 2) ;darkblue
				(== script 0)
			)
			(curRoom setScript: FallDown)
		)		
		(if
			(and
				(& (ego onControl:) $4000) ;yellow - back to ship
				(== script 0)
			)
			(curRoom newRoom: 802)
		)
		(if
			(and
				(or 
					(> (ego y?) 187)
					(> (ego x?) 317)
				)
				(== script 0)
			)
			(curRoom setScript: toSouthScript)
		)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
					((Said 'look>')
						(cond
							((Said '/moon')
								(Print {You can't see Ren's only moon from here.})
							)
							((Said '/drop,cliff')
								(Print {I'd keep a good distance from the edges, Roger. It doesn't seem like safety is a priority here!})
							)
							((Said '/face,rock,carving,man')
								(Print {After awhile all these planet start to look very simmilar, don't they?})
							)
							((Said '[/anyword]')
								(Print {This is a rather precarious path with steep drop-offs on either side. I guess there aren't many safety regulations on this planet.})
							)
						)	
					)

				)
			)
		)
	)
)

(instance toSouthScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					ignoreControl:
					setMotion: MoveTo (ego x?) 199 self
				)
			)
			(1
				(RedrawCast)
				(HandsOn)
				(curRoom newRoom: 804)
			)
		)
	)
)

(instance fromSouthScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					ignoreControl:
					setMotion: MoveTo (- (ego x?) 10) 185 self
				)
			)
			(1
				(HandsOn)
				(fromSouthScript dispose:)
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
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					posn: 50 46 
					ignoreControl:
					setMotion: MoveTo 77 64 self
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
				(EgoDead 0 0 0 27)
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

