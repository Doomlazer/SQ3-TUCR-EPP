;;; Sierra Script 1.0 - (do not remove this comment)
(script# 811)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room811 0
)

(local
	local0
	npcDirX
	npcDirY
	heroDirX
	heroDirY
	heroBonked
	npcBonked
	heroHP
	npcHP
	cooldown
)

(instance ChickenHero of Actor
	(method (init)
		(super init:)
		(self
			view: 302
			ignoreActors:
			setLoop: 6
			setCel: 0
			;setPri: 13
			x: 125
			y: 120
			setStep: 1
		)
	)
)

(instance ChickenNPC of Actor
	(method (init)
		(super init:)
		(self
			view: 290
			ignoreActors:
			setLoop: 6
			setCel: 0
			;setPri: 13
			x: 190
			y: 120
			setStep: 1
		)
	)
)

(procedure (ChickenInit &tmp [str 50])
	;(Print {called ChickenInit})
	(= heroHP (Random 6 10))
	(= npcHP (Random 6 10))
	(ShowHP)
	(Display 811 0
		p_width 250
		p_at 10 158
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display 811 0
		p_width 250
		p_at 200 158
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display 811 0
		p_width 250
		p_at 10 165
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display 811 0
		p_width 250
		p_at 200 165
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display (Format @str {%s} 811 (Random 1 29))
		p_width 250
		p_at 10 160
		;p_mode teJustCenter
		p_font 300
		p_color vMAGENTA			
	)
	(Display (Format @str {%s} 811 (Random 1 29))
		p_width 250
		p_at 200 160
		;p_mode teJustCenter
		p_font 300
		p_color vGREY
	)
	(ChickenHero
		setScript: HeroScript
		init:
	)
	(ChickenNPC
		setScript: NPCScript
		init:
	)
)

(procedure (ShowHP &tmp [str 50] heroCol npcCol)
	(if (< heroHP 3)
		(= heroCol vYELLOW)
	else
		(= heroCol vGREEN)
	)
	(if (< heroHP 1)
		(= heroCol vRED)
	)
		(if (< npcHP 3)
		(= npcCol vYELLOW)
	else
		(= npcCol vGREEN)
	)
	(if (< npcHP 1)
		(= npcCol vRED)
	)
	(Display 811 0
		p_width 250
		p_at 10 175
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display 811 0
		p_width 250
		p_at 210 175
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display (Format @str {Health: %d} heroHP)
		p_width 250
		p_at 25 175
		;p_mode teJustCenter
		p_font 300
		p_color heroCol			
	)
	(Display (Format @str {Health: %d} npcHP)
		p_width 250
		p_at 210 175
		;p_mode teJustCenter
		p_font 300
		p_color npcCol
	)
)



(instance Room811 of Room
	(properties
		picture scriptNumber
		south 810
	)
	
	(method (init)
		(super init:)
		(ChickenInit)
		(switch prevRoomNum
			(810
				(ego posn: 155 180 loop: 3)
			)
			(else
				(ego posn: 250 106 loop: 3)
				(self setScript: RoomScript)
			)
		)
		(ego init:)	
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(super handleEvent: pEvent)
		; handle Said's, etc...
		(if (Said 'look')
			(= temp0 (GetNumber {Program number:}))
			(DrawPic temp0 8)
		)	
	)
	
	(method (doit)
		(super doit:)
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
		(if (Said 'look')
			(DrawPic 804 9)
		)	
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(HandsOff)
				(ego
					posn: 50 46 
					ignoreControl:
					setMotion: MoveTo 77 64 self
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

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

(instance HeroScript of Script
	(method (doit)
		(super doit:)
		(if (not heroBonked)
			;Dead
			(if (< heroHP 1)
				(ChickenHero setScript: winScript)
			)
			(if heroDirX
				(ChickenHero loop: 0 setCycle: Forward)
				(if (< (ChickenHero x?) 200)
					(ChickenHero x: (+ (ChickenHero x?) (Random 0 4)))
				else
					(= heroDirX 0)
				)
			else
				(ChickenHero loop: 1 setCycle: Forward)
				(if (> (ChickenHero x?) 120)
					(ChickenHero x: (- (ChickenHero x?) (Random 0 4)))
				else
					(= heroDirX 1)
				)
			)
			(if heroDirY
				(if (< (ChickenHero y?) 119)
					(ChickenHero y: (+ (ChickenHero y?) (Random 0 4)))
				else
					(= heroDirY 0)
				)
			else
				(if (> (ChickenHero y?) 110)
					(ChickenHero y: (- (ChickenHero y?) (Random 0 4)))
				else
					(= heroDirY 1)
				)
			)
			(if (== 9 (Random 0 100))
				(if (Random 0 1)
					(= heroDirX (Random 0 1))
				else
					(= heroDirY (Random 0 1))
				)
			)
		else
			(ChickenHero loop: 8 cel: heroBonked)
		 	(-- heroBonked)
		)
		
		
		;colision
		(if 
			(and
				;(== (ChickenHero y?) (ChickenNPC y?))
				(< (Abs (- (ChickenHero y?) (ChickenNPC y?))) 5)
				(< (Abs (- (ChickenHero x?) (ChickenNPC x?))) 10)
				(not cooldown)
			)
			(if (> 50 (Random 1 100))
				(= heroBonked 6)
				(= heroHP (- heroHP (Random 1 2)))
				(if (< heroHP 0)
					(= heroHP 0)
				)
			else
				(= npcBonked 6)
				(= npcHP (- npcHP (Random 1 2)))
				(if (< npcHP 0)
					(= npcHP 0)
				)
			)
			(ShowHP)
			(= cooldown 20)	
		)
		(if (> cooldown 0)
			(-- cooldown)	
		)
	)
		
	(method (changeState newState)
		(switch (= state newState)
			(0
				
			)
		)
	)
)



(instance NPCScript of Script
	(method (doit)
		(super doit:)
		(if (not npcBonked)
			;Dead
			(if (< npcHP 1)
				(ChickenHero setScript: winScript)
			)
			(if npcDirX
				(ChickenNPC loop: 0 setCycle: Forward)
				(if (< (ChickenNPC x?) 200)
					(ChickenNPC x: 	(+ (ChickenNPC x?) (Random 0 2)))
				else
					(= npcDirX 0)
				)
			else
				(ChickenNPC loop: 1 setCycle: Forward)
				(if (> (ChickenNPC x?) 120)
					(ChickenNPC x: 	(- (ChickenNPC x?) (Random 0 2)))
				else
					(= npcDirX 1)
				)
			)
			(if npcDirY
				(if (< (ChickenNPC y?) 119)
					(ChickenNPC y: 	(+ (ChickenNPC y?) (Random 0 2)))
				else
					(= npcDirY 0)
				)
			else
				(if (> (ChickenNPC y?) 110)
					(ChickenNPC y: 	(- (ChickenNPC y?) (Random 0 2)))
				else
					(= npcDirY 1)
				)
			)
			(if (== 5 (Random 0 10))
				(if (Random 0 1)
					(= npcDirX (Random 0 1))
				else
					(= npcDirY (Random 0 1))
				)
			)
		else
			(ChickenNPC loop: 8 cel: npcBonked)
			(-- npcBonked)
		)
	)
		
	(method (changeState newState)
		(switch (= state newState)
			(0
				
			)
		)
	)
)

(instance winScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ChickenNPC setScript: 0)
				;(ChickenHero setScript: 0)
				;(Print {0})
				(if (> heroHP 0)
					(ChickenHero loop: 6 cel: 0 setCycle: EndLoop)
					(ChickenNPC view: 291 loop: 0 cel: 0 setCycle: EndLoop)
				else
					(ChickenNPC loop: 6 cel: 0 setCycle: EndLoop )
					(ChickenHero view: 291 loop: 0 cel: 0 setCycle: EndLoop)
				)
				(= seconds 2)
				
			)
			(1
				;(Print {1})
				(if (> heroHP 0)
					(ChickenNPC loop: 1 cel: 0 setCycle: EndLoop winScript)
				else
					(ChickenHero loop: 1 cel: 0 setCycle: EndLoop winScript)
				)
			)
			(2
				;(Print {2})
				;(ChickenHero dispose:)
				;(ChickenNPC dispose:)
				(= seconds 2)
			)
			(3
				;(Print {3})
				(ChickenNPC setScript: 0)
				(ChickenHero setScript: 0)
				(ChickenInit)
				(= state -1)
				;(self dispose:)
			)
		)
	)
)