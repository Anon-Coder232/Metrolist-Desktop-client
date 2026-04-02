package com.metrolist.player

import uk.co.caprica.vlcj.player.component.AudioPlayerComponent

class AudioPlayer {
    // VLCJ handles native C bindings to libvlc under the hood
    private val mediaPlayerComponent = AudioPlayerComponent()

    init {
        // Ensure VLC native libs are found (requires VLC installed on PC)
        System.setProperty("jna.library.path", System.getenv("VLC_HOME") ?: "")
    }

    fun playStream(url: String) {
        val media = mediaPlayerComponent.mediaFactory().media().url(url).build()
        mediaPlayerComponent.mediaPlayer().media().play(media)
    }

    fun pause() {
        mediaPlayerComponent.mediaPlayer().controls().pause()
    }

    fun resume() {
        mediaPlayerComponent.mediaPlayer().controls().play()
    }

    fun seekTo(timeInSeconds: Long) {
        mediaPlayerComponent.mediaPlayer().controls().setTime(timeInSeconds * 1000)
    }

    fun getCurrentTime(): Long {
        return mediaPlayerComponent.mediaPlayer().status().time() / 1000
    }

    fun release() {
        mediaPlayerComponent.release()
    }
}
