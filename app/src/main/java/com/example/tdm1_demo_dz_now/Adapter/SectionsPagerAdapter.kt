package com.example.tdm1_demo_dz_now.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class SectionsPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private var instance :SectionsPagerAdapter?=null
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    private val tabItemsTitles = ArrayList<String>()

    fun getInstance (manager: FragmentManager):SectionsPagerAdapter?{
        if(instance==null){
            instance=SectionsPagerAdapter(manager)
        }
     return instance
  }
    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1,mFragmentTitleList.get(position))
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String, position: Int) {
        mFragmentList.add(position, fragment)
        mFragmentTitleList.add(position, title)
    }

    fun removeFragment(fragment: Fragment, position: Int) {
        mFragmentList.removeAt(position)
        mFragmentTitleList.removeAt(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }

}