;;; Sierra Script 1.0 - (do not remove this comment)
(script# 802)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room802 0
)

(instance Room802 of Room
	(properties
		picture scriptNumber
		north 0
		east 0
		south 0
		west 0
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(14
				(ego view: 63)
				(self setScript: RoomScript)
				;(Print {fuck1})
				;(theMusic owner: -1 number: 22 priority: 1 loop: -1 play:)
				;(= programControl TRUE)
			)
			(else 
				(ego posn: 150 100 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		;(super doit:)
		; code executed each game cycle
		(if
			(and
				(& (ego onControl:) $4000)
				(== script 0)
			)
			(curRoom newRoom: 14)
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
					posn: 157 147 
					ignoreControl:
					setMotion: MoveTo 184 174 self
				)
			)
			(1
				(Print {Roger, this is a no parking zone. Hope you don't get towed.})
				(RedrawCast)
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)
