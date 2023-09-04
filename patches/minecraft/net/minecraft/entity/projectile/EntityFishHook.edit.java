
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> INSERT  4 : 5  @  4

+ 

> DELETE  2  @  2 : 3

> DELETE  1  @  1 : 3

> DELETE  7  @  7 : 8

> DELETE  3  @  3 : 4

> DELETE  4  @  4 : 5

> CHANGE  2 : 4  @  2 : 3

~ import net.zxmushroom63.plugins.BaseData;
~ import net.zxmushroom63.plugins.PluginData;

> INSERT  100 : 155  @  100

+ 	@Override
+ 	public void loadPluginData(BaseData data) {
+ 		super.loadPluginData(data);
+ 		inGround = data.getBoolean("inGround");
+ 		xTile = data.getInt("xTile");
+ 		yTile = data.getInt("yTile");
+ 		zTile = data.getInt("zTile");
+ 		shake = data.getInt("shake");
+ 		ticksCatchable = data.getInt("ticksCatchable");
+ 		ticksCatchableDelay = data.getInt("ticksCatchableDelay");
+ 		ticksCaughtDelay = data.getInt("ticksCaughtDelay");
+ 		ticksInAir = data.getInt("ticksInAir");
+ 		ticksInGround = data.getInt("ticksInGround");
+ 		if (caughtEntity != null) {
+ 			caughtEntity.loadPluginData(data.getBaseData("caughtEntity"));
+ 		}
+ 		fishApproachAngle = data.getFloat("fishApproachAngle");
+ 		fishPitch = data.getDouble("fishPitch");
+ 		fishYaw = data.getDouble("fishYaw");
+ 		fishPosRotationIncrements = data.getInt("fishPosRotationIncrements");
+ 		fishX = data.getDouble("fishX");
+ 		fishY = data.getDouble("fishY");
+ 		fishZ = data.getDouble("fishZ");
+ 	}
+ 
+ 	@Override
+ 	public PluginData makePluginData() {
+ 		PluginData data = super.makePluginData();
+ 		data.set("inGround", inGround);
+ 		data.set("xTile", xTile);
+ 		data.set("yTile", yTile);
+ 		data.set("zTile", zTile);
+ 		data.set("shake", shake);
+ 		data.set("ticksCatchable", ticksCatchable);
+ 		data.set("ticksCatchableDelay", ticksCatchableDelay);
+ 		data.set("ticksCaughtDelay", ticksCaughtDelay);
+ 		data.set("ticksInAir", ticksInAir);
+ 		data.set("ticksInGround", ticksInGround);
+ 		if (caughtEntity != null) {
+ 			data.set("caughtEntity", caughtEntity.makePluginData());
+ 		}
+ 		data.set("fishApproachAngle", fishApproachAngle);
+ 		data.set("fishPitch", fishPitch);
+ 		data.set("fishYaw", fishYaw);
+ 		data.set("fishPosRotationIncrements", fishPosRotationIncrements);
+ 		data.set("fishX", fishX);
+ 		data.set("fishY", fishY);
+ 		data.set("fishZ", fishZ);
+ 
+ 		data.setCallbackVoid("reload", () -> {
+ 			loadPluginData(data);
+ 		});
+ 		return data;
+ 	}
+ 

> DELETE  65  @  65 : 74

> DELETE  1  @  1 : 14

> DELETE  118  @  118 : 219

> CHANGE  40 : 41  @  40 : 79

~ 		return 0;

> DELETE  2  @  2 : 27

> EOF
