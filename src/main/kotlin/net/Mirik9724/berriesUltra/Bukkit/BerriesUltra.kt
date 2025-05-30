package net.Mirik9724.berriesUltra.Bukkit

import net.Mirik9724.berriesUltra.logger.logger_
import org.bukkit.plugin.java.JavaPlugin

class BerriesUltra : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(BerriesNewPhisic(), this)
        logger_.info("ON")
    }

    override fun onDisable() {
        logger_.info("OFF")
    }
}
