
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 4  @  2 : 6

~ import net.zxmushroom63.plugins.BaseData;
~ import net.zxmushroom63.plugins.PluginData;

> INSERT  286 : 319  @  286

+ 
+ 	public void loadPluginData(BaseData data) {
+ 		// Actually we cant load anything
+ 		// _ _
+ 		// \(o-o)/
+ 	}
+ 
+ 	public PluginData makePluginData() {
+ 		PluginData data = new PluginData();
+ 		data.set("minX", minX);
+ 		data.set("minY", minY);
+ 		data.set("minZ", minZ);
+ 		data.set("maxX", maxX);
+ 		data.set("maxY", maxY);
+ 		data.set("maxZ", maxZ);
+ 		data.setCallbackVoidWithDataArg("addCoord", (BaseData params) -> {
+ 			addCoord(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));
+ 		});
+ 		data.setCallbackVoidWithDataArg("contract", (BaseData params) -> {
+ 			contract(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));
+ 		});
+ 		data.setCallbackVoidWithDataArg("expand", (BaseData params) -> {
+ 			expand(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));
+ 		});
+ 		data.setCallbackVoidWithDataArg("offset", (BaseData params) -> {
+ 			offset(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));
+ 		});
+ 		data.setCallbackDouble("getAverageEdgeLength", () -> {
+ 			return getAverageEdgeLength();
+ 		});
+ 
+ 		return data;
+ 	}

> EOF
