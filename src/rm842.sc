;;; Sierra Script 1.0 - (do not remove this comment)
(script# 842)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room842 0
)

(local
)


(instance Room842 of Room
	;; NOTICE THIS ROOM IS NO LONGER NEEDED and CAN BE REPURPOSED
	(properties
		picture 26 ;scriptNumber
	)
	
	(method (init)
		(super init:)
		(ship 
			view: 52
			loop: 1
			cel: 2
			posn: 250 120
			setPri: 4
			ignoreActors: TRUE
			ignoreHorizon: TRUE
			illegalBits: 0
			init:
		)
		(switch prevRoomNum
			(else 
				;(ego posn: 50 120 loop: 1)
				(self setScript: departScript)
			)
		)
		;(ego init:)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent &tmp i [pass 50] [str 50] [upper 50])
		(super handleEvent: pEvent)
		
		(if (Said 'use/decoder,relic')

		)
		(if
			(or
				(Said 'use/keypad')
				(Said 'enter/password')
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
				(= seconds 5)
			)
			(1
				(ShakeScreen 1 1)
				(explode
					posn: 185 125
					view: 832
					loop: 0
					cel: 0
					setCycle: EndLoop self
					init:
				) 
			)
			(2
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)

(instance departScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship
					setCycle: EndLoop
					setStep: 3 1
					setMotion: MoveTo 150 80 self
				)
				(= seconds 4)
			)
			(1
				(ShakeScreen 1 1)
				(explode
					posn: 185 125
					view: 832
					loop: 0
					cel: 0
					setCycle: EndLoop
					init:
				) 
				(ship
					setStep: 1 1
					setCycle: 0
					setMotion: MoveTo 70 50 self
				)
			)
			(2
				(Print {As you zoom away from the bar a moderate rummbling shakes the ship. You wonder what that was about?})
				;(= prevRoomNum 808) doesn't work
				(curRoom newRoom: 14)
			)
		)
	)
)

(instance ship of Actor
	(properties)
)

(instance explode of Actor
)
