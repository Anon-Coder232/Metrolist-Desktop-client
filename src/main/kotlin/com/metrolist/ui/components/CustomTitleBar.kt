package com.metrolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.crop_square
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.awtEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

@Composable
fun CustomTitleBar(
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // The actual draggable top bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.95f))
                .padding(horizontal = 12.dp)
                // Magic code to make the window draggable
                .java.awt.awtEvent {
                    this.addMouseListener(object : MouseAdapter() {
                        override fun mousePressed(e: MouseEvent) {
                            window.location = window.location.apply {
                                x += e.x
                                y += e.y
                            }
                        }
                    })
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Metrolist",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            // Window Controls (Right Aligned)
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                IconButton(onClick = { /* Minimize logic */ }, modifier = Modifier.size(40.dp)) {
                    Icon(Icons.Default.HorizontalRule, contentDescription = "Minimize", tint = MaterialTheme.colorScheme.onSurface)
                }
                IconButton(onClick = { /* Maximize logic */ }, modifier = Modifier.size(40.dp)) {
                    Icon(Icons.Default.crop_square, contentDescription = "Maximize", tint = MaterialTheme.colorScheme.onSurface)
                }
                IconButton(onClick = onClose, modifier = Modifier.size(40.dp)) {
                    Icon(Icons.Default.Close, contentDescription = "Close", tint = MaterialTheme.colorScheme.onSurface)
                }
            }
        }

        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

        // The rest of the app goes under the title bar
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}
