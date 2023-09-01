package com.github.mspirat.bookgamestainlesssteelrat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameProcess : AppCompatActivity() {

    private lateinit var mChapterText: TextView
    private lateinit var mButtonContainer: LinearLayout
    private lateinit var mScrollContainer: ScrollView
    private var mChapterNumber: Int = 0
    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_process)

        mButtonContainer = findViewById(R.id.button_container)
        mScrollContainer = findViewById(R.id.scroll_container)
        mChapterText = findViewById(R.id.chapter_text)

        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE)

        mChapterNumber = mSharedPref.getInt(getString(R.string.chapter_number), 0)
        title = mSharedPref.getString(getString(R.string.chapter_title), "Начало")
        Log.d("myLog", "Восстановили текущую главу: $mChapterNumber - $title")

        gameProcess()

        Log.d("myLog", "Запущен игровой активити")
    }

    override fun onPause() {
        super.onPause()
        saveChapter()
    }

    private fun saveChapter() {
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = mSharedPref.edit()
        editor.putInt(getString(R.string.chapter_number), mChapterNumber)
        editor.putString(getString(R.string.chapter_title), title.toString())
        editor.apply()
        Log.d("myLog", "Сохранили текущую главу: $mChapterNumber")
    }

    private fun addButton(textButton: String, nextChapter: Int) {
        val button: Button =
            layoutInflater.inflate(R.layout.game_button, mButtonContainer, false) as Button
        button.text = textButton
        mButtonContainer.addView(button)
        Log.d("myLog", "Создали кнопку: $textButton")

        mScrollContainer.scrollTo(0, 0)

        button.setOnClickListener {
            mChapterNumber = nextChapter
            mButtonContainer.removeAllViews()
            gameProcess()
        }
    }

    private fun gameProcess() {
        when (mChapterNumber) {
            0 -> {
                title = getString(R.string.title_0)
                mChapterText.setText(R.string.ch_0)
                addButton(getString(R.string.way_0_30), 30)
            }

            // TODO Add more cases as needed
        }
    }
}
