;;; Sierra Script 1.0 - (do not remove this comment)
(script# 810)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room810 0
)

(local
	local0
	local1
)


(instance Room810 of Room
	(properties
		picture 808
		east 808
	)
	
	(method (init)
		(super init:)
		(= local0 3)
		(= local1 3)
		(door init: stopUpd:)
		(holoDoor init: stopUpd:)
		(quark init:)
		(theMusic number: 401)
		(if (and (!= prevRoomNum 27) (!= prevRoomNum 808))
			(theMusic play: loop: 1)
		)
		(switch prevRoomNum
			(808
				(ego posn: 315 (ego y?) loop: 1)
				;(self setScript: RoomScript)
			)
			(else 
				(ego posn: 310 140 loop: 1)
			)
		)
		(ego init:)
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
				
			)
			(1
				(RedrawCast)
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 298 ;56
			setLoop: 2
			setCel: 0
			posn: 156 95
			setPri: 6
			ignoreActors: TRUE
		)
	)
	
	(method (doit)
		(super doit:)
		(if (not (curRoom script?))
			(cond 
				(
					(or
						(== (ego onControl: 0) 2)
						(== (ego onControl: 0) 3)
					)
					(if (> local0 1)
						(= local0 1)
						(self setCycle: EndLoop self)
					)
				)
				((< local0 2) (= local0 3) (self setCycle: BegLoop self))
			)
		)
	)
	
	(method (cue)
		(door stopUpd:)
		(= local0 (if (== local0 1) 0 else 2))
	)
)

(instance holoDoor of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 299
			setLoop: 0
			setCel: 0
			posn: 229 120
			setPri: 8
			ignoreActors: TRUE
		)
	)
	
	(method (doit)
		(super doit:)
		(if (not (curRoom script?))
			(cond
				( 
					(or
						(== (ego onControl: 0) 16)
						(== (ego onControl: 0) 17)
					)
					(if (> local1 1)
						(= local1 1)
						(self setCycle: EndLoop self)
					)
				)
				((< local1 2) (= local1 3) (self setCycle: BegLoop self))
			)
		)
	)
	
	(method (cue)
		(holoDoor stopUpd:)
		(= local1 (if (== local1 1) 0 else 2))
	)
)


(instance quark of Actor
	(properties)
	
	(method (init)
		(super init:)
		(self
			x: 330
			y: 107
			view: 297
			setLoop: 0
			setCel: 0
			setPri: 7
			illegalBits: 0
			ignoreActors: 1
		)
		(self setScript: quarkScript)
	)
	
	(method (doit)
		(super doit:)
		(if (== (quark loop?) 0)
			(if (== (Random 0 40) 5)
				(quark cel: (Random 0 2))
			)	
		)	
	)
)

(instance quarkScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(quark
					loop: 2
					setMotion: MoveTo 305 107 self	
				)
			)
			(1
				(quark loop: 0 cel: 0)
				(= seconds (Random 2 15))
			)
			(2
				(quark
					loop: 1
					setMotion: MoveTo 330 107 self	
				)	
			)
			(3
				(quark loop: 0 cel: 0)
				(= seconds (Random 2 15))	
			)
			(4
				(= state -1)
				(= cycles 1)	
			)
		)
	)	
)