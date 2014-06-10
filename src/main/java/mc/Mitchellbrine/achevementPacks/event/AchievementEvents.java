package mc.Mitchellbrine.achevementPacks.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import mc.Mitchellbrine.achevementPacks.api.AchievementPack;
import mc.Mitchellbrine.achevementPacks.api.CraftingAchievement;
import mc.Mitchellbrine.achevementPacks.api.PickupAchievement;
import mc.Mitchellbrine.achevementPacks.api.SmeltingAchievement;
import mc.Mitchellbrine.achevementPacks.util.ErrorMessages;
import net.minecraft.stats.Achievement;

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

}
