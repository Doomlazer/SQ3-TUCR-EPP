;;; Sierra Script 1.0 - (do not remove this comment)
(script# 807)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room807 0
)

(local
	local0
)
(instance rogView of Actor
	(properties)
)

(instance Room807 of Room
	(properties
		picture scriptNumber
	)

	
	(method (init)
		(super init:)
;;;		(switch prevRoomNum
;;;			(else 
;;;			)
;;;		)
		(self setScript: roomScript)
		;(ego init:)
	)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	
	)
	
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
;;;		(cond 
;;;			((Said 'look>')
;;;				(cond 
;;;					((Said '/rock,stone') (Print {There is something unsettling about the thought of passing a kidney stone this size.}))
;;;					((Said '[<around,at,in][/area,!*]') (Print {After treking all the way out here, it seems there is little to do other than bask in the grandure of its sheer size.}))
;;;				)
;;;			)
;;;		)
	)
)

(instance roomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
				
			)
			(1
				(larrySound play:)
				(rogView 
					view: 296
					posn: 280 160
					cel: -1
					setCycle: BegLoop self
					init:
				)
			)
			(2
				(rogView loop: 2)
				(= seconds 1)
			)
			(3
				(rogView loop: 1)
				(= seconds 1)
			)
			(4
				(rogView loop: 2)
				(= seconds 1)
			)
			(5
				
				(= seconds 2)
			)
			(6
				(rogView loop: 1)
				(Print {"Wowza! Now this is worth the six buckaziods!!"}#title {Roger} #at 200 70)
				(= seconds 3)
			)
			(7
				(rogView 
					loop: 0
					setCycle: EndLoop self
				)
			)
			(8
				(Print {"WAIT! NO NO No No no no... I didn't even get to tell her about my golden mop!!} #title {Roger} #at 200 80)
				(HandsOn)
				(roomScript dispose:)
				(curRoom newRoom: 804)
			)
		)
	)	
)

(instance larrySound of Sound
	(properties
		number 300
		priority 2
	)
)