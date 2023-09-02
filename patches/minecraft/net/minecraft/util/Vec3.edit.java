
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 4  @  2 : 4

~ import net.zxmushroom63.plugins.BaseData;
~ import net.zxmushroom63.plugins.PluginData;

> INSERT  1 : 20  @  1

+ /**
+  * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
+  * code.
+  * 
+  * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
+  * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
+  * 
+  * EaglercraftX 1.8 patch files are (c) 2022-2023 LAX1DUDE. All Rights Reserved.
+  * 
+  * WITH THE EXCEPTION OF PATCH FILES, MINIFIED JAVASCRIPT, AND ALL FILES
+  * NORMALLY FOUND IN AN UNMODIFIED MINECRAFT RESOURCE PACK, YOU ARE NOT ALLOWED
+  * TO SHARE, DISTRIBUTE, OR REPURPOSE ANY FILE USED BY OR PRODUCED BY THE
+  * SOFTWARE IN THIS REPOSITORY WITHOUT PRIOR PERMISSION FROM THE PROJECT AUTHOR.
+  * 
+  * NOT FOR COMMERCIAL OR MALICIOUS USE
+  * 
+  * (please read the 'LICENSE' file this repo's root directory for more info)
+  * 
+  */

> CHANGE  1 : 4  @  1 : 4

~ 	public double xCoord;
~ 	public double yCoord;
~ 	public double zCoord;

> INSERT  23 : 26  @  23

+ 	/**
+ 	 * + Returns a new vector with the result of the specified vector minus this.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Normalizes the vector to a length of 1 (except if it is the zero vector)
+ 	 */

> INSERT  11 : 14  @  11

+ 	/**
+ 	 * + Returns a new vector with the result of this vector x the specified vector.
+ 	 */

> INSERT  18 : 22  @  18

+ 	/**
+ 	 * + Adds the specified x,y,z vector components to this vector and returns the
+ 	 * resulting vector. Does not change this vector.
+ 	 */

> INSERT  4 : 8  @  4

+ 	/**
+ 	 * + Euclidean distance between this and the specified vector, returned as
+ 	 * double.
+ 	 */

> INSERT  7 : 10  @  7

+ 	/**
+ 	 * + The square of the Euclidean distance between this and the specified vector.
+ 	 */

> INSERT  7 : 10  @  7

+ 	/**
+ 	 * + Returns the length of the vector.
+ 	 */

> INSERT  5 : 9  @  5

+ 	/**
+ 	 * + Returns a new vector with x value equal to the second parameter, along the
+ 	 * line between this vector and the passed in vector, or null if not possible.
+ 	 */

> INSERT  14 : 18  @  14

+ 	/**
+ 	 * + Returns a new vector with y value equal to the second parameter, along the
+ 	 * line between this vector and the passed in vector, or null if not possible.
+ 	 */

> INSERT  14 : 18  @  14

+ 	/**
+ 	 * + Returns a new vector with z value equal to the second parameter, along the
+ 	 * line between this vector and the passed in vector, or null if not possible.
+ 	 */

> INSERT  35 : 105  @  35

+ 
+ 	public void loadPluginData(BaseData data) {
+ 		xCoord = data.getDouble("x");
+ 		yCoord = data.getDouble("y");
+ 		zCoord = data.getDouble("z");
+ 	}
+ 
+ 	public static Vec3 fromPluginData(BaseData data) {
+ 		return new Vec3(data.getDouble("x"), data.getDouble("y"), data.getDouble("z"));
+ 	}
+ 
+ 	public PluginData makePluginData() {
+ 		PluginData data = new PluginData();
+ 		data.set("x", xCoord);
+ 		data.set("y", yCoord);
+ 		data.set("z", zCoord);
+ 		data.setCallbackVoid("reload", () -> {
+ 			loadPluginData(data);
+ 		});
+ 		data.setCallbackVoidWithDataArg("subtractReverse", (BaseData vec3) -> {
+ 			subtractReverse(Vec3.fromPluginData(vec3));
+ 		});
+ 		data.setCallbackObject("normalize", () -> {
+ 			return normalize().makePluginData();
+ 		});
+ 		data.setCallbackDoubleWithDataArg("dotProduct", (BaseData vec3) -> {
+ 			return dotProduct(Vec3.fromPluginData(vec3));
+ 		});
+ 		data.setCallbackObjectWithDataArg("crossProduct", (BaseData vec3) -> {
+ 			return crossProduct(Vec3.fromPluginData(vec3)).makePluginData();
+ 		});
+ 		data.setCallbackObjectWithDataArg("subtract", (BaseData params) -> {
+ 			return subtract(params.getDouble("x"), params.getDouble("y"), params.getDouble("z")).makePluginData();
+ 		});
+ 		data.setCallbackObjectWithDataArg("addVector", (BaseData params) -> {
+ 			return addVector(params.getDouble("x"), params.getDouble("y"), params.getDouble("z")).makePluginData();
+ 		});
+ 		data.setCallbackDoubleWithDataArg("distanceTo", (BaseData vec3) -> {
+ 			return distanceTo(Vec3.fromPluginData(vec3));
+ 		});
+ 		data.setCallbackDoubleWithDataArg("squareDistanceTo", (BaseData vec3) -> {
+ 			return squareDistanceTo(Vec3.fromPluginData(vec3));
+ 		});
+ 		data.setCallbackDouble("lengthVector", () -> {
+ 			return lengthVector();
+ 		});
+ 		data.setCallbackObjectWithDataArg("getIntermediateWithXValue", (BaseData params) -> {
+ 			return getIntermediateWithXValue(Vec3.fromPluginData(params.getBaseData("vec")), params.getDouble("x"))
+ 					.makePluginData();
+ 		});
+ 		data.setCallbackObjectWithDataArg("getIntermediateWithYValue", (BaseData params) -> {
+ 			return getIntermediateWithYValue(Vec3.fromPluginData(params.getBaseData("vec")), params.getDouble("y"))
+ 					.makePluginData();
+ 		});
+ 		data.setCallbackObjectWithDataArg("getIntermediateWithZValue", (BaseData params) -> {
+ 			return getIntermediateWithZValue(Vec3.fromPluginData(params.getBaseData("vec")), params.getDouble("z"))
+ 					.makePluginData();
+ 		});
+ 		data.setCallbackString("toString", () -> {
+ 			return toString();
+ 		});
+ 		data.setCallbackObjectWithDataArg("rotatePitch", (BaseData params) -> {
+ 			return rotatePitch(params.getFloat("pitch")).makePluginData();
+ 		});
+ 		data.setCallbackObjectWithDataArg("rotateYaw", (BaseData params) -> {
+ 			return rotateYaw(params.getFloat("yaw")).makePluginData();
+ 		});
+ 
+ 		return data;
+ 	}

> EOF
