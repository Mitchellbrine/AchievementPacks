package mc.Mitchellbrine.achevementPacks.api;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class PackCompletionAchievement extends Achievement{

    private AchievementPack pack;

    public PackCompletionAchievement(AchievementPack pack, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, new ItemStack(Items.nether_star), p_i45302_6_);
        this.pack = pack;
    }

    public AchievementPack getPack() {
        return this.pack;
    }


}
