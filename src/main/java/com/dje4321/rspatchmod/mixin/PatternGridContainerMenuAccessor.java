package com.dje4321.rspatchmod.mixin;

import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternGridContainerMenu;
import com.refinedmods.refinedstorage.common.autocrafting.patterngrid.PatternType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = PatternGridContainerMenu.class, remap = false)
public interface PatternGridContainerMenuAccessor {

    @Invoker("getPatternType")
    PatternType invokeGetPatternType();

    @Invoker("setPatternType")
    void invokeSetPatternType(PatternType patternType);
}
