package net.Mirik9724.berriesUltra

import net.mirik9724.berriesUltra.BerriesNewPhisic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.bukkit.plugin.java.JavaPlugin

class BerriesUltra : JavaPlugin() {
    private val logger: Logger = LoggerFactory.getLogger(BerriesUltra::class.java)

    override fun onEnable() {
        server.pluginManager.registerEvents(BerriesNewPhisic(), this)
        logger.info("ON")
    }

    override fun onDisable() {
        logger.info("OFF")
    }
}
