package com.example.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_websites.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WebsitesFragment : Fragment() {

    private val websites= arrayListOf<Website>()
    private val websiteAdapter=WebsiteAdapter(websites) { website: Website ->
        websiteItemClicked(
            website
        )
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_websites, container, false)
    }
    private fun websiteItemClicked(website:Website){
        //TODO MAKE IT OPEN CHROME TAB
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeAddWebsiteResult()
    }

    private fun initViews() {
        rvWebsites.layoutManager=GridLayoutManager(context,2)
        rvWebsites.adapter=websiteAdapter
        //.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
    private fun observeAddWebsiteResult(){
        setFragmentResultListener(REQ_WEBSITE_KEY){
            key,bundle->bundle.getParcelable<Website>(BUNDLE_WEBSITE_KEY)?.let{
            val website = Website(it.websiteTitleText,it.websiteURLText)
            websites.add(website)
            websiteAdapter.notifyDataSetChanged()
        }?: Log.e("WebsiteFragment","Request triggered,but empty website text")
        }
    }
}