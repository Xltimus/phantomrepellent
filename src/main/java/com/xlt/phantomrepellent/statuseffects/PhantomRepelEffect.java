package com.xlt.phantomrepellent.statuseffects;

import com.xlt.phantomrepellent.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.predicate.entity.EntityPredicates;

import java.util.Iterator;
import java.util.List;

public class PhantomRepelEffect extends StatusEffect {

    public PhantomRepelEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }
}
