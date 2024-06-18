;;; Sierra Script 1.0 - (do not remove this comment)
(script# 821)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room821 0
)

(local
	tempX
	tempY
)


(instance Room821 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= tempX (ego x?))
		(= tempY (ego y?))
		(super init:)
		(switch prevRoomNum
			(27
				(self setScript: RoomScript)
			)
			(822
				(self setScript: RoomScript)
			)
			(829
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
			(and
				(> (ego y?) 180)
				(== (curRoom script?) 0) 
			)
			(self setScript: exitScript)
		)
		(if
			(and
				(> (ego x?) 315)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 822)
		)
		(if
			(and
				(> (ego y?) 180)
				(== (curRoom script?) 0) 
			)
			(self setScript: exitScript)
		)
		(if
			(and
				(< (ego x?) 5)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 829)
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
	
	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type?)
			(saidEvent
				(cond
					((Said 'look>')
						(cond
							((Said '/walkway,floor,down') (Print 821 1))
							((Said '[<at,around,in][/area,!*]') (Print 821 0))
						)
					)
				)
			)
		)
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(switch prevRoomNum
					(27
						(ego
							posn: 196 200 
							ignoreControl:
							setMotion: MoveTo 196 170 self
						)
					)
					(822
						(if (>= tempX 320)
							(ego
								posn: 330 140 
								ignoreControl:
								setMotion: MoveTo 310 140 self
							)
						else
							(ego
								posn: 330 90 
								ignoreControl:
								setMotion: MoveTo 310 90 self
							)
						)
					)
					(829
						(if (<= tempX 35)
							(ego
								posn: -10 140 
								ignoreControl:
								setMotion: MoveTo 10 140 self
							)
						else
							(ego
								posn: -10 90 
								ignoreControl:
								setMotion: MoveTo 10 90 self
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

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)			
				(ego setMotion: MoveTo (ego x?) 200 self)
			)
			(1
				(HandsOn)
				(curRoom newRoom: 14)
			)
		)
	)
)