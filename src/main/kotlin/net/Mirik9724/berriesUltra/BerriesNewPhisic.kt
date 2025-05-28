package net.Mirik9724.berriesUltra

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerInteractEvent

class BerriesNewPhisic : Listener {

    @EventHandler
    fun onBerryPlant(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_BLOCK) {
            val item = event.item
            if (item != null && item.type == Material.SWEET_BERRIES) {
                val player = event.player
                if (!player.isSneaking) {
//                    player.sendMessage("§cПосадить ягоды можно только нажав Shift!")
                    event.isCancelled = true
                    player.playSound(player.location, Sound.UI_BUTTON_CLICK, 0f, 0f)
                }
            }
        }
    }

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player = event.player
        val block = event.block

        if (block.type == Material.SWEET_BERRIES && !player.isSneaking) {
            // Отменяем установку блока (удаляем)
            event.isCancelled = true
            player.playSound(player.location, Sound.UI_BUTTON_CLICK, 0f, 0f)
        }
    }
}
