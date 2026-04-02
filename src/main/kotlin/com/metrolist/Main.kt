package com.metrolist

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.metrolist.di.appModule
import com.metrolist.ui.components.CustomTitleBar
import com.metrolist.ui.screens.MainScreen
import com.metrolist.ui.theme.MetrolistTheme
import org.koin.core.context.startKoin
import java.awt.Dimension

fun main() {
    // Start Dependency Injection
    startKoin {
        modules(appModule)
    }

    application {
        var isOpen by remember { mutableStateOf(true) }

        // System Tray (Closes to tray instead of exiting, just like Spotify)
        Tray(
            icon = loadImageResource("icons/tray_icon.png"),
            tooltip = "Metrolist - Playing Music",
            menu = {
                Item("Show Metrolist", onClick = { isOpen = true })
                Separator()
                Item("Quit", onClick = ::exitApplication)
            }
        )

        if (isOpen) {
            Window(
                onCloseRequest = { isOpen = false }, // Minimizes to tray!
                visible = isOpen,
                title = "Metrolist",
                state = rememberWindowState(
                    width = 1100.dp,
                    height = 750.dp,
                    position = WindowPosition(100.dp, 100.dp)
                ),
                undecorated = true, // Removes OS title bar for custom UI
                transparent = false,
                resizable = true
            ) {
                window.minimumSize = Dimension(900, 600)

                MetrolistTheme {
                    // Custom layout containing our Spotify-like top bar
                    CustomTitleBar(onClose = { isOpen = false }) {
                        MainScreen()
                    }
                }
            }
        }
    }
}
