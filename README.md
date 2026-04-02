Metrolist PC
The premium, open-source YouTube Music desktop client.

License: GPL v3 Kotlin Compose Multiplatform

⬇️ Download  •  🐛 Report Bug  •  📖 Wiki
✨ Features
No Ads, No Tracking: 100% private, bypasses YouTube Premium paywalls.
Native Desktop Experience: Built with Material Design 3. Supports Windows, macOS, and Linux.
Background Playback: System tray integration. Music keeps playing even when the window is minimized.
High-Quality Audio: Streams up to 256kbps Opus/AAC directly from YouTube.
Local Library Sync: Import your YouTube Music playlists, or play local MP3/FLAC files.
Synchronized Lyrics: Real-time lyrics display.

🛠️ Tech Stack
UI: Jetpack Compose for Desktop (Material 3)
Language: Kotlin
Audio Engine: JAudioLib / MPV (Cross-platform native audio)
Database: SQLDelight (SQLite)
Networking: Ktor Client (InnerTube API)

🚀 Getting Started (Developers)
Prerequisites
JDK 17 or higher
Android Studio (with Kotlin Multiplatform plugin) OR IntelliJ IDEA Ultimate
Build from source
git clone https://github.com/yourusername/Metrolist-PC.gitcd Metrolist-PC./gradlew run
Build Installers (.msi, .dmg, .deb)
./gradlew packageDmg     # macOS
./gradlew packageMsi     # Windows
./gradlew packageDeb     # Linux


how to imstall :
1.Download and install IntelliJ IDEA Community Edition (it's free from JetBrains.com).
Open IntelliJ IDEA.
Click "Open" (or File -> Open).
Select the unzipped Metrolist-Desktop-main folder you just downloaded.
IntelliJ will take a few minutes to load the Gradle files (you'll see a loading bar at the bottom).
Once it's done, you can click the green "Play" button at the top right of IntelliJ to compile and launch
