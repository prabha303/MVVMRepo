package com.match.matchmakers.ui.launcher.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.match.matchmakers.R
import com.match.matchmakers.ui.launcher.view.LoginActivty
import kotlinx.android.synthetic.main.launcher_fragment.view.*

class LauncherFragment : Fragment() {
    private lateinit var mContext: Context

    companion object {
        fun newInstance() = LauncherFragment()
    }
    lateinit var rootView: View

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView= inflater.inflate(R.layout.launcher_fragment, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        rootView.loginCard.setOnClickListener {

            val intent = Intent(mContext, LoginActivty::class.java)
            startActivity(intent)

        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
     }


}
