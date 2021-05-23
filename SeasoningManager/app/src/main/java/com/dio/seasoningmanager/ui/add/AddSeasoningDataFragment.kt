package com.dio.seasoningmanager.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dio.seasoningmanager.R
import com.dio.seasoningmanager.ui.setting.SettingViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AddSeasoningDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSeasoningDataFragment : Fragment() {
    private lateinit var addSeasoningViewModel: SettingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addSeasoningViewModel =
                ViewModelProvider(this).get(SettingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_seasoning_data, container, false)
        return root
    }
}