package net.xiaoyu233.mitemod.miteite.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.thread.ExchangerSkillThread;

public class EntityExchanger extends EntitySkeleton {
    private int teleportDelay;

    public EntityExchanger(World par1World) {
        super(par1World);
    }

    @Override
    protected void addRandomEquipment() {
        this.setCurrentItemOrArmor(0, (new ItemStack(Items.enderPearl, 1)).randomizeForMob(this, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        int day = this.getWorld().getDayOfOverworld();
        double rate;
        if(day > 32 ){
            rate = (double)day / 16.0D;
        } else {
            rate = day / 16;
        }
        this.setEntityAttribute(GenericAttributes.attackDamage, 2.0D + rate * 3D);
        this.setEntityAttribute(GenericAttributes.maxHealth, 10.0D +  rate * 10D);
        this.setEntityAttribute(GenericAttributes.movementSpeed, 0.2572D);
    }

    @Override
    public boolean canBeDisarmed() {
        return false;
    }

    @Override
    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player){
            int count = 3;
            for (int i1 = 0; i1 < count; i1++) {
                this.dropItem(Item.arrowIron);
            }
        }
    }

    @Override
    protected EntityPlayer findPlayerToAttack(float max_distance) {
        EntityPlayer player = this.getClosestVulnerablePlayer((double)max_distance);
        return player;
    }

    @Override
    public boolean canCatchFire() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote){
            int var6;
            for (var6 = 0; var6 < 2; ++var6) {
                this.worldObj.spawnParticle(EnumParticle.portal_underworld, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }

            if(this.entityToAttack == null) {
                entityToAttack = this.findPlayerToAttack(32F);
                if (entityToAttack instanceof EntityPlayer) {
                    ((EntityPlayer) entityToAttack).addChatMessage("你已被转移骷髅注视,3S后转移");
                }
                this.teleportDelay = 0;
            } else {
                if(entityToAttack.isDead || getDistanceToEntity(entityToAttack) > 32F) {
                    if (entityToAttack instanceof EntityPlayer) {
                        ((EntityPlayer) entityToAttack).addChatMessage("转移骷髅已放弃注视你");
                    }
                    this.entityToAttack = null;
                    return;
                }
                if (this.teleportDelay < 70 && ++this.teleportDelay > 60) {
                    (new ExchangerSkillThread(this)).start();
                    this.teleportDelay = 70;
                }
            }
        }
    }

    public boolean teleportToTarget(double par1, double par3, double par5) {
        double var7 = this.posX;
        double var9 = this.posY;
        double var11 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        boolean var13 = false;
        int var14 = MathHelper.floor_double(this.posX);
        int var15 = MathHelper.floor_double(this.posY);
        int var16 = MathHelper.floor_double(this.posZ);

        if (this.worldObj.blockExists(var14, var15, var16)) {
            boolean var17 = false;

            while(!var17 && var15 > 0) {
                if (this.worldObj.isBlockSolid(var14, var15 - 1, var16)) {
                    var17 = true;
                } else {
                    --this.posY;
                    --var15;
                }
            }

            if (var17) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    var13 = true;
                }
            }
        }

        if (!var13) {
            this.setPosition(var7, var9, var11);
            return false;
        } else {
            int x = MathHelper.floor_double(this.posX);
            int y = MathHelper.floor_double(this.posY);
            int z = MathHelper.floor_double(this.posZ);
            World var10000 = this.worldObj;
            double distance = (double)World.getDistanceFromDeltas(this.posX - var7, this.posY - var9, this.posZ - var11);
            this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y, z, (new SignalData()).setByte(EnumParticle.portal_underworld.ordinal()).setShort((int)(8.0D * distance)).setApproxPosition((double)MathHelper.floor_double(var7), (double)MathHelper.floor_double(var9), (double)MathHelper.floor_double(var11)));
            this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y + 1, z, (new SignalData()).setByte(EnumParticle.portal_underworld.ordinal()).setShort((int)(8.0D * distance)).setApproxPosition((double)MathHelper.floor_double(var7), (double)MathHelper.floor_double(var9 + 1.0D), (double)MathHelper.floor_double(var11)));
            this.worldObj.playSoundEffect(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

}
