package com.dio.seasoningmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dio.seasoningmanager.R
import com.dio.seasoningmanager.model.SeasoningListDataModel


/**
 * A simple [Fragment] subclass.
 * Use the [SeasoningListAdapter.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeasoningListAdapter(
    context: Context,
    resource: Int,
    objects: List<SeasoningListDataModel>

) : ArrayAdapter<SeasoningListDataModel>(context, resource, objects) {

    private val resource: Int
    private val seasoningList: List<SeasoningListDataModel>
    private val inflater: LayoutInflater

    init {
        this.resource = resource;
        this.seasoningList = objects;
        this.inflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var adapterView: View;
        if (convertView == null) {
            adapterView = inflater.inflate(R.layout.seasoning_list_adapter, parent, false);
        } else {
            adapterView = convertView
        }
        var seasoningData: SeasoningListDataModel = seasoningList.get(position)
        var seasoningImageView: ImageView = adapterView.findViewById(R.id.seasoningDataListAdapterImageView)
        var seasoningNameTextView: TextView = adapterView.findViewById(R.id.seasoningDataListAdapterNameTextView)
        var seasoningExpiredDateTextView: TextView = adapterView.findViewById(R.id.seasoningDataListAdapterExpiredDateTextView)
        return super.getView(position, convertView, parent)
    }
}

