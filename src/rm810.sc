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
	
	(method (init)
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
			init:
		)
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
					((Said 'look>')
						(cond 
							((Said '/quark,bartender,man') (Print 810 3))
							((Said '/woman,alien') (Print 810 2))
							((Said '/dabo[/table]') (Print 810 1))
							((Said '[<around,at,in][/area,cafe]') (Print 810 0))
						)
					)
					((Said 'bet,play,dabo[/*]')
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
				(if gaveGem
					(dlight setCycle: CycleTo betNumber 1 self)
				else
					(dlight setCycle: CycleTo (Random 0 15) 1 self)	
				)
				(daboSound play:)
			)
			(5
				(if gaveGem
					(daboSound stop:)
					(daboWinMusic number: 403 priority: 15 play:)
					(Print {DABO!!!!!})
					(Print {YOU WON 999x your bet!})
					(= buckazoids (* betAmount 999))
					(= gaveGem 0)
					(= state 100)
					(= seconds 2)
					(= odoGone 1)
				else
					(if (== (- betNumber 1) (dlight cel?))
						(Print {YOU WON 16x your bet!})
						(= buckazoids (* betAmount 16))
					else
						(Print {You lost!})
					)
					(= seconds 10)
				)
			)
			(6
				(dlight setScript: dLightIdleScript)
			)
			(101
				(Print 810 9 #at 160 40 #title {Quark})
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
					setMotion: MoveTo 350 160 self	
				)	
			)
			(103
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