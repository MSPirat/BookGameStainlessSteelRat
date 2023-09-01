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
                mChapterText.setText(R.string.ch_1)
                addButton(getString(R.string.way_1_229), 229)
                addButton(getString(R.string.way_1_347), 347)
            }

            2 -> {
                mChapterText.setText(R.string.ch_2)
                addButton(getString(R.string.way_2_4), 4)
                addButton(getString(R.string.way_2_138), 138)
            }

            3 -> {
                mChapterText.setText(R.string.ch_3)
                addButton(getString(R.string.way_3_218), 218)
            }

            4 -> {
                mChapterText.setText(R.string.ch_4)
                addButton(getString(R.string.way_4_134), 134)
            }
            5 -> {
                mChapterText.setText(R.string.ch_5)
                addButton(getString(R.string.way_5_342), 342)
                addButton(getString(R.string.way_5_343), 343)
            }
            6 -> {
                mChapterText.setText(R.string.ch_6)
                addButton(getString(R.string.way_6_76), 76)
                addButton(getString(R.string.way_6_232), 232)
            }
            7 -> {
                mChapterText.setText(R.string.ch_7)
                addButton(getString(R.string.way_7_65), 65)
            }
            8 -> {
                setTitle(R.string.title_8)
                mChapterText.setText(R.string.ch_8)
                addButton(getString(R.string.way_8_253), 253)
            }
            9 -> {
                mChapterText.setText(R.string.ch_9)
                addButton(getString(R.string.way_9_311), 311)
            }
            10 -> {
                mChapterText.setText(R.string.ch_10)
                addButton(getString(R.string.way_10_82), 82)
            }
            11 -> {
                mChapterText.setText(R.string.ch_11)
                addButton(getString(R.string.way_11_140), 140)
            }
            12 -> {
                mChapterText.setText(R.string.ch_12)
                addButton(getString(R.string.way_12_65), 65)
            }
            13 -> {
                mChapterText.setText(R.string.ch_13)
                addButton(getString(R.string.way_13_88), 88)
            }
            14 -> {
                mChapterText.setText(R.string.ch_14)
                addButton(getString(R.string.way_14_99), 99)
            }
            15 -> {
                mChapterText.setText(R.string.ch_15)
                addButton(getString(R.string.way_15_113), 113)
            }
            16 -> {
                mChapterText.setText(R.string.ch_16)
                addButton(getString(R.string.way_16_139), 139)
            }
            17 -> {
                mChapterText.setText(R.string.ch_17)
                addButton(getString(R.string.way_17_115), 115)
            }
            18 -> {
                mChapterText.setText(R.string.ch_18)
                addButton(getString(R.string.way_18_87), 87)
            }
            19 -> {
                mChapterText.setText(R.string.ch_19)
                addButton(getString(R.string.way_19_49), 49)
                addButton(getString(R.string.way_19_124), 124)
            }
            20 -> {
                mChapterText.setText(R.string.ch_20)
                addButton(getString(R.string.way_20_339), 339)
            }

            21 -> {
                mChapterText.setText(R.string.ch_21)
                addButton(getString(R.string.way_21_80), 80)
            }
            22 -> {
                mChapterText.setText(R.string.ch_22)
                addButton(getString(R.string.way_22_34), 34)
            }
            23 -> {
                mChapterText.setText(R.string.ch_23)
                addButton(getString(R.string.way_23_340), 340)
            }
            24 -> {
                mChapterText.setText(R.string.ch_24)
                addButton(getString(R.string.way_24_302), 302)
                addButton(getString(R.string.way_24_332), 332)
            }
            25 -> {
                mChapterText.setText(R.string.ch_25)
                addButton(getString(R.string.way_25_90), 90)
                addButton(getString(R.string.way_25_167), 167)
            }
            26 -> {
                mChapterText.setText(R.string.ch_26)
                addButton(getString(R.string.way_26_205), 205)
            }
            27 -> {
                mChapterText.setText(R.string.ch_27)
                addButton(getString(R.string.way_27_163), 163)
                addButton(getString(R.string.way_27_289), 289)
            }
            28 -> {
                mChapterText.setText(R.string.ch_28)
                addButton(getString(R.string.way_28_121), 121)
            }
            29 -> {
                mChapterText.setText(R.string.ch_29)
                addButton(getString(R.string.way_29_64), 64)
            }
            30 -> {
                mChapterText.setText(R.string.ch_30)
                addButton(getString(R.string.way_30_42), 42)
            }
            31 -> {
                mChapterText.setText(R.string.ch_31)
                addButton(getString(R.string.way_31_344), 344)
                addButton(getString(R.string.way_31_292), 292)
                addButton(getString(R.string.way_31_346), 346)
            }
            32 -> {
                mChapterText.setText(R.string.ch_32)
                addButton(getString(R.string.way_32_118), 118)
            }
            33 -> {
                mChapterText.setText(R.string.ch_33)
                addButton(getString(R.string.way_33_12), 12)
            }
            34 -> {
                mChapterText.setText(R.string.ch_34)
                addButton(getString(R.string.way_34_32), 32)
                addButton(getString(R.string.way_34_118), 118)
            }
            35 -> {
                mChapterText.setText(R.string.ch_35)
                addButton(getString(R.string.way_35_197), 197)
            }
            36 -> {
                mChapterText.setText(R.string.ch_36)
                addButton(getString(R.string.way_36_120), 120)
            }
            37 -> {
                mChapterText.setText(R.string.ch_37)
                addButton(getString(R.string.way_37_18), 18)
            }
            38 -> {
                mChapterText.setText(R.string.ch_38)
                addButton(getString(R.string.way_38_216), 216)
            }
            39 -> {
                mChapterText.setText(R.string.ch_39)
                addButton(getString(R.string.way_39_255), 255)
            }
            40 -> {
                mChapterText.setText(R.string.ch_40)
                addButton(getString(R.string.way_40_254), 254)
                addButton(getString(R.string.way_40_284), 284)
            }

            41 -> {
                mChapterText.text = getString(R.string.ch_41)
                addButton(getString(R.string.way_41_50), 50)
                addButton(getString(R.string.way_41_54), 54)
                addButton(getString(R.string.way_41_315), 315)
            }
            42 -> {
                mChapterText.text = getString(R.string.ch_42)
                addButton(getString(R.string.way_42_62), 62)
            }
            43 -> {
                mChapterText.text = getString(R.string.ch_43)
                addButton(getString(R.string.way_43_63), 63)
            }
            44 -> {
                mChapterText.text = getString(R.string.ch_44)
                addButton(getString(R.string.way_44_23), 23)
            }
            45 -> {
                mChapterText.text = getString(R.string.ch_45)
                addButton(getString(R.string.way_45_215), 215)
            }
            46 -> {
                mChapterText.text = getString(R.string.ch_46)
                addButton(getString(R.string.way_46_193), 193)
                addButton(getString(R.string.way_46_339), 339)
            }
            47 -> {
                mChapterText.text = getString(R.string.ch_47)
                addButton(getString(R.string.way_47_98), 98)
            }
            48 -> {
                mChapterText.text = getString(R.string.ch_48)
                addButton(getString(R.string.way_48_61), 61)
                addButton(getString(R.string.way_48_67), 67)
            }
            49 -> {
                mChapterText.text = getString(R.string.ch_49)
                addButton(getString(R.string.way_49_304), 304)
                addButton(getString(R.string.way_49_337), 337)
            }
            50 -> {
                mChapterText.text = getString(R.string.ch_50)
                addButton(getString(R.string.way_50_164), 164)
            }
            51 -> {
                mChapterText.text = getString(R.string.ch_51)
                addButton(getString(R.string.way_51_215), 215)
                addButton(getString(R.string.way_51_45), 45)
            }
            52 -> {
                mChapterText.text = getString(R.string.ch_52)
                addButton(getString(R.string.way_52_307), 307)
            }
            53 -> {
                mChapterText.text = getString(R.string.ch_53)
                addButton(getString(R.string.way_53_16), 16)
                addButton(getString(R.string.way_53_139), 139)
            }
            54 -> {
                mChapterText.text = getString(R.string.ch_54)
                addButton(getString(R.string.way_54_71), 71)
            }
            55 -> {
                mChapterText.text = getString(R.string.ch_55)
                addButton(getString(R.string.way_55_206), 206)
            }
            56 -> {
                mChapterText.text = getString(R.string.ch_56)
                addButton(getString(R.string.way_56_11), 11)
            }
            57 -> {
                mChapterText.text = getString(R.string.ch_57)
                addButton(getString(R.string.way_57_255), 255)
            }
            58 -> {
                mChapterText.text = getString(R.string.ch_58)
                addButton(getString(R.string.way_58_283), 283)
                addButton(getString(R.string.way_58_160), 160)
            }
            59 -> {
                mChapterText.text = getString(R.string.ch_59)
                addButton(getString(R.string.way_59_80), 80)
            }

            60 -> {
                mChapterText.setText(R.string.ch_60)
                addButton(getString(R.string.way_60_72), 72)
            }
            61 -> {
                mChapterText.setText(R.string.ch_61)
                addButton(getString(R.string.way_61_67), 67)
            }
            62 -> {
                mChapterText.setText(R.string.ch_62)
                addButton(getString(R.string.way_62_14), 14)
                addButton(getString(R.string.way_62_99), 99)
            }
            63 -> {
                mChapterText.setText(R.string.ch_63)
                addButton(getString(R.string.way_63_130), 130)
            }
            64 -> {
                mChapterText.setText(R.string.ch_64)
                addButton(getString(R.string.way_64_114), 114)
                addButton(getString(R.string.way_64_345), 345)
            }
            65 -> {
                mChapterText.setText(R.string.ch_65)
                addButton(getString(R.string.way_65_48), 48)
            }
            66 -> {
                mChapterText.setText(R.string.ch_66)
                addButton(getString(R.string.way_66_181), 181)
            }
            67 -> {
                setTitle(R.string.title_67)
                mChapterText.setText(R.string.ch_67)
                addButton(getString(R.string.way_67_97), 97)
                addButton(getString(R.string.way_67_146), 146)
            }
            // Add other cases here
            68 -> {
                // Handle case 68
            }
            69 -> {
                mChapterText.setText(R.string.ch_69)
                addButton(getString(R.string.way_69_70), 70)
            }
            70 -> {
                mChapterText.setText(R.string.ch_70)
                addButton(getString(R.string.way_70_278), 278)
            }
            71 -> {
                mChapterText.setText(R.string.ch_71)
                addButton(getString(R.string.way_71_161), 161)
            }
            72 -> {
                mChapterText.setText(R.string.ch_72)
                addButton(getString(R.string.way_72_348), 348)
            }
            73 -> {
                mChapterText.setText(R.string.ch_73)
                addButton(getString(R.string.way_73_313), 313)
            }
            74 -> {
                mChapterText.setText(R.string.ch_74)
                addButton(getString(R.string.way_74_320), 320)
            }
            75 -> {
                mChapterText.setText(R.string.ch_75)
                addButton(getString(R.string.way_75_70), 70)
            }
            76 -> {
                mChapterText.setText(R.string.ch_76)
                addButton(getString(R.string.way_76_237), 237)
                addButton(getString(R.string.way_76_310), 310)
            }
            77 -> {
                mChapterText.setText(R.string.ch_77)
                addButton(getString(R.string.way_77_78), 78)
            }
            78 -> {
                mChapterText.setText(R.string.ch_78)
                addButton(getString(R.string.way_78_128), 128)
            }
            79 -> {
                mChapterText.setText(R.string.ch_79)
                addButton(getString(R.string.way_79_51), 51)
            }
            80 -> {
                mChapterText.setText(R.string.ch_80)
                addButton(getString(R.string.way_80_330), 330)
                addButton(getString(R.string.way_80_149), 149)
                addButton(getString(R.string.way_80_59), 59)
                addButton(getString(R.string.way_80_159), 159)
                addButton(getString(R.string.way_80_21), 21)
                addButton(getString(R.string.way_80_168), 168)
            }
            81 -> {
                mChapterText.setText(R.string.ch_81)
                addButton(getString(R.string.way_81_51), 51)
            }
            82 -> {
                mChapterText.setText(R.string.ch_82)
                addButton(getString(R.string.way_82_148), 148)
            }
            83 -> {
                mChapterText.setText(R.string.ch_83)
                addButton(getString(R.string.way_83_170), 170)
            }
            84 -> {
                mChapterText.setText(R.string.ch_84)
                addButton(getString(R.string.way_84_9), 9)
                addButton(getString(R.string.way_84_166), 166)
            }
            85 -> {
                mChapterText.setText(R.string.ch_85)
                addButton(getString(R.string.way_85_31), 31)
            }
            86 -> {
                mChapterText.setText(R.string.ch_86)
                addButton(getString(R.string.way_86_137), 137)
                addButton(getString(R.string.way_86_25), 25)
            }
            87 -> {
                mChapterText.setText(R.string.ch_87)
                addButton(getString(R.string.way_87_306), 306)
            }
            88 -> {
                mChapterText.setText(R.string.ch_88)
                addButton(getString(R.string.way_88_131), 131)
                addButton(getString(R.string.way_88_249), 249)
            }
            89 -> {
                mChapterText.setText(R.string.ch_89)
                addButton(getString(R.string.way_89_1), 1)
            }
            90 -> {
                mChapterText.setText(R.string.ch_90)
                addButton(getString(R.string.way_90_175), 175)
            }
            // Add other cases here
            91 -> {
                // Handle case 91
            }
            92 -> {
                mChapterText.setText(R.string.ch_92)
                addButton(getString(R.string.way_92_200), 200)
                addButton(getString(R.string.way_92_53), 53)
            }
            93 -> {
                mChapterText.setText(R.string.ch_93)
                addButton(getString(R.string.way_93_103), 103)
                addButton(getString(R.string.way_93_221), 221)
                addButton(getString(R.string.way_93_158), 158)
            }
            94 -> {
                mChapterText.setText(R.string.ch_94)
                addButton(getString(R.string.way_94_7), 7)
                addButton(getString(R.string.way_94_65), 65)
            }
            95 -> {
                mChapterText.setText(R.string.ch_95)
                addButton(getString(R.string.way_95_255), 255)
            }
            96 -> {
                mChapterText.setText(R.string.ch_96)
                addButton(getString(R.string.way_96_47), 47)
                addButton(getString(R.string.way_96_66), 66)
                addButton(getString(R.string.way_96_105), 105)
                addButton(getString(R.string.way_96_123), 123)
            }
            97 -> {
                mChapterText.setText(R.string.ch_97)
                addButton(getString(R.string.way_97_129), 129)
                addButton(getString(R.string.way_97_174), 174)
                addButton(getString(R.string.way_97_186), 186)
                addButton(getString(R.string.way_97_193), 193)
            }
            98 -> {
                mChapterText.setText(R.string.ch_98)
                addButton(getString(R.string.way_98_181), 181)
            }
            99 -> {
                mChapterText.setText(R.string.ch_99)
                addButton(getString(R.string.way_99_106), 106)
                addButton(getString(R.string.way_99_189), 189)
            }
            100 -> {
                mChapterText.setText(R.string.ch_100)
                addButton(getString(R.string.way_100_58), 58)
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
