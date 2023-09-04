
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

> INSERT  18 : 150  @  18

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
+ 		data.setCallbackObject("getItem", () -> {
+ 			return getItem().makePluginData();
+ 		});
+ 		data.setCallbackInt("getMaxStackSize", () -> {
+ 			return getMaxStackSize();
+ 		});
+ 		data.setCallbackBoolean("isStackable", () -> {
+ 			return isStackable();
+ 		});
+ 		data.setCallbackBoolean("isItemStackDamageable", () -> {
+ 			return isItemStackDamageable();
+ 		});
+ 		data.setCallbackBoolean("getHasSubtypes", () -> {
+ 			return getHasSubtypes();
+ 		});
+ 		data.setCallbackBoolean("isItemDamaged", () -> {
+ 			return isItemDamaged();
+ 		});
+ 		data.setCallbackInt("getItemDamage", () -> {
+ 			return getItemDamage();
+ 		});
+ 		data.setCallbackInt("getMetadata", () -> {
+ 			return getMetadata();
+ 		});
+ 		data.setCallbackVoidWithDataArg("setItemDamage", (BaseData params) -> {
+ 			setItemDamage(params.getInt("meta"));
+ 		});
+ 		data.setCallbackInt("getMaxDamage", () -> {
+ 			return getMaxDamage();
+ 		});
+ 		data.setCallbackObject("copy", () -> {
+ 			return copy().makePluginData();
+ 		});
+ 		data.setCallbackString("getUnlocalizedName", () -> {
+ 			return getUnlocalizedName();
+ 		});
+ 		data.setCallbackString("toString", () -> {
+ 			return toString();
+ 		});
+ 		data.setCallbackInt("getMaxItemUseDuration", () -> {
+ 			return getMaxItemUseDuration();
+ 		});
+ 		data.setCallbackString("getDisplayName", () -> {
+ 			return getDisplayName();
+ 		});
+ 		data.setCallbackObjectWithDataArg("setDisplayName", (BaseData params) -> {
+ 			return setStackDisplayName(params.getString("displayName")).makePluginData();
+ 		});
+ 		data.setCallbackVoid("clearCustomName", () -> {
+ 			clearCustomName();
+ 		});
+ 		data.setCallbackBoolean("hasDisplayName", () -> {
+ 			return hasDisplayName();
+ 		});
+ 		data.setCallbackBoolean("hasEffect", () -> {
+ 			return hasEffect();
+ 		});
+ 		data.setCallbackBoolean("isItemEnchantable", () -> {
+ 			return isItemEnchantable();
+ 		});
+ 		data.setCallbackVoidWithDataArg("addEnchantment", (BaseData params) -> {
+ 			addEnchantment(Enchantment.getEnchantmentById(params.getInt("enchId")), params.getInt("level"));
+ 		});
+ 		data.setCallbackBoolean("isItemEnchanted", () -> {
+ 			return isItemEnchanted();
+ 		});
+ 		data.setCallbackBoolean("canEditBlocks", () -> {
+ 			return canEditBlocks();
+ 		});
+ 		data.setCallbackBoolean("isOnItemFrame", () -> {
+ 			return isOnItemFrame();
+ 		});
+ 		data.setCallbackInt("getRepairCost", () -> {
+ 			return getRepairCost();
+ 		});
+ 		data.setCallbackVoidWithDataArg("setRepairCost", (BaseData params) -> {
+ 			setRepairCost(params.getInt("cost"));
+ 		});
+ 		data.setCallbackVoidWithDataArg("setItem", (BaseData params) -> {
+ 			setItem(Item.getItemById(params.getInt("itemId")));
+ 		});
+ 		data.setCallbackBooleanWithDataArg("canDestroy", (BaseData params) -> {
+ 			return canDestroy(Block.getBlockById(params.getInt("blockId")));
+ 		});
+ 		data.setCallbackBooleanWithDataArg("canPlaceOn", (BaseData params) -> {
+ 			return canPlaceOn(Block.getBlockById(params.getInt("blockId")));
+ 		});
+ 		return data;
+ 	}
+ 

> DELETE  27  @  27 : 28

> INSERT  15 : 19  @  15

+ 	/**
+ 	 * + Splits off a stack of the given amount of this stack and reduces this stack
+ 	 * by the amount.
+ 	 */

> INSERT  10 : 13  @  10

+ 	/**
+ 	 * + Returns the object corresponding to the stack.
+ 	 */

> INSERT  4 : 8  @  4

+ 	/**
+ 	 * + Called when the player uses this ItemStack on a Block (right-click). Places
+ 	 * blocks, etc. (Legacy name: tryPlaceItemIntoWorld)
+ 	 */

> INSERT  14 : 18  @  14

+ 	/**
+ 	 * + Called whenever this item stack is equipped and right clicked. Returns the
+ 	 * new item stack to put in the position where this item is. Args: world, player
+ 	 */

> INSERT  4 : 8  @  4

+ 	/**
+ 	 * + Called when the item in use count reach 0, e.g. item food eaten. Return the
+ 	 * new ItemStack. Args : world, entity
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Write the stack fields to a NBT object. Return the new NBT object.
+ 	 */

> INSERT  12 : 15  @  12

+ 	/**
+ 	 * + Read the stack fields from a NBT object.
+ 	 */

> INSERT  22 : 25  @  22

+ 	/**
+ 	 * + Returns maximum size of the stack.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Returns true if the ItemStack can hold 2 or more units of the item.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + true if this itemStack is damageable
+ 	 */

> INSERT  10 : 13  @  10

+ 	/**
+ 	 * + returns true when a damageable item is damaged
+ 	 */

> INSERT  20 : 23  @  20

+ 	/**
+ 	 * + Returns the max damage an item in the stack can take.
+ 	 */

> CHANGE  4 : 12  @  4 : 5

~ 	/**
~ 	 * + Attempts to damage the ItemStack with par1 amount of damage, If the
~ 	 * ItemStack has the Unbreaking enchantment there is a chance for each point of
~ 	 * damage to be negated. Returns true if it takes more damage than
~ 	 * getMaxDamage(). Returns false otherwise or if the ItemStack can't be damaged
~ 	 * or if all points of damage are negated.
~ 	 */
~ 	public boolean attemptDamageItem(int amount, EaglercraftRandom rand) {

> INSERT  24 : 27  @  24

+ 	/**
+ 	 * + Damages the item in the ItemStack
+ 	 */

> INSERT  25 : 28  @  25

+ 	/**
+ 	 * + Calls the corresponding fct in di
+ 	 */

> INSERT  8 : 11  @  8

+ 	/**
+ 	 * + Called when a Block is destroyed using this ItemStack
+ 	 */

> INSERT  8 : 11  @  8

+ 	/**
+ 	 * + Check whether the given Block can be harvested using this ItemStack.
+ 	 */

> INSERT  8 : 11  @  8

+ 	/**
+ 	 * + Returns a new stack with the same properties.
+ 	 */

> INSERT  20 : 24  @  20

+ 	/**
+ 	 * + compares ItemStack argument1 with ItemStack argument2; returns true if both
+ 	 * ItemStacks are equal
+ 	 */

> INSERT  5 : 9  @  5

+ 	/**
+ 	 * + compares ItemStack argument to the instance ItemStack; returns true if both
+ 	 * ItemStacks are equal
+ 	 */

> INSERT  9 : 12  @  9

+ 	/**
+ 	 * + Compares Item and damage value of the two stacks
+ 	 */

> INSERT  5 : 9  @  5

+ 	/**
+ 	 * + compares ItemStack argument to the instance ItemStack; returns true if the
+ 	 * Items contained in both ItemStacks are equal
+ 	 */

> INSERT  8 : 11  @  8

+ 	/**
+ 	 * + Creates a copy of a ItemStack, a null parameters will return a null.
+ 	 */

> INSERT  8 : 12  @  8

+ 	/**
+ 	 * + Called each tick as long the ItemStack in on player inventory. Used to
+ 	 * progress the pickup animation and update maps.
+ 	 */

> INSERT  25 : 29  @  25

+ 	/**
+ 	 * + Called when the player releases the use item button. Args: world,
+ 	 * entityplayer, itemInUseCount
+ 	 */

> INSERT  4 : 8  @  4

+ 	/**
+ 	 * + Returns true if the ItemStack has an NBTTagCompound. Currently used to
+ 	 * store enchantments.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Returns the NBTTagCompound of the ItemStack.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Get an NBTTagCompound from this stack's NBT data.
+ 	 */

> INSERT  16 : 20  @  16

+ 	/**
+ 	 * + Assigns a NBTTagCompound to the ItemStack, minecraft validates that only
+ 	 * non-stackable items can have it.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + returns the display name of the itemstack
+ 	 */

> INSERT  25 : 28  @  25

+ 	/**
+ 	 * + Clear any custom name set for this ItemStack
+ 	 */

> INSERT  16 : 19  @  16

+ 	/**
+ 	 * + Returns true if the itemstack has a display name
+ 	 */

> INSERT  6 : 9  @  6

+ 	/**
+ 	 * + Return a list of strings containing information about the item
+ 	 */

> CHANGE  17 : 18  @  17 : 18

~ 				s = s + HString.format("#%04d/%d%s",

> CHANGE  2 : 3  @  2 : 3

~ 				s = s + HString.format("#%04d%s", new Object[] { Integer.valueOf(i), s1 });

> CHANGE  56 : 57  @  56 : 57

~ 			for (Entry entry : (Set<Entry>) multimap.entries()) {

> INSERT  91 : 94  @  91

+ 	/**
+ 	 * + True if it is a tool and has no enchantments to begin with
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Adds an enchantment with a desired level on the ItemStack.
+ 	 */

> INSERT  16 : 19  @  16

+ 	/**
+ 	 * + True if the item has enchantment data
+ 	 */

> INSERT  16 : 19  @  16

+ 	/**
+ 	 * + Return whether this stack is on an item frame.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Set the item frame this stack is on.
+ 	 */

> INSERT  4 : 8  @  4

+ 	/**
+ 	 * + Return the item frame this stack is on. Returns null if not on an item
+ 	 * frame.
+ 	 */

> INSERT  4 : 7  @  4

+ 	/**
+ 	 * + Get this stack's repair cost, or 0 if no repair cost is defined.
+ 	 */

> INSERT  6 : 9  @  6

+ 	/**
+ 	 * + Set this stack's repair cost.
+ 	 */

> INSERT  34 : 38  @  34

+ 	/**
+ 	 * + Get a ChatComponent for this Item's display name that shows this Item on
+ 	 * hover
+ 	 */

> EOF
