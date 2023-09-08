package com.github.mspirat.bookgamestainlesssteelrat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mOpenGameButton: Button
    private lateinit var mResetGameButton: Button
    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
// Hide system bars
        windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

        setContentView(R.layout.activity_main)

        mOpenGameButton = findViewById(R.id.open_game_button)
        mResetGameButton = findViewById(R.id.reset_game_button)

        Log.d("myLog", "Запущен стартовый активити")
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE)
        val mChapterNumber = mSharedPref.getInt(getString(R.string.chapter_number), 0)

        if (mChapterNumber > 0) {
            mOpenGameButton.text = getString(R.string.continue_game)
            mResetGameButton.visibility = View.VISIBLE
        } else {
            mOpenGameButton.text = getString(R.string.start_game)
            mResetGameButton.visibility = View.INVISIBLE
        }

        Log.d("myLog", "Восстановили текущую главу и обновили кнопки")
    }

    fun openGame(view: View) {
        val intent = Intent(this, GameProcess::class.java)
        startActivity(intent)
    }

    fun resetProgress(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.reset_progress_title)
            .setMessage(R.string.reset_progress_message)
            .setNegativeButton(R.string.reset_progress_cancel, null)
            .setPositiveButton(R.string.reset_progress_ok) { _, _ ->
                mSharedPref =
                    getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = mSharedPref.edit()
                editor.putInt(getString(R.string.chapter_number), 0)
                editor.apply()
                updateUI()
            }
            .show()
    }
}
