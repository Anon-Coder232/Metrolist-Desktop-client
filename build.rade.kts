
---

### ⚙️ `build.gradle.kts`
*(This configures the Compose Desktop app, sets up native installers, and includes the necessary PC libraries).*

```kotlin
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.compose") version "1.6.0"
}

group = "com.metrolist"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
}

dependencies {
    // Compose Desktop (Material 3)
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)

    // Networking for InnerTube API
    implementation("io.ktor:ktor-client-core:2.3.7")
    implementation("io.ktor:ktor-client-cio:2.3.7")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    
    // JSON Parsing
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    // Database (SQLDelight replaces Android Room)
    implementation("app.cash.sqldelight:sqlite-driver:2.0.1")

    // Audio Playback (JLayer for basic MP3, or use mpv-lib for advanced streaming)
    implementation("javazoom:jlayer:1.0.1") 
    // For production, replace JLayer with: implementation("uk.co.caprica:vlcj:4.8.2")
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
                iconFile.set(project.file("icons/metrolist.ico"))
            }
            macOS {
                bundleID = "com.metrolist.pc"
                iconFile.set(project.file("icons/metrolist.icns"))
            }
            linux {
                iconFile.set(project.file("icons/metrolist.png"))
            }
        }
        
        buildTypes.release {
            proguard {
                isEnabled.set(false) // Enable true for production to shrink app size
            }
        }
    }
}
