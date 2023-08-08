;;; Sierra Script 1.0 - (do not remove this comment)
(script# 26)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)
(use Follow)
(use Wander)

(public
	initScript 0
	CommandPet 1
	PetRename 2
	WarpToEgo 3
	WarpOffScreen 4
	PetGoggleVision 5
)

(local
	morphTimer
	prevX
	prevY
	shrink
	petGoggles
	wT
)

(procedure (PetGoggleVision s)
	(if s
		(= petGoggles 3)
	else
		(= petGoggles 0)
	)
	(petActor view: (+ (+ petView shrink) petGoggles))
)

(procedure (WarpToEgo)
	(petActor view: (+ (+ petView shrink) petGoggles) posn: (ego x?) (ego y?))
	(= petMode 2) ;follow
)

(procedure (WarpOffScreen)
	(petActor  view: (+ (+ petView shrink) petGoggles) posn: 1000 1000)
	(= petMode 3) ;stay
)

(procedure (CommandPet &tmp temp0 [str 100])
	(= temp0
		(Print
			(Format @str {Tell %s:} petName)
			#button {Morph} 1
			#button {Converse} 2
			#button {Mode} 3
			#button {Rename} 4
			#button {Shutdown} 5
		)
	)
	(switch temp0
		(1
			(Print {*MORPH*} #title petName #dispose #time 3 #at (- (petActor x?) 25) (- (petActor y?) 40))
			;(= morphTimer (Random 500 1000))
			(cond
				((== petView 309)
					(= petView 310)
					(petActor
						ignoreActors: FALSE
						illegalBits: cWHITE
						;cycleSpeed: 2
						;cycle controled by doit
					)
				)
				((== petView 310)
					(= petView 311)
					(petActor
						setCycle: Forward
						ignoreActors: TRUE
						illegalBits: 0
						;cycleSpeed: 2
					)
				)
				((== petView 311)
					(= petView 309)
					(petActor
						setCycle: Walk
						ignoreActors: FALSE
						illegalBits: cWHITE
						;cycleSpeed: 1
					)
				)
			)
			(petActor view: (+ (+ petView shrink) petGoggles))
		)
		(2
			(switch (Random 0 2)
				(0
					(Printf {"Thank you for naming me, %s. It's so much better than what my previous owner named me."} petName)
				)
				(1
					(Printf {"Your lucky numbers are: %d %d %d"} (Random 0 99) (Random 0 99) (Random 0 99))
				)
				(2
					(Printf {%s says, "NEED INPUT!"} petName)
				)
				(4
					(Printf {"I need to be programed with more responses."})
				)
			)
		)
		(3
			(= petMode ;0-off, 1-auto, 2-follow, 3-stay, 4-wonder
				(Print
					{SET MODE:}
					#button {AUTO} 1
					#button {FOLLOW} 2
					#button {STAY} 3
					#button {WANDER} 4
					#button {OFF} 5
				)
			)
			(= wT 0)
			(if
				(and
					(< petMode 5)
					(> petMode 0)
				)
				(switch (Random 0 1)
					(0
						(Print {"Yes, master!"} #title petName #dispose #time 3 #at (- (petActor x?) 25) (- (petActor y?) 40))
					)
					(1
						(Print {"As you wish."} #title petName #dispose #time 3 #at (- (petActor x?) 25) (- (petActor y?) 40))
					)
				)
			)
		)
		(4 ;rename
			(PetRename)
		)
		(5
			(Printf {%s shutting down...} petName)
			(= petMode 5)
		)
	)
)

(procedure (PetRename)
	(Print {"In adhearance with SCI Standards, all virtual pet names must be unique to avoid conflicts with other common voice recognition devices."})
	(Print {"Names such as LOOK, DOOR, or SHIP are invalid. Names like PICKLES, BLOBBY, or DEFENESTRATION are vaild because they are not officially recognized in SCI Vocaulary."})
	(Print {"Type a unique name for your pet immediately following this message to initialize."})
	(= petMode 99)
)

(instance petActor of Actor
	(properties)
)

(instance initScript of Script
	(properties)
	
	(method (init)
		(= wT 0)
		(if
			(or
				(== curRoomNum 800)
				(== curRoomNum 116)
			)
			(= shrink 6)	
		else
			(= shrink 0)
		)
		(petActor
			view: (+ (+ petView shrink) petGoggles)
			setCycle: (if (== petView 311) Forward else Walk)
			ignoreActors: (if (== petView 311) TRUE else FALSE) ;ghost walks through walls
			illegalBits: (if (== petView 311) 0 else cWHITE)
			posn: (if (cast contains: ego) (ego x?) else 1000) (if (cast contains: ego) (ego y?) else 1000)
			setStep: (if shrink 1 else 2) (if shrink 1 else 2)
			setMotion: Follow ego (if shrink 10 else 20)
;;;			cycleSpeed:
;;;				(cond
;;;					((== petView 309) 1)
;;;					((== petView 310) 2)
;;;					((== petView 311) 2)
;;;				)
			show:
			init:
		)
		(petActor setScript: petScript)
		(if (not (cast contains: ego))
			(= petMode 3) ;stay
		)
		(self dispose:)
	)
)

(instance petScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not petInit)
					(client hide:)
					(Print {A robotic voice eminitates from the device, "Beginning Virtual Pet Initialization..."})
					(Print {"Welcome to Virtual Pet setup!"})
					(Printf {"To activate your new pet you must assign it a name."})
					(PetRename)
				)
			)
		)
	)
	
	(method (doit)
		(if (== petView 310) ;comlete jump
			(if
				(and
					(== prevX (client x?))
					(== prevY (client y?))
				)
				(if (< (client cel?) 4)
					(client setCycle: EndLoop)
				)
			else
				(client setCycle: Walk)
			)
			(= prevX (client x?))
			(= prevY (client y?))
		)
		(cond
			((== petMode 0) ;was off
				(self changeState: 0)
				(petActor show:)
				(= petMode 1)
			)
			((== petMode 1) ;auto
				(petActor show:)
				(if (== (Random 0 100) 10)
					(switch (Random 0 1)
						(1
							(client
								;setStep: (Random 1 4)
								setMotion: Wander 50
							)
						)
						(else
							(client
								;setStep: (Random 1 4)
								setMotion: Follow ego (Random 15 100)
							)
						)
					)
				)
			)
			((== petMode 2) ;Follow
				(client
					;setStep: (if shrink 1 else 3)
					setMotion: Follow ego (if shrink 10 else 20)
				)
			)
			((== petMode 3) ;stay
				(cond
					((== petView 309)
						(client
							setCycle: 0
							setMotion: 0
						)
					)
					((== petView 310)
						(client
							;setCycle: EndLoop
							setMotion: 0
						)
					)
					((== petView 311)
						(client
							setCycle: Forward
							setMotion: 0
						)
					)
				)
			)
			((== petMode 4) ;wander
				(if (== (Random 0 5000) 10)
					(== petMode 1) ;pet got board of wandering
				)
				(if (== wT 0)
					(client
						;setStep: (Random 1 4)
						setMotion: Wander 50
					)
					(++ wT)
				)
			)
			((== petMode 5) ;off
				(= petActive 0)
				(petActor hide:)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				;
			)
		)
	)
)