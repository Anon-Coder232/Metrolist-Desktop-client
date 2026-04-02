
---

### ⚙️ `build.gradle.kts`
```kotlin
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "com.metrolist"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)

    // Ktor for InnerTube API
    implementation("io.ktor:ktor-client-core:2.3.7")
    implementation("io.ktor:ktor-client-cio:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    
    // JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    // VLCJ for robust, gapless, Spotify-like audio playback
    implementation("uk.co.caprica:vlcj:4.8.2")

    // Koin for Dependency Injection (Replaces Android's Hilt)
    implementation("io.insert-koin:koin-core:3.5.3")
    implementation("io.insert-koin:koin-compose:3.5.3")

    // SQLite for local database caching
    implementation("org.xerial:sqlite-jdbc:3.44.1.0")
}

compose.desktop {
    application {
        mainClass = "com.metrolist.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Dmg, TargetFormat.Deb)
            packageName = "Metrolist"
            packageVersion = "1.0.0"
            
            windows {
                menuGroup = "Music"
                upgradeUuid = "a1b2c3d4-e5f6-7890-abcd-ef1234567890"
                dirChooser = true
            }
            macOS {
                bundleID = "com.metrolist.desktop"
            }
        }
    }
}
