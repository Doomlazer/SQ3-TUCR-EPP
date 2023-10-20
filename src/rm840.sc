;;; Sierra Script 1.0 - (do not remove this comment)
(script# 840)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room840 0
)

(local
)

(instance sludge of Actor
	(properties
		x 216
		y 65
		view 308
		loop 0
		cel 0
	)
)



(instance Room840 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(841
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
		(sludge init: setCycle: Forward)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(> (ego y?) 185)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 841)
		)
	)
	
	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
		
		(if (Said 'read,look/sign')

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
				(switch prevRoomNum
					(813
						(ego
							posn: 160 200
							setMotion: MoveTo 160 180 self
						)
					)
				)
			)
			(1
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)