package com.xlt.phantomrepellent.events;

import com.xlt.phantomrepellent.ModEnchants;
import com.xlt.phantomrepellent.ModStatusEffects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;
import net.minecraft.world.World;

import java.util.List;
import java.util.ListIterator;

public class RepelPhantomsEvent implements ServerTickEvents.EndWorldTick {

    //@Override
    public void onStartTick(ServerWorld world) {
        /*
        if (!(world.isClient())) {
            List<LivingEntity> entityList = (List<LivingEntity>) world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), EntityPredicates.VALID_ENTITY);

            for (ListIterator iter = entityList.listIterator(); iter.hasNext();){
                LivingEntity entity = (LivingEntity) iter.next();

                if (EnchantmentHelper.getEquipmentLevel(ModEnchants.AphantasmalAura, entity) > 0 || entity.hasStatusEffect(ModStatusEffects.PhantomRepel)){
                    RepelZombies(entity,world);
                }
            }
        }
        */
    }

    public static void RepelPhantoms (LivingEntity entity, World world) {
        List<PhantomEntity> list = entity.getWorld().getEntitiesByClass(PhantomEntity.class, entity.getBoundingBox().expand(16.0), EntityPredicates.VALID_ENTITY);

        for (PhantomEntity phantomEntity : list) {
            phantomEntity.setTarget(null);
        }
    }

    public static void RepelZombies (LivingEntity entity, World world) {
        List<ZombieEntity> list = entity.getWorld().getEntitiesByClass(ZombieEntity.class, entity.getBoundingBox().expand(16.0), EntityPredicates.VALID_ENTITY);

        for (ZombieEntity zombieEntity : list) {
            if (zombieEntity.canTarget(entity))
            {
                zombieEntity.getTarget().setInvisible(true);
                zombieEntity.setAttacking(false);
                zombieEntity.setTarget(null);
            }
        }
    }

    @Override
    public void onEndTick(ServerWorld world) {
        if (!(world.isClient())) {
            List<LivingEntity> entityList = (List<LivingEntity>) world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), EntityPredicates.VALID_ENTITY);

            for (ListIterator iter = entityList.listIterator(); iter.hasNext();){
                LivingEntity entity = (LivingEntity) iter.next();

                if (EnchantmentHelper.getEquipmentLevel(ModEnchants.AphantasmalAura, entity) > 0 || entity.hasStatusEffect(ModStatusEffects.PhantomRepel)){
                    RepelZombies(entity,world);
                }
            }
        }
    }
}
