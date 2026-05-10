package com.dje4321.rspatchmod.mixin;

import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternGridScreen;
import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternType;
import net.minecraft.client.gui.components.AbstractWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = PatternGridScreen.class, remap = false)
public abstract class PatternGridScreenMixin {

    @Inject(
        method = "init",
        at = @At("TAIL")
    )
    private void onInit(final CallbackInfo ci) {
        final PatternGridScreen self = (PatternGridScreen)(Object)this;
        final PatternGridScreenAccessor selfAccessor = (PatternGridScreenAccessor) this;

        // Hide the crafting button
        final Map<PatternType, ?> buttons = selfAccessor.getPatternTypeButtons();
        final Object craftingButton = buttons.get(PatternType.CRAFTING);
        if (craftingButton instanceof AbstractWidget widget) {
            widget.visible = false;
            widget.active = false;
        }

        // If defaulting to CRAFTING, switch to PROCESSING
        final PatternGridContainerMenuAccessor menu =
            (PatternGridContainerMenuAccessor) self.getMenu();
        if (menu.invokeGetPatternType() == PatternType.CRAFTING) {
            // Set the menu property
            menu.invokeSetPatternType(PatternType.PROCESSING);
            // Also update the screen renderer and button states
            selfAccessor.invokePatternTypeChanged(PatternType.PROCESSING);
        }
    }
}
