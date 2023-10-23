;;; Sierra Script 1.0 - (do not remove this comment)
(script# 829)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room829 0
)

(local
	tempX
	tempY
)

(instance Room829 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= tempX (ego x?))
		(= tempY (ego y?))
		(super init:)
		(switch prevRoomNum
			(828
				(self setScript: RoomScript)
			)
			(821
				(self setScript: RoomScript)
			)
			(830
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
		(door init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(or
				(and
					(> (ego x?) 296)
					(<= (ego y?) 20)
					(== (curRoom script?) 0) 
				)
				(and
					(>= (ego x?) 319)
					(== (curRoom script?) 0) 
				)
			)
			(curRoom newRoom: 828)
		)
		(if
			(or
				(and
					(< (ego x?) 150)
					(> (ego y?) 186)
					(== (curRoom script?) 0) 
				)
				(and
					(< (ego x?) 4)
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
		(if
			(and
				(& (ego onControl:) $0008) ;ctlTEAL
				(== script 0)
			)
			(curRoom newRoom: 830)
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
					(830 ;from store
						(ego
							posn: 70 40
							setMotion: MoveTo 125 85 self
						)
					)
					(828
						(if (< tempY 187)
							(ego
								posn: 330 -5
								setMotion: MoveTo 290 20 self
							)
						else
							(ego
								posn: 330 80
								setMotion: MoveTo 300 90 self
							)
						)
					)
					(821
						(if (> tempY 120)
							(ego
								posn: -10 170
								setMotion: MoveTo 10 160 self
							)
						else
							(ego
								posn: 100 200
								setMotion: MoveTo 135 180 self
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

(instance door of PicView
	(properties
		x 86
		y 69
		view 825
		loop 2
		priority 1
	)
)