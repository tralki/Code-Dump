package com.example.projetomobile.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projetomobile.fragments.MonitoradosFragment
import com.example.projetomobile.fragments.NewsFragment
import com.example.projetomobile.fragments.SearchFragment

class MyFragmentStateAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Número de fragmentos
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MonitoradosFragment()
            1 -> SearchFragment()
            2 -> NewsFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    fun getNewsFragment(): NewsFragment {
        return createFragment(2) as NewsFragment
    }
}
