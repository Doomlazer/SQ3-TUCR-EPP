;;; Sierra Script 1.0 - (do not remove this comment)
(script# 10)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use ClickMenu)
(use Class_948_0)
(use CueObj)
(use SysWindow)
(use User)
(use View)
(use Obj)

(public
	debugHandler 0
)

(local
	[local0 27]
)
(procedure (localproc_0052)
	(if (proc999_5 (global2 style?) 11 12 13 14)
		(global2 drawPic: (global2 picture?) 100 style: 100)
	)
)

(instance debugHandler of Feature
	(properties)
	
	(method (init)
		(super init:)
		(gOldMH addToFront: self)
		(gOldKH addToFront: self)
	)
	
	(method (dispose)
		(gOldMH delete: self)
		(gOldKH delete: self)
		(super dispose:)
		(DisposeScript 10)
	)
	
	(method (handleEvent pEvent &tmp [temp0 160] temp160 newEvent gOldCastFirst theGFont temp164 temp165 temp166 temp167 temp168 temp169 temp170 temp171 temp172 userAlterEgo temp174 temp175 temp176 temp177 temp178)
		(return
			(switch (pEvent type?)
				(evKEYBOARD
					(pEvent claimed: 1)
					(if
						(and
							(not (FileIO fiEXISTS {880.scr}))
							(not
								(proc999_5
									(pEvent message?)
									11776
									4608
									8960
									9216
									9472
									12544
									6144
									6400
									4864
									12032
								)
							)
						)
						(return 1)
					)
					(switch (pEvent message?)
						(KEY_ALT_a
							(= gOldCastFirst (gOldCast first:))
							(while gOldCastFirst
								(= temp164 (NodeValue gOldCastFirst))
								(Format
									@temp0
									10
									1
									((temp164 -super-?) name?)
									(temp164 view?)
									(temp164 loop?)
									(temp164 cel?)
									(temp164 x?)
									(temp164 y?)
									(temp164 z?)
									(temp164 heading?)
									(temp164 priority?)
									(temp164 signal?)
									(if (temp164 isKindOf: Actor)
										(temp164 illegalBits?)
									else
										-1
									)
								)
								(if
									(not
										(Print
											addText:
												@temp0
												(CelWide
													(temp164 view?)
													(temp164 loop?)
													(temp164 cel?)
												)
												0
											window: SysWindow
											addTitle: (temp164 name?)
											addIcon: (temp164 view?) (temp164 loop?) (temp164 cel?) 0 0
											init:
										)
									)
									(break)
								)
								(= gOldCastFirst (gOldCast next: gOldCastFirst))
							)
						)
						(KEY_ALT_b (PolyEdit doit:))
						(KEY_ALT_c
							(localproc_0052)
							(Show 4)
						)
						(KEY_ALT_e
							(Format
								@temp0
								10
								2
								(gEgo name?)
								(gEgo view?)
								(gEgo loop?)
								(gEgo cel?)
								(gEgo x?)
								(gEgo y?)
								(gEgo z?)
								(gEgo heading?)
								(gEgo priority?)
								(gEgo signal?)
								(gEgo illegalBits?)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							(Print
								addText: @temp0
								addIcon: (gEgo view?) (gEgo loop?) (gEgo cel?)
								init:
							)
						)
						(KEY_ALT_g
							(= temp0 0)
							(proc921_2 @temp0 6 {Variable No.})
							(= gOldCastFirst (ReadNumber @temp0))
							(= temp0 0)
							(proc921_2 @temp0 6 {Value})
							(= [gEgo gOldCastFirst] (ReadNumber @temp0))
							(= temp0 0)
						)
						(KEY_ALT_h
							(= temp0 0)
							(Print
								addText: {Global number:}
								addEdit: @temp0 6 0 12
								init:
							)
							(= gOldCastFirst (ReadNumber @temp0))
							(if (IsObject [gEgo gOldCastFirst])
								(Format
									@temp0
									{ Global %d: %s_}
									gOldCastFirst
									([gEgo gOldCastFirst] name?)
								)
							else
								(Format
									@temp0
									{ Global %d: %d_}
									gOldCastFirst
									[gEgo gOldCastFirst]
								)
							)
							(proc921_0 @temp0)
						)
						(KEY_ALT_i
							((ScriptID 16 0) doit:)
						)
						(KEY_ALT_j
							(= gOldCastFirst 0)
							(while (< gOldCastFirst (gOldCast size?))
								(if
									(not
										(&
											((= temp164 (gOldCast at: gOldCastFirst)) signal?)
											$0004
										)
									)
									(Format
										@temp0
										10
										1
										((temp164 -super-?) name?)
										(temp164 view?)
										(temp164 loop?)
										(temp164 cel?)
										(temp164 x?)
										(temp164 y?)
										(temp164 z?)
										(temp164 heading?)
										(temp164 priority?)
										(temp164 signal?)
										(if (temp164 isKindOf: Actor)
											(temp164 illegalBits?)
										else
											-1
										)
									)
									(Print
										addText:
											@temp0
											(CelWide
												(temp164 view?)
												(temp164 loop?)
												(temp164 cel?)
											)
											0
										window: SysWindow
										addTitle: (temp164 name?)
										addIcon: (temp164 view?) (temp164 loop?) (temp164 cel?) 0 0
										init:
									)
								)
								(++ gOldCastFirst)
							)
						)
						(KEY_ALT_k
							(= temp160 (GetPort))
							(SetPort 0)
							(= temp171 5)
							(= temp172 16)
							(= temp167 15)
							(= temp168 80)
							(= temp170 (+ temp167 (* 34 temp171)))
							(= temp169 (+ temp168 (* 10 temp172)))
							(= temp165
								(Graph grSAVE_BOX temp167 temp168 temp170 temp169 1)
							)
							(Graph grFILL_BOX temp167 temp168 temp170 temp169 1 255)
							(= temp166 0)
							(while (< temp166 256)
								(Graph
									grFILL_BOX
									(+ temp167 temp171 (* temp171 (/ temp166 8)))
									(+ temp168 temp172 (* 16 (mod temp166 8)))
									(+ temp167 temp171 temp171 (* temp171 (/ temp166 8)))
									(+ temp168 temp172 temp172 (* temp172 (mod temp166 8)))
									1
									temp166
								)
								(++ temp166)
							)
							(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
							(repeat
								(if
									(or
										(== ((= newEvent (Event new:)) type?) 1)
										(== (newEvent type?) 4)
									)
									(break)
								)
								(newEvent dispose:)
							)
							(newEvent dispose:)
							(Graph grRESTORE_BOX temp165)
							(Graph grUPDATE_BOX temp167 temp168 temp170 temp169 1)
							(SetPort temp160)
						)
						(KEY_ALT_l
							(= temp0 0)
							(= gOldCastFirst (proc255_1 {Flag No.}))
							(proc0_2 gOldCastFirst)
						)
						(KEY_ALT_m
							(= temp0 0)
							(= gOldCastFirst (proc255_1 {Flag No.}))
							(proc0_3 gOldCastFirst)
						)
						(KEY_ALT_n
							(= temp0 0)
							(= gOldCastFirst (proc255_1 {Flag No.}))
							(if (proc0_1 gOldCastFirst)
								(proc921_0 {TRUE})
							else
								(proc921_0 {FALSE})
							)
						)
						(KEY_ALT_o
							((ScriptID 952) doit: @global42 0)
						)
						(KEY_ALT_p
							(localproc_0052)
							(Show 2)
						)
						(KEY_ALT_q
							(gSQ5 detailLevel: 1)
						)
						(KEY_ALT_r
							(Format
								@temp0
								10
								3
								(global2 name?)
								gModNum
								(global2 curPic?)
								(global2 style?)
								(global2 horizon?)
								(global2 north?)
								(global2 south?)
								(global2 east?)
								(global2 west?)
								(if (IsObject (global2 script?))
									((global2 script?) name?)
								else
									{..none..}
								)
							)
							(Print width: 120 addText: @temp0 init:)
							(gSQ5 showMem:)
						)
						(KEY_ALT_s
							(= temp0 0)
							(if
								(Print
									addText: {Which Format?}
									addButton: 0 {String} 0 12
									addButton: 1 {Message} 50 12
									init:
								)
								(= temp174 (proc255_1 {Noun?} 0))
								(= temp175 (proc255_1 {Verb?} 0))
								(= temp176 (proc255_1 {Case?} 0))
								(= temp177 (proc255_1 {Sequence?} 0))
								(Message msgGET temp174 temp175 temp176 temp177 @temp0)
							else
								(proc921_2 @temp0 50 {String to display?})
							)
							(= temp167 (proc255_1 {Y Parameter?} 0))
							(= temp168 (proc255_1 {X Parameter?} 0))
							(= gOldCastFirst (proc255_1 {Box Width?} 0))
							(if
							(not (= theGFont (proc255_1 {Font Number?} 0)))
								(= theGFont gFont)
							)
							(Print
								posn: temp168 temp167
								width: gOldCastFirst
								font: theGFont
								addText: @temp0
								init:
							)
						)
						(KEY_ALT_t
							(if gDialog (gDialog dispose:))
							(Print
								addText: {Which room do you want?}
								addEdit: @temp0 6 115 35
								init:
							)
							(if
							(and temp0 (> (= gOldCastFirst (ReadNumber @temp0)) 0))
								(global2 newRoom: gOldCastFirst)
							)
						)
						(KEY_ALT_u
							(User canInput: 1 canControl: 1)
							(gSq5IconBar enable: 0 1 2 3 5 6)
						)
						(22 (Show 1))
						(KEY_ALT_w (Class_948_0 doit:))
						(KEY_ALT_x (= global4 1))
						(KEY_ALT_v
							(Print
								addText: {Version number:} 0 0
								addText: global27 0 14
								init:
							)
						)
						(KEY_ALT_y
							(= temp167 0)
							(while (< temp167 (gOldCast size?))
								(Graph
									grFILL_BOX
									((gOldCast at: temp167) brTop?)
									((gOldCast at: temp167) brLeft?)
									((gOldCast at: temp167) brBottom?)
									((gOldCast at: temp167) brRight?)
									1
									global151
									-1
									-1
								)
								(++ temp167)
							)
						)
						(KEY_ALT_z (= global4 1))
						(KEY_QUESTION
							(proc921_0
								{Debug options:______(Page 1 of 5)\n\n___A - Show cast\n___B - Polygon editor\n___C - Show control map\n___D - Place an actor\n___E - Show ego info\n___F - Show feature outlines\n___G - Set global\n}
							)
							(proc921_0
								{Debug options:______(Page 2 of 5)\n\n___H - Show global\n___I - Get inventory item\n___J - Justify text on screen\n___K - Show palette\n___L - Set flag\n___M - Clear flag\n___N - Show flag\n}
							)
							(proc921_0
								{Debug options:______(Page 3 of 5)\n\n___O - QA Note Logger\n___P - Show priority map\n___Q - Set Detail to 1\n___R - Show room info/free memory\n___S - Show a string or message\n___T - Teleport\n___U - Give HandsOn\n}
							)
							(proc921_0
								{Debug options:______(Page 4 of 5)\n\n___V - Show visual map\n___W - Feature writer\n___Y - Stuff or Unstuff a clue\n___X,Z - Quick quit\n}
							)
							(proc921_0
								{Debug options:______(Page 5 of 5)\n\n__A=Alt, C=Ctrl, L=Left shift, R=Right shift\n\n__Left click:\n____A_______Move ego\n____CL______Show ego\n____CR______Show room\n____CA______Show position\n}
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(evMOUSEBUTTON
					(switch (pEvent modifiers?)
						(13 0)
						(14 0)
						(12
							(pEvent claimed: 1)
							(Format @temp0 10 4 (pEvent x?) (pEvent y?))
							(= temp160
								(Print
									posn: 160 10
									font: 999
									modeless: 1
									addText: @temp0
									init:
								)
							)
							(while (!= 2 ((= newEvent (Event new:)) type?))
								(newEvent dispose:)
							)
							(newEvent dispose:)
							(temp160 dispose:)
						)
						(5
							(pEvent type: 4 message: 4864)
							(self handleEvent: pEvent)
						)
						(6
							(pEvent type: 4 message: 4608)
							(self handleEvent: pEvent)
						)
						(9 0)
						(10 0)
						(emRIGHT_SHIFT 0)
						(emLEFT_SHIFT 0)
						(emCTRL 0)
						(emALT
							(pEvent claimed: 1)
							(= temp178 (gSQ5 setCursor: 996))
							(= gOldCastFirst
								((= userAlterEgo (User alterEgo?)) signal?)
							)
							(userAlterEgo startUpd:)
							(while (!= 2 ((= newEvent (Event new:)) type?))
								(userAlterEgo x: (newEvent x?) y: (- (newEvent y?) 10))
								(Animate (gOldCast elements?) 0)
								(newEvent dispose:)
							)
							(newEvent dispose:)
							(gSQ5 setCursor: temp178)
							(userAlterEgo signal: gOldCastFirst)
						)
					)
				)
			)
		)
	)
)
