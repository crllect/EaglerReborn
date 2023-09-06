
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> DELETE  2  @  2 : 5

> CHANGE  5 : 6  @  5 : 6

~ import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;

> CHANGE  1 : 2  @  1 : 2

~ import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;

> INSERT  1 : 6  @  1

+ 
+ import com.google.common.base.Predicate;
+ import com.google.common.collect.Lists;
+ import com.google.common.collect.Sets;
+ 

> INSERT  8 : 9  @  8

+ import net.minecraft.client.Minecraft;

> DELETE  10  @  10 : 11

> DELETE  12  @  12 : 27

> DELETE  1  @  1 : 2

> DELETE  3  @  3 : 4

> INSERT  7 : 13  @  7

+ 	/**
+ 	 * + A list of all Entities in all currently-loaded chunks
+ 	 */
+ 	/**
+ 	 * + A list of all Entities in all currently-loaded chunks
+ 	 */

> INSERT  2 : 8  @  2

+ 	/**
+ 	 * + A list of the loaded tile entities in the world
+ 	 */
+ 	/**
+ 	 * + A list of the loaded tile entities in the world
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Array list of players in the world.
+ 	 */
+ 	/**
+ 	 * + Array list of players in the world.
+ 	 */

> INSERT  1 : 7  @  1

+ 	/**
+ 	 * + a list of all the lightning entities
+ 	 */
+ 	/**
+ 	 * + a list of all the lightning entities
+ 	 */

> CHANGE  4 : 25  @  4 : 5

~ 	/**
~ 	 * + Contains the current Linear Congruential Generator seed for block updates.
~ 	 * Used with an A value of 3 and a C value of 0x3c6ef35f, producing a highly
~ 	 * planar series of values ill-suited for choosing random blocks in a 16x128x16
~ 	 * field.
~ 	 */
~ 	/**
~ 	 * + Contains the current Linear Congruential Generator seed for block updates.
~ 	 * Used with an A value of 3 and a C value of 0x3c6ef35f, producing a highly
~ 	 * planar series of values ill-suited for choosing random blocks in a 16x128x16
~ 	 * field.
~ 	 */
~ 	protected int updateLCG = (new EaglercraftRandom()).nextInt();
~ 	/**
~ 	 * + magic number used to generate fast random numbers for 3d distribution
~ 	 * within a chunk
~ 	 */
~ 	/**
~ 	 * + magic number used to generate fast random numbers for 3d distribution
~ 	 * within a chunk
~ 	 */

> CHANGE  6 : 13  @  6 : 7

~ 	/**
~ 	 * + RNG for World.
~ 	 */
~ 	/**
~ 	 * + RNG for World.
~ 	 */
~ 	public final EaglercraftRandom rand = new EaglercraftRandom();

> DELETE  7  @  7 : 8

> CHANGE  3 : 9  @  3 : 4

~ 	/**
~ 	 * + populated by chunks that are within 9 chunks of any player
~ 	 */
~ 	/**
~ 	 * + populated by chunks that are within 9 chunks of any player
~ 	 */

> INSERT  6 : 7  @  6

+ 	private final Minecraft mc = Minecraft.getMinecraft();

> INSERT  4 : 7  @  4

+ 		if (!client) {
+ 			throw new IllegalStateException("Singleplayer is unavailable because all of it's code was deleted");
+ 		}

> DELETE  8  @  8 : 9

> CHANGE  12 : 13  @  12 : 13

~ 				return chunk.getBiome(pos);

> CHANGE  11 : 12  @  11 : 12

~ 			return BiomeGenBase.plains;

> DELETE  3  @  3 : 7

> INSERT  6 : 14  @  6

+ 	/**
+ 	 * + Sets a new spawn location by finding an uncovered block at a random (x,z)
+ 	 * location in the chunk.
+ 	 */
+ 	/**
+ 	 * + Sets a new spawn location by finding an uncovered block at a random (x,z)
+ 	 * location in the chunk.
+ 	 */

> INSERT  14 : 20  @  14

+ 	/**
+ 	 * + Check if the given BlockPos has valid coordinates
+ 	 */
+ 	/**
+ 	 * + Check if the given BlockPos has valid coordinates
+ 	 */

> INSERT  5 : 15  @  5

+ 	/**
+ 	 * + Checks to see if an air block exists at the provided location. Note that
+ 	 * this only checks to see if the blocks material is set to air, meaning it is
+ 	 * possible for non-vanilla blocks to still pass this check.
+ 	 */
+ 	/**
+ 	 * + Checks to see if an air block exists at the provided location. Note that
+ 	 * this only checks to see if the blocks material is set to air, meaning it is
+ 	 * possible for non-vanilla blocks to still pass this check.
+ 	 */

> DELETE  29  @  29 : 37

> INSERT  29 : 35  @  29

+ 	/**
+ 	 * + Returns back a chunk looked up by chunk coordinates Args: x, y
+ 	 */
+ 	/**
+ 	 * + Returns back a chunk looked up by chunk coordinates Args: x, y
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Convenience method to update the block on both the client and server
+ 	 */
+ 	/**
+ 	 * + Convenience method to update the block on both the client and server
+ 	 */

> DELETE  3  @  3 : 5

> CHANGE  15 : 16  @  15 : 16

~ 				if ((flags & 2) != 0 && ((flags & 4) == 0) && chunk.isPopulated()) {

> DELETE  3  @  3 : 10

> INSERT  9 : 17  @  9

+ 	/**
+ 	 * + Sets a block to air, but also plays the sound and particles and can spawn
+ 	 * drops
+ 	 */
+ 	/**
+ 	 * + Sets a block to air, but also plays the sound and particles and can spawn
+ 	 * drops
+ 	 */

> INSERT  15 : 21  @  15

+ 	/**
+ 	 * + Convenience method to update the block on both the client and server
+ 	 */
+ 	/**
+ 	 * + Convenience method to update the block on both the client and server
+ 	 */

> CHANGE  12 : 13  @  12 : 16

~ 		this.notifyNeighborsOfStateChange(pos, blockType);

> INSERT  2 : 8  @  2

+ 	/**
+ 	 * + marks a vertical line of blocks as dirty
+ 	 */
+ 	/**
+ 	 * + marks a vertical line of blocks as dirty
+ 	 */

> DELETE  65  @  65 : 67

> DELETE  1  @  1 : 21

> INSERT  86 : 92  @  86

+ 	/**
+ 	 * + Returns maximum world height.
+ 	 */
+ 	/**
+ 	 * + Returns maximum world height.
+ 	 */

> INSERT  16 : 22  @  16

+ 	/**
+ 	 * + Gets the lowest height of the chunk where sunlight directly reaches
+ 	 */
+ 	/**
+ 	 * + Gets the lowest height of the chunk where sunlight directly reaches
+ 	 */

> INSERT  110 : 122  @  110

+ 	public Block getBlock(BlockPos pos) {
+ 		return getBlockState(pos).getBlock();
+ 	}
+ 
+ 	/**
+ 	 * + Checks whether its daytime by seeing if the light subtracted from the
+ 	 * skylight is less than 4
+ 	 */
+ 	/**
+ 	 * + Checks whether its daytime by seeing if the light subtracted from the
+ 	 * skylight is less than 4
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */
+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */
+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */
+ 	/**
+ 	 * + ray traces all blocks, including non-collideable ones
+ 	 */

> INSERT  136 : 144  @  136

+ 	/**
+ 	 * + Plays a sound at the entity's position. Args: entity, sound, volume
+ 	 * (relative to 1.0), and frequency (or pitch, also relative to 1.0).
+ 	 */
+ 	/**
+ 	 * + Plays a sound at the entity's position. Args: entity, sound, volume
+ 	 * (relative to 1.0), and frequency (or pitch, also relative to 1.0).
+ 	 */

> INSERT  8 : 14  @  8

+ 	/**
+ 	 * + Plays sound to all near players except the player reference given
+ 	 */
+ 	/**
+ 	 * + Plays sound to all near players except the player reference given
+ 	 */

> INSERT  8 : 20  @  8

+ 	/**
+ 	 * + Play a sound effect. Many many parameters for this function. Not sure what
+ 	 * they do, but a classic call is : (double)i + 0.5D, (double)j + 0.5D,
+ 	 * (double)k + 0.5D, 'random.door_open', 1.0F, world.rand.nextFloat() * 0.1F +
+ 	 * 0.9F with i,j,k position of the block.
+ 	 */
+ 	/**
+ 	 * + Play a sound effect. Many many parameters for this function. Not sure what
+ 	 * they do, but a classic call is : (double)i + 0.5D, (double)j + 0.5D,
+ 	 * (double)k + 0.5D, 'random.door_open', 1.0F, world.rand.nextFloat() * 0.1F +
+ 	 * 0.9F with i,j,k position of the block.
+ 	 */

> INSERT  7 : 13  @  7

+ 	/**
+ 	 * + par8 is loudness, all pars passed to minecraftInstance.sndManager.playSound
+ 	 */
+ 	/**
+ 	 * + par8 is loudness, all pars passed to minecraftInstance.sndManager.playSound
+ 	 */

> INSERT  25 : 28  @  25

+ 		if (mc.gameSettings.particleSetting == 3) {
+ 			return;
+ 		}

> INSERT  7 : 13  @  7

+ 	/**
+ 	 * + adds a lightning bolt to the list of lightning bolts in this world.
+ 	 */
+ 	/**
+ 	 * + adds a lightning bolt to the list of lightning bolts in this world.
+ 	 */

> INSERT  5 : 11  @  5

+ 	/**
+ 	 * + Called when an entity is spawned in the world. This includes players.
+ 	 */
+ 	/**
+ 	 * + Called when an entity is spawned in the world. This includes players.
+ 	 */

> INSERT  38 : 46  @  38

+ 	/**
+ 	 * + Schedule the entity for removal during the next tick. Marks the entity dead
+ 	 * in anticipation.
+ 	 */
+ 	/**
+ 	 * + Schedule the entity for removal during the next tick. Marks the entity dead
+ 	 * in anticipation.
+ 	 */

> INSERT  18 : 24  @  18

+ 	/**
+ 	 * + Do NOT use this method to remove normal entities- use normal removeEntity
+ 	 */
+ 	/**
+ 	 * + Do NOT use this method to remove normal entities- use normal removeEntity
+ 	 */

> INSERT  17 : 23  @  17

+ 	/**
+ 	 * + Adds a IWorldAccess to the list of worldAccesses
+ 	 */
+ 	/**
+ 	 * + Adds a IWorldAccess to the list of worldAccesses
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Removes a worldAccess from the worldAccesses object
+ 	 */
+ 	/**
+ 	 * + Removes a worldAccess from the worldAccesses object
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Returns a list of bounding boxes that collide with aabb excluding the
+ 	 * passed in entity's collision. Args: entity, aabb
+ 	 */
+ 	/**
+ 	 * + Returns a list of bounding boxes that collide with aabb excluding the
+ 	 * passed in entity's collision. Args: entity, aabb
+ 	 */

> INSERT  109 : 115  @  109

+ 	/**
+ 	 * + Returns the amount of skylight subtracted for the current time
+ 	 */
+ 	/**
+ 	 * + Returns the amount of skylight subtracted for the current time
+ 	 */

> INSERT  11 : 17  @  11

+ 	/**
+ 	 * + Returns the sun brightness - checks time of day, rain and thunder
+ 	 */
+ 	/**
+ 	 * + Returns the sun brightness - checks time of day, rain and thunder
+ 	 */

> INSERT  10 : 16  @  10

+ 	/**
+ 	 * + Calculates the color for the skybox
+ 	 */
+ 	/**
+ 	 * + Calculates the color for the skybox
+ 	 */

> INSERT  50 : 56  @  50

+ 	/**
+ 	 * + calls calculateCelestialAngle
+ 	 */
+ 	/**
+ 	 * + calls calculateCelestialAngle
+ 	 */

> INSERT  8 : 16  @  8

+ 	/**
+ 	 * + gets the current fullness of the moon expressed as a float between 1.0 and
+ 	 * 0.0, in steps of .25
+ 	 */
+ 	/**
+ 	 * + gets the current fullness of the moon expressed as a float between 1.0 and
+ 	 * 0.0, in steps of .25
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Return getCelestialAngle()*2*PI
+ 	 */
+ 	/**
+ 	 * + Return getCelestialAngle()*2*PI
+ 	 */

> INSERT  36 : 42  @  36

+ 	/**
+ 	 * + Returns vector(ish) with R/G/B for fog
+ 	 */
+ 	/**
+ 	 * + Returns vector(ish) with R/G/B for fog
+ 	 */

> INSERT  9 : 17  @  9

+ 	/**
+ 	 * + Finds the highest block on the x and z coordinate that is solid or liquid,
+ 	 * and returns its y coord.
+ 	 */
+ 	/**
+ 	 * + Finds the highest block on the x and z coordinate that is solid or liquid,
+ 	 * and returns its y coord.
+ 	 */

> INSERT  17 : 23  @  17

+ 	/**
+ 	 * + How bright are stars in the sky
+ 	 */
+ 	/**
+ 	 * + How bright are stars in the sky
+ 	 */

> INSERT  16 : 22  @  16

+ 	/**
+ 	 * + Updates (and cleans up) entities and tile entities
+ 	 */
+ 	/**
+ 	 * + Updates (and cleans up) entities and tile entities
+ 	 */

> INSERT  170 : 178  @  170

+ 	/**
+ 	 * + Will update the entity in the world if the chunk the entity is in is
+ 	 * currently loaded. Args: entity
+ 	 */
+ 	/**
+ 	 * + Will update the entity in the world if the chunk the entity is in is
+ 	 * currently loaded. Args: entity
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Will update the entity in the world if the chunk the entity is in is
+ 	 * currently loaded or its forced to update. Args: entity, forceUpdate
+ 	 */
+ 	/**
+ 	 * + Will update the entity in the world if the chunk the entity is in is
+ 	 * currently loaded or its forced to update. Args: entity, forceUpdate
+ 	 */

> INSERT  71 : 79  @  71

+ 	/**
+ 	 * + Returns true if there are no solid, live entities in the specified
+ 	 * AxisAlignedBB, excluding the given entity
+ 	 */
+ 	/**
+ 	 * + Returns true if there are no solid, live entities in the specified
+ 	 * AxisAlignedBB, excluding the given entity
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Returns true if there are no solid, live entities in the specified
+ 	 * AxisAlignedBB, excluding the given entity
+ 	 */
+ 	/**
+ 	 * + Returns true if there are no solid, live entities in the specified
+ 	 * AxisAlignedBB, excluding the given entity
+ 	 */

> INSERT  14 : 22  @  14

+ 	/**
+ 	 * + Returns true if there are any blocks in the region constrained by an
+ 	 * AxisAlignedBB
+ 	 */
+ 	/**
+ 	 * + Returns true if there are any blocks in the region constrained by an
+ 	 * AxisAlignedBB
+ 	 */

> INSERT  23 : 29  @  23

+ 	/**
+ 	 * + Returns if any of the blocks within the aabb are liquids. Args: aabb
+ 	 */
+ 	/**
+ 	 * + Returns if any of the blocks within the aabb are liquids. Args: aabb
+ 	 */

> INSERT  48 : 56  @  48

+ 	/**
+ 	 * + handles the acceleration of an object whilst in water. Not sure if it is
+ 	 * used elsewhere.
+ 	 */
+ 	/**
+ 	 * + handles the acceleration of an object whilst in water. Not sure if it is
+ 	 * used elsewhere.
+ 	 */

> INSERT  44 : 50  @  44

+ 	/**
+ 	 * + Returns true if the given bounding box contains the given material
+ 	 */
+ 	/**
+ 	 * + Returns true if the given bounding box contains the given material
+ 	 */

> INSERT  23 : 29  @  23

+ 	/**
+ 	 * + checks if the given AABB is in the material given. Used while swimming.
+ 	 */
+ 	/**
+ 	 * + checks if the given AABB is in the material given. Used while swimming.
+ 	 */

> INSERT  32 : 38  @  32

+ 	/**
+ 	 * + Creates an explosion. Args: entity, x, y, z, strength
+ 	 */
+ 	/**
+ 	 * + Creates an explosion. Args: entity, x, y, z, strength
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + returns a new explosion. Does initiation (at time of writing Explosion is
+ 	 * not finished)
+ 	 */
+ 	/**
+ 	 * + returns a new explosion. Does initiation (at time of writing Explosion is
+ 	 * not finished)
+ 	 */

> INSERT  8 : 16  @  8

+ 	/**
+ 	 * + Gets the percentage of real blocks within within a bounding box, along a
+ 	 * specified vector.
+ 	 */
+ 	/**
+ 	 * + Gets the percentage of real blocks within within a bounding box, along a
+ 	 * specified vector.
+ 	 */

> INSERT  31 : 37  @  31

+ 	/**
+ 	 * + Attempts to extinguish a fire
+ 	 */
+ 	/**
+ 	 * + Attempts to extinguish a fire
+ 	 */

> INSERT  11 : 17  @  11

+ 	/**
+ 	 * + This string is 'All: (number of loaded entities)' Viewable by press ing F3
+ 	 */
+ 	/**
+ 	 * + This string is 'All: (number of loaded entities)' Viewable by press ing F3
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Returns the name of the current chunk provider, by calling
+ 	 * chunkprovider.makeString()
+ 	 */
+ 	/**
+ 	 * + Returns the name of the current chunk provider, by calling
+ 	 * chunkprovider.makeString()
+ 	 */

> INSERT  77 : 83  @  77

+ 	/**
+ 	 * + Adds the specified TileEntity to the pending removal list.
+ 	 */
+ 	/**
+ 	 * + Adds the specified TileEntity to the pending removal list.
+ 	 */

> INSERT  23 : 29  @  23

+ 	/**
+ 	 * + Checks if a block's material is opaque, and that it takes up a full cube
+ 	 */
+ 	/**
+ 	 * + Checks if a block's material is opaque, and that it takes up a full cube
+ 	 */

> INSERT  14 : 22  @  14

+ 	/**
+ 	 * + Called on construction of the World class to setup the initial skylight
+ 	 * values
+ 	 */
+ 	/**
+ 	 * + Called on construction of the World class to setup the initial skylight
+ 	 * values
+ 	 */

> INSERT  8 : 14  @  8

+ 	/**
+ 	 * + first boolean for hostile mobs and second for peaceful mobs
+ 	 */
+ 	/**
+ 	 * + first boolean for hostile mobs and second for peaceful mobs
+ 	 */

> INSERT  5 : 11  @  5

+ 	/**
+ 	 * + Runs a single tick for the world
+ 	 */
+ 	/**
+ 	 * + Runs a single tick for the world
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Called from World constructor to set rainingStrength and thunderingStrength
+ 	 */
+ 	/**
+ 	 * + Called from World constructor to set rainingStrength and thunderingStrength
+ 	 */

> INSERT  10 : 16  @  10

+ 	/**
+ 	 * + Updates all weather states.
+ 	 */
+ 	/**
+ 	 * + Updates all weather states.
+ 	 */

> DELETE  1  @  1 : 59

> DELETE  40  @  40 : 64

> CHANGE  8 : 9  @  8 : 9

~ 	public void forceBlockUpdateTick(Block blockType, BlockPos pos, EaglercraftRandom random) {

> INSERT  13 : 19  @  13

+ 	/**
+ 	 * + Checks to see if a given block is both water and cold enough to freeze.
+ 	 */
+ 	/**
+ 	 * + Checks to see if a given block is both water and cold enough to freeze.
+ 	 */

> INSERT  31 : 37  @  31

+ 	/**
+ 	 * + Checks to see if a given block can accumulate snow from it snowing
+ 	 */
+ 	/**
+ 	 * + Checks to see if a given block can accumulate snow from it snowing
+ 	 */

> INSERT  29 : 35  @  29

+ 	/**
+ 	 * + gets the light level at the supplied position
+ 	 */
+ 	/**
+ 	 * + gets the light level at the supplied position
+ 	 */

> INSERT  150 : 156  @  150

+ 	/**
+ 	 * + Runs through the list of updates to run and ticks them
+ 	 */
+ 	/**
+ 	 * + Runs through the list of updates to run and ticks them
+ 	 */

> CHANGE  8 : 16  @  8 : 12

~ 	/**
~ 	 * + Will get all entities within the specified AABB excluding the one passed
~ 	 * into it. Args: entityToExclude, aabb
~ 	 */
~ 	/**
~ 	 * + Will get all entities within the specified AABB excluding the one passed
~ 	 * into it. Args: entityToExclude, aabb
~ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Gets all entities within the specified AABB excluding the one passed into
+ 	 * it. Args: entityToExclude, aabb, predicate
+ 	 */
+ 	/**
+ 	 * + Gets all entities within the specified AABB excluding the one passed into
+ 	 * it. Args: entityToExclude, aabb, predicate
+ 	 */

> CHANGE  24 : 25  @  24 : 25

~ 			if (entityType.isAssignableFrom(entity.getClass()) && filter.apply((T) entity)) {

> CHANGE  10 : 12  @  10 : 12

~ 		for (EntityPlayer entity : this.playerEntities) {
~ 			if (playerType.isAssignableFrom(entity.getClass()) && filter.apply((T) entity)) {

> INSERT  50 : 58  @  50

+ 	/**
+ 	 * + Returns the Entity with the given ID, or null if it doesn't exist in this
+ 	 * World.
+ 	 */
+ 	/**
+ 	 * + Returns the Entity with the given ID, or null if it doesn't exist in this
+ 	 * World.
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Accessor for world Loaded Entity List
+ 	 */
+ 	/**
+ 	 * + Accessor for world Loaded Entity List
+ 	 */

> INSERT  11 : 19  @  11

+ 	/**
+ 	 * + Counts how many entities of an entity class exist in the world. Args:
+ 	 * entityClass
+ 	 */
+ 	/**
+ 	 * + Counts how many entities of an entity class exist in the world. Args:
+ 	 * entityClass
+ 	 */

> INSERT  44 : 52  @  44

+ 	/**
+ 	 * + Returns the single highest strong power out of all directions using
+ 	 * getStrongPower(BlockPos, EnumFacing)
+ 	 */
+ 	/**
+ 	 * + Returns the single highest strong power out of all directions using
+ 	 * getStrongPower(BlockPos, EnumFacing)
+ 	 */

> INSERT  9 : 17  @  9

+ 	/**
+ 	 * + Returns the single highest strong power out of all directions using
+ 	 * getStrongPower(BlockPos, EnumFacing)
+ 	 */
+ 	/**
+ 	 * + Returns the single highest strong power out of all directions using
+ 	 * getStrongPower(BlockPos, EnumFacing)
+ 	 */

> INSERT  50 : 58  @  50

+ 	/**
+ 	 * + Checks if the specified block or its neighbors are powered by a neighboring
+ 	 * block. Used by blocks like TNT and Doors.
+ 	 */
+ 	/**
+ 	 * + Checks if the specified block or its neighbors are powered by a neighboring
+ 	 * block. Used by blocks like TNT and Doors.
+ 	 */

> INSERT  17 : 25  @  17

+ 	/**
+ 	 * + Gets the closest player to the entity within the specified distance (if
+ 	 * distance is less than 0 then ignored). Args: entity, dist
+ 	 */
+ 	/**
+ 	 * + Gets the closest player to the entity within the specified distance (if
+ 	 * distance is less than 0 then ignored). Args: entity, dist
+ 	 */

> INSERT  4 : 14  @  4

+ 	/**
+ 	 * + Gets the closest player to the point within the specified distance
+ 	 * (distance can be set to less than 0 to not limit the distance). Args: x, y,
+ 	 * z, dist
+ 	 */
+ 	/**
+ 	 * + Gets the closest player to the point within the specified distance
+ 	 * (distance can be set to less than 0 to not limit the distance). Args: x, y,
+ 	 * z, dist
+ 	 */

> INSERT  32 : 38  @  32

+ 	/**
+ 	 * + Find a player by name in this world.
+ 	 */
+ 	/**
+ 	 * + Find a player by name in this world.
+ 	 */

> CHANGE  11 : 12  @  11 : 12

~ 	public EntityPlayer getPlayerEntityByUUID(EaglercraftUUID uuid) {

> INSERT  10 : 16  @  10

+ 	/**
+ 	 * + If on MP, sends a quitting packet.
+ 	 */
+ 	/**
+ 	 * + If on MP, sends a quitting packet.
+ 	 */

> INSERT  3 : 9  @  3

+ 	/**
+ 	 * + Checks whether the session lock file was modified by another process
+ 	 */
+ 	/**
+ 	 * + Checks whether the session lock file was modified by another process
+ 	 */

> INSERT  8 : 14  @  8

+ 	/**
+ 	 * + gets the random world seed
+ 	 */
+ 	/**
+ 	 * + gets the random world seed
+ 	 */

> INSERT  12 : 18  @  12

+ 	/**
+ 	 * + Sets the world time.
+ 	 */
+ 	/**
+ 	 * + Sets the world time.
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Gets the spawn point in the world
+ 	 */
+ 	/**
+ 	 * + Gets the spawn point in the world
+ 	 */

> INSERT  15 : 21  @  15

+ 	/**
+ 	 * + spwans an entity and loads surrounding chunks
+ 	 */
+ 	/**
+ 	 * + spwans an entity and loads surrounding chunks
+ 	 */

> INSERT  21 : 27  @  21

+ 	/**
+ 	 * + sends a Packet 38 (Entity Status) to all tracked players of that entity
+ 	 */
+ 	/**
+ 	 * + sends a Packet 38 (Entity Status) to all tracked players of that entity
+ 	 */

> INSERT  3 : 9  @  3

+ 	/**
+ 	 * + gets the world's chunk provider
+ 	 */
+ 	/**
+ 	 * + gets the world's chunk provider
+ 	 */

> INSERT  8 : 14  @  8

+ 	/**
+ 	 * + Returns this world's current save handler
+ 	 */
+ 	/**
+ 	 * + Returns this world's current save handler
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Returns the world's WorldInfo object
+ 	 */
+ 	/**
+ 	 * + Returns the world's WorldInfo object
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Gets the GameRules instance.
+ 	 */
+ 	/**
+ 	 * + Gets the GameRules instance.
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Updates the flag that indicates whether or not all players in the world are
+ 	 * sleeping.
+ 	 */
+ 	/**
+ 	 * + Updates the flag that indicates whether or not all players in the world are
+ 	 * sleeping.
+ 	 */

> INSERT  8 : 14  @  8

+ 	/**
+ 	 * + Sets the strength of the thunder.
+ 	 */
+ 	/**
+ 	 * + Sets the strength of the thunder.
+ 	 */

> INSERT  5 : 11  @  5

+ 	/**
+ 	 * + Returns rain strength.
+ 	 */
+ 	/**
+ 	 * + Returns rain strength.
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Sets the strength of the rain.
+ 	 */
+ 	/**
+ 	 * + Sets the strength of the rain.
+ 	 */

> INSERT  5 : 13  @  5

+ 	/**
+ 	 * + Returns true if the current thunder strength (weighted with the rain
+ 	 * strength) is greater than 0.9
+ 	 */
+ 	/**
+ 	 * + Returns true if the current thunder strength (weighted with the rain
+ 	 * strength) is greater than 0.9
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Returns true if the current rain strength is greater than 0.2
+ 	 */
+ 	/**
+ 	 * + Returns true if the current rain strength is greater than 0.2
+ 	 */

> INSERT  27 : 35  @  27

+ 	/**
+ 	 * + Assigns the given String id to the given MapDataBase using the MapStorage,
+ 	 * removing any existing ones of the same id.
+ 	 */
+ 	/**
+ 	 * + Assigns the given String id to the given MapDataBase using the MapStorage,
+ 	 * removing any existing ones of the same id.
+ 	 */

> INSERT  4 : 14  @  4

+ 	/**
+ 	 * + Loads an existing MapDataBase corresponding to the given String id from
+ 	 * disk using the MapStorage, instantiating the given Class, or returns null if
+ 	 * none such file exists. args: Class to instantiate, String dataid
+ 	 */
+ 	/**
+ 	 * + Loads an existing MapDataBase corresponding to the given String id from
+ 	 * disk using the MapStorage, instantiating the given Class, or returns null if
+ 	 * none such file exists. args: Class to instantiate, String dataid
+ 	 */

> INSERT  4 : 12  @  4

+ 	/**
+ 	 * + Returns an unique new data id from the MapStorage for the given prefix and
+ 	 * saves the idCounts map to the 'idcounts' file.
+ 	 */
+ 	/**
+ 	 * + Returns an unique new data id from the MapStorage for the given prefix and
+ 	 * saves the idCounts map to the 'idcounts' file.
+ 	 */

> INSERT  32 : 38  @  32

+ 	/**
+ 	 * + Returns maximum world height.
+ 	 */
+ 	/**
+ 	 * + Returns maximum world height.
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Returns current world height.
+ 	 */
+ 	/**
+ 	 * + Returns current world height.
+ 	 */

> CHANGE  4 : 11  @  4 : 5

~ 	/**
~ 	 * + puts the World Random seed to a specific state dependant on the inputs
~ 	 */
~ 	/**
~ 	 * + puts the World Random seed to a specific state dependant on the inputs
~ 	 */
~ 	public EaglercraftRandom setRandomSeed(int parInt1, int parInt2, int parInt3) {

> INSERT  10 : 16  @  10

+ 	/**
+ 	 * + set by !chunk.getAreLevelsEmpty
+ 	 */
+ 	/**
+ 	 * + set by !chunk.getAreLevelsEmpty
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Returns horizon height for use in rendering the sky.
+ 	 */
+ 	/**
+ 	 * + Returns horizon height for use in rendering the sky.
+ 	 */

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Adds some basic stats of the world to the given crash report.
+ 	 */
+ 	/**
+ 	 * + Adds some basic stats of the world to the given crash report.
+ 	 */

> INSERT  32 : 38  @  32

+ 	/**
+ 	 * + returns a calendar object containing the current date
+ 	 */
+ 	/**
+ 	 * + returns a calendar object containing the current date
+ 	 */

> CHANGE  2 : 3  @  2 : 3

~ 			this.theCalendar.setTimeInMillis(System.currentTimeMillis());

> DELETE  67  @  67 : 71

> INSERT  4 : 10  @  4

+ 	/**
+ 	 * + Returns true if the chunk is located near the spawn point
+ 	 */
+ 	/**
+ 	 * + Returns true if the chunk is located near the spawn point
+ 	 */

> EOF
