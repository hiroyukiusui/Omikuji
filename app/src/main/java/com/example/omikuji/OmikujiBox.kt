package com.example.omikuji

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import kotlinx.android.synthetic.main.omikuji.*
import kotlin.random.Random

class OmikujiBox:Animation.AnimationListener {
    lateinit var omikujiView: ImageView
    var finish = false
    val number:Int //くじ番号
    get(): Int {
        val rnd = java.util.Random()
//        val rnd = (1..20).random()
        return rnd.nextInt(20)
    }

    fun shake() {
        //おみくじの箱を上下させるアニメーション処理
        val translate = TranslateAnimation(0f,0f,0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100
//        omikujiView.startAnimation(translate)

        val rotate = RotateAnimation(0f, 36f, omikujiView.width/2f, omikujiView.height/2f)

        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)
        set.setAnimationListener(this)

        omikujiView.startAnimation(set)

        finish = true
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        omikujiView.setImageResource(R.drawable.omikuji2)

    }

    override fun onAnimationStart(animation: Animation?) {

    }


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