package mc.Mitchellbrine.achevementPacks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mc.Mitchellbrine.achevementPacks.api.AchievementPack;
import mc.Mitchellbrine.achevementPacks.event.AchievementEvents;
import mc.Mitchellbrine.achevementPacks.packs.MitchellbrinePicks;
import mc.Mitchellbrine.achevementPacks.packs.TestPack;
import mc.Mitchellbrine.achevementPacks.util.PackEvents;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

@Mod(modid = "AchievementPacks", name = "Achievement Packs", version = "1.0")
public class AchievementPacksMain {

    public static Logger logger;

    public static ArrayList<String> outdatedPacks = new ArrayList<String>();
    public static ArrayList<String> erroredPacks = new ArrayList<String>();
    public static ArrayList<AchievementPack> packs = new ArrayList<AchievementPack>();

    public static ArrayList<Achievement> craftingAchievements = new ArrayList<Achievement>();

    public static ArrayList<Achievement> smeltingAchievements = new ArrayList<Achievement>();

    public static ArrayList<Achievement> pickupAchievements = new ArrayList<Achievement>();

    public static ArrayList<Achievement> killAchievements = new ArrayList<Achievement>();

    private boolean initTest;
    private boolean initMBrine;

    public AchievementPacksMain(){
        MinecraftForge.EVENT_BUS.register(new PackEvents());
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        Configuration config = new Configuration(new File(event.getModConfigurationDirectory() + "/AchievementPacks/main.txt"));

        config.load();

        initTest = config.get("packs","Add Test Pack?",true).getBoolean(true);
        initMBrine = config.get("packs","Add MBrine's Picks?",true).getBoolean(true);

        config.save();

        if (initTest == true) {
            TestPack.init();
        }

        if (initMBrine == true) {
            MitchellbrinePicks.init();
        }

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
        MinecraftForge.EVENT_BUS.register(new AchievementEvents());

    }

}
