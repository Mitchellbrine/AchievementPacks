package mc.Mitchellbrine.achevementPacks.packs;

import mc.Mitchellbrine.achevementPacks.api.AchievementPack;
import mc.Mitchellbrine.achevementPacks.api.CraftingAchievement;
import mc.Mitchellbrine.achevementPacks.api.PickupAchievement;
import mc.Mitchellbrine.achevementPacks.api.SmeltingAchievement;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class TestPack {

    public static Achievement pickupIronIngot;
    public static Achievement wood;
    public static Achievement stone;

    public static AchievementPack test;


    public static void init() {
        pickupIronIngot = new PickupAchievement(Items.iron_ingot,"iron","iron",0,0,new ItemStack(Items.iron_ingot),null).initIndependentStat().registerStat();
        wood = new CraftingAchievement(Blocks.planks,"wood","wood",0,2,new ItemStack(Blocks.planks),null).initIndependentStat().registerStat();
        stone = new SmeltingAchievement(new ItemStack(Blocks.stone),"stone","stone",0,4,new ItemStack(Blocks.stone),null).initIndependentStat().registerStat();

        AchievementPack.registerAchievement(pickupIronIngot);
        AchievementPack.registerAchievement(wood);
        AchievementPack.registerAchievement(stone);

        test = new AchievementPack("Getting Started","1.0","https://dl.dropboxusercontent.com/u/133619815/WeatherCarpetsStable.txt",new Achievement[]{pickupIronIngot,wood,stone});

    }

}
