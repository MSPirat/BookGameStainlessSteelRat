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

            1 -> {

            }

            2 -> {

            }

            3 -> {

            }

            4 -> {

            }

            5 -> {

            }

            6 -> {

            }

            7 -> {

            }

            8 -> {

            }

            9 -> {

            }

            10 -> {

            }

            11 -> {

            }

            12 -> {

            }

            13 -> {

            }

            14 -> {

            }

            15 -> {

            }

            16 -> {

            }

            17 -> {

            }

            18 -> {

            }

            19 -> {

            }

            20 -> {

            }

            21 -> {

            }

            22 -> {

            }

            23 -> {

            }

            24 -> {

            }

            25 -> {

            }

            26 -> {

            }

            27 -> {

            }

            28 -> {

            }

            29 -> {

            }

            30 -> {

            }

            31 -> {

            }

            32 -> {

            }

            33 -> {

            }

            34 -> {

            }

            35 -> {

            }

            36 -> {

            }

            37 -> {

            }

            38 -> {

            }

            39 -> {

            }

            40 -> {

            }

            41 -> {

            }

            42 -> {

            }

            43 -> {

            }

            44 -> {

            }

            45 -> {

            }

            46 -> {

            }

            47 -> {

            }

            48 -> {

            }

            49 -> {

            }

            50 -> {

            }

            51 -> {

            }

            52 -> {

            }

            53 -> {

            }

            54 -> {

            }

            55 -> {

            }

            56 -> {

            }

            57 -> {

            }

            58 -> {

            }

            59 -> {

            }

            60 -> {

            }

            61 -> {

            }

            62 -> {

            }

            63 -> {

            }

            64 -> {

            }

            65 -> {

            }

            66 -> {

            }

            67 -> {

            }

            68 -> {

            }

            69 -> {

            }

            70 -> {

            }

            71 -> {

            }

            72 -> {

            }

            73 -> {

            }

            74 -> {

            }

            75 -> {

            }

            76 -> {

            }

            77 -> {

            }

            78 -> {

            }

            79 -> {

            }

            80 -> {

            }

            81 -> {

            }

            82 -> {

            }

            83 -> {

            }

            84 -> {

            }

            85 -> {

            }

            86 -> {

            }

            87 -> {

            }

            88 -> {

            }

            89 -> {

            }

            90 -> {

            }

            91 -> {

            }

            92 -> {

            }

            93 -> {

            }

            94 -> {

            }

            95 -> {

            }

            96 -> {

            }

            97 -> {

            }

            98 -> {

            }

            99 -> {

            }

            100 -> {

            }

            101 -> {

            }

            102 -> {

            }

            103 -> {

            }

            104 -> {

            }

            105 -> {

            }

            106 -> {

            }

            107 -> {

            }

            108 -> {

            }

            109 -> {

            }

            110 -> {

            }

            111 -> {

            }

            112 -> {

            }

            113 -> {

            }

            114 -> {

            }

            115 -> {

            }

            116 -> {

            }

            117 -> {

            }

            118 -> {

            }

            119 -> {

            }

            120 -> {

            }

            121 -> {

            }

            122 -> {

            }

            123 -> {

            }

            124 -> {

            }

            125 -> {

            }

            126 -> {

            }

            127 -> {

            }

            128 -> {

            }

            129 -> {

            }

            130 -> {

            }

            131 -> {

            }

            132 -> {

            }

            133 -> {

            }

            134 -> {

            }

            135 -> {

            }

            136 -> {

            }

            137 -> {

            }

            138 -> {

            }

            139 -> {

            }

            140 -> {

            }

            141 -> {

            }

            142 -> {

            }

            143 -> {

            }

            144 -> {

            }

            145 -> {

            }

            146 -> {

            }

            147 -> {

            }

            148 -> {

            }

            149 -> {

            }

            150 -> {

            }

            151 -> {

            }

            152 -> {

            }

            153 -> {

            }

            154 -> {

            }

            155 -> {

            }

            156 -> {

            }

            157 -> {

            }

            158 -> {

            }

            159 -> {

            }

            160 -> {

            }

            161 -> {

            }

            162 -> {

            }

            163 -> {

            }

            164 -> {

            }

            165 -> {

            }

            166 -> {

            }

            167 -> {

            }

            168 -> {

            }

            169 -> {

            }

            170 -> {

            }

            171 -> {

            }

            172 -> {

            }

            173 -> {

            }

            174 -> {

            }

            175 -> {

            }

            176 -> {

            }

            177 -> {

            }

            178 -> {

            }

            179 -> {

            }

            180 -> {

            }

            181 -> {

            }

            182 -> {

            }

            183 -> {

            }

            184 -> {

            }

            185 -> {

            }

            186 -> {

            }

            187 -> {

            }

            188 -> {

            }

            189 -> {

            }

            190 -> {

            }

            191 -> {

            }

            192 -> {

            }

            193 -> {

            }

            194 -> {

            }

            195 -> {

            }

            196 -> {

            }

            197 -> {

            }

            198 -> {

            }

            199 -> {

            }

            200 -> {

            }

            201 -> {

            }

            202 -> {

            }

            203 -> {

            }

            204 -> {

            }

            205 -> {

            }

            206 -> {

            }

            207 -> {

            }

            208 -> {

            }

            209 -> {

            }

            210 -> {

            }

            211 -> {

            }

            212 -> {

            }

            213 -> {

            }

            214 -> {

            }

            215 -> {

            }

            216 -> {

            }

            217 -> {

            }

            218 -> {

            }

            219 -> {

            }

            220 -> {

            }

            221 -> {

            }

            222 -> {

            }

            223 -> {

            }

            224 -> {

            }

            225 -> {

            }

            226 -> {

            }

            227 -> {

            }

            228 -> {

            }

            229 -> {

            }

            230 -> {

            }

            231 -> {

            }

            232 -> {

            }

            233 -> {

            }

            234 -> {

            }

            235 -> {

            }

            236 -> {

            }

            237 -> {

            }

            238 -> {

            }

            239 -> {

            }

            240 -> {

            }

            241 -> {

            }

            242 -> {

            }

            243 -> {

            }

            244 -> {

            }

            245 -> {

            }

            246 -> {

            }

            247 -> {

            }

            248 -> {

            }

            249 -> {

            }

            250 -> {

            }

            251 -> {

            }

            252 -> {

            }

            253 -> {

            }

            254 -> {

            }

            255 -> {

            }

            256 -> {

            }

            257 -> {

            }

            258 -> {

            }

            259 -> {

            }

            260 -> {

            }

            261 -> {

            }

            262 -> {

            }

            263 -> {

            }

            264 -> {

            }

            265 -> {

            }

            266 -> {

            }

            267 -> {

            }

            268 -> {

            }

            269 -> {

            }

            270 -> {

            }

            271 -> {

            }

            272 -> {

            }

            273 -> {

            }

            274 -> {

            }

            275 -> {

            }

            276 -> {

            }

            277 -> {

            }

            278 -> {

            }

            279 -> {

            }

            280 -> {

            }

            281 -> {

            }

            282 -> {

            }

            283 -> {

            }

            284 -> {

            }

            285 -> {

            }

            286 -> {

            }

            287 -> {

            }

            288 -> {

            }

            289 -> {

            }

            290 -> {

            }

            291 -> {

            }

            292 -> {

            }

            293 -> {

            }

            294 -> {

            }

            295 -> {

            }

            296 -> {

            }

            297 -> {

            }

            298 -> {

            }

            299 -> {

            }

            300 -> {

            }

            301 -> {

            }

            302 -> {

            }

            303 -> {

            }

            304 -> {

            }

            305 -> {

            }

            306 -> {

            }

            307 -> {

            }

            308 -> {

            }

            309 -> {

            }

            310 -> {

            }

            311 -> {

            }

            312 -> {

            }

            313 -> {

            }

            314 -> {

            }

            315 -> {

            }

            316 -> {

            }

            317 -> {

            }

            318 -> {

            }

            319 -> {

            }

            320 -> {

            }

            321 -> {

            }

            322 -> {

            }

            323 -> {

            }

            324 -> {

            }

            325 -> {

            }

            326 -> {

            }

            327 -> {

            }

            328 -> {

            }

            329 -> {

            }

            330 -> {

            }

            331 -> {

            }

            332 -> {

            }

            333 -> {

            }

            334 -> {

            }

            335 -> {

            }

            336 -> {

            }

            337 -> {

            }

            338 -> {

            }

            339 -> {

            }

            340 -> {

            }

            341 -> {

            }

            342 -> {

            }

            343 -> {

            }

            344 -> {

            }

            345 -> {

            }

            346 -> {

            }

            347 -> {

            }

            348 -> {

            }

            349 -> {

            }

            350 -> {

            }
            // TODO Add more cases as needed
        }
    }
}
