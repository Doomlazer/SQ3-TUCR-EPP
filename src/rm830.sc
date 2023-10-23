;;; Sierra Script 1.0 - (do not remove this comment)
(script# 830)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Wander)

(public
	Room830 0
)

(local
	
)

(instance slab of Prop
	(properties)
)

(instance Room830 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(if slabInChute
			(slab
				view: 828
				loop: 4
				cel: 1
				posn: 117 91
				init:
			)
		)
		(switch prevRoomNum
			(829
				(self setScript: RoomScript)
			)
			(831
				;reposition ego if needed
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(& (ego onControl:) $0040) ;ctlBROWN 
				(== script 0)
			)
			(curRoom newRoom: 829)
		)
	)
	
	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
		
		(if (Said 'use,read,look/sign,screen')
			(if (& (ego onControl:) $0010) ;ctlMAROON
				(curRoom newRoom: 831)
			else 
				(Print 830 0)
			)
		)
		(if (Said 'look>')
			(cond 
				((Said '[/area,around]')
					(Print 830 1)
					(Print 830 2)
				)
				((Said '/chute')
					(if slabInChute
						(Print 830 8)
					else
						(Print 830 3)
					)
				)
				((Said '/screen')
					(if (& (ego onControl:) $0010) ;ctlMAROON
						(curRoom newRoom: 831)
					else 
						(Print 830 0)
					)
				)
			)
		)
		(if (Said 'take/chute,eslab,device')
			(if slabInChute
				(if
					(and
						(& (ego onControl:) $0004) ;ctlGREEN 
						(== script 0)
					)
					(= slabInChute 0)
					(slab dispose:)
					(ego get: iESlab)
					(Print 830 6)
					(Print 830 7)
				else
					(Print 830 5)
				)
			else
				(Print 830 4)
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
				(ego
					posn: 160 200
					setMotion: MoveTo 160 185 self
				)
			)
			(1
				(if slabInChute
					(Print 830 9) ; roger forgot to take eSlab
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)