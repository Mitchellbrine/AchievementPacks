package mc.Mitchellbrine.achevementPacks.api;

import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import mc.Mitchellbrine.achevementPacks.util.InvalidAchievementException;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AchievementPack extends AchievementPage{

    private String updateURL;
    private String packName;
    private String packVersion;
    private String packSling;

    public AchievementPack(String packName, String packVersion, String updateURL, Achievement[] achievements) {
        super("[AP] " + packName, achievements);
        this.packName = packName;
        this.packVersion = packVersion;
        this.updateURL = updateURL;
        String lowercaseName = this.packName.toLowerCase();
        this.packSling = lowercaseName.replaceAll(" ","-");
        AchievementPacksMain.packs.add(this);
        AchievementPacksMain.logger.info("Pack registered: " + this.packName);

        try {
            if (isOutdated()) {
                AchievementPacksMain.outdatedPacks.add(this.packName);
            }
        } catch (IOException ex) {
            AchievementPacksMain.erroredPacks.add(this.packName);
            ex.printStackTrace();
        }
    }

    private boolean isOutdated() throws IOException{
        BufferedReader updateFile = null;
        if (this.updateURL != null) {
            if (this.updateURL.substring(this.updateURL.length() - 1).equalsIgnoreCase("/")) {
                updateFile = new BufferedReader(new InputStreamReader(new URL(this.getUpdateURL() + this.packSling + ".txt").openStream()));
            }
            else {
                updateFile = new BufferedReader(new InputStreamReader(new URL(this.getUpdateURL() + "/" + this.packSling + ".txt").openStream()));
            }
        }
        if (updateFile != null) {
            String currentVersion = updateFile.readLine();
            updateFile.close();

            if (currentVersion.compareToIgnoreCase(this.packVersion) != 0) {
                BufferedReader changeFile = null;
                if (this.getUpdateURL().substring(this.updateURL.length() - 1).equalsIgnoreCase("/")) {
                    changeFile = new BufferedReader(new InputStreamReader(new URL(this.getUpdateURL() + this.packSling + ".changelog.txt").openStream()));
                }
                else {
                    changeFile = new BufferedReader(new InputStreamReader(new URL(this.getUpdateURL() + "/" + this.packSling + ".changelog.txt").openStream()));
                }
                AchievementPacksMain.outdatedVersions.add(currentVersion);
                if (changeFile != null) {
                    String changeLog = changeFile.readLine();
                    changeFile.close();
                    AchievementPacksMain.outdatedChangelog.put(this.packName, changeLog);
                }
                AchievementPacksMain.logger.info("New version of " + this.packName + ": " + currentVersion);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void finalizePack(AchievementPack pack) {
        for (Achievement ach : pack.getAchievements()) {
            AchievementPack.registerAchievement(ach);
        }
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
        } else if (ach instanceof KillAchievement) {
            AchievementPacksMain.killAchievements.add(ach);
        } else if (ach instanceof StatAchievement) {
            AchievementPacksMain.statAchievements.add(ach);
        } else {
            try {
                throw new InvalidAchievementException();
            } catch (Exception e) {}
        }
        return ach;
    }

    public String getUpdateURL() {
        return this.updateURL;
    }

}
