package com.prabha.examplemvvm.application

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : Application() {


    init {
        instance = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        /**
         * timeStamp + " | " + appVersion + " : " + osVersion + " | " + deviceUUID + " | [" + logLevelName + "]: " + message
         * Eg : 2017-10-05T14:46:36.541Z 1.0 | 0.0.1 : Android-7.1.1 | 62bb1162466c3eed | INFO: Log has been pushed
         */

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }


    companion object {
        private var instance: MyApplication? = null
        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent.builder().application(this).build()
    }*/

}