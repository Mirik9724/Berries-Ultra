plugins {
    id("fabric-loom") version "0.12.10"
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "net.Mirik9724"
version = "0.1.8"

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigotmc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://maven.fabricmc.net/")
//    gradlePluginPortal()
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
    }
}


dependencies {
    minecraft("com.mojang:minecraft:1.14.4")
    mappings("net.fabricmc:yarn:1.14.4+build.12:v2")
    modImplementation("net.fabricmc:fabric-loader:0.4.8")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.3.0+build.209-1.14")

    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.slf4j:slf4j-api:2.0.9")
    // Один из back-end (иначе логгирование не будет работать)
    runtimeOnly("org.slf4j:slf4j-jdk14:2.0.9")
}

tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.14")
    }
}

val targetJavaVersion = 8
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks{
withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("") // Убирает "-all" из имени
    archiveVersion.set(project.version.toString())
    mergeServiceFiles()
}
}