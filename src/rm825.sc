;;; Sierra Script 1.0 - (do not remove this comment)
(script# 825)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room825 0
)

(local
	
)

(instance door of Prop
	(properties
		x 168
		y 91
		view 825
		loop 0
		priority 1
		;signal $4010
	)
)

(instance Room825 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(824
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 160 120 loop: 1)
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
					(> (ego x?) 115)
					(>= (ego y?) 188)
					(== (curRoom script?) 0) 
				)
				(and
					(>= (ego x?) 318)
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
	
	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
		
		(if (Said 'read,look/sign')
			(if (ego inRect: 120 80 200 100)
				(Print {The sign posted on the gate indicates that this location was closed down some time ago due to health code violations.})
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
					(824
						(if (< (ego y?) 50)
							(ego
								posn: 330 116
								setMotion: MoveTo 310 112 self
							)
						else
							(ego
								posn: 330 150
								setMotion: MoveTo 310 148 self
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