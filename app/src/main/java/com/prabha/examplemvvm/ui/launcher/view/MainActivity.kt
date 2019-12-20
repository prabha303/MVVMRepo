package com.prabha.examplemvvm.ui.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import com.prabha.examplemvvm.R
import com.prabha.examplemvvm.ui.launcher.main.LauncherFragment
import com.prabha.examplemvvm.ui.launcher.main.MainFragment

class MainActivity : AppCompatActivity() {

    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragmentTag = LauncherFragment::class.java.simpleName
        val fragment = LauncherFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction().addToBackStack(null)

        transaction.replace(R.id.container, fragment, fragmentTag)
        transaction.commit()

        currentFragment = fragment

    }


    private fun setFragmentBackStackListener() {
        val fm = supportFragmentManager

        e( "BackStack_Count" , "${fm.backStackEntryCount}")
    }

}
