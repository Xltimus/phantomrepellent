package com.xlt.phantomrepellent;

import com.xlt.phantomrepellent.statuseffects.PhantomRepelEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects
{
    public static final StatusEffect PhantomRepel = new PhantomRepelEffect(StatusEffectCategory.BENEFICIAL, 0xA9CB3F);

    public static void registerStatusEffects()
    {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(PhantomRepellent.MOD_ID, "phantomrepel"), PhantomRepel);
    }
}
