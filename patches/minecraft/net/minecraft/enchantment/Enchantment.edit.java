
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> DELETE  2  @  2 : 4

> CHANGE  3 : 7  @  3 : 21

~ 
~ import com.google.common.collect.Lists;
~ import com.google.common.collect.Maps;
~ 

> INSERT  7 : 9  @  7

+ import net.zxmushroom63.plugins.BaseData;
+ import net.zxmushroom63.plugins.PluginData;

> CHANGE  43 : 44  @  43 : 44

~ 	private int weight;

> INSERT  19 : 46  @  19

+ 	public void loadPluginData(BaseData data) {
+ 		weight = data.getInt("weight");
+ 		name = data.getString("name");
+ 	}
+ 
+ 	public PluginData makePluginData() {
+ 		PluginData data = new PluginData();
+ 		data.set("enchID", effectId);
+ 		data.set("weight", weight);
+ 		data.set("name", name);
+ 		data.setCallbackVoid("reload", () -> {
+ 			loadPluginData(data);
+ 		});
+ 		return data;
+ 	}
+ 
+ 	public static PluginData makePluginDataStatic() {
+ 		PluginData data = new PluginData();
+ 		Map<ResourceLocation, Enchantment> enchMap = locationEnchantments;
+ 		for (Map.Entry<ResourceLocation, Enchantment> entry : enchMap.entrySet()) {
+ 			if (entry.getKey().resourceName != null && entry.getValue() != null) {
+ 				data.set(entry.getKey().resourceName, entry.getValue().makePluginData());
+ 			}
+ 		}
+ 		return data;
+ 	}
+ 

> EOF
