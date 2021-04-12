package com.dio.seasoningmanager.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dio.seasoningmanager.R

class SeasoningListFragment : Fragment() {

    private lateinit var seasoningListViewModel: SeasoningListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        seasoningListViewModel =
                ViewModelProvider(this).get(SeasoningListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sesoning_list, container, false)
        seasoningListViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }
}