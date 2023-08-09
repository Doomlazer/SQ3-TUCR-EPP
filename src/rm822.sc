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
	tempX
	tempY
)

(instance door of Prop
	(properties
		x 200
		y 35
		view 825
		loop 1
		priority 13
	)
)


(instance Room822 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= tempX (ego x?))
		(= tempY (ego y?))
		(super init:)
		(switch prevRoomNum
			(821
				(self setScript: RoomScript)
			)
			(823
				(self setScript: RoomScript)
			)
			(824
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
		(door ignoreActors: FALSE init:)
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
		(if
			(or
				(and
					(< (ego x?) 20)
					(< (ego y?) 10)
					(== (curRoom script?) 0) 
				)
				(and
					(< (ego x?) 4)
					(== (curRoom script?) 0) 
				)
			)
			(curRoom newRoom: 824)
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
			(curRoom newRoom: 823)
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
			(if (ego inRect: 145 45 230 135)
				(Print {The sign reads, "Thank you to our loyal customers of electronic components and vidPhone subsriptions. This location has been permanently closed".})
			else
				(Print {You can't make out the text from here.})
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
					(823
						(ego setMotion: MoveTo 200 75 self)
					)
					(824
						(if (< tempX 285)
							(ego
								posn: -10 80
								setMotion: MoveTo 10 90 self
							)
						else
							(ego
								posn: -10 -10
								setMotion: MoveTo 25 25 self
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