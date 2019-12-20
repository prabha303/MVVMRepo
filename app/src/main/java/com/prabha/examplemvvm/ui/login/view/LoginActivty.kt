package com.match.matchmakers.ui.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import com.match.matchmakers.R
import com.match.matchmakers.base.view.BaseActivity
import com.match.matchmakers.ui.launcher.main.LauncherFragment
import com.match.matchmakers.ui.launcher.main.MainFragment
import com.match.matchmakers.ui.launcher.main.SplashFragment

class LoginActivty : BaseActivity() {


    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


    }





    override fun processServerError(module: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInternetConnected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInternetDisconnected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
