package dev.attackeight.ability_pan_region.mixin;

import iskallia.vault.client.gui.screen.player.legacy.tab.split.spi.AbstractPanRegion;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = AbstractPanRegion.class, remap = false)
public interface AbstractPanRegionAccessor {

    @Accessor("grabbedPos")
    Vec2 getGrabbedPos();

    @Accessor("viewportTranslation")
    Vec2 getViewportTranslation();

    @Accessor("viewportTranslation")
    void setViewportTranslation(Vec2 newValue);

    @Accessor("viewportScale")
    float getViewportScale();

    @Invoker("saveViewportTransforms")
    void invokeSaveViewportTransforms();

}
