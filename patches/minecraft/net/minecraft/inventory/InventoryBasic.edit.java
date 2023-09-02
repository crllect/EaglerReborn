
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> DELETE  2  @  2 : 3

> INSERT  1 : 4  @  1

+ 
+ import com.google.common.collect.Lists;
+ 

> DELETE  1  @  1 : 3

> INSERT  4 : 6  @  4

+ import net.zxmushroom63.plugins.BaseData;
+ import net.zxmushroom63.plugins.PluginData;

> INSERT  8 : 39  @  8

+ 	public void loadPluginData(BaseData data) {
+ 		BaseData[] parItemStacks = data.getBaseDataArr("inventoryContents");
+ 		for (int i = 0; i < parItemStacks.length && i < inventoryContents.length; i++) {
+ 			if (inventoryContents[i] != null) {
+ 				inventoryContents[i].loadPluginData(parItemStacks[i]);
+ 			}
+ 		}
+ 
+ 		inventoryTitle = data.getString("inventoryTitle");
+ 		slotsCount = data.getInt("slotsCount");
+ 		hasCustomName = data.getBoolean("hasCustomName");
+ 	}
+ 
+ 	public PluginData makePluginData() {
+ 		PluginData data = new PluginData();
+ 		PluginData[] parBaseDatas = new PluginData[inventoryContents.length];
+ 		for (int i = 0; i < inventoryContents.length; i++) {
+ 			if (inventoryContents[i] != null) {
+ 				parBaseDatas[i] = inventoryContents[i].makePluginData();
+ 			}
+ 		}
+ 		data.set("inventoryContents", parBaseDatas);
+ 		data.set("inventoryTitle", inventoryTitle);
+ 		data.set("slotsCount", slotsCount);
+ 		data.set("hasCustomName", hasCustomName);
+ 		data.setCallbackVoid("reload", () -> {
+ 			loadPluginData(data);
+ 		});
+ 		return data;
+ 	}
+ 

> EOF
