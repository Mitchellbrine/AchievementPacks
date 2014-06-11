package mc.Mitchellbrine.achevementPacks.packs;

import mc.Mitchellbrine.achevementPacks.api.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatList;

public class TestPack {

    public static Achievement pickupIronIngot;
    public static Achievement wood;
    public static Achievement stone;
    public static Achievement pig;
    public static Achievement mob;

    public static AchievementPack test;


    public static void init() {
        pickupIronIngot = new PickupAchievement(Items.iron_ingot,"iron","iron",0,0,new ItemStack(Items.iron_ingot),null).initIndependentStat().registerStat();
        wood = new CraftingAchievement(Blocks.planks,"wood","wood",0,2,new ItemStack(Blocks.planks),null).initIndependentStat().registerStat();
        stone = new SmeltingAchievement(new ItemStack(Blocks.stone),"stone","stone",0,4,new ItemStack(Blocks.stone),null).initIndependentStat().registerStat();
        pig = new KillAchievement("Pig","pig","pig",0,6,new ItemStack(Items.porkchop),null).initIndependentStat().registerStat();
        mob = new StatAchievement(StatList.mobKillsStat,10,"mob","mob",0,8,new ItemStack(Items.skull),null).initIndependentStat().registerStat();

        test = new AchievementPack("Getting Started","1.1","https://raw.githubusercontent.com/Mitchellbrine/AchievementPacks/master/packUpdaters/",new Achievement[]{pickupIronIngot,wood,stone,pig,mob});

    }

}
