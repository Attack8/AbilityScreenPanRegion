package dev.attackeight.ability_pan_region;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

@Mod(AbilityScreenPanRegion.ID)
public class AbilityScreenPanRegion {

    public static final String ID = "ability_pan_region";

    public AbilityScreenPanRegion() {
        ModLoadingContext.get().registerConfig(Type.CLIENT, SPEC, ID + "-server.toml");
    }

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ACTIVATE;

    static {
        ACTIVATE = BUILDER.comment("Whether or not the mod should be active")
                .define("activate", true);
        SPEC = BUILDER.build();
    }
}
