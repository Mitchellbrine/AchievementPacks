package mc.Mitchellbrine.achevementPacks.api;

import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingAchievement extends Achievement{

    private ItemStack eventItem;

    public CraftingAchievement(Item itemStack, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, p_i45302_5_, p_i45302_6_);
        this.eventItem = new ItemStack(itemStack);
    }

    public CraftingAchievement(Block itemStack, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, p_i45302_5_, p_i45302_6_);
        this.eventItem = new ItemStack(itemStack);
    }

    public ItemStack getEventItem() {
        return this.eventItem;
    }
}
