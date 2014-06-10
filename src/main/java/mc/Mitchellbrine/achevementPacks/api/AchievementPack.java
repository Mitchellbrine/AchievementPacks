package mc.Mitchellbrine.achevementPacks.api;

import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AchievementPack extends AchievementPage{

    private String updateURL;
    private String packName;
    private String packVersion;

    public AchievementPack(String packName, String packVersion, String updateURL, Achievement[] achievements) {
        super("[AP] " + packName, achievements);
        this.packName = packName;
        this.packVersion = packVersion;
        this.updateURL = updateURL;
        AchievementPacksMain.packs.add(this);
        AchievementPacksMain.logger.info("Pack registered: " + this.packName);

        try {
            if (isOutdated()) {
                AchievementPacksMain.outdatedPacks.add(this.packName);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isOutdated() throws IOException{
        BufferedReader updateFile = new BufferedReader(new InputStreamReader(new URL(updateURL).openStream()));
        String currentVersion = updateFile.readLine();
        updateFile.close();

        if (this.updateURL != currentVersion) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void finalizePack(AchievementPack pack) {
        AchievementPage.registerAchievementPage(pack);
    }

    public static Achievement registerAchievement(Achievement ach) {
        if (ach instanceof CraftingAchievement) {
            AchievementPacksMain.craftingAchievements.add(ach);
        }
        else if (ach instanceof SmeltingAchievement) {
            AchievementPacksMain.smeltingAchievements.add(ach);
        }
        else if (ach instanceof PickupAchievement) {
            AchievementPacksMain.pickupAchievements.add(ach);
        }
        return ach;
    }

}
