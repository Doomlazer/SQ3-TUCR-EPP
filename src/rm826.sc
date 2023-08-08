;;; Sierra Script 1.0 - (do not remove this comment)
(script# 826)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room826 0
)

(local
	tempX
	tempY
)

(instance Room826 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= tempX (ego x?))
		(= tempY (ego y?))
		(super init:)
		(switch prevRoomNum
			(825
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 160 110 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(>= (ego x?) 317)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 825)
		)
		(if
			(and
				(< (ego x?) 3)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 827)
		)	
		(if
			(and
				(& (ego onControl:) $0008) ;ctlTEAL
				(== script 0)
			)
			;(curRoom newRoom: 823)
		)
	)
	
	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
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
					(825
						(if (< tempY 115)
							(ego
								posn: 330 80
								setMotion: MoveTo 310 90 self
							)
						else
							(ego
								posn: 330 120
								setMotion: MoveTo 310 130 self
							)
						)
					)
					(else
						(ego posn: 160 115)
					)
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