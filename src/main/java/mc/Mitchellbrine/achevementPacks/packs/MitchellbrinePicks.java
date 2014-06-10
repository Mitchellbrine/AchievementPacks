package mc.Mitchellbrine.achevementPacks.packs;

import mc.Mitchellbrine.achevementPacks.api.AchievementPack;
import mc.Mitchellbrine.achevementPacks.api.CraftingAchievement;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MitchellbrinePicks {

    public static Achievement solla;
    public static Achievement goldenTicket;
    public static Achievement rich;
    public static Achievement yopp;
    public static Achievement waste;
    public static Achievement possible;

    public static AchievementPack mBrine;

    public static void init() {
        solla = new CraftingAchievement(Items.bed,"solla","solla",0,0,new ItemStack(Items.bed),null).initIndependentStat().registerStat();
        goldenTicket = new CraftingAchievement(Blocks.gold_block,"goldenTicket","goldenTicket",2,0,new ItemStack(Blocks.gold_block),solla).registerStat();
        rich = new CraftingAchievement(Blocks.diamond_block,"rich","rich",2,2,new ItemStack(Blocks.diamond_block),solla).registerStat();
        yopp = new CraftingAchievement(Blocks.noteblock,"yopp","yopp",2,4,new ItemStack(Blocks.noteblock),solla).registerStat();
        waste = new CraftingAchievement(Items.diamond_hoe,"waste","waste",2,6,new ItemStack(Items.diamond_hoe),solla).registerStat();
        possible = new CraftingAchievement(Items.speckled_melon,"possible","possible",2,8,new ItemStack(Items.speckled_melon),solla).registerStat();

        mBrine = new AchievementPack("MBrine's Picks","1.0","https://dl.dropboxusercontent.com/u/133619815/WeatherCarpetsStable.txt",new Achievement[]{solla,goldenTicket,rich,yopp,waste,possible});

    }

}
