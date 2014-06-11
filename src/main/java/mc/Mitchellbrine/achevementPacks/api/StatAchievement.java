package mc.Mitchellbrine.achevementPacks.api;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;

public class StatAchievement extends Achievement {

    private StatBase eventStat;
    private int statAmount;

    public StatAchievement(StatBase stat, int value, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, p_i45302_5_, p_i45302_6_);
        this.eventStat = stat;
        if (this.eventStat == StatList.distanceWalkedStat || this.eventStat == StatList.distanceClimbedStat || this.eventStat == StatList.distanceDoveStat || this.eventStat == StatList.distanceFallenStat || this.eventStat == StatList.distanceFlownStat || this.eventStat == StatList.distanceSwumStat) {
            this.statAmount = value * 100;
        }
        else {
            this.statAmount = value;
        }

    }

    public StatBase getEventStat() {
        return this.eventStat;
    }

    public int getStatAmount() { return this.statAmount; }

}
