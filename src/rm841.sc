;;; Sierra Script 1.0 - (do not remove this comment)
(script# 841)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room841 0
)

(local
	code
	ringToggle = 0
	printObj
	decoderNum ;mod
	ringTable = [84 86 88 90 92 94 96 98 100 102 104 106 108 151 153 155 157 159 161 163 165 167 169 171 173 175]
)

(instance Room841 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(= decoderNum (Random 2 23))
		(= code (Random 26 114))	
		(super init:)
		(ego get: iDecoderRing)
		(switch prevRoomNum
			(813
				(self setScript: RoomScript)
			)
			(840
				(ego posn: 150 120 loop: 1)
			)
			(else 
				(ego posn: 150 120 loop: 1)
			)
		)
		(ego init:)
		(Decrypt)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(> (ego y?) 185)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 813)
		)
		(if
			(and
				(< (ego y?) 90)
				(== (curRoom script?) 0) 
			)
			(curRoom newRoom: 840)
		)
	)
	
	(method (handleEvent pEvent &tmp i [pass 50] [str 50] [upper 50])
		(super handleEvent: pEvent)
		
		(if (Said 'use/decoder,relic')
			(if (ego has: iDecoderRing)
				(= ringToggle TRUE)
				(Decrypt)
		 		(CryptShift)
		 		(Decrypt)
		 	else
		 		(DontHave)
			)
		)
		(if
			(or
				(Said 'use/keypad')
				(Said 'enter/password')
			)
			(GetInput @pass 20 {Enter Password:})
				(StrCpy @upper (ToUpper (Format @str 841 code)))
			(if (not (StrCmp @upper (ToUpper @pass)))
				(Print {Password Accepted})	
			else
				(Print {Password Incorrect})	
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
					(813
						(ego
							posn: 160 200
							setMotion: MoveTo 160 180 self
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

(procedure (Decrypt &tmp i [str 200] t f x offsetNum stepper)
	(= stepper 0)
	(if ringToggle
		(= f 778)
	else
		(= f 777)
	)
	(= offsetNum (- decoderNum sDoorCodeDistance))
	(if (< offsetNum 0)
		(= offsetNum (+ offsetNum 26))
	)
	(if (> offsetNum 25)
		(= offsetNum (- offsetNum 26))
	)
	(curRoom drawPic: 841)
	(StrCpy @str (ToUpper (Format @str 841 code)))
	(= i 0)
	(= t 0)
	(while (< i (StrLen @str))
		;(Printf {was: %s} (StrAt @str i))
		(if
			(or
				(== 10 (StrAt @str i)) ;line break
				(== 32 (StrAt @str i)) ;space
				(== 33 (StrAt @str i)) ;exlaim
				(== 39 (StrAt @str i)) ;apostro
				(== 46 (StrAt @str i)) ;period
			)
			(StrAt @str i (StrAt @str i))
		else
			(if ringToggle
				(= x (+ offsetNum stepper))
			else
				(= x stepper)
			)
			(if (< x 0)
				(= x (+ x 26))
			)
			(if (> x 25)
				(= x (- x 26))
			)
			(= t (+ (StrAt @str i) x))
			(if (> t 90)
				(= t (- t 26))	
			)
			(StrAt @str i t)
		)
		(++ i)
		(++ stepper)
		;(Printf {now: %s} (StrAt @str i))
	)
	;(Printf {x at: %d} (- 160 (* 8 (/ (StrLen @str) 2))))
	;(Printf {minus: %d} (* 8 (/ (StrLen @str) 2)))	
	(= printObj
		(Display @str 
			p_at (- 150 (/ (* (StrLen @str) 7) 2)) 65
			;p_width 50
			p_color 4
			p_back 7 ;vBLACK
			p_font f 
		)
	)	
)

(procedure (CryptShift &tmp i [str 200] t)
	(= inCartoon TRUE)
	(RedrawCast)
	(while (not (== printObj 2))
		(Format @str 290 10)
		(= i 0)
		(= t 0)
		(while (< i 26)
			;(Printf {StrAt @str : %d} (StrAt @str [ringTable i])) 
			(= t (+ (StrAt @str [ringTable i]) decoderNum))
			(if (> t 90)
				(= t (- t 26))	
			)
			;(Printf {t : %d} t) 
			(StrAt @str [ringTable i] t)
			(++ i)
		)	
		(= printObj
			(Print @str ;290 10
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
		(if (== printObj 2)
			(= printObj 0)
			(curRoom drawPic: 841)
			(= ringToggle FALSE)	
			(break)	
		)
		(if (== printObj 3)
			(= decoderNum (+ decoderNum 1))
			(if (> decoderNum 25)
				(= decoderNum 0)	
			)
		)
		(Decrypt)
	)
)