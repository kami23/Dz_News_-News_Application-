package com.example.tdm1_demo_dz_now

import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.card_custom_view.view.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.tdm1_demo_dz_now.Adapter.ListNewsAdapter
import com.example.tdm1_demo_dz_now.Adapter.ListSourceAdapter
import com.example.tdm1_demo_dz_now.Common.Common
import com.example.tdm1_demo_dz_now.Interface.NewsService
import com.example.tdm1_demo_dz_now.Model.WebSite
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Response

class news : AppCompatActivity() {
    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, news::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
     //   setupUI()
        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }


   /*private fun setupUI() {
        sign_out_button.setOnClickListener {
            signOut()
        }
    }
    private fun signOut() {
        startActivity(HomeActivity.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut()
    }*/

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_news, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Modifier les catégories ")
            val items = arrayOf("Politique", "International", "Sport", "Culture","Musique","Cinéma")
            val selectedList = ArrayList<Int>()
            builder.setMultiChoiceItems(items, null
            ) { _, which, isChecked ->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(Integer.valueOf(which))
                }
            }

            builder.setPositiveButton("Enregistrer") { _, _ ->
                val selectedStrings = ArrayList<String>()

                for (j in selectedList.indices) {
                    selectedStrings.add(items[selectedList[j]])
                }

            }
            builder.show()

            return true
        }


        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            val listTitle = arrayListOf<String>()
            listTitle.addAll(listOf("hello", "hi", "hola"))

            return PlaceholderFragment.newInstance(position + 1,listTitle)

        }

        override fun getCount(): Int {
            // Show 4 total pages.
            return 4
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment (): Fragment() {
        var cpt = 1
        lateinit var category:String
        private lateinit var mService: NewsService
        lateinit var adapter : ListNewsAdapter
        private lateinit var layoutManager: androidx.recyclerview.widget.LinearLayoutManager
        lateinit var dialog: AlertDialog

        /*fun handleOnClick() {
            val intent = Intent(context, SourceActivity::class.java)
            // start your next activity
            startActivity(intent)
        }*/

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_news, container, false)
            val imgResId1 = R.drawable.img1
            rootView.card1.img_news.setImageResource(imgResId1)
            rootView.card1.setOnClickListener{}
            rootView.card1.tv_title.text = category
            rootView.card1.tv_des.text="Les étudiants manifestent à Alger pour le 18e mardi consécutif pour demander le départ des figures ...."
            rootView.card1.tv_src.text="12 juin 2019 la source"
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"
            private val LIST_TITLE=  "listTitle"

            /**
             *
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int, listTitle : ArrayList<String>): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                args.putStringArrayList(LIST_TITLE,listTitle)
                fragment.arguments = args
                return fragment
            }
        }
    }




}
