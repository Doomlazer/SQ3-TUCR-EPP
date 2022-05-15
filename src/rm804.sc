;;; Sierra Script 1.0 - (do not remove this comment)
(script# 804)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room804 0
)

(instance Room804 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(++ towed)
		(switch prevRoomNum
			(803
				(ego posn: 315 160 loop: 1)
				;(self setScript: RoomScript)
			)
			(806
				(ego posn: 170 85 view: 68 loop: 1) ;return from big rock
			)
			(else 
				(ego posn: 150 150 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		;(super doit:)
		; code executed each game cycle
		(if
			(and
				(& (ego onControl:) $4000) ;yellow - vist rock
				(== script 0)
			)
			(curRoom newRoom: 806)
		)
		(if
			(and
				(> (ego x?) 321)
				(== script 0)
			)
			(curRoom newRoom: 803) ;return to path
		)
		(if (< (ego y?) 116)		
			(ego view: 68 moveSpeed: 1)
		else
			(ego view: 0 moveSpeed: 0)
		)
	)
)
