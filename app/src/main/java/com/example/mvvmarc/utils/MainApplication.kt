package com.example.mvvmarc.utils

import android.app.Application

/**
 * This Application class intended to load first. If any module to initialize to first run , we can
 * init here.
 */
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {


}