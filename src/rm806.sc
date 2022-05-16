;;; Sierra Script 1.0 - (do not remove this comment)
(script# 806)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room806 0
)

(local
	local0
)

(instance Room806 of Room
	(properties
		picture scriptNumber
		north 0
		east 804
		south 804
		west 804
	)
	
	(method (init)
		(super init:)
		(switch prevRoomNum
			(else 
				(if (> (ego x?) 146)
					(ego posn: 290 170 view: 292 moveSpeed: 2)
				else
					(ego posn: 30 170 view: 292 moveSpeed: 2) ;far side of rock
				)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
;;;		(if
;;;			(and
;;;				(& (ego onControl:) $4000)
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 14)
;;;		)
;;;		(if
;;;			(and
;;;				(& (ego onControl:) 2) ;darkblue
;;;				(== script 0)
;;;			)
;;;			(curRoom setScript: FallDown)
;;;		)
;;;		(if
;;;			(and
;;;				(& (ego onControl:) 4) ;green
;;;				(== script 0)
;;;			)
;;;			(ego setPri: 2)
;;;			(curRoom setScript: FallDown)
;;;		)
;;;		(if
;;;			(and
;;;				(> (ego y?) 194)
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 803)
;;;		)	
	)
	
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(cond 
			((Said 'look>')
				(cond 
					((Said '/rock,stone') (Print {There is something unsettling about the thought of passing a kidney stone this size.}))
					((Said '[<around,at,in][/area,!*]') (Print {After treking all the way out here, it seems there is little to do other than bask in the grandure of its sheer size.}))
				)
			)
		)
	)
)


