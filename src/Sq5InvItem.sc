;;; Sierra Script 1.0 - (do not remove this comment)
(script# 15)
(include sci.sh)
(use Main)
(use ScrollableInventory)
(use ScrollInsetWindow)
(use Print)
(use IconI)
(use InvI)
(use Obj)

(public
	invCode 0
	invWin 1
)

(class Sq5InvItem of InvI
	(properties
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 0
		modifiers $0000
		signal $0000
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		owner 0
		script 0
		value 0
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not modNum) (= modNum gModNum))
		(switch theVerb
			(1
				(if (Message msgSIZE modNum noun 1 0 1)
					(= temp1 (CelWide view loop cel))
					(= temp0 (GetPort))
					(Print
						addIcon: view loop cel 0 0
						addText: noun 1 0 1 (+ temp1 4) 0 modNum
						init:
					)
					(SetPort temp0)
				)
			)
			(4
				(if (Message msgSIZE modNum noun 4 0 1)
					(= temp0 (GetPort))
					(Print addText: noun 4 0 0 0 0 modNum init:)
					(SetPort temp0)
				else
					(= temp0 (GetPort))
					(Print addText: 0 4 0 0 0 0 modNum init:)
					(SetPort temp0)
				)
			)
			(else 
				(if (Message msgSIZE modNum noun theVerb 0 1)
					(= temp0 (GetPort))
					(Print addText: noun theVerb 0 0 0 0 modNum init:)
					(SetPort temp0)
				else
					(= temp0 (GetPort))
					(Print addText: 0 7 0 0 0 0 modNum init:)
					(SetPort temp0)
				)
			)
		)
	)
)

(instance sq5Inv of ScrollableInventory
	(properties)
	
	(method (init)
		(super init: &rest)
		(invWin
			color: 0
			back: 3
			topBordColor: 5
			lftBordColor: 4
			rgtBordColor: 2
			botBordColor: 1
			insideColor: 2
			topBordColor2: 1
			lftBordColor2: 1
			botBordColor2: 6
			rgtBordColor2: 6
		)
		(self
			add:
				Buckazoids
				Floor_Scrubber
				Safety_Cones
				Distributor_Cap
				Transporter_Fuse
				Antacid
				Ship_Opener
				Cutting_Torch
				Spike
				Oxygen_Tank
				Communicator
				Hole_Punch
				Cloaking_Device
				Space_Monkeys_Package
				Business_Card
				Genetix_Canister
				Liquid_Nitro_Tank
				Kiz_Branch
				Kiz_Fruit
				frock
				WD40_Head
				Oxygen_Mask
				Paper
			eachElementDo: #lowlightColor 2
			add: invLook invSelect invHelp invUp invDown ok
		)
		(self
			state: 2048
			upIcon: invUp
			downIcon: invDown
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			numCols: 5
			scrollAmount: 5
			dispAmount: 10
			empty: 13
			normalHeading: 15
			eachElementDo: #highlightColor 0
			eachElementDo: #modNum 15
			eachElementDo: #init
		)
	)
)

(instance invCode of Code
	(properties)
	
	(method (init)
		((= gSq5Inv sq5Inv) init:)
	)
)

(instance invWin of ScrollInsetWindow
	(properties
		priority -1
		topBordHgt 30
		botBordHgt 5
	)
	
	(method (open)
		(invLook
			nsLeft: (- (/ (- (self right?) (self left?)) 2) 84)
		)
		(invLook nsTop: 2)
		(super open: &rest)
	)
)

(instance invUp of IconI
	(properties
		view 991
		loop 5
		cel 0
		cursor 999
		maskView 991
		maskLoop 5
		maskCel 2
		lowlightColor 5
		noun 18
		helpVerb 5
	)
	
	(method (select)
		(if (super select: &rest) (gSq5Inv scroll: -1))
		(return 0)
	)
)

(instance invDown of IconI
	(properties
		view 991
		loop 6
		cel 0
		cursor 999
		maskView 991
		maskLoop 6
		maskCel 2
		lowlightColor 5
		noun 11
		helpVerb 5
	)
	
	(method (select)
		(if (super select: &rest) (gSq5Inv scroll: 1))
		(return 0)
	)
)

(instance ok of IconI
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal $0043
		lowlightColor 5
		noun 16
		helpVerb 5
	)
)

(instance invLook of IconI
	(properties
		view 991
		loop 2
		cel 0
		cursor 981
		message 1
		signal $0081
		lowlightColor 5
		noun 15
		helpVerb 5
	)
)

(instance invHand of IconI
	(properties
		view 991
		loop 0
		cel 0
		cursor 982
		message 4
		lowlightColor 5
		noun 12
		helpVerb 5
	)
)

(instance invHelp of IconI
	(properties
		view 991
		loop 1
		cel 0
		cursor 989
		message 5
		lowlightColor 5
		noun 14
		helpVerb 5
	)
)

(instance invSelect of IconI
	(properties
		view 991
		loop 4
		cel 0
		cursor 999
		lowlightColor 5
		noun 17
		helpVerb 5
	)
)

(instance Buckazoids of Sq5InvItem
	(properties
		view 900
		loop 1
		cursor 900
		message 17
		signal $0002
		noun 3
	)
)

(instance Floor_Scrubber of Sq5InvItem
	(properties
		view 901
		loop 1
		cursor 901
		message 18
		signal $0002
		noun 28
		name "Floor Scrubber"
	)
)

(instance Safety_Cones of Sq5InvItem
	(properties
		view 903
		loop 1
		cursor 903
		message 20
		signal $0002
		noun 27
		name "Safety Cones"
	)
)

(instance Distributor_Cap of Sq5InvItem
	(properties
		view 904
		loop 1
		cursor 904
		message 19
		signal $0002
		noun 7
		name "Distributor Cap"
	)
)

(instance Transporter_Fuse of Sq5InvItem
	(properties
		view 905
		loop 1
		cursor 905
		message 28
		signal $0002
		noun 9
		name "Transporter Fuse"
	)
)

(instance Antacid of Sq5InvItem
	(properties
		view 906
		loop 1
		cursor 906
		message 29
		signal $0002
		noun 1
	)
)

(instance Ship_Opener of Sq5InvItem
	(properties
		view 907
		loop 1
		cursor 907
		message 6
		signal $0002
		noun 29
		name "Ship Opener"
	)
)

(instance Cutting_Torch of Sq5InvItem
	(properties
		view 908
		loop 1
		cursor 908
		message 30
		signal $0002
		noun 31
		name "Cutting Torch"
	)
)

(instance Spike of Sq5InvItem
	(properties
		view 909
		loop 1
		cursor 909
		message 31
		signal $0002
		noun 30
	)
)

(instance Oxygen_Tank of Sq5InvItem
	(properties
		view 917
		loop 1
		cursor 917
		message 25
		signal $0002
		noun 24
		name "Oxygen Tank"
	)
)

(instance Communicator of Sq5InvItem
	(properties
		view 911
		loop 1
		cursor 911
		message 32
		signal $0002
		noun 6
	)
)

(instance Hole_Punch of Sq5InvItem
	(properties
		view 912
		loop 1
		cursor 912
		message 33
		signal $0002
		noun 26
		name "Hole Punch"
	)
)

(instance Cloaking_Device of Sq5InvItem
	(properties
		view 913
		loop 1
		cursor 913
		message 26
		signal $0002
		noun 5
		name "Cloaking Device"
	)
)

(instance Space_Monkeys_Package of Sq5InvItem
	(properties
		view 914
		loop 1
		cursor 914
		message 34
		signal $0002
		noun 21
		name "Space Monkeys Package"
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not modNum) (= modNum gModNum))
		(if (Message msgSIZE modNum noun theVerb 0 1)
			(= temp1 (CelWide 529 0 0))
			(= temp0 (GetPort))
			(Print
				addIcon: 529 0 0 0 0
				addText: noun theVerb 0 1 (+ temp1 4) 0 modNum
				init:
			)
			(SetPort temp0)
		)
	)
)

(instance Business_Card of Sq5InvItem
	(properties
		view 915
		loop 1
		cursor 915
		message 35
		signal $0002
		noun 2
		name "Business Card"
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 33)
			(if (proc999_5 gModNum 201 200 228 226 620 640)
				(= temp0 (GetPort))
				(Print addText: noun theVerb 1 1 0 0 15 init:)
				(SetPort temp0)
			else
				(gSq5Inv hide:)
				((ScriptID 2000 0) doit:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance Genetix_Canister of Sq5InvItem
	(properties
		view 916
		loop 1
		cursor 916
		message 36
		signal $0002
		noun 4
		name "Genetix Canister"
	)
)

(instance Liquid_Nitro_Tank of Sq5InvItem
	(properties
		view 910
		loop 1
		cursor 910
		message 37
		signal $0002
		noun 22
		name "Liquid Nitro Tank"
	)
)

(instance Kiz_Branch of Sq5InvItem
	(properties
		view 918
		loop 1
		cursor 918
		message 21
		signal $0002
		noun 19
		name "Kiz Branch"
	)
)

(instance Kiz_Fruit of Sq5InvItem
	(properties
		view 919
		loop 1
		cursor 919
		message 22
		signal $0002
		noun 20
		name "Kiz Fruit"
	)
)

(instance frock of Sq5InvItem
	(properties
		view 920
		loop 1
		cursor 920
		message 23
		signal $0002
		noun 8
	)
)

(instance WD40_Head of Sq5InvItem
	(properties
		view 921
		loop 1
		cursor 921
		message 38
		signal $0002
		noun 10
		name "WD40 Head"
	)
)

(instance Oxygen_Mask of Sq5InvItem
	(properties
		view 922
		loop 1
		cursor 922
		message 39
		signal $0002
		noun 23
		name "Oxygen Mask"
	)
)

(instance Paper of Sq5InvItem
	(properties
		view 923
		loop 1
		cursor 923
		message 42
		signal $0002
		noun 25
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(if (not modNum) (= modNum gModNum))
		(if (Message msgSIZE modNum noun theVerb 0 1)
			(= temp1 (CelWide 614 0 0))
			(= temp0 (GetPort))
			(Print
				addIcon: 614 0 0 0 0
				addText: noun theVerb 0 1 (+ temp1 4) 0 modNum
				init:
			)
			(SetPort temp0)
		)
	)
)
