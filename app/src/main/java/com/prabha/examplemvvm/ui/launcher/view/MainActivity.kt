package com.match.matchmakers.ui.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import com.match.matchmakers.R
import com.match.matchmakers.ui.launcher.main.LauncherFragment
import com.match.matchmakers.ui.launcher.main.MainFragment
import com.match.matchmakers.ui.launcher.main.SplashFragment

class MainActivity : AppCompatActivity() {

    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragmentTag = SplashFragment::class.java.simpleName
        val fragment = SplashFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction().addToBackStack(null)
        transaction.replace(R.id.container, fragment, fragmentTag)
        transaction.commit()

        currentFragment = fragment
        setFragmentBackStackListener()
    }


    private fun setFragmentBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener {
            val fm = supportFragmentManager
            if (supportFragmentManager.backStackEntryCount == 0) {
                if (currentFragment is SplashFragment) {
                    val fragmentTag = LauncherFragment::class.java.simpleName
                    val fragment = LauncherFragment.newInstance()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.container, fragment, fragmentTag)
                    transaction.commit()
                    currentFragment = fragment
                }
                e( "BackStack_Count" , "${fm.backStackEntryCount}")
            }
        }

    }




}
