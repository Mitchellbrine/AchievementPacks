package mc.Mitchellbrine.achevementPacks.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import mc.Mitchellbrine.achevementPacks.api.*;
import mc.Mitchellbrine.achevementPacks.util.ErrorMessages;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class AchievementEvents {

    @SubscribeEvent
    public void craftingEvent(PlayerEvent.ItemCraftedEvent event) {

        for (int i = 0; i < AchievementPacksMain.craftingAchievements.size();i++) {
            if (AchievementPacksMain.craftingAchievements.get(i) instanceof CraftingAchievement) {
                CraftingAchievement ach = (CraftingAchievement) AchievementPacksMain.craftingAchievements.get(i);
                if (event.crafting != null && ach.getEventItem() != null && event.crafting.getItem() == ach.getEventItem().getItem()) {
                    event.player.addStat(ach,1);
                }
            }
        }

    }

    @SubscribeEvent
    public void smeltingEvent(PlayerEvent.ItemSmeltedEvent event) {
        for (int i = 0; i < AchievementPacksMain.smeltingAchievements.size();i++) {
            if (AchievementPacksMain.smeltingAchievements.get(i) != null) {
                if (AchievementPacksMain.smeltingAchievements.get(i) instanceof SmeltingAchievement) {
                    SmeltingAchievement ach = (SmeltingAchievement) AchievementPacksMain.smeltingAchievements.get(i);
                    if (event.smelting != null && ach.getEventItem() != null && event.smelting.getItem() == ach.getEventItem().getItem()) {
                        event.player.addStat(ach, 1);
                    }
                }
            }

        }
    }

    @SubscribeEvent
    public void pickupEvent(PlayerEvent.ItemPickupEvent event) {
        for (int i = 0; i < AchievementPacksMain.pickupAchievements.size();i++) {
            if (AchievementPacksMain.pickupAchievements.get(i) instanceof PickupAchievement) {
                PickupAchievement ach = (PickupAchievement) AchievementPacksMain.pickupAchievements.get(i);
                if (event.pickedUp != null && event.pickedUp.getEntityItem() != null && event.pickedUp.getEntityItem().getItem() != null && ach.getEventItem() != null && event.pickedUp.getEntityItem().getItem() == ach.getEventItem()) {
                    event.player.addStat(ach,1);
                }
            }
        }
    }

    @SubscribeEvent
    public void killEvent(LivingDeathEvent event) {
        if (event.source != null && event.source.getEntity() != null) {
            if (event.source.getEntity() instanceof EntityPlayer) {
                for (int i = 0; i < AchievementPacksMain.killAchievements.size(); i++) {
                    if (AchievementPacksMain.killAchievements.get(i) instanceof KillAchievement) {
                        KillAchievement ach = (KillAchievement) AchievementPacksMain.killAchievements.get(i);

                        if (event.entityLiving != null && ach.getEntity() != null && EntityList.getEntityString(event.entityLiving).equalsIgnoreCase(ach.getEntity())) {
                            ((EntityPlayer) event.source.getEntity()).addStat(ach, 1);
                        }
                        else if (!EntityList.getEntityString(event.entityLiving).equalsIgnoreCase(ach.getEntity())) {
                            ErrorMessages.compareError(ach.getEntity(), EntityList.getEntityString(event.entityLiving));
                        }

                    }
                }
            }
        }
    }

}
