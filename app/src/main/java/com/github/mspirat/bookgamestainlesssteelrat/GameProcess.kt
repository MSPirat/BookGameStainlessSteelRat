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
                mChapterText.setText(R.string.ch_101)
                addButton(getString(R.string.way_101_20), 20)
            }

            102 -> {
                mChapterText.setText(R.string.ch_102)
                addButton(getString(R.string.way_102_109), 109)
            }

            103 -> {
                mChapterText.setText(R.string.ch_103)
                addButton(getString(R.string.way_103_221), 221)
            }

            104 -> {
                mChapterText.setText(R.string.ch_104)
                addButton(getString(R.string.way_104_314), 314)
                addButton(getString(R.string.way_104_15), 15)
                addButton(getString(R.string.way_104_155), 155)
            }

            105 -> {
                mChapterText.setText(R.string.ch_105)
                addButton(getString(R.string.way_105_181), 181)
            }

            106 -> {
                mChapterText.setText(R.string.ch_106)
                addButton(getString(R.string.way_106_94), 94)
                addButton(getString(R.string.way_106_65), 65)
            }

            107 -> {
                mChapterText.setText(R.string.ch_107)
                addButton(getString(R.string.way_107_110), 110)
                addButton(getString(R.string.way_107_111), 111)
                addButton(getString(R.string.way_107_145), 145)
            }

            108 -> {
                mChapterText.setText(R.string.ch_108)
                addButton(getString(R.string.way_108_110), 110)
            }

            109 -> {
                mChapterText.setText(R.string.ch_109)
                addButton(getString(R.string.way_109_125), 125)
            }

            110 -> {
                mChapterText.setText(R.string.ch_110)
                addButton(getString(R.string.way_110_207), 207)
            }

            111 -> {
                mChapterText.setText(R.string.ch_111)
                addButton(getString(R.string.way_111_145), 145)
            }

            112 -> {
                mChapterText.setText(R.string.ch_112)
                addButton(getString(R.string.way_112_305), 305)
            }

            113 -> {
                mChapterText.setText(R.string.ch_113)
                addButton(getString(R.string.way_113_199), 199)
            }

            114 -> {
                mChapterText.setText(R.string.ch_114)
                addButton(getString(R.string.way_114_25), 25)
                addButton(getString(R.string.way_114_137), 137)
            }

            115 -> {
                mChapterText.setText(R.string.ch_115)
                addButton(getString(R.string.way_115_96), 96)
            }

            116 -> {
                mChapterText.setText(R.string.ch_116)
                addButton(getString(R.string.way_116_185), 185)
            }

            117 -> {
                mChapterText.setText(R.string.ch_117)
                addButton(getString(R.string.way_117_142), 142)
            }

            118 -> {
                setTitle(R.string.title_118)
                mChapterText.setText(R.string.ch_118)
                addButton(getString(R.string.way_118_36), 36)
                addButton(getString(R.string.way_118_120), 120)
            }

            119 -> {
                mChapterText.setText(R.string.ch_119)
                addButton(getString(R.string.way_119_248), 248)
                addButton(getString(R.string.way_119_165), 165)
            }

            120 -> {
                mChapterText.setText(R.string.ch_120)
                addButton(getString(R.string.way_120_39), 39)
                addButton(getString(R.string.way_120_57), 57)
                addButton(getString(R.string.way_120_276), 276)
            }

            121 -> {
                setTitle(R.string.title_121)
                mChapterText.setText(R.string.ch_121)
                addButton(getString(R.string.way_121_18), 18)
                addButton(getString(R.string.way_121_37), 37)
            }

            122 -> {
                mChapterText.setText(R.string.ch_122)
                addButton(getString(R.string.way_122_333), 333)
            }

            123 -> {
                mChapterText.setText(R.string.ch_123)
                addButton(getString(R.string.way_123_17), 17)
                addButton(getString(R.string.way_123_191), 191)
            }

            124 -> {
                mChapterText.setText(R.string.ch_124)
                addButton(getString(R.string.way_124_304), 304)
                addButton(getString(R.string.way_124_337), 337)
            }

            125 -> {
                setTitle(R.string.title_125)
                mChapterText.setText(R.string.ch_125)
                addButton(getString(R.string.way_125_55), 55)
                addButton(getString(R.string.way_125_206_2), 206)
                addButton(getString(R.string.way_125_206_1), 206)
            }

            126 -> {
                mChapterText.setText(R.string.ch_126)
                addButton(getString(R.string.way_126_136), 136)
            }

            127 -> {
                mChapterText.setText(R.string.ch_127)
                addButton(getString(R.string.way_127_252), 252)
            }

            128 -> {
                mChapterText.setText(R.string.ch_128)
                addButton(getString(R.string.way_128_271), 271)
                addButton(getString(R.string.way_128_301), 301)
                addButton(getString(R.string.way_128_336), 336)
            }

            129 -> {
                mChapterText.setText(R.string.ch_129)
                addButton(getString(R.string.way_129_180), 180)
            }

            130 -> {
                mChapterText.setText(R.string.ch_130)
                addButton(getString(R.string.way_130_192_1), 192)
                addButton(getString(R.string.way_130_192_2), 192)
            }

            131 -> {
                setTitle(R.string.title_131)
                mChapterText.setText(R.string.ch_131)
                addButton(getString(R.string.way_131_40), 40)
                addButton(getString(R.string.way_131_257), 257)
            }

            132 -> {
                mChapterText.setText(R.string.ch_132)
                addButton(getString(R.string.way_132_190), 190)
            }

            133 -> {
                mChapterText.setText(R.string.ch_133)
                addButton(getString(R.string.way_133_342), 342)
                addButton(getString(R.string.way_133_343), 343)
            }

            134 -> {
                mChapterText.setText(R.string.ch_134)
                addButton(getString(R.string.way_134_38), 38)
                addButton(getString(R.string.way_134_169), 169)
            }

            135 -> {
                mChapterText.setText(R.string.ch_135)
                addButton(getString(R.string.way_135_230), 230)
                addButton(getString(R.string.way_135_13), 13)
            }

            136 -> {
                mChapterText.setText(R.string.ch_136)
                addButton(getString(R.string.way_136_43), 43)
                addButton(getString(R.string.way_136_63), 63)
            }

            137 -> {
                mChapterText.setText(R.string.ch_137)
                addButton(getString(R.string.way_137_90), 90)
                addButton(getString(R.string.way_137_167), 167)
            }

            138 -> {
                mChapterText.setText(R.string.ch_138)
                addButton(getString(R.string.way_138_4), 4)
            }

            139 -> {
                mChapterText.setText(R.string.ch_139)
                addButton(getString(R.string.way_139_83), 83)
                addButton(getString(R.string.way_139_170), 170)
            }

            140 -> {
                mChapterText.setText(R.string.ch_140)
                addButton(getString(R.string.way_140_179), 179)
            }

            141 -> {
                mChapterText.setText(R.string.ch_141)
                addButton(getString(R.string.way_141_260), 260)
            }

            142 -> {
                mChapterText.setText(R.string.ch_142)
                addButton(getString(R.string.way_142_177), 177)
                addButton(getString(R.string.way_142_171), 171)
            }

            143 -> {
                mChapterText.setText(R.string.ch_143)
                addButton(getString(R.string.way_143_126), 126)
                addButton(getString(R.string.way_143_136), 136)
            }

            144 -> {
                mChapterText.setText(R.string.ch_144)
                addButton(getString(R.string.way_144_60), 60)
                addButton(getString(R.string.way_144_282), 282)
            }

            145 -> {
                mChapterText.setText(R.string.ch_145)
                addButton(getString(R.string.way_145_108), 108)
            }

            146 -> {
                mChapterText.setText(R.string.ch_146)
                addButton(getString(R.string.way_146_129), 129)
                addButton(getString(R.string.way_146_174), 174)
                addButton(getString(R.string.way_146_186), 186)
                addButton(getString(R.string.way_146_193), 193)
            }

            147 -> {
                setTitle(R.string.title_147)
                mChapterText.setText(R.string.ch_147)
                addButton(getString(R.string.way_147_319), 319)
                addButton(getString(R.string.way_147_41), 41)
            }

            148 -> {
                mChapterText.setText(R.string.ch_148)
                addButton(getString(R.string.way_148_143), 143)
            }

            149 -> {
                mChapterText.setText(R.string.ch_149)
                addButton(getString(R.string.way_149_80), 80)
            }

            150 -> {
                mChapterText.setText(R.string.ch_150)
                addButton(getString(R.string.way_150_119), 119)
            }

            151 -> {
                mChapterText.setText(R.string.ch_151)
                addButton(getString(R.string.way_151_270), 270)
            }

            152 -> {
                mChapterText.setText(R.string.ch_152)
                addButton(getString(R.string.way_152_112), 112)
            }

            153 -> {
                mChapterText.setText(R.string.ch_153)
                addButton(getString(R.string.way_153_28), 28)
            }

            154 -> {
                mChapterText.setText(R.string.ch_154)
                addButton(getString(R.string.way_154_176), 176)
                addButton(getString(R.string.way_154_190), 190)
            }

            155 -> {
                mChapterText.setText(R.string.ch_155)
                addButton(getString(R.string.way_155_113), 113)
            }

            156 -> {
                mChapterText.setText(R.string.ch_156)
                addButton(getString(R.string.way_156_330), 330)
                addButton(getString(R.string.way_156_149), 149)
                addButton(getString(R.string.way_156_59), 59)
                addButton(getString(R.string.way_156_159), 159)
                addButton(getString(R.string.way_156_21), 21)
            }

            157 -> {
                mChapterText.setText(R.string.ch_157)
                addButton(getString(R.string.way_157_275), 275)
                addButton(getString(R.string.way_157_69), 69)
            }

            158 -> {
                mChapterText.setText(R.string.ch_158)
                addButton(getString(R.string.way_158_299), 299)
            }

            159 -> {
                mChapterText.setText(R.string.ch_159)
                addButton(getString(R.string.way_159_80), 80)
            }

            160 -> {
                mChapterText.setText(R.string.ch_160)
                addButton(getString(R.string.way_160_72), 72)
            }

            161 -> {
                mChapterText.setText(R.string.ch_161)
                addButton(getString(R.string.way_161_328), 328)
            }
            // Add other cases here
            162 -> {
                // Handle case 162
            }

            163 -> {
                mChapterText.setText(R.string.ch_163)
                addButton(getString(R.string.way_163_5), 5)
                addButton(getString(R.string.way_163_342), 342)
            }

            164 -> {
                mChapterText.setText(R.string.ch_164)
                addButton(getString(R.string.way_164_329), 329)
            }

            165 -> {
                mChapterText.setText(R.string.ch_165)
                addButton(getString(R.string.way_165_308), 308)
                addButton(getString(R.string.way_165_325), 325)
            }

            166 -> {
                mChapterText.setText(R.string.ch_166)
                addButton(getString(R.string.way_166_133), 133)
                addButton(getString(R.string.way_166_343), 343)
            }

            167 -> {
                setTitle(R.string.title_167)
                mChapterText.setText(R.string.ch_167)
                addButton(getString(R.string.way_167_53), 53)
                addButton(getString(R.string.way_167_92), 92)
            }

            168 -> {
                mChapterText.setText(R.string.ch_168)
                addButton(getString(R.string.way_168_323), 323)
            }

            169 -> {
                mChapterText.setText(R.string.ch_169)
                addButton(getString(R.string.way_169_38), 38)
            }

            170 -> {
                mChapterText.setText(R.string.ch_170)
                addButton(getString(R.string.way_170_214), 214)
            }

            171 -> {
                mChapterText.setText(R.string.ch_171)
                addButton(getString(R.string.way_171_213), 213)
            }
            // Add other cases here
            172 -> {
                // Handle case 172
            }

            173 -> {
                mChapterText.setText(R.string.ch_173)
                addButton(getString(R.string.way_173_144), 144)
            }

            174 -> {
                mChapterText.setText(R.string.ch_174)
                addButton(getString(R.string.way_174_101), 101)
                addButton(getString(R.string.way_174_20), 20)
            }

            175 -> {
                mChapterText.setText(R.string.ch_175)
                addButton(getString(R.string.way_175_29), 29)
            }

            176 -> {
                mChapterText.setText(R.string.ch_176)
                addButton(getString(R.string.way_176_190), 190)
            }

            177 -> {
                mChapterText.setText(R.string.ch_177)
                addButton(getString(R.string.way_177_171), 171)
            }

            178 -> {
                mChapterText.setText(R.string.ch_178)
                addButton(getString(R.string.way_178_205), 205)
            }

            179 -> {
                setTitle(R.string.title_179)
                mChapterText.setText(R.string.ch_179)
                addButton(getString(R.string.way_179_156), 156)
            }

            180 -> {
                mChapterText.setText(R.string.ch_180)
                addButton(getString(R.string.way_180_46), 46)
                addButton(getString(R.string.way_180_339), 339)
            }

            181 -> {
                mChapterText.setText(R.string.ch_181)
                addButton(getString(R.string.way_181_122_1), 122)
                addButton(getString(R.string.way_181_122_2), 122)
            }

            182 -> {
                mChapterText.setText(R.string.ch_182)
                addButton(getString(R.string.way_182_194), 194)
            }

            183 -> {
                mChapterText.setText(R.string.ch_183)
                addButton(getString(R.string.way_183_112), 112)
            }

            184 -> {
                mChapterText.setText(R.string.ch_184)
                addButton(getString(R.string.way_184_5), 5)
                addButton(getString(R.string.way_184_342), 342)
            }

            185 -> {
                mChapterText.setText(R.string.ch_185)
                addButton(getString(R.string.way_185_328), 328)
            }

            186 -> {
                mChapterText.setText(R.string.ch_186)
                addButton(getString(R.string.way_186_33), 33)
                addButton(getString(R.string.way_186_12), 12)
            }

            187 -> {
                mChapterText.setText(R.string.ch_187)
                addButton(getString(R.string.way_187_104), 104)
            }

            188 -> {
                mChapterText.setText(R.string.ch_188)
                addButton(getString(R.string.way_188_267), 267)
                addButton(getString(R.string.way_188_150), 150)
            }

            189 -> {
                mChapterText.setText(R.string.ch_189)
                addButton(getString(R.string.way_189_65), 65)
                addButton(getString(R.string.way_189_94), 94)
            }

            190 -> {
                mChapterText.setText(R.string.ch_190)
                addButton(getString(R.string.way_190_182), 182)
                addButton(getString(R.string.way_190_194), 194)
            }

            191 -> {
                mChapterText.setText(R.string.ch_191)
                addButton(getString(R.string.way_191_98), 98)
            }

            192 -> {
                mChapterText.setText(R.string.ch_192)
                addButton(getString(R.string.way_192_225), 225)
            }

            193 -> {
                mChapterText.setText(R.string.ch_193)
                addButton(getString(R.string.way_193_175), 175)
                addButton(getString(R.string.way_193_86), 86)
            }

            194 -> {
                mChapterText.setText(R.string.ch_194)
                addButton(getString(R.string.way_194_334), 334)
            }
            // Add other cases here
            195 -> {
                // Handle case 195
            }

            196 -> {
                mChapterText.setText(R.string.ch_196)
                addButton(getString(R.string.way_196_153), 153)
            }

            197 -> {
                mChapterText.setText(R.string.ch_197)
                addButton(getString(R.string.way_197_242), 242)
            }

            198 -> {
                mChapterText.setText(R.string.ch_198)
                addButton(getString(R.string.way_198_28), 28)
                addButton(getString(R.string.way_198_196), 196)
            }

            199 -> {
                setTitle(R.string.title_199)
                mChapterText.setText(R.string.ch_199)
                addButton(getString(R.string.way_199_117), 117)
                addButton(getString(R.string.way_199_327), 327)
            }

            200 -> {
                mChapterText.setText(R.string.ch_200)
                addButton(getString(R.string.way_200_53), 53)
            }

            201 -> {
                mChapterText.text = getString(R.string.ch_201)
                addButton(getString(R.string.way_201_85), 85)
            }

            202 -> {
                mChapterText.text = getString(R.string.ch_202)
                addButton(getString(R.string.way_202_210), 210)
                addButton(getString(R.string.way_202_226), 226)
            }

            203 -> {
                mChapterText.text = getString(R.string.ch_203)
                addButton(getString(R.string.way_203_208), 208)
                addButton(getString(R.string.way_203_264), 264)
            }
            // Add other cases here
            204 -> {
                // Handle case 204
            }

            205 -> {
                mChapterText.text = getString(R.string.ch_205)
                addButton(getString(R.string.way_205_3), 3)
                addButton(getString(R.string.way_205_198), 198)
            }

            206 -> {
                mChapterText.text = getString(R.string.ch_206)
                addButton(getString(R.string.way_206_107), 107)
            }

            207 -> {
                mChapterText.text = getString(R.string.ch_207)
                addButton(getString(R.string.way_207_224), 224)
                addButton(getString(R.string.way_207_266), 266)
            }

            208 -> {
                mChapterText.text = getString(R.string.ch_208)
                addButton(getString(R.string.way_208_261), 261)
            }

            209 -> {
                mChapterText.text = getString(R.string.ch_209)
                addButton(getString(R.string.way_209_348), 348)
            }

            210 -> {
                mChapterText.text = getString(R.string.ch_210)
                addButton(getString(R.string.way_210_202), 202)
            }

            211 -> {
                mChapterText.text = getString(R.string.ch_211)
                addButton(getString(R.string.way_211_241), 241)
                addButton(getString(R.string.way_211_281), 281)
                addButton(getString(R.string.way_211_297), 297)
            }

            212 -> {
                mChapterText.text = getString(R.string.ch_212)
                addButton(getString(R.string.way_212_240), 240)
                addButton(getString(R.string.way_212_296), 296)
            }

            213 -> {
                mChapterText.text = getString(R.string.ch_213)
                addButton(getString(R.string.way_213_188), 188)
            }

            214 -> {
                mChapterText.text = getString(R.string.ch_214)
                addButton(getString(R.string.way_214_178), 178)
                addButton(getString(R.string.way_214_26), 26)
            }

            215 -> {
                mChapterText.text = getString(R.string.ch_215)
                addButton(getString(R.string.way_215_128), 128)
            }

            216 -> {
                mChapterText.text = getString(R.string.ch_216)
                addButton(getString(R.string.way_216_22), 22)
            }

            217 -> {
                mChapterText.text = getString(R.string.ch_217)
                addButton(getString(R.string.way_217_300), 300)
            }

            218 -> {
                mChapterText.text = getString(R.string.ch_218)
                addButton(getString(R.string.way_218_28), 28)
            }

            219 -> {
                mChapterText.text = getString(R.string.ch_219)
                addButton(getString(R.string.way_219_266), 266)
            }

            220 -> {
                mChapterText.text = getString(R.string.ch_220)
                addButton(getString(R.string.way_220_234), 234)
                addButton(getString(R.string.way_220_235), 235)
                addButton(getString(R.string.way_220_240), 240)
            }

            221 -> {
                mChapterText.text = getString(R.string.ch_221)
                addButton(getString(R.string.way_221_299), 299)
            }

            222 -> {
                mChapterText.text = getString(R.string.ch_222)
                addButton(getString(R.string.way_222_228), 228)
                addButton(getString(R.string.way_222_235), 235)
            }

            223 -> {
                mChapterText.text = getString(R.string.ch_223)
                addButton(getString(R.string.way_223_96), 96)
            }

            224 -> {
                mChapterText.text = getString(R.string.ch_224)
                addButton(getString(R.string.way_224_219), 219)
            }

            225 -> {
                setTitle(R.string.title_225)
                mChapterText.text = getString(R.string.ch_225)
                addButton(getString(R.string.way_225_96), 96)
                addButton(getString(R.string.way_225_223), 223)
            }

            226 -> {
                mChapterText.text = getString(R.string.ch_226)
                addButton(getString(R.string.way_226_202), 202)
                addButton(getString(R.string.way_226_294), 294)
                addButton(getString(R.string.way_226_296), 296)
            }

            227 -> {
                mChapterText.text = getString(R.string.ch_227)
                addButton(getString(R.string.way_227_297), 297)
                addButton(getString(R.string.way_227_341), 341)
            }

            228 -> {
                mChapterText.text = getString(R.string.ch_228)
                addButton(getString(R.string.way_228_222), 222)
            }

            229 -> {
                mChapterText.text = getString(R.string.ch_229)
                addButton(getString(R.string.way_229_35), 35)
                addButton(getString(R.string.way_229_197), 197)
            }

            230 -> {
                mChapterText.text = getString(R.string.ch_230)
                addButton(getString(R.string.way_230_88), 88)
            }

            231 -> {
                mChapterText.text = getString(R.string.ch_231)
                addButton(getString(R.string.way_231_82), 82)
            }

            232 -> {
                mChapterText.text = getString(R.string.ch_232)
                addButton(getString(R.string.way_232_81), 81)
            }
            // Add other cases here
            233 -> {
                // Handle case 233
            }

            234 -> {
                mChapterText.text = getString(R.string.ch_234)
                addButton(getString(R.string.way_234_220), 220)
                addButton(getString(R.string.way_234_241), 241)
            }

            235 -> {
                mChapterText.text = getString(R.string.ch_235)
                addButton(getString(R.string.way_235_220), 220)
                addButton(getString(R.string.way_235_222), 222)
            }

            237 -> {
                mChapterText.text = getString(R.string.ch_237)
                addButton(getString(R.string.way_237_79), 79)
            }

            238 -> {
                mChapterText.text = getString(R.string.ch_238)
                addButton(getString(R.string.way_238_241), 241)
            }

            239 -> {
                mChapterText.text = getString(R.string.ch_239)
                addButton(getString(R.string.way_239_24), 24)
                addButton(getString(R.string.way_239_318), 318)
            }

            240 -> {
                mChapterText.text = getString(R.string.ch_240)
                addButton(getString(R.string.way_240_212), 212)
                addButton(getString(R.string.way_240_220), 220)
            }

            241 -> {
                mChapterText.text = getString(R.string.ch_241)
                addButton(getString(R.string.way_241_211), 211)
                addButton(getString(R.string.way_241_234), 234)
                addButton(getString(R.string.way_241_238), 238)
            }

            242 -> {
                mChapterText.text = getString(R.string.ch_242)
                addButton(getString(R.string.way_242_8), 8)
            }
            // Add other cases here
            243 -> {
                // Handle case 243
            }

            244 -> {
                mChapterText.text = getString(R.string.ch_244)
                addButton(getString(R.string.way_244_259), 259)
                addButton(getString(R.string.way_244_295), 295)
            }

            245 -> {
                mChapterText.text = getString(R.string.ch_245)
                addButton(getString(R.string.way_245_6), 6)
                addButton(getString(R.string.way_245_127), 127)
            }

            246 -> {
                mChapterText.text = getString(R.string.ch_246)
                addButton(getString(R.string.way_246_258), 258)
                addButton(getString(R.string.way_246_262), 262)
            }

            247 -> {
                mChapterText.text = getString(R.string.ch_247)
                addButton(getString(R.string.way_247_296), 296)
            }

            248 -> {
                mChapterText.text = getString(R.string.ch_248)
                addButton(getString(R.string.way_248_165), 165)
            }

            249 -> {
                mChapterText.text = getString(R.string.ch_249)
                addButton(getString(R.string.way_249_131), 131)
            }

            250 -> {
                mChapterText.text = getString(R.string.ch_250)
                addButton(getString(R.string.way_250_316), 316)
            }

            251 -> {
                mChapterText.setText(R.string.ch_251)
                addButton(getString(R.string.way_251_239), 239)
            }

            252 -> {
                mChapterText.setText(R.string.ch_252)
                addButton(getString(R.string.way_252_74), 74)
                addButton(getString(R.string.way_252_246), 246)
            }

            253 -> {
                mChapterText.setText(R.string.ch_253)
                addButton(getString(R.string.way_253_227), 227)
                addButton(getString(R.string.way_253_269), 269)
            }

            254 -> {
                mChapterText.setText(R.string.ch_254)
                addButton(getString(R.string.way_254_163), 163)
                addButton(getString(R.string.way_254_289), 289)
            }

            255 -> {
                mChapterText.setText(R.string.ch_255)
                addButton(getString(R.string.way_255_10), 10)
                addButton(getString(R.string.way_255_231), 231)
            }
            // Add other cases here
            256 -> {
                // Handle case 256
            }

            257 -> {
                mChapterText.setText(R.string.ch_257)
                addButton(getString(R.string.way_257_27), 27)
                addButton(getString(R.string.way_257_84), 84)
            }

            258 -> {
                mChapterText.setText(R.string.ch_258)
                addButton(getString(R.string.way_258_250), 250)
            }

            259 -> {
                mChapterText.setText(R.string.ch_259)
                addButton(getString(R.string.way_259_244), 244)
            }

            260 -> {
                mChapterText.setText(R.string.ch_260)
                addButton(getString(R.string.way_260_287), 287)
                addButton(getString(R.string.way_260_312), 312)
                addButton(getString(R.string.way_260_141), 141)
                addButton(getString(R.string.way_260_187), 187)
            }

            261 -> {
                setTitle(R.string.title_261)
                mChapterText.setText(R.string.ch_261)
                addButton(getString(R.string.way_261_277), 277)
                addButton(getString(R.string.way_261_290), 290)
            }

            262 -> {
                mChapterText.setText(R.string.ch_262)
                addButton(getString(R.string.way_262_250), 250)
            }

            263 -> {
                mChapterText.setText(R.string.ch_263)
                addButton(getString(R.string.way_263_230), 230)
                addButton(getString(R.string.way_263_13), 13)
            }

            264 -> {
                mChapterText.setText(R.string.ch_264)
                addButton(getString(R.string.way_264_203), 203)
                addButton(getString(R.string.way_264_294), 294)
            }

            265 -> {
                mChapterText.setText(R.string.ch_265)
                addButton(getString(R.string.way_265_263), 263)
                addButton(getString(R.string.way_265_135), 135)
            }

            266 -> {
                mChapterText.setText(R.string.ch_266)
                addButton(getString(R.string.way_266_73), 73)
            }

            267 -> {
                mChapterText.setText(R.string.ch_267)
                addButton(getString(R.string.way_267_119), 119)
            }

            268 -> {
                mChapterText.setText(R.string.ch_268)
                addButton(getString(R.string.way_268_157), 157)
            }

            269 -> {
                mChapterText.setText(R.string.ch_269)
                addButton(getString(R.string.way_269_293), 293)
                addButton(getString(R.string.way_269_341), 341)
            }

            270 -> {
                mChapterText.setText(R.string.ch_270)
                addButton(getString(R.string.way_270_75), 75)
            }

            271 -> {
                mChapterText.setText(R.string.ch_271)
                addButton(getString(R.string.way_271_265), 265)
            }

            272 -> {
                mChapterText.setText(R.string.ch_272)
                addButton(getString(R.string.way_272_280), 280)
            }

            273 -> {
                mChapterText.setText(R.string.ch_273)
                addButton(getString(R.string.way_273_239_1), 239)
                addButton(getString(R.string.way_273_239_2), 239)
                addButton(getString(R.string.way_273_239_3), 239)
            }
            // Add other cases here
            274 -> {
                // Handle case 274
            }

            275 -> {
                mChapterText.setText(R.string.ch_275)
                addButton(getString(R.string.way_275_70), 70)
            }

            276 -> {
                mChapterText.setText(R.string.ch_276)
                addButton(getString(R.string.way_276_95), 95)
            }

            277 -> {
                mChapterText.setText(R.string.ch_277)
                addButton(getString(R.string.way_277_290), 290)
            }

            278 -> {
                mChapterText.setText(R.string.ch_278)
                addButton(getString(R.string.way_278_147), 147)
            }

            279 -> {
                mChapterText.setText(R.string.ch_279)
                addButton(getString(R.string.way_279_326), 326)
            }

            280 -> {
                mChapterText.setText(R.string.ch_280)
                addButton(getString(R.string.way_280_100), 100)
                addButton(getString(R.string.way_280_173), 173)
            }

            281 -> {
                mChapterText.setText(R.string.ch_281)
                addButton(getString(R.string.way_281_211), 211)
                addButton(getString(R.string.way_281_300), 300)
            }

            282 -> {
                mChapterText.setText(R.string.ch_282)
                addButton(getString(R.string.way_282_209_1), 209)
                addButton(getString(R.string.way_282_209_2), 209)
            }

            283 -> {
                mChapterText.setText(R.string.ch_283)
                addButton(getString(R.string.way_283_209_1), 209)
                addButton(getString(R.string.way_283_209_2), 209)
            }

            284 -> {
                mChapterText.setText(R.string.ch_284)
                addButton(getString(R.string.way_284_184), 184)
                addButton(getString(R.string.way_284_286), 286)
            }
            // Add other cases here
            285 -> {
                // Handle case 285
            }

            286 -> {
                mChapterText.setText(R.string.ch_286)
                addButton(getString(R.string.way_286_44), 44)
            }

            287 -> {
                mChapterText.setText(R.string.ch_287)
                addButton(getString(R.string.way_287_260), 260)
            }
            // Add other cases here
            288 -> {
                // Handle case 288
            }

            289 -> {
                mChapterText.setText(R.string.ch_289)
                addButton(getString(R.string.way_289_133), 133)
                addButton(getString(R.string.way_289_343), 343)
            }

            290 -> {
                mChapterText.setText(R.string.ch_290)
                addButton(getString(R.string.way_290_132), 132)
                addButton(getString(R.string.way_290_154), 154)
            }

            291 -> {
                mChapterText.setText(R.string.ch_291)
                addButton(getString(R.string.way_291_350), 350)
            }

            292 -> {
                mChapterText.setText(R.string.ch_292)
                addButton(getString(R.string.way_292_229), 229)
            }

            293 -> {
                mChapterText.setText(R.string.ch_293)
                addButton(getString(R.string.way_293_269), 269)
                addButton(getString(R.string.way_293_295), 295)
            }

            294 -> {
                mChapterText.setText(R.string.ch_294)
                addButton(getString(R.string.way_294_226), 226)
                addButton(getString(R.string.way_294_264), 264)
            }

            295 -> {
                mChapterText.setText(R.string.ch_295)
                addButton(getString(R.string.way_295_244), 244)
                addButton(getString(R.string.way_295_293), 293)
            }

            296 -> {
                mChapterText.setText(R.string.ch_296)
                addButton(getString(R.string.way_296_212), 212)
                addButton(getString(R.string.way_296_226), 226)
                addButton(getString(R.string.way_296_247), 247)
            }

            297 -> {
                mChapterText.setText(R.string.ch_297)
                addButton(getString(R.string.way_297_211), 211)
                addButton(getString(R.string.way_297_227), 227)
            }

            298 -> {
                mChapterText.setText(R.string.ch_298)
                addButton(getString(R.string.way_298_229), 229)
            }

            299 -> {
                mChapterText.setText(R.string.ch_299)
                addButton(getString(R.string.way_299_350), 350)
            }

            300 -> {
                mChapterText.setText(R.string.ch_300)
                addButton(getString(R.string.way_300_217), 217)
                addButton(getString(R.string.way_300_281), 281)
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
