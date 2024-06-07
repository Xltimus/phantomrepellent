package com.xlt.phantomrepellent;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.predicate.entity.EntityPredicates;

import java.util.Iterator;
import java.util.List;

public class PhantomRepelEffect extends StatusEffect {

    protected PhantomRepelEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(PhantomRepellent.PhantomRepel))
        {
            List<PhantomEntity> list = entity.getWorld().getEntitiesByClass(PhantomEntity.class, entity.getBoundingBox().expand(16.0), EntityPredicates.VALID_ENTITY);
            Iterator iterator = list.iterator();

            while(iterator.hasNext()) {
                PhantomEntity phantomEntity = (PhantomEntity) iterator.next();
                phantomEntity.setTarget(null);
            }
        }
    }
}
