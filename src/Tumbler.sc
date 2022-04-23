;;; Sierra Script 1.0 - (do not remove this comment)
(script# 770)
(include sci.sh)
(use Main)
(use genetix)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm770 0
)

(local
	gEgoOnControl
	local1
)
(instance rm770 of Rm
	(properties
		noun 4
		picture 115
	)
	
	(method (init)
		(proc958_0 143 number)
		(gSq5Music2 stop:)
		(self setRegions: 31)
		(= style -32668)
		(super init:)
		(plate init: setOnMeCheck: 1 (plate onMeCheck?))
		(proc0_6 603)
		(gEgo
			view: 603
			init:
			scaleSignal: 0
			cycleSpeed: 3
			setStep: 3 3
			scaleX: 128
			scaleY: 128
			setCycle: Walk
		)
		(switch gGModNum
			(730
				(global2 setScript: sFrom730)
			)
			(790
				(global2 setScript: sFrom790)
			)
			(else 
				(proc0_2 24)
				(proc0_2 25)
				(proc0_2 26)
				(proc0_2 22)
				(proc0_2 27)
				(global2 setScript: sFrom790)
			)
		)
		(beam1 init:)
		(beam2 init:)
		(beam3 init:)
		(beam4 init:)
		(beam5 init:)
		(beam6 init:)
		(beam7 init:)
		(beam8 init:)
		(beam9 init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init: 107 96 186 130 215 117 256 133 256 104 146 71 106 81 106 94
					yourself:
				)
		)
		(tumbler1 init:)
		(tumbler2 init:)
		(tumbler3 init:)
		(tumbler4 init:)
		(gSq5Music1 number: 121 setLoop: -1 play:)
	)
	
	(method (doit)
		(= gEgoOnControl (gEgo onControl:))
		(if (not (global2 script?))
			(if (& $1000 gEgoOnControl)
				(global2 setScript: (ScriptID 31 3) 0 7)
			)
			(if (& $0800 gEgoOnControl)
				(global2 setScript: (ScriptID 31 3) 0 8)
			)
		)
		(super doit:)
	)
)

(instance sFrom790 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo posn: 108 63 setMotion: MoveTo 140 83 self)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrom730 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo posn: 281 126 setMotion: MoveTo 231 117 self)
			)
			(1
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Tumbler of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 1
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		state $0000
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view 615
		loop 1
		cel 0
		priority 3
		underBits 0
		signal $0010
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
	)
	
	(method (init)
		(super init:)
		(= signal (| signal $0008))
	)
	
	(method (dispose)
		(= signal (| signal $0008))
		(= signal (| signal $8000))
	)
	
	(method (hide)
		(super hide:)
		(self cue:)
	)
	
	(method (show)
		(super show:)
		(self cue:)
	)
	
	(method (cue)
		(gSq5Music2 number: 611 setLoop: 1 play:)
	)
)

(instance tumbler1 of Tumbler
	(properties
		x 251
		y 80
	)
)

(instance tumbler2 of Tumbler
	(properties
		x 251
		y 71
	)
)

(instance tumbler3 of Tumbler
	(properties
		x 251
		y 62
	)
)

(instance tumbler4 of Tumbler
	(properties
		x 251
		y 53
	)
)

(class Beam of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 2
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		state $0000
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view 615
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0010
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
	)
	
	(method (doit)
		(cond 
			((& onMeCheck gEgoOnControl) (if (not (& signal $0088)) (self hide:)))
			((& signal $0088) (self show:))
		)
		(super doit:)
	)
	
	(method (hide)
		(if (not local1)
			(= local1 1)
			(super hide:)
			(switch self
				(beam2 (tumbler1 show:))
				(beam4 (tumbler2 show:))
				(beam6 (tumbler3 show:))
				(beam8 (tumbler4 show:))
			)
		)
	)
	
	(method (show)
		(= local1 0)
		(super show:)
		(switch self
			(beam2 (tumbler1 hide:))
			(beam4 (tumbler2 hide:))
			(beam6 (tumbler3 hide:))
			(beam8 (tumbler4 hide:))
		)
	)
)

(instance beam1 of Beam
	(properties
		x 142
		y 71
		onMeCheck $0002
		cel 8
		priority 7
	)
)

(instance beam2 of Beam
	(properties
		x 162
		y 65
		onMeCheck $0004
		cel 7
		priority 6
	)
)

(instance beam3 of Beam
	(properties
		x 180
		y 60
		onMeCheck $0008
		cel 5
		priority 5
	)
)

(instance beam4 of Beam
	(properties
		x 164
		y 79
		onMeCheck $0010
		cel 6
		priority 8
	)
)

(instance beam5 of Beam
	(properties
		x 184
		y 73
		onMeCheck $0020
		cel 1
		priority 7
	)
)

(instance beam6 of Beam
	(properties
		x 203
		y 67
		onMeCheck $0040
		cel 2
		priority 6
	)
)

(instance beam7 of Beam
	(properties
		x 189
		y 89
		onMeCheck $0080
		cel 3
		priority 9
	)
)

(instance beam8 of Beam
	(properties
		x 210
		y 82
		onMeCheck $0100
		cel 1
		priority 8
	)
)

(instance beam9 of Beam
	(properties
		x 228
		y 75
		onMeCheck $0200
		priority 7
	)
)

(instance plate of Feature
	(properties
		x 271
		y 189
		noun 3
		onMeCheck $53fe
	)
)

(instance cliffy of MyActor
	(properties
		noun 1
		view 20
		signal $4000
	)
)
