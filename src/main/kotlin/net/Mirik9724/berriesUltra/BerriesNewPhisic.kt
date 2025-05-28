package net.mirik9724.berriesUltra

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class BerriesNewPhisic : Listener {

    @EventHandler
    fun onBerryPlant(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_BLOCK) {
            val item = event.item
            if (item != null && item.type == Material.SWEET_BERRIES) {
                val player = event.player
                if (!player.isSneaking) {
                    player.sendMessage("§cПосадить ягоды можно только нажав Shift!")
                    event.isCancelled = true
                }
            }
        }
    }
}
