package net.Mirik9724.berriesUltra.Fabric.Mixins

import net.minecraft.entity.player.PlayerEntity
import net.Mirik9724.berriesultra.BerriesUltraMod
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(PlayerEntity::class)
class PlayerEntityMixin {
    @Inject(method = ["tick"], at = [At("HEAD")])
    private fun onTick(info: CallbackInfo) {
        BerriesUltraMod.LOGGER.info("Ticking player at mixin!")
    }
}
