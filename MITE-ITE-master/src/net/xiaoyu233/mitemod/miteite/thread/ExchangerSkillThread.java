package net.xiaoyu233.mitemod.miteite.thread;

import net.minecraft.EntityPlayer;
import net.xiaoyu233.mitemod.miteite.entity.EntityExchanger;

public class ExchangerSkillThread extends Thread{
    public EntityPlayer target;
    public EntityExchanger entityExchanger;

    public ExchangerSkillThread(EntityExchanger entityExchanger) {
        this.target = (EntityPlayer)entityExchanger.getEntityToAttack();
        this.entityExchanger = entityExchanger;

    }
    public void run() {
        try {
            Thread.sleep(100L);
            if(target!= null) {
                double entiX = target.posX;
                double entiY = target.posY;
                double entiZ = target.posZ;
                double currentX = entityExchanger.posX;
                double currentY = entityExchanger.posY;
                double currentZ = entityExchanger.posZ;
                entityExchanger.teleportToTarget(entiX, entiY, entiZ);
                target.setPositionAndUpdate(currentX, currentY, currentZ);
            }
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }
}
