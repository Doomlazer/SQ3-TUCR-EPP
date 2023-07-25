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
)

(local
	morphTimer
	prevX
	prevY
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
				)
				((== petView 310)
					(= petView 311)
					(petActor setCycle: Walk)
				)
				((== petView 311)
					(= petView 309)
					(petActor setCycle: Walk)
				)
			)
			(petActor view: petView)
		)
		(2
			(switch (Random 0 2)
				(0
					(Printf {"Hello, My name is %s. It's a pleasure to follow you around."} petName)
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
		(petActor
			view: petView ;309
			setCycle: Walk
			ignoreActors: FALSE
			illegalBits: cWHITE
			posn: (ego x?) (ego y?)
			setStep: 2
			setMotion: Follow ego (Random 10 75)
			show:
			init:
		)
		(petActor setScript: petScript)
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
				(if (== (Random 0 500) 10)
					(switch (Random 0 5)
						(1
							(client
								setStep: (Random 1 4)
								setMotion: Wander
							)
						)
						(else
							(client
								setStep: (Random 1 4)
								setMotion: Follow ego (Random 15 150)
							)
						)
					)
				)
			)
			((== petMode 2) ;Follow
				(client
					setStep: (Random 3 4)
					setMotion: Follow ego (Random 15 40)
				)
			)
			((== petMode 3) ;stay
				(if (== petView 310)
					(client
						setCycle: EndLoop
						setMotion: 0
					)
				else
					(client
						setCycle: Forward
						setMotion: 0
					)
				)
			)
			((== petMode 4) ;wander
				(if (== (Random 0 5000) 10)
					(== petMode 1) ;pet got board of wandering
				)
				(client
					setStep: (Random 1 4)
					setMotion: Wander
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