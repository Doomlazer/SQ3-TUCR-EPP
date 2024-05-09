;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include game.sh) (include menu.sh)
(use Intrface)
(use LoadMany)
(use Sound)
(use Save)
(use Jump)
(use Motion)
(use File)
(use Game)
(use Invent)
(use User)
(use Menu)
(use Actor)
(use System)
(use pet)
(use rm827)

(public
	SQ3 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	NotClose 5
	AlreadyDone 6
	SeeNothing 7
	CantDo 8
	DontHave 9
	RedrawCast 10
	ChangeSoundState 11
	cls 12
	InRoom 13
	PutInRoom 14
	IsObjectOnControl 15
	proc0_16 16
	EgoDead 17
	ToUpper 18
)

(local
	ego									;pointer to ego
	theGame								;ID of the Game instance
	curRoom								;ID of current room
	speed =  6							;number of ticks between animations
	quit								;when TRUE, quit game
	cast								;collection of actors
	regions								;set of current regions
	timers								;list of timers in the game
	sounds								;set of sounds being played
	inventory							;set of inventory items in game
	addToPics							;list of views added to the picture
	curRoomNum							;current room number
	prevRoomNum							;previous room number
	newRoomNum							;number of room to change to
	debugOn								;generic debug flag -- set from debug menu
	score								;the player's current score
	possibleScore						;highest possible score
	showStyle	=		IRISOUT			;style of picture showing
	aniInterval							;# of ticks it took to do the last animation cycle
	theCursor							;the number of the current cursor
	normalCursor =		ARROW_CURSOR	;number of normal cursor form
	waitCursor	 =		HAND_CURSOR		;cursor number of "wait" cursor
	userFont	 =		USERFONT		;font to use for Print
	smallFont	 =		4				;small font for save/restore, etc.
	lastEvent							;the last event (used by save/restore game)
	modelessDialog						;the modeless Dialog known to User and Intrface
	bigFont		=		USERFONT		;large font
	volume		=		12				;sound volume
	version		=		{x.yyy.zzz}		;pointer to 'incver' version string			
	locales								;set of current locales
	[curSaveDir 20]						;address of current save drive/directory string
	aniThreshold	=	10
	perspective							;player's viewing angle:
										;	 degrees away from vertical along y axis
	features							;locations that may respond to events
	sortedFeatures          			;above+cast sorted by "visibility" to ego
	useSortedFeatures					;enable cast & feature sorting?
	demoScripts							;add to curRoomNum to find room demo script
	egoBlindSpot						;used by sortCopy to exclude
										;actors behind ego within angle 
										;from straight behind. 
										;Default zero is no blind spot
	overlays	=		-1
	doMotionCue							;a motion cue has occurred - process it
	systemWindow						;ID of standard system window
	demoDialogTime	=	3				;how long Prints stay up in demo mode
	currentPalette
	modelessPort
	PTDCountDown
	PTDattachObj
	quirkJobKnown
	;globals 66-99 are unused
		global66
		global67
		global68
		global69
		global70
		global71
		global72
		global73
		global74
		global75
		global76
		global77
		global78
		global79
		global80
		global81
		global82
		global83
		global84
		global85
		global86
		global87
		global88
		global89
		global90
		global91
		global92
		global93
		global94
		global95
		global96
		global97
		global98
	lastSysGlobal
	;globals 100 and above are for game use
	programControl			;if TRUE, don't allow player control
	orderedBigBelcherCombo	;ego ordered Big Belcher Combo, and he'll throw up afterwards
	global102				;used in Aluminum Mallard
	haggledWithFester		;ego haggled with Fester Blatz over the gem
	global104				;used in Phleebhut
	egoInvisible			;if TRUE, ego is invisible thanks to the belt
	gPEventMessage
	gGEgoX_5
	gGEgoY_4
	global109
	terminatorState			;current state of the Terminator
	terminator				;pointer for Terminator object
	gGEgoX_4
	gGEgoY_3
	notifyCountdown			;time before notification
	global115				;unused
	global116				;unused
	roomWithDeadTerminator	;room where the Terminator was killed
	visitedPhleebhut		;been on Phleebhut
	sawScorpion				;saw the scorpion on Phleebhut
	beltState				;current state of the invisibility belt
	beltTimer =  1000		;time left of the invisibility belt
	pestulonGuardState		;current state of the Pestulon guards
	machineSpeed			;used by the speed tester to test how fast the system is
							; and used in determining game speed. (used in conjunction with howFast)
	howFast					;machine speed level (0 = slow, 1 = medium, 2 = fast)
	startingRoom			;room to start the game in
	wearingBelt				;ego is wearing the invisibility belt
	terminatorRemains		;pointer for Terminator remains
	theBelt					;pointer for invisibility belt object
	foundScumSoft			;ego found ScumSoft on Pestulon
	wearingChickenHat		;ego is wearing the Astro-Chicken hat
	ratStoleReactor			;the rat stole back the reactor. He won't do this again.
	global132				;? used for grabber
	climbedOutOfReactorRoom	;made it out of the reactor room. You can re-enter.
	global134				;related to getting the ladder, but is never set
	motivatorState	=	motivatorONFLOOR	;current state of warp drive motivator
	shipRepairLevel							;when this is at 4, the Aluminum Mallard is ready to go.
	global137				;unused
	global138				;unused
	global139				;unused
	global140				;unused
	global141				;unused
	global142				;unused
	global143				;unused
	global144				;unused
	global145				;unused
	global146				;unused
	gGGGNorth				;related to the warp drive motivator and grabber
	grabberState			;current state of the grabber
	roomWithMotivator =  2	;current room with warp drive motivator
	searchedPilotSeat		;searched the pilot's seat, got buckazoids
	sawTerminator			;saw the Terminator in Phleebhut
	visitedPhleebhutStore	;visited Fester Blatz's store
	theMusic				;pointer for music object
	buckazoids				;number of buckazoids in hand
	isHandsOff				;ego can't be controlled
	global156				;unused
	global157				;checked in room 6, but is never set
	enterpriseLeftMonolithBurger	;The U.S.S. Enterprise left Monolith Burger
	inCartoon =  TRUE		;if TRUE, the game is running a cutscene
	grabberRect				;rectangle of grabber
	global161
	gGEgoY_5
	global163
	global164
	global165
	global166
	global167
	global168
	examinedMallard			;examined the Aluminum Mallard
	decodedMessage			;decoded the secret message in Astro Chicken
	fryToDeathTimer			;time before dying on Ortega
	rockSankInLava			;the rock has sunk into the lava
	global173				;unused
	shipShieldHealth =  12	;amount of health the Mallard's shields have
	global175
	global176
	global177
	twoGuysOnBoard			;saved the Two Guys, and now they're on board
	global179					;lightspeed non functional?
	fallingIntoLava			;ego is falling into the lava
	global181
	wearingUnderwear		;ego is wearing the ThermoWeave shorts, and won't burn
	steppedOnUnstableRock	;ego stepped on the unstable rock
	ortegaEarthquakeWarning	;warned of Ortega earthquake
	badWordCount			;times said profanity in parser
	motivatorKnown			;ego knows the ship needs a warp drive motivator
	global187				;unused
	certainDeath			;message to play when ego dies
	teleportRoom			;room to teleport to in debug
	deathView				;death icon view
	deathLoop				;death icon loop
	deathCel				;death icon cel
	saveDisabled			;if TRUE, can't save
	ladderOnGround			;ladder fell on the ground
	global195				;unused
	global196				;unused
	dead					;if TRUE, bring up death message
	thisTime				;current system time
	oldSysTime				;previous system time
	debugging				;debug enabled
	grabberX				;x coord of grabber
	grabberY				;y coord of grabber
	sittingInCockpit		;ego is sitting in the pilot's seat
	global204				;unused
	shieldActivated			;if TRUE< the ship's shield is on
	global206
	global207
	global208
	global209
	shipLocation
	global211
	global212
	scanningSector
	currentSector =  75
	global215
	global216
	selectedSector
	global218
	global219
	global220
	global221
	global222
	global223
	global224
	global225
	gameSeconds				;elapsed seconds
	gameMinutes				;elapsed minutes
	gameHours				;elapsed hour
	global229				;unused
	oldCursor				;saved cursor
	enteredMallard			;has entered the Aluminum Mallard
	elmoAtDesk				;Elmo is at his desk
	scumSoftAlerted			;ScumSoft has been alerted to an intruder
	global234				;unused
	global235				;unused
	shadowDroidX			;x coord of droid shadow
	shadowDroidY			;y coord of droid shadow
	bridgeExtended			;bridge has been extended
	enteredConveyorBucket	;ego entered the conveyor bucket
	global240				;unused
	jumpedOntoRailing		;ego grabbed the railing
	scumSoftAnnouncement	;ScumSoft made its announcement
	global243
	monolithBurgerBill		;total owed for Monolith Burger order
	gGEgoX_3
	gGEgoY_2
	global247
	global248
	mealHasDecoderRing		;does the meal have a decoder ring?
	global250
	vaporCalcCued			;VaporCalc cued to appear
	calcOn		;VaporCalc is on screen
	ortegaWorkersLeft		;Ortega workers have left the planet
	lookedAtForceBeam		;ego saw the force beam
	global255
	forceBeamDestroyed		;Force beam has been destroyed. Pestulon can now be visited.
	shakeTimer				;time between screen shakes
	global258
	deathMessage			;buffer for death message
		global260
		global261
		global262
		global263
		global264
		global265
		global266
		global267
		global268
		global269
		global270
		global271
		global272
		global273
		global274
		global275
		global276
		global277
		global278
		global279
		global280
		global281
		global282
		global283
		global284
		global285
		global286
		global287
		global288
		global289
		global290
		global291
		global292
		global293
		global294
		global295
		global296
		global297
		global298
		global299
		global300
		global301
		global302
		global303
		global304
		global305
		global306
		global307
		global308
		global309
		global310
		global311
		global312
		global313
		global314
		global315
		global316
		global317
		global318
		global319
	deathTitle			;buffer for death title			
		global321
		global322
		global323
		global324
		global325
		global326
		global327
		global328
		global329
		global330
		global331
		global332
		global333
		global334
		global335
		global336
		global337
		global338
		global339
		global340
		global341
		global342
		global343
		global344
		global345
		global346
		global347
		global348
		global349
		global350
	theInvItem			;current inventory item
	global352
	global353
	global354
	global355
	global356
	global357
	global358
	global359
	global360
	global361
	global362
	global363
	global364
	global365
	global366
	global367
	global368
	global369
	global370
	global371
	global372
	global373
	global374
	global375
	global376
	global377
	global378
	global379
	global380
	global381
	global382
	global383
	global384
	global385
	global386
	global387
	global388
	global389
	global390
	global391
	global392
	global393
	global394
	global395
	global396
	global397
	global398
	global399
	global400
	global401
	invStr
	global403
	global404
	global405
	global406
	global407
	global408
	global409
	global410
	global411
	global412
	global413
	global414
	global415
	global416
	global417
	global418
	global419
	global420
	global421
	global422
	global423
	global424
	global425
	global426
	global427
	global428
	global429
	global430
	global431
	global432
	global433
	global434
	global435
	global436
	global437
	global438
	global439
	global440
	global441
	global442
	global443
	global444
	global445
	global446
	global447
	global448
	global449
	global450
	global451
	global452
	global453
	global454
	global455
	global456
	global457
	global458
	global459
	global460
	global461
	global462
	global463
	global464
	global465
	global466
	global467
	global468
	global469
	global470
	global471
	global472
	global473
	global474
	global475
	global476
	global477
	global478
	global479
	global480
	global481
	global482
	global483
	global484
	global485
	global486
	global487
	global488
	global489
	global490
	global491
	global492
	global493
	global494
	global495
	global496
	global497
	global498
	global499
	global500
	global501
	global502
	global503
	global504
	global505
	global506
	global507
	global508
	global509
	global510
	global511
	global512
	global513
	global514
	global515
	global516
	global517
	global518
	global519
	global520
	global521
	global522
	global523
	global524
	global525
	global526
	global527
	global528
	global529
	global530
	global531
	global532
	global533
	global534
	global535
	global536
	global537
	global538
	global539
	global540
	global541
	global542
	global543
	global544
	global545
	global546
	global547
	global548
	global549
	global550
	global551
	global552
	global553
	global554
	global555
	global556
	global557
	global558
	global559
	global560
	global561
	global562
	global563
	global564
	global565
	global566
	trashVaporized
	global568
	global569
	global570
	global571
	global572
	global573
	global574
	global575
	global576
	global577
	global578
	global579
	global580
	global581
	global582
	global583
	global584
	global585
	global586
	global587
	global588
	astroChickenPlays	;number of times you played Astro Chicken
	astroChickenScore	;top score on Astro Chicken
	global591
	global592
	ortegaPostBeamRooms	;number of room transitions after Ortega's force beam is destroyed.
						; if you take too long to leave the planet, you'll be killed by the earthquakes.
	global594
	global595			;appears to be unused
	climbedDownBattlebot
	enteredScumSoftHQ
	numColors			;number of colors supported by driver
	global599			;appears to be unused
	thePostcard
	mallardRisenFromDebris
	
	completedEnding
	towed ;is roger's ship towed?
	ticketed ;did roger buy the booth ticket on planet REN?
	gaveGem ;traded the gem to get ship out of impound
	egg ;counter for Ren teleportation easter egg
	
	tdx ;time disruptor x
	tdy
	tdv ;time disruptor view
	tdxs ;xstep
	tdys 
	tdl ; loop
	tdcs ;cycleSpeed
	tdill ;illegalBits
	tdicon ;ignore control
	tdobc ;observe control
	
	qtab = 0 ;quarks bar tab
	
	petInit
	petActive ;Roger's pet 
	petMode ;0-off, 1-auto, 2-follow, 3-stay, 4-wonder
	petView
	petName = {nermal}
	
	quarkAttacks
	quarksGoonsAttacking
	
	VCCel = [0 0 0 0 0 0 0 0 0 0 0 0] ;new and improved vaporcalc
	
	hBal = -32768
	sValue = [10 130 90 50 200 5]
	sPosn = [0 0 0 0 0 0]
	
	owned = [302 0 0 0 0 0 0 0 0 0 0 0]
	bookmark = [3 3 3 3 3 3 3 3 3 3 3 3]
	readerX
	readerY
	
	sDoorCodeDistance
	meetSV
	
	slabInChute ;for store 830
)

(procedure (NormalEgo theLoop theView)
	;normalizes ego's animation
	(if (> argc 0)
		(ego loop: theLoop)
		(if (> argc 1)
			(ego view: theView)
		)
	)
	(ego
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Walk
		setStep: 3 2
		looper: 0
		illegalBits: cWHITE
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: FALSE
	)
)

(procedure (HandsOff)
	;Disable ego control
	(User canControl: FALSE canInput: FALSE)
	(ego setMotion: 0)
	(= isHandsOff TRUE)
)

(procedure (HandsOn)
	;Enable ego control
	(User canControl: TRUE canInput: TRUE)
	(= isHandsOff FALSE)
)

(procedure (HaveMem howMuch)
	;check how much heap is available
	(return (> (MemoryInfo FreeHeap) howMuch))
)

(procedure (NotClose)
	(Print 0 35)
)

(procedure (AlreadyDone)
	(Print 0 36)
)

(procedure (SeeNothing)
	(Print 0 37)
)

(procedure (CantDo)
	(Print 0 38)
)

(procedure (DontHave)
	(Print 0 39)
)

(procedure (RedrawCast)
	;re-animate the cast without cycling
	(Animate (cast elements?) FALSE)
)

(procedure (ChangeSoundState soundObj theLoop)
	;seems to change a sound object's loop and state
	(soundObj loop: theLoop changeState:)
)

(procedure (cls)
	;Clear modeless dialog from the screen
	(if modelessDialog
		(modelessDialog dispose:)
	)
)

(procedure (InRoom what where)
	(return
		(==
			((inventory at: what) owner?)
			(if (== argc 1) curRoomNum else where)
		)
	)
)

(procedure (PutInRoom what where)
	((inventory at: what)
		owner: (if (== argc 1) curRoomNum else where)
	)
)

(procedure (IsObjectOnControl obj event)
	;check if an object is on a specific control
	(if (< argc 2)
		(= event (| keyDown mouseDown))
	)
	(OnControl
		(- (obj x?) event)
		(- (obj y?) event)
		(+ (obj x?) event)
		(+ (obj y?) event)
	)
)

(procedure (proc0_16)
	;Dummy proc?
)

(procedure (EgoDead theView theLoop theCel theDeath)
	(if (regions contains: (ScriptID 809)) 
		(if 
			(or 
				;(== curRoomNum 12) scrapyard rails not working, check rm13 for clues
				(== curRoomNum 52)
				(== curRoomNum 53)
				(== curRoomNum 60)
				(== curRoomNum 61)
				(== curRoomNum 62)
				(== curRoomNum 63)
				(== curRoomNum 64)
				(== curRoomNum 65)
				(== curRoomNum 66)
				(== curRoomNum 67)
				(== curRoomNum 68)
				(== curRoomNum 69)
				(== curRoomNum 70)
				(== curRoomNum 71)
				(== curRoomNum 75)
				(== curRoomNum 421) 
				(== curRoomNum 802)
				(== curRoomNum 803) 
			)
			(curRoom setScript:(ScriptID 809 1))
		else
			(ego setScript:(ScriptID 809 1))
		)
	else
		;ego dies
		(HandsOff)
		(= dead TRUE)
		(if (not theView)
			(= deathView 901)
		else
			(= deathView theView)
		)
		(= deathLoop theLoop)
		(= deathCel theCel)
		(= certainDeath theDeath)
	)
)

(procedure (DoStocks &tmp i t file [str 50])
	(= i 0)
	(while (< i 6)
		(switch (Random 1 3)
			(1
				(switch (Random 1 10)
					(1 
						(= [sValue i] (- [sValue i] (Random 10 30)))
					)
					(else
						(= [sValue i] (- [sValue i] (Random 0 6)))
					)
				)
			)
			(else
				(switch (Random 1 20)
					(1 
						(= [sValue i] (+ [sValue i] (Random 10 30)))
					)
					(else
						(= [sValue i] (+ [sValue i] (Random 0 3)))
					)
				)
			)
		)
		(if (< [sValue i] 1) (= [sValue i] 1))
		(if (> [sValue i] 32000) (= [sValue i] 32000))
		(++ i)
	)
;;;	;record stock moment
;;;	(if (< itr 180)
;;;		(= file (File new:))
;;;		(if (file name: "Stocks.txt" open: 0); fOPENCREATE)
;;;			(file write: (Format @str {%d, %d, %d, %d, %d, %d\n}[sValue 0] [sValue 1] [sValue 2] [sValue 3] [sValue 4] [sValue 5]))
;;;			(file close: dispose:)
;;;		else
;;;			(Print {stock file error})
;;;		)
;;;		(++ itr)
;;;	else
;;;		(Print {3 HOURS DONE})
;;;	)
	(UpdateStocks)
)

(procedure (DisplayPet v l c &tmp temp0 [str 100] pCel)
	(cond
		((== petView 311)
			(= pCel 3)
		)
		((== petView 309)
			(= pCel 4)
		)
		((== petView 310)
			(= pCel 5)
		)
	)
	(if (not petInit)
		(Print 
			{A virtual pet children's toy. It's awaiting initialization.}
			#icon 242 1 pCel
		)	
	else
		(if petActive
			(Print 
				(Format @str {Your virtual pet, %s. Current status: Activated.} petName)
				#icon 242 1 pCel
			)
		else
			(Print 
				(Format @str {Your virtual pet, %s. Current status: Deactivated.} petName)
				#icon 242 1 pCel
			)
		)
	)
)

(procedure (ActivatePet)
	;Pet
	(if
		(and
			(ego has: 20)
			petActive
		)
		(if
			(and
				(not (== curRoomNum 9))	;rails
				(not (== curRoomNum 10)) ;rails
				(not (== curRoomNum 11)) ;rails
				(not (== curRoomNum 12)) ;rails
				(not (== curRoomNum 14)) ;mallard int
				(not (== curRoomNum 17))
				(not (== curRoomNum 18))
				(not (== curRoomNum 19))
				(not (== curRoomNum 115)) ;an ending scene (pet can be in 116)
				(not (== curRoomNum 117)) ;an ending scene
				(not (== curRoomNum 290)) ;arcade game 1
				(not (== curRoomNum 470)) ;world o wonder
				(not (== curRoomNum 690)) ;telescope on lava planet
				(not (== curRoomNum 807)) ;teleport easter egg
				(not (== curRoomNum 814)) ;arcade game 2
			)
			(if (== (ego script?) 0)
				(ego setScript: (ScriptID 26 0))
			else
				(Print {"Error: Virtual Pet is experiencing issues in this location."})	
			)
		)
	)	
)

(procedure (Capitalize param1 &tmp [str 100] char)
	(StrCpy @str param1)
	(= char (StrAt @str 0))
	(if (and (<= 97 char) (<= char 122))
		(StrAt @str 0 (- char 32))
	)
	(return @str)
)

(procedure (ToUpper param1 &tmp [str 100] char i) ;string to uppercase
	(= i 0)
	(StrCpy @str param1)
	(while (< i (StrLen @str))
		(= char (StrAt @str i))
		(if (and (<= 97 char) (<= char 122))
			(StrAt @str i (- char 32))
		else
			(StrAt @str i char)
		)
		(++ i)
	)
	(return @str)
)

(procedure (RingPrint &tmp printObj [str 100] i t decoderNum [ringTable 26])
	;ringTable = [84 86 88 90 92 94 96 98 100 102 104 106 108 151 153 155 157 159 161 163 165 167 169 171 173 175]
	(= i 0)
	(while (< i 13)
		(= [ringTable i] (+ 84 (* 2 i)))
		(++ i)
	)
	(while (< i 26)
		(= [ringTable i] (+ (+ 84 (* 2 i)) 41))
		(++ i)
	)
	
	(= decoderNum (Random 5 20))
	(while (not (== printObj 2))
		(Format @str 290 10)
		(= i 0)
		(= t 0)
		(while (< i 26)
			(= t (+ (StrAt @str [ringTable i]) decoderNum))
			(if (> t 90)
				(= t (- t 26))	
			)
			(StrAt @str [ringTable i] t)
			(++ i)
		)	
		(= printObj
			(Print @str
				#font 777 ;603 use new fixed width "i"
				#icon 242 0 5
				#width 240
				#at -1 143
				#button {Rotate Left} 1
				#button {Done} 2 
				#button {Rotate Right} 3
				#advance
			)
		)
		(if (== printObj 1)
			(= decoderNum (- decoderNum 1))
			(if (< decoderNum 0)
				(= decoderNum 25)	
			)
		)
		(if (== printObj 3)
			(= decoderNum (+ decoderNum 1))
			(if (> decoderNum 25)
				(= decoderNum 0)	
			)
		)
	)
)

(instance statusCode of Code
	;draw the status line
	(method (doit strg)
		(Format strg 0 0
			score possibleScore 0 1
			{Space Quest \0B} 0 1
		)
	)
)

(instance egoObj of Ego
	(properties
		name "ego"
	)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

;;;(instance logFile of File)

(instance SQ3 of Game
	
	(method (init &tmp versionFile)
		(super init:)
		;set up the game's objects and globals
		(= numColors (Graph GDetect))
		(= version {0.000.001})
		(= versionFile (FOpen {version} 1))
		(FGets version 6 versionFile)
		(FClose versionFile)
		(= saveDisabled TRUE)
		(longSong owner: self init:)
		(= theMusic longSong)
		(User blocks: 0 canControl: FALSE x: -1 y: 160)
		(= ego egoObj)
		(User alterEgo: ego)
		(StatusLine code: statusCode)
		(theGame setSpeed: 5)
		(= systemWindow sysWindow)
		(TheMenuBar init:)
		(HandsOn)
		(= useSortedFeatures TRUE)
		(ScriptID SORTCOPY)
		(= possibleScore 738)
		(= userFont 300)
		;set up the inventory
		(inventory
			add:
				Glowing_Gem
				Wire
				Ladder
				Reactor
				Orat_on_a_Stick
				ThermoWeave_Underwear
				Astro_Chicken_Flight_Hat
				Monolith_Decoder_Ring
				Buckazoids
				Metal_Pole
				Thermal_Detonator
				Keycard
				Coveralls
				Vaporizer
				Elmo_s_picture
				a_copy_of_Elmo_s_picture
				Invisibility_Belt
				Bag_of_Fast_Food
				Time_Disruptor
				goggles
				petInv
				eSlab
				McGuffin
		)
		(= petView (Random 309 311))
		(= sDoorCodeDistance (Random 3 20))
		(if (GameIsRestarting)
			(TheMenuBar draw:)
			(StatusLine enable:)
			(= startingRoom 2)
			(self newRoom: 777)
		else
			(TheMenuBar state: TRUE)
			(= startingRoom 900)
			(self newRoom: 777)
		)
		(ego get: 21)
	)
	
	(method (doit &tmp haveMouse)
		
		;EO: this is a recreation, based on the decompiled doit: for Astro Chicken
		(if
			(and
				(!= curRoomNum 890)
				(!= curRoomNum 1)
				(!= curRoomNum 155)
			)
			(= haveMouse (HaveMouse))
			(if (not global592)
				(cond 
					(inCartoon
						(= oldCursor 69)
					)
					((== (User controls?) FALSE)
						(= haveMouse TRUE)
						(if (not calcOn)
							(= oldCursor waitCursor)
						)
					)
					(else
						(= oldCursor normalCursor)
					)
				)
				(if (!= theCursor oldCursor)
					(self setCursor: oldCursor haveMouse)
				)
			)
		)
		(if (== vaporCalcCued TRUE)
			(= vaporCalcCued FALSE)
			(= calcOn TRUE)
			;(calc init:)
			(if
				(and
					(== (ego script?) 0)
					(User canControl?)
				)
				(HandsOff)
				(ego setScript: (ScriptID 30))	
			else
				(Print {You can't use the VaporCalc right now.})
			)
		)

		;if ego died, bring up the death handler
		(if dead
			(= inCartoon FALSE)
			(theMusic
				number: (Random 23 24)
				loop: 1
				priority: 500
				play:
			)
			(switch certainDeath
				(1
					(= deathTitle {Deceleration Trauma})
					(= deathMessage {It wouldn't be so bad, except for the sudden stop at the end.
						__Next time, don't get so close to the edge.})
				)
				(2
					(= deathTitle {New, Improved Quick Tanning Method})
					(= deathMessage {You never did care for fondue.__Next time, don't get so close to the edge.})
				)
				(3
					(= deathTitle {Rats!})
					(= deathMessage {You may not be Purina Rat Chow, but you'll do!})
				)
				(4
					(= deathTitle {It Slices, It Dices...})
					(= deathMessage {You're a less-than-choice cut, Wilco!})
				)
				(5
					(= deathTitle {Decompression Blues})
					(= deathMessage {Sudden Decompression Sucks!})
				)
				(6
					(= deathTitle {A Slimmer, Trimmer You!})
					(= deathMessage {A quick, but painful, way to shed those extra inches.})
				)
				(7
					(= deathTitle {Learn to Drive That Thing!})
					(= deathMessage {Your radar is designed to avoid just such an occurrence.})
				)
				(8
					(= deathTitle {One Way to Lower Your Blood Pressure.})
					(= deathMessage {A brave but fatal attempt at arterial art.})
				)
				(9
					(= deathTitle {You have blown your `cover'.})
					(= deathMessage {You have demonstrated a surprising lack of janitorial skill.__
						Perhaps this would be an opportune time to `brush up' on your technique with Space Quest I and II.})
				)
				(10
					(= deathTitle {You have taken the big plunge.})
					(= deathMessage {That's one small step for man... One giant leap for janitor-kind.})
				)
				(11
					(= deathTitle {Sunbathing Not Recommended})
					(= deathMessage {It's so hot you could fry a Vorlian phlegmsnake egg.})
				)
				(12
					(= deathTitle {Don't Trust Guys in Black Spacesuits})
					(= deathMessage {A pulselaser blast to the forehead is not your idea of fun.__Fortunately, it didn't hit anything important.})
				)
				(13
					(= deathTitle {Down for the Count})
					(= deathMessage {Better hang out at the gym more often.})
				)
				(14
					(= deathTitle {Hole In One!})
					(= deathMessage {Hope you enjoy your new flow-through ventilation system.})
				)
				(15
					(= deathTitle {Just Like Mom Used to Make})
					(= deathMessage {As your life sputters to a close, you decide to cut down on desserts.})
				)
				;no 16-19
				(16
					(= deathTitle {It's a Bird...})
					(= deathMessage {What are the chances of something like that even happening? Hope you remmebered to save.})
				)
				(17 ;falling on Planet REN
					(= deathTitle {Hopefully, Nobody Heard You Scream!})
					(= deathMessage {You'd think you'd eventually learn to be more careful around ledges. Then again, you never cease to amaze.})
				)
				(18 ;frozen in space from teleporter on REN
					(= deathTitle {Brrr... It's Cold Up Here})
					(= deathMessage {Looks like Roger finally learned to "chill" out! Seriously though, you asphyxiated long before you even started to freeze.})
				)
				(20
					(= deathTitle {Be More Careful With Explosives})
					(= deathMessage {Didn't mom always tell you not to play with firecrackers?})
				)
				(else
					(= deathTitle {Congratulations On Your Recent Death !})
					(= deathMessage {Thanks for playing Space Quest ]I[. As usual, you've been a real hoot.})
				)
			)
			(repeat
				(switch
					(Print deathMessage
						#icon deathView deathLoop deathCel
						#mode teJustCenter
						#title deathTitle
						#button {Restore} 1
						#button {Restart} 2
						#button {Quit} 3
					)
					(1
						(theGame restore:)
					)
					(2
						(theGame restart:)
					)
					(3
						(= quit TRUE)
						(break)
					)
				)
			)
		else	;end of deaths
			(= global219 0)
			(= global223 0)
			;let the game's clock tick
			(if (!= (= thisTime (GetTime SYSTIME1)) oldSysTime)
				(= oldSysTime thisTime)
				(+= gameSeconds 1)
				(= global219 1)
				(if (>= gameSeconds 60)
					(++ gameMinutes)
					(= gameSeconds 0)
					(= global223 1)
					(DoStocks)
					(if (== gameMinutes 60)
						(++ gameHours)
						(= gameMinutes 0)
					)
				)
			)
		)
		(super doit:)
	)

	
	(method (replay)
		(TheMenuBar draw:)
		(StatusLine enable:)
		(SetMenu soundI p_text
			(if (DoSound SoundOn) {Turn Off} else {Turn On})
		)
		(super replay:)
	)
	
	(method (startRoom roomNum)
		;clean up after a room change
		(LoadMany FALSE
			RELDPATH TIMER GROOPER RFEATURE QSCRIPT DPATH SMOOPER COUNT 952
			FOLLOW STOPWALK DCICON WANDER MOUSER LASTLINK QSOUND SORT CAT GOTOSAID FORCOUNT
			CHASE NAMEFIND APPROACH TIMEDCUE TEXTRA ORBIT DEMO WINDOW TRACK AVOIDER
			SIGHT REVERSE 26 30 827 ;26=pet 30=VaporCalc 817=UpdateStocks
		)
		(if debugOn
			(= debugOn FALSE)
			(SetDebug)
		)
		;if memory is fragmented, bring up a warning and the internal debugger
		(if
			(and
				(u> (MemoryInfo FreeHeap) (+ 20 (MemoryInfo LargestPtr)))
				debugging
				(Print 0 2
					#button {Debug} 1
					#button {ignore} 0
				)
			)
			(SetDebug)
		)
		(super startRoom: roomNum)
		(if (== petMode 99)
			(= petMode 1) ;no name was chosen
		)
		(ActivatePet)
		(if (== prevRoomNum 300)
			(ego posn: readerX readerY)
		)
	)
	
	(method (handleEvent event &tmp item obj evt temp3 nextRoom evtX evtY evtMod temp8 [str 50])
		(if (event claimed?) (return))
		(super handleEvent: event)
		(if (== calcOn TRUE)
			((ScriptID 30) handleEvent: event)
			(if (== calcOn FALSE)
				(event claimed: TRUE)
				((ScriptID 30) dispose:)
			)
		)
		(switch (event type?)
			(saidEvent
				(cond
					((Said 'use/decoder,relic')
					 	(if (ego has: iDecoderRing)
					 		(RingPrint)
					 	else
					 		(DontHave)
						)
					)	
					((Said 'remove,take[<off]/goggles')
						(if (ego has: iGoggles)
							(Print 800 7)
						else
							(Print 800 11)
						)
					)
					((Said 'wear,use/goggles')
						(if (ego has: iGoggles)
							(if (== curRoomNum 470)
								(Print 800 12)
							else
								(Print 800 10)
							)
						else
							(Print 800 11)
						)
					)
					((Said 'activate,use,press/disruptor[<time]')
						(if (ego has: 18)
							(if (== curRoomNum 800) ;disable use
								(Print 800 24)
								(Print {*BZZTT*} #title {PTD} #at (- (ego x?) 30) (- (ego y?) 40))
								(Print 800 25)
								(Print 800 26)
							else
								(if (regions contains: (ScriptID 809)) 
									(Print 0 41)
								else
									(Print 0 40 #icon 242 1 1)
									(curRoom setRegions: 809)
								)	
							)	
						else
							(DontHave)
						)
					) 
					((Said 'use/eslab')
						(if (ego has: iESlab)
							(if (== (ego script?) 0)
								(= readerX (ego x?))
								(= readerY (ego y?))
								(curRoom newRoom: 300)
							else
								(Print 300 4)	
							)
						else
							(Print 300 5)
						)
					)
					((Said 'tp')
						(if (not debugging)
							(event claimed: FALSE)
						else
							(User canControl: TRUE)
							(= programControl FALSE)
							(if
								(and
									(!= (= nextRoom (GetNumber {Teleport to:})) 1)
									(!= nextRoom 900)
									(!= nextRoom 155)
								)
								(theMusic stop:)
								(= inCartoon FALSE)
								(= oldCursor normalCursor)
								(theGame setCursor: normalCursor (HaveMouse))
							)
							(= teleportRoom nextRoom)
							(= saveDisabled FALSE)
							(curRoom newRoom: nextRoom)
						)
					)
					((Said 'pump,backstage/shark,pass')
						(Print 0 3)
						(= debugging TRUE)
					)
					((Said 'wait')
						(Print 0 4)
					)
					((or (Said 'wear/belt') (Said 'drop<on/belt'))
						(if (ego has: iInvisibilityBelt)
							(if (not wearingBelt)
								(Print 0 5)
								(= wearingBelt TRUE)
							else
								(Print 0 6)
							)
						else
							(DontHave)
						)
					)
					(
						(or
							(Said 'use,activate/belt,invisibility')
							(Said 'turn<on/belt')
							(Said 'press/button/belt')
							(Said 'switch<on/belt')
						)
						(cond 
							((not (ego has: iInvisibilityBelt))
								(DontHave)
							)
							((not wearingBelt)
								(Print 0 7)
							)
							((== beltState beltDEPLETED)
								(Print 0 8)
							)
							(else
								(Print 0 9)
							)
						)
					)
					((Said 'wear,(drop<on)/panties')
						(cond 
							((not (ego has: iThermoUnderwear))
								(DontHave)
							)
							(wearingUnderwear
								(Print 0 10)
							)
							(else
								(Print 0 11)
							)
						)
					)
					((Said 'wear,(drop<on)/decoder')
						(if (not (ego has: iDecoderRing))
							(DontHave)
						else
							(Print 0 12)
						)
					)
					(
						(or
							(Said 'remove/attire')
							(Said 'get/naked')
							(Said 'undress')
							(Said 'remove/panties')
						)
						(Print 0 13)
					)
					((Said 'wear/cap')
						(if (ego has: iChickenHat)
							(Print 0 14)
						else
							(DontHave)
						)
					)
					((Said 'look/hand')
						(if ticketed
							(Print 0 45)
						else
							(Print 0 46)
						)	
					)
					((Said 'look/anemometer')
						(if (ego has: iMetalPole)
							(Print 0 15)
						else
							(DontHave)
						)
					)
					((Said 'look/belt')
						(cond 
							((not (ego has: iInvisibilityBelt))
								(DontHave)
							)
							((!= beltState beltDEPLETED)
								(Print 0 16)
							)
							(else
								(Print 0 17)
							)
						)
					)
					((Said 'converse/pet')
						(cond
							((not (ego has: iPetInv))
								(DontHave)
							)
							(else
								(if petInit
									(if petActive
										(if (== petMode 99)
											(PetRename)
										else
											(CommandPet)
										)
									else
										(Print {First activate the pet.})
									)
								else
									(Print {Initialize the pet first.})
								)
							)
						)
					)
					((Said 'look/pet')
						(cond 
							((not (ego has: iPetInv))
								(DontHave)
							)
							(else
								(DisplayPet)
							)
						)
					)
					(
						(or
							(Said 'init,activate/pet')
							(Said 'pet<on')
						)
						(cond 
							((not (ego has: iPetInv))
								(DontHave)
							)
							(else
								(if petInit
									(if petActive
										(Print {Pet is already initialized and active.})
									else
										(Print {Activating pet.})
										(= petMode 0)
										(= petActive 1)
										(ActivatePet)
									)
								else 
									(= petMode 0)
									(= petActive 1)
									(ActivatePet)
								)
							)
						)
					)
					(
						(or
							(Said 'deactivate/pet')
							(Said 'pet<off')
						)
						(cond 
							((not (ego has: iPetInv))
								(DontHave)
							)
							(else
								(if petActive
									(Print {deactivation sequence...})
									(= petMode 5)
								else
									(Print {Pet is already deactivated.})
								)
							)
						)
					)
					(
						(and
							(Said 'look>')
							(= item (inventory firstTrue: #saidMe))
						)
						(if (item ownedBy: ego)
							(item showSelf:)
						else
							(Print 0 18)
						)
					)
					((Said 'eat,drop,use')
						(Print 0 19)
					)
					((Said 'get')
						(cond 
							(
								(or
									(not debugging)
									(not (= item (inventory firstTrue: #saidMe)))
								)
								(Print 0 20)
							)
							((item ownedBy: ego)
								(Print 0 21)
							)
							(else
								(event claimed: FALSE)
							)
						)
					)
					((Said 'smell')
						(Print 0 22)
					)
					((Said 'throw')
						(Print 0 23)
					)
					((Said 'press')
						(Print 0 24)
					)
					((Said 'jump')
						(Print 0 25)
					)
					((Said 'jog')
						(Print 0 26)
					)
					((Said 'ass')
						(if (> (++ badWordCount) 25)
							(Print 0 27)
						else
							(Print 0 28)
						)
					)
					((or (Said 'inventory') (Said 'look,get/inventory'))
						(inventory showSelf: ego)
					)
				)
			)
			(mouseDown
				;debug code
				(if debugging
					(= evtX (event x?))
					(= evtY (event y?))
					(cond 
						((& (= evtMod (event modifiers?)) 10) ;shift+ALT+click
							(event claimed: TRUE)
							((User alterEgo?) setMotion: JumpTo evtX evtY)
						)
						((& evtMod shiftDown)
							(event claimed: TRUE)
							(= obj
								(Print
									(Format @str 0 29 evtX evtY)
									#at
									(cond 
										((< evtX 20) evtX)
										((< 300 evtX)
											(- evtX 40)
										)
										(else
											(- evtX 20)
										)
									)
									(if (< evtY 16)
										evtY
									else
										(- evtY 6)
									)
									#font 999
									#dispose
								)
							)
							(while (!= mouseUp ((= evt (Event new:)) type?))
								(evt dispose:)
							)
							(obj dispose:)
							(evt dispose:)
						)
						((& evtMod ctrlDown)
							(event claimed: TRUE)
							(while (!= mouseUp ((= evt (Event new:)) type?))
								((User alterEgo?)
									posn: (evt x?) (- (evt y?) 10)
									setMotion: 0
								)
								(Animate (cast elements?) FALSE)
								(evt dispose:)
							)
							(evt dispose:)
						)
						((& evtMod altDown)
							(event claimed: TRUE)
							((User alterEgo?) showSelf:)
						)
					)
				)
			)
			(keyDown
				;more debugging code
				(if (not debugging) (return))
				(switch (event message?)
					(`@l
						(if (== printLang ENGLISH)
							(= printLang GERMAN)
							(= subtitleLang ENGLISH)
						else
							(= printLang ENGLISH)
							(= subtitleLang GERMAN)
						)
					)
					(`@z
						(if debugging
							(event claimed: TRUE)
							(= quit TRUE)
						)
					)
					(`@e
						(Print
							(Format @str
								{view: %d loop: %d cel: %d posn: %d %d pri: %d OnControl: $%x Origin on: $%x}
								(ego view?)
								(ego loop?)
								(ego cel?)
								(ego x?)
								(ego y?)
								(ego priority?)
								(ego onControl:)
								(ego onControl: origin)
							)
							#icon (ego view?) (ego loop?) (ego cel?)
						)
					)
					(`@h
						(theGame showMem:)
						(event claimed: TRUE)
					)
					(`@r
						(Print (Format @str 0 30 curRoomNum))
					)
					(`@v
						(Show VMAP)
					)
					(`@p
						(Show PMAP)
					)
					(`@y
						(= invStr 0)
						(GetInput @invStr 8 {Inv. Object})
						(= theInvItem (ReadNumber @invStr))
						(= invStr 0)
						(GetInput @invStr 12 {Owner})
						(if (not (StrCmp {ego} @invStr))
							((inventory at: theInvItem) moveTo: ego)
						else
							((inventory at: theInvItem)
								moveTo: (ReadNumber @invStr)
							)
						)
						(= invStr 0)
					)
					(`@c
						(Show CMAP)
						(Animate (cast elements?))
						(while
						(== 0 ((= evt (Event new: allEvents)) type?))
							(evt dispose:)
						)
						(evt dispose:)
						(Show VMAP)
					)
				)
			)
		)
	)
	
	(method (wordFail word &tmp [str 100] [tWord 100] [tName 100])
		;don't recognize a word
		(StrCpy @tWord (ToUpper word))
		(StrCpy @tName (ToUpper petName))
		;(Printf {str: %s} @tWord)
		;(Printf {str2: %s} @tName)
		
		(if petActive
			;(if (not (StrCmp word petName)) ;name said	
			(if (not (StrCmp @tWord @tName))
				(CommandPet)
			else
				(if (== petMode 99)
					(= petMode 1) ;return to auto
					(StrCpy petName (Capitalize word))
					(Print (Format @str {"Pet has been successfully named: %s. Use your pet's name to access additional features."} petName))
					(= petInit 1)
				else
					(Print (Format @str 0 31 word))
				)
			)
		else
			;(if (not (StrCmp word petName)) ;name said
			(if (not (StrCmp @tWord @tName))
				(Print {Pet is currently deactivated.})
			else
				(Print (Format @str 0 31 word))
			)
		)
	)
	
	(method (syntaxFail)
		;can't parse input
		(Print 0 32)
	)
	
	(method (pragmaFail &tmp [str 100])
		;no response to event
		(Print 0 33)
	)
)

(instance Glowing_Gem of InvItem
	(properties
		said '/crystal[<glowing]/'
		description {You are still carrying the piece of orium you picked up on Labion during your last adventure. However, it has long since lost its glow.}
		view 242
		name "Glowing Gem"
	)
)

(instance Wire of InvItem
	(properties
		said '/cable'
		description {It's a piece of SQ-approved electrical wire.}
		owner 6
		view 242
		cel 1
	)
)

(instance Ladder of InvItem
	(properties
		said '/ladder/'
		description {This is a ladder. The evenly spaced rungs allow altitude adjustment.}
		owner 15
		view 242
		cel 2
	)
)

(instance Reactor of InvItem
	(properties
		said '/generator/'
		description {This is an auxiliary reactor.}
		owner 15
		view 242
		cel 3
	)
)

(instance Orat_on_a_Stick of InvItem
	(properties
		said '/orat,stick'
		description {Orat on a Stick! You can open his mouth, and close his mouth! Hours of fun for all!}
		owner 470
		view 242
		cel 8
		name "Orat on a Stick"
	)
)

(instance ThermoWeave_Underwear of InvItem
	(properties
		said '/panties'
		description {ThermoWeave Shorts.__They keep you cool, and they're oh, so stylish.}
		owner 470
		view 242
		cel 9
		name "ThermoWeave Underwear"
	)
)

(instance Astro_Chicken_Flight_Hat of InvItem
	(properties
		said '/cap'
		description {Wow! Your Official Astro Chicken Flight Hat!__Man, the babes'll really dig you in this!}
		owner 470
		view 242
		cel 6
		name "Astro Chicken Flight Hat"
	)
)

(instance Monolith_Decoder_Ring of InvItem
	(properties
		said '/decoder,prize'
		description {With this ring, you can decode any secret message!__Well, almost any secret message.}
		owner 29
		view 242
		cel 5
		name "Monolith Decoder Ring"
	)
)

(instance Buckazoids of InvItem
	(properties
		said '/bill'
		view 242
		cel 7
	)
	
	(method (showSelf)
		(Print
			(Format @invStr 0 34 buckazoids)
			#icon view loop cel
		)
	)
)

(instance Metal_Pole of InvItem
	(properties
		said '/pole'
		description {A handy metal pole.}
		owner 69
		view 242
		cel 11
		name "Metal Pole"
	)
)

(instance Thermal_Detonator of InvItem
	(properties
		said '/detonator'
		description {Used for blowing stuff to little bits.___It has an impact switch, so in other words...DON'T DROP IT!}
		owner 69
		view 242
		cel 12
		name "Thermal Detonator"
	)
)

(instance Keycard of InvItem
	(properties
		said '/card'
		description {Elmo Pug's personal keycard for opening locked doors.}
		owner 93
		view 242
		loop 1
	)
)

(instance Coveralls of InvItem
	(properties
		said '/attire'
		description {A pair of janitor's coveralls. Used for looking the part.}
		owner 90
		view 242
		cel 14
	)
)

(instance Vaporizer of InvItem
	(properties
		said '/mrgarbage'
		description {Mr. Garbage: a janitor's best friend. Designed to vaporize all nonorganic biodegradable matter (i.e. trash).}
		owner 90
		view 242
		cel 15
	)
)

(instance Elmo_s_picture of InvItem
	(properties
		said '/original'
		description {A fine likeness of Elmo Pug's mug. Elmo Pug is the dashing young owner of ScumSoft, Inc.}
		owner 92
		view 242
		cel 13
		name "Elmo's picture"
	)
)

(instance a_copy_of_Elmo_s_picture of InvItem
	(properties
		said '/copy'
		description {A fine likeness of a likeness of Elmo Pug's mug.}
		owner 92
		view 242
		cel 13
		name "a copy of Elmo's picture"
	)
)

(instance Invisibility_Belt of InvItem
	(properties
		said '/belt'
		description {Terminator's invisibility belt.}
		owner -1
		view 242
		cel 10
		name "Invisibility Belt"
	)
)

(instance Bag_of_Fast_Food of InvItem
	(properties
		said '/bag,dinner'
		description {A bag chock-full of gastric delights!}
		owner -1
		view 242
		cel 4
		name "Bag of Fast Food"
	)
)

(instance Time_Disruptor of InvItem
	(properties
		said '/disruptor[<time]'
		description {An illegal personal time disruptor. Useful for being in two places at once. Looks like this one has seen some use.}
		view 242
		loop 1
		cel 1
		name "Time Disruptor"
	)
)

(instance goggles of InvItem
	(properties
		said '/goggles'
		description {ACME Mine Avoidance Goggles. They make cloaked mines visable and jam their tracking abilities.}
		owner 470
		view 242
		loop 1
		cel 2
		name "Mine Avoidance Goggles"
	)
)

(instance petInv of InvItem
	(properties
		said '/pet'
		description {Your virtual pet.}
		owner 470
		view 242
		loop 1
		cel 3
		name "Pet"
	)
	
	(method (showSelf)
		(DisplayPet)
	)
)

(instance eSlab of InvItem
	(properties
		said '/eslab'
		description {The eSlab document reader allows you to store and view documents using a proprietary format.}
		owner 470
		view 242
		loop 1
		cel 6
		name "eSlab"
	)
)

(instance McGuffin of InvItem
	(properties
		said '/mcguffin,package'
		description {Right now it's just a package to deliver.}
		owner 470
		view 242
		loop 1
		cel 7
		name "McGuffin"
	)
)

;;;(instance calc of Prop
;;;	
;;;	(method (init)
;;;		(super init:)
;;;		(self
;;;			view: 27
;;;			setLoop: 0
;;;			setCel: 0
;;;			ignoreActors: TRUE
;;;			setPri: 15
;;;			posn: 159 94
;;;			stopUpd:
;;;		)
;;;	)
;;;)

(instance sysWindow of SysWindow)
