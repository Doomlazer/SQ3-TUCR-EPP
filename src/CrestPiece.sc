;;; Sierra Script 1.0 - (do not remove this comment)
(script# 119)
(include sci.sh)
(use Main)
(use GravMover)
(use starCon)
(use Print)
(use PAvoider)
(use Blink)
(use PolyPath)
(use Polygon)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm119 0
	genTalker 1
	quirkTalker2 2
	beaTalker 10
	quirkTalker 14
	rogTalker 15
)

(local
	[local0 16] = [160 46 160 65 138 65 138 46 178 74 200 74 200 93 178 93]
	[local16 10]
	local26
	local27
	local28
	gEgoX
	gEgoY
	newPolygon
	local32
	local33 =  5
	local34 =  -1
	local35 =  5
	theTheCone1
	local37
	local38
	local39
	theCone1
	local41
	theSeconds =  30
	[local43 104] = [-22 175 330 175 -22 1 330 1 29 143 0 -22 320 -22 175 330 175 -22 1 330 1 29 143 0 -22 320 29 -10 29 200 287 -10 287 200 81 231 0 -10 200 29 200 29 -10 287 200 287 -10 81 231 0 200 -10 0 100 79 189 228 0 319 62 27 130 100 -10 190 51 1 0 64 319 59 234 189 170 270 -170 -10 220 170 189 319 50 0 66 74 -1 0 120 140 200 -10 102 189 0 107 319 66 237 -10 200 300 -220 200 -10]
)
(procedure (localproc_020a)
	(proc0_6 129 &rest)
	(gEgo
		baseSetter: myBaseSetter
		setPri: 14
		setStep: 6 5
		setScale: 0
		noun: 19
		setAvoider: PAvoider
	)
)

(procedure (localproc_023f param1 param2 param3 param4 param5 param6 param7)
	(param1
		view: param2
		loop: param3
		cel: param4
		x: param5
		y: param6
		setPri: param7
		ignoreActors: 1
	)
)

(procedure (localproc_0264 &tmp temp0 temp1 temp2 [temp3 10])
	(= temp0 19)
	(while (< temp0 155)
		(= temp1 72)
		(while (< temp1 252)
			(if
				(and
					(& (= temp2 (OnControl 4 temp1 temp0)) $001e)
					(< (= temp2 (OnControl 2 temp1 temp0)) 4)
				)
				(return 0)
			)
			(= temp1 (+ temp1 10))
		)
		(= temp0 (+ temp0 10))
	)
	(return 1)
)

(procedure (localproc_02bb &tmp temp0 temp1 temp2 temp3 temp4)
	(p1 case: 9)
	(p2 case: 9)
	(p3 case: 9)
	(p4 case: 9)
	(= temp2 (- (gEgo x?) 4))
	(= temp1 (- (gEgo y?) 10))
	(= temp4 (+ (gEgo x?) 2))
	(= temp3 (+ (gEgo y?) 9))
	(Graph grFILL_BOX temp1 temp2 temp3 temp4 2 -1 2 -1)
	(Graph
		grFILL_BOX
		(+ temp1 1)
		(- temp2 2)
		(- temp3 1)
		(+ temp4 2)
		2
		-1
		2
		-1
	)
	(Graph
		grFILL_BOX
		(+ temp1 2)
		(- temp2 3)
		(- temp3 2)
		(+ temp4 3)
		2
		-1
		2
		-1
	)
	(Graph
		grFILL_BOX
		(+ temp1 3)
		(- temp2 4)
		(- temp3 3)
		(+ temp4 4)
		2
		-1
		2
		-1
	)
	(Graph
		grFILL_BOX
		(+ temp1 4)
		(- temp2 5)
		(- temp3 4)
		(+ temp4 5)
		2
		-1
		2
		-1
	)
	(Graph
		grFILL_BOX
		(+ temp1 6)
		(- temp2 6)
		(- temp3 6)
		(+ temp4 6)
		2
		-1
		2
		-1
	)
)

(procedure (localproc_03e7 param1 &tmp temp0 [temp1 30])
	(switch param1
		(0
			(if (< (= temp0 (- (gEgo heading?) 90)) 0)
				(= temp0 (+ temp0 360))
			)
			(if (> (= temp0 (- 450 temp0)) 359)
				(= temp0 (- temp0 360))
			)
		)
		(1
			(if
			(not (mod (= temp0 (- 360 (gEgo heading?))) 180))
				(= temp0 (- temp0 180))
			)
		)
		(2
			(if (< (= temp0 (- (gEgo heading?) 180)) 0)
				(= temp0 (+ temp0 360))
			)
		)
	)
	(gEgo setMotion: GravMover temp0)
)

(procedure (localproc_047b &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(cond 
		(
			(and
				local27
				(proc999_4
					(- (cone1 nsLeft?) 10)
					(- (cone1 nsTop?) 10)
					(+ (cone1 nsRight?) 10)
					(+ (cone1 nsBottom?) 10)
					disk
				)
			)
			(= theCone1 cone1)
		)
		(
			(and
				local27
				(proc999_4
					(- (cone2 nsLeft?) 10)
					(- (cone2 nsTop?) 10)
					(+ (cone2 nsRight?) 10)
					(+ (cone2 nsBottom?) 10)
					disk
				)
			)
			(= theCone1 cone2)
		)
		(
			(and
				local27
				(proc999_4
					(- (cone3 nsLeft?) 10)
					(- (cone3 nsTop?) 10)
					(+ (cone3 nsRight?) 10)
					(+ (cone3 nsBottom?) 10)
					disk
				)
			)
			(= theCone1 cone3)
		)
		(
			(and
				(gOldCast contains: ap)
				(proc999_4
					(- (ap nsLeft?) 15)
					(- (ap nsTop?) 15)
					(+ (ap nsRight?) 15)
					(+ (ap nsBottom?) 15)
					disk
				)
			)
			(= theCone1 ap)
			(if (and (not theTheCone1) (== local26 2))
				(gTestMessager
					say: 10 2 0 (+ (= local34 (mod (++ local34) 8)) 1)
				)
			)
		)
		(
		(not (if (< 5 (gEgo x?)) (< (gEgo x?) 315))) (= theCone1 2) (return -2))
		(
		(not (if (< 5 (gEgo y?)) (< (gEgo y?) 185))) (= theCone1 3) (return -3))
		(else (return -1))
	)
	(if (proc999_5 theCone1 cone1 cone2 cone3)
		(theCone1 setLoop: 0 setCycle: ForwardCounter 3 theCone1)
	)
	(= temp1
		(GetAngle
			(theCone1 x?)
			(theCone1 y?)
			(gEgo x?)
			(gEgo y?)
		)
	)
	(= temp2 (SinMult temp1 500))
	(= temp3 (- (CosMult temp1 500)))
	(= temp4 (SinMult (gEgo heading?) 500))
	(= temp5 (- (CosMult (gEgo heading?) 500)))
	(= temp2 (+ temp2 temp4))
	(= temp3 (+ temp3 temp5))
	(return (= temp1 (GetAngle (gEgo x?) (gEgo y?) temp2 temp3)))
)

(instance rm119 of Rm
	(properties
		noun 2
		picture 25
		style $800a
	)
	
	(method (init)
		(self
			setRegions: 109
			addObstacle:
				((Polygon new:)
					type: 2
					init: 18 15 18 25 9 25 9 15
					yourself:
				)
		)
		(proc958_0 128 129 136 130 139 138 146)
		(proc958_0 132 9 11 133 10 136 137 18)
		(proc0_6 129)
		(gEgo init:)
		(localproc_020a)
		(switch gGModNum
			(117 (gEgo posn: -10 10))
			(else  (gEgo posn: 330 170))
		)
		(super init:)
		(if (== ((gSq5Inv at: 2) owner?) gModNum)
			(cone1 init:)
			(cone2 init:)
			(cone3 init:)
			(= local27 1)
		)
		(if (proc0_1 122)
			(= local26 0)
			(disk init:)
			(if (proc0_1 123)
				(= local26 1)
				(disk setCel: (disk lastCel:))
			)
			(global2
				addObstacle:
					((= newPolygon (Polygon new:))
						type: 2
						init: 88 84 108 84 113 97 113 107 107 112 95 112 86 104 86 96
						yourself:
					)
			)
		)
		(if (not (proc0_1 6)) (p1 init:))
		(gOldWH addToFront: self)
		(self setScript: enterRoom)
	)
	
	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond 
			(script 0)
			(
				(and
					(not (proc999_4 -20 -20 350 210 disk))
					(!= ((gEgo mover?) x?) 160)
					(!= ((gEgo mover?) y?) 90)
				)
				(gEgo setMotion: GravMover 160 90)
			)
			(
				(and
					(!= (= temp0 (localproc_047b)) -1)
					(== local26 2)
				)
				(if (!= theTheCone1 theCone1)
					(= theTheCone1 theCone1)
					(if (< temp0 -1)
						(switch theCone1
							(2 (localproc_03e7 1 0))
							(3 (localproc_03e7 0 0))
						)
					else
						(gEgo setMotion: GravMover temp0)
					)
				)
			)
			((and (== temp0 -1) (== local26 2)) (= theTheCone1 0) (= theCone1 0))
			(
				(and
					(not (proc999_4 30 5 300 185 gEgo))
					(!= local26 2)
				)
				(if
					(and
						(or
							(== ((gSq5Inv at: 1) owner?) gEgo)
							(== ((gSq5Inv at: 1) owner?) gModNum)
						)
						(or
							(== ((gSq5Inv at: 2) owner?) gEgo)
							(== ((gSq5Inv at: 2) owner?) gModNum)
						)
						(not (proc0_1 6))
					)
					(self setScript: bounceBack)
				else
					(if (not (proc0_1 6))
						(starCon setScript: (ScriptID 109 2))
					)
					(self setScript: exitRoom)
				)
			)
		)
	)
	
	(method (dispose)
		(gOldWH delete: self)
		(if (gEgo looper?) ((gEgo looper?) dispose:))
		(ap setMotion: 0)
		(gEgo looper: 0)
		(gEgo setMotion: 0)
		(gEgo setCycle: 0)
		(if (IsObject newPolygon)
			((global2 obstacles?) delete: newPolygon)
			(newPolygon dispose:)
		)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(20
					(if (== local26 2)
						(gTestMessager say: 3 0 3 0)
					else
						(global2 setScript: sSetCones)
					)
				)
				(18
					(if (proc0_1 6)
						(gTestMessager say: 4 0 5 0)
					else
						(self setScript: placeScrubber)
						(return 1)
					)
				)
				(4
					(cond 
						(
							(and
								(not local27)
								(gOldCast contains: disk)
								(== local26 2)
								(> (gEgo distanceTo: ap) 75)
							)
							(global2 setScript: getOffScrubber)
						)
						((and local27 (gOldCast contains: disk)) (gTestMessager say: 5 4 8 0))
						((proc0_1 6) (gTestMessager say: 5 4 5 0))
						(else (gTestMessager say: 5 4 8 0))
					)
				)
				(3
					(if (not theCone1)
						(if (== local26 2)
							(gEgo setMotion: GravMover gPEventX gPEventY)
						else
							(super doVerb: theVerb &rest)
						)
					)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					setLoop: (if (< (gEgo x?) 160) 4 else 1)
					setMotion: MoveTo 150 129 self
				)
			)
			(1
				(gEgo setLoop: -1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(cond 
					((< (gEgo y?) 21) (= gEgoY (- (gEgo y?) 50)))
					((> (gEgo y?) 169) (= gEgoY (+ (gEgo y?) 50)))
					(else (= gEgoY (gEgo y?)))
				)
				(cond 
					((< (gEgo x?) 31) (= gEgoX (- (gEgo x?) 50)))
					((> (gEgo x?) 299) (= gEgoX (+ (gEgo x?) 50)))
					(else (= gEgoX (gEgo x?)))
				)
				(gEgo ignoreHorizon: 1)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo gEgoX gEgoY self)
			)
			(2
				(if (< (gEgo x?) 160)
					(global2 newRoom: 117)
				else
					(global2 newRoom: 115)
				)
			)
		)
	)
)

(instance bounceBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gTestMessager say: 2 0 2 0 self)
			)
			(1
				(= gEgoX (gEgo x?))
				(= gEgoY (gEgo y?))
				(cond 
					((< (gEgo y?) 20) (= gEgoY (+ (gEgo y?) 50)))
					((> (gEgo y?) 180) (= gEgoY (- (gEgo y?) 50)))
				)
				(cond 
					((< (gEgo x?) 31) (= gEgoX (+ (gEgo x?) 50)))
					((> (gEgo x?) 299) (= gEgoX (- (gEgo x?) 50)))
				)
				(= cycles 5)
			)
			(2
				(gEgo setMotion: PolyPath gEgoX gEgoY self)
			)
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance quirkYells of Script
	(properties)
	
	(method (dispose)
		(= theSeconds seconds)
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(starCon setScript: 0)
				(if theSeconds
					(if (not local27)
						(= seconds theSeconds)
					else
						(= seconds (* theSeconds 6))
					)
				)
			)
			(1
				(= seconds 15)
				(= local41 1)
			)
			(2
				(gSq5Music1 fade: 0 10 5 1)
				(gSq5Music2 fade: 0 10 5 1)
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 160 100 self)
			)
			(3
				(if (gEgo looper?)
					((gEgo looper?) dispose:)
					(gEgo looper: 0)
				)
				(gEgo setCycle: 0 setCel: 10)
				(quirk
					init:
					posn: 250 -1
					setCycle: Walk
					setLoop: 0
					setPri: 14
					setMotion: MoveTo 221 96 self
				)
			)
			(4
				(quirk
					view: 132
					loop: 1
					cel: 0
					posn: 219 99
					setCycle: End self
				)
			)
			(5
				(= local28 -1)
				(gTestMessager say: 1 0 1 0 self)
			)
			(6
				(gSq5Music1 number: 18 loop: 1 play: self)
			)
			(7 (global2 newRoom: 195))
		)
	)
)

(instance placeScrubber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo put: 1 gModNum)
				(gEgo setMotion: PolyPath 87 108 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(localproc_023f gEgo 130 6 5 83 114 14)
				(gEgo setCycle: Beg self)
			)
			(3
				(= local26 0)
				(gSq5Music2 number: 416 loop: 1 play:)
				(disk init:)
				(gEgo setCycle: End self)
			)
			(4
				(localproc_020a)
				(proc0_2 122)
				(if (not (IsObject newPolygon))
					(global2
						addObstacle:
							((= newPolygon (Polygon new:))
								type: 2
								init: 88 84 108 84 113 97 113 107 107 112 95 112 86 104 86 96
								yourself:
							)
					)
				)
				(gEgo setPri: 14 posn: 87 108)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance activateScrubber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: PolyPath 87 108 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(localproc_023f gEgo 130 6 5 83 114 14)
				(gEgo setCycle: Beg self)
			)
			(3
				(gSq5Music2 number: 124 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gSq5Music2 number: 127 loop: 1 play:)
				(disk setCycle: End self)
				(localproc_020a)
				(gEgo posn: 87 108)
			)
			(5
				(proc0_2 123)
				(= local26 1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getOnScrubber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				((global2 obstacles?) delete: newPolygon)
				(gEgo setMotion: PolyPath 115 101 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(disk ignoreActors: 1 setPri: 2)
				(localproc_023f gEgo 136 3 0 109 108 14)
				(gEgo setCycle: End self)
			)
			(3
				(p1 stopUpd:)
				(gEgo
					view: 136
					setStep: 5 5
					setPri: 3
					setLoop: 0
					setCycle: SpecialCycler
					cel: 0
					setAvoider: 0
					ignoreActors: 0
					posn: 100 100
				)
				(= local26 2)
				(if (not local32)
					(= local32 1)
					(gTestMessager say: 4 4 6 0 self)
				else
					(= cycles 3)
				)
			)
			(4
				(= next 0)
				(if (not (proc0_1 0))
					(gSQ5 setCursor: 999)
					(switch
						(Print
							font: gFont
							width: 200
							addText: 11 0 0 1 0 0 119
							mode: 1
							addColorButton: 1 11 0 0 2 0 85 119 0 15 23 5 5 5
							addColorButton: 2 11 0 0 3 0 100 119 0 15 23 5 5 5
							init:
						)
						(1
							(proc0_2 6)
							(= next itsClean)
						)
					)
				)
				(= cycles 2)
			)
			(5
				(gSQ5 setCursor: 996)
				(gSq5Music1 number: 9 loop: -1 play:)
				(gSq5Music2 number: 132 loop: -1 play:)
				(gEgo setScript: quirkYells)
				(gEgo setMotion: GravMover 225)
				(if (not next)
					(gSQ5 handsOn:)
					(gSq5IconBar curIcon: (gSq5IconBar at: 0))
					(gSQ5 setCursor: ((gSq5IconBar curIcon?) cursor?))
					(if (not local27) (ap init: 0))
				)
				(self dispose:)
			)
		)
	)
)

(instance getOffScrubber of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client global2) (gSQ5 handsOff:))
				(gSq5Music1 number: 5 loop: -1 play:)
				(gEgo
					setMotion: 0
					setScript: 0
					setLoop: SpecialLooper
					setMotion: MoveTo 115 101 self
				)
			)
			(1
				(gSq5Music2 stop:)
				(= local26 3)
				(disk setCycle: 0)
				(localproc_023f disk 136 2 10 100 100 2)
				(localproc_023f gEgo 136 3 6 109 108 14)
				(gEgo setCycle: Beg self)
			)
			(2
				(if (gEgo looper?) ((gEgo looper?) dispose:))
				(gEgo setCycle: 0)
				(localproc_020a)
				(gEgo posn: 115 101 setMotion: PolyPath 87 108 self)
			)
			(3 (gEgo setHeading: 0 self))
			(4
				(localproc_023f gEgo 130 6 5 83 114 14)
				(gEgo setCycle: Beg self)
			)
			(5
				(gSq5Music2 number: 124 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(gSq5Music2 number: 127 loop: 1 play:)
				(disk setCycle: Beg self)
			)
			(7 (gEgo setCycle: Beg self))
			(8
				(disk dispose:)
				(proc0_3 122)
				(gEgo get: 1 setCycle: End self)
			)
			(9
				(localproc_020a)
				(gEgo posn: 87 108)
				(if (== client global2) (gSQ5 handsOn:))
				(self dispose:)
			)
		)
	)
)

(instance cleanSpot of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& local37 $0002) (p1 startUpd:))
				(if (& local37 $0004) (p2 startUpd:))
				(if (& local37 $0008) (p3 startUpd:))
				(if (& local37 $0010) (p4 startUpd:))
				(= cycles 2)
			)
			(1
				(localproc_02bb)
				(= cycles 2)
			)
			(2
				(p1 stopUpd:)
				(if (localproc_0264)
					(proc0_2 6)
					(global2 setScript: itsClean)
				)
				(= cycles 2)
			)
			(3 (self dispose:))
		)
	)
)

(instance itsClean of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (not local27)
					(quirkYells seconds: 0 state: 1 cue:)
					(= local41 1)
					(self dispose:)
				else
					(p1 dispose:)
					(gSq5Music1 fade: 0 10 5)
					(gEgo
						setLoop: SpecialLooper
						setMotion: PolyPath 218 128 self
					)
				)
			)
			(1
				(proc0_10 165 50)
				(gEgo setHeading: 315)
				(twinkle init:)
				(= seconds 5)
			)
			(2
				(crestFeature init: setOnMeCheck: 1 2 4 8 16)
				(= next sMeetQuirk)
				(self dispose:)
			)
		)
	)
)

(instance dirtyFloor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& local38 $0002) (p1 startUpd:))
				(if (& local38 $0004) (p2 startUpd:))
				(if (& local38 $0008) (p3 startUpd:))
				(if (& local38 $0010) (p4 startUpd:))
				(= cycles 2)
			)
			(1
				(Graph
					grFILL_BOX
					(+ (ap lsTop?) 5)
					(+ (ap lsLeft?) 5)
					(+ (ap lsTop?) 10)
					(+ (ap lsLeft?) 8)
					2
					-1
					1
					-1
				)
				(Graph
					grFILL_BOX
					(- (ap lsBottom?) 10)
					(- (ap lsRight?) 8)
					(- (ap lsBottom?) 5)
					(- (ap lsRight?) 5)
					2
					-1
					1
					-1
				)
				(Graph
					grFILL_BOX
					(+ (ap lsTop?) 3)
					(+ (ap lsLeft?) 7)
					(+ (ap lsTop?) 6)
					(+ (ap lsLeft?) 12)
					2
					-1
					1
					-1
				)
				(Graph
					grFILL_BOX
					(- (ap lsBottom?) 12)
					(- (ap lsRight?) 10)
					(- (ap lsBottom?) 7)
					(- (ap lsRight?) 3)
					2
					-1
					1
					-1
				)
				(= cycles 3)
			)
			(2
				(p1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sSetCones of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setScript: 0)
				(= local27 1)
				(= register cone1)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion: PolyPath (- (register x?) 11) (+ (register y?) 6) self
				)
			)
			(2 (gEgo setHeading: 0 self))
			(3
				(gEgo
					posn: (- (register x?) 15) (+ (register y?) 12)
					view: 130
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(4
				(register init:)
				(gSq5Music2 number: 133 loop: -1 setVol: 64 play:)
				(gEgo loop: 6 cel: 0 setCycle: End self)
			)
			(5
				(localproc_020a)
				(gEgo posn: (- (register x?) 11) (+ (register y?) 6))
				(switch register
					(cone1
						(= register cone2)
						(= state (- state 5))
					)
					(cone2
						(= register cone3)
						(= state (- state 5))
					)
				)
				(= cycles 1)
			)
			(6
				(gEgo setMotion: MoveTo 98 116 self)
			)
			(7
				(gEgo put: 2 gModNum)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMeetQuirk of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setScript: 0)
				(proc958_0 128 132 133 134 132 131)
				(proc958_0 129 26 27)
				(gSq5Music2 fade: 0 10 5 1)
				(ap ignoreActors: 1)
				(p1 dispose:)
				(twinkle dispose:)
				(quirk
					init:
					posn: 250 -1
					setCycle: Walk
					setLoop: 0
					setPri: 14
					setMotion: MoveTo 211 106 self
				)
				(bea
					init:
					posn: 273 4
					setLoop: 0
					setCycle: Walk
					setPri: 14
					setMotion: MoveTo 248 116 self
				)
			)
			(1)
			(2
				(gSq5Music2 stop:)
				(quirk
					view: 132
					loop: 1
					cel: 0
					posn: 209 109
					setCycle: End self
				)
				(bea setCel: 6)
				(gEgo setHeading: 45)
			)
			(3
				(gOldCast eachElementDo: #startUpd)
				(if (gEgo looper?) ((gEgo looper?) dispose:))
				(= cycles 2)
			)
			(4
				(gSq5Music1 number: 10 loop: -1 play:)
				(gOldCast eachElementDo: #hide)
				(global2 drawPic: 26 -32759)
				(localproc_023f quirk 133 0 0 39 81 14)
				(quirk show: addToPic:)
				(localproc_023f bea 133 8 0 200 99 14)
				(bea show: addToPic:)
				(localproc_023f quirkHead 133 1 0 94 38 2)
				(quirkHead init:)
				(localproc_023f extra1 133 6 1 148 87 -1)
				(extra1 init:)
				(localproc_023f extra2 133 7 0 170 125 -1)
				(extra2 init:)
				(localproc_023f beaHead 133 9 1 220 60 -1)
				(beaHead init:)
				(= cycles 10)
			)
			(5
				(gTestMessager say: 6 0 0 1 self)
			)
			(6
				(gTestMessager say: 6 0 0 2 self)
			)
			(7
				(localproc_023f extra1 133 6 0 148 87 -1)
				(extra1 init:)
				(extra2 dispose:)
				(quirkTalker cel: 1)
				(quirkEyes loop: 4 nsLeft: 15 nsTop: 16)
				(quirkMouth loop: 2 nsLeft: 5 nsTop: 24)
				(= cycles 4)
			)
			(8
				(gTestMessager say: 6 0 0 3 self)
			)
			(9
				(localproc_023f quirkHead 133 1 1 94 38 2)
				(quirkHead init:)
				(gTestMessager say: 6 0 0 4 self)
			)
			(10
				(localproc_023f beaHead 133 9 0 220 60 -1)
				(beaHead init:)
				(= seconds 2)
			)
			(11
				(quirkTalker talkWidth: 0)
				(gTestMessager say: 6 0 0 5 self)
			)
			(12
				(quirkTalker talkWidth: 280)
				(beaTalker cel: 0)
				(beaEyes loop: 13 nsLeft: 6 nsTop: 18)
				(beaMouth loop: 11 nsLeft: 7 nsTop: 28)
				(gTestMessager say: 6 0 0 6 self)
			)
			(13
				(gSq5Music1 fade: 0 5 5 1 self)
			)
			(14
				(gSq5Music1 number: 11 loop: -1 play: 0 fade: 127 5 5 0)
				(global2 drawPic: 27 3)
				(localproc_023f bea 134 0 0 82 34 1)
				(bea addToPic:)
				(quirk dispose:)
				(quirkHead dispose:)
				(beaHead dispose:)
				(extra2 dispose:)
				(extra1 dispose:)
				(= seconds 3)
			)
			(15
				(localproc_023f extra1 134 1 0 128 90 14)
				(extra1 init:)
				(extra1 show:)
				(= temp0 0)
				(while (< temp0 4)
					(= [local16 temp0]
						((Prop new:)
							view: 134
							loop: 3
							cel: (Random 0 10)
							signal: 16400
							init:
							setCycle: Fwd
							yourself:
						)
					)
					(++ temp0)
				)
				([local16 0] posn: 223 48)
				([local16 1] posn: 229 101)
				([local16 2] posn: 114 44)
				([local16 3] posn: 102 130)
				(= seconds 2)
			)
			(16
				(extra1 hide:)
				(localproc_023f extra2 134 2 0 144 98 15)
				(extra2 init: setCycle: End self)
			)
			(17 (extra2 setCycle: Beg self))
			(18
				(extra2 dispose:)
				(= seconds 2)
			)
			(19
				(extra1 show:)
				(= temp0 4)
				(while (< temp0 8)
					(= [local16 temp0]
						((Prop new:)
							view: 134
							loop: 3
							cel: (Random 0 10)
							signal: 16400
							init:
							setCycle: Fwd
							yourself:
						)
					)
					(++ temp0)
				)
				([local16 4] posn: 202 134)
				([local16 5] posn: 232 113)
				([local16 6] posn: 93 87)
				([local16 7] posn: 80 112)
				(= seconds 2)
			)
			(20
				(extra1 hide:)
				(= temp0 8)
				(while (< temp0 10)
					(= [local16 temp0]
						((Prop new:)
							view: 134
							loop: 3
							cel: (Random 0 10)
							signal: 16400
							init:
							setCycle: Fwd
							yourself:
						)
					)
					(++ temp0)
				)
				([local16 8] posn: 241 68)
				([local16 9] posn: 84 64)
				(= seconds 2)
			)
			(21
				(extra1 dispose:)
				(= cycles 3)
			)
			(22
				(gTestMessager say: 6 0 0 7 self)
			)
			(23
				(gTestMessager say: 6 0 0 8 self)
			)
			(24
				(gTestMessager say: 6 0 0 9 self)
			)
			(25
				(gSq5Music1 fade: 0 10 5 1 self)
			)
			(26
				(= temp0 0)
				(while (< temp0 10)
					([local16 temp0] dispose:)
					(++ temp0)
				)
				(bea dispose:)
				(= cycles 1)
			)
			(27
				(gSq5Music1 number: 10 loop: -1 play:)
				(global2 drawPic: 26 9)
				(localproc_023f quirk 133 0 0 39 81 -1)
				(quirk addToPic:)
				(localproc_023f bea 133 8 0 200 99 -1)
				(bea addToPic:)
				(localproc_023f quirkHead 133 1 0 94 38 2)
				(quirkHead init:)
				(localproc_023f extra1 133 6 1 148 87 -1)
				(extra1 init:)
				(localproc_023f extra2 133 7 0 170 125 -1)
				(extra2 init:)
				(localproc_023f beaHead 133 9 1 220 60 -1)
				(beaHead init:)
				(= seconds 2)
			)
			(28
				(gTestMessager say: 6 0 0 10 self)
			)
			(29
				(gTestMessager say: 6 0 0 11 self)
			)
			(30
				(extra1 setCel: 1)
				(extra2 setCel: 1)
				(quirkTalker talkWidth: 0)
				(gTestMessager say: 6 0 0 12 self)
			)
			(31 (= seconds 3))
			(32
				(quirkHead dispose:)
				(beaHead dispose:)
				(extra1 dispose:)
				(extra2 dispose:)
				(global2 drawPic: 27 3)
				(localproc_023f quirk 134 4 0 97 62 -1)
				(quirk addToPic:)
				(= local28 1)
				(quirkTalker loop: 14 x: 146 y: 119)
				(quirkEyes loop: 14 nsLeft: 0 nsRight: 0)
				(quirkMouth view: 134 loop: 5 nsLeft: 0 nsTop: 0)
				(= seconds 2)
			)
			(33
				(gTestMessager say: 6 0 0 13 self)
			)
			(34
				(gTestMessager say: 6 0 0 14 self)
			)
			(35
				(gTestMessager say: 6 0 0 18 self)
			)
			(36
				(quirkTalker talkWidth: 280)
				(global2 drawPic: 25 -32761)
				(cone1 show:)
				(cone2 show:)
				(cone3 show:)
				(gEgo show:)
				(disk show:)
				(localproc_023f quirk 132 2 0 209 109 15)
				(quirk signal: 16400 init:)
				(localproc_023f bea 131 0 6 248 116 15)
				(bea signal: 16400 init:)
				(= seconds 2)
			)
			(37
				(gSq5Music1 stop:)
				(gSq5Music2 number: 152 loop: 1 play:)
				(quirk setCycle: End self)
			)
			(38
				(gSq5Music2 number: 136 loop: 1 play: self)
			)
			(39
				(gSq5Music1 number: 12 loop: -1 play:)
				(gOldCast eachElementDo: #hide)
				(global2 drawPic: 26 -32761)
				(localproc_023f quirk 135 1 0 263 88 -1)
				(quirk addToPic:)
				(localproc_023f bea 135 0 0 67 159 -1)
				(bea addToPic:)
				(localproc_023f extra1 135 4 0 228 142 -1)
				(extra1 init: ignoreActors: 1 setLoop: 4)
				(localproc_023f extra2 135 2 0 263 88 -1)
				(extra2 init: ignoreActors: 1 setLoop: 2)
				(localproc_023f extra3 135 3 0 262 94 -1)
				(extra3 init: ignoreActors: 1 setLoop: 3)
				(beaHead dispose:)
				(quirkHead dispose:)
				(= local28 2)
				(= seconds 2)
			)
			(40
				(rogTalker talkWidth: 90)
				(gTestMessager say: 6 0 0 19 self)
			)
			(41
				(gTestMessager say: 6 0 0 15 self)
			)
			(42
				(rogTalker talkWidth: 180)
				(extra1 setCycle: End self)
				(extra3 setCycle: End self)
			)
			(43)
			(44
				(extra1 stopUpd:)
				(extra3 dispose:)
				(extra2 setCycle: End self)
			)
			(45
				(extra2 stopUpd:)
				(quirkTalker view: 135 loop: 6 cel: 0 x: 225 y: 130)
				(quirkEyes view: 135 loop: 6 nsLeft: 0 nsTop: 0)
				(quirkMouth view: 135 loop: 5 nsLeft: -11 nsTop: -11)
				(= cycles 4)
			)
			(46
				(gTestMessager say: 6 0 0 16 self)
			)
			(47
				(gTestMessager say: 6 0 0 17 self)
			)
			(48
				(gSq5Music1 number: 10 loop: -1 play:)
				(global2 drawPic: 25 -32761)
				(localproc_023f bea 131 1 0 246 110 15)
				(bea show: signal: 16400 init:)
				(localproc_023f quirk 132 3 0 207 91 15)
				(quirk show: signal: 16400 init:)
				(extra1 dispose:)
				(extra2 dispose:)
				(extra3 dispose:)
				(beaHead dispose:)
				(quirkHead dispose:)
				(cone1 show:)
				(cone2 show:)
				(cone3 show:)
				(gEgo show:)
				(disk show:)
				(= cycles 2)
			)
			(49 (bea setCycle: End self))
			(50
				(bea
					setLoop: 2
					cel: 0
					setCycle: Walk
					ignoreHorizon: 1
					setMotion: MoveTo 150 4
				)
				(gSq5Music2 number: 132 loop: -1 play:)
				(quirk posn: 207 91 setCycle: End self)
				(gSq5Music1 fade: 0 10 5 1)
			)
			(51 (= seconds 1))
			(52
				(quirk
					setLoop: 4
					cel: 0
					posn: 207 91
					setCycle: Walk
					ignoreHorizon: 1
					setMotion: MoveTo 97 -10 self
				)
			)
			(53
				(gSq5Music1 number: 5 loop: -1 play: 0 fade: 127 10 5 0)
				(bea hide:)
				(quirk hide:)
				(= cycles 2)
			)
			(54
				(bea dispose: delete:)
				(gOldCast eachElementDo: #stopUpd)
				(gEgo startUpd:)
				(quirk dispose: delete:)
				(self setScript: getOffScrubber self)
			)
			(55
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance disk of Prop
	(properties
		x 100
		y 100
		noun 4
		view 136
		loop 2
		priority 2
		signal $0810
		cycleSpeed 1
	)
	
	(method (doit)
		(if (== local26 2)
			(self setLoop: 1 x: (gEgo x?) y: (gEgo y?))
			(if (not cycler) (self setCycle: Fwd))
			(if
				(and
					(not (proc0_1 6))
					(&
						(= local37 (OnControl 4 nsLeft nsTop nsRight nsBottom))
						$001e
					)
					(& (OnControl 2 nsLeft nsTop nsRight nsBottom) $0002)
					(not script)
					(not (quirkYells state?))
				)
				(self setScript: cleanSpot)
			)
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(switch local26
					(0
						(global2 setScript: activateScrubber)
					)
					(1
						(global2 setScript: getOnScrubber)
					)
					(2
						(cond 
							(local27 (gTestMessager say: 4 4 7 0 self))
							((>= (gEgo distanceTo: ap) 75) (global2 setScript: getOffScrubber))
							(else (super doVerb: theVerb &rest))
						)
					)
				)
			)
			(1
				(switch local26
					(0
						(gTestMessager say: noun 1 10 0)
					)
					(1
						(gTestMessager say: noun 1 11 0)
					)
					(else 
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class CrestPiece of View
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 5
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
		view 139
		loop 0
		cel 0
		priority 1
		underBits 0
		signal $5010
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
		case 8
	)
	
	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((pEvent claimed?) (return 1))
				(
					(and
						(& (pEvent type?) evVERB)
						(self onMe: pEvent)
						(self isNotHidden:)
						(proc999_5 (pEvent message?) 18 4)
					)
					(self doVerb: (pEvent message?))
					(return 1)
				)
				(else (super handleEvent: pEvent))
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(crestFeature doVerb: theVerb)
			)
			(1
				(gTestMessager say: noun theVerb case 0)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)

(instance p1 of CrestPiece
	(properties
		x 71
		y 18
	)
	
	(method (init)
		(super init: &rest)
		(p2 init:)
		(p3 init:)
		(p4 init:)
	)
	
	(method (dispose)
		(p2 dispose:)
		(p3 dispose:)
		(p4 dispose:)
		(super dispose: &rest)
	)
	
	(method (stopUpd)
		(p2 stopUpd:)
		(p3 stopUpd:)
		(p4 stopUpd:)
		(super stopUpd:)
	)
)

(instance p2 of CrestPiece
	(properties
		x 84
		y 57
		cel 1
	)
)

(instance p3 of CrestPiece
	(properties
		x 171
		y 57
		cel 2
	)
)

(instance p4 of CrestPiece
	(properties
		x 100
		y 107
		cel 3
	)
)

(class MyCones of Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 3
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
		view 138
		loop 0
		cel 0
		priority 2
		underBits 0
		signal $4010
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
		(super init: &rest)
		(if (== ((gSq5Inv at: 2) owner?) gModNum)
			(self cue:)
		else
			(self setCycle: ForwardCounter 1 self)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_1 6)
					(gTestMessager say: noun theVerb 4 0)
				else
					(gTestMessager say: noun theVerb 1 0)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self setLoop: 1 cel: 0 stopUpd:)
		(if (!= (gEgo view?) 136) (gSq5Music2 stop:))
	)
)

(instance cone1 of MyCones
	(properties
		x 58
		y 23
	)
	
	(method (init)
		(super init: &rest)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 69 14 69 34 47 34 47 14
					yourself:
				)
		)
	)
)

(instance cone2 of MyCones
	(properties
		x 264
		y 67
	)
	
	(method (init)
		(super init: &rest)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 250 58 276 58 276 79 250 79
					yourself:
				)
		)
	)
)

(instance cone3 of MyCones
	(properties
		x 144
		y 154
	)
	
	(method (init)
		(super init: &rest)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 128 146 158 146 158 165 128 165
					yourself:
				)
		)
	)
)

(instance twinkle of Prop
	(properties
		view 138
		loop 3
		priority 10
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(self
			cel: 0
			posn: (Random 72 253) (Random 19 100)
			setCycle: End self
		)
	)
	
	(method (cue)
		(self init:)
	)
)

(instance extra1 of Actor
	(properties
		view 134
	)
)

(instance extra2 of Actor
	(properties
		view 134
	)
)

(instance extra3 of Actor
	(properties
		view 134
	)
)

(instance quirkHead of Prop
	(properties
		view 133
	)
)

(instance beaHead of Prop
	(properties
		view 133
	)
)

(instance bea of Actor
	(properties
		view 131
	)
)

(instance quirk of Actor
	(properties
		view 132
	)
)

(instance ap of Actor
	(properties
		view 146
		priority 14
		signal $2010
	)
	
	(method (init param1 &tmp temp0 temp1)
		(super init: &rest)
		(self baseSetter: myBaseSetter)
		(= temp0 param1)
		(self setLoop: param1 setCycle: Walk)
		(if loop (= noun 8) else (= noun 7))
		(= param1 (* param1 13))
		(if local27
			(= param1 (+ param1 (* (Random 0 1) 4)))
			(self
				posn: [local43 param1] [local43 (+ param1 1)]
				setMotion: PolyPath [local43 (+ param1 2)] [local43 (+ param1 3)] self
			)
		else
			(= param1 (+ param1 8))
			(= temp1
				(Random [local43 param1] [local43 (+ param1 1)])
			)
			(if (< temp0 2)
				(self posn: -22 temp1 setMotion: PolyPath 320 temp1 self)
			else
				(self
					posn: temp1 [local43 (+ param1 3)]
					setMotion:
						PolyPath
						(+ temp1 [local43 (+ param1 2)])
						[local43 (+ param1 4)]
						self
				)
			)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not local27)
				(not script)
				(& (OnControl 2 x y) $0004)
			)
			(= local38 (OnControl 4 nsLeft nsTop nsRight nsBottom))
			(self setScript: dirtyFloor)
		)
	)
	
	(method (cue)
		(if
			(or
				(== (gEgo view?) 129)
				(== (global2 script?) sMeetQuirk)
				(gOldCast contains: quirk)
				local41
			)
			(self dispose:)
		else
			(self init: (= local39 (mod (++ local39) 8)))
		)
	)
)

(instance quirkMouth of Prop
	(properties
		nsTop 25
		view 133
		loop 3
		signal $4000
	)
)

(instance quirkEyes of Prop
	(properties
		nsTop 15
		nsLeft 5
		view 133
		loop 5
		signal $4000
	)
)

(instance quirkTalker of Talker
	(properties
		x 94
		y 38
		view 133
		loop 1
		talkWidth 280
		textX -70
		textY -30
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(switch local28
			(1
				(gSq5Win tailX: 92 tailY: 64 xOffset: -3 isBottom: 1)
			)
			(0
				(gSq5Win
					tailX: 132
					tailY: (proc0_12 38 38 38 38 35)
					xOffset: 40
					isBottom: 1
				)
			)
			(2
				(self talkWidth: 200 textX: -40)
				(gSq5Win
					tailX: 160
					tailY: (proc0_12 80 80 80 80 65)
					xOffset: -30
					isBottom: 1
				)
			)
			(-1
				(self loop: 4 cel: 1 talkWidth: 100)
				(gSq5Win
					tailX: (quirk x?)
					tailY: (- (quirk y?) 40)
					xOffset: 0
				)
			)
		)
		(if (>= local28 0)
			(super init: 0 quirkEyes quirkMouth &rest)
		else
			(super init: 0 &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 24
		nsLeft 2
		view 133
		loop 10
		signal $4000
	)
)

(instance beaEyes of Prop
	(properties
		nsTop 13
		view 133
		loop 15
		signal $4000
	)
)

(instance beaTalker of Talker
	(properties
		x 220
		y 60
		view 133
		loop 9
		cel 1
		talkWidth 200
		textX -160
		textY -40
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(if (== local28 2)
			(gSq5Win tailX: 100 tailY: 40 xOffset: 30 isBottom: 1)
			(self cel: 0 loop: 14 talkWidth: 0)
			(super init: 0 0 0 &rest)
		else
			(gSq5Win tailX: 210 tailY: 55 xOffset: -60 isBottom: 1)
			(= talkWidth 200)
			(super init: 0 beaEyes beaMouth &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance rogTalker of Narrator
	(properties
		x 20
		y 160
		talkWidth 180
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(if (== (global2 script?) sMeetQuirk)
			(gSq5Win tailX: 110 tailY: 170 xOffset: 0 isBottom: 1)
		else
			(gSq5Win
				tailX: (gEgo x?)
				tailY: (+ (gEgo y?) 15)
				xOffset: 0
				isBottom: 0
			)
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance quirkTalker2 of Narrator
	(properties
		talkWidth 100
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gNewSpeakWindow)
		(gSq5Win
			tailX: (- (quirk x?) 50)
			xOffset: -20
			tailY: (quirk y?)
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance genTalker of Narrator
	(properties
		talkWidth 100
	)
	
	(method (init)
		(= font gFont)
		(= gSq5Win gSq5Win_2)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance myBaseSetter of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (- (param1 nsBottom?) (param1 nsTop?)))
		(= temp1 (- (param1 nsRight?) (param1 nsLeft?)))
		(= temp2 (- (param1 x?) (/ temp1 2)))
		(= temp3 (- (param1 y?) (/ temp0 2)))
		(param1
			brLeft: temp2
			brRight: (+ temp2 temp1)
			brTop: temp3
			brBottom: (+ temp3 temp0)
		)
	)
)

(instance crestFeature of Feature
	(properties
		x 160
		y 100
		noun 5
		onMeCheck $001e
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (proc0_1 6)
					(gTestMessager say: noun theVerb 5 0)
				else
					(global2 doVerb: theVerb &rest)
				)
			)
			(1
				(if (proc0_1 6)
					(gTestMessager say: noun theVerb 5 0)
				else
					(gTestMessager say: noun theVerb (p1 case?) 0)
				)
			)
			(else 
				(global2 doVerb: theVerb &rest)
			)
		)
	)
)
