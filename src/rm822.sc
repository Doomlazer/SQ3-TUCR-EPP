;;; Sierra Script 1.0 - (do not remove this comment)
(script# 822)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room822 0
)

(local
	
)


(instance Room822 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(821
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(or
				(and
					(> (ego x?) 138)
					(>= (ego y?) 190)
					(== (curRoom script?) 0) 
				)
				(and
					(>= (ego x?) 320)
					(== (curRoom script?) 0) 
				)
			)
			(curRoom newRoom: 821)
		)
;;;		(if
;;;			(and
;;;				(& (ego onControl:) 2) ;darkblue
;;;				(== script 0)
;;;			)
;;;			(curRoom setScript: FallDown)
;;;		)		
;;;		(if
;;;			(and
;;;				(& (ego onControl:) $4000) ;yellow - back to ship
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 802)
;;;		)
;;;		(if
;;;			(and
;;;				(or 
;;;					(> (ego y?) 194)
;;;					(> (ego x?) 323)
;;;				)
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 804)
;;;		)
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
					(821
						(if (> (ego y?) 110)
							(ego
								posn: 330 170
								setMotion: MoveTo 310 160 self
							)
						else
							(ego
								posn: 200 195
								setMotion: MoveTo 190 185 self
							)
						)
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