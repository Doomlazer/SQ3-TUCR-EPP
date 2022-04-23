;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1882)
(include sci.sh)
(use Main)
(use Blink)
(use View)

(public
	Bea 26
)

(instance Bea of Talker
	(properties
		x 10
		y 25
		view 1001
		loop 5
		talkWidth 150
		back 5
		textX 120
		textY 10
	)
	
	(method (init)
		(= font gFont)
		(beaEyes setLoop: (Random 2 3))
		(super init: beaBust beaEyes beaMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance beaBust of Prop
	(properties
		view 1001
	)
)

(instance beaEyes of Prop
	(properties
		nsTop 20
		nsLeft 54
		view 1001
		loop 2
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 34
		nsLeft 47
		view 1001
		loop 1
	)
)
