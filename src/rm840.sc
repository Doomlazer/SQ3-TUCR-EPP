;;; Sierra Script 1.0 - (do not remove this comment)
(script# 840)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room840 0
)

(local
)

(instance sludge of Actor
	(properties
		x 33
		y 85
		view 308
		loop 1
		cel 0
	)
)

(instance vohaul of Actor
	(properties
		x 216
		y 65
		view 308
		loop 0
		cel 0
	)
)



(instance Room840 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(if (not meetSV)
			(= picture 842) 
		)
		(super init:)
		(switch prevRoomNum
			(841
				(if (not meetSV)
					(self setScript: RevealScript)
				else
					(sludge init: setCycle: Forward cycleSpeed: (Random 6 10))
					(vohaul init: setCycle: Forward cycleSpeed: (Random 1 5))	
					(self setScript: RoomScript)
				)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
		
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(> (ego y?) 185)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 841)
		)
	)
	
	(method (handleEvent pEvent &tmp i)
		(super handleEvent: pEvent)
		
		(if (Said 'talk/sludge')
			(if (< (ego distanceTo: sludge) 40)
				(LocalSpeak 0 43) ;procedure (LocalSpeak [0=sludge,1=vohaul] line)
				; need to make sludge quests
			else 
				(NotClose)	
			)
		)
		(if (Said 'talk/vohaul')
			(if (< (ego distanceTo: vohaul) 40)
				(if killedQuirk
					(if killedElmo
						(LocalSpeak 1 34) ;completed both murders, need to add more vohaul quests eventually
						; need to prevent repeated rewards
						(if (not (ego has: iBuckazoids))
							(ego get: iBuckazoids)	
						)
						(= buckazoids (+ buckazoids 900))
						(LocalSpeak 1 42)
					else
						(if (not (ego has: iPackage))
							(LocalSpeak 1 26)
							(LocalSpeak 1 27)
							(if (not (ego has: iBuckazoids))
								(ego get: iBuckazoids)	
							)
							(= buckazoids (+ buckazoids 500))
							(LocalSpeak 1 28)
							(Print 840 29)
							(ego get: iPackage)
							(LocalSpeak 1 30)
							(LocalSpeak 1 31)
							(LocalSpeak 1 32)
						else
							(LocalSpeak 1 33)
						)
					)
				else
					(if killedElmo
						(if killedQuirk
							; copy of 2nd reward above. fix reward duplication and add more vohaul quests
							(LocalSpeak 1 34) ;completed both murders, need to add more vohaul quests eventually
							; need to prevent repeated rewards
							(if (not (ego has: iBuckazoids))
								(ego get: iBuckazoids)	
							)
							(= buckazoids (+ buckazoids 900))
							(LocalSpeak 1 42)
						
						else
							(if (not (ego has: iPackage))
								(LocalSpeak 1 35)
								(LocalSpeak 1 36)
								(LocalSpeak 1 37)
								(ego get: iPackage)
								(LocalSpeak 1 38)
							else
								(LocalSpeak 1 39)
							)	
						)
					else
						; quirk and elmo both alive
						(LocalSpeak 1 40)
						(LocalSpeak 1 41)
					)
				)
			else 
				(NotClose)	
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
					(841
						(ego
							posn: 160 200
							setMotion: MoveTo 160 160 self
						)
					)
				)
			)
			(1
				(HandsOn)
				(RoomScript dispose:)
			)
		)
	)
)

(instance RevealScript of Script
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
					(841
						(ego
							posn: 160 200
							setMotion: MoveTo 160 160 self
						)
					)
				)
			)
			(1
				(LocalSpeak 0 0)
				(LocalSpeak 1 1)
				(= cycles 30)
			)
			(2
				(DrawPic 843 0)
				(vohaul init: setCycle: Forward cycleSpeed: (Random 6 10))
				(LocalSpeak 1 2)
				(DrawPic 844 0)
				(sludge init: setCycle: Forward cycleSpeed: (Random 1 5))
				(LocalSpeak 0 3)
				(DrawPic 840 0) 
				(= cycles 30)
			)
			(3
				(LocalSpeak 1 4)
				(++ meetSV)
				(LocalSpeak 1 5)
				(ShakeScreen 3 3)
				(= seconds 5)
			)
			(4
				(LocalSpeak 0 6)
				(LocalSpeak 1 7)
				(LocalSpeak 1 19)
				(LocalSpeak 1 8)
				(LocalSpeak 1 9)
				(LocalSpeak 0 10)
				(= seconds 2)
			)
			(5
				(LocalSpeak 1 11)
				(LocalSpeak 1 12)
				(LocalSpeak 1 13)
				(LocalSpeak 0 14)
				(= seconds 4)
			)
			(6
				(LocalSpeak 1 15)
				(LocalSpeak 1 16)
				(LocalSpeak 0 25) ;fer sure
				(LocalSpeak 1 17)
				(LocalSpeak 0 18)
				(LocalSpeak 1 20)
				(LocalSpeak 1 21)
				(ego setMotion: MoveTo 205 95 self)
			)
			(7
				(Print 840 24) ;hands package for quirk
				(ego get: iPackage)
				(LocalSpeak 1 22)
				(LocalSpeak 1 23)
				(HandsOn)
				(RevealScript dispose:)
			)
		)
	)
)

(procedure (LocalSpeak which line &tmp name)
	(if which 
		(if meetSV
			(= name {Vohaul})
		else
			(= name {???})
		)
		(Print 
			840 line
			#title name
			#at 165 90
		)	
	else
		(if meetSV
			(= name {Sludge})
		else
			(= name {???})
		)
		(Print 
			840 line
			#title name
			#at 10 25
		)
	)
) 