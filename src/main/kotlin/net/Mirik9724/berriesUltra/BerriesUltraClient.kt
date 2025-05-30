package net.Mirik9724.berriesUltra

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.minecraft.block.Blocks
import net.minecraft.item.Items
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.world.World
import net.minecraft.entity.player.PlayerEntity

class BerriesUltraClinet : ModInitializer {

    override fun onInitialize() {
        // Событие на попытку взаимодействия с блоком (например, посадка)
        UseBlockCallback.EVENT.register(UseBlockCallback { player, world, hand, hitResult ->
            if (!world.isClient) {
                val item = player.getStackInHand(hand).item
                // Проверяем, пытаемся ли посадить ягоды
                if (item == Items.SWEET_BERRIES) {
                    if (!player.isSneaking) {
                        // Отменяем посадку, если Shift не нажат
                        return@UseBlockCallback ActionResult.FAIL
                    }
                }
            }
            ActionResult.PASS
        })

        // Событие на попытку использовать предмет (есть ягоды)
        UseItemCallback.EVENT.register(UseItemCallback { player, world, hand ->
            val item = player.getStackInHand(hand).item
            if (item == Items.SWEET_BERRIES) {
                if (player.isSneaking) {
                    // Отменяем поедание ягод, если Shift нажат
                    return@UseItemCallback ActionResult.FAIL
                }
            }
            ActionResult.PASS
        })
    }
}
