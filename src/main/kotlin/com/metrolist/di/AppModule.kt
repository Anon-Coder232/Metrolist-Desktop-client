package com.metrolist.di

import com.metrolist.player.AudioPlayer
import org.koin.dsl.module

val appModule = module {
    single { AudioPlayer() }
    // Add ViewModels and API clients here as singletons
}
