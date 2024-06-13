package com.xlt.phantomrepellent.mixin;
import com.xlt.phantomrepellent.PhantomRepellent;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PhantomEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.entity.mob.PhantomEntity$SwoopMovementGoal")
public abstract class ExampleMixin  {

	@Inject (at = @At(value = "TAIL"), method = "shouldContinue")
	private void init(CallbackInfoReturnable info) {

	}
}