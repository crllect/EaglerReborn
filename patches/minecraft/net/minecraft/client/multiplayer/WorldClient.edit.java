
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 3  @  2 : 4

~ import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;

> INSERT  2 : 5  @  2

+ 
+ import com.google.common.collect.Sets;
+ 

> DELETE  5  @  5 : 6

> INSERT  210 : 213  @  210

+ 		if (mc.gameSettings.particleSetting == 3) {
+ 			return;
+ 		}

> CHANGE  1 : 2  @  1 : 2

~ 		EaglercraftRandom random = new EaglercraftRandom();

> CHANGE  83 : 84  @  83 : 85

~ 				return "Non-integrated multiplayer server";

> EOF
