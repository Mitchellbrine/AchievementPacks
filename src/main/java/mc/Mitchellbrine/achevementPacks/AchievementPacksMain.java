package mc.Mitchellbrine.achevementPacks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mc.Mitchellbrine.achevementPacks.api.AchievementPack;
import mc.Mitchellbrine.achevementPacks.api.CraftingAchievement;
import mc.Mitchellbrine.achevementPacks.api.PickupAchievement;
import mc.Mitchellbrine.achevementPacks.api.SmeltingAchievement;
import mc.Mitchellbrine.achevementPacks.event.AchievementEvents;
import mc.Mitchellbrine.achevementPacks.packs.MitchellbrinePicks;
import mc.Mitchellbrine.achevementPacks.packs.TestPack;
import mc.Mitchellbrine.achevementPacks.util.PackEvents;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

@Mod(modid = "AchievementPacks", name = "Achievement Packs", version = "1.0")
public class AchievementPacksMain {

    public static Logger logger;

    public static ArrayList<String> outdatedPacks = new ArrayList<String>();
    public static ArrayList<AchievementPack> packs = new ArrayList<AchievementPack>();

    public static HashMap<Achievement, ItemStack> craftingHashMap = new HashMap<Achievement, ItemStack>();
    public static ArrayList<Achievement> craftingAchievements = new ArrayList<Achievement>();

    public static HashMap<Achievement, ItemStack> smeltingHashMap = new HashMap<Achievement, ItemStack>();
    public static ArrayList<Achievement> smeltingAchievements = new ArrayList<Achievement>();

    public static HashMap<Achievement, Item> pickupHashMap = new HashMap<Achievement, Item>();
    public static ArrayList<Achievement> pickupAchievements = new ArrayList<Achievement>();

    public AchievementPacksMain(){
        MinecraftForge.EVENT_BUS.register(new PackEvents());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        TestPack.init();
        MitchellbrinePicks.init();

    }

    /*

     This means EVERY achievement pack must be registered in the PREINITIALIZATION event!
     ONLY IN THE PREINITIALIZATION EVENT! YOU HEAR ME? ONLY THE PREINITIALIZATION EVENT! :D
     (And everything else involving items and blocks!
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        for (int pack = 0; pack < packs.size();pack++) {
            AchievementPack.finalizePack(packs.get(pack));
        }

        FMLCommonHandler.instance().bus().register(new AchievementEvents());

    }

}
