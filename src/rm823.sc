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

(local
	fc1
	fc2
	fc3
	f1w
	f2w
	f3w
	hw
	cw
	rw
	cpw
	greet
	introduced
	kickOut
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

(instance fish1 of Actor
	(properties)
)

(instance fish2 of Actor
	(properties)
)

(instance fish3 of Actor
	(properties)
)

(instance salesman of Actor
	(properties)
)

(instance petDevice of Prop
	(properties)
)


(instance Room823 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		
		(if (not (ego has: iPetInv))
			(petDevice 
				view: 828
				loop: 4
				posn: 15 86
				init:
			)
		)
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
		(fish1
			view: 826
			setCycle: Forward
			;posn: (Random 85 233) (Random 46 76) ;85 46 233 76
			posn: 140 46
			setPri: (Random 2 4)
			cycleSpeed: 2
			setStep: 1 1
			ignoreControl: $ffff
			ignoreActors: TRUE
			init:
		)
		(fish1 setScript: fish1Script)
		(fish2
			view: 829
			setCycle: Forward
			;posn: (Random 85 233) (Random 46 76) ;85 46 233 76
			posn: 140 46
			setPri: (Random 2 4)
			cycleSpeed: 2
			setStep: 1 1
			ignoreControl: $ffff
			ignoreActors: TRUE
			init:
		)
		(fish2 setScript: fish2Script)
		(fish3
			view: 830
			setCycle: Forward
			;posn: (Random 85 233) (Random 46 76) ;85 46 233 76
			posn: 140 46
			setPri: (Random 2 4)
			cycleSpeed: 2
			setStep: 1 1
			ignoreControl: $ffff
			ignoreActors: TRUE
			init:
		)
		(fish3 setScript: fish3Script)
		(salesman
			view: 828
			setCycle: Walk
			posn: 163 106
			loop: 2
			ignoreControl: $ffff
			ignoreActors: TRUE 
			init:
		)
		(salesman setScript: salesmanScript)
		(switch prevRoomNum
			(824
				(self setScript: RoomScript)
			)
			(300
				(= greet TRUE)
				(= introduced TRUE)
			)
			(else 
				(self setScript: RoomScript)
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
		(if cpw
			(-- cpw)
			(if (== cpw 0)
				(self cue:)
			)
		)
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
				(= cpw 80)
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
				(= cpw 10)
			)
			(2
				(Display
					{pet}
					p_width 100
					p_at 17 55
					p_color vYELLOW 
					p_font 600
				)
				(= cpw 10) 
			)
			(3
				(Display
					{sale}
					p_width 100
					p_at 15 65
					p_color vRED
					p_font 600
				)
				(= cpw 40)
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
		(if rw
			(-- rw)
			(if (== rw 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(client setMotion: EndLoop self )
			)
			(1
				(switch (Random 1 4)
					(1 
						(client loop: 0)
					)
					(else
						(client loop: 1)
					)	
				)
				(client setMotion: 0 cel: 0)
				(= state -1)
				(= rw (Random 10 60))
			)
		)
	)
)

(instance catScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if cw
			(-- cw)
			(if (== cw 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp i)
		(= state newState)
		(switch state
			(0
				(client loop: (Random 4 6) setMotion: 0 posn: (cat x?) 90 setCycle: Forward)
				(= cw (Random 200 500))
			)
			(1	
				(= i (Random 120 230))
				(while (< (Abs(- i (cat x?))) 50)
					(= i (Random 110 230))
				)
				(client
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
		(if hw
			(-- hw)
			(if (== hw 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp i)
		(= state newState)
		(switch state
			(0
				(client setMotion: Wander setCycle: Walk)
				(= hw (Random 20 100))
			)
			(1	
				(client
					loop: (if (== (client loop?) 0) 4 else 5)
					setMotion: 0
					cel: 0
					setCycle: EndLoop self
				)
				
				(= state -1)
			)
		)
	)
)

(instance fish1Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(++ fc1)
		(if
			(or
				(and
					(< (client x?) 190)
					(< (client y?) 51)
				)
				(and
					(> (client x?) 147)
					(< (client x?) 190)
					(< (client y?) 59)
				)
			)
			(if
				(and
					(> fc1 100)
					(not (client inRect: (fish2 nsLeft?)(fish2 nsTop?)(fish2 nsRight?)(fish2 nsBottom?)))
					(not (client inRect: (fish3 nsLeft?)(fish3 nsTop?)(fish3 nsRight?)(fish3 nsBottom?)))
				)
				(= fc1 0)
				(client setPri: (if (== (client priority?) 4) 2 else 4))
			)
		)
		(if f1w
			(-- f1w)
			(if (== f1w 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp fx fy)
		(= state newState)
		(= fx (Random 85 233))
		(= fy (Random 46 76))
		(switch state
			(0
				(client posn: fx fy)
				(self cue:)
			)
			(1
				(= fx (Random 85 233))
				(= fy (Random 46 76))
				(client
					loop: (if (>= fx (client x?)) 0 else 1)
					setMotion: MoveTo fx fy self
				)
			)
			(2	
				(= state 0)
				(= f1w (Random 10 30))
			)
		)
	)
)

(instance fish2Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(++ fc2)
		(if
			(or
				(and
					(< (client x?) 190)
					(< (client y?) 51)
				)
				(and
					(> (client x?) 147)
					(< (client x?) 190)
					(< (client y?) 59)
				)
			)
			(if
				(and
					(> fc2 100)
					(not (client inRect: (fish1 nsLeft?)(fish1 nsTop?)(fish1 nsRight?)(fish1 nsBottom?)))
					(not (client inRect: (fish3 nsLeft?)(fish3 nsTop?)(fish3 nsRight?)(fish3 nsBottom?)))
				)
				(= fc2 0)
				(client setPri: (if (== (client priority?) 4) 2 else 4))
			)
		)
		(if f2w
			(-- f2w)
			(if (== f2w 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp fx fy)
		(= state newState)
		(= fx (Random 85 233))
		(= fy (Random 46 76))
		(switch state
			(0
				(client posn: fx fy)
				(self cue:)
			)
			(1
				(= fx (Random 85 233))
				(= fy (Random 46 76))
				(client
					loop: (if (>= fx (client x?)) 0 else 1)
					setMotion: MoveTo fx fy self
				)
			)
			(2	
				(= state 0)
				(= f2w (Random 30 60))
			)
		)
	)
)

(instance fish3Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(++ fc3)
		(if
			(or
				(and
					(< (client x?) 190)
					(< (client y?) 51)
				)
				(and
					(> (client x?) 147)
					(< (client x?) 190)
					(< (client y?) 59)
				)
			)
			(if
				(and
					(> fc3 100)
					(not (client inRect: (fish1 nsLeft?)(fish1 nsTop?)(fish1 nsRight?)(fish1 nsBottom?)))
					(not (client inRect: (fish2 nsLeft?)(fish2 nsTop?)(fish2 nsRight?)(fish2 nsBottom?)))
				)
				(= fc3 0)
				(client setPri: (if (== (client priority?) 4) 2 else 4))
			)
		)
		(if f3w
			(-- f3w)
			(if (== f3w 0)
				(self cue:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		; handle Said's, etc...
	)
	
	(method (changeState newState &tmp fx fy)
		(= state newState)
		(= fx (Random 85 233))
		(= fy (Random 46 76))
		(switch state
			(0
				(client posn: fx fy)
				(self cue:)
			)
			(1
				(= fx (Random 85 233))
				(= fy (Random 46 76))
				(client
					loop: (if (>= fx (client x?)) 0 else 1)
					setMotion: MoveTo fx fy self
				)
			)
			(2	
				(= state 0)
				(= f3w (Random 20 70))
			)
		)
	)
)

(instance salesmanScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
		(if (& (ego onControl:) $0800) ;ctlCYAN
			(if (not greet)
				(= greet TRUE)
				(self changeState: 100)
			)
		else
			(if greet
				(self changeState: 1)
				(= greet FALSE)
			)
		)
		(if (& (ego onControl:) $0020) ;ctlPURPLE
			(if (not kickOut)
				(= kickOut TRUE)
				(self changeState: 200)
			)	
		)
	)
	
	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(switch (event type?)
			(saidEvent
				(cond
					((Said 'converse/clerk,man,alien')
						(salesPrint 823 39)
						(salesPrint 823 40)
					) 
					((Said 'look>')
						(cond
							((Said '/clerk,man,alien') (Print 823 41))
							((Said '/cat') (Print 823 4))
							((Said '/fish') (Print 823 3))
							((Said '/hen') (Print 823 7))
							((Said '/bird') (Print 823 8))
							((Said '/aquarium') (Print 823 2))
							((Said '/pet[<virtual]') (Print 823 27)(salesPrint 823 17))
							((Said '[<at,around,in][/area,!*]') (Print 823 1))
						)
					)
					((Said 'smell[/area,air]') (Print 823 0))
					((Said 'touch,pet,take/cat') (salesPrint 823 5))
					((Said 'touch,pet,take/hen') (salesPrint 823 6))
					((Said 'touch,pet,take/bird') (salesPrint 823 9))
					((Said 'buy>')
						(if (& (ego onControl:) $0800) ;ctlCYAN 
							(cond
								((Said '/hen') (salesPrint 823 10))
								((Said '/bird') (salesPrint 823 11))
								((Said '/cat') (salesPrint 823 12))
								((Said '/fish') (salesPrint 823 14)(salesPrint 823 15))
								((Said '/pet[<virtual]')
									(if (ego has: iPetInv)	
										(salesPrint 823 16)
									else
										(salesPrint 823 18)
										(salesPrint 823 26)
										(= temp0
											(Print
												823 19
												#button {I'll take it!} 1
												#button {No, thank you.} 2
											)
										)
										(switch temp0
											(1
												(if (>= buckazoids 85)
													(salesman setScript: buyPetScript)
												else
													(Print 823 21)
												)
											)
											(else
												(salesPrint 823 20)
											)
										)
									)
								)
								((Said '/*') (salesPrint 823 13))
							)
						else
							(Print 823 23)
						)
						(event claimed: TRUE)
					)
					(
						(or
							(Said 'manual')
							(Said '*/manual')
							(Said '*[<*]/manual')
							(Said '*[<about]/manual')
							(Said 'manual/*')
						)
						(if (ego has: iPetInv)
							(salesPrint 823 38)
							(if (ego has: iESlab)
								(if (syncDoc)
									(salesPrint 823 34)	
								else
									(salesPrint 823 35)
								)
							else
								(salesPrint 823 36)
							)
						else
							(salesPrint 823 37)
						)
					)
				)
			)
		)
	)
	
	(method (changeState newState &tmp fx fy)
		(= state newState)
		(switch state
			(0
				(client posn: 150 106)
				(self cue:)
			)
			(1
				(client setMotion: MoveTo (Random 100 240) (client y?) self)
			)
			(2	
				(client cel: 0 loop: 2)
				(= state 0)
				(= seconds (Random 5 15))
			)
			(100
				(client setMotion: MoveTo (ego x?) (client y?) self)
			)
			(101
				(client cel: 0 loop: 2)
				(= cycles 2)
			)
			(102
				(if (not introduced)
					(= introduced TRUE)
					(salesPrint 823 24)
				)
			)
			(200
				(HandsOff)
				(client loop: 1)
				(= cycles 1)
			)
			(201
				(salesPrint 823 28)
				(= cycles 1)
			)
			(202
				(ego setMotion: MoveTo 45 106 self)
			)
			(203
				(= kickOut FALSE)
				(HandsOn)
				(self changeState: 1)
			)
		)
	)
)

(instance buyPetScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle

	)

	(method (changeState newState &tmp fx fy temp0)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(client setMotion: MoveTo 16 (client y?) self)
			)
			(1
				(client loop: 3)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(petDevice dispose:)
				(= cycles 8)
			)
			(3	
				(client setMotion: MoveTo (ego x?) (client y?) self)
			)
			(4
				(client loop: 2)
				(= cycles 2)
			)
			(5
				(= buckazoids (- buckazoids 85))
				(if (== buckazoids 0) (ego put: iBuckazoids -1))
				(ego get: iPetInv)
				(salesPrint 823 22)
				(Print 823 25)
				(= temp0 
					(Print 
						823 29
						#width 220
						#title {Clerk}
						#at -1 10
						#button {OK} 1
						#button {No, Thanks} 2
						#button {A what?} 3
					)
				)
				(switch temp0
					(1
						(if (ego has: iESlab)
							(if (syncDoc)
								(salesPrint 823 34)	
							else
								(salesPrint 823 35)
							)
						else
							(salesPrint 823 36)
						)
					)
					(2
						(salesPrint 823 30)
					)
					(3
						(salesPrint 823 31)
						(salesPrint 823 32)
					)
					(else
						(salesPrint 823 33)
					)
				)
 				(salesman setScript: salesmanScript)
				(salesmanScript changeState: 1)
				(HandsOn)
			)
		)
	)
)

(procedure (salesPrint text line)
	(Print text line #title {Clerk} #at -1 10)
)

(procedure (syncDoc &tmp i r)
	(= i 0)
	(= r 0)
	(while (< i 12)
		(if
			(and
				(== [owned i] 0)
				(not r)
			)
			(= r 1)
			(= [owned i] 301) ;upload virtual pet manual
		)
		(++ i)
	)
	(return r)
)