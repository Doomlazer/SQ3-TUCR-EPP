;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1885)
(include sci.sh)
(use Main)
(use Blink)
(use View)

(public
	Droole 21
)

(instance Droole of Talker
	(properties
		x 10
		y 25
		view 1004
		loop 4
		talkWidth 150
		back 5
		textX 120
		textY 10
	)
	
	(method (init)
		(= font gFont)
		(drooleEyes setLoop: (Random 2 3))
		(super init: drooleBust drooleEyes drooleMouth &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance drooleBust of Prop
	(properties
		view 1004
	)
)

(instance drooleEyes of Prop
	(properties
		nsTop 12
		nsLeft 50
		view 1004
		loop 2
	)
)

(instance drooleMouth of Prop
	(properties
		nsTop 32
		nsLeft 47
		view 1004
		loop 1
	)
)
