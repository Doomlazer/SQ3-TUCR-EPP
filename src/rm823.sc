;;; Sierra Script 1.0 - (do not remove this comment)
(script# 823)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room823 0
)

(instance captivePet of Prop
	(properties)
)

(instance Room823 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(captivePet
			view: (Random 309 311)
			loop: 2
			setCycle: Forward
			posn: 25 85
			setPri: 4
			cycleSpeed: 4
			init:
		)
		(captivePet setScript: captivePetScript)
		(switch prevRoomNum
			(824
				(self setScript: RoomScript)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		; handle Said's, etc...
		(switch (event type?)
			(saidEvent
				(cond 
					((or (Said 'disembark,quit') (Said '/bye'))
						;(curRoom newRoom: 822)
					)
				)
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(& (ego onControl:) $0040) ;ctlBROWN 
				(== script 0)
			)
			(curRoom newRoom: 824)
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
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance captivePetScript of Script
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
				(cond
					((== (captivePet view?) 309)
						(captivePet view: 310 posn: 25 85)
					)
					((== (captivePet view?) 310)
						(captivePet view: 311 posn: 25 80 )
					)
					((== (captivePet view?) 311)
						(captivePet view: 309 posn: 25 85)
					)
				)
				(= seconds 4)
			)
			(1
				(captivePet hide:)
				(Display
					{virtual}
					p_width 100
					p_at 8 55
					p_color 2 ;green 
					p_font 600
				)
				(= seconds 1)
			)
			(2
				(Display
					{pet}
					p_width 100
					p_at 17 65
					p_color vYELLOW 
					p_font 600
				)
				(= seconds 1) 
			)
			(3
				(Display
					{sale}
					p_width 100
					p_at 15 75
					p_color vRED
					p_font 600
				)
				(= seconds 1)
			)
			(4
				(Display
					{virtual}
					p_width 100
					p_at 8 55
					p_color vBLACK 
					p_font 600
				)
				(Display
					{pet}
					p_width 100
					p_at 17 65
					p_color vBLACK
					p_font 600
				)
				(Display
					{sale}
					p_width 100
					p_at 15 75
					p_color vBLACK
					p_font 600
				)
				(= state -1)
				(self cue:)
				(captivePet show:)
			)
		)
	)
)