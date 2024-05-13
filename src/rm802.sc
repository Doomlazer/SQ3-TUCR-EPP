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

(local
	local0
)

(instance Room802 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(if towed
			(= picture 805)	
		)
		(super init:)
		(switch prevRoomNum
			(14
				(ego view: 63)
				(self setScript: RoomScript)
			)
			(803
				(ego posn: 266 198 loop: 3)
				(self setScript: fromSouthScript)
			)
			(else 
				(ego posn: 150 100 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(if
			(and
				(& (ego onControl:) $4000)
				(== script 0)
			)
			(curRoom newRoom: 14)
		)
		(if
			(and
				(& (ego onControl:) 2) ;darkblue
				(== script 0)
			)
			(curRoom setScript: FallDown)
		)
		(if
			(and
				(& (ego onControl:) 4) ;green
				(== script 0)
			)
			(ego setPri: 2)
			(curRoom setScript: FallDown)
		)
		(if
			(and
				(> (ego y?) 188)
				(== script 0)
			)
			(curRoom setScript: toSouthScript)
		)	
	)
	
	
	;(method (handleEvent pEvent)
		;(super handleEvent: pEvent)
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
					((Said 'look>')
						(cond
							((Said '/sign')
								(if towed
									(Print {It's the intergalactic symbol for restricted parking. It certainly would have been nice to see that before your ship was impounded!})
								else 
									(Print {What sign?})
								)
							)
							((Said '/ship')
								(if towed
									(Print {You could have sworn you left your spaceship around here somewhere. Perhaps that sign holds some clue as to its whereabouts?})
								else 
									(Print {It still looks as beautiful as the day you salvaged it from the trash heap.})
								)
							)
							((Said '/moon')
								(Print {You pause for a moment to take in the soft glow of Ren's only moon, Stimpy.})
							)
							((Said '/drop,cliff')
								(Print {I'd keep a good distance from the edges, Roger. It doesn't seem like safety is a priority on this planet!})
							)
							((Said '[/anyword]')
								(if towed
									(Print {Based on that no-parking sign, it's probably safe to assume that your ship has been towed. Before you cry foul, remember, ignorance of local planety parking laws is no excuse!})
								else 
									(Print {You've landed the Mallard in a rather precarious location with steep drops on either side of the path. Thankfully, the reflected light from Ren's moon should provide enough visibility to navigate without killing yourself.})
								)
							)
						)	
					)
					((Said 'read/sign')
						(if towed
							(Print {It's the intergalactic symbol for restricted parking. It certainly would have been nice to see that before your ship was impounded!})
						else 
							(Print {What sign?})
						)	
					)
				)
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
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					posn: 157 147 
					ignoreControl:
					setMotion: MoveTo 190 174 self
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

(instance FallDown of Script
	(method (doit)
		(super doit:)
		(if (== (fallSound prevSignal?) -1)
			(= local0 1)
		)
		(if (or local0 (== (fallSound state?) 0))
			(= local0 0)
			
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(ego setLoop: setCel: 0 setStep: 6 12 setCycle: 0)
				(RedrawCast)
				(ego setMotion: MoveTo (ego x?) 229)
				(ohnoScript changeState: 0)
			)
			(1
				(EgoDead 0 0 0 27)
			)
		)
	)
)

(instance ohnoScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ohno init: setCycle: EndLoop self)
			)
			(1
				(ohno dispose:)
			)
		)
	)
)

(instance ohno of Prop
	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (ego priority?)
			posn: (ego x?) (- (ego y?) 40)
			ignoreActors: TRUE
		)
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

;;;(instance boom of Sound
;;;	(properties
;;;		number 78
;;;		priority 1
;;;	)
;;;)
;;;

(instance toSouthScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					ignoreControl:
					setMotion: MoveTo (+ (ego x?) 5) 199 self
				)
			)
			(1
				(RedrawCast)
				(HandsOn)
				(curRoom newRoom: 803)
			)
		)
	)
)

(instance fromSouthScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					ignoreControl:
					setMotion: MoveTo 260 185 self
				)
			)
			(1
				(HandsOn)
				(fromSouthScript dispose:)
			)
		)
	)
)
