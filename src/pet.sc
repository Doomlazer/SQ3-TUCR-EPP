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
)

(procedure (CommandPet &tmp temp0 [str 100])
	(= temp0
		(Print
			(Format {%s awaiting command?} petName)
			#button {Morph} 1
			#button {Converse} 2
			#button {Mode} 3
			#button {Rename} 4
			#button {Shutdown} 5
		)
	)
	(switch temp0
		(1
			(Print {*MORP*} #title petName #dispose #time 3 #at (- (petActor x?) 25) (- (petActor y?) 40))
			(= morphTimer (Random 500 1000))
			(= petView (Random 0 29))
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
	(Print {"Names are case sensitive and can always be changed by typing the pet's current name and selecting the 'rename' option."})
	(Print {"Type a unique, one word name for your pet now to initialize."})
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
		(if (not (== petView 309))
			(= morphTimer (Random 50 300))
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
					(Print {A robotic voice eminitates from the device, "Beginning Virtual Pet Initialization..."})
					(Print {"Welcome to Virtual Pet setup!"})
					(Printf {"To fully engage with your new pet you must assign it a name."})
					(PetRename)
				)
;;;				(if (not (StrCmp petName {RESET}))
;;;					(Print {Thank you for purchasing me. Please give me a name.})
;;;					(= acceptName 1)
;;;				)
			)
		)
	)
	
	(method (doit)
		(cond
;;;			((== petMode 0) ;was off
;;;				(Print {Virtual Pet Initialization process...})
;;;				(Printf {Call pet name for interaction.\nNAME IS: %s} petName)
;;;				(= petActive 1)
;;;			)
			((> morphTimer 1)
				(-- morphTimer)
			)
			((== morphTimer 1)
				(-- morphTimer)
				(= petView 309)
				(petActor view: 309)
			)
			((== petMode 0) ;was off
				(self changeState: 0)
				(petActor show:)
				(= petMode 1)
			)
			((== petMode 1) ;auto
				(if (== (Random 0 500) 10)
					(switch (Random 0 6)
						(1
							(client
								setStep: (Random 1 4)
								setMotion: Wander
							)
						)
						(2 ;morph for a few seconds
							(Print {*MORPHING*} #dispose #time 3 #at (petActor x?) (- (petActor y?) 15))
							(= petView (Random 0 29))
							(petActor view: petView)
							(= morphTimer (Random 50 120))
						)
						(else
							(client
								setStep: (Random 1 4)
								setMotion: Follow ego (Random 5 150)
							)
						)
					)
				)
			)
			((== petMode 2) ;Follow
				(client
					setStep: (Random 3 4)
					setMotion: Follow ego (Random 5 40)
				)
			)
			((== petMode 3) ;stay
				(client
					setCycle: Forward
					setMotion: 0
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
;;;				(cond 
;;;					((Said 'look>')
;;;						(cond 
;;;							((Said '/six') 
;;;								(Print {"iPet v0.00.01 A Weyland Corp. Product"})
;;;							)
;;;;;;							((Said '[<at,around,in][/area,!*]')
;;;;;;								(Print {Besides Six, your iPet...})
;;;;;;								(event claimed: FALSE)
;;;;;;							)
;;;						)
;;;					)
;;;					((Said 'converse/six')
;;;						(Print {"Hello, Master?" What is your command?})
;;;					)
;;;				)
			)
		)
	)
)

;;;(instance clunk of Sound
;;;	(properties
;;;		number 75
;;;		priority 5
;;;	)
;;;)
;;;