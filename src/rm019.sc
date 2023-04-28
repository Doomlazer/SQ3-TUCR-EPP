;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use Intrface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm019 0
)

(local
	local0
	saveBits1
	saveBits2
	saveBits3
	saveBits4
	saveBits5
	[str1 49]
	[str2 50]
	[str3 50]
	local155
)
(procedure (localproc_000c param1 param2)
	(if (< numColors 16) (= param2 15))
	(= saveBits1
		(Display
			param1
			dsWIDTH
			135
			dsALIGN
			1
			dsCOORD
			168
			12
			dsCOLOR
			param2
			dsFONT
			600
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_003c param1)
	(Display 19 1 108 param1)
	(RedrawCast)
)

(instance rm019 of Room
	(properties
		picture 19
		picAngle 1
	)
	
	(method (init &tmp [temp0 50])
		(HandsOff)
		(User mapKeyToDir: 0)
		(self setRegions: 701)
		(HandsOff)
		(if (> numColors 4)
			(Load rsPIC 191)
		else
			(Load rsPIC 300)
		)
		(Load rsVIEW 49)
		(Load rsVIEW 50)
		(Load rsVIEW 212)
		(Load rsSOUND 25)
		(super init:)
		(if
		(and (== currentSector 75) (not selectedSector))
			(= global161 3)
			(= gGEgoY_5 7)
			(= global163 3)
			(= global164 7)
			(= scanningSector 75)
		)
		(controls
			add: scanBut courseBut returnBut
			eachElementDo: #init
			draw:
		)
		(self setScript: rmScript)
		(scanner play:)
	)
	
	(method (doit)
		(if global167 (curRoom newRoom: 17))
		(super doit:)
	)
	
	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if
		(or (!= (event type?) evSAID) (event claimed?))
			(return)
		)
	)
	
	(method (newRoom newRoomNumber)
		(scanner stop:)
		(HandsOn)
		(User mapKeyToDir: 1)
		(timers eachElementDo: #dispose 84)
		(if saveBits2
			(localproc_003c saveBits2)
			(= saveBits2 0)
		)
		(if saveBits1
			(localproc_003c saveBits1)
			(= saveBits1 0)
		)
		(if saveBits3
			(localproc_003c saveBits3)
			(= saveBits3 0)
		)
		(if saveBits4
			(localproc_003c saveBits4)
			(= saveBits4 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(scanBut state: 0 draw:)
				(courseBut state: 0 draw:)
				(returnBut state: 0 draw:)
				(= cycles 6)
			)
			(1
				(if (> numColors 4)
					(curRoom overlay: 191 1)
				else
					(curRoom overlay: 300 1)
				)
				(= cycles 2)
			)
			(2
				(= saveBits2
					(Display
						19
						0
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(scanBut state: 1 draw:)
				(courseBut draw:)
				(returnBut state: 1 draw:)
				(scanBox init:)
				(you init:)
				(= cycles 2)
			)
			(3
				(if selectedSector
					(= saveBits2
						(Display
							(Format @str2 {DESTINATION: SECTOR %d} selectedSector)
							dsWIDTH
							135
							dsALIGN
							1
							dsCOORD
							168
							3
							dsCOLOR
							9
							dsFONT
							600
							dsSAVEPIXELS
						)
					)
				)
				(curRoom setScript: 0)
			)
		)
	)
)

(instance scanScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(if saveBits2
					(localproc_003c saveBits2)
					(= saveBits2 0)
				)
				(cond 
					(
						(and
							(!= scanningSector 23)
							(!= scanningSector 27)
							(!= scanningSector 39)
							(!= scanningSector 62)
							(!= scanningSector 70)
							(!= scanningSector 82)
							(!= scanningSector 69)
						)
						(self changeState: 2)
					)
					(
					(and (== scanningSector 69) (not forceBeamDestroyed)) (self changeState: 2))
					(local0 (= local0 0) (self changeState: 2))
					(else
						(if
							(!=
								saveBits5
								(Format @str3 {SCANNING SECTOR %d} scanningSector)
							)
							(= saveBits5
								(Format @str3 {SCANNING SECTOR %d} scanningSector)
							)
							(if saveBits1
								(localproc_003c saveBits1)
								(= saveBits1 0)
							)
						)
						(scanBox setCycle: Forward)
						(scanBut state: 0 cel: 2 draw:)
						(returnBut state: 0 cel: 1 draw:)
						(= cycles 10)
					)
				)
			)
			(1
				(localproc_000c
					(Format @str3 {SCANNING SECTOR %d} scanningSector)
					14
				)
				(curRoom setScript: zoomScript)
			)
			(2 (= cycles 1))
			(3
				(if (< scanningSector 108)
					(++ scanningSector)
				else
					(= scanningSector 1)
				)
				(= global164 (/ scanningSector 12))
				(if
				(> (= global163 (- scanningSector (* global164 12))) 0)
					(++ global164)
				else
					(= global163 12)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance zoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(scanBut cel: 2 state: 0 draw:)
				(returnBut cel: 1 state: 0 draw:)
				(courseBut cel: 1 state: 0 draw:)
				(scanBox
					view:
						(cond 
							((== scanningSector 23) 401)
							((== scanningSector 27) 401)
							((== scanningSector 70) 401)
							(else 50)
						)
					setLoop:
						(cond 
							((== scanningSector 82) 1)
							((== scanningSector 39) 2)
							((== scanningSector 62) 3)
							((== scanningSector 69) 5)
							((== scanningSector 23) 6)
							((== scanningSector 27) 1)
							((== scanningSector 70) 3)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: EndLoop self
				)
				(you hide:)
			)
			(1
				(returnBut cel: 0 state: 1 draw:)
				(courseBut cel: 0 state: 1 draw:)
				(scanBut cel: 1 state: 1 draw:)
				(Timer setCycle: self 2)
			)
			(2
				(if saveBits1
					(localproc_003c saveBits1)
					(= saveBits1 0)
				)
				(= saveDisabled 1)
				(= saveBits3
					(Display
						(cond 
							((== scanningSector 23)
								{NAME:\n AQUAVELVEETA\nSECTOR: 23\n\nNEWLY FORMED\nFULL SERVICE PLANET}
							)
							((== scanningSector 27)
								{NAME:\n REN\nSECTOR: 27\n\nTOURIST DESTINATION:\n Operated by:\n Honest Stone LLC.\n Limited amenities\n}
							)
							((== scanningSector 39)
								{NAME:\n PLANET PHLEEBHUT\nSECTOR: 39\n\nLIGHT ATMOSPHERE\n1 KNOWN SETTLEMENT}
							)
							((== scanningSector 62)
								{NAME:\n MONOLITH BURGER FAST FOOD DIVE\nSECTOR: 62\n\nA FINITE\nNUMBER SERVED}
							)
							((== scanningSector 69)
								{NAME:\n PESTULON\nSECTOR: 69\nHABITANTS: UNKNOWN\nSURFACE UNCHARTED.\nIT FIGURES...}
							)
							((== scanningSector 70)
								{NAME:\n QUIRK's BAR\nSECTOR: 70\nHABITANTS: \nVILE SCUMM\nOVERPRICED DRINKS.\nGAMBLING.}
							)
							((== scanningSector 82)
								{NAME:\n PLANET ORTEGA\nSECTOR: 82\nHABITANTS: UNKNOWN\nVOLCANIC CRATER-STREWN\nSURFACE}
							)
						)
						dsWIDTH
						(if (< global163 7) 220 else 91)
						dsCOORD
						(if (< global163 7)
							(+ (* (- global163 1) 25) 62)
						else
							(- (* (- global163 1) 25) 111)
						)
						(+ (* (- global164 1) 18) 6)
						dsFONT
						600
						dsCOLOR
						12
						dsSAVEPIXELS
					)
				)
			)
			(3
				(scanBox setCycle: BegLoop self)
				(if saveBits1
					(localproc_003c saveBits1)
					(= saveBits1 0)
				)
				(if saveBits3
					(localproc_003c saveBits3)
					(= saveBits3 0)
				)
				(= saveDisabled 0)
			)
			(4
				(scanBox setLoop: 0)
				(= local0 1)
				(curRoom setScript: scanScript)
				(you show:)
			)
		)
	)
)

(instance courseScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 49])
		(switch (= state newState)
			(0
				(if saveBits2
					(localproc_003c saveBits2)
					(= saveBits2 0)
				)
				(= gGEgoY_5 (/ currentSector 12))
				(if
				(> (= global161 (- currentSector (* gGEgoY_5 12))) 0)
					(++ gGEgoY_5)
				else
					(= global161 12)
				)
				(if (> global163 global161) (= global165 1))
				(if (< global163 global161) (= global165 -1))
				(if (== global163 global161) (= global165 0))
				(if (> global164 gGEgoY_5) (= global166 1))
				(if (< global164 gGEgoY_5) (= global166 -1))
				(if (== global164 gGEgoY_5) (= global166 0))
				(= seconds 2)
			)
			(1
				(= temp0
					(if (== scanningSector currentSector)
						{COURSE ALREADY ACHIEVED}
					else
						{STANDBY\nCALCULATING COURSE}
					)
				)
				(if (!= scanningSector currentSector)
					(= selectedSector scanningSector)
				)
				(if saveBits1
					(localproc_003c saveBits1)
					(= saveBits1 0)
				)
				(= saveBits4
					(Display
						temp0
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(if (== temp0 {COURSE ALREADY ACHIEVED})
					(scanBut state: 0 cel: 2 draw:)
					(courseBut state: 0 cel: 1 draw:)
					(returnBut state: 0 cel: 1 draw:)
					(= state 5)
				)
				(= seconds 3)
			)
			(2
				(if saveBits4
					(localproc_003c saveBits4)
					(= saveBits4 0)
				)
				(if (!= scanningSector currentSector) (= cycles 2))
			)
			(3
				(= saveBits4
					(Display
						{COURSE LOCKED}
						dsWIDTH
						135
						dsALIGN
						1
						dsCOORD
						168
						3
						dsCOLOR
						9
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(4
				(if saveBits4
					(localproc_003c saveBits4)
					(= saveBits4 0)
				)
				(= cycles 1)
			)
			(5
				(localproc_003c
					(Format @str2 {DESTINATION: SECTOR %d} selectedSector)
				)
				(= global220 local155)
				(curRoom newRoom: 17)
			)
			(6 (curRoom newRoom: 17))
		)
	)
)

(instance scanBut of DIcon
	(properties
		state $0001
		nsTop 3
		nsLeft 7
		key 49
	)
	
	(method (init)
		(super init:)
		(= view (if (> numColors 4) 49 else 149))
	)
	
	(method (doit)
		(self cel: 3 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(returnBut state: 0 cel: 1 draw:)
		(if (< (scanBox cel?) 2)
			(scanBox startUpd: setLoop: 0 setCel: 0 setCycle: 0)
			(= local155 global220)
			(= global220 0)
			(curRoom setScript: scanScript)
		else
			(zoomScript changeState: 3)
		)
	)
)

(instance courseBut of DIcon
	(properties
		nsTop 3
		nsLeft 60
		key 50
		loop 3
		cel 1
	)
	
	(method (init)
		(super init:)
		(= view (if (> numColors 4) 49 else 149))
	)
	
	(method (doit)
		(if (!= scanningSector currentSector)
			(self cel: 2 state: 0 draw:)
			(scanBut state: 0 cel: 2 draw:)
			(returnBut state: 0 cel: 1 draw:)
		)
		(curRoom setScript: courseScript)
	)
)

(instance returnBut of DIcon
	(properties
		state $0001
		nsTop 3
		nsLeft 113
		key 51
		loop 4
	)
	
	(method (init)
		(super init:)
		(= view (if (> numColors 4) 49 else 149))
	)
	
	(method (doit)
		(self cel: 2 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(scanBut state: 0 cel: 2 draw:)
		(curRoom newRoom: 17)
	)
)

(instance scanBox of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32)
			setPri: 13
			setCel: 0
			setLoop: 0
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(self
			posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32)
		)
	)
)

(instance you of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global161 1) 25) 22) (+ (* (- gGEgoY_5 1) 18) 32)
			setPri: 14
			setLoop: 4
			ignoreActors: 1
		)
	)
	
	(method (doit)
		(super doit:)
		(self
			posn: (+ (* (- global161 1) 25) 22) (+ (* (- gGEgoY_5 1) 18) 32)
		)
	)
)

(instance scanner of Sound
	(properties
		number 25
		priority 1
		loop -1
	)
)
