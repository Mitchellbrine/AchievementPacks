package mc.Mitchellbrine.achevementPacks.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class KillAchievement extends Achievement{

    private String eventEntity;

    public KillAchievement(String entityID, String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
        super(p_i45302_1_, p_i45302_2_, p_i45302_3_, p_i45302_4_, p_i45302_5_, p_i45302_6_);
        this.eventEntity = entityID;

    }

    public String getEntity() {
        return this.eventEntity;
    }

}
