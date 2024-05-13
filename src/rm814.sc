;;; Sierra Script 1.0 - (do not remove this comment)
(script# 814)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Wander)
(use Follow)
(use User)

(public
	Room814 0
)

(local
	dirtyTiles
	arrayCounter
	totalTiles = 78
	[ta 78]
	startX = 63
	startY = 65
	pScore
	[str 20]
	lives = 3
	deathSquares
	maxDeathSquares
	pt1
	pt2
	level = 1
	hScore1 = 100
	hScore2 = 60
	hScore3 = 30
	tilesetLoop = 4
	prevSpeed
	isPlaying
	ir
)

(procedure (Score)
	(Display
		(Format @str {Score: %d} pScore)
		p_width 50
		p_at 60 30
		p_color vBLACK
		p_font 600
	)
	(Display
		(Format @str {Tiles: %d} dirtyTiles)
		p_width 50
		p_at 210 30
		p_color vBLACK
		p_font 600
	)
	(+= pScore 1)
	(-- dirtyTiles)
	(if isPlaying
		(cleanSound number: 44 play:)
	)
	(Display
		(Format @str {Score: %d} pScore)
		p_width 50
		p_at 60 30
		p_color vYELLOW
		p_font 600
	)
	(Display
		(Format @str {Tiles: %d} dirtyTiles)
		p_width 50
		p_at 210 30
		p_color vYELLOW
		p_font 600
	)
)

(procedure (ResetScore)
	(Display
		(Format @str {Score: %d} pScore)
		p_width 50
		p_at 60 30
		p_color vBLACK
		p_font 600
	)
	(Display
		(Format @str {Tiles: %d} dirtyTiles)
		p_width 50
		p_at 210 30
		p_color vBLACK
		p_font 600
	)
	(= pScore 0)
	(= dirtyTiles 0)
	(= maxDeathSquares 0)
	(= level 1)
	(= tilesetLoop 4)
	(Display
		(Format @str {Score: %d} pScore)
		p_width 50
		p_at 60 30
		p_color vYELLOW
		p_font 600
	)
	(Display
		(Format @str {Tiles: %d} dirtyTiles)
		p_width 50
		p_at 210 30
		p_color vYELLOW
		p_font 600
	)
)

(instance hero of Actor
	
	(method (doit)
		(super doit:)
		(if (ego inRect:
				(self nsLeft?)
				(- (self nsBottom?) 5)
				(self nsRight?)
				(self nsBottom?)
			)
			(curRoom setScript: gameOverScript)
		)
	)
)

(instance hero2 of Actor
	
	(method (doit)
		(super doit:)
		(if (ego inRect:
				(self nsLeft?)
				(- (self nsBottom?) 5)
				(self nsRight?)
				(self nsBottom?)
			)
			(curRoom setScript: gameOverScript)
		)
	)
)

(instance chaseEnemy of Actor
	
	(method (doit)
		(super doit:)
		(if (ego inRect:
				(self nsLeft?)
				(- (self nsBottom?) 5)
				(self nsRight?)
				(self nsBottom?)
			)
			(self setMotion: 0)
			(curRoom setScript: gameOverScript)
		)
	)
)

(instance Room814 of Room
	(properties
		picture scriptNumber
	)
	
	(method (init &tmp temp0)
		(super init:)
		(= prevSpeed (theGame setSpeed: 1)) ;store old speed and set to max ScummVM speed
		(hero
			view: 128
			ignoreHorizon:
			illegalBits: cWHITE
			setCycle: Forward
			setMotion: Wander
			setPri: 13
			x: 120
			y: 155
			init:
		)
		(hero2
			view: 128
			loop: 1
			ignoreHorizon:
			illegalBits: cWHITE
			setCycle: Forward
			setMotion: 0
			setPri: 13
			x: 200
			y: 155
			init:
		)
		(chaseEnemy
			view: 292 ;tiny roger
			ignoreHorizon:
			illegalBits: cWHITE
			setCycle: Walk
			setMotion: 0
			setPri: 13
			setStep: 1 1
			x: 160
			y: 155
			init:
		)
		(ego
			view: 814
			ignoreHorizon:
			illegalBits: cWHITE
			setCycle: Walk
			setPri: 13
			x: 160
			y: 40
			init:
		)
		(while (< arrayCounter totalTiles)
			(if (= temp0 (Random 0 3))
				(++ dirtyTiles) 
			)
			((= [ta arrayCounter] (Actor new:))
				view: 814
				loop: tilesetLoop
				cel: temp0
				ignoreHorizon:
				ignoreActors:
				illegalBits: 0
				setPri: 7
				x: startX
				y: startY
				addToPic:
			)  
			(+= startX 16)
			(if (> startX 260)
				(= startX 63)
				(+= startY 16)
			)
			(++ arrayCounter)
		)
		(Display
			(Format @str {Score: %d} pScore)
			p_width 50
			p_at 60 30
			p_color vBLACK
			p_font 600
		)
		(Display
			(Format @str {Tiles: %d} dirtyTiles)
			p_width 50
			p_at 210 30
			p_color vBLACK
			p_font 600
		)
		;(Printf {Clean %d dirty tiles.} dirtyTiles)
		;(self setScript: levelScript)
		(self setScript: gameOverScript)
	)
	
	(method (handleEvent event)
		(if (event claimed?) (return))
		(switch (event type?)
			(saidEvent
				(cond 
					(
						(or
							(Said 'insert/buckazoid')
							(Said 'play/game')
						)
						(if (> buckazoids 0)
							(-- buckazoids)
							(if (< buckazoids 0)
								(ego put: iBuckazoids -1)
							)
							(ResetScore)
							(= isPlaying 1)
							(ego
								setMotion: 0
								setCycle: Walk
								setPri: 13
								x: 160
								y: 40
							)
							(DrawPic 814 0) ;-1) ;dpOPEN_INSTANTLY
							(curRoom setScript: levelChangeScript)
						else
							(Print {You don't have any buckazoids left.})
						)
					)
					((or (Said 'disembark,quit[/game,device]') (Said '/bye'))
						(= saveDisabled FALSE)
						(= inCartoon FALSE)
						(theGame setSpeed: prevSpeed) ;restore old speed
						(HandsOn)
						(curRoom newRoom: 804)
					)
				)
			)
		)
	)
)


(instance levelScript of Script
	(properties)
	
	(method (doit &tmp nsl nst nsr nsb)
		(super doit:)
		(= arrayCounter 0)
		(while (< arrayCounter totalTiles)
			(= nsl ([ta arrayCounter] nsLeft?))
			(= nst ([ta arrayCounter] nsTop?))
			(= nsr ([ta arrayCounter] nsRight?))
			(= nsb ([ta arrayCounter] nsBottom?))
			(if (ego inRect: nsl nst nsr nsb)
				(if (== ([ta arrayCounter] cel?) 4)
					;(Print {DEAD})
					(curRoom setScript: gameOverScript)
					(break)
				else
					(if (> ([ta arrayCounter] cel?) 0)
						(= [ta arrayCounter] 0)
						((= [ta arrayCounter] (Actor new:))
							view: 814
							loop: tilesetLoop
							cel: 0
							ignoreHorizon:
							ignoreActors:
							illegalBits: 0
							setPri: 7
							x: (- nsr 8)
							y: (- nsb 1)
							addToPic:
						) 
						(Score)
					)
				)
			)
			(++ arrayCounter)		
		)
		(if (== dirtyTiles 0)
			;(NewLevel)
			(++ level)
			(++ tilesetLoop)
			(if (> tilesetLoop 6)
				(= tilesetLoop 4)
			)
			(= deathSquares 0)
			(if (< maxDeathSquares 15) ;total possilbe death squares
				(++ maxDeathSquares)
			)
			(ego setMotion: 0)
			(curRoom setScript: levelChangeScript)
		)
	)
)

(instance levelChangeScript of Script
	(properties)
	
	(method (changeState newState &tmp nsl nst nsr nsb temp0)
		(= state newState)
		(switch state
			(0
				;(HandsOff)
				(User canControl: FALSE canInput: TRUE)
				(= arrayCounter 0)
				(ego posn: 160 40 setMotion: 0 show:)
				(hero posn: 120 155 setMotion: 0 show:)
				(hero2 posn: 200 155 setMotion: 0 show:)
				(chaseEnemy posn: 160 155 setMotion: 0 show:)
				(= cycles 5)
			)
			(1
				(if (not isPlaying)
					(= level (Random 2 9))
					(= tilesetLoop (Random 4 6))
					(= maxDeathSquares (Random 0 2))
					(Print {DEMO} #dispose #time 3 #at 135 27)
				)
				(self cue:)
			)
			(2
				(if (= temp0 (Random 0 4))
					(Display
						(Format @str {Tiles: %d} dirtyTiles)
						p_width 50
						p_at 210 30
						p_color vBLACK
						p_font 600
					)
					(if
						(and
							(== temp0 4) ;add death square
							(< deathSquares maxDeathSquares)
							(not pt1) ;last two tiles were NOT deathsquares
							(not pt2)
						)
						(++ deathSquares)
						(= pt2 pt1)
						(= pt1 1)
						(if isPlaying
							(cleanSound number: 5 play:)
						)
					else
						(if (== temp0 4)
							(= temp0 (Random 1 3)) ;too many deathSquares change to spill
						)
						(++ dirtyTiles)
						(if isPlaying
							(cleanSound number: 19 play:)
						)
						(Display
							(Format @str {Tiles: %d} dirtyTiles)
							p_width 50
							p_at 210 30
							p_color vYELLOW
							p_font 600
						)
						(= pt2 pt1)
						(= pt1 0)
					)
				)
				(= nsr ([ta arrayCounter] nsRight?))
				(= nsb ([ta arrayCounter] nsBottom?))
				;([ta arrayCounter] setCel: temp0)
				(= [ta arrayCounter] 0)
				((= [ta arrayCounter] (Actor new:))
					view: 814
					loop: tilesetLoop
					cel: temp0
					ignoreHorizon:
					ignoreActors:
					illegalBits: 0
					setPri: 7
					x: (- nsr 8)
					y: (- nsb 1)
					addToPic:
				) 
				(++ arrayCounter)
				(if (< arrayCounter totalTiles)
					(= state 1)
					(= cycles 1)
				else
					(= cycles 5)
				)
			)
			(3
				(if isPlaying
					(self cue:)
				else
					(= state 4) ;attract mode
					(self cue:)
				)
			)
			(4
				(User canControl: TRUE canInput: TRUE)
				(if isPlaying
					(Printf {Level: %d Dirty Tiles: %d} level dirtyTiles #dispose #time 3) ;(Printf {Clean %d dirty tiles.} dirtyTiles)
				)
				;(HandsOn)
				(hero posn: 120 155 setMotion: Wander)
				(if (> level 6)
					(hero2 posn: 200 155 setMotion: Wander)
				)
				(if (> level 3)
					(chaseEnemy posn: 160 155 setMotion: Follow ego 0)
				)
				(curRoom setScript: levelScript)
			)
			(5
				;(HandsOff)
				(User canControl: FALSE canInput: TRUE)
				(curRoom setScript: attractModeScript)
			)
		)
	)
)

(instance gameOverScript of Script
	(properties)
	
	(method (changeState newState &tmp nsl nst nsr nsb temp0)
		(= state newState)
		(switch state
			(0
				;(HandsOff)
				(User canControl: FALSE canInput: TRUE)
				(= deathSquares 0)
				(= maxDeathSquares 0)
				(= arrayCounter 0)
				(self cue:)
			)
			(1
				(if isPlaying
					(cleanSound number: 26 play:)
					(Print {GAME OVER} #time 3)
					(= isPlaying 0)
					(self cue:)
				else
;;;					(ego setMotion: 0)
;;;					(hero setMotion: 0)
;;;					(hero2 setMotion: 0)
;;;					(chaseEnemy setMotion: 0)
;;;					(= cycles 40)
					(Print {INSERT COIN} #time 3)
					(curRoom setScript: highScoresScript)
				)
			)
			(2
				(cond
					((> pScore hScore1)
						(= hScore3 hScore2)
						(= hScore2 hScore1)
						(= hScore1 pScore)
					)
					((> pScore hScore2)
						(= hScore3 hScore2)
						(= hScore2 pScore)
					)
					((> pScore hScore3)
						(= hScore3 pScore)
					)
				)
				(curRoom setScript: highScoresScript)
			)
		)
	)
)

(instance highScoresScript of Script
	(properties)
	
	(method (changeState newState &tmp nsl nst nsr nsb temp0)
		(= state newState)
		(switch state
			(0
				;(HandsOff)
				(User canControl: FALSE canInput: TRUE)
				(= arrayCounter 0)
				(ego posn: 160 40 hide:)
				(hero posn: 120 155 setMotion: 0 hide:)
				(hero2 posn: 200 155 setMotion: 0 hide:)
				(chaseEnemy posn: 160 155 setMotion: 0 hide:)
				(= cycles 5)
			)
			(1
				(self cue:)
			)
			(2
				(= nsr ([ta arrayCounter] nsRight?))
				(= nsb ([ta arrayCounter] nsBottom?))
				;([ta arrayCounter] setCel: temp0)
				(= [ta arrayCounter] 0)
				((= [ta arrayCounter] (Actor new:))
					view: 814
					loop: tilesetLoop
					cel: 5 ;black out square
					ignoreHorizon:
					ignoreActors:
					illegalBits: 0
					setPri: 7
					x: (- nsr 8)
					y: (- nsb 1)
					addToPic:
				) 
				(++ arrayCounter)
				(if (< arrayCounter totalTiles)
					(= state 1)
					(= cycles 1)
				else
					(= cycles 5)
				)
			)
			(3
				(Display
					{HIGH SCORES:}
					p_at 120 60
					p_color 12 ;vWHITE
					p_font 600
				)
				(= cycles 10)
			)
			(4
				(Display
					(Format @str {1st place: %d} hScore1)
					p_at 130 80
					p_color vGREEN
					p_font 600
				)
				(= cycles 10)
			)
			(5
				(Display
					(Format @str {2nd place: %d} hScore2)
					p_at 130 100
					p_color vYELLOW
					p_font 600
				)
				(= cycles 10)
			)
			(6
				(Display
					(Format @str {3rd place: %d} hScore3)
					p_at 130 120
					p_color vRED
					p_font 600
				)
				(= seconds 6)
			)
			(7
				(ResetScore)
				;(curRoom setScript: levelChangeScript)
				(curRoom setScript: titleScript)
			)
		)
	)
)

(instance titleScript of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(= ir 0)
				(DrawPic 815 8) ;dpOPEN_CHECKBOARD
				(= cycles 10)
			)
			(1
				(Display
					{MOP}
					p_width 100
					p_at 95 55
					p_color 12 ;4 red
					p_font 200
				)
				(cleanSound number: 44 play:)
				(= cycles 20)
			)
			(2
				(Display
					{GAME}
					p_width 100
					p_at 91 65
					p_color 12
					p_font 200
				)
				(cleanSound number: 44 play:)
				(= cycles 20)
			)
			(3
				(Display
					{INSERT COIN}
					p_width 100
					p_at 82 80
					p_color vWHITE
					p_font 600
				)
				(= cycles 20)
			)
			(4
				(Display
					{INSERT COIN}
					p_width 100
					p_at 82 80
					p_color 0
					p_font 600
				)
				(if (< ir 4)
					(= state 2)
				)
				(++ ir)
				(= cycles 20)
			)
			(5
				(DrawPic 814 0) ;-1) ;dpOPEN_INSTANTLY
				(curRoom setScript: levelChangeScript)
			)
		)
	)
)

(instance attractModeScript of Script
	(properties)
	
	(method (doit &tmp nsl nst nsr nsb)
		(super doit:)
		(= arrayCounter 0)
		(while (< arrayCounter totalTiles)
			(= nsl ([ta arrayCounter] nsLeft?))
			(= nst ([ta arrayCounter] nsTop?))
			(= nsr ([ta arrayCounter] nsRight?))
			(= nsb ([ta arrayCounter] nsBottom?))
			(if (ego inRect: nsl nst nsr nsb)
				(if (== ([ta arrayCounter] cel?) 4)
					;(Print {DEAD})
					(curRoom setScript: gameOverScript)
					(break)
				else
					(if (> ([ta arrayCounter] cel?) 0)
						(= [ta arrayCounter] 0)
						((= [ta arrayCounter] (Actor new:))
							view: 814
							loop: tilesetLoop
							cel: 0
							ignoreHorizon:
							ignoreActors:
							illegalBits: 0
							setPri: 7
							x: (- nsr 8)
							y: (- nsb 1)
							addToPic:
						) 
						(Score)
					)
				)
			)
			(++ arrayCounter)		
		)
		(if (== dirtyTiles 0)
			;(NewLevel)
			(++ level)
			(++ tilesetLoop)
			(if (> tilesetLoop 6)
				(= tilesetLoop 4)
			)
			(= deathSquares 0)
			(if (< maxDeathSquares 15) ;total possilbe death squares
				(++ maxDeathSquares)
			)
			(curRoom setScript: levelChangeScript)
		)
	)
	
	(method (changeState newState &tmp nsl nst nsr nsb temp0)
		(= state newState)
		(switch state
			(0
				;(HandsOff)
				(User canControl: FALSE canInput: TRUE)
				(ego setMotion: MoveTo (ego x?) (Random 50 140) self)
				(hero posn: 120 155 setMotion: Wander)
				(if (> level 6)
					(hero2 posn: 200 155 setMotion: Wander)
				)
				(if (> level 3)
					(chaseEnemy posn: 160 155 setMotion: Follow ego 0)
				)
			)
			(1
				(switch (Random 0 1)
					(0
						(ego setMotion: MoveTo (Random 60 250) (ego y?) self)
					)
					(1
						(ego setMotion: MoveTo (ego x?) (Random 50 140) self)
					)
				)
				(= state 0)
			)
		)
	)
)

(instance cleanSound of Sound
	(properties)
)