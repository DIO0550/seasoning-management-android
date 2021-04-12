package com.dio.seasoningmanager.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import com.dio.seasoningmanager.model.SeasoningListDataModel

/**
 * A simple [Fragment] subclass.
 * Use the [SeasoningListAdapter.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeasoningListAdapter(context: Context, resource: Int, objects: Array<out SeasoningListDataModel>) : ArrayAdapter<SeasoningListDataModel>(context, resource, objects)

