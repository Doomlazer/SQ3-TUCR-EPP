;;; Sierra Script 1.0 - (do not remove this comment)
(script# 923)
(include sci.sh)
(use Main)
(use View)
(use Obj)


(class Inset of Code
	(properties
		picture 0
		anOverlay 0
		style $0064
		view 0
		loop 0
		cel 0
		x 0
		y 0
		priority 14
		register 0
		hideTheCast 0
		caller 0
		owner 0
		script 0
		oldCast 0
		oldFeatures 0
		oldATPs 0
		oldMH 0
		oldKH 0
		oldDH 0
		oldWH 0
		oldObstacles 0
		oldStyle 0
		inset 0
		disposeNotOnMe 0
		modNum -1
		noun 0
		insetView 0
	)
	
	(method (init theCaller theOwner theRegister)
		(= owner theOwner)
		(owner inset: self)
		(= register theRegister)
		(= caller theCaller)
		(if hideTheCast (self hideCast: 1))
		(= oldCast gOldCast)
		(= oldFeatures gOldFeatures)
		(= oldATPs gOldATPs)
		(= oldMH gOldMH)
		(= oldKH gOldKH)
		(= oldDH gOldDH)
		(= oldWH gOldWH)
		(= oldObstacles (global2 obstacles?))
		(global2 obstacles: ((List new:) add: yourself:))
		((= gOldCast (EventHandler new:)) name: {newCast} add:)
		((= gOldFeatures (EventHandler new:))
			name: {newFeatures}
			add: self
		)
		((= gOldATPs (EventHandler new:)) name: {newATPs} add:)
		((= gOldMH (EventHandler new:)) name: {newMH} add: self)
		((= gOldKH (EventHandler new:)) name: {newKH} add: self)
		((= gOldDH (EventHandler new:)) name: {newDH} add: self)
		((= gOldWH (EventHandler new:)) name: {newWH} add:)
		(gTheDoits add: self)
		(self drawInset:)
	)
	
	(method (doit)
		(if script (script doit:))
		(if (not hideTheCast) (Animate (oldCast elements?) 0))
	)
	
	(method (dispose param1 &tmp theCaller)
		(gOldFeatures delete: self)
		(gOldMH delete: self)
		(gOldKH delete: self)
		(gOldDH delete: self)
		(gOldWH delete: self)
		(gTheDoits delete: self)
		(if inset (inset dispose: 0))
		(gOldCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(gOldATPs dispose:)
		(gOldFeatures dispose:)
		(gOldMH dispose:)
		(gOldKH dispose:)
		(gOldDH dispose:)
		(gOldWH dispose:)
		((global2 obstacles?) dispose:)
		(owner inset: 0)
		(if (or (not argc) param1) (self refresh:))
		(if (or (not argc) param1)
			((= gOldATPs oldATPs) doit:)
		)
		(global2 obstacles: oldObstacles)
		(= gOldCast oldCast)
		(= gOldFeatures oldFeatures)
		(= gOldMH oldMH)
		(= gOldKH oldKH)
		(= gOldDH oldDH)
		(= gOldWH oldWH)
		(if hideTheCast (self hideCast: 0))
		(if (and (or (not argc) param1) caller)
			(= theCaller caller)
			(= caller 0)
			(theCaller cue:)
		)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(= script (if argc theScript else 0))
		(if script (script init: self &rest))
	)
	
	(method (handleEvent pEvent &tmp [temp0 2])
		(return
			(cond 
				((and inset (inset handleEvent: pEvent)) 0)
				((& (pEvent type?) evVERB)
					(cond 
						((self onMe: pEvent) (pEvent claimed: 1) (self doVerb: (pEvent message?)))
						(disposeNotOnMe (pEvent claimed: 1) (self dispose:))
						(else (return 0))
					)
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(if (== modNum -1) (= modNum gModNum))
		(if
		(and global90 (Message msgGET modNum noun theVerb 0 1))
			(gTestMessager say: noun theVerb 0 0 0 modNum)
		)
	)
	
	(method (hideCast param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (if param1 1000 else -1000))
		(while (< temp0 (gOldCast size?))
			((gOldCast at: temp0)
				z: (+ ((gOldCast at: temp0) z?) temp1)
			)
			(++ temp0)
		)
		(Animate (gOldCast elements?) 0)
	)
	
	(method (drawInset)
		(if (> picture 0)
			(DrawPic
				picture
				(if anOverlay 100 else style)
				(if anOverlay 0 else 1)
			)
		)
		(if view
			(= insetView
				((inView new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					setPri: priority
					ignoreActors: 1
					init:
					yourself:
				)
			)
		)
	)
	
	(method (restore)
		(self drawInset:)
		(if inset ((inset oldATPs?) doit:) (inset restore:))
	)
	
	(method (refresh)
		(if view
			(DrawPic (global2 picture?) dpOPEN_NO_TRANSITION)
		else
			(DrawPic (global2 picture?) style)
		)
		(global2 style: oldStyle)
		(if (!= gPicNumber -1)
			(DrawPic gPicNumber dpOPEN_NO_TRANSITION dpNO_CLEAR)
		)
		(if (global2 inset:) ((global2 inset:) restore:))
	)
	
	(method (setInset param1 param2 param3)
		(if inset (inset dispose:))
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)
	
	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x?))
			(= temp1 (param1 y?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if view
				(return (insetView onMe: param1 param2))
			else
				(return 1)
			)
		)
	)
)

(instance inView of View
	(properties)
	
	(method (handleEvent)
		(return 0)
	)
)
