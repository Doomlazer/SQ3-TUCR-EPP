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

(local
	printObj
)

(instance captivePet1 of Actor
	(properties)
)

(instance mouth of Actor
	(properties)
)

(instance leftEye of Actor
	(properties)
)
(instance rightEye of Actor
	(properties)
)

(instance balloon of Prop
	(method (init)
		(super init:)
		(self
			view: 81
			setLoop: 0
			setCel: 1
			setPri: 15
			posn: 1000 1000
		)
	)
)

(instance Room823 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(captivePet1
			view: 309
			setCycle: Walk
			ignoreActors: FALSE
			illegalBits: cWHITE
			posn: (Random 150 290) (Random 90 115)
			setStep: 2
			init:
		)
		(captivePet1 setScript: captiveScript)
		(mouth
			view: 823
			loop: 0
			cel: 0
			posn: 81 91
			init:
		)
		(mouth setScript: salesPitch)
		(leftEye
			view: 823
			loop: 1
			cel: 0
			posn: 68 64
			init:
		)
		(leftEye setScript: blinkScript)
		(rightEye
			view: 823
			loop: 1
			cel: 0
			posn: 92 64
			init:
		)
		(balloon init:)
;;;		(switch prevRoomNum
;;;			(821
;;;				(self setScript: RoomScript)
;;;			)
;;;			(else 
;;;				(ego posn: 150 120 loop: 1)
;;;			)
;;;		)
;;;		(ego init:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		; handle Said's, etc...
		(switch (event type?)
			(keyDown
				(if printObj
					(ClearTalking)
					(event claimed: TRUE)
				)
			)
			(saidEvent
				(cond 
					((or (Said 'disembark,quit') (Said '/bye'))
						(curRoom newRoom: 822)
					)
					((Said '*')
						(salesPitch changeState: 100)
					)
				)
			)
		)
	)
	
	(method (doit)
		(super doit:)
;;;		(if
;;;			(or
;;;				(and
;;;					(> (ego x?) 138)
;;;					(>= (ego y?) 190)
;;;					(== (curRoom script?) 0) 
;;;				)
;;;				(and
;;;					(>= (ego x?) 320)
;;;					(== (curRoom script?) 0) 
;;;				)
;;;			)
;;;			(curRoom newRoom: 821)
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
;;;				(& (ego onControl:) $4000) ;yellow - back to ship
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 802)
;;;		)
;;;		(if
;;;			(and
;;;				(or 
;;;					(> (ego y?) 194)
;;;					(> (ego x?) 323)
;;;				)
;;;				(== script 0)
;;;			)
;;;			(curRoom newRoom: 804)
;;;		)
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
				(switch prevRoomNum
					(821
						(if (> (ego y?) 110)
							(ego
								posn: 330 170
								setMotion: MoveTo 310 160 self
							)
						else
							(ego
								posn: 200 195
								setMotion: MoveTo 190 185 self
							)
						)
					)
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

(instance captiveScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo (Random 150 290) (Random 90 115) self)
			)
			(1
				(= cycles (Random 0 20))
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance blinkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 30 200))
			)
			(1
				(leftEye setCycle: EndLoop self)
				(rightEye setCycle: EndLoop)
			)
			(2
				(leftEye setCycle: BegLoop self)
				(rightEye setCycle: BegLoop)	
			)
			(3
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance salesPitch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 1 10))
			)
			(1
				(alienTalks 50 47)
				(mouth  setCycle: Forward)
				(= printObj
					(Print {Hello, and welcom to Virtual Pet. Would you like to buy a pet?} #at -1 10 #width 280 #font 600 #dispose)
				)
				(= seconds 5)
			)
			(2
				(ClearTalking)
				(= cycles (Random 30 150))
			)
			(3
				(= state -1)
				(self cue:)
			)
			(100
				(= cycles 0)
				(= seconds 0)
				(alienTalks 50 47)
				(mouth  setCycle: Forward)
				(= printObj
					(Print {Sorry, this room is unfinished. Type EXIT to leave the store.} #at -1 10 #width 280 #font 600 #dispose)
				)
				(= seconds 5)
			)
			(101
				(= state -1)
				(self cue:)
			)
		)
	)
)

(procedure (alienTalks x y)
	(= saveDisabled TRUE)
	(balloon setCel: 1 posn: x y)
	(mouth setCycle: Forward)
)

(procedure (ClearTalking)
	(if printObj
		(balloon setCel: 3)
		(cls)
		(= printObj 0)
	)
	(if (not (== (mouth cel?) 0))
		(mouth setCycle: BegLoop)
	)
	(= saveDisabled 0)
)
