package com.match.matchmakers.base.view

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.match.matchmakers.base.receiver.INetworkChangeCallback
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity : DaggerAppCompatActivity(), INetworkChangeCallback {

    var activityStack = arrayListOf<BaseActivity>()
    private val tag= "BaseActivity"
     @Inject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

    }

    abstract fun processServerError(module: String)


    lateinit var requestPermissionCallback: RequestPermissionCallback

    interface RequestPermissionCallback {
        fun onPermissionGranted()
        fun onPermissionDenied()
    }

    fun checkLocationPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION_CODE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    fun checkStoragePermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    fun checkCameraPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    fun checkCallPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), CALL_PHONE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    fun checkPhoneBookPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), READ_PHONEBOOK)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    fun checkStorageAndMediaPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                requestPermissionCallback.onPermissionGranted()
            } else {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO), REQUESTPERMISSION_CODE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        var isPermissionGranted = true
        grantResults.forEach {
            if(it != PackageManager.PERMISSION_GRANTED){
                isPermissionGranted = false
                return@forEach
            }
        }

        if (isPermissionGranted) {
            requestPermissionCallback.onPermissionGranted()
        } else {
            requestPermissionCallback.onPermissionDenied()
        }
    }

    fun keepScreenOn(activity: Activity) {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    companion object {
        private const val LOCATION_PERMISSION_CODE = 1000
        private const val STORAGE_PERMISSION_CODE = 1002
        private const val CAMERA_PERMISSION_CODE = 1003
        private const val CALL_PHONE = 1004
        private const val READ_PHONEBOOK = 1005
        private val REQUESTPERMISSION_CODE = 1000
    }

}
