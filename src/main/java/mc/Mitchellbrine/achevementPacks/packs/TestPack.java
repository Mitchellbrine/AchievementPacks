package mc.Mitchellbrine.achevementPacks.packs;

import mc.Mitchellbrine.achevementPacks.api.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class TestPack {

    public static Achievement pickupIronIngot;
    public static Achievement wood;
    public static Achievement stone;
    public static Achievement pig;

    public static AchievementPack test;


    public static void init() {
        pickupIronIngot = new PickupAchievement(Items.iron_ingot,"iron","iron",0,0,new ItemStack(Items.iron_ingot),null).initIndependentStat().registerStat();
        wood = new CraftingAchievement(Blocks.planks,"wood","wood",0,2,new ItemStack(Blocks.planks),null).initIndependentStat().registerStat();
        stone = new SmeltingAchievement(new ItemStack(Blocks.stone),"stone","stone",0,4,new ItemStack(Blocks.stone),null).initIndependentStat().registerStat();
        pig = new KillAchievement("Pig","pig","pig",0,6,new ItemStack(Items.porkchop),null).initIndependentStat().registerStat();

        test = new AchievementPack("Getting Started","1.0","https://dl.dropboxusercontent.com/u/133619815/gettingStarted.txt",new Achievement[]{pickupIronIngot,wood,stone,pig});

    }

}
