package com.example.coinbuddy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinBuddyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
