package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_website.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
const val REQ_WEBSITE_KEY ="req_website"
const val BUNDLE_WEBSITE_KEY="bundle_website"
class AddWebsiteFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_website, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddWebsite.setOnClickListener{
            onAddWebsite()
        }


    }

    private fun onAddWebsite() {
        val websiteText = etWebsiteName.text.toString()


        if(websiteText.isNotBlank()){
            setFragmentResult(REQ_WEBSITE_KEY, bundleOf(Pair(BUNDLE_WEBSITE_KEY,websiteText)))
            findNavController().popBackStack()
        }else {
            Toast.makeText(
                activity,R.string.not_valid_website,Toast.LENGTH_SHORT
            ).show()
        }

    }
}