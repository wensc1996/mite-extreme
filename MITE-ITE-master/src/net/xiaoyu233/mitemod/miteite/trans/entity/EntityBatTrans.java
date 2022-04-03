package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.entity.EntityWanderingWitch;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityBat.class)
public class EntityBatTrans extends EntityAmbient {
    private boolean spawnedByWitch;
    private EntityWanderingWitch spawnerWitch;
    private int spawnWorldID;

    public EntityBatTrans(World par1World) {
        super(par1World);
    }

    @Inject(method = "<init>",at = @At("RETURN"))
    private void injectCtor(CallbackInfo callbackInfo){
        if (this.worldObj.isUnderworld()){
            this.spawnWorldID = 3;
        }
        if (this.worldObj.isOverworld()){
            this.spawnWorldID = 0;
        }
        if (this.worldObj.isTheNether()){
            this.spawnWorldID = 1;
        }
        if (this.worldObj.isTheEnd()){
            this.spawnWorldID = 2;
        }
    }

    @Override
    public void addPotionEffect(MobEffect par1PotionEffect) {
        if (!this.spawnedByWitch){
            super.addPotionEffect(par1PotionEffect);
        }
    }

//    @Override
//    public int getExperienceValue() {
//
//        return super.getExperienceValue();
//    }

    @Override
    public float getNaturalDefense(DamageSource damage_source) {
        if (spawnedByWitch){
            return damage_source.hasMagicAspect() && damage_source.isIndirect() ? Integer.MAX_VALUE : super.getNaturalDefense(damage_source);
        }
        return super.getNaturalDefense(damage_source);
    }

    @Inject(method = "readEntityFromNBT",at = @At("RETURN"))
    private void injectReadNBT(NBTTagCompound nbt, CallbackInfo callbackInfo){
        if (nbt.hasKey("SpawnedByWitch")){
            if (nbt.hasKey("SpawnWorldId")){
                this.spawnWorldID = nbt.getInteger("SpawnWorldId");
            }
            this.spawnedByWitch = nbt.getBoolean("SpawnedByWitch");
            Entity entityByID = this.worldObj.getAsWorldServer().p().worldServers[this.spawnWorldID].getEntityByID(nbt.getInteger("WitchSpawner"));
            if (entityByID == null){
                this.setDead();
            }
            this.spawnerWitch = (EntityWanderingWitch) entityByID;
        }
    }

    @Inject(method = "writeEntityToNBT",at = @At("RETURN"))
    private void injectWriteNBT(NBTTagCompound nbt, CallbackInfo callbackInfo){
        if (this.spawnedByWitch){
            nbt.setBoolean("SpawnedByWitch", true);
            nbt.setInteger("WitchSpawner",this.spawnerWitch.entityId);
            nbt.setInteger("SpawnWorldId",this.spawnWorldID);
        }
    }

    @Override
    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
        if (this.spawnerWitch != null && this.spawnerWitch.isEntityAlive()){
            this.spawnerWitch.onAllyBatsDeath();
        }
    }

    public void setSpawnedByWitch(boolean spawnedByWitch,EntityWanderingWitch witch) {
        this.spawnedByWitch = spawnedByWitch;
        this.spawnerWitch = witch;
    }
    @Override
    public int getExperienceValue() {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            this.dropItem(Items.manure);
        }
        if (this.spawnedByWitch){
            return 0;
        }

        int baseExp = 0;
        if (this.getClass().equals(EntityVampireBat.class)) {
            baseExp = 2;
        } else if (this.getClass().equals(EntityGiantVampireBat.class)) {
            baseExp = 4;
        } else if (this.getClass().equals(EntityNightwing.class)) {
            baseExp = 4;
        }

        int day = Math.max(this.getWorld().getDayOfWorld(), 1);
        int Temp = baseExp * day;
        int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        int level = 0;
        if (this.getLastHarmingEntity() instanceof EntityPlayer) {
            level = this.getLastHarmingEntity().getAsPlayer().getExperienceLevel();
        }

        Temp = baseExp * Math.max(level, 1);
        int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
        if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1")) {
            return exp1;
        } else {
            return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
        }
    }
}
