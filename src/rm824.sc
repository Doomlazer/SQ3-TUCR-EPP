;;; Sierra Script 1.0 - (do not remove this comment)
(script# 824)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room824 0
)

(local
	tempX
	tempY
)


(instance Room824 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= tempX (ego x?))
		(= tempY (ego y?))
		(super init:)
		(switch prevRoomNum
			(822
				(self setScript: RoomScript)
			)
			(825
				(self setScript: RoomScript)
			)
			(827
				;return from ATM, do nothing
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
					(> (ego x?) 115)
					(>= (ego y?) 188)
					(== (curRoom script?) 0) 
				)
				(and
					(>= (ego x?) 318)
					(== (curRoom script?) 0) 
				)
			)
			(curRoom newRoom: 822)
		)
		(if
			(or
				(and
					(< (ego x?) 10)
					(< (ego y?) 10)
					(== (curRoom script?) 0) 
				)
				(and
					(< (ego x?) 4)
					(== (curRoom script?) 0) 
				)
			)
			(curRoom newRoom: 825)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look,use/machine,atm')
			(if (& (ego onControl:) $4000) ;ctlYellow
				(curRoom newRoom: 827)
			else
				(NotClose)
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
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(switch prevRoomNum
					(822
						(if (< (ego y?) 50)
							(ego
								posn: 330 175
								setMotion: MoveTo 310 165 self
							)
						else
							(ego
								posn: 200 195
								setMotion: MoveTo 190 185 self
							)
						)
					)
					(825
						(if (< tempY 130)
							(ego
								posn: -10 -10
								setMotion: MoveTo 25 25 self
							)
						else
							(ego
								posn: -10 80
								setMotion: MoveTo 10 90 self
							)
						)
					)
					(else
						(ego posn: 150 130)
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