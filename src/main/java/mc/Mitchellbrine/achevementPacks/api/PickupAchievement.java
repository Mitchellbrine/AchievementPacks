package mc.Mitchellbrine.achevementPacks.api;

import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class PickupAchievement extends Achievement{

    private Item eventItem;

    public PickupAchievement(Item item, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, p_i45302_5_, p_i45302_6_);
        this.eventItem = item;
    }

    public Item getEventItem() {
        return eventItem;
    }
}
