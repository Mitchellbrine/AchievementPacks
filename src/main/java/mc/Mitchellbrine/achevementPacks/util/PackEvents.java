package mc.Mitchellbrine.achevementPacks.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mc.Mitchellbrine.achevementPacks.AchievementPacksMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class PackEvents {

    @SubscribeEvent
    public void printOutdated(EntityJoinWorldEvent event) {
            if (event.entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.entity;

                if (player.worldObj.isRemote) {
                    if (!AchievementPacksMain.outdatedPacks.isEmpty()) {
                        player.addChatMessage(new ChatComponentText("[Achievement Packs] The following packs are outdated: "));
                        for (int pack = 0; pack < AchievementPacksMain.outdatedPacks.size();pack++) {
                            player.addChatMessage(new ChatComponentText(EnumChatFormatting.ITALIC + AchievementPacksMain.outdatedPacks.get(pack) + " - " + AchievementPacksMain.outdatedVersions.get(pack)));
                            if (AchievementPacksMain.outdatedChangelog.get(AchievementPacksMain.outdatedPacks.get(pack)) != null) {
                                player.addChatMessage(new ChatComponentText(EnumChatFormatting.ITALIC + " -" + AchievementPacksMain.outdatedChangelog.get(AchievementPacksMain.outdatedPacks.get(pack))));
                            }
                        }
                        if (!AchievementPacksMain.erroredPacks.isEmpty()) {
                            player.addChatMessage(new ChatComponentText(""));
                            player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[Achievement Packs] The following packs had update errors:"));
                            for (int pack = 0; pack < AchievementPacksMain.erroredPacks.size(); pack++) {
                                player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.ITALIC + AchievementPacksMain.erroredPacks.get(pack)));
                            }
                        }
                    }
                }
            }
    }

}
