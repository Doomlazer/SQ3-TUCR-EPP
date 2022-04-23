# Space Quest III - The Undiscovered Country Road - Extended Planets Pack!

## INSTALLATION

DOSBox users must copy the contents of PATCHES into the SQ3 game folder. ScummVM users can copy either the contents or the entire PATCHES folder into the SQ3 game folder.

## What is this?

A mod for the DOS version of Space Quest III. It adds new planets to the Aluminum Malard's scanner. Currently there are two new planets appearing in sectors 23 and 27. Both planets can be landed on, but are currently just proof of concepts that will change drastically with updates.

<img src="pics/23.png"  width="600" alt="AquaVelveeta seen for the first time.">

<img src="pics/27.png"  width="600" alt="A planet whose name will likely change.">

## Why am I getting so many pop-up ads during the game?

The SQ3-TUCR-EPP mod's revenue model is ad-supportd free-to-play. You can pay 20 buckazoids to remove all advertisements from the game by typing "PAY MAGIC" or:
<details> 
  <summary>(click to reveal spoiler)</summary>
   Use the reverse command "MAGIC PAY" to disable ads immediately without payment.
</details>

<img src="pics/ad.png"  width="600" alt="A pic showing an in-game advertisement.">

## I'd like to purchase in-game advertising.

Please click <a href="https://github.com/Doomlazer/SQ3-TUCR-EPP/issues/1">here</a>.

## I have an idea for a planet.

New planet submissions are engouraged, though limited by HEAP memory in some scripts. I'm not sure what that number is right now. I don't think ScummVM cares about exeeding the HEAP, but ideally DOSBox should be supported as well. A tutorial covering what is needed to add a new planet is coming, but the source code for scripts in the PATCHES folder can be referenced in the meantime. 

To get started download SCICompanion from https://github.com/Kawa-oneechan/SCICompanion or http://scicompanion.com/download/. Move the 'src' folder and game.ini into a backed up copy of your SQ3 folder, then open resource.map from within SCICompanion. The modified scripts will already be there, but you'll need to import any pics or views from the PATCHES folder.

## I'm trying to test a planet, how can I skip the opening sequence?

Type PUMP SHARK to activate debugging. You can use TP to teleport to other rooms or type QA in the first room then select "space" to jump to where you can warp right to your planet. More debugging info <a href="http://sciwiki.sierrahelp.com//index.php?title=SCI_Debug_Modes#Space_Quest_3">here</a>.
