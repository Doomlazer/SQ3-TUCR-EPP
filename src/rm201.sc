;;; Sierra Script 1.0 - (do not remove this comment)
(script# 201)
(include sci.sh)
(use Main)
(use AnimDialog)
(use sStopEggTimer)
(use eureka)
(use Class_255_0)
(use Blink)
(use CueObj)
(use MoveFwd)
(use n958)
(use ScaleTo)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm201 0
	sFlashRed 1
	flo 2
	floArm 3
	sBusyFlo 4
	proc201_5 5
	proc201_6 6
	proc201_7 7
	sTurnDrooleBack 8
	bigPlanet 9
	drooleTalker 12
	floTalker 13
	rogTalker 15
	proc201_20 20
	proc201_21 21
	proc201_22 22
	sAbandonShip 23
	droole 24
	ViewScreen 25
	proc201_27 27
	proc201_33 33
	drooleArm 34
	sFlashWhite 35
	sInToOrbit 36
	sOutOfOrbit 37
	sTurnAround 38
	sBigPlanet 39
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14 =  -1
	[local15 26] = [0 0 0 0 0 0 0 0 0 0 {Nowhere} {garbage1} {garbage2} {ku} {spacebar} {clorox2} {thrakus} {genetix Space Lab} {genetix environdome} {generic planet 1} {generic planet 2} {generic planet 3} {generic planet 4} {generic planet 5} {goliath} {empty space!}]
	[local41 16] = [212 212 213 221 222 223 224 225 226 214 216 214 216 2243 2272 220]
	[local57 16] = [0 0 0 0 0 0 0 0 0 0 0 214 216 0 413]
	local73 =  1
	local74 =  1
)
(procedure (proc201_5 param1)
	(= local73 param1)
)

(procedure (proc201_6 param1)
	(flo setLoop: 1 setCycle: End (if argc param1 else 0))
	(floArm hide:)
	(gEgo setLoop: 1 setCel: 0 posn: 178 95 show:)
)

(procedure (proc201_7 param1)
	(drooleArm setScript: 0 hide:)
	(droole setLoop: 1 setCycle: End (if argc param1 else 0))
	(drooleHand hide:)
)

(procedure (proc201_20)
	(return local12)
)

(procedure (proc201_21)
	(= local12 0)
)

(procedure (proc201_22)
	(return local13)
)

(procedure (proc201_27 param1)
	(= local74 param1)
)

(procedure (proc201_33)
	(= local13 0)
)

(procedure (localproc_0544)
	(if (proc0_1 84) ((ScriptID 202 2) init:) (proc204_1))
)

(procedure (localproc_055f &tmp temp0 temp1 temp2 temp3 [temp4 6])
	(= temp1 0)
	(= temp0 0)
	(while (< temp0 14)
		(= temp3 1)
		(= temp2 0)
		(while (< temp2 5)
			(if
				(!=
					(StrAt @local15 temp2)
					(StrAt
						{00000 71552 92767 20011 69869 90210 53284 41666 41666 91001 01015 44091 81100 54671}
						(+ temp1 temp2)
					)
				)
				(= temp3 0)
				(break)
			)
			(++ temp2)
		)
		(if temp3 (return (if (<= temp0 13) temp0 else 15)))
		(= temp1 (+ temp1 6))
		(++ temp0)
	)
	(return 15)
)

(procedure (localproc_05f7)
	(cond 
		((proc0_1 84)
			(if (!= (gSq5Music1 number?) 42)
				(gSq5Music1 number: 42 loop: -1 play: 127)
			)
		)
		((proc0_1 61)
			(if (!= (gSq5Music1 number?) 20)
				(gSq5Music1 number: 20 loop: -1 play: 127)
			)
		)
		((or (proc0_1 42) (== (eureka puke?) 2))
			(if (!= (gSq5Music1 number?) 38)
				(gSq5Music1 number: 38 loop: -1 play: 127)
			)
		)
		((!= (gSq5Music1 number?) 101) (gSq5Music1 number: 101 loop: -1 play: 75))
		(else (gSq5Music1 pause: 0))
	)
)

(procedure (localproc_06b3)
	(if (or (proc0_1 84) (>= (eureka puke?) 4))
	else
		(gSq5Music2 number: 206 loop: -1 play:)
	)
)

(procedure (localproc_0fd7 &tmp temp0 temp1)
	(= temp0 0)
	(while (< temp0 (gOldCast size?))
		(= temp1 (gOldCast at: temp0))
		(if (temp1 isKindOf: Actor) (temp1 cue:))
		(++ temp0)
	)
)

(procedure (localproc_1011)
	(return local73)
)

(procedure (localproc_1019)
	(return local74)
)

(procedure (localproc_1021 &tmp temp0 temp1)
	(= temp1 4)
	(= temp0 1)
	(while (< temp0 temp1)
		((fastStar new:) init:)
		((mediumStar new:) init:)
		((slowStar new:) init:)
		(++ temp0)
	)
	(fastStar init:)
	(mediumStar init:)
	(slowStar init:)
)

(procedure (localproc_1077)
	(if (!= gEurekaCurLocation 0)
		(if (proc0_1 32) (= local10 0) else (= local10 1))
		(localproc_1021)
	)
)

(instance rm201 of Rm
	(properties
		noun 32
		picture 41
		style $000a
	)
	
	(method (init &tmp temp0)
		(global2 setRegions: 210)
		(proc958_0 143 201 205 202)
		(proc958_0 128 98 217 202 203 992 200)
		(super init: &rest)
		(global2 setScript: sInitRoom)
	)
	
	(method (doit)
		(cond 
			(script)
			((eureka timer?) (self setScript: sHandleTimer))
			((and (proc0_1 84) (not (proc0_1 86))) (proc0_2 85) (global2 setScript: sAbandonShip))
		)
		(super doit:)
	)
	
	(method (dispose)
		(gOldWH delete: bridge)
		(theMusic3 dispose:)
		(if (not (proc999_5 gNewRoomNumber 200 222))
			(gSq5Music2 fade:)
			(if (not (proc999_5 gNewRoomNumber 212 213))
				(gSq5Music1 fade:)
			)
		)
		(DisposeScript 202)
		(DisposeScript 204)
		(DisposeScript 207)
		(DisposeScript 208)
		(DisposeScript 209)
		(DisposeScript 211)
		(DisposeScript 214)
		(DisposeScript 216)
		(DisposeScript 217)
		(DisposeScript 218)
		(DisposeScript 219)
		(DisposeScript 220)
		(DisposeScript 221)
		(DisposeScript 232)
		(DisposeScript 233)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(if
			(and
				(gOldCast contains: (ScriptID 204 4))
				(not (proc0_1 84))
			)
			(global2 setScript: (ScriptID 204 5))
		else
			(super doVerb: theVerb)
		)
	)
	
	(method (notify param1 param2 param3 param4 param5 param6 &tmp eurekaDestination)
		(gSQ5 handsOff:)
		(switch param1
			(1
				(Format
					@local15
					201
					0
					(+ param2 48)
					(+ param3 48)
					(+ param4 48)
					(+ param5 48)
					(+ param6 48)
				)
				(= eurekaDestination 0)
				(if (eureka destination?)
					(= eurekaDestination (eureka destination?))
				)
				(= local14 (localproc_055f))
				(eureka destination: local14)
				(cond 
					((== (eureka destination?) 0) (eureka destination: 0))
					(
					(and (== (eureka destination?) 7) (== global142 2)) (eureka destination: 8))
				)
				(cond 
					(
					(== (eureka destination?) (eureka curLocation?))
					(switch (eureka state?)
						(3 (eureka destination: 0))
					))
					(
					(and (== (eureka destination?) 4) (proc0_1 30))
						(gTestMessager say: 23 0 43 1)
						(if eurekaDestination
							(eureka destination: eurekaDestination)
							(= param1 -1)
						else
							(eureka destination: 0)
							(eureka warnings: 0 timer: 0 setScript: 0)
						)
					)
					((proc0_1 32)
						(eureka warnings: 0 timer: 0 state: 1 setScript: 0)
						(eureka
							setScript:
								(if
								(and (== (eureka destination?) 3) (not (proc0_1 9)))
									(ScriptID 210 6)
								else
									(ScriptID 210 4)
								)
								0
								30
						)
					)
					(else
						(eureka timer: 0 warnings: 0 setScript: 0)
						(if (== (eureka state?) 2) (eureka state: 1))
						(eureka setScript: (ScriptID 210 2) 0 30)
					)
				)
				(eureka warnings: 0)
			)
		)
		(= local13 param1)
		(switch (eureka state?)
			(0
				((ScriptID 214 3) stopUpd:)
				((ScriptID 214 2) stopUpd:)
			)
		)
		(droole stopUpd:)
	)
)

(instance sInitRoom of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(bridge init:)
				(buttonPanel init:)
				(gEgo
					view: 200
					init:
					loop: 0
					cel: 0
					posn: 132 95
					setScale: 0
					setPri: 12
					hide:
				)
				(localproc_0544)
				(switch gGModNum
					(107
						(eureka
							timer: 0
							setScript:
								(if
								(and (== (eureka destination?) 3) (not (proc0_1 9)))
									(ScriptID 210 6)
								else
									(ScriptID 210 4)
								)
								0
								30
						)
						(gSQ5 handsOn:)
					)
					(200
						(if
							(and
								(== gEurekaCurLocation 3)
								(proc0_1 9)
								(proc0_1 61)
							)
							(proc0_3 61)
						)
						(cond 
							(
								(and
									(== global142 1)
									(proc0_1 45)
									(not (proc0_1 86))
									(== gEurekaCurLocation 6)
								)
								(if (== global164 1)
									(proc0_2 42)
									(eureka setScript: 0)
									(eureka setScript: (ScriptID 210 1) 0 3)
								else
									(= next (ScriptID 233 3))
								)
							)
							(
							(and (proc0_1 76) (== global142 0) (not (proc0_1 97))) (= next (ScriptID 211 1)) (= global142 1))
							(
								(and
									(== gEurekaCurLocation 8)
									(proc0_1 75)
									(< global164 8)
								)
								(= next (ScriptID 233 3))
							)
							(
								(and
									(== gEurekaCurLocation 14)
									(not (proc0_1 86))
									(== (eureka puke?) 1)
								)
								(eureka setScript: (ScriptID 210 5) 0 1)
							)
							(
							(and (== (eureka garbage?) 1) (not (proc0_1 86))) (= next (ScriptID 232 25)))
							(
								(and
									(not (proc0_1 86))
									(or (not (proc0_1 56)) (proc0_1 113) (proc0_1 114))
									(> global126 1)
								)
								(= next (ScriptID 232 24))
							)
							(else (gSQ5 handsOn:))
						)
					)
					(206
						((ScriptID 209 2) init: view: 218 setLoop: 0 cel: 0)
						(= next (ScriptID 232 4))
					)
					(212
						(gSQ5 handsOn:)
						(eureka puke: 2)
					)
					(213
						(gSQ5 handsOn:)
						(eureka puke: 3)
					)
					(222
						(gSQ5 handsOn:)
						(if (== gEurekaCurLocation 6)
							(eureka setScript: 0)
							(eureka setScript: (ScriptID 210 1) 0 10)
						else
							(= next (ScriptID 221 6))
						)
					)
					(280
						(++ global127)
						(switch (eureka curLocation?)
							(1 (= next (ScriptID 232 7)))
							(2 (= next (ScriptID 232 5)))
						)
					)
					(290
						(++ global127)
						(switch (eureka curLocation?)
							(1 (= next (ScriptID 232 7)))
							(2 (= next (ScriptID 232 5)))
							(else  (gSQ5 handsOn:))
						)
					)
					(215 (gSQ5 handsOn:))
					(550
						(= gEurekaCurLocation 16)
						(= local10 1)
						(eureka state: 1 prevLocation: 4 curLocation: 0)
						(proc0_2 30)
						(proc0_2 56)
						(proc0_2 35)
						(proc0_2 36)
						(proc0_2 9)
						(proc0_2 60)
						(proc0_3 32)
						(proc0_3 86)
						(= global170 2)
						(= global130 1)
						(= global126 6)
						(= next (ScriptID 233 8))
					)
					(else 
						(gSQ5 handsOn:)
						(if
							(>=
								(= temp0
									(proc255_1
										{Eureka State: \n\n\n(0) starcon \n(1) regular speed \n(2) chasing goliath \n(3) wd40 attacks \n(4) garbage pickup \n(5) distress call \n(6) goliath blobbed \n(7) approach space bar \n(8) cliffy lost in space \n(9) goliath attacks\n}
									)
								)
								0
							)
							(= local0 temp0)
						else
							(= local0 0)
						)
						(switch local0
							(0
								(= gEurekaCurLocation 0)
								(= global130 1)
								(eureka state: 0)
							)
							(1
								(gSQ5 handsOn:)
								(= gEurekaCurLocation 16)
								(= global130 1)
								(eureka state: 1)
								(= local10 1)
								(proc0_3 32)
							)
							(2
								(eureka
									warnings: 0
									state: 1
									destination: 12
									setScript: (ScriptID 210 4) 0 5
								)
								(= gEurekaCurLocation 17)
								(= local10 0)
								(= global130 1)
								(= global164 8)
								(= global170 2)
								(= global142 2)
								(= local10 0)
								(proc0_2 32)
								(proc0_2 33)
								(proc0_2 94)
								(proc0_2 93)
								(proc0_2 87)
								(proc0_2 89)
								(proc0_2 75)
								(proc0_2 30)
								(proc0_3 42)
								(proc0_2 45)
							)
							(3
								(= gEurekaCurLocation 17)
								(= global130 1)
								(proc0_2 32)
								(eureka state: 1)
								(= local10 0)
								(eureka
									warnings: 0
									destination: 3
									setScript: (ScriptID 210 6) 0 10
								)
							)
							(4
								(= gEurekaCurLocation 17)
								(proc0_2 32)
								(= local10 0)
								(= global127 0)
								(proc0_3 35)
								(= global130 1)
								(proc0_3 36)
								(eureka
									warnings: 0
									state: 1
									destination: 1
									setScript: (ScriptID 210 4) 0 5
								)
								(proc0_3 30)
							)
							(5
								(= gEurekaCurLocation 5)
								(= global170 2)
								(proc0_2 76)
								(proc0_2 30)
								(proc0_2 9)
								(proc0_2 93)
								(= global130 1)
								(= global142 0)
								(eureka state: 3 destination: 0 curLocation: 5)
								(= local10 1)
								(= global127 3)
								(localproc_1021)
							)
							(6
								(= gEurekaCurLocation 14)
								(= global142 2)
								(= global170 2)
								(proc0_2 60)
								(proc0_2 30)
								(proc0_2 76)
								(proc0_2 9)
								(proc0_2 93)
								(proc0_2 56)
								(proc0_3 32)
								(eureka
									state: 3
									curLocation: 14
									puke: 1
									destination: 0
									setScript: (ScriptID 210 5) 0 1
								)
							)
							(7
								(= global130 1)
								(= global126 4)
								(= gEurekaCurLocation 17)
								(= local10 0)
								(= global127 3)
								(proc0_2 32)
								(proc0_2 35)
								(proc0_2 36)
								(proc0_2 56)
								(proc0_3 30)
								(eureka
									warnings: 0
									state: 1
									destination: 4
									setScript: (ScriptID 210 4) 0 10
								)
							)
							(8
								(eureka
									state: 3
									warnings: 0
									timer: 0
									destination: 0
									curLocation: 15
									setScript: 0
								)
								(proc0_2 33)
								(proc0_2 94)
								(proc0_2 93)
								(proc0_3 87)
								(proc0_2 89)
								(proc0_3 75)
								(proc0_2 30)
								(proc0_2 45)
								(proc0_3 42)
								(proc0_3 32)
								(= global170 2)
								(= global130 1)
								(= gEurekaCurLocation 15)
								(= global142 2)
								(= global164 1)
								(= next (ScriptID 221 6))
							)
							(9
								(= gEurekaCurLocation 6)
								(= global170 2)
								(= global142 1)
								(eureka
									state: 3
									warnings: 0
									timer: 0
									destination: 0
									curLocation: 6
									setScript: 0
								)
								(proc0_2 42)
								(eureka setScript: (ScriptID 210 1) 0 5)
								(proc0_2 33)
								(proc0_2 94)
								(proc0_2 93)
								(proc0_2 76)
								(proc0_2 63)
								(proc0_2 30)
								(proc0_2 45)
								(= global130 1)
								(= global164 1)
								(proc0_3 32)
							)
							(else 
								(= gEurekaCurLocation 16)
								(eureka state: 1)
								(proc0_3 32)
							)
						)
					)
				)
				(localproc_1077)
				(flo init:)
				(droole init:)
				(bigPlanet init:)
				(ViewScreen init: setOnMeCheck: 1 2)
				(vid1Monitor init:)
				(vid2Monitor init:)
				(vid3Monitor init:)
				(capChair init:)
				(dConsole init:)
				(fConsole init:)
				(gOldWH addToFront: bridge)
				(gUser canControl: 0)
				(if (or (>= (eureka puke?) 4) (proc0_1 84))
					((ScriptID 202 13) init:)
					((ScriptID 202 14) init:)
					((ScriptID 202 15) init:)
				)
				(= cycles 1)
			)
			(1
				(localproc_05f7)
				(localproc_06b3)
				(= cycles 1)
			)
			(2 (self dispose:))
		)
	)
)

(instance sTurnDrooleBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (droole setCycle: Beg self))
			(1
				(drooleArm show: setScript: sDrooleArm)
				(droole setLoop: 0 setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(2 (self dispose:))
		)
	)
)

(instance sAbandonShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc0_1 84) (= seconds 8) else (= seconds 1))
				(gSQ5 handsOff:)
			)
			(1
				(global2 newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance sHandleTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if
					(or
						(== (eureka timer?) 3)
						(proc0_1 86)
						(and (== (eureka timer?) 6) (== (eureka warnings?) 1))
						(and (proc0_1 37) (proc0_1 39))
						(and
							(== (eureka timer?) 5)
							(or
								(== gEurekaCurLocation 14)
								(> (eureka warnings?) 1)
							)
						)
						(== global126 1)
						(and
							(== (eureka destination?) 32)
							(>= global127 3)
							(not (proc0_1 56))
						)
					)
					(= cycles 4)
				else
					(proc201_7 self)
				)
			)
			(1
				(eureka warnings: (+ (eureka warnings?) 1))
				(switch (eureka timer?)
					(1
						(gTestMessager say: 11 0 17 (eureka warnings?) self)
						(if (== (eureka warnings?) 3) (eureka warnings: 0))
						(eureka setScript: 0)
						(eureka setScript: (ScriptID 210 2) 0 30)
					)
					(2
						(cond 
							(
								(or
									(== global126 1)
									(and
										(== (eureka destination?) 4)
										(>= global127 3)
										(not (proc0_1 56))
									)
								)
								(= next (ScriptID 232 9))
								(self dispose:)
							)
							((< (eureka warnings?) 3)
								(proc0_2 60)
								(eureka state: 2)
								(eureka setScript: (ScriptID 210 4) 0 30)
								(gTestMessager say: 11 0 14 (eureka warnings?) self)
							)
							((proc0_1 37)
								(if (not (proc0_1 39))
									(gTestMessager say: 24 0 0 1 self 202)
								else
									(= cycles 1)
								)
								(= next (ScriptID 207 7))
								(eureka
									state: 2
									timer: 0
									warnings: 0
									destination: 0
									curLocation: 14
								)
							)
							(else
								(if (proc0_1 32)
									(= next sSmallPlanet)
								else
									(if (gOldCast contains: wasteBeacon)
										(wasteBeacon dispose:)
									)
									(if (== (eureka destination?) 6)
										((ScriptID 221 0) dispose:)
									)
									(bigPlanet dispose:)
									(proc0_3 38)
								)
								(gTestMessager say: 11 0 14 3 self)
								(eureka timer: 0 warnings: 0 state: 1 destination: 0)
							)
						)
					)
					(3
						(if (!= global126 1)
							(switch (eureka warnings?)
								(1
									(proc0_2 61)
									(proc0_2 60)
									(eureka timer: 0 setScript: 0)
									(= local12 0)
									(= next (ScriptID 208 0))
									(= cycles 1)
								)
								(2
									(= next (ScriptID 208 1))
									(eureka timer: 0)
									(= cycles 1)
								)
								(3
									(= next (ScriptID 208 1))
									(eureka timer: 0)
									(= cycles 1)
								)
							)
						else
							(= next (ScriptID 232 9))
							(= cycles 1)
						)
						(self dispose:)
					)
					(5
						(switch gEurekaCurLocation
							(6
								(switch (eureka warnings?)
									(1
										(gTestMessager say: 13 0 14 0 self 202)
										(eureka setScript: 0)
										(eureka setScript: (ScriptID 210 1) 0 2)
									)
									(2
										(gTestMessager
											say: 13 0 12 (+ (eureka hits?) 1) self 202
										)
										(eureka setScript: 0)
										(eureka setScript: (ScriptID 210 1) 0 20)
									)
									(3
										(= next (ScriptID 221 5))
										(= cycles 1)
									)
									(4
										(eureka warnings: 1)
										(global2 newRoom: 222)
										(= cycles 1)
									)
								)
							)
							(14
								(if (proc0_1 39)
									(= cycles 1)
								else
									(= next (ScriptID 207 5))
									(= cycles 1)
								)
							)
						)
					)
					(6
						(switch (eureka puke?)
							(1
								(switch (eureka warnings?)
									(1
										(gTestMessager say: 11 0 15 1 self)
										(eureka setScript: 0)
										(eureka setScript: (ScriptID 210 5) 0 15)
									)
									(else 
										(= next (ScriptID 207 2))
										(self dispose:)
									)
								)
							)
							(2
								(= next (ScriptID 207 4))
								(self dispose:)
							)
							(4
								(client setScript: (ScriptID 210 3) 0 7)
								(self dispose:)
							)
							(else 
								(eureka timer: 0 setScript: 0 warnings: 0)
								(= cycles 1)
							)
						)
					)
				)
				(eureka timer: 0)
			)
			(2
				(self setScript: sTurnDrooleBack self)
			)
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSmallPlanet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(smallPlanet init: setScale: ScaleTo 100 10 self)
			)
			(1
				(smallPlanet setMotion: MoveTo 275 120 self)
				(eureka state: 1)
			)
			(2
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnAround of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(if (eureka curLocation?)
					(= local11 1)
					(eureka setScript: 0 timer: 0)
					(leadStar init:)
				else
					(= cycles 1)
				)
			)
			(1 (= seconds 3))
			(2
				(eureka state: 2)
				(self setScript: sBigPlanet self)
			)
			(3 (self dispose:))
		)
	)
)

(instance sFloArm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(floArm
					setCel:
					(switch (Random 0 6)
						(0 0)
						(else  (Random 1 2))
					)
				)
				(= cycles 1)
			)
			(1
				(= ticks (Random 3 20))
				(= state (- state 2))
			)
		)
	)
)

(instance sBusyFlo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo startUpd:)
				(flo setCycle: Beg self)
			)
			(1
				(flo setLoop: 0 setCel: 0 setCycle: 0)
				(gEgo hide:)
				(floArm show: self)
				(= cycles 1)
			)
			(2
				(if (and (<= 1 register) (<= register 3))
					(gSq5Music2 number: 212 setLoop: 1 play:)
					(= seconds 2)
				else
					(= ticks 30)
				)
			)
			(3
				(if (and (<= 1 register) (<= register 3))
					(proc201_5 0)
					(floTalker talkWidth: 60)
					(gTestMessager say: 19 0 0 1 self)
				else
					(self changeState: 6)
				)
			)
			(4
				(= seconds 3)
				(floTalker talkWidth: 120)
				(proc201_5 1)
				(gSq5Music2 number: 234 setLoop: 1 play:)
			)
			(5
				(if
					(and
						(== register 1)
						(not (proc0_1 34))
						(== gEurekaCurLocation 0)
					)
					(= cycles 1)
				else
					(proc201_6 self)
				)
			)
			(6
				(flo stopUpd:)
				(if (not (proc0_1 61))
					(gSq5Music2 number: 206 setLoop: -1 play:)
				)
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sDrooleArm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(switch (Random 0 6)
					(0
						(drooleArm setCel: 0)
						(drooleHand hide:)
					)
					(else 
						(drooleArm setCel: 1)
						(drooleHand show: setCel: (Random 2 4))
					)
				)
				(= cycles 1)
			)
			(2 (= ticks (Random 3 20)))
			(3 (self changeState: 1))
		)
	)
)

(instance sStepOnGas of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 163 loop: 1 play: self)
			)
			(1
				(UnLoad 132 163)
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 4))
				(gSQ5 setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sFlashWhite of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(if (gOldCast contains: wasteBeacon)
					(wasteBeacon dispose:)
				)
				(= seconds 2)
			)
			(1
				(Palette palSET_INTENSITY 64 127 0)
				(= cycles 1)
			)
			(2
				(Palette palSET_FROM_RESOURCE 4101 2)
				(Palette palSET_INTENSITY 64 127 0)
				(droole setScript: sStepOnGas)
				(= cycles 1)
			)
			(3
				(= register 0)
				(while (< register 65)
					(Palette palSET_INTENSITY 64 127 register)
					(if (== register 60) (= cycles 1))
					(= register (+ register 15))
				)
				(= local8 1)
				(= local10 0)
				(localproc_0fd7)
			)
			(4
				(Palette palSET_INTENSITY 64 127 100)
				(= cycles 1)
			)
			(5
				(Palette palSET_FROM_RESOURCE 412 2)
				(= gEurekaCurLocation 17)
				(= local8 0)
				(eureka timer: 0 setScript: 0)
				(eureka
					setScript:
						(if
						(and (== (eureka destination?) 3) (not (proc0_1 9)))
							(ScriptID 210 6)
						else
							(ScriptID 210 4)
						)
						0
						30
				)
				(= cycles 1)
			)
			(6
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnBrakes of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 214 loop: 1 play: self)
			)
			(1
				(gSq5Music2 number: 107 loop: 1 play: self)
			)
			(2
				(gSq5Music2 number: 206 loop: -1 play:)
				(= gEurekaCurLocation 16)
				(if
				(and (== (eureka state?) 2) (eureka destination?))
					(= next sBigPlanet)
					(self dispose:)
				else
					(gSQ5 handsOn:)
					(gSq5IconBar select: (gSq5IconBar at: 4))
					(gSQ5 setCursor: 984 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFlashRed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (not (proc0_1 61))
					(gSq5Music2 number: 211 setLoop: 1 play:)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(1
				(Palette palSET_INTENSITY 64 127 0)
				(if (not (proc0_1 61))
					(droole setScript: sPutOnBrakes)
				else
					(gSq5Music2 number: 128 loop: -1 play:)
				)
				(= cycles 1)
			)
			(2
				(Palette palSET_FROM_RESOURCE 4102 2)
				(Palette palSET_INTENSITY 64 127 0)
				(= cycles 1)
			)
			(3
				(= register 0)
				(while (< register 65)
					(Palette palSET_INTENSITY 64 127 register)
					(if (>= register 60) (= cycles 1))
					(= register (+ register 10))
				)
				(= local9 1)
				(localproc_0fd7)
			)
			(4
				(Palette palSET_INTENSITY 64 127 100)
				(= cycles 1)
			)
			(5
				(Palette palSET_FROM_RESOURCE 412 2)
				(= local9 0)
				(= cycles 1)
			)
			(6
				(= local10 1)
				(if (proc0_1 61) (= seconds 1) else (= cycles 1))
			)
			(7 (self dispose:))
		)
	)
)

(instance sTrashBeacon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc201_6 self))
			(1
				(gTestMessager say: 39 0 51 1 self)
			)
			(2
				(self setScript: sBusyFlo self 0)
			)
			(3 (self dispose:))
		)
	)
)

(instance sBigPlanet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_3 38)
				(eureka setScript: 0 timer: 0)
				(if (> (eureka curLocation?) 14)
					(eureka state: 1 destination: 0 curLocation: 0)
					(proc201_27 0)
					(gTestMessager say: 11 0 14 4 self)
					(= state 3)
				else
					(switch (eureka curLocation?)
						(1
							(if (proc0_1 35) (proc0_3 38) else (proc0_2 38))
							(= cycles 1)
						)
						(2
							(if (proc0_1 36) (proc0_3 38) else (proc0_2 38))
							(= cycles 1)
						)
						(5
							(if (and (not (proc0_1 93)) (proc0_1 30))
								(= local2 1)
							else
								(= local2 0)
							)
							(= cycles 1)
						)
						(6
							(if (and (not (proc0_1 94)) (proc0_1 33))
								(= local3 1)
							else
								(= local3 0)
							)
							(= cycles 1)
							((ScriptID 221 0) init:)
						)
						(12
							(if (proc0_1 75)
								(self setScript: (ScriptID 207 6) self)
							else
								(= cycles 1)
							)
						)
						(else  (= cycles 1))
					)
				)
			)
			(1
				(if (proc0_1 38) (wasteBeacon init: setCycle: Fwd self))
				(bigPlanet
					init:
					setScale: ScaleTo 100 5 2
					setMotion: MoveTo -64 125 self
				)
			)
			(2
				(cond 
					((proc0_1 38) (self setScript: sTrashBeacon self))
					(local3 (= local3 0) (self setScript: (ScriptID 233 2) self))
					(local2 (= local2 0) (self setScript: (ScriptID 233 1) self))
					((proc0_1 61) (self dispose:))
					(else (= cycles 1))
				)
			)
			(3
				(eureka
					timer: 0
					setScript: (ScriptID 210 4) 0 30
					warnings: 2
					destination: 0
				)
				(= cycles 1)
			)
			(4
				(proc201_27 1)
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 4))
				(gSQ5 setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sInToOrbit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (not (proc0_1 61))
					(gSq5Music2 number: 211 setLoop: 1 play:)
				)
				(= seconds 2)
			)
			(1
				(= local6 1)
				(bigPlanet init:)
				(if (== (eureka curLocation?) 6)
					((ScriptID 221 0) init:)
				)
			)
			(2
				(= gEurekaCurLocation (eureka curLocation?))
				(switch (eureka curLocation?)
					(7 (= next (ScriptID 232 11)))
					(4
						(cond 
							((< global127 3) (= next (ScriptID 232 12)))
							((== global127 3) (proc0_2 85) (= next sAbandonShip))
						)
					)
					(6
						(if (== global142 1) (proc0_10 181 20))
						((ScriptID 221 0) addToPic:)
					)
					(5
						(if (proc0_1 30)
							(proc0_10 177 10)
							(if (and (not (proc0_1 97)) (not (proc0_1 76)))
								(proc0_2 108)
							)
						)
					)
					(8 (proc0_10 180 10))
				)
				(if (not (proc0_1 61)) (bigPlanet addToPic:))
				(= cycles 1)
			)
			(3
				(if (not (proc0_1 61))
					(gSq5Music2 number: 206 setLoop: -1 play:)
					(gSQ5 handsOn:)
					(gSq5IconBar select: (gSq5IconBar at: 4))
					(gSQ5 setCursor: 984 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOutOfOrbit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if
					(and
						(== gEurekaCurLocation 6)
						(gOldATPs contains: (ScriptID 221 0))
					)
					(gOldATPs delete: (ScriptID 221 0))
				)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(= seconds 2)
			)
			(1
				(global2 drawPic: 41 100)
				(flo startUpd:)
				(droole startUpd:)
				(bigPlanet init:)
				(if (== gEurekaCurLocation 6) ((ScriptID 221 0) init:))
				(= local7 1)
			)
			(2
				(= gEurekaCurLocation 16)
				(eureka state: 1)
				(= local7 0)
				(= cycles 1)
			)
			(3
				(gSQ5 handsOn:)
				(gSq5IconBar select: (gSq5IconBar at: 4))
				(gSQ5 setCursor: 984 1)
				(if (== (eureka curLocation?) 15)
					(eureka curLocation: 6)
				)
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance smallPlanet of Actor
	(properties
		x 156
		y 81
		view 217
		loop 4
		cel 6
		maxScale 20
	)
	
	(method (init)
		(self
			setLoop: 4
			setCel: 6
			x: 156
			y: 81
			setPri: 5
			ignoreActors: 1
			scaleX: 20
			scaleY: 20
			moveSpeed: 0
			setStep: 5 5
		)
		(super init: &rest)
	)
	
	(method (doit)
		(if
		(and (== (eureka state?) 2) (== gEurekaCurLocation 16))
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance wasteBeacon of Prop
	(properties
		x 130
		y 75
		view 217
		loop 3
		detailLevel 2
	)
	
	(method (init)
		(if (< (eureka warnings?) 2)
			(self setPri: 6 setLoop: 3 x: 130 y: 75 ignoreActors:)
		else
			(self x: -64 y: 125 hide:)
		)
		(super init: &rest)
		(theMusic3 number: 224 loop: -1 play:)
	)
	
	(method (doit)
		(self x: (+ (bigPlanet x?) 10) y: (bigPlanet y?))
		(super doit: &rest)
	)
	
	(method (dispose)
		(theMusic3 fade: 0 10 10 1)
		(super dispose: &rest)
	)
)

(instance bigPlanet of Actor
	(properties
		view 212
		signal $6000
	)
	
	(method (init &tmp temp0)
		(if
			(or
				(and
					(== (eureka state?) 2)
					(eureka destination?)
					(not (proc0_1 32))
				)
				(== (eureka state?) 3)
			)
			(self
				view: [local41 (eureka curLocation?)]
				setStep: 15 15
				setPri: 5
			)
			(if (= temp0 [local57 (eureka curLocation?)])
				(Palette palSET_FROM_RESOURCE temp0 2)
			)
			(switch (eureka state?)
				(2
					(self
						x: 130
						y: 75
						scaleX: 10
						scaleY: 10
						maxScale: 10
						scaleSignal: 1
						setCel: 0
						setLoop: 0
						moveSpeed: 0
						ignoreActors: 1
					)
				)
				(3
					(self signal: 0)
					(if local6
						(self
							ignoreActors: 1
							view: [local41 (eureka curLocation?)]
							setLoop: (if (proc999_5 (eureka curLocation?) 4 7 8 14) 0 else 1)
							x: -186
							y: 58
							setCycle: 0
							scaleSignal: 1
							scaleX: 128
							scaleY: 128
							maxScale: 128
							setPri: 5
						)
					else
						(self
							ignoreActors: 1
							view: [local41 (eureka curLocation?)]
							setLoop: (if (proc999_5 (eureka curLocation?) 4 7 8 14 15)
								0
							else
								1
							)
							x: 48
							y: 58
							setCycle: 0
							scaleSignal: 1
							scaleX: 128
							scaleY: 128
							maxScale: 128
							setPri: 5
						)
					)
					(if
						(and
							(== (eureka curLocation?) 14)
							(>= (eureka puke?) 1)
						)
						(self view: 227)
					)
				)
				(else  (super init: &rest))
			)
			(super init: &rest)
		)
	)
	
	(method (doit)
		(cond 
			(local6
				(if (> x 42)
					(sInToOrbit cue:)
					(= local6 0)
				else
					(self setMotion: MoveTo (+ x 6) y)
				)
			)
			(local7
				(if (< x -180)
					(sOutOfOrbit cue:)
					(switch (eureka curLocation?)
						(15
							((ScriptID 221 1) dispose:)
							((ScriptID 221 2) dispose:)
							((ScriptID 221 3) dispose:)
							((ScriptID 221 4) dispose:)
						)
						(6 ((ScriptID 221 0) dispose:))
					)
					(self dispose:)
				else
					(self setMotion: MoveTo (- x 6) y)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance leadStar of Actor
	(properties
		view 217
		priority 4
		signal $6000
	)
	
	(method (init)
		(self x: 44 y: 129 ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (doit)
		(if local11
			(if (> x 464)
				(= local11 0)
				(sTurnAround cue:)
				(self dispose:)
			else
				(self x: (+ x 6))
			)
		else
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance fastStar of Actor
	(properties
		view 217
		priority 4
		signal $6010
		moveSpeed 0
	)
	
	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond 
			((== (eureka state?) 3) (= temp0 (Random 5 85)))
			(local10 (= temp0 (Random 5 65)))
			(else (= temp0 (Random 15 25)))
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			posn: temp2 temp3
			setLoop: 0
			setCel: 0
			heading: (+ temp1 90)
			setStep: 5 5
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 5 5 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)
	
	(method (doit)
		(cond 
			(local6 (if (> x 276) (self x: (- x 230))) (self x: (+ x 6)))
			(local7 (if (< x 44) (self x: (+ x 240))) (self x: (- x 6)))
			(local11 (if (< x 44) (self x: (+ x 230))) (self x: (- x 6)))
		)
		(super doit: &rest)
	)
	
	(method (cue)
		(cond 
			(local9 (self setStep: 1 1 setMotion: MoveFwd 10 self))
			(local8 (self setStep: 10 10 setMotion: MoveFwd 20 self))
			(local10 (self setMotion: 0))
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop?) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else (self init:))
		)
	)
)

(instance mediumStar of Actor
	(properties
		view 217
		priority 4
		signal $6010
		moveSpeed 5
	)
	
	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond 
			((== (eureka state?) 3) (= temp0 (Random 5 85)))
			(local10 (= temp0 (Random 5 65)))
			(else (= temp0 (Random 10 15)))
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			setHeading: (+ temp1 90)
			posn: temp2 temp3
			setLoop: 0
			setCel: (Random 0 1)
			setStep: 4 4
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 4 4 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)
	
	(method (doit)
		(cond 
			(local6 (if (> x 276) (self x: (- x 230))) (self x: (+ x 3)))
			(local7 (if (< x 44) (self x: (+ x 240))) (self x: (- x 3)))
			(local11 (if (< x 44) (self x: (+ x 230))) (self x: (- x 3)))
		)
		(super doit: &rest)
	)
	
	(method (cue)
		(cond 
			(local9 (self setStep: 1 1 setMotion: MoveFwd 10 self))
			(local8 (self setStep: 5 5 setMotion: MoveFwd 20 self))
			(local10 (self setMotion: 0))
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop?) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else (self init:))
		)
	)
)

(instance slowStar of Actor
	(properties
		view 217
		priority 4
		signal $6010
		moveSpeed 10
	)
	
	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond 
			((== (eureka state?) 3) (= temp0 (Random 5 85)))
			(local10 (= temp0 (Random 5 65)))
			(else (= temp0 (Random 10 15)))
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			setHeading: (+ temp1 90)
			posn: temp2 temp3
			setLoop: 0
			setCel: (Random 2 3)
			setStep: 1 1
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 2 2 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)
	
	(method (doit)
		(cond 
			(local6
				(if (> x 276) (self x: (- x 230)))
				(self x: (+ (self x?) xStep))
			)
			(local7
				(if (< x 44) (self x: (+ x 240)))
				(self x: (- (self x?) xStep))
			)
			(local11 (if (< x 44) (self x: (+ x 230))) (self x: (- x 3)))
		)
		(super doit: &rest)
	)
	
	(method (cue)
		(cond 
			(local9 (self setStep: 1 1 setMotion: MoveFwd 10 self))
			(local8 (self setStep: 2 2 setMotion: MoveFwd 20 self))
			(local10 (self setMotion: 0))
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop?) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else (self init:))
		)
	)
)

(instance ViewScreen of Feature
	(properties
		x 165
		y 179
		z 93
		noun 23
		onMeCheck $0002
	)
	
	(method (init)
		(switch gEurekaCurLocation
			(0
				((ScriptID 214 1) init: ignoreActors: 1 addToPic:)
				((ScriptID 214 0) init: ignoreActors: 1 addToPic:)
				(if (not (proc0_1 31))
					((ScriptID 214 3) init: stopUpd: ignoreActors: 1)
					((ScriptID 214 2) init: stopUpd: ignoreActors: 1)
				)
			)
			(6
				((ScriptID 221 0) init: addToPic:)
			)
			(15
				((ScriptID 221 1) init:)
				((ScriptID 221 2) init:)
				((ScriptID 221 3) init:)
				((ScriptID 221 4) init:)
			)
			(14 ((ScriptID 207 0) init:))
			(3
				(if (proc0_1 61) ((ScriptID 208 2) init: addToPic:))
			)
		)
		(if (== (eureka state?) 3) (bigPlanet addToPic:))
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(if
			(and
				(gOldCast contains: (ScriptID 204 4))
				(not (proc0_1 84))
			)
			(global2 setScript: (ScriptID 204 5))
		else
			(switch theVerb
				(1
					(cond 
						(
						(and (== (eureka state?) 2) (eureka curLocation?)) (gTestMessager say: 23 1 0 (eureka curLocation?) 0 202))
						((== gEurekaCurLocation 0)
							(if (proc0_1 31)
								(gTestMessager say: 23 1 88 1 0 202)
							else
								(gTestMessager say: 23 1 20 1 0 202)
							)
						)
						(
						(and (== gEurekaCurLocation 6) (> gPEventX 136)) (gTestMessager say: 23 1 17 1 0 202))
						(
						(and (== gEurekaCurLocation 14) (< (eureka puke?) 2))
							(cond 
								((== (eureka puke?) 1) (gTestMessager say: 23 1 92 1 0 202))
								((proc0_1 119) (gTestMessager say: 23 1 14 1 0 202))
								(else (proc0_2 119) (gTestMessager say: 23 1 14 0 0 202))
							)
						)
						((proc0_1 61) (gTestMessager say: 29 1 0 1 0 202))
						(else (gTestMessager say: 23 1 0 gEurekaCurLocation 0 202))
					)
				)
				(else  (super doVerb: theVerb))
			)
		)
	)
)

(instance flo of Prop
	(properties
		x -12
		y 199
		z 90
		noun 16
		view 202
		priority 12
		signal $5010
	)
	
	(method (init)
		(if (not (proc0_1 86))
			(self
				stopUpd:
				setCycle: 0
				setScript: sFloArm
				ignoreActors: 1
			)
			(floArm init: show:)
			(super init: &rest)
		else
			(self dispose:)
		)
	)
	
	(method (doVerb theVerb)
		(if (gOldCast contains: (ScriptID 204 4))
			(global2 setScript: (ScriptID 204 5))
		else
			(switch theVerb
				(24
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 216 0))
				)
				(2
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 216 1))
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance droole of Prop
	(properties
		x 276
		y 200
		z 80
		noun 11
		view 203
		priority 9
		signal $5010
		detailLevel 3
	)
	
	(method (init)
		(if (or (proc0_1 86) (proc0_1 97))
			(self dispose:)
		else
			(self stopUpd: setCycle: 0 ignoreActors: 1)
			(drooleArm init:)
			(super init: &rest)
		)
	)
	
	(method (doVerb theVerb)
		(if (gOldCast contains: (ScriptID 204 4))
			(global2 setScript: (ScriptID 204 5))
		else
			(switch theVerb
				(24
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 217 0))
				)
				(2
					(global2 setScript: (ScriptID 217 1))
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance drooleArm of Prop
	(properties
		x 275
		y 178
		view 203
		loop 2
		priority 9
		signal $0010
		detailLevel 3
	)
	
	(method (init)
		(drooleHand init:)
		(self setScript: sDrooleArm setCycle: 0 show:)
		(super init: &rest)
	)
)

(instance drooleHand of Prop
	(properties
		x 275
		y 178
		view 203
		loop 2
		cel 2
		priority 9
		signal $0010
		detailLevel 3
	)
	
	(method (init)
		(self hide:)
		(super init: &rest)
	)
)

(instance rogTalker of Narrator
	(properties)
	
	(method (init)
		(= font gFont)
		((= gSq5Win gNewSpeakWindow)
			tailX: 152
			tailY: 138
			xOffset: 0
			isBottom: 0
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance floTalker of ChoiceTalker
	(properties
		x -22
		y 107
		view 202
		loop 1
		cel 1
		signal $4000
		talkWidth 120
		normal 1
	)
	
	(method (init)
		(= font gFont)
		(if normal
			((= gSq5Win gNewSpeakWindow)
				tailX: 55
				tailY: 88
				xOffset: 30
				isBottom: 1
			)
		else
			(= gSq5Win gSq5Win_2)
			(self textX: 50 textY: -100 talkWidth: 150)
		)
		(if (localproc_1011)
			(self loop: 1 cel: 1)
			(super init: 0 0 floMouth &rest)
		else
			(self loop: 4 cel: 0)
			(super init: 0 0 0 &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance floMouth of Prop
	(properties
		nsTop 26
		nsLeft 30
		view 202
		loop 3
		cel 4
		signal $4000
	)
	
	(method (init)
		(self cel: 4)
		(super init: &rest)
	)
)

(instance drooleTalker of ChoiceTalker
	(properties
		x 268
		y 120
		view 203
		loop 1
		cel 2
		signal $4000
		talkWidth 120
		textX -100
		normal 1
	)
	
	(method (init)
		(= font gFont)
		(if normal
			((= gSq5Win gNewSpeakWindow)
				tailX: 250
				tailY: 115
				xOffset: -1
				isBottom: 1
			)
		else
			(= gSq5Win gSq5Win_2)
			(self textX: -120 textY: -100 talkWidth: 120)
		)
		(if (localproc_1019)
			(self loop: 1 cel: 2 x: 268 y: 120)
			(super init: 0 drooleEyes drooleMouth &rest)
		else
			(self setLoop: 5 cel: 0)
			(super init: 0 0 0 &rest)
		)
	)
	
	(method (dispose)
		(= gSq5Win gSq5Win_2)
		(super dispose: &rest)
	)
)

(instance drooleMouth of Prop
	(properties
		nsTop 16
		nsLeft 31
		view 203
		loop 3
		signal $4000
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance drooleEyes of Prop
	(properties
		nsTop 7
		nsLeft 28
		view 203
		loop 4
		priority 14
		signal $4010
	)
)

(instance floArm of View
	(properties
		x 31
		y 176
		view 202
		loop 2
		priority 12
		signal $4010
	)
)

(instance dConsole of Feature
	(properties
		x 257
		y 188
		z 30
		noun 9
		nsTop 135
		nsLeft 227
		nsBottom 182
		nsRight 287
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(24
				(if (and (not (proc0_1 86)) (not (proc0_1 97)))
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 217 0))
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2
				(if (and (not (proc0_1 86)) (not (proc0_1 97)))
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 217 1))
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fConsole of Feature
	(properties
		x 48
		y 184
		z 30
		noun 14
		nsTop 138
		nsLeft 23
		nsBottom 170
		nsRight 74
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(24
				(if (not (proc0_1 86))
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 216 0))
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2
				(if (not (proc0_1 86))
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 216 1))
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance capChair of Feature
	(properties
		x 162
		y 199
		z 30
		noun 5
		nsTop 149
		nsLeft 127
		nsBottom 189
		nsRight 197
	)
)

(instance vid1Monitor of Feature
	(properties
		x 100
		y 35
		noun 36
		nsTop 26
		nsLeft 89
		nsBottom 41
		nsRight 112
	)
)

(instance vid2Monitor of Feature
	(properties
		x 219
		y 34
		noun 37
		nsTop 26
		nsLeft 207
		nsBottom 41
		nsRight 232
	)
)

(instance vid3Monitor of Feature
	(properties
		x 160
		y 34
		noun 38
		nsTop 26
		nsLeft 143
		nsBottom 42
		nsRight 177
	)
)

(instance bridge of Feature
	(properties
		x 163
		y 234
		z 50
		nsTop 171
		nsLeft 145
		nsBottom 188
		nsRight 178
	)
	
	(method (doVerb theVerb)
		(cond 
			(
				(and
					(gOldCast contains: (ScriptID 204 4))
					(not (proc0_1 84))
				)
				(global2 setScript: (ScriptID 204 5))
			)
			((proc999_5 theVerb 4 3) (gSQ5 handsOff:) (global2 newRoom: 200))
			(else (super doVerb: theVerb))
		)
	)
)

(instance buttonPanel of Feature
	(properties
		x 201
		y 153
		nsTop 150
		nsLeft 200
		nsBottom 157
		nsRight 218
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(cond 
					((proc999_4 200 160 204 167 gPEventX gPEventY) (= temp0 0))
					((proc999_4 207 160 211 167 gPEventX gPEventY) (= temp0 1))
					((proc999_4 214 160 218 167 gPEventX gPEventY) (= temp0 2))
				)
				(if (not (global2 script?))
					(gSQ5 handsOff:)
					(global2 setScript: (ScriptID 202 6) 0 temp0)
				)
			)
			(1
				(cond 
					((proc999_4 200 160 204 167 gPEventX gPEventY) (= temp0 1))
					((proc999_4 207 160 211 167 gPEventX gPEventY) (= temp0 2))
					((proc999_4 214 160 218 167 gPEventX gPEventY) (= temp0 3))
				)
				(gTestMessager say: 6 1 0 temp0 0 202)
			)
			(else  (super doVerb: theVerb))
		)
	)
)
