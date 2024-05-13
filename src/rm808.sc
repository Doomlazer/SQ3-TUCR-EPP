;;; Sierra Script 1.0 - (do not remove this comment)
(script# 808)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)
(use Sound)

(public
	rm808 0
)

;;;(instance dabo of Sound
;;;	(properties
;;;		number 401
;;;		priority 1
;;;	)
;;;)

(local
	local0
	local1
	local2
	local3
	standingUp
	local5
	local6
	local7
	greetCust
	choice
	toldAboutDisruptor
	queueGivePackage
)

(procedure (DoGivePackage) ; kill quirk
	(ego put: iPackage 808)
	(= queueGivePackage 0)
	(Print
		808 67
		#title {Quirk}
		#mode teJustLeft
	)
	(Print
		808 68
		#title {Quirk}
		#mode teJustLeft
	)
	(Print
		808 69
	)
	(= buckazoids (+ buckazoids 300))
	(= killedQuirk 1)
)

(procedure (buyPTDlocal cost &tmp ch [strb 50])
	(= ch 0)
	(= ch
		(Print
			(Format @strb 808 36 cost)
			#title {Quirk}
			#mode teJustLeft
			#button {Yes, I want it.} 1
			#button {No, thank you.} 2
		)
	)
	(if (== ch 1)
		(Print
			(Format @strb 808 37 cost)
			#title {Quirk}
			#at (/ (quark x?) 2) (- (quark y?) 60)
		)
		(Print
			808 71
			#title {Quirk}
			#at (/ (quark x?) 2) (- (quark y?) 60)
		)
		(Print 808 38)
		(= qtab (+ qtab cost))
		(ego get: iTime_Disruptor)
	)
	(if (== ch 2)
		(Print 808 39 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))	
	)	
)

(procedure (TalkOther &tmp c i)
	(= c
		(if (not (ego has: 18))
			(Print
				808 55
				#title {Quirk}
				#mode teJustLeft
				#button {Bar} 1
				#button {Gambling} 2
				#button {Work} 3
				#button {Wares} 4
			)
		else
			(Print
				808 55
				#title {Quirk}
				#mode teJustLeft
				#button {Bar} 1
				#button {Gambling} 2
				#button {Work} 3
			)
		)
		
	)
	(switch c
		(1
			(Print 808 51)
			(Print 808 56)
			(Print 808 57)
			(buyBook)
		)
		(2
			(Print 808 52)
			(Print 808 53)
		)
		(3
			(if quirkJobKnown
				(= i 0)
				(if (ego has: iPackage)
					(Print
						808 70 ;come back with my property
						#title {Quirk}
						#mode teJustLeft
					)
				else
					(if (ego has: iTime_Disruptor)
						(while (< i 2)
							(Print 808 (+ 48 i) #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
							(++ i)					
						)
					else
						(Print 808 50 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
					)
				)
			else
				(while (< i 4)
					(Print 808 (+ 42 i) #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
					(++ i)					
				)
				(++ quirkJobKnown)
				(if (ego has: 18)
					(Print 808 54 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
				else
					(Print 808 46 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
				)
			)
		)
		(4
			(if toldAboutDisruptor
				(Print 808 40 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
			else
				(= i 0)
				(while (< i 3)
					(Print 808 (+ 32 i) #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
					(++ i)
				)
				(++ toldAboutDisruptor)
			)
			(buyPTDlocal 800)
		)
	)
)

(instance rm808 of Room
	(properties
		picture 809
		west 810
	)
	
	(method (init &tmp [temp0 50])
		(Load VIEW 298) ;door
		(Load VIEW 297) ;quark
		(Load VIEW 44)
		(Load VIEW 53)
		(Load VIEW 64)
		(Load VIEW 137)
		(Load VIEW 213)
		(Load SOUND 401)
		(super init:)
		(ship init:)
		(collar init: stopUpd:)
		(door init: stopUpd:)
		(quark init:)
		(ripley 
			ignoreActors: 0	
			init:
		)
		(greenCustomer init:)
		(greenFeet init:)
		(CherubCustomer setCycle: Forward init:)
		(= local1 2)
		(= standingUp TRUE)
		(= local5 1)
		(= monolithBurgerBill 0)
		(= global247 1)
		;(dabo play:)
		(theMusic number: 401) ;16)
		(if (and (!= prevRoomNum 27) (!= prevRoomNum 810))
			(theMusic play: loop: 1)
		)
		(switch prevRoomNum
			(810
				(collar setCel: 0)
				(ship x: 286 y: 115 stopUpd:)
				(chairMan setCel: 7 init:)
				(collar stopUpd:)
				(HandsOn)
				(ego init: posn: 5 (ego y?) loop:0)
				(ship stopUpd:)
				(= global206 0)
				(= local0 1)
			)
			(26
				(collar setCel: 7)
				(ship x: 335 y: 174)
				(chairMan setCel: 0)
				(HandsOff)
				(= global206 1)
				(= local0 4)
				(self setScript: dockScript)
			)
			(300
				;return from ereader
				(collar setCel: 0)
				(ship x: 286 y: 115 stopUpd:)
				(chairMan setCel: 7 init:)
				(collar stopUpd:)
				(HandsOn)
				(ego init:)
				(if
					(and 
						(== (ego x?) 76)
						(== (ego y?) 115)
					)
					(ego
						view: 300
						illegalBits: 0
						setLoop: 0
						setPri: 14
						setCel: 0
					)
					(= standingUp FALSE)
				else
					(ego illegalBits: cWHITE view: 0  setCel: 0)
					(RedrawCast)
					(NormalEgo 2 0)
					(= standingUp TRUE)
				)
				(ship stopUpd:)
				(= global206 0)
				(= local0 1)
			)
			(else ; dock testing from TP debug
				(collar setCel: 7)
				(ship x: 335 y: 174)
				(chairMan setCel: 0)
				(HandsOff)
				(= global206 1)
				(= local0 4)
				(self setScript: dockScript)
			)
		)
		(TheMenuBar draw:)
		(StatusLine enable:)
	)
	
	(method (doit)
		(super doit:)
		(ripley cel: (Random 0 2))
		(if (not (Random 0 50))
			(greenFeet cel: (Random 0 1))
			(greenCustomer cel: (Random 0 1))
		)
		(if (not (Random 0 100))
			(CherubCustomer cel: 0 setCycle: EndLoop)
		)
		(if
			(or
				(== (ego onControl: 0) 4)
				(== (ego onControl: 0) 5)
			)
			(curRoom newRoom: 29)
		)
		(if
			(and
				(or
					(== (ego onControl: 0) 16)
					(== (ego onControl: 0) 17)
				)
				(not script)
			)
			(curRoom setScript: SitDown)
		)
	)
	
	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond
					((Said 'look>')
						(cond 
							((or (Said '/pane') (Said '<out')) (Print 808 10))
							((or (Said '/deck,ceiling') (Said '<up,down')) (Print 808 9))
							((Said '/partition') (Print 28 2))
							((Said '/alien,being,man,bystander,folk,animal') (Print 28 4))
							((Said '/craft') (Print 28 5))
							((Said '/door') (Print 28 6))
							((Said '/quark') (Print 810 14))
							((Said '/quirk,bartender,clerk,waiter')
								(Print 808 0)
							)
							((Said '/chair,booth,stool') (Print 808 6))
							((Said '/dabo[<table]') (Print 808 7))
							((Said '/counter,bar') (Print 808 8))
							((Said '/menu') (Print 808 1))
							((Said '[<around,at,in][/area,cafe]') (Print 808 2))
						)
					)
					((Said 'down,sit[<down]')
						(cond 
							((== standingUp FALSE) (Print 808 3))
							((ego inRect: 57 122 91 130) (curRoom setScript: SitDown))
							(else (Print 808 4))
						)
					)
					((Said 'up,(get<up),stand[/up]')
						(if (== standingUp TRUE)
							(Print 808 5)
						else
							(curRoom setScript: StandUp)
						)
					)
					((Said 'open,close/door') (Print 808 11 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)))
					((Said 'call,converse/quark') (Print 810 14))
					((Said 'give/package')
						(if (ego has: iPackage)
							(if standingUp
								(Print 808 12)	
							else
								(if (and 
										(== (quark loop?) 0)
										(>= (quark x?) 50)
									)
									(DoGivePackage)	
								else
									(Print 808 66) ;You wave Quirk over to where you're seated.
									(= queueGivePackage 1)
									(= greetCust 0)
									(quarkScript changeState: 0)		
								)
							)
						else
							(DontHave)
						)
					)
					((Said 'call,converse/clerk,bartender,quirk,waiter')
						(if standingUp
							(Print 808 12)	
						else
							(if (and 
									(== (quark loop?) 0)
									(>= (quark x?) 50)
								)
								(quark setScript: quarkTalkScript)
							else
								(Print 808 13)
								(= greetCust 0)
								(quarkScript changeState: 0)
							)
						)
					)
					(
						(Said
							'ask,converse/alien,being,man,bystander,folk,animal,customer'
						)
						(Print 808 14)
					)
					((Said 'converse') (Print 28 27))
					(
						(Said
							'kiss/alien,being,man,bystander,folk,animal,customer'
						)
						(Print 808 15)
					)
					(
						(Said
							'smell[/man,being,alien,him,bystander,animal,customer]'
						)
						(Print 808 16)
					)
					(
						(Said
							'beat[/man,being,alien,him,bystander,animal,customer]'
						)
						(Print 28 30)
					)
					((Said 'ask,converse/gagh,food') (Print 808 17))
					(
						(or
							(Said 'open,enter,board,climb,(get<in)[/door,door,craft]')
							(Said 'disembark')
						)
						(cond 
							((not (ego inRect: 179 72 251 95)) (Print 28 31))
							(orderedBigBelcherCombo (self setScript: VomitScript))
							(else (self setScript: OutScript))
						)
					)
				)
			)
			(direction
				(if (== standingUp 0)
					(switch (event message?)
						(dirN
							(event claimed: TRUE)
						)
						(dirE
							(curRoom setScript: StandUp)
							(event claimed: TRUE)
							(return)
						)
						(dirS
							(curRoom setScript: StandUp)
							(event claimed: TRUE)
							(return)
						)
						(dirNW
							(event claimed: TRUE)
						)
						(dirNE
							(event claimed: TRUE)
							(return)
						)
						(dirSE
							(curRoom setScript: StandUp)
							(event claimed: TRUE)
							(return)
						)
						(dirSW
							(curRoom setScript: StandUp)
							(event claimed: TRUE)
							(return)
						)
						(dirW
							(curRoom setScript: StandUp)
							(event claimed: TRUE)
						)
						(dirStop
							(event claimed: TRUE)
							(return)
						)
					)
				)
			)
			(mouseDown
				(if (and (== standingUp 0) (not (event claimed?)))
					(curRoom setScript: StandUp)
					(event claimed: TRUE)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 29) (theMusic fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance SitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					view: 300
					illegalBits: 0
					posn: 76 115
					setLoop: 0
					setPri: 14
					setCel: 0
				)
				(= cycles 10)
			)
			(1
				(HandsOn)
				(= standingUp FALSE)
				(curRoom setScript: 0)
			)
		)
	)
)

(instance StandUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ego illegalBits: cWHITE view: 0 setLoop: 2 setCel: 0)
				(RedrawCast)
				(NormalEgo 2 0)
				(ego posn: 90 128)
				(= standingUp TRUE)
				(curRoom setScript: 0)
			)
		)
	)
)


(instance dockScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship setMotion: MoveTo 286 125 self)
			)
			(1
				(ship setMotion: MoveTo 286 115 self)
			)
			(2
				(collar setCycle: BegLoop self startUpd:)
				(ship stopUpd:)
			)
			(3
				(collar stopUpd:)
				(= global206 0)
				(= seconds 2)
			)
			(4
				(Print {With the docking maneuver completed, the engines shut down. Welcome to Quirk's!} #at -1 130 #width 280)
				(HandsOn)
				(= cycles 2)
			)
			(5
				(chairMan init: setCycle: EndLoop self)
			)
			(6
				(chairMan stopUpd:)
				(= seconds 2)
			)
			(7
				(Print 28 36)
				(ego
					view: 0
					setLoop: -1
					loop: 1
					posn: 173 93
					setStep: 3 2
					setCycle: Walk
					illegalBits: cWHITE
					setPri: -1
					init:
				)
				(if (cast contains: ego) (ego show:) else (ego init:))
				(HandsOn)
				(= local0 1)
				(curRoom setScript: 0)
			)
		)
	)
)

(instance OutScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego setMotion: MoveTo 202 82 self)
			)
			(1
				(= inCartoon 1)
				(chairMan setCycle: BegLoop self)
				(ego hide:)
			)
			(2
				(= local0 4)
				(chairMan dispose:)
				(RedrawCast)
				(Print 808 31 #at -1 130 #width 280)
				(if (> qtab 0)
					(Print 808 27)
					;(= sawTerminator 0)
					;(= terminatorState 0)
					(= quarkAttacks 1)
				)
				(ship setMotion: MoveTo 286 125 self)
			)
			(3
				(ship setMotion: MoveTo 335 174 self)
			)
			(4
				(= global206 3)
				(= inCartoon 0)
				;handle quirk explodes
				(if (== killedQuirk 1)
					(++ killedQuirk)
					(cast eachElementDo: #dispose)
					(curRoom setScript: killQuirkScript)
				else
					(curRoom newRoom: 14)
				)
			)
		)
	)
)

(instance VomitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ego
					view: 137
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo 168 93 self
				)
			)
			(1
				(ego setMotion: MoveTo 134 105 self)
			)
			(2
				(ego setCel: 0 setLoop: 1 setCycle: EndLoop self)
			)
			(3 (= cycles 10))
			(4 (ego setCycle: EndLoop self))
			(5 (= cycles 10))
			(6 (ego setCycle: EndLoop self))
			(7
				(ego
					view: 0
					loop: 1
					setLoop: -1
					illegalBits: -32768
					setCycle: Walk
				)
				(= seconds 2)
			)
			(8
				(Print 808 28)
				(if (> qtab 0)
					(Print 808 29 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
				)
				(= orderedBigBelcherCombo FALSE)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance CherubCustomer of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 300
			setLoop: 3
			setCel: 0
			posn: 101 109
			setPri: 8
			ignoreActors: 1
		)
	)
)

(instance greenCustomer of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 300
			setLoop: 1
			setCel: 0
			posn: 32 117
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance greenFeet of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 300
			setLoop: 2
			setCel: 0
			posn: 32 112
			setPri: 8
			ignoreActors: 1
		)
	)
)

(instance collar of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 0
			posn: 286 90
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance ship of Actor
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 1
			setPri: 5
			setStep: 1 1
			illegalBits: 0
			ignoreActors: 1
		)
	)
)

(instance quark of Actor
	(properties)
	
	(method (init)
		(super init:)
		(self
			x: 2
			y: 106
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
					loop: 1
					setMotion: MoveTo 80 100 self	
				)
			)
			(1
				(quark loop: 0 cel: 0)
				(if standingUp
					(= seconds (Random 2 15))
				else
					(if (ego has: iPackage)
						(Print
							808 65 ; did you get my stolen property?
							#title {Quirk}
							#mode teJustLeft
						)
						(if queueGivePackage
							(DoGivePackage)
						)
					else 
						(if greetCust
							(= seconds (Random 2 15))
						else
							(++ greetCust)
							(quark setScript: quarkTalkScript)
						)
					)
				)
			)
			(2
				(quark
					loop: 2
					setMotion: MoveTo 22 105 self	
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

(instance quarkTalkScript of Script
	(method (changeState newState &tmp [str 50])
		(switch (= state newState)
			(0
				
				(= choice
					(if quarkAttacks
						(Print
							{"You ready to settle your tab now?"}
							#title {Quirk}
							#mode teJustLeft
							#button {Yes} 3
						)
					else
						(Print
							{"What can I get for you, Hu-mon?"}
							#title {Quirk}
							#mode teJustLeft
							#button {Food} 1
							#button {Drink} 2
							#button {Pay Tab} 3
							#button {Other} 4
						)
					)
				)
				(if (== choice 1)
						(++ orderedBigBelcherCombo) ;vomit on exit
						(= qtab (+ qtab 10))
						(Print 808 18)
						(Print 808 19 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
				)
				(if (== choice 2)
						(= qtab (+ qtab 9))
						(Print 808 24 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
						(Print 808 23)
				)
				(if (== choice 3) ;pay tab
					(if (<= qtab 0)
						(Print 808 30 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
					)
					(if (< buckazoids qtab) 
						(Print 808 21 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
						(Print (Format @str "%d buckazoids" qtab) #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
						(Print 808 26 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
					)
					(if (and (>= buckazoids qtab) (> qtab 0))
						(Print 808 20 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
						(Print (Format @str "%d buckazoids" qtab) #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60)) 
						(= buckazoids (- buckazoids qtab))
						(= qtab 0)
						(= quarkAttacks 0)
						(Print 808 25 #title {Quirk} #at (/ (quark x?)2) (- (quark y?) 60))
					)
				)
				(if (== choice 4)
					(TalkOther)
				)
				(quark setScript: quarkScript)
				(quarkScript changeState: 2)
			)
		)
	)	
)

(instance ripley of Prop
	(properties
		x 158
		y 130
		view 400
		priority 15
	)
)

(instance chairMan of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 44
			setLoop: 2
			posn: 263 109
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance door of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 298
			setLoop: 0
			setCel: 0
			posn: 164 95
			setPri: 6
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(
				(or
					(== (ego onControl: 0) 2)
					(== (ego onControl: 0) 3)
				)
				(if (> local1 1)
					(= local1 1)
					(self setCycle: EndLoop self)
				)
			)
			((< local1 2) (= local1 3) (self setCycle: BegLoop self))
		)
	)
	
	(method (cue)
		(door stopUpd:)
		(= local1 (if (== local1 1) 0 else 2))
	)
)


(procedure (buyBook &tmp temp0)
	(= temp0 
		(Print 
			808 58
			#width 220
			#at -1 10
			#button {Sure, why not?} 1
			#button {No, thank you.} 2
		)
	)
	(switch temp0
		(1
			(if (ego has: iESlab)
				(if (syncDoc)
					(Print 808 61)
					(= qtab (+ qtab 10))
				else
					(Print 808 62)
				)
			else
				(Print 808 59)
				(Print 808 60)
			)
		)
		(else
			(Print 808 63)
		)
	)
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
			(= [owned i] 303) ;upload Quirk's autobiography
		)
		(++ i)
	)
	(return r)
)

(instance shipLeaving of Actor
	(properties)
)

(instance explode of Actor
)

(instance killQuirkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship 
					view: 52
					loop: 1
					cel: 2
					posn: 250 120
					setPri: 4
					init:
				)
				(curRoom drawPic: 26)
				(shipLeaving
					view: 52
					loop: 1
					cel: 2
					posn: 250 120
					setPri: 4
					setCycle: EndLoop
					setStep: 3 1
					setMotion: MoveTo 150 80 self
					init:
				)
			)
			(1
				(ShakeScreen 1 1)
				(explode
					posn: 185 125
					view: 832
					loop: 0
					cel: 0
					setCycle: EndLoop
					init:
				) 
				(shipLeaving
					setStep: 1 1
					setCycle: 0
					setMotion: MoveTo 70 50 self
				)
			)
			(2
				(Print 808 64)
				(curRoom newRoom: 14)
			)
		)
	)
)