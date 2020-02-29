package com.example.omikuji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random


class OmikujiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //文字を入力する
        val rnd = (1..20).random()
        val number = rnd

        //おみくじ欄の準備
        val omikujiShelf = Array<String>(20,{"吉"})
        omikujiShelf[0] = "大吉"
        omikujiShelf[3] = "笑吉"
        omikujiShelf[19] = "凶"
        omikujiShelf[18] = "末吉"


        //おみくじ欄から取得
        val str = omikujiShelf[number]
        hello_View.text = "$str ${number}"
    }
}
