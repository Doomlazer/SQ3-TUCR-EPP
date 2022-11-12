# Space Quest III - The Undiscovered Country Road - Extended Planets Pack!

WARNING: This mod is still in early development.

## What is this? 

A mod for the DOS version of Space Quest III. It adds new planets to the Aluminum Mallard's scanner. Currently, there are two new planets and one new space station. It adds a new inventory item the P.T.D. which can distort time and even <a href="https://www.youtube.com/watch?v=czkSgwzEfqA">cheat death</a>. The mod is still in early development and in an unfinished state. Causal players should wait until the final release for the best experience. 

<img src="pics/23.png"  width="600" alt="AquaVelveeta seen for the first time.">

<img src="pics/27.png"  width="600" alt="Planet REN.">

<img src="pics/70.png"  width="600" alt="Quark's Bar.">

## INSTALLATION

This mod requires the retail version of SQ3. Both the GOG and Steam versions are compatible. This mod has only been tested with SQ3 version 1.018. Savegames are not compatible with vanilla SQ3.

To download the patch, click the green "CODE" button near the top of this page and select "Download Zip". Uncompress the .zip and find the PATCHES folder.

DOSBox users must copy <b>only the contents</b> of PATCHES into the SQ3 game folder. All the mod files need to be loose inside the folder next to SQ3.bat - this makes uninstalling the mod difficult, so it's recommend you back up your SQ3 game folder before installing.

ScummVM users can move the entire PATCHES folder into the SQ3 game folder a SVM will load the files. It's not possible to define multiple patch locations in RESOURCE.CFG until SCI1 afaik.


## I have an idea for a planet.

New planet submissions are engouraged, though limited by HEAP memory in some scripts. I'm not sure what the max number of planets will be. I don't think ScummVM cares about exeeding the HEAP, but DOSBox will crash. The goal is to support both. 

A tutorial covering what is needed to add a new planet is coming, but the source code for scripts in the PATCHES folder can be referenced in the meantime. 

To get started download SCICompanion from https://github.com/Kawa-oneechan/SCICompanion or http://scicompanion.com/download/. Move the 'src' folder and game.ini into a backed up copy of your SQ3 folder, then open resource.map from within SCICompanion. The modified scripts will already be there, but you'll need to import any pics or views from the PATCHES folder.

## I'm trying to test a planet, how can I skip the opening sequence?

When Roger wakes up and exits the escape pod, type <b>PUMP SHARK</b> to activate debugging. 

You can use the debug command <b>TP</b> to teleport to other rooms, but it's best to type <b>QA</b> in the first room, then select the "space" option which makes the Mallard spaceworthy and ready to warp to any planet. 

FYI, the QA debug command is only available in the first room. More debugging info <a href="http://sciwiki.sierrahelp.com//index.php?title=SCI_Debug_Modes#Space_Quest_3">here</a> and <a href="https://github.com/Doomlazer/SCI-Debug-Resources">here</a>.


## CREDITS

<b>Sectors 23, 27 & 70:</b>

DoomLazer - Concepts and Programming

Threepwang - Background Artist


## What's changed recently?

### October 2022

Dabo working, but rought around the edges. 

Quark's is about 75% complete.

Personal Time Disruptor bug fixes, but still mostly untested.

### July 2022

Planet Ren (sector 27) is mostly done.

Quark's Bar can be visited but it's in very unfinished state.

fixed a bug where "scanning sector %d" never goes away if the play clicks scan too quickly.

Personal Time Disruptor added: https://www.youtube.com/watch?v=czkSgwzEfqA

### May 2022 

Sector27 is now Planet Ren and more than half implemented.


