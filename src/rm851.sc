;;; Sierra Script 1.0 - (do not remove this comment)
(script# 851)
(include game.sh)
(use Main)
(use Intrface)
(use ScumSoft)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm851 0
)

(instance rm851 of Room
	(properties
		picture 851
		style HSHUTTER
		east 852
	)
	
	(method (init)
		(super init:)
		(Load VIEW 131)
		(Load VIEW 132)
		(Load VIEW 133)
		(Load SOUND 54)
		(addToPics
			add:
				prog01
				prog02
				prog03
				prog04
				prog05
				prog06
				prog07
				prog08
				prog09
				prog10
				prog11
				prog12
				prog13
				prog14
				prog15
				prog16
				prog17
				prog18
				prog19
				prog20
				prog21
				prog22
				prog23
				prog24
				prog25
				prog26
		)
		(addToPics doit:)
		(rick init:)
		(ken init:)
		(trash1 init:)
		(ego init:)
;;;		(if elmoAtDesk
;;;			(= elmoAtDesk FALSE)
;;;			(trash1 myNerd: 0)
;;;			(if ((inventory at: iKeycard) ownedBy: curRoomNum)
;;;				(if killedElmo
;;;					; key card is now impossible to get
;;;				else
;;;					(keycard init:)
;;;				)
;;;			)
;;;		else
;;;			(if killedElmo
;;;				;; ded	
;;;			else
;;;				(= elmoAtDesk TRUE)
;;;				(elmo init:)
;;;				(trash1 setCel: (= [trashVaporized 0] 0))
;;;				(trash1 vaporized: 0)
;;;			)
;;;		)
		(self setScript: rmScript)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
;;;					((Said 'look[/area]')
;;;						(if elmoAtDesk
;;;							(Print 93 0)
;;;						else
;;;							(if killedElmo
;;;								(Print 93 19)
;;;							else
;;;								(Print 93 1)
;;;							)
;;;						)	
;;;					)
;;;					((Said 'look/man,boss')
;;;						(if (and elmoAtDesk (ego inRect: 225 86 320 149))
;;;							(Print 93 2)
;;;						else
;;;							(Print 93 3)
;;;						)
;;;					)
;;;					((Said 'give/package')
;;;						(if (ego has: iPackage)
;;;							(if elmoAtDesk
;;;								(if (ego inRect: 225 86 320 149)
;;;									(ego put: iPackage 93)
;;;									(Print 93 18)
;;;									(Print 93 17)
;;;									(= killedElmo 1)
;;;								else
;;;									(NotClose)
;;;								)
;;;							else
;;;								(Print 93 16)
;;;							)
;;;						)
;;;					)
;;;					((Said '*/complex')
;;;						(Print 93 4)
;;;					)
;;;					((Said 'converse/man,boy,elmo,boss,bystander')
;;;						(if (and elmoAtDesk (ego inRect: 225 86 320 149))
;;;							(Print 93 5)
;;;						else
;;;							(Print 93 6)
;;;						)
;;;					)
;;;					((Said 'look,open,explore,unlock/desk,drawer')
;;;						(if (ego inRect: 225 86 320 149)
;;;							(cond 
;;;								(elmoAtDesk
;;;									(Print 93 7)
;;;								)
;;;								(((inventory at: iKeycard) ownedBy: curRoomNum)
;;;									(Print 93 8)
;;;								)
;;;								(else
;;;									(Print 93 9)
;;;								)
;;;							)
;;;						else
;;;							(Print 93 10)
;;;						)
;;;					)
;;;					((Said 'get/key,card')
;;;						(cond 
;;;							(elmoAtDesk
;;;								(Print 93 11)
;;;							)
;;;							(((inventory at: iKeycard) ownedBy: curRoomNum)
;;;								(if (ego inRect: 275 89 300 104)
;;;									(ego get: iKeycard)
;;;									(keycard dispose:)
;;;									(Print 93 12)
;;;									(theGame changeScore: 5)
;;;								else
;;;									(Print 93 13)
;;;								)
;;;							)
;;;							((ego has: iKeycard)
;;;								(Print 93 14)
;;;							)
;;;							(else
;;;								(Print 93 15)
;;;							)
;;;						)
;;;					)
				)
			)
		)
	)
	
	(method (newRoom n)
		(if (== n 94)
			(theMusic stop:)
		)
		(timers eachElementDo: #dispose 84)
		(super newRoom: n)
	)
)

(instance rmScript of Script
	(method (init)
		(super init: &rest)
		(ego posn: init:)
		(if (== prevRoomNum 850)
			(ego posn: 240 200 setMotion: MoveTo 240 180 self)
		)
		(if (== prevRoomNum 852) ; TODO: add basement 
			(ego posn: 315 70 setMotion: MoveTo 275 70 self)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(> (ego y?) 200)
				(== (ego script?) 0) 
			)
			(curRoom newRoom: 850)
		)
		(if
			(and
				(== (ken loop?) 0)
				(< (rick loop?) 2)
				(== 10 (Random 1 20))
			)
			(if (== (kenScript state?) 1)
				(kenScript start: 1)
			else
				(kenScript start: 0)
			)
			(ken setScript: kenWhip)
		)
		(if
			(and
				(== (rick loop?) 0)
				(< (ken loop?) 2)
				(== 10 (Random 1 20))
			)
			(if (== (rickScript state?) 0)
				(rickScript start: 0)
			else
				(rickScript start: 1)
			)
			(rick setScript: rickWhip)
		)
	)
)

(instance trash1 of TrashBasket
	(properties
		nearWest 225
		nearNorth 86
		nearEast 320
		nearSouth 149
	)
	
	(method (init)
		(super init:)
		(self posn: 256 103 myNerd: elmo)
	)
)

(instance elmo of Nerd
	(method (init)
		(super init:)
		(self
			view: 115
			setLoop: 8
			posn: 263 84
			setPri: 6
			speakX: 167
			speakY: 75
			speakCel: 0
		)
	)
)

(instance keycard of View
	(method (init)
		(self
			view: 115
			setLoop: 9
			setCel: 1
			setPri: 6
			posn: 285 92
		)
		(super init:)
	)
)

;;;(class ProgPri14 of PicView	;EO: was a class, but not in the class table
;;;	(properties
;;;		heading 0
;;;;;;		yStep 133
;;;;;;		cel 14
;;;		view 133
;;;		loop 0
;;;		cel 1
;;;		priority 14 ;16384
;;;		signal ignrAct
;;;	)
;;;)
;;;
;;;(class ProgPri4 of PicView	;EO: was a class, but not in the class table
;;;	(properties
;;;		heading 0
;;;		view 133
;;;		loop 0
;;;		cel 1
;;;		priority 4
;;;		signal ignrAct
;;;	)
;;;)
;;;
;;;(class ProgPri2 of PicView	;EO: was a class, but not in the class table
;;;	(properties
;;;		heading 0
;;;		view 133
;;;		loop 0
;;;		cel 1
;;;		priority 2
;;;		signal ignrAct
;;;	)
;;;)

(instance prog01 of PicView ;ProgPri14
	(properties
		y 181
		x 176
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog02 of PicView ;ProgPri14
	(properties
		y 150
		x 175
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog03 of PicView ;ProgPri14
	(properties
		y 118
		x 173
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog04 of PicView ;ProgPri14
	(properties
		y 87
		x 171
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog05 of PicView ;ProgPri14
	(properties
		y 54
		x 170
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog06 of PicView ;ProgPri14
	(properties
		y 24
		x 170
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog07 of PicView ;ProgPri14
	(properties
		y 181
		x 134
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog08 of PicView ;ProgPri14
	(properties
		y 150
		x 138
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog09 of PicView ;ProgPri14
	(properties
		y 118
		x 140
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog10 of PicView ;ProgPri14
	(properties
		y 87
		x 141
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog11 of PicView ;ProgPri14
	(properties
		y 55
		x 141
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog12 of PicView ;ProgPri14
	(properties
		y 24
		x 143
		view 133
		loop 0
		cel 0
		priority 14
		signal ignrAct
	)
)

(instance prog13 of PicView ;ProgPri4
	(properties
		y 181
		x 56
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog14 of PicView ;ProgPri4
	(properties
		y 150
		x 63
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog15 of PicView ;ProgPri4
	(properties
		y 118
		x 70
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog16 of PicView ;ProgPri4
	(properties
		y 87
		x 78
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog17 of PicView ;ProgPri4
	(properties
		y 55
		x 88
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog18 of PicView ;ProgPri4
	(properties
		y 24
		x 96
		view 133
		loop 0
		cel 1
		priority 4
		signal ignrAct
	)
)

(instance prog19 of PicView ;ProgPri2
	(properties
		y 181
		x 16
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog20 of PicView ;ProgPri2
	(properties
		y 150
		x 26
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog21 of PicView ;ProgPri2
	(properties
		y 118
		x 37
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog22 of PicView ;ProgPri2
	(properties
		y 87
		x 48
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog23 of PicView ;ProgPri2
	(properties
		y 55
		x 59
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog24 of PicView ;ProgPri2
	(properties
		y 24
		x 72
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog25 of PicView ;ProgPri2
	(properties
		y 24
		x 26
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance prog26 of PicView ;ProgPri2
	(properties
		y 56
		x 10
		view 133
		loop 0
		cel 1
		priority 2
		signal ignrAct
	)
)

(instance rick of Actor
	(method (init)
		(self
			ignoreHorizon: TRUE
			view: 131
			x: 116
			y: -5
			setPri: 14
			setCycle: Forward
			setStep: 1 1
			ignoreActors: TRUE
			ignoreControl: -1
			setScript: rickScript
		)
		(super init:)
	)
)

(instance rickScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick setLoop: 0 setMotion: MoveTo 97 148 self)
			)
			(1
				(rick setLoop: 1 setMotion: MoveTo 116 -5 self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance ken of Actor
	(method (init)
		(self
			ignoreHorizon: TRUE
			view: 132
			x: -11
			y: 136
			setPri: 14
			setCycle: Forward
			setStep: 1 1
			ignoreActors: TRUE
			ignoreControl: -1
			setScript: kenScript
		)
		(super init:)
	)
)

(instance kenScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 1 setMotion: MoveTo 48 -5 self)
			)
			(1
				(ken setLoop: 0 setMotion: MoveTo -11 136 self)
			)
			(2
				(kenScript start: 0)
				(self init:)
			)
		)
	)
)

(instance rickWhip of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rick
					setLoop: (if (<= 5 (Random 1 10)) 2 else 3)
					setCel: 0
					setMotion: 0
					setCycle: EndLoop self
				)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(rick setCycle: Forward setLoop: 0 setScript: rickScript)
				)
			)
			(else  (self init:))
		)
	)
)

(instance kenWhip of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 2 setCel: 0 setMotion: 0 setCycle: EndLoop self)
				(whipSound play:)
			)
			(1
				(if (!= (whipSound prevSignal?) -1)
					(-- state)
					(Timer setCycle: self 3)
				else
					(ken setCycle: Forward setLoop: 0 setScript: kenScript)
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance whipSound of Sound
	(properties
		number 54
		priority 1
	)
)
