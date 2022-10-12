package net.xiaoyu233.mitemod.miteite.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.item.enchantment.Enchantments;

import java.util.Iterator;
import java.util.List;

public class EntityZombieBoss extends EntityZombie {
    private Enchantment [] enhanceSpecialBookList = new Enchantment[] {Enchantment.protection, Enchantment.sharpness,  Enchantment.fortune, Enchantment.harvesting, Enchantments.EXTEND, Enchantment.efficiency, Enchantment.vampiric, Enchantment.butchering, Enchantments.enchantmentFixed, Enchantments.enchantmentChain};
    private int thunderTick = 0;
    public EntityZombieBoss(World par1World) {
        super(par1World);
    }

    protected void addRandomEquipment() {
        this.setCurrentItemOrArmor(0, (new ItemStack(Items.VIBRANIUM_WAR_HAMMER, 1)).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(1, (new ItemStack(Items.VIBRANIUM_HELMET, 1)).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(2, (new ItemStack(Items.VIBRANIUM_CHESTPLATE, 1)).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(3, (new ItemStack(Items.VIBRANIUM_LEGGINGS, 1)).randomizeForMob(this, true));
        this.setCurrentItemOrArmor(4, (new ItemStack(Items.VIBRANIUM_BOOTS, 1)).randomizeForMob(this, true));
        this.addPotionEffect(new MobEffect(1, 2147483647, 0));
        this.addPotionEffect(new MobEffect(5, 2147483647, 0));
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player){
            Enchantment dropEnchantment = enhanceSpecialBookList[rand.nextInt(enhanceSpecialBookList.length)];
            ItemStack var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentInstance(dropEnchantment, dropEnchantment.getNumLevels()));
            this.dropItemStack(var11);
            this.dropItemStack(new ItemStack(Items.diamond, 10));
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(GenericAttributes.attackDamage, 12.0D);
        this.setEntityAttribute(GenericAttributes.maxHealth, 500);
        this.setEntityAttribute(GenericAttributes.movementSpeed, 0.3D);
    }

    public boolean canBeDisarmed() {
        return false;
    }

    public boolean canCatchFire() {
        return false;
    }

    @Override
    public EntityDamageResult attackEntityFrom(Damage damage) {
        if(damage.getSource().damageType.equals("player") || damage.getSource().damageType.equals("mob")) {
            return super.attackEntityFrom(damage);
        } else {
            return null;
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote){
            thunderTick ++;
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
                        if(!this.canPathTo(MathHelper.floor_double(player.getFootPos().xCoord), MathHelper.floor_double(player.getFootPos().yCoord), MathHelper.floor_double(player.getFootPos().zCoord), 50)) {
//                        player.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                            WorldServer var20 = (WorldServer)this.worldObj;
                            var20.addWeatherEffect(new EntityLightning(var20, player.posX, player.posY, player.posZ));
                            player.attackEntityFrom(new Damage(DamageSource.divine_lightning, 5F));
                        }
                    }
                }
                thunderTick = 0;
            }
        }
    }
}
