# EntityData

A typical EntityData object will have the following properties:
- `x`: Number: Equal to the entity's `posX`.
- `y`: Number: Equal to the entity's `posY`.
- `z`: Number: Equal to the entity's `posZ`.
- `chunkCoordX`: Number: Equal to the entity's `chunkCoordX`. (Read-only)
- `chunkCoordY`: Number: Equal to the entity's `chunkCoordY`. (Read-only)
- `chunkCoordZ`: Number: Equal to the entity's `chunkCoordZ`. (Read-only)
- `motionX`: Number: Equal to the entity's `motionX`.
- `motionY`: Number: Equal to the entity's `motionY`.
- `motionZ`: Number: Equal to the entity's `motionZ`.
- `yaw`: Number: Equal to the entity's `rotationYaw`.
- `pitch`: Number: Equal to the entity's `rotationPitch`.
- `isInWeb`: Boolean: Equal to the entity's `isInWeb`.
- `isCollided`: Boolean: Equal to the entity's `isCollided`.
- `isCollidedVertically`: Boolean: Equal to the entity's `isCollidedVertically`.
- `isCollidedHorizontally`: Boolean: Equal to the entity's `isCollidedHorizontally`.
- `onGround`: Boolean: Equal to the entity's `onGround`.
- `dimension`: Integer: Equal to the entity's `dimension`. (Read-only)
- `id`: Integer: Equal to the entity's `entityId`. (Read-only)
- `fallDistance`: Number: Equal to the entity's `fallDistance`. (Read-only)
- `noClip`: Boolean: Equal to the entity's `noClip`.
- `stepHeight`: Number: Equal to the entity's `stepHeight`.
- `isDead`: Boolean: Equal to the entity's `isDead`. (Read-only)
- `inPortal`: Boolean: Equal to the entity's `inPortal`.
- `inWater`: Boolean: Equal to the entity's `inWater`.
- `isAirBorne`: Boolean: Equal to the entity's `isAirBorne`.
- `ticksExisted`: Integer: Equal to the entity's `ticksExisted`. (Read-only)
- `invulnerable`: Boolean: Equal to the entity's `invulnerable`.
- `isImmuneToFire`: Boolean: Equal to the entity's `isImmuneToFire`.
- `isOutsideBorder`: Boolean: Equal to the entity's `isOutsideBorder`.
- `entityCollisionReduction`: Number: Equal to the entity's `entityCollisionReduction`.

Hello. This doc isn't done. At all. Just understand that almost all of the functions listed here take the same arguments and have the same return type as in the normal `Entity.java`.
However, rather than taking a list of arguments `func(a = 1, b = 2, c = 3)` they either take an object or nothing: `func({a: 1, b: 2, c: 3})`. I do this so I don't have to manually write interfaces for every combination possible. Good luck understanding the code below!

```
data.setCallbackBoolean("isBurning", ()->{return isBurning();});
data.setCallbackBoolean("isPushedByWater", ()->{return isPushedByWater();});
data.setCallbackBoolean("isEating", ()->{return isEating();});
data.setCallbackBoolean("isEntityAlive", ()->{return isEntityAlive();});
data.setCallbackBoolean("isEntityInsideOpaqueBlock", ()->{return isEntityInsideOpaqueBlock();});
data.setCallbackBoolean("isImmuneToExplosions", ()->{return isImmuneToExplosions();});
data.setCallbackBoolean("isImmuneToFire", ()->{return isImmuneToFire();});
data.setCallbackBoolean("isInLava", ()->{return isInLava();});
data.setCallbackBooleanWithDataArg("isInRangeToRender3d", (BaseData params)->{return isInRangeToRender3d(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));});
data.setCallbackBooleanWithDataArg("isInRangeToRenderDist", (BaseData params)->{return isInRangeToRenderDist(params.getDouble("distance"));});
data.setCallbackBoolean("isInWater", ()->{return isInWater();});
data.setCallbackBoolean("isInvisible", ()->{return isInvisible();});
data.setCallbackBoolean("isPushedByWater", ()->{return isPushedByWater();});
data.setCallbackBoolean("isRiding", ()->{return isRiding();});
data.setCallbackBoolean("isSilent", ()->{return isSilent();});
data.setCallbackBoolean("isSneaking", ()->{return isSneaking();});
data.setCallbackBoolean("isSprinting", ()->{return isSprinting();});
data.setCallbackBoolean("isWet", ()->{return isWet();});

data.setCallbackVoidWithDataArg("setAir", (BaseData params)->{setAir(params.getInt("air"));});
data.setCallbackVoidWithDataArg("setAlwaysRenderNameTag", (BaseData params)->{setAlwaysRenderNameTag(params.getBoolean("alwaysRenderNameTag"));});
data.setCallbackVoidWithDataArg("setAngles", (BaseData params)->{setAngles(params.getFloat("yaw"),params.getFloat("pitch"));});
data.setCallbackVoid("setBeenAttacked", ()->{setBeenAttacked();});
data.setCallbackVoidWithDataArg("setCustomNameTag", (BaseData params)->{setCustomNameTag(params.getString("name"));});
data.setCallbackVoid("setDead", ()->{setDead();});
data.setCallbackVoidWithDataArg("setEating", (BaseData params)->{setEating(params.getBoolean("eating"));});
data.setCallbackVoidWithDataArg("setEntityId", (BaseData params)->{setEntityId(params.getInt("id"));});
data.setCallbackVoidWithDataArg("setFire", (BaseData params)->{setFire(params.getInt("seconds"));});
data.setCallbackVoidWithDataArg("setFlag", (BaseData params)->{setFlag(params.getInt("flag"), params.getBoolean("set"));});
data.setCallbackVoid("setInWeb", ()->{setInWeb();});
data.setCallbackVoidWithDataArg("setInvisible", (BaseData params)->{setInvisible(params.getBoolean("invisible"));});
data.setCallbackVoidWithDataArg("setLocationAndAngles", (BaseData params)->{setLocationAndAngles(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"), params.getFloat("yaw"), params.getFloat("pitch"));});
data.setCallbackVoid("setOnFireFromLava", ()->{setOnFireFromLava();});
data.setCallbackVoidWithDataArg("setOutsideBorder", (BaseData params)->{setOutsideBorder(params.getBoolean("outsideBorder"));});
data.setCallbackVoidWithDataArg("setPosition", (BaseData params)->{setPosition(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));});
data.setCallbackVoidWithDataArg("setPositionAndRotation", (BaseData params)->{setPositionAndRotation(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"), params.getFloat("yaw"), params.getFloat("pitch"));});
data.setCallbackVoidWithDataArg("setPositionAndRotation2", (BaseData params)->{setPositionAndRotation2(params.getDouble("d0"), params.getDouble("d1"), params.getDouble("d2"), params.getFloat("f"), params.getFloat("f1"), params.getInt("var9"), params.getBoolean("var10"));});
data.setCallbackVoidWithDataArg("setPositionAndUpdate", (BaseData params)->{setPositionAndUpdate(params.getDouble("d0"), params.getDouble("d1"), params.getDouble("d2"));});
data.setCallbackVoidWithDataArg("setRotation", (BaseData params)->{setRotation(params.getFloat("yaw"),params.getFloat("pitch"));});
data.setCallbackVoidWithDataArg("setRotationYawHead", (BaseData params)->{setRotationYawHead(params.getFloat("rotation"));});
data.setCallbackVoidWithDataArg("setSilent", (BaseData params)->{setSilent(params.getBoolean("isSilent"));});
data.setCallbackVoidWithDataArg("setSize", (BaseData params)->{setSize(params.getFloat("f"), params.getFloat("f1"));});
data.setCallbackVoidWithDataArg("setSneaking", (BaseData params)->{setSneaking(params.getBoolean("sneaking"));});
data.setCallbackVoidWithDataArg("setSprinting", (BaseData params)->{setSprinting(params.getBoolean("flag"));});
data.setCallbackVoidWithDataArg("setVelocity", (BaseData params)->{setVelocity(params.getDouble("x"), params.getDouble("y"), params.getDouble("z"));});

data.setCallbackString("getUUID", ()->{return entityUniqueID.toString();});
```