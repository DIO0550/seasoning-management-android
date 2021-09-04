package com.dio.seasoningmanager.ui.list

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.dio.seasoningmanager.MainActivity
import com.dio.seasoningmanager.R
import com.dio.seasoningmanager.state.toolbar.AddToolbarState
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.util.*
import java.util.logging.Logger

class SeasoningListFragment : Fragment() {

    private val addButtonOnClickListener = object: View.OnClickListener {
        override fun onClick(v: View?) {
            // 追加画面に繊維
            val context: Context = v?.context ?: return
            if (context is MainActivity) {
                val navController = context.findNavController(R.id.nav_host_fragment) as NavHostController
                navController.navigate(R.id.action_list_to_add)
            }
        }
    }

    private lateinit var seasoningListViewModel: SeasoningListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        seasoningListViewModel =
                ViewModelProvider(this).get(SeasoningListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sesoning_list, container, false)
        val addButton: FloatingActionButton = root.findViewById(R.id.fab_add_button)
        addButton.setOnClickListener(addButtonOnClickListener);
        return root
    }


}