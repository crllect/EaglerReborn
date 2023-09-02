
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> DELETE  2  @  2 : 5

> DELETE  3  @  3 : 4

> INSERT  1 : 9  @  1

+ import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
+ import net.lax1dude.eaglercraft.v1_8.HString;
+ import java.util.Set;
+ 
+ import com.google.common.collect.HashMultimap;
+ import com.google.common.collect.Lists;
+ import com.google.common.collect.Multimap;
+ 

> DELETE  13  @  13 : 17

> INSERT  12 : 14  @  12

+ import net.zxmushroom63.plugins.BaseData;
+ import net.zxmushroom63.plugins.PluginData;

> INSERT  18 : 63  @  18

+ 	public void loadPluginData(BaseData data) {
+ 		stackSize = data.getInt("amount");
+ 		animationsToGo = data.getInt("animationsToGo");
+ 		itemDamage = data.getInt("itemDamage");
+ 		if (itemFrame != null) {
+ 			itemFrame.loadPluginData(data.getBaseData("itemFrame"));
+ 		}
+ 		if (canDestroyCacheBlock != null) {
+ 			canDestroyCacheBlock.loadPluginData(data.getBaseData("canDestroyCacheBlock"));
+ 		}
+ 		if (canPlaceOnCacheBlock != null) {
+ 			canPlaceOnCacheBlock.loadPluginData(data.getBaseData("canPlaceOnCacheBlock"));
+ 		}
+ 		canDestroyCacheResult = data.getBoolean("canDestroyCacheResult");
+ 		canPlaceOnCacheResult = data.getBoolean("canPlaceOnCacheResult");
+ 	}
+ 
+ 	public static ItemStack fromPluginData(BaseData data) {
+ 		return new ItemStack(Item.getItemById(data.getInt("itemId")), data.getInt("amount"), data.getInt("itemDamage"));
+ 	}
+ 
+ 	public PluginData makePluginData() {
+ 		PluginData data = new PluginData();
+ 		data.set("amount", stackSize);
+ 		data.set("animationsToGo", animationsToGo);
+ 		data.set("itemId", item.getIdFromItem(item));
+ 		data.set("itemDamage", itemDamage);
+ 		if (itemFrame != null) {
+ 			data.set("itemFrame", itemFrame.makePluginData());
+ 		}
+ 		if (canDestroyCacheBlock != null) {
+ 			data.set("canDestroyCacheBlock", canDestroyCacheBlock.makePluginData());
+ 		}
+ 		data.set("canDestroyCacheResult", canDestroyCacheResult);
+ 		if (canPlaceOnCacheBlock != null) {
+ 			data.set("canPlaceOnCacheBlock", canPlaceOnCacheBlock.makePluginData());
+ 		}
+ 		data.set("canPlaceOnCacheResult", canPlaceOnCacheResult);
+ 
+ 		data.setCallbackVoid("reload", () -> {
+ 			loadPluginData(data);
+ 		});
+ 		return data;
+ 	}
+ 

> DELETE  27  @  27 : 28

> CHANGE  127 : 128  @  127 : 128

~ 	public boolean attemptDamageItem(int amount, EaglercraftRandom rand) {

> CHANGE  249 : 250  @  249 : 250

~ 				s = s + HString.format("#%04d/%d%s",

> CHANGE  2 : 3  @  2 : 3

~ 				s = s + HString.format("#%04d%s", new Object[] { Integer.valueOf(i), s1 });

> CHANGE  56 : 57  @  56 : 57

~ 			for (Entry entry : (Set<Entry>) multimap.entries()) {

> EOF
