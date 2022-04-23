;;; Sierra Script 1.0 - (do not remove this comment)
(script# 900)
(include game.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm900 0
)

(instance rm900 of Room
	(properties
		picture 900
	)
	
	(method (init &tmp event [str 50])
		(= showStyle (| BLACKOUT IRISOUT))
		(User canInput: TRUE canControl: TRUE)
		(Load VIEW 900)
		(super init:)
		(while ((= event (Event new:)) type?)
			(event dispose:)
		)
		(event dispose:)
		(self setScript: rmScript)
	)
	
	(method (handleEvent event &tmp temp0)
		(if (event claimed?) (return))
		(if (event type?)
			(= normalCursor ARROW_CURSOR)
			(theGame setCursor: normalCursor (HaveMouse))
			(theMusic stop:)
			(curRoom newRoom: 2)
		)
	)
)

(instance rmScript of Script
	(method (changeState newState)
		(switch (= state newState)
			(0
				(logo0 init:)
				(shadow0 init:)
				(= cycles 10)
			)
			(1
				(= inCartoon TRUE)
				(theMusic play:)
				(= cycles 10)
			)
			(2
				(if howFast
					(logo0 setMotion: MoveTo 158 17 self)
					(shadow0 setMotion: MoveTo 166 20)
				else
					(logo0 posn: 158 17)
					(shadow0 posn: 166 20)
					(= cycles 1)
				)
			)
			(3
				(logo0 stopUpd:)
				(shadow0 stopUpd:)
				(if (>= howFast medium)
					(logo1 init: setMotion: MoveTo 158 23 self)
					(shadow1 init: setMotion: MoveTo 167 26)
				else
					(logo1 init: posn: 158 23)
					(shadow1 init: posn: 167 26)
					(= cycles 1)
				)
			)
			(4
				(logo1 stopUpd:)
				(shadow1 stopUpd:)
				(if howFast
					(logo2 init: setMotion: MoveTo 158 29 self)
					(shadow2 init: setMotion: MoveTo 167 32)
				else
					(logo2 init: posn: 158 29)
					(shadow2 init: posn: 167 32)
					(= cycles 1)
				)
			)
			(5
				(logo2 stopUpd:)
				(shadow2 stopUpd:)
				(if howFast
					(logo3 init: setMotion: MoveTo 158 35 self)
					(shadow3 init: setMotion: MoveTo 166 38)
				else
					(logo3 init: posn: 158 35)
					(shadow3 init: posn: 166 38)
					(= cycles 1)
				)
			)
			(6
				(logo3 stopUpd:)
				(shadow3 stopUpd:)
				(if howFast
					(logo4 init: setMotion: MoveTo 158 41 self)
					(shadow4 init: setMotion: MoveTo 165 44)
				else
					(logo4 init: posn: 158 41)
					(shadow4 init: posn: 165 44)
					(= cycles 1)
				)
			)
			(7
				(logo4 stopUpd:)
				(shadow4 stopUpd:)
				(if howFast
					(logo5 init: setMotion: MoveTo 158 47 self)
					(shadow5 init: setMotion: MoveTo 166 50)
				else
					(logo5 init: posn: 158 47)
					(shadow5 init: posn: 166 50)
					(= cycles 1)
				)
			)
			(8
				(logo5 stopUpd:)
				(shadow5 stopUpd:)
				(if howFast
					(logo6 init: setMotion: MoveTo 158 53 self)
					(shadow6 init: setMotion: MoveTo 166 56)
				else
					(logo6 init: posn: 158 53)
					(shadow6 init: posn: 166 56)
					(= cycles 1)
				)
			)
			(9
				(logo6 stopUpd:)
				(shadow6 stopUpd:)
				(if howFast
					(logo7 init: setMotion: MoveTo 158 59 self)
					(shadow7 init: setMotion: MoveTo 167 62)
				else
					(logo7 init: posn: 158 59)
					(shadow7 init: posn: 167 62)
					(= cycles 1)
				)
			)
			(10
				(logo7 stopUpd:)
				(shadow7 stopUpd:)
				(if howFast
					(logo8 init: setMotion: MoveTo 158 65 self)
					(shadow8 init: setMotion: MoveTo 166 68)
				else
					(logo8 init: posn: 158 65)
					(shadow8 init: posn: 166 68)
					(= cycles 1)
				)
			)
			(11
				(logo8 stopUpd:)
				(shadow8 stopUpd:)
				(if howFast
					(logo9 init: setMotion: MoveTo 158 71 self)
					(shadow9 init: setMotion: MoveTo 166 74)
				else
					(logo9 init: posn: 158 71)
					(shadow9 init: posn: MoveTo 166 74)
					(= cycles 1)
				)
			)
			(12
				(logo9 stopUpd:)
				(shadow9 stopUpd:)
				(if howFast
					(logo10 init: setMotion: MoveTo 158 77 self)
					(shadow10 init: setMotion: MoveTo 166 80)
				else
					(logo10 init: posn: 158 77)
					(shadow10 init: posn: 166 80)
					(= cycles 1)
				)
			)
			(13
				(logo10 stopUpd:)
				(shadow10 stopUpd:)
				(if howFast
					(logo11 init: setMotion: MoveTo 158 83 self)
					(shadow11 init: setMotion: MoveTo 166 86)
				else
					(logo11 init: posn: 158 83)
					(shadow11 init: posn: 166 86)
					(= cycles 1)
				)
			)
			(14
				(logo11 stopUpd:)
				(shadow11 stopUpd:)
				(if howFast
					(logo12 init: setMotion: MoveTo 158 89 self)
					(shadow12 init: setMotion: MoveTo 166 92)
				else
					(logo12 init: posn: 158 89)
					(shadow12 init: posn: 166 92)
					(= cycles 1)
				)
			)
			(15
				(logo12 stopUpd:)
				(shadow12 stopUpd:)
				(if howFast
					(logo13 init: setMotion: MoveTo 158 95 self)
					(shadow13 init: setMotion: MoveTo 166 98)
				else
					(logo13 init: posn: 158 95)
					(shadow13 init: posn: 166 98)
					(= cycles 1)
				)
			)
			(16
				(logo13 stopUpd:)
				(shadow13 stopUpd:)
				(if howFast
					(logo14 init: setMotion: MoveTo 158 101 self)
					(shadow14 init: setMotion: MoveTo 166 104)
				else
					(logo14 init: posn: 158 101)
					(shadow14 init: posn: 166 104)
					(= cycles 1)
				)
			)
			(17
				(logo14 stopUpd:)
				(shadow14 stopUpd:)
				(if howFast
					(logo15 init: setMotion: MoveTo 158 107 self)
					(shadow15 init: setMotion: MoveTo 166 110)
				else
					(logo15 init: posn: 158 107)
					(shadow15 init: posn: 166 110)
					(= cycles 1)
				)
			)
			(18
				(logo15 stopUpd:)
				(shadow15 stopUpd:)
				(if howFast
					(logo16 init: setMotion: MoveTo 158 113 self)
					(shadow16 init: setMotion: MoveTo 166 116)
				else
					(logo16 init: posn: 158 113)
					(shadow16 init: posn: 166 116)
					(= cycles 1)
				)
			)
			(19
				(logo16 stopUpd:)
				(shadow16 stopUpd:)
				(theS init: setCycle: EndLoop self)
			)
			(20
				(theS stopUpd:)
				(theI init: setCycle: EndLoop self)
			)
			(21
				(theI stopUpd:)
				(theE init: setCycle: EndLoop self)
			)
			(22
				(theE stopUpd:)
				(theR1 init: setCycle: EndLoop self)
			)
			(23
				(theR1 stopUpd:)
				(theR2 init: setCycle: EndLoop self)
			)
			(24
				(theR2 stopUpd:)
				(theA init: setCycle: EndLoop self)
			)
			(25
				(theA stopUpd:)
				(= seconds 2)
			)
			(26
				(presents init:)
				(= seconds 2)
			)
			(27
				(curRoom newRoom: 1)
			)
		)
	)
)

(instance logo0 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 0
			ignoreActors: TRUE
			illegalBits: 0
			posn: -32 17
			setPri: 15
			setStep: 50 1
			setCycle: 0
		)
	)
)

(instance logo1 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 1
			ignoreActors: TRUE
			illegalBits: 0
			posn: 368 23
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo2 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 2
			ignoreActors: TRUE
			illegalBits: 0
			posn: -52 29
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo3 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 3
			ignoreActors: TRUE
			illegalBits: 0
			posn: 378 35
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo4 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 4
			ignoreActors: TRUE
			illegalBits: 0
			posn: -62 41
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo5 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 5
			ignoreActors: TRUE
			illegalBits: 0
			posn: 388 47
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo6 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 6
			ignoreActors: TRUE
			illegalBits: 0
			posn: -72 53
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo7 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 7
			ignoreActors: TRUE
			illegalBits: 0
			posn: 388 59
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo8 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 8
			ignoreActors: TRUE
			illegalBits: 0
			posn: -72 65
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo9 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 0
			ignoreActors: TRUE
			illegalBits: 0
			posn: 378 71
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo10 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 1
			ignoreActors: TRUE
			illegalBits: 0
			posn: -62 77
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo11 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 2
			ignoreActors: TRUE
			illegalBits: 0
			posn: 388 83
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo12 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 3
			ignoreActors: TRUE
			illegalBits: 0
			posn: -62 89
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo13 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 4
			ignoreActors: TRUE
			illegalBits: 0
			posn: 368 95
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo14 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 5
			ignoreActors: TRUE
			illegalBits: 0
			posn: -32 101
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo15 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 6
			ignoreActors: TRUE
			illegalBits: 0
			posn: 348 107
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo16 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 7
			ignoreActors: TRUE
			illegalBits: 0
			posn: -12 113
			setPri: 15
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow0 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 0
			ignoreActors: TRUE
			illegalBits: 0
			posn: -24 20
			setStep: 50 1
			setCycle: 0
		)
	)
)

(instance shadow1 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 1
			ignoreActors: TRUE
			illegalBits: 0
			posn: 376 26
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow2 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 2
			ignoreActors: TRUE
			illegalBits: 0
			posn: -44 32
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow3 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 3
			ignoreActors: TRUE
			illegalBits: 0
			posn: 386 38
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow4 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 4
			ignoreActors: TRUE
			illegalBits: 0
			posn: -55 44
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow5 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 5
			ignoreActors: TRUE
			illegalBits: 0
			posn: 396 50
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow6 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 6
			ignoreActors: TRUE
			illegalBits: 0
			posn: -64 56
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow7 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 7
			ignoreActors: TRUE
			illegalBits: 0
			posn: 397 62
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow8 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 8
			ignoreActors: TRUE
			illegalBits: 0
			posn: -64 68
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow9 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 0
			ignoreActors: TRUE
			illegalBits: 0
			posn: 386 74
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow10 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 1
			ignoreActors: TRUE
			illegalBits: 0
			posn: -54 80
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow11 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 2
			ignoreActors: TRUE
			illegalBits: 0
			posn: 396 85
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow12 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 3
			ignoreActors: TRUE
			illegalBits: 0
			posn: -54 92
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow13 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 4
			ignoreActors: TRUE
			illegalBits: 0
			posn: 376 98
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow14 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 5
			ignoreActors: TRUE
			illegalBits: 0
			posn: -24 104
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow15 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 6
			ignoreActors: TRUE
			illegalBits: 0
			posn: 356 110
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow16 of Actor
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 7
			ignoreActors: TRUE
			illegalBits: 0
			posn: -4 116
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance theS of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 4
			cel: (if (>= howFast medium) 0 else 4)
			posn: 77 132
			ignoreActors: TRUE
		)
	)
)

(instance theI of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 5
			cel: (if (>= howFast medium) 0 else 4)
			posn: 102 132
			ignoreActors: TRUE
		)
	)
)

(instance theE of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 6
			cel: (if (>= howFast medium) 0 else 4)
			posn: 127 133
			ignoreActors: TRUE
		)
	)
)

(instance theR1 of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 7
			cel: (if (>= howFast medium) 0 else 4)
			posn: 163 133
			ignoreActors: TRUE
		)
	)
)

(instance theR2 of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 7
			cel: (if (>= howFast medium) 0 else 4)
			posn: 201 133
			ignoreActors: TRUE
		)
	)
)

(instance theA of Prop
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 8
			cel: (if (>= howFast medium) 0 else 4)
			posn: 237 133
			ignoreActors: TRUE
		)
	)
)

(instance presents of View
	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 9
			cel: 0
			ignoreActors: TRUE
			posn: 158 175
		)
	)
)
