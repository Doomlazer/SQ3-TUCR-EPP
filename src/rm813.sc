;;; Sierra Script 1.0 - (do not remove this comment)
(script# 813)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room813 0
)

(local)

(procedure (checkPad pad)
	(if
		(and
			(< tdx (pad nsRight?))
			(> tdx (pad nsLeft?))
			(< tdy (pad nsBottom?))
			(> tdy (pad nsTop?))
		)
		(return)
	)
	(if
		(and
			(< (ego x?) (pad nsRight?))
			(> (ego x?) (pad nsLeft?))
			(< (ego y?) (pad nsBottom?))
			(> (ego y?) (pad nsTop?))
		)
		(return)
	)	
)

(instance door of Actor
	
	(method (init)
		(super init:)
		(self
			view: 303
			ignoreHorizon:
			illegalBits: 0
			;ignoreControl: (| cGREEN cRED cWHITE)
			setLoop: 1
			setCel: 0
			setPri: 2
			x: 160
			y: 115
		)
	)
	
	(method (doit)
		(super doit:)
		(if 
			(and
				(== (pad1 cel?) 2)
				(== (pad2 cel?) 2)
			)
			(if (> (self y?) 40)
				(self setStep: 2 3 setMotion: MoveTo (self x?) 40)
			)	
		else
			(if (< (self y?) 115)
				(self setStep: 2 1 setMotion: MoveTo (self x?) 115)
			)
		)

		(if (< (self y?) 75)
			(ego illegalBits: (| cGREEN cWHITE))
		else
			(ego illegalBits: (| cGREEN cRED cWHITE))
;;;			(if
;;;				(and
;;;					(& (ego onControl:) cRED)
;;;					(< (self y?) 80)
;;;					(> (self y?) 75)
;;;				)
;;;				(Print {the door crushes your skull.})
;;;				(EgoDead 901 0 15 1)
;;;			)
		)
	)
)


(instance pad1 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 303
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 3
			x: 78
			y: 147
		)
	)
	
	(method (doit)
		(super doit:)
		(if (checkPad self)
			(if (== (self cel?) 0)
				(self setCycle: EndLoop)
			)
		else
			(if (== (self cel?) 2)
				(self setCycle: BegLoop)
			)
		)
	)
)

(instance pad2 of Prop
	(method (init)
		(super init:)
		(self
			view: 303
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 3
			x: 220
			y: 147
		)
	)
	
	(method (doit)
		(super doit:)
		(if (checkPad self)
			(if (== (self cel?) 0)
				(self setCycle: EndLoop)
			)
		else
			(if (== (self cel?) 2)
				(self setCycle: BegLoop)
			)
		)
	)
)

(instance Room813 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init)
		(super init:)
		(= tdx 0)
		(= tdy 0)
		(ego
			view: 0
			setStep: 3 2
			init:
		)	
		(pad1 init:)
		(pad2 init:)
		(door init:)
		;(door2 init:)
		;(ego get: 18)
		(switch prevRoomNum
			(814
				(ego posn: 163 151 loop: 3)
			)
			(else
				(ego posn: 160 200)
				(self setScript: RoomScript)
			)
		)
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
		(if (< (ego y?) 105)
			(curRoom newRoom: 800) ;814)	
		)
		(if (> (ego y?) 205)
			(curRoom newRoom: 800)
		)
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
					setMotion: MoveTo 160 180 self
				)
			)
			(1
				(RedrawCast)
				(if (ego has: iGoggles)
					(Print 800 18)
				)
				(HandsOn)
				(self dispose:)
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