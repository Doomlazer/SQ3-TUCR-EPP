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
(use Wander)

(public
	Room823 0
)

(instance captivePet of Prop
	(properties)
)

(instance raven of Actor
	(properties)
)

(instance cat of Actor
	(properties)
)

(instance hen of Actor
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
			posn: 25 75
			setPri: 4
			cycleSpeed: 4
			init:
		)
		(captivePet setScript: captivePetScript)
		(raven
			view: 823
			loop: 1
			;setCycle: Forward
			posn: 95 150
			setPri: 15
			cycleSpeed: 2
			init:
		)
		(raven setScript: ravenScript)
		(cat
			view: 822
			loop: 4
			setCycle: Forward
			posn: (Random 120 230) 90
			setPri: 9
			cycleSpeed: 2
			setStep: 1 1
			ignoreControl: $ffff
			init:
		)
		(cat setScript: catScript)
		(hen
			view: 824
			setCycle: Walk
			setMotion: Wander
			posn: (Random 120 230) 150
			cycleSpeed: 2
			setStep: 1 1
			ignoreActors: FALSE
			init:
		)
		(hen setScript: henScript)
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
						(captivePet view: 310 posn: 25 75)
					)
					((== (captivePet view?) 310)
						(captivePet view: 311 posn: 25 70 )
					)
					((== (captivePet view?) 311)
						(captivePet view: 309 posn: 25 75)
					)
				)
				(= seconds 4)
			)
			(1
				(captivePet hide:)
				(Display
					{virtual}
					p_width 100
					p_at 8 45
					p_color 2 ;green 
					p_font 600
				)
				(= seconds 1)
			)
			(2
				(Display
					{pet}
					p_width 100
					p_at 17 55
					p_color vYELLOW 
					p_font 600
				)
				(= seconds 1) 
			)
			(3
				(Display
					{sale}
					p_width 100
					p_at 15 65
					p_color vRED
					p_font 600
				)
				(= seconds 1)
			)
			(4
				(Display
					{virtual}
					p_width 100
					p_at 8 45
					p_color vBLACK 
					p_font 600
				)
				(Display
					{pet}
					p_width 100
					p_at 17 55
					p_color vBLACK
					p_font 600
				)
				(Display
					{sale}
					p_width 100
					p_at 15 65
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

(instance ravenScript of Script
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
				(raven setMotion: EndLoop self )
			)
			(1
				(switch (Random 1 4)
					(1 
						(raven loop: 0)
					)
					(else
						(raven loop: 1)
					)	
				)
				(raven setMotion: 0 cel: 0)
				(= state -1)
				(= seconds (Random 1 5))
			)
		)
	)
)

(instance catScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp i)
		(= state newState)
		(switch state
			(0
				(cat loop: (Random 4 6) setMotion: 0 posn: (cat x?) 90 setCycle: Forward)
				(= seconds (Random 20 50))
			)
			(1	
				(= i (Random 120 230))
				(while (< (Abs(- i (cat x?))) 50)
					(= i (Random 110 230))
				)
				(cat
					setCycle: Walk
					setMotion: MoveTo i 90 self
				)
				(= state -1)
			)
		)
	)
)

(instance henScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp i)
		(= state newState)
		(switch state
			(0
				(hen setMotion: Wander setCycle: Walk)
				(= seconds (Random 2 10))
			)
			(1	
				(hen
					loop: (if (== (hen loop?) 0) 4 else 5)
					setMotion: 0
					cel: 0
					setCycle: EndLoop self
				)
				
				(= state -1)
			)
		)
	)
)