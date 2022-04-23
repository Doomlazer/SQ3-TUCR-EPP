;;; Sierra Script 1.0 - (do not remove this comment)
(script# 225)
(include sci.sh)
(use Main)
(use eureka)
(use Class_255_0)
(use Scaler)
(use Osc)
(use RandCycle)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	rm225 0
	scienceDoor 1
)

(local
	local0
	local1
	local2
	local3
	[local4 9] = [58 71 84 60 73 85 63 74 87]
	[local13 20] = [124 110 4 124 111 5 124 112 113 115 153 154 1 153 159 2 151 159 123 157]
)
(procedure (localproc_01cc)
	(if (== (eureka garbage?) 1)
		(garb1 init:)
		(garb2 init:)
		(groundGarbage init:)
		(groundPeel init:)
	)
)

(procedure (localproc_01fb)
	(cond 
		((proc0_1 61)
			(if (!= (gSq5Music1 number?) 20)
				(gSq5Music1 number: 20 loop: -1 play:)
			)
		)
		((proc0_1 84)
			(if (!= (gSq5Music1 number?) 42)
				(gSq5Music1 number: 42 loop: -1 play:)
			)
		)
		(else (gSq5Music1 number: 101 loop: -1 play: 127))
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance rm225 of Rm
	(properties
		noun 17
		picture 42
		style $000a
		vanishingY 50
	)
	
	(method (init)
		(global2 setRegions: 210)
		(proc958_0 128 235 0 2 180 230 233 238 239)
		(global2
			addObstacle:
				(if (== global130 1)
					((Polygon new:)
						type: 3
						init:
							222
							182
							186
							165
							155
							124
							147
							124
							133
							108
							107
							109
							110
							120
							92
							134
							91
							142
							117
							143
							125
							169
							95
							180
						yourself:
					)
				else
					((Polygon new:)
						type: 3
						init:
							222
							182
							186
							165
							155
							124
							147
							124
							135
							109
							107
							109
							110
							120
							92
							134
							91
							142
							117
							143
							125
							169
							95
							180
						yourself:
					)
				)
		)
		(global2 setScript: sInitRoom)
		(super init: &rest)
		(gOldWH addToFront: northDoor scienceDoor)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script 0)
			((and (elevator onMe: gEgo) local0) (global2 setScript: sElevDown))
			(
				(and
					(proc0_1 113)
					(acidHole1 onMe: gEgo)
					(<= 91 (gEgo heading?))
					(<= (gEgo heading?) 269)
				)
				(global2 setScript: fallInHole 0 acidHole1)
			)
			((and (proc0_1 114) (acidHole2 onMe: gEgo)) (global2 setScript: fallInHole 0 acidHole2))
			((and (not (proc0_1 86)) (not (proc0_1 60))) (global2 setScript: (ScriptID 227 1)))
			(
				(and
					(or (pukeDrip onMe: gEgo) (blobReach onMe: gEgo))
					local2
				)
				(blobReach dispose:)
				(= local2 0)
				(global2 setScript: sApproachPuke)
			)
		)
	)
	
	(method (dispose)
		(gOldWH delete: northDoor scienceDoor openDoor)
		(DisposeScript 227)
		(switch (eureka puke?)
			(4 (eureka puke: 5))
			(5 (eureka puke: 6))
		)
		(super dispose:)
	)
)

(instance sInitRoom of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(toolBox init: setOnMeCheck: 1 2)
				(elevator init:)
				(northDoor init:)
				(scienceDoor init:)
				(pipes init:)
				(emptyTrash init:)
				(serviceTunnel init:)
				(if (proc0_1 113)
					(acidHole1 setCel: (acidHole1 lastCel:) init:)
				)
				(if (proc0_1 114)
					(acidHole2 setCel: (acidHole2 lastCel:) init:)
				)
				(if (== (eureka puke?) 7) (= local2 1))
				(switch gGModNum
					(200
						(proc0_6 0 2)
						(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
						(= next sEnterNorth)
					)
					(226
						(proc0_6 0 1)
						(gEgo init: setScale: Scaler 153 42 168 107 posn: 120 155)
						(gSQ5 handsOn:)
					)
					(228
						(gEgo
							view: 241
							init:
							posn: 145 115
							setLoop: 1
							cel: 9
							show:
						)
						(= next sEnterEast)
					)
					(230
						(proc0_6 0 2)
						(gEgo init: posn: 167 141 setScale: Scaler 153 42 168 107)
						(= global126 4)
						(= next sSpikeScoots)
					)
					(240
						(proc0_6 0 0)
						(gEgo init: posn: 66 133 setScale: Scaler 153 42 168 107)
						(= next sEnterWest)
					)
					(250
						(proc0_6 0)
						(gEgo init: setScale: Scaler 153 42 168 107 hide:)
						(elevLighttl init:)
						(elevLighttr init:)
						(elevLightbl init:)
						(elevLightbr init:)
						(elevButtonLight init:)
						(= next sUpElev)
					)
					(else 
						(if
							(>=
								(= temp0
									(proc255_1
										{Eureka State: \n\n\n(0) Meet Cliffy \n(1) Spike's Here \n(2) Cliffy Hammering \n(3) Puke Bulging \n(4) Puke Dripping \n(5) Puke Grabbing\n}
									)
								)
								0
							)
							(= local3 temp0)
						else
							(= local3 0)
						)
						(switch local3
							(0
								(= gEurekaCurLocation 0)
								(= next sEnterNorth)
								(proc0_3 60)
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
							)
							(1
								(= gEurekaCurLocation 16)
								(= global126 1)
								(= global130 4)
								(= global170 1)
								(= global127 1)
								(= next sEnterNorth)
								(proc0_2 60)
								(proc0_2 35)
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
							)
							(2
								(= next sEnterNorth)
								(= gEurekaCurLocation 16)
								(= global126 4)
								(= global130 1)
								(proc0_2 60)
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
							)
							(3
								(eureka puke: 4)
								(= gEurekaCurLocation 14)
								(= global126 0)
								(= global130 0)
								(= next sEnterNorth)
								(proc0_2 60)
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
							)
							(4
								(eureka puke: 5)
								(= next sEnterNorth)
								(= gEurekaCurLocation 14)
								(= global126 0)
								(= global130 0)
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
								(proc0_2 60)
							)
							(5
								(eureka puke: 6)
								(proc0_2 60)
								(= gEurekaCurLocation 14)
								(= global126 0)
								(= global130 0)
								(proc0_2 73)
								(gEgo
									view: 239
									init:
									posn: 145 115
									setLoop: 0
									cel: 9
									show:
								)
								(= next sEnterEast)
							)
							(else 
								(proc0_6 0 2)
								(gEgo init: posn: 121 105 setScale: Scaler 153 42 168 107)
								(proc0_2 60)
								(= next sEnterNorth)
							)
						)
					)
				)
				(trashDoorBottom init:)
				(trashDoorTop init:)
				(localproc_01cc)
				(blobReach init:)
				(garbageButton init:)
				(elevButton init:)
				(redCross init:)
				(redLight init:)
				(light1 init:)
				((ScriptID 227 0) init:)
				(= cycles 1)
			)
			(1
				(spike init:)
				(localproc_01fb)
				(= cycles 1)
			)
			(2 (self dispose:))
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (gEgo has: 20)
					(gTestMessager say: 17 4 3 0 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (gEgo has: 20)
					(gSQ5 handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(northDoor setCycle: End self)
			)
			(3
				(if
					(and
						(gOldCast contains: (ScriptID 227 0))
						(== ((ScriptID 227 0) view?) 241)
					)
					((ScriptID 227 0) setCycle: Beg)
				)
				(gEgo setMotion: MoveTo 121 105 self)
			)
			(4
				(global2 newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance spikeStuff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((and (proc0_1 114) (not (proc0_1 113))) (proc0_2 113) (= register acidHole1))
					((proc0_1 113) (= register 0))
					(else (proc0_2 114) (= register acidHole2))
				)
				(if register
					(gSq5Music2 number: 256 loop: 1 play:)
					(register init: setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(if register (register stopUpd:))
				(spike setCycle: Walk setMotion: MoveTo 129 195 self)
			)
			(2
				(gTestMessager say: 10 0 0 1 self)
			)
			(3
				(if
					(and
						(gOldCast contains: (ScriptID 227 0))
						(!= ((ScriptID 227 0) view?) 241)
					)
					(gTestMessager say: 4 0 2 0 self)
				else
					(= cycles 1)
				)
			)
			(4
				(= global126 3)
				(spike dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (== global126 4)
					(self setScript: spikeStuff self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveFwd 10 self)
			)
			(2
				(northDoor setCycle: Beg self)
			)
			(3 (= cycles 1))
			(4
				(if (== global126 1)
					(if (== global130 1)
						(gTestMessager say: 11 0 0 0 self)
					else
						(self setScript: (ScriptID 227 4) self)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(if
					(and
						(proc999_5 (eureka puke?) 5 6)
						(!= (theMusic3 number?) 250)
					)
					(trashDoorTop cue:)
				)
				(northDoor stopUpd:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(scienceDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 66 133 self)
			)
			(2
				(global2 newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (== global126 4)
					(self setScript: spikeStuff self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveFwd 30 self)
			)
			(2
				(scienceDoor setCycle: Beg self)
			)
			(3
				(if (gEgo has: 20)
					(gTestMessager say: 17 0 3 0 self)
				else
					(= cycles 1)
				)
			)
			(4
				(if
					(and
						(proc999_5 (eureka puke?) 5 6)
						(!= (theMusic3 number?) 250)
					)
					(trashDoorTop cue:)
				)
				(scienceDoor stopUpd:)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
				(gSQ5 handsOff:)
			)
			(1
				(gEgo
					view: 241
					posn: 145 115
					setLoop: 1
					cel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(global2 newRoom: 228)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: Beg self)
				(if (and (== global126 1) (== global130 1)))
			)
			(2
				(proc0_6 0 0)
				(gEgo posn: 135 115 setScale: Scaler 153 42 168 107)
				(= seconds 1)
			)
			(3
				(if (and (proc0_1 73) (== (eureka puke?) 6))
					(= next sPukeAttacks)
				)
				(= cycles 1)
			)
			(4
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sElevDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= local0 0)
				(gEgo setMotion: MoveTo 129 130 self)
			)
			(1
				(gEgo heading: 180)
				(= cycles 1)
			)
			(2
				(gEgo hide:)
				(elevator setPri: 7 setLoop: 1 setCel: 2)
				(= cycles 20)
			)
			(3
				(elevator setMotion: MoveTo 130 189 self)
				(theMusic3 number: 127 loop: 1 play:)
			)
			(4
				(global2 newRoom: 250)
				(self dispose:)
			)
		)
	)
)

(instance sUpElev of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (== global126 4)
					(self setScript: spikeStuff self)
				else
					(= cycles 1)
				)
			)
			(1
				(elevator setPri: 7 setMotion: MoveTo 130 136 self)
				(gEgo posn: 129 130 setHeading: 180)
			)
			(2
				(theMusic3 number: 241 setLoop: 1 play:)
				(= seconds 1)
			)
			(3
				(= cycles 1)
				(elevator setCel: 1)
				(elevLighttl dispose:)
				(elevLighttr dispose:)
				(elevLightbl dispose:)
				(elevLightbr dispose:)
				(elevButtonLight dispose:)
				(gEgo show: self)
			)
			(4
				(gSQ5 handsOn:)
				(theMusic3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sCycleLights of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palANIMATE 114 116 1)
				(Palette palANIMATE 231 235 -1)
				(= cycles 1)
			)
			(1
				(= state (- state 2))
				(= cycles 1)
			)
		)
	)
)

(instance sOpenGarbageDoors of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo
					view: 235
					posn: 165 134
					cel: 0
					setScale: 0
					setLoop: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo cel: 3 setCycle: CT 0 -1 self)
			)
			(2
				(proc0_6 0 0)
				(gEgo setScale: Scaler 153 42 168 107 posn: 165 138)
				(cond 
					((proc999_5 (eureka puke?) 4 5 6) (= next sPukeAttacks) (self dispose:))
					((== (eureka gdoor?) 0) (trashDoorTop heading: 0) (eureka gdoor: 1) (= cycles 1))
					(else
						(trashDoorTop heading: 180)
						(eureka gdoor: 0)
						(= cycles 1)
					)
				)
			)
			(3
				(trashDoorTop setStep: 1 5 setMotion: MoveFwd 17 self)
				(theMusic3 number: 108 setLoop: 1 play:)
			)
			(4
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fallInHole of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= register (if (== register acidHole1) 0 else 10))
				(gEgo
					setMotion: MoveTo [local13 (+ register 0)] [local13 (+ register 1)] self
				)
			)
			(1
				(gEgo
					view: 240
					loop: [local13 (+ register 2)]
					cel: 0
					posn: [local13 (+ register 3)] [local13 (+ register 4)]
					setCycle: End self
				)
				(if (not register)
					(gEgo setScale: 0)
				else
					(gEgo setScale: Scaler 153 42 168 107)
				)
			)
			(2
				(gEgo hide:)
				((ScriptID 227 2) pause: 1)
				(theMusic3 number: 102 loop: 1 play:)
				(= seconds 2)
			)
			(3
				(theMusic3 number: 116 loop: 1 play:)
				(= seconds 4)
			)
			(4
				((ScriptID 227 2) pause: 0)
				(gEgo
					show:
					loop: [local13 (+ register 5)]
					cel: 0
					setCycle: End self
				)
			)
			(5
				(proc0_6 0 5)
				(gEgo
					posn: [local13 (+ register 6)] [local13 (+ register 7)]
					setScale: Scaler 153 42 168 107
					setMotion: MoveTo [local13 (+ register 8)] [local13 (+ register 9)] self
				)
			)
			(6 (gEgo setHeading: 90 self))
			(7
				(gTestMessager say: 1 0 4 0 self)
			)
			(8
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGarbageFalls of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= seconds 1)
				(eureka garbage: 1)
			)
			(1
				(gEgo
					view: 235
					posn: 165 134
					cel: 0
					setScale: 0
					setLoop: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(trashDoorTop
					yStep: 15
					heading: 0
					setMotion: MoveFwd 17 self
				)
				(if (== global126 1)
					(gSq5Music2 number: 2451 loop: -1 play:)
				)
				(eureka gdoor: 1)
			)
			(3
				(gEgo setCycle: CT 7 1 self)
				(theMusic3 number: 244 setLoop: 1 play:)
			)
			(4
				(gEgo setCel: 8 setCycle: 0)
				(garb1 init:)
				(= ticks 1)
			)
			(5
				(gEgo setCel: 9)
				(garb2 init:)
				(= ticks 1)
			)
			(6
				(gEgo setCel: 10)
				(garb3 init:)
				(= ticks 1)
			)
			(7 (gEgo setCycle: End self))
			(8
				(groundGarbage init:)
				(gEgo setLoop: 1 setCel: 0)
				(= ticks 1)
			)
			(9
				(gEgo setLoop: 1 setCel: 1)
				(= ticks 1)
			)
			(10
				(justBody init:)
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 148 131
					setCycle: CT 3 1 self
				)
			)
			(11
				(groundPeel init:)
				(gEgo cycleSpeed: 9 setCycle: CT 7 1 self)
			)
			(12 (= seconds 2))
			(13
				(justBody hide:)
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 167 141
					cycleSpeed: 12
					setCycle: CT 9 1 self
				)
			)
			(14
				(if (== global126 1)
					(global2 setScript: sSpikeAttacks)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(15
				(proc0_6 0 0)
				(gEgo posn: 165 138 setScale: Scaler 153 42 168 107)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSpikeAttacks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 3
					setCel: 10
					cycleSpeed: 8
					setCycle: CT 15 1 self
				)
				(gSq5Music2 number: 22 setLoop: -1 play:)
			)
			(1 (= seconds 2))
			(2
				(theMusic3 number: 246 setLoop: 1 play:)
				(gEgo setLoop: 4 cel: 0 setCycle: CT 1 1 self)
			)
			(3
				(theMusic3 number: 228 setLoop: 1 play:)
				(gSq5Music2 number: 90 setLoop: 1 play:)
				(gEgo cel: 2 cycleSpeed: 4 setCycle: CT 10 1 self)
			)
			(4
				(theMusic3 number: 2471 loop: -1 play:)
				(= cycles 1)
				(= register 4)
			)
			(5
				(gEgo cel: 2 setCycle: CT 10 1 self)
			)
			(6
				(if (-- register) (= state (- state 2)))
				(= cycles 1)
			)
			(7
				(gEgo
					setLoop: 5
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(8
				(theMusic3 number: 247 loop: 1 play: 127)
				(gEgo cel: 5 setCycle: CT 7 1 self)
				(gSq5Music2
					number: 23
					setLoop: -1
					play: 0
					fade: 127 5 5 0
				)
			)
			(9
				(= global126 4)
				(theMusic3 dispose:)
				(global2 newRoom: 230)
				(self dispose:)
			)
		)
	)
)

(instance sPushElev of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 230
					setLoop: 0
					cel: 0
					setScale: 0
					posn: 157 124
					setCycle: End self
				)
			)
			(2
				(if (not local0)
					(elevator setCel: 0)
					(elevButtonLight init:)
					(elevLighttl init:)
					(elevLighttr init:)
					(elevLightbl init:)
					(elevLightbr init:)
					(= local0 1)
					(= seconds 1)
				else
					(elevator setCel: 1)
					(elevButtonLight dispose:)
					(elevLighttl dispose:)
					(elevLighttr dispose:)
					(elevLightbl dispose:)
					(elevLightbr dispose:)
					(= local0 0)
					(= seconds 1)
				)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(gEgo posn: 154 124 setScale: Scaler 153 42 168 107)
				(proc0_6 0)
				(= cycles 1)
			)
			(5
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGreenLights of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= register 0) (= cycles 1))
			(1
				(light1 x: -5 y: [local4 register] setCel: 0)
				(= seconds 1)
			)
			(2
				(light1
					setStep: 8 1
					setMotion: MoveTo 28 [local4 register] self
				)
			)
			(3
				(light1 x: 34 y: [local4 register] cel: 1)
				(= cycles 3)
			)
			(4
				(light1
					x: 40
					y: [local4 (+ register 3)]
					cel: 2
					setStep: 2 1
					setMotion: MoveTo 50 [local4 (+ register 6)] self
				)
			)
			(5
				(= cycles 1)
				(= register (mod (++ register) 3))
				(= state 0)
			)
		)
	)
)

(instance sPukeAttacks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(if (== (eureka puke?) 4)
					(eureka puke: 6)
					(pukeDrip init:)
				)
				(= seconds 2)
			)
			(1
				(pukeDrip
					view: 238
					setLoop: 1
					cel: 0
					x: 213
					y: 99
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(2
				(pukeDrip setCycle: CT 8 1 self)
				(trashDoorTop
					view: 238
					setLoop: 0
					cel: 0
					x: 143
					y: 113
					cycleSpeed: 4
					setPri: 7
					signal: (| (trashDoorTop signal?) $1000)
					noun: 2
					setCycle: End self
					show:
				)
				(theMusic3 number: 251 setLoop: 1 play:)
				(gEgo setHeading: 180)
				(eureka puke: 7)
			)
			(3 0)
			(4
				(gTestMessager say: 2 0 12 0 self)
				(gSq5Music2 number: 249 setLoop: -1 play:)
			)
			(5
				(pukeDrip setCel: 9)
				(trashDoorTop setPri: 8)
				(pukeEyes init:)
				(pukeHand init:)
				(ambPuke1 init:)
				(ambPuke2 init:)
				(if (== (gEgo x?) 165)
					(= next sPukeRoger)
					(gEgo
						view: 239
						setLoop: 4
						setScale: 0
						setMotion: 0
						posn: 153 142
					)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(6
				(= local2 1)
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sApproachPuke of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setMotion: MoveTo 110 129 self)
			)
			(1
				(pukeHand setCycle: End cycleSpeed: 2)
				(scienceDoor setCycle: End self)
			)
			(2
				(pukeHand setLoop: 7 cel: 0 setCycle: End)
				(gEgo
					view: 239
					setLoop: 2
					cel: 0
					x: 102
					y: 129
					cycleSpeed: 6
					setScale: 0
					setMotion: 0
				)
				(gSq5Music2 number: 249 setLoop: -1 play:)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Osc)
				(pukeHand setCycle: Osc)
				(openDoor init:)
				(gOldWH addToFront: openDoor)
				(= seconds 2)
			)
			(4
				(if (== gGModNum 240)
					(= next sPukeRoger)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(5
				(gSQ5 handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sJumpRoger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 1 setCycle: End self)
			)
			(2
				(global2 newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance sPukeRoger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 4 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(2 (= cycles 1))
			(3 (proc0_9 9) (self dispose:))
		)
	)
)

(instance sSpikeScoots of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSQ5 handsOff:)
				(proc0_10 168 20)
				(spike setCycle: Walk setMotion: MoveTo 129 195 self)
			)
			(1
				(gTestMessager say: 13 0 0 1 self)
			)
			(2
				(spike dispose:)
				(if (proc0_1 84)
					(gSq5Music2 number: 105 loop: -1 play:)
				else
					(gSq5Music2 fade:)
				)
				(= seconds 3)
			)
			(3
				(gSQ5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBlobNoise of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(theMusic3
					number: (if (== (eureka puke?) 4) 250 else 249)
					loop: -1
					play: 0
					fade: 127 5 5 0
				)
				(= cycles 1)
			)
			(2 (self dispose:))
		)
	)
)

(instance trashDoorTop of Actor
	(properties
		x 199
		y 86
		noun 15
		view 233
		loop 7
		priority 3
		signal $5010
	)
	
	(method (init)
		(if (== global126 1) (eureka gdoor: 0))
		(if (< (eureka puke?) 4)
			(self
				view: 233 x 199
				y: (if (== (eureka gdoor?) 0) 86 else 69)
				stopUpd:
				setLoop: 7
				noun: 15
			)
		else
			(trashDoorBottom dispose:)
			(if (proc999_5 (eureka puke?) 4 5 6)
				(self
					view: 237
					loop: 0
					cel: 0
					x: 206
					y: 99
					priority: 10
					setCycle: Osc
					noun: 22
					setScript: sBlobNoise
				)
			else
				(self
					view: 238
					loop: 0
					cel: 4
					x: 143
					y: 113
					priority: 7
					noun: 2
				)
			)
			(if (proc999_5 (eureka puke?) 5 6 7) (pukeDrip init:))
		)
		(super init:)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not cel)
				(proc999_5 (eureka puke?) 5 6)
				(!= (theMusic3 number?) 250)
			)
			(self cue:)
		)
	)
	
	(method (dispose)
		(theMusic3 dispose:)
		(super dispose: &rest)
	)
	
	(method (cue)
		(theMusic3 number: 250 loop: 1 play: self)
	)
)

(instance pukeDrip of Prop
	(properties
		x 205
		y 99
		noun 2
		view 237
		loop 1
		cel 4
		priority 11
		signal $5010
	)
	
	(method (init)
		(if (< (eureka puke?) 7)
			(self
				view: 237
				setLoop: (if (== (eureka puke?) 5) 1 else 2)
				cycleSpeed: 10
				setCycle: Fwd
			)
			(pukeSpill init:)
		else
			(self view: 238 loop: 1 cel: 9 x: 213 y: 99 priority: 11)
			(gSq5Music2 number: 249 setLoop: -1 play:)
			(pukeEyes init:)
			(pukeHand init:)
			(ambPuke1 init:)
			(ambPuke2 init:)
		)
		(super init: &rest)
	)
)

(instance pukeSpill of Prop
	(properties
		x 202
		y 135
		noun 2
		view 237
		loop 3
		priority 11
		signal $5010
	)
	
	(method (init)
		(if (== (eureka puke?) 5)
			(self setLoop: 3 cel: 0 cycleSpeed: 50 setCycle: End self)
		else
			(self setLoop: 4 cel: 0 cycleSpeed: 15 setCycle: Osc)
		)
		(super init: &rest)
	)
	
	(method (cue)
		(self
			setLoop: 4
			cycleSpeed: 15
			ignoreActors: 1
			setCycle: Fwd
		)
	)
)

(instance ambPuke1 of Prop
	(properties
		x 131
		y 133
		noun 2
		view 238
		loop 2
		cel 2
		priority 12
		signal $5010
	)
	
	(method (init)
		(self
			setLoop: 2
			cycleSpeed: 20
			setCycle: Fwd
			ignoreActors: 1
		)
		(super init:)
	)
)

(instance ambPuke2 of Prop
	(properties
		x 151
		y 112
		noun 2
		view 238
		loop 3
		priority 12
		signal $5010
	)
	
	(method (init)
		(self
			setLoop: 3
			cycleSpeed: 10
			ignoreActors: 1
			setCycle: Fwd
		)
		(super init:)
	)
)

(instance pukeEyes of Prop
	(properties
		x 187
		y 105
		noun 2
		view 238
		loop 5
		cel 1
		priority 12
		signal $5010
	)
	
	(method (init)
		(self
			setLoop: 5
			cycleSpeed: 80
			ignoreActors: 1
			setCycle: Fwd
		)
		(super init:)
	)
)

(instance pukeHand of Prop
	(properties
		x 120
		y 151
		noun 2
		view 238
		loop 6
		priority 12
		signal $5010
	)
	
	(method (init)
		(self setLoop: 6 setCel: 0 ignoreActors: 1)
		(super init:)
	)
)

(instance spike of Actor
	(properties
		noun 12
		view 242
		loop 1
		signal $4000
	)
	
	(method (init)
		(cond 
			((and (!= gGModNum 226) (== global126 4))
				(cond 
					((and (proc0_1 114) (not (proc0_1 113))) (self x: 118 y: 110))
					((== gGModNum 230) (self x: 160 y: 153))
					(else (self x: 140 y: 153))
				)
				(super init: &rest)
				(self setScale: Scaler 100 35 166 107)
				(if (!= (gSq5Music2 number?) 23)
					(theMusic3 number: 23 loop: -1 play:)
				)
			)
			((== global126 1) (gSq5Music2 number: 245 loop: -1 play:))
		)
	)
	
	(method (dispose)
		(theMusic3 fade:)
		(super dispose: &rest)
	)
	
	(method (cue)
		(self dispose:)
	)
)

(instance acidHole1 of Prop
	(properties
		x 122
		y 108
		noun 1
		view 240
		loop 3
		priority 1
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance acidHole2 of Prop
	(properties
		x 131
		y 142
		noun 1
		view 240
		priority 9
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance light1 of Actor
	(properties
		x 2
		y 58
		yStep 5
		view 233
		loop 3
		priority 10
		signal $0010
		xStep 5
	)
	
	(method (init)
		(self
			setLoop: 3
			setPri: 10
			moveSpeed: 0
			setScript: sGreenLights
		)
		(super init:)
	)
)

(instance elevator of Actor
	(properties
		x 130
		noun 5
		view 230
		loop 1
		signal $4000
		moveSpeed 0
	)
	
	(method (init)
		(if (!= gGModNum 250)
			(self y: 136 setCel: 1)
		else
			(self y: 188 setCel: 2)
		)
		(self stopUpd: setLoop: 1 ignoreActors: 1 setPri: 3)
		(super init:)
	)
)

(instance redLight of Prop
	(properties
		x 250
		y 74
		view 233
		loop 4
		cel 1
	)
	
	(method (init)
		(if (or (proc0_1 84) (>= (eureka puke?) 4))
			(if (!= (gSq5Music2 number?) 105)
				(gSq5Music2 number: 105 loop: -1 play:)
			)
			(self cycleSpeed: 16 setCycle: Osc)
			(super init: &rest)
		)
	)
)

(instance trashDoorBottom of View
	(properties
		x 201
		y 100
		noun 15
		view 233
		loop 7
		cel 1
		priority 3
		signal $0010
	)
	
	(method (init)
		(if (<= (eureka puke?) 3) (super init: &rest))
	)
	
	(method (doit)
		(self posn: x (+ 100 (- 86 (trashDoorTop y?))))
		(super doit:)
	)
)

(instance groundGarbage of View
	(properties
		x 167
		y 191
		z 50
		noun 16
		view 235
		loop 6
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: 16 4 0 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance groundPeel of View
	(properties
		x 122
		y 191
		z 50
		view 235
		loop 6
		cel 1
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: 16 4 0 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance justBody of View
	(properties
		x 167
		y 191
		z 50
		view 235
		loop 1
		cel 2
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
)

(instance garb1 of View
	(properties
		x 200
		y 171
		z 50
		noun 16
		view 235
		loop 6
		cel 2
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: 16 4 0 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance garb2 of View
	(properties
		x 181
		y 180
		z 50
		noun 16
		view 235
		loop 6
		cel 3
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: 16 4 0 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance garb3 of View
	(properties
		x 170
		y 190
		z 50
		noun 16
		view 235
		loop 6
		cel 4
		priority 9
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gTestMessager say: 16 4 0 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance elevButtonLight of View
	(properties
		x 167
		y 91
		noun 19
		view 230
		loop 3
	)
)

(instance elevLighttr of View
	(properties
		x 143
		y 125
		view 230
		loop 2
	)
	
	(method (init)
		(self ignoreActors: 1 setPri: 3)
		(super init:)
	)
)

(instance elevLightbl of View
	(properties
		x 115
		y 139
		view 230
		loop 2
		cel 2
		priority 8
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1 setPri: 8)
		(super init:)
	)
)

(instance elevLightbr of View
	(properties
		x 150
		y 138
		view 230
		loop 2
		cel 3
	)
	
	(method (init)
		(self ignoreActors: 1 setPri: 8)
		(super init:)
	)
)

(instance elevLighttl of View
	(properties
		x 113
		y 127
		view 230
		loop 2
		cel 1
		priority 3
		signal $4010
	)
	
	(method (init)
		(self ignoreActors: 1 setPri: 3)
		(super init:)
	)
)

(instance redCross of Prop
	(properties
		x 169
		y 175
		view 233
		loop 2
		priority 15
		signal $0010
	)
	
	(method (init)
		(self
			setCycle: RandCycle
			ignoreActors:
			setScript: sCycleLights
		)
		(super init:)
	)
)

(instance emptyTrash of Feature
	(properties
		x 206
		y 85
		noun 20
		nsTop 85
		nsLeft 194
		nsBottom 122
		nsRight 219
		sightAngle 40
	)
	
	(method (init)
		(if (or (proc0_1 35) (proc0_1 36))
			(self noun: 16)
		else
			(self noun: 20)
		)
		(super init: &rest)
	)
)

(instance pipes of Feature
	(properties
		x 253
		y 135
		noun 8
		nsTop 106
		nsLeft 233
		nsBottom 165
		nsRight 274
		sightAngle 40
	)
)

(instance blobReach of Feature
	(properties
		x 119
		y 225
		z 100
		nsTop 121
		nsLeft 94
		nsBottom 133
		nsRight 125
		sightAngle 40
		approachX 114
		approachY 129
	)
	
	(method (init)
		(if (> (eureka puke?) 5) (super init: &rest))
	)
)

(instance serviceTunnel of Feature
	(properties
		x 152
		y 98
		noun 6
		nsTop 91
		nsLeft 146
		nsBottom 106
		nsRight 158
		sightAngle 40
		approachX 141
		approachY 115
		approachDist 1
	)
	
	(method (init)
		(self approachVerbs: 4 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					(
					(and (== (eureka puke?) 7) (== (gEgo view?) 239)) (global2 setScript: sPukeRoger))
					(
						(or
							(not (gOldCast contains: (ScriptID 227 0)))
							(!= ((ScriptID 227 0) view?) 241)
						)
						(global2 setScript: sExitEast)
					)
					(else (gTestMessager say: noun 4 1 1))
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance elevButton of Feature
	(properties
		x 195
		y 120
		noun 19
		nsTop 91
		nsLeft 168
		nsBottom 95
		nsRight 172
		sightAngle 0
		approachX 154
		approachY 124
		approachDist 10
	)
	
	(method (init)
		(self approachVerbs: 4 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if
				(and (== (eureka puke?) 7) (== (gEgo view?) 239))
					(global2 setScript: sPukeRoger)
				else
					(global2 setScript: sPushElev)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance toolBox of Feature
	(properties
		x 97
		y 150
		noun 21
		onMeCheck $0002
		approachX 120
		approachY 155
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if
				(and (== (eureka puke?) 7) (== (gEgo view?) 239))
					(global2 setScript: sPukeRoger)
				else
					(global2 newRoom: 226)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garbageButton of Feature
	(properties
		x 186
		y 97
		noun 14
		nsTop 92
		nsLeft 184
		nsBottom 103
		nsRight 189
		sightAngle 40
		approachX 165
		approachY 138
		approachDist 10
	)
	
	(method (init)
		(self approachVerbs: 4 1)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					((== (eureka puke?) 7)
						(if (== (gEgo view?) 239)
							(global2 setScript: sPukeRoger)
						)
					)
					(
						(and
							(not (proc0_1 30))
							(or (proc0_1 35) (proc0_1 36))
							(== (eureka garbage?) 0)
						)
						(global2 setScript: sGarbageFalls)
					)
					(else (global2 setScript: sOpenGarbageDoors))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorSound of Sound
	(properties)
)

(instance northDoor of Prop
	(properties
		x 120
		y 106
		noun 3
		approachX 121
		approachY 110
		view 233
	)
	
	(method (init)
		(self
			ignoreActors: 1
			approachVerbs: 4 3
			setPri: 4
			stopUpd:
			cel: (if (proc999_5 gGModNum 100 200) (self lastCel:) else 0)
		)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (and (== (eureka puke?) 7) (not local2))
					(global2 setScript: sPukeRoger)
				else
					(global2 setScript: sExitNorth)
				)
			)
			(4
				(if (and (== (eureka puke?) 7) (not local2))
					(global2 setScript: sPukeRoger)
				else
					(global2 setScript: sExitNorth)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (setCycle theCycler)
		(if theCycler (doorSound number: 103 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
)

(instance scienceDoor of Prop
	(properties
		x 79
		y 137
		noun 9
		view 233
		loop 1
	)
	
	(method (init)
		(self
			approachX: 96
			approachY: 133
			setPri: 5
			stopUpd:
			cel: (if (== gGModNum 240) (self lastCel:) else 0)
			approachVerbs: 4 3
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(doorSound dispose:)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(global2 setScript: sExitWest)
			)
			(4
				(if (and (== (eureka puke?) 7) (not local2))
					(global2 setScript: sJumpRoger)
				else
					(global2 setScript: sExitWest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (setCycle theCycler)
		(if theCycler (doorSound number: 103 loop: 1 play:))
		(super setCycle: theCycler &rest)
	)
)

(instance openDoor of Feature
	(properties
		x 79
		y 207
		z 100
		noun 9
		nsTop 90
		nsLeft 65
		nsBottom 125
		nsRight 95
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: sJumpRoger)
			)
			(3
				(global2 setScript: sJumpRoger)
			)
			(else  (super doVerb: theVerb))
		)
	)
)
