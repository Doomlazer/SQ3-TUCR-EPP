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
	
)


(instance Room824 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(822
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
;;;		(if
;;;			(and
;;;				(& (ego onControl:) 2) ;darkblue
;;;				(== script 0)
;;;			)
;;;			(curRoom setScript: FallDown)
;;;		)		
		(if
			(and
				(& (ego onControl:) $0008) ;ctlTEAL
				(== script 0)
			)
			;(curRoom newRoom: 823)
		)
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
;;;					(823
;;;						(ego setMotion: MoveTo 200 75 self)
;;;					)
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