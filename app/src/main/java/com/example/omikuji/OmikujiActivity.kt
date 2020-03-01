package com.example.omikuji

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fortune.*
import kotlinx.android.synthetic.main.omikuji.*


class OmikujiActivity : AppCompatActivity() {

    // おみくじ欄の配列
    val omikujiShelf = Array<OmikujiParts>(20)
        {OmikujiParts(R.drawable.result2,R.string.contents1) }

    //おみくじ番号保管用
    var omikujiNumber = -1

    val omikujiBox = OmikujiBox()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omikuji)

        omikujiBox.omikujiView = imageView

        //おみくじ欄の準備

        omikujiShelf[0].drowID = R.drawable.result1
        omikujiShelf[0].fortuneID = R.string.contents2

        omikujiShelf[1].drowID = R.drawable.result3
        omikujiShelf[1].fortuneID = R.string.contents9

        omikujiShelf[2].fortuneID = R.string.contents3
        omikujiShelf[3].fortuneID = R.string.contents4
        omikujiShelf[4].fortuneID = R.string.contents5
        omikujiShelf[5].fortuneID = R.string.contents6




/*
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
*/
    }


    fun onBottonClick(v: View) {
        omikujiBox.shake()

/*
        //おみくじの箱を上下させるアニメーション処理
        val translate = TranslateAnimation(0f,0f,0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100
        imageView.startAnimation(translate)

        val rotate = RotateAnimation(0f, 36f, imageView.width/2f, imageView.height/2f)

        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)

        imageView.startAnimation(set)

//        imageView.setImageResource(R.drawable.result1)
*/
    }

    fun drawResult(){

        //おみくじ番号取得
        omikujiNumber = omikujiBox.number

        //おみくじ欄の配列から、omikujiPartsを取得
        val op = omikujiShelf[omikujiNumber]

        //レイアウトを運勢表示に変更
        setContentView(R.layout.fortune)

        //画像とテキストを変更
        imageView2.setImageResource(op.drowID)
        textView2.setText(op.fortuneID)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN) {
            if (omikujiNumber < 0 && omikujiBox.finish) {
                drawResult()
            }
        }
        return super.onTouchEvent(event)
    }



}
