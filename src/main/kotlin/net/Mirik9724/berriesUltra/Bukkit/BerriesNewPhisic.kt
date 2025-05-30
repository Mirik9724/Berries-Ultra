package net.Mirik9724.berriesUltra.Bukkit

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerInteractEvent

class BerriesNewPhisic : Listener {

    @EventHandler
    fun onBerryUse(event: PlayerInteractEvent) {
        val player = event.player
        val item = event.item

        if (item != null && item.type == Material.SWEET_BERRIES) {
            when (event.action) {
                Action.RIGHT_CLICK_BLOCK -> {
                    // Посадка: только если Shift (приседаем)
                    if (!player.isSneaking) {
                        event.isCancelled = true
                    }
                }
                Action.RIGHT_CLICK_AIR -> {
                    // Едим ягоды: только если НЕ Shift
                    if (player.isSneaking) {
                        event.isCancelled = true
                    }
                }
                else -> {}
            }
        }
    }

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player = event.player
        val block = event.block

        if (block.type == Material.SWEET_BERRIES && !player.isSneaking) {
            event.isCancelled = true
        }
    }
}
