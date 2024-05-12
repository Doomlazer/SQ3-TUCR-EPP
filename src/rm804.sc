;;; Sierra Script 1.0 - (do not remove this comment)
(script# 804)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Reverse)


(public
	Room804 0
)
(local 
	greet 
	justPaid ;fine, not entrance fee
)

(instance boothAlien of Actor
	(properties)
)

(instance machine of Prop
	(properties
		y 125
		x 20
		view 56
		loop 1
		cel 3
	)
)



(instance Room804 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(boothAlien 
			view: 293
			cel: 1
			posn: 66 130
			setLoop: 0
			setCel: 0
			illegalBits: 0
			setCycle: 0
			setPri: 11
			init:
		)
		(machine
			ignoreActors: FALSE
			init:
		)
		(switch prevRoomNum
			(803
				(ego posn: 315 160 loop: 1)
				;(self setScript: RoomScript)
			)
			(806
				(ego posn: 170 85 view: 68 loop: 1) ;return from big rock
			)
			(807
				(self setScript: eggReturnScript)
			)
			(814 ;from arcade game
				(ego view: 0 posn: 33 123 loop: 1 setPri: -1)
			)
			(else 
				(ego posn: 150 150 loop: 1)
			)
		)
		(ego init:)
	)
	
	(method (doit)
		(super doit:)
		; alien blink
		(if (== (Random 0 10) 3)
			(boothAlien cel: (Random 0 1))
		)
		(if
			(and
				(& (ego onControl:) $4000) ;yellow - vist rock
				(== script 0)
			)
			(curRoom newRoom: 806)
		)
		(if
			(and
				(> (ego x?) 321)
				(== script 0)
			)
			(curRoom newRoom: 803) ;return to path
		)
		(if
			(and
				(& (ego onControl:) $0200) ;vtlBLUE ;warp to forgraund
				(== script 0)
			)
			(self setScript: backgroundScript)
		)
		(if
			(and
				(& (ego onControl:) $0002) ;ctlNAVY ;warp to background
				(== script 0)
			)
			(self setScript: foregroundScript)
		)
		(if
			(and
				(& (ego onControl:) $2000) ;fuchia greet
				(== script 0)
			)
			(if (== greet 0)
				(Print 804 0)
				(++ greet)	
			)
		)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
					((Said 'look[/area]')
						(Print 804 1)
					)
					((Said 'look/stone,rock')
						(Print 804 2)
					)
					((Said 'look/booth')
						(Print 804 3)
					)
					((Said 'look/alien,attendant')
						(Print 804 4)
					)
					((Said 'look/sign')
						(Print 804 5)
					)
					(
						(or
							(Said 'look/astro,astro,grafitti,game,device[<grafitti]')
							(Said 'look/astro<astro')
						)
						(Print {It's a currently unnamed prototype arcade cabinet.})
					)
					(
						(or
							(Said 'play/astro,astro,grafitti,game,device[<grafitti]')
							(Said 'play/astro<astro')
						)
						(if (ego inRect: 21 118 42 128)
							(curRoom newRoom: 814)
						else
							(NotClose)
						)
					)
					((Said 'ask,converse>')
						(cond 	
							((Said '/alien,attendant')
								(if (& (ego onControl:) $2000)
									(if towed
										(Print 804 24)
									else
										(Print 804 6)
									)
								else
									(Print 804 13)
								)
							)
							((Said '/man,woman')
								(Print 804 31)
							)
							((Said '/spaceship')
								(if (& (ego onControl:) $2000)
									(if towed
										(Print 804 18)
									else
										(Print 804 25)
									)
								else
									(Print 804 13)
								)
							)
							((Said '/fine')
								(if (& (ego onControl:) $2000)
									(if towed
										(Print 804 26)
									else
										(Print 804 27)
									)
								else
									(Print 804 13)
								)
							)
						)									
					)
					((Said 'buy,pay/ticket')
						(if (& (ego onControl:) $2000)
							(if (>= buckazoids 6)
								(Print 804 9)
								(badBlip play:)
								(Print 804 10 #title {Roger})
								(Print 804 11)
								(theGame changeScore: 5)
								(= buckazoids (- buckazoids 6))
								(++ ticketed)	
							else
								(Print 804 12)
							)
						else
							(Print 804 13)
						)
					)
					((Said 'buy,pay/fine')
						(if (& (ego onControl:) $2000)
							(if towed
								(if (>= buckazoids 50)
									(Print 804 20)
									(Print 804 21)
									(theGame changeScore: 50)
									(= buckazoids (- buckazoids 50))
									(= justPaid 1)
									(= towed 0)			
								else
									(Print 804 19)
								)
							else
								(Print 804 32) 
							)
						else
							(Print 804 13)
						)
					)
					((Said 'give,drop,sell,display,trade/crystal,crystal[<glowing]')
						(if (& (ego onControl:) $2000)
							(if (ego has: iGlowingGem)
								(ego put: iGlowingGem)
								(if towed
									(Print 804 23)
									(theGame changeScore: 400)
									(Print 804 21)
									(= gaveGem 1) ;only in trade for mallard to force 1 buckazoid dabo win at quarks.
									(= justPaid 1)
									(= towed 0)
								else
									(if ticketed
										(Print 804 28)
									else
										(Print 804 29)
										(Print 804 30)
										(badBlip play:)
										(Print 804 10 #title {Roger})
										(Print 804 11)
										(theGame changeScore: 2)
										(++ ticketed)
									)
								)	
							else
								(Print 804 22)
							)
						else
								(Print 804 13)
						)	
					)
					((Said 'look/security,gate,teleporter,transporter')
						(Print 804 14)
					)
					((Said 'look/skull')
						(Print 804 15)
					)
				)
			)
		)
	)
)

(instance backgroundScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(hit number: 79 play:)
				(ego
					view: 294
					cel: 0
					setCycle: EndLoop
				)
				(if ticketed
					(= state 0)
					(= seconds (Random 2 3))
				else
					(= state 399)
					(= seconds 3)
				)
			)
			(1
				(ego
					view: 295 
					posn: 220 102 
					cel: -1
					setPri: 15
					setCycle: BegLoop self
				)
			)
			(2
				(ego
					view: 68
					moveSpeed: 1
					setPri: -1
					setMotion: MoveTo 219 96 self
					setCycle: Walk
				)
			)
			(3
				(hit stop:)
				(RedrawCast)
				(HandsOn)
				(if (not towed)
					(if (not justPaid)
						(Print 804 16)	
						(++ towed)
					)
				)
				(backgroundScript dispose:)
			)
			(400
				(= seconds 3)
			)
			(401
				(Print 804 17)
				(EgoDead 0 1 1 18)
				(= inCartoon FALSE)
				(HandsOn)
			)
		)
	)
)

(instance foregroundScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(++ egg)
				(HandsOff)
				(hit number: 79 play:)
				(ego 
					view: 295
					cel: 0
					setCycle: EndLoop
				)
				(= state 0)
				(= seconds (Random 2 3))
			)
			(1
				(if (== egg 25)
					(HandsOff)
					(curRoom newRoom: 807)
				else
					(ego
						view: 294
						posn: 218 136
						setPri: 15
						setCycle: BegLoop self
					)
				)
			)
			(2
				(ego
					view: 0
					moveSpeed: 0
					loop: 2
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 216 140 self
				)
			)
			(3
				(hit stop:)
				(RedrawCast)
				(HandsOn)
				(foregroundScript dispose:)
			)
		)
	)
)

(instance hit of Sound
	(properties
		priority 5
	)
)

(instance badBlip of Sound
	(properties
		number 96
		priority 2
	)
)

(instance eggReturnScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(hit number: 79 play:)
				(ego
					view: 294
					posn: 218 136
					setPri: 15
					setCycle: BegLoop self
				)
			)
			(1
				(ego
					view: 0
					moveSpeed: 0
					loop: 2
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 216 140 self
				)
			)
			(2 
				(= seconds 2)
			)
			(3
				(hit stop:)
				(RedrawCast)
				(HandsOn)
				(Print {Don't even bother trying to get back there, Roger. That babe was one in a million, not to mention completely out of your league.})
				(eggReturnScript dispose:)
			)
		)
	)
)