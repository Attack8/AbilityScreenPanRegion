package dev.attackeight.ability_pan_region.mixin;

import dev.attackeight.ability_pan_region.AbilityScreenPanRegion;
import iskallia.vault.client.gui.screen.player.legacy.tab.split.pan.AbilityPanRegion;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AbilityPanRegion.class, remap = false)
public class AbilityPanRegionMixin {

    @Inject(method = "calculateViewportTranslation", at = @At("HEAD"), cancellable = true)
    private void allowAnyTranslation(double mouseX, double mouseY, CallbackInfo ci) {
        if (AbilityScreenPanRegion.ACTIVATE.get()) {
            AbstractPanRegionAccessor pan = (AbstractPanRegionAccessor) this;

            float dx = (float) (mouseX - (double) pan.getGrabbedPos().x) / pan.getViewportScale();
            float dy = (float) (mouseY - (double) pan.getGrabbedPos().y) / pan.getViewportScale();
            pan.setViewportTranslation(new Vec2(pan.getViewportTranslation().x + dx, pan.getViewportTranslation().y + dy));
            pan.invokeSaveViewportTransforms();
            ci.cancel();
        }
    }
}
