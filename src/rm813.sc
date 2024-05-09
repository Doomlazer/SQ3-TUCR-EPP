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
(use pet)

(public
	Room813 0
)

(local
	wearingGoggles
)

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
			setLoop: (if wearingGoggles 2 else 1)
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
		(if (== (ego view?) 306)
			(= wearingGoggles TRUE)
			(= picture 904)
		)
		(super init:)
		(Display 841 0
			p_at 220 68
			p_font 600
			p_width 10
			p_color vBLACK
		)
		(Display 841 sDoorCodeDistance
			p_at 77 68
			p_font 777
			p_width 10
			p_color vBLACK
		)
		(= tdx 0)
		(= tdy 0)
		(ego
			view: (if wearingGoggles 321 else 0)
			setStep: 3 2
			init:
		)	
		(pad1 init:)
		(pad2 init:)
		(door init:)
		(switch prevRoomNum
			(814
				(ego posn: 163 151 loop: 3)
			)
			(841
				(self setScript: exitScript)
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
			(Print {fix me})
		)	
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(< (ego y?) 105)
				(== (curRoom script?) 0)
			)
			(curRoom newRoom: 840)	
		)
		(if
			(and
				(> (ego y?) 185)
				(== (curRoom script?) 0)
			)
			(curRoom newRoom: 800)
		)
		(if (< (ego x?) -5)
			(Print 800 21)
			(ego setMotion: MoveTo 10 (ego y?))
		)
		(if (> (ego x?) 325)
			(Print 800 21)
			(ego setMotion: MoveTo 315 (ego y?))
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

		)	
	)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(if petActive
					(PetGoggleVision 1)
				)
				(HandsOff)
				(ego
					setMotion: MoveTo 160 180 self
				)
			)
			(1
				(RedrawCast)
				(if wearingGoggles
					(= wearingGoggles FALSE)
					(Print 800 18)
					(if petActive
						(PetGoggleVision 0)
					)
					(ego view: 0)
					(door loop: 1)
					(DrawPic 902 100)
					(DrawPic 813 100)
					(= saveDisabled FALSE)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
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
				(door posn: 160 60)
				(ego
					posn: 160 90
					setMotion: MoveTo 160 125 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

