package com.dio.seasoningmanager.ui.add

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dio.seasoningmanager.R
import com.dio.seasoningmanager.const.SeasoningManagerConst
import com.dio.seasoningmanager.dao.SeasoningDataDao
import com.dio.seasoningmanager.ui.setting.SettingViewModel
import com.dio.seasoningmanager.util.DateUtil
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDateTime
import com.dio.seasoningmanager.Application;
import com.dio.seasoningmanager.entity.SeasoningData
import com.dio.seasoningmanager.util.DateUtil.Companion.toDate
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.logging.Logger

/**
 * A simple [Fragment] subclass.
 * Use the [AddSeasoningDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSeasoningDataFragment : Fragment() {
    /// ViewModel
    private lateinit var addSeasoningViewModel: SettingViewModel
    /// 名前テキストフィールド
    private lateinit var seasoningNameText: TextInputEditText;
    /// LinearLayout
    private lateinit var expirationDateFrameLayout: LinearLayout;
    /// 賞味機嫌 or 消費期限
    private lateinit var expirationDateTextInputEditText: TextInputEditText;
    /// カレンダー表示ボタン
    private lateinit var expirationDateMaterialButton: MaterialButton;

    /// カレンダー表示済み
    private var isDisplayCalendarDialog: Boolean = false;

    /// === ClickListener ===


    /**
     * 賞味機嫌 or 消費期限レイアウト クリックリスナー
     */
    private val expiredDateFrameLayoutListener = View.OnClickListener {
        this.showExpiredCalendarView();
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        addSeasoningViewModel =
                ViewModelProvider(this).get(SettingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_seasoning_data, container, false)
        seasoningNameText = root.findViewById(R.id.add_seasoning_name_text)
        expirationDateFrameLayout = root.findViewById(R.id.add_seasoning_expired_frame)
        expirationDateTextInputEditText = expirationDateFrameLayout.findViewById(R.id.add_seasoning_expired_text)
        expirationDateMaterialButton = expirationDateFrameLayout.findViewById(R.id.add_seasoning_expired_button)

        expirationDateMaterialButton.setOnClickListener(expiredDateFrameLayoutListener);
        expirationDateFrameLayout.setOnClickListener(expiredDateFrameLayoutListener);
        expirationDateTextInputEditText.setOnClickListener(expiredDateFrameLayoutListener);
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_seasouning_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                val seasoningDataDao: SeasoningDataDao = Application.database.seasoningDao()
                val name: String = seasoningNameText.text.toString();
                val expirationDateStr: String = expirationDateTextInputEditText.text.toString()
                val expirationDate: Date? = expirationDateStr.toDate();
                val type: String = "a"
                val data = SeasoningData(0, name, expirationDate, type, null);
                GlobalScope.launch(){
                    seasoningDataDao.insert(data)
                    val all = seasoningDataDao.getAll();
                    Log.d("a", "a");
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        expirationDateFrameLayout.setOnClickListener(null)
    }

    /**
     * DatePickerDialogを表示する
     */
    private fun showExpiredCalendarView() {
        if (isDisplayCalendarDialog) {
            return;
        }
        var context: Context = this.activity ?: return;
        val now = LocalDateTime.now()
        var datePickerDialog: DatePickerDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth -> },
            now.year,
            now.month.value - 1,
            now.dayOfMonth)
        datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            val expirationDateStr: String = DateUtil.toDateString(SeasoningManagerConst.ExpirationDate.EXPIRATION_DATE_FORMATTER, year, month, dayOfMonth);
            expirationDateTextInputEditText.setText(expirationDateStr);
        };
        datePickerDialog.setOnDismissListener {
            isDisplayCalendarDialog = false;
        }
        datePickerDialog.show()
        isDisplayCalendarDialog = true;
    }
}