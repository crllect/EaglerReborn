# Eagler Reborn | Eaglercraft service allowing to connect to Java Minecraft servers.

### Play real Minecraft 1.8 in your browser, currently only supports multiplayer

![EaglercraftX 1.8 Screenshot Main Menu](https://media.discordapp.net/attachments/1042594789943689327/1080697078583394355/eaglerx-480p.png)
---

### This repository contains:

 - **Utilities to decompile Minecraft 1.8 and apply patch files to it**
 - **Source code to provide the LWJGL keyboard, mouse, and OpenGL APIs in a browser**
 - **Patch files to mod the Minecraft 1.8 source code to make it browser compatible**
 - **Browser-modified portions of Minecraft 1.8's open-source dependencies**
 - **Plugins for Minecraft servers to allow the eagler client to connect to them**
 - **Hooks to ViaMCP to allow joining of regular servers**

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
