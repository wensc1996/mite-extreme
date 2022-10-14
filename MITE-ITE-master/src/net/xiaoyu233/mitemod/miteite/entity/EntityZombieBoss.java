package net.xiaoyu233.mitemod.miteite.entity;

import javafx.beans.binding.MapExpression;
import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.item.enchantment.Enchantments;
import net.xiaoyu233.mitemod.miteite.util.Configs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EntityZombieBoss extends EntityZombie {
    private Enchantment [] enhanceSpecialBookList = new Enchantment[] {Enchantment.protection, Enchantment.sharpness,  Enchantment.fortune, Enchantment.harvesting, Enchantments.EXTEND, Enchantment.efficiency, Enchantment.vampiric, Enchantment.butchering, Enchantments.enchantmentFixed, Enchantments.enchantmentChain, Enchantments.EMERGENCY};
    private int thunderTick = 0;
    private int attackedCounter = 200;

    private final HashMap activePotionsMap = new HashMap();

    public EntityZombieBoss(World par1World) {
        super(par1World);
    }

    protected void addRandomEquipment() {
        this.setCurrentItemOrArmor(0, new ItemStack(Items.VIBRANIUM_WAR_HAMMER, 1).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(1, new ItemStack(Items.VIBRANIUM_HELMET, 1).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(2, new ItemStack(Items.VIBRANIUM_CHESTPLATE, 1).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(3, new ItemStack(Items.VIBRANIUM_LEGGINGS, 1).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(4, new ItemStack(Items.VIBRANIUM_BOOTS, 1).randomizeForMob(this, true));
        this.addPotionEffect(new MobEffect(1, 2147483647, 0));
        this.addPotionEffect(new MobEffect(5, 2147483647, 0));
    }

    public void addPotionEffect(MobEffect par1PotionEffect) {
        if(par1PotionEffect.getPotionID() == 1 || par1PotionEffect.getPotionID() == 5) {
            super.addPotionEffect(par1PotionEffect);
        }
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player){
            Enchantment dropEnchantment = enhanceSpecialBookList[rand.nextInt(enhanceSpecialBookList.length)];
            ItemStack var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentInstance(dropEnchantment, dropEnchantment.getNumLevelsForVibranium()));
            this.dropItemStack(var11);
            this.dropItemStack(new ItemStack(Items.diamond, 10));
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(GenericAttributes.attackDamage, Configs.wenscConfig.zombieBossBaseDamage.ConfigValue);
        this.setEntityAttribute(GenericAttributes.maxHealth, Configs.wenscConfig.zombieBossMaxHealth.ConfigValue);
        this.setEntityAttribute(GenericAttributes.movementSpeed, 0.45D);
    }

    @Override
    protected void tryDamageArmor(DamageSource damage_source, float amount, EntityDamageResult result) {
    }

    public boolean isComfortableInLava()
    {
        return true;
    }

    public boolean getCanSpawnHere(boolean perform_light_check) {
        return true;
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    @Override
    public boolean handleWaterMovement() {
        return false;
    }

    public boolean canBeDisarmed() {
        return false;
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isPushedByWater() {
        return false;
    }


    @Override
    public boolean canNeverPickUpItem(Item item) {
        return true;
    }

    public boolean canBeKnockedBack() {
        return false;
    }

    @Override
    public EntityDamageResult attackEntityFrom(Damage damage) {
        if(damage.getSource().damageType.equals("player") || damage.getSource().damageType.equals("mob")) {
            if(damage.getSource().getResponsibleEntity() instanceof EntityIronGolem) {
                return null;
            }
            this.attackedCounter = 200;
            damage.setAmount(damage.getAmount() / 5);
            return super.attackEntityFrom(damage);
        } else {
            return null;
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("attackedCounter", (short)this.attackedCounter);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.attackedCounter = par1NBTTagCompound.getShort("attackedCounter");
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote){
            thunderTick ++;
            if(attackedCounter <= 0) {
                if(this.getHealth() < this.getMaxHealth()) {
                    this.heal(this.getMaxHealth());
                }
            } else {
                attackedCounter --;
            }
            if(thunderTick == 60) {
                List entities =  this.getNearbyEntities(16, 16);
                if(entities.size() > 0) {
                    Object targetPlayer = entities.get(rand.nextInt(entities.size()));
                    if(targetPlayer instanceof EntityPlayer) {
                        this.setTarget((EntityLiving)targetPlayer);
                    }
                }
                for (int i = 0; i< entities.size(); i++) {
                    if(entities.get(i) instanceof EntityPlayer) {
                        EntityPlayer player = ((EntityPlayer) entities.get(i));
                        player.isAttackByBossCounter = 200;
                        if(player.motionY != 0) {
                            if(!this.canPathTo(MathHelper.floor_double(player.getFootPos().xCoord), player.getFootBlockPosY(), MathHelper.floor_double(player.getFootPos().zCoord), 50)) {
                                WorldServer var20 = (WorldServer)this.worldObj;
                                var20.addWeatherEffect(new EntityLightning(var20, player.posX, player.posY, player.posZ));
                                player.attackEntityFrom(new Damage(DamageSource.divine_lightning, 10F));
                            }
                        } else {
                            if(!this.canPathTo(MathHelper.floor_double(player.getFootPos().xCoord), MathHelper.floor_double(player.getFootPos().yCoord), MathHelper.floor_double(player.getFootPos().zCoord), 50)) {
                                WorldServer var20 = (WorldServer)this.worldObj;
                                var20.addWeatherEffect(new EntityLightning(var20, player.posX, player.posY, player.posZ));
                                player.attackEntityFrom(new Damage(DamageSource.divine_lightning, 10F));
                            }
                        }
                    }
                }
                thunderTick = 0;
            }
        }
    }
}
