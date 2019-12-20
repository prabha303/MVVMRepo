package com.match.matchmakers.ui.launcher.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import com.match.matchmakers.R
import com.match.matchmakers.base.view.BaseActivity
import com.match.matchmakers.ui.launcher.main.LauncherFragment
import com.match.matchmakers.ui.launcher.main.MainFragment
import com.match.matchmakers.ui.launcher.main.SplashFragment
import kotlinx.android.synthetic.main.launcher_fragment.view.*
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivty :AppCompatActivity()  /*BaseActivity()*/ {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)



        register.setOnClickListener {

            val intent = Intent(this@LoginActivty, RegisterActivty::class.java)
            startActivity(intent)

        }


    }






}
