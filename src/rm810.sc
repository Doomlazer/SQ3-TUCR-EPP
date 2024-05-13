;;; Sierra Script 1.0 - (do not remove this comment)
(script# 810)
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
	Room810 0
)

(local
	local0
	local1
	betAmount
	betNumber
	nagged
	odoGone
	dapoEgg
	saveBits
	ded
	escape
	delt
	timePod
)

(procedure (Face actor1 actor2)
	(DirLoop actor1
		(GetAngle
			(actor1 x?)
			(actor1 y?)
			(actor2 x?)
			(actor2 y?)
		)
	)
)

(instance daboSound of Sound
	(properties
		number 402
		priority 15
	)
)

(instance daboWinMusic of Sound)

(instance dtable of Prop
	(properties
		x 230
		y 157
		view 301
	)
)

(instance dlight of Prop
	(properties
		x 230
		y 147
		loop 1
		view 301
	)
)
(instance dlight2 of Prop
	(properties
		x 179
		y 132
		loop 1
		view 301
	)
)
(instance dlight3 of Prop
	(properties
		x 150
		y 117
		loop 1
		view 301
	)
)

(instance rogGirl of Actor
	(properties
		x 140
		y 160
		loop 4
		view 299
	)
)

(instance SqlPolice of Actor
	(properties
		x 160
		y 162
		loop 1
		cel 6
		view 834
	)
)

(instance dgirl of Actor
	(properties
		x 205
		y 160
		loop 1
		view 299
	)
)

(instance Room810 of Room
	(properties
		picture 808
		east 808
	)
	
	(method (newRoom n)
		(if delt (= deltWithBarCop 1))
		(super newRoom: n)
	)	
	
	(method (init)
		(Load SOUND 401)
		(super init:)
		(= local0 3)
		(= local1 3)
		(door init: stopUpd:)
		(holoDoor init: stopUpd:)
		(quark init:)
		(dtable
			ignoreActors: 0
			init:
		)
		(dlight
			setPri:12
			setScript: dLightIdleScript
			ignoreActors: 1
			init:
		)
		(dlight2
			;setPri:12
			setScript: dLight2Script
			ignoreActors: 1
			init:
		)
		(dlight3
			;setPri:12
			ignoreActors: 1
			setScript: dLight3Script
			init:
		)
		(dgirl
			ignoreActors: 0
			setScript: dgirlEyeScript
			init:
		)
		(if (not deltWithBarCop)
			(rogGirl init:)
			(SqlPolice
				setScript: SqlScript
				init:
			)
		)
		;todo: move music to region
		(theMusic number: 401)
		(if (and (!= prevRoomNum 27) (!= prevRoomNum 808))
			(theMusic play: loop: 1)
		)
		(switch prevRoomNum
			(811
				(ego posn: 228 126 loop: 2)
				(holoDoor setCel: 2 setCycle: BegLoop) 
			)
			(808
				(ego posn: 315 (ego y?) loop: 1)
				;(self setScript: RoomScript)
			)
			(else 
				(ego posn: 310 140 loop: 1)
			)
		)
		(ego
			ignoreActors: 0
			init:
		)
	)
	
	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
					((Said '[play,bet]/dabo')
						(Print 810 12)
						(Print 810 13)	
					)
					((Said 'call,converse/quark') (Print 810 14))
					((Said '(police[<sequel]),man') (if deltWithBarCop (Print 810 24) else (Print 810 23)))
					((Said 'call,converse/(woman[<dapo]),alien') (Print 810 19 #at 120 25 #title {Quirk}))
					((Said 'look>')
						(cond 
							((Said '/quark,bartender') (Print 810 14))
							((Said '/quirk,bartender') (Print 810 3))
							((Said '/(police[<sequel]),man') (if deltWithBarCop (Print 810 24) else (Print 810 22)))
							((Said '/(woman[<dapo]),alien')
								(if deltWithBarCop
									(Print 810 2)
								else
									(Print 810 20)
									(Print 810 21)
								)	
							)
							((Said '/table[<dapo]') (Print 810 1))
							((Said '/table[<dabo]') (Print 810 12)(Print 810 13))
							((Said '[<around,at,in][/area,cafe]') (Print 810 0))
						)
					)
					((Said 'bet,play,dapo/[dapo]')
						(if odoGone
							(Print 810 10)
						else 
							(if (< (ego distanceTo: dtable) 30)
								(dlight setScript: daboScript)
								(daboScript changeState: 1)
							else
								(Print 810 6)
							)
						)
					)
				)
			)
		)
	)
)

(instance daboScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		; code executed each game cycle
	)

	(method (changeState newState)
		(= state newState)
		(switch state
			(1
				(= betAmount (GetNumber {How many Buckazoids do you bet?}))
				(if (> betAmount buckazoids)
					(Print 810 5)	
					(dlight setScript: dLightIdleScript)
				else
					(if (< betAmount 1)
						(Print 810 8)
						(dlight setScript: dLightIdleScript)
					else
						(if (== buckazoids 1) (++ dapoEgg) else (= dapoEgg 0))
						(= buckazoids (- buckazoids betAmount))
						(= betNumber (GetNumber {Pick a number 1-16}))
						(if (> betNumber 0) 
							(if nagged
								(Print 810 11)
							else
								(Print 810 4)
								(= nagged 1)
							)
						else
							(Print 810 7)
							(if (< buckazoids 1)
								(ego put: iBuckazoids -1)
							)
							(dlight setScript: dLightIdleScript)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(dlight setCel: 0 setCycle: EndLoop self)
				(daboSound play:)
			)
			(3
				(dlight setCycle: EndLoop self)
				(daboSound play:)
			)
			(4
				(if
					(and
						gaveGem
						dapoEgg
					)
					(dlight setCycle: CycleTo betNumber 1 self)
				else
					(dlight setCycle: CycleTo (Random 0 15) 1 self)	
				)
				(daboSound play:)
			)
			(5
				(if (and
						gaveGem
						dapoEgg
					)
					(daboSound stop:)
					(daboWinMusic number: 403 priority: 15 play:)
					(Print {DAPO, baby!!})
					(Print 810 18)
					(= buckazoids (* betAmount 999))
					(= gaveGem 0)
					(= state 98)
					;(= seconds 2)
					(self cue:)
					(= odoGone 1)
					(= gaveGem 0) ;prevent jackpot repeat
				else
					(Printf {The number is %d!!} (dlight cel?))
					(if (== (- betNumber 1) (dlight cel?))
						(Print 810 17)
						(= buckazoids (* betAmount 16))
					else
						(Print {You lost.})
					)
					(= seconds 10)
				)
			)
			(6
				(dlight setScript: dLightIdleScript)
			)
			(99
				(quark
					loop: 2
					setMotion: MoveTo 305 107 self	
				)
			)
			(100
				(quark loop: 0 cel: 0)
				(= cycles 10)
			)
			(101
				(Print 810 15 #at 120 25 #title {Quirk})
				(Print 810 9 #at 150 40 #title {Quirk})
				(Print 810 16 #at 150 40 #title {Quirk})
				(dgirl
					illegalBits: 0
					ignoreActors: 1
					setLoop: 2
					setCel: 0
					setCycle: EndLoop self
				)	
			)
			(102
				(dgirl
					setLoop: 3 
					setCycle: Forward
					setMotion: MoveTo 220 170 self	
				)	
			)
			(103
				(dgirl
					setMotion: MoveTo 260 160 self	
				)	
			)
			(104
				(dgirl
					setMotion: MoveTo 350 160 self	
				)	
			)
			(105
				(dgirl dispose:)
				(dlight setScript: dLightIdleScript)
			)
		)
	)
)

(instance door of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 298 ;56
			setLoop: 2
			setCel: 0
			posn: 156 95
			setPri: 6
			ignoreActors: TRUE
		)
	)
	
	(method (doit)
		(super doit:)
		(if (not (curRoom script?))
			(cond 
				(
					(or
						(== (ego onControl: 0) 2)
						(== (ego onControl: 0) 3)
						(== escape 1)
					)
					(if (> local0 1)
						(= local0 1)
						(self setCycle: EndLoop self)
					)
				)
				((< local0 2) (= local0 3) (self setCycle: BegLoop self))
			)
		)
	)
	
	(method (cue)
		(door stopUpd:)
		(= local0 (if (== local0 1) 0 else 2))
		(if
			(and
				(not escape)
				(not timePod)
				ded
				(== local0 0)
			)
			(++ timePod)
			(Print 810 25)
		)
	)
	
)

(instance holoDoor of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 299
			setLoop: 0
			setCel: 0
			posn: 229 120
			setPri: 8
			ignoreActors: TRUE
		)
	)
	
	(method (doit)
		(super doit:)
		(if (== (holoDoor cel?) 3)
			(curRoom newRoom: 811)	
		)
		(if (not (curRoom script?))
			(cond
				( 
					(or
						(== (ego onControl: 0) 16)
						(== (ego onControl: 0) 17)
					)
					(if (> local1 1)
						(= local1 1)
						(self setCycle: EndLoop self)
					)
				)
				((< local1 2)
					(= local1 3)
					(self setCycle: BegLoop self)
				)
			)
		)
	)
	
	(method (cue)
		(holoDoor stopUpd:)
		(= local1 (if (== local1 1) 0 else 2))
	)
)


(instance quark of Actor
	(properties)
	
	(method (init)
		(super init:)
		(self
			x: 330
			y: 107
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
					loop: 2
					setMotion: MoveTo 305 107 self	
				)
			)
			(1
				(quark loop: 0 cel: 0)
				(= seconds (Random 2 15))
			)
			(2
				(quark
					loop: 1
					setMotion: MoveTo 330 107 self	
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

(instance dLightIdleScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if (== (Random 0 1) 1)
					(dlight setCycle: Forward)
				else 
					(dlight setCycle: Reverse)
				)
				(= seconds (Random 1 3))
			)
			(2
				(dlight setCycle: 0)
				(= state 0)
				(= seconds (Random 2 15))
			)
		)
	)	
)

(instance dLight2Script of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 0 4))
			)
			(1
				(if (== (Random 0 1) 1)
					(dlight2 setCycle: Forward)
				else 
					(dlight2 setCycle: Reverse)
				)
				(= seconds (Random 1 3))
			)
			(2
				(dlight2 setCycle: 0)
				(= state 0)
				(= seconds (Random 2 15))
			)
		)
	)	
)

(instance dLight3Script of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 0 4))
			)
			(1
				(if (== (Random 0 1) 1)
					(dlight3 setCycle: Forward)
				else 
					(dlight3 setCycle: Reverse)
				)
				(= seconds (Random 1 3))
			)
			(2
				(dlight3 setCycle: 0)
				(= state 0)
				(= seconds (Random 2 15))
			)
		)
	)	
) 

(instance dgirlEyeScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 0 15))
			)
			(1
				(dgirl setCycle: EndLoop self)
			)
			(2
				(dgirl setCycle: BegLoop self)
				(= state -1)
			)
		)
	)	
) 

(instance SqlScript of Script
	
	(method (doit)
		(super doit:)
		(if
			(and
				(< (ego distanceTo: SqlPolice) 40)
				(not ded)
			)
			(++ ded)
			(Face SqlPolice ego)
			(SqlPolice 
				view: 835
				cel: 0
			)
			(= seconds 0)
			(= state 99)
			(HandsOff)
			(if saveBits
				(Display 1 0 p_restore saveBits)
			)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp brag)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(= brag (Random 2 20)) ;0 & 1 reserved for escape
				(= saveBits
					(Display 26 brag
						p_width 250
						p_at 5 170
						p_mode teJustCenter
						p_font 600
						p_color vYELLOW
						p_save
					)
				)
				
				(= seconds 6)
			)
			(2
				(Display 1 0 p_restore saveBits)
				(= state -1)
				(self cue:)
			)
			(100
				(SqlPolice setCycle: EndLoop self)
			)
			(101
				(ego 
					view: 79
					loop: 0
					cel: 0
					setCycle: EndLoop self
				)
			)
			(102
				(if (regions contains: (ScriptID 809)) 
					; rog escape
					(theGame changeScore: 50)
					(rogGirl
						view: 836
						setCycle: Walk
						ignoreControl: $ffff
						setMotion: MoveTo 125 125 self
					)
					(= delt 1)
					(= state 199)
					(EgoDead 0 0 11 29)
				else
					; rog ceases to exist
					(rogGirl setCycle: EndLoop)
					(= seconds 4)
				)
			)
			(103
				(rogGirl dispose:)
				(SqlPolice view: 834 loop: 1 cel: 5) ;face left
				(= saveBits
					(Display 26 0 ;no mop
						p_width 250
						p_at 5 170
						p_mode teJustCenter
						p_font 600
						p_color vYELLOW
						p_save
					)
				)
				(= seconds 2)
			)
			(104	
				(EgoDead 0 0 11 29)
			)
			(200
				(= escape 1)
				(rogGirl setMotion: MoveTo 160 100 self)
			)
			(201
				(rogGirl setMotion: MoveTo 135 88 self)
			)
			(202
				(= escape 0)
				(= seconds 2)
			)
			(203
				(rogGirl dispose:)
				(SqlPolice view: 834 loop: 1 cel: 5) ;face left
				(= saveBits
					(Display 26 0 ;no mop
						p_width 250
						p_at 5 170
						p_mode teJustCenter
						p_font 600
						p_color vYELLOW
						p_save
					)
				)
				(= seconds 6)
			)
			(204
				(Display 1 0 p_restore saveBits)
				(= seconds 3)	
			)
			(205
				(= saveBits
					(Display 26 1
						p_width 250
						p_at 5 170
						p_mode teJustCenter
						p_font 600
						p_color vYELLOW
						p_save
					)
				)
				(= seconds 6)
			)
			(206
				(Display 1 0 p_restore saveBits)
				(= seconds 3)	
			)
		)
	)	
) 