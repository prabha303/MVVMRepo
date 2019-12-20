package com.match.matchmakers.ui.launcher.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.match.matchmakers.R
import java.util.*
import android.os.Looper





class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root= inflater.inflate(R.layout.splash_fragment, container, false)
        val mainLooperHandler = Handler(Looper.getMainLooper())
        mainLooperHandler.postDelayed({
            if (activity != null) {
                getFragmentManager()!!.popBackStack()
            }
        }, 1500)
        return root
    }
}
