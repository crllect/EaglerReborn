# Eagler Reborn | Eaglercraft client allowing to connect to Java Minecraft servers.

### Play real Minecraft 1.8 in your browser, currently only supports multiplayer

![Eagler Reborn Title Screen](https://github.com/EaglerReborn/EaglerReborn/assets/134523836/3ff13a58-96dc-4200-bdbf-89a0db647d2d)
---

### This repository contains:

 - **Utilities to decompile Minecraft 1.8 and apply patch files to it**
 - **Source code to provide the LWJGL keyboard, mouse, and OpenGL APIs in a browser**
 - **Patch files to mod the Minecraft 1.8 source code to make it browser compatible**
 - **Browser-modified portions of Minecraft 1.8's open-source dependencies**
 - **ViaMCP code to allow joining of modern servers**

### This repository does NOT contain:

 - **Any portion of the decompiled Minecraft 1.8 source code or resources**
 - **Any portion of Mod Coder Pack and it's config files**
 - **Data that can be used alone to reconstruct portions of the game's source code**
 - **Software configured by default to allow users to play without owning a copy of Minecraft**

## Getting Started:

### To compile the latest version of the client, on Windows:

1. Make sure you have at least Java 11 installed and added to your PATH
2. Download (clone) this repository to your computer
3. Double click `CompileLatestClient.bat`, a GUI resembling a classic windows installer should open
4. Follow the steps shown to you in the new window to finish compiling

### To compile the latest version of the client, on Linux/macOS:

1. Make sure you have at least Java 11 installed
2. Download (clone) this repository to your computer
3. Open a terminal in the folder the repository was cloned to
4. Type `chmod +x CompileLatestClient.sh` and hit enter
5. Type `./CompileLatestClient.sh` and hit enter, a GUI resembling a classic windows installer should open
6. Follow the steps shown to you in the new window to finish compiling


### Creating an INDEV 2 relay (WIP)
(note: only works with cracked servers at the moment)
[![replit button](https://camo.githubusercontent.com/de8d18f58a5c013d803964424dc10e4276d57c2d9f7d2bd5ce2ffa127d6e832c/68747470733a2f2f62696e6261736862616e616e612e6769746875622e696f2f6465706c6f792d627574746f6e732f627574746f6e732f72656d6164652f7265706c69742e737667)](https://replit.com/github/novnc/websockify-js)
you can create a relay on replit via that button. just do `cd websockify; npm i` in the shell before you run it. Set the run command to `cd websockify; ./websockify.js 127.0.0.1:8080 SERVERIP:SERVERPORT`
