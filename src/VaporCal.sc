;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include game.sh)
(use Main)
(use Intrface)
(use System)
(use Actor)


(public
	calcScript 0
)

(local)

(instance base of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 0
			setCel: 0
			ignoreActors: TRUE
			setPri: 15
			posn: 159 94
			stopUpd:
		)
	)
)

(instance t1 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 0]
			ignoreActors: TRUE
			setPri: 15
			posn: 131 63
		)
	)
)

(instance t2 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 1]
			ignoreActors: TRUE
			setPri: 15
			posn: 142 63
		)
	)
)

(instance t3 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 2]
			ignoreActors: TRUE
			setPri: 15
			posn: 153 63
		)
	)
)

(instance t4 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 3]
			ignoreActors: TRUE
			setPri: 15
			posn: 164 63
		)
	)
)
(instance t5 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 4]
			ignoreActors: TRUE
			setPri: 15
			posn: 175 63
		)
	)
)

(instance t6 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 1
			setCel: [VCtCel 5]
			ignoreActors: TRUE
			setPri: 15
			posn: 186 63
		)
	)
)

(instance b1 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 0]
			ignoreActors: TRUE
			setPri: 15
			posn: 131 91
		)
	)
)

(instance b2 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 1]
			ignoreActors: TRUE
			setPri: 15
			posn: 142 91
		)
	)
)

(instance b3 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 2]
			ignoreActors: TRUE
			setPri: 15
			posn: 153 91
		)
	)
)

(instance b4 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 3]
			ignoreActors: TRUE
			setPri: 15
			posn: 164 91
		)
	)
)

(instance b5 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 4]
			ignoreActors: TRUE
			setPri: 15
			posn: 175 91
		)
	)
)

(instance b6 of Prop
	
	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 2
			setCel: [VCbCel 5]
			ignoreActors: TRUE
			setPri: 15
			posn: 186 91
		)
	)
)

(instance calcScript of Script
	(properties)
	
	(method (init)
		(base init:)
		(t1 init:)
		(t2 init:)
		(t3 init:)
		(t4 init:)
		(t5 init:)
		(t6 init:)
		(b1 init:)
		(b2 init:)
		(b3 init:)
		(b4 init:)
		(b5 init:)
		(b6 init:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed?) (return))
		(switch (event type?)
			(mouseDown
				(event claimed: TRUE)
				(if
					(and
						(>= (event x?) 120)
						(<= (event x?) 197)
						(>= (event y?) 52)
						(<= (event y?) 94)
					)
					;(Printf {x: %d, y: %d} (event x?) (event y?))
					(cond
						(;column 1
							(and
								(>= (event x?) 127)
								(<= (event x?) 135)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t1 cel?) 0))	
									)
									;t1 top
									(t1 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t1 cel?) 1))	
									)
									;t1 mid
									(t1 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t1 cel?) 2))	
									)
									;t1 bottom
									(t1 cel: 2)
								)
								;b1
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b1 cel?) 0))	
									)
									;b1 top
									(b1 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b1 cel?) 1))	
									)
									;b1
									(b1 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b1 cel?) 2))	
									)
									;b1
									(b1 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b1 cel?) 3))	
									)
									;b1
									(b1 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b1 cel?) 4))	
									)
									;b1
									(b1 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b1 cel?) 5))	
									)
									;b1 bottom
									(b1 cel: 5)
								)	
							)
						)
						(;column 2
							(and
								(>= (event x?) 138)
								(<= (event x?) 146)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t2 cel?) 0))	
									)
									;t2 top
									(t2 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t2 cel?) 1))	
									)
									;t2 mid
									(t2 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t2 cel?) 2))	
									)
									;t2 bottom
									(t2 cel: 2)
								)
								;b1
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b2 cel?) 0))	
									)
									;b2 top
									(b2 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b2 cel?) 1))	
									)
									;b2
									(b2 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b2 cel?) 2))	
									)
									;b2
									(b2 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b2 cel?) 3))	
									)
									;b2
									(b2 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b2 cel?) 4))	
									)
									;b2
									(b2 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b2 cel?) 5))	
									)
									;b2 bottom
									(b2 cel: 5)
								)	
							)
						)
						(;column 3
							(and
								(>= (event x?) 149)
								(<= (event x?) 157)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t3 cel?) 0))	
									)
									;t3 top
									(t3 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t3 cel?) 1))	
									)
									;t3 mid
									(t3 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t3 cel?) 2))	
									)
									;t3 bottom
									(t3 cel: 2)
								)
								;b1
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b3 cel?) 0))	
									)
									;b3 top
									(b3 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b3 cel?) 1))	
									)
									;b3
									(b3 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b3 cel?) 2))	
									)
									;b3
									(b3 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b3 cel?) 3))	
									)
									;b3
									(b3 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b3 cel?) 4))	
									)
									;b3
									(b3 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b3 cel?) 5))	
									)
									;b3 bottom
									(b3 cel: 5)
								)	
							)
						)
						(;column 4
							(and
								(>= (event x?) 160)
								(<= (event x?) 168)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t4 cel?) 0))	
									)
									;t4 top
									(t4 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t4 cel?) 1))	
									)
									;t4 mid
									(t4 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t4 cel?) 2))	
									)
									;t4 bottom
									(t4 cel: 2)
								)
								;b4
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b4 cel?) 0))	
									)
									;b4 top
									(b4 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b4 cel?) 1))	
									)
									;b4
									(b4 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b4 cel?) 2))	
									)
									;b4
									(b4 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b4 cel?) 3))	
									)
									;b4
									(b4 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b4 cel?) 4))	
									)
									;b4
									(b4 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b4 cel?) 5))	
									)
									;b4 bottom
									(b4 cel: 5)
								)	
							)
						)
						(;column 5
							(and
								(>= (event x?) 171)
								(<= (event x?) 179)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t5 cel?) 0))	
									)
									;t5 top
									(t5 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t5 cel?) 1))	
									)
									;t5 mid
									(t5 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t5 cel?) 2))	
									)
									;t5 bottom
									(t5 cel: 2)
								)
								;b1
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b5 cel?) 0))	
									)
									;b5 top
									(b5 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b5 cel?) 1))	
									)
									;b5
									(b5 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b5 cel?) 2))	
									)
									;b5
									(b5 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b5 cel?) 3))	
									)
									;b5
									(b5 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b5 cel?) 4))	
									)
									;b5
									(b5 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b5 cel?) 5))	
									)
									;b5 bottom
									(b5 cel: 5)
								)	
							)
						)
						(;column 6
							(and
								(>= (event x?) 182)
								(<= (event x?) 190)
							)
							(cond
								(
									(and
										(>= (event y?) 54)
										(<= (event y?) 58)
										(not (== (t6 cel?) 0))	
									)
									;t6 top
									(t6 cel: 0)
								)
								(
									(and
										(>= (event y?) 58)
										(<= (event y?) 60)
										(not (== (t6 cel?) 1))	
									)
									;t6 mid
									(t6 cel: 1)
								)
								(
									(and
										(>= (event y?) 61)
										(<= (event y?) 64)
										(not (== (t6 cel?) 2))	
									)
									;t6 bottom
									(t6 cel: 2)
								)
								;b1
								(
									(and
										(>= (event y?) 67)
										(<= (event y?) 71)
										(not (== (b6 cel?) 0))	
									)
									;b6 top
									(b6 cel: 0)
								)
								(
									(and
										(>= (event y?) 71)
										(<= (event y?) 75)
										(not (== (b6 cel?) 1))	
									)
									;b6
									(b6 cel: 1)
								)
								(
									(and
										(>= (event y?) 75)
										(<= (event y?) 79)
										(not (== (b6 cel?) 2))	
									)
									;b6
									(b6 cel: 2)
								)
								(
									(and
										(>= (event y?) 79)
										(<= (event y?) 83)
										(not (== (b6 cel?) 3))	
									)
									;b6
									(b6 cel: 3)
								)
								(
									(and
										(>= (event y?) 83)
										(<= (event y?) 87)
										(not (== (b6 cel?) 4))	
									)
									;b6
									(b6 cel: 4)
								)
								(
									(and
										(>= (event y?) 87)
										(<= (event y?) 91)
										(not (== (b6 cel?) 5))	
									)
									;b6 bottom
									(b6 cel: 5)
								)	
							)
						)
					)
				else
					(= calcOn FALSE)
				)
			)
			(keyDown
				(= calcOn FALSE)
			)
		)
	)
	
	(method (dispose)
		;(theGame setCursor: prevCur (HaveMouse))
		(HandsOn)
		(= [VCtCel 0] (t1 cel?))
		(= [VCtCel 1] (t2 cel?))
		(= [VCtCel 2] (t3 cel?))
		(= [VCtCel 3] (t4 cel?))
		(= [VCtCel 4] (t5 cel?))
		(= [VCtCel 5] (t6 cel?))
		(= [VCbCel 0] (b1 cel?))
		(= [VCbCel 1] (b2 cel?))
		(= [VCbCel 2] (b3 cel?))
		(= [VCbCel 3] (b4 cel?))
		(= [VCbCel 4] (b5 cel?))
		(= [VCbCel 5] (b6 cel?))
		(base dispose:)
		(t1 dispose:)
		(t2 dispose:)
		(t3 dispose:)
		(t4 dispose:)
		(t5 dispose:)
		(t6 dispose:)
		(b1 dispose:)
		(b2 dispose:)
		(b3 dispose:)
		(b4 dispose:)
		(b5 dispose:)
		(b6 dispose:)
	)
)
