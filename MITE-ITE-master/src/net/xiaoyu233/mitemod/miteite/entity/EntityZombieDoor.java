package net.xiaoyu233.mitemod.miteite.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Constant;

public class EntityZombieDoor extends EntityZombie {
    private int spawnCounter;
    private int spawnSums;
    private boolean haveTryToSpawnExchanger = false;

    public EntityZombieDoor(World par1World) {
        super(par1World);
    }

    @Override
    protected void addRandomEquipment() {
        int day = this.getWorld().getDayOfOverworld();
        Item [] doorList = new Item[] {Items.doorAdamantium, Items.doorWood, Items.doorGold, Items.doorSilver, Items.doorIron, Items.doorCopper, Items.doorGold};
        this.setCurrentItemOrArmor(0, (new ItemStack(doorList[Constant.GARandom.nextInt(doorList.length - 1)], 1)).randomizeForMob(this, false));
        this.addPotionEffect(new MobEffect(MobEffectList.moveSpeed.id, 2147483647, 0));
        if( day / 32 >= 1) {
            this.addPotionEffect(new MobEffect(MobEffectList.damageBoost.id, 2147483647, 0));
        }
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
        this.setEntityAttribute(GenericAttributes.attackDamage, 4.0D + rate * 4D);
        this.setEntityAttribute(GenericAttributes.maxHealth, 10.0D + rate * 20D);
        this.setEntityAttribute(GenericAttributes.movementSpeed, 0.3D);
    }

    @Override
    public boolean canBeDisarmed() {
        return false;
    }

    @Override
    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player){
            int day = this.getWorld().getDayOfOverworld();
            int diamond_count = (day / 16) > 3 ? 3 : (day / 16);
            for (int i1 = 0; i1 < diamond_count; i1++) {
                this.dropItem(Item.emerald);
            }
        }
    }

    @Override
    public boolean canCatchFire() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote){
            EntityLiving target = this.getAttackTarget();
            if(target instanceof EntityPlayer) {
                if (spawnSums < 10) {
                    if (this.spawnCounter < 200) {
                        ++this.spawnCounter;
                    } else {
                        EntityZombie zombie = new EntityZombie(this.worldObj);
                        if (zombie.entityId == 207) {
                            return;
                        }
                        zombie.setPosition(this.posX, this.posY, this.posZ);
                        zombie.refreshDespawnCounter(-9600);
                        this.worldObj.spawnEntityInWorld(zombie);
                        zombie.onSpawnWithEgg(null);
                        zombie.setAttackTarget(this.getTarget());
                        zombie.entityFX(EnumEntityFX.summoned);
                        this.spawnCounter = 0;
                        ++spawnSums;
                    }
                }
                if(haveTryToSpawnExchanger == false) {
                    if( rand.nextInt(5) == 0) {
                        EntityExchanger entityExchanger = new EntityExchanger(this.worldObj);
                        entityExchanger.setPosition(this.posX, this.posY, this.posZ);
                        entityExchanger.refreshDespawnCounter(-9600);
                        this.worldObj.spawnEntityInWorld(entityExchanger);
                        entityExchanger.onSpawnWithEgg(null);
                        entityExchanger.setAttackTarget(this.getTarget());
                        entityExchanger.entityFX(EnumEntityFX.summoned);
                    }
                    this.haveTryToSpawnExchanger = true;
                }
            }
        }
    }
}
