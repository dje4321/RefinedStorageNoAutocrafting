package com.dje4321.rspatchmod.mixin;

import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternGridScreen;
import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(value = PatternGridScreen.class, remap = false)
public interface PatternGridScreenAccessor {

    @Accessor("patternTypeButtons")
    Map<PatternType, ?> getPatternTypeButtons();

    @Invoker("patternTypeChanged")
    void invokePatternTypeChanged(PatternType patternType);
}
