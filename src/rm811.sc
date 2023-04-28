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
	name1
	name2
	betOnNum
	betAmount
	wait
	lossCount
)

(instance ChickenHero of Actor
	(method (init)
		(super init:)
		(self
			view: 302
			ignoreActors:
			illegalBits: 0
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
			illegalBits: 0
			setLoop: 6
			setCel: 0
			;setPri: 13
			x: 190
			y: 120
			setStep: 1
		)
	)
)

(procedure (ChickenInit &tmp [str 50] [str2 50] c)
	;clear names
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
	;clear HPs
	(Display 811 0
		p_width 250
		p_at 10 175
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(Display 811 0
		p_width 250
		p_at 200 175
		;p_mode teJustCenter
		p_font 777
		p_color vBLACK		
	)
	(RedrawCast)
	(= name1 (Random 1 29))
	(= name2 (Random 1 29))
	(while (== name1 name2)
		(= name2 (Random 1 29))
	)
	(if
		(and
			wait ;allow betting on 2nd round after entering.
			(> buckazoids 0)
		)
		(= c
			(Print (Format @str {Bet on next round?\n__%s\n____vs.\n__%s\n} 811 name1 811 name2)
				;#font: SYSFONT
				#button: {Place bet} TRUE
				#button: {No, thanks} FALSE
			)
		)
		(switch c
			(TRUE
				(= betOnNum
					(Print
						{Pick an Astrochicken:_______}
						#button: (Format @str 811 name1) 1
						#button: (Format @str2 811 name2) 2
					)
				)
				(if betOnNum
					(= betAmount (GetNumber (Format @str {You have %d buckazoids.\nBet amount?} buckazoids)))
					(if (> betAmount buckazoids)
						(Print {That's more that you have, Roger. Bet canceled.})
						(= betAmount 0)
						(= betOnNum 0)
					else
						(if (< betAmount 1)
							(Print {Bet canceled.})
							(= betAmount 0)
							(= betOnNum 0)
						else
							(= buckazoids (- buckazoids betAmount))
							(if (< buckazoids 1) 
								(Printf {Bet placed:\n__Everything on %s.} (Format @str 811 ( if (== betOnNum 1) name1 else name2 )))
							else
								(Printf {Bet placed:\n__%d on %s to win.} betAmount (Format @str 811 ( if (== betOnNum 1) name1 else name2 )))
							)
						)
					)
				else
					(Print {Bet canceled.})
				)	
			)
		)
	)
	(= wait 1)
	(Display (Format @str {%s} 811 name1)
		p_width 250
		p_at 10 160
		;p_mode teJustCenter
		p_font 300
		p_color vMAGENTA			
	)
	(Display (Format @str {%s} 811 name2)
		p_width 250
		p_at 200 160
		;p_mode teJustCenter
		p_font 300
		p_color vGREY
	)
	(= heroHP (Random 6 10))
	(= npcHP (Random 6 10))
	(ShowHP)
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
		p_at 200 175
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
				(ego posn: 155 180 loop: 3)
				;(ego posn: 250 106 loop: 3)
				;(self setScript: RoomScript)
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
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
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
				(if (< (ChickenHero y?) 120) ;119
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
				(if (< (ChickenNPC y?) 120) ;119
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
			;Someone is Dead
			(if (or
					(< npcHP 1)
					(< heroHP 1)
				)
				(ChickenHero setScript: winScript)
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
				(if (> heroHP 0)
					(if (< (ChickenHero y?) 114)
						(ChickenHero posn: (ChickenHero x?) 114)
					)
					(ChickenHero loop: 6 cel: 0 setMotion: 0 setCycle: EndLoop)
					(ChickenNPC view: 291 loop: 0 cel: 0 setMotion: 0 setCycle: EndLoop self)
				else
					(if (< (ChickenNPC y?) 114)
						(ChickenNPC posn: (ChickenNPC x?) 114)
					)
					(ChickenNPC loop: 6 cel: 0 setMotion: 0 setCycle: EndLoop )
					(ChickenHero view: 291 loop: 0 cel: 0 setMotion: 0 setCycle: EndLoop self)
				)
			)
			(1
				(if (> heroHP 0)
					(ChickenNPC loop: 1 cel: 0 setCycle: EndLoop self)
				else
					(ChickenHero loop: 1 cel: 0 setCycle: EndLoop self)
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(if betOnNum
					(if
						(and
							(< npcHP 1)
							(< heroHP 1)
						)
						(Print {Draw. House takes all bets.})
					else
						(if
							(or
								(and
									(< npcHP 1)
									(== betOnNum 1)
								)
								(and
									(< heroHP 1)
									(== betOnNum 2)
								)
							)
							(= buckazoids (+ buckazoids (* betAmount 2)))
							(Printf {You won %d buckazoids!\n__Total Buckazoids: %d} (* betAmount 2) buckazoids)
							(= lossCount 0)
						else
							(if (< buckazoids 1)
								(Printf {Your Astrochicken lost.\n__You've lost all of your Buckazoids.})
								(ego put: iBuckazoids -1)
							else
								(Printf {Your Astrochicken lost.\n__You have %d Buckazoids left.} buckazoids)
							)
							(++ lossCount)
							(if (== lossCount 5)
								(Print {Don't give up your day job, Roger.})
							)
															
						)
					)
					(= betAmount 0)
					(= betOnNum 0)	
				)
				(= cycles 1)
			)
			(4
				(ChickenNPC setScript: 0)
				(ChickenHero setScript: 0)
				(ChickenInit)
				(= state -1)
			)
		)
	)
)