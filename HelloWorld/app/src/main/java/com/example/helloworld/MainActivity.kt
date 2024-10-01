package com.example.helloworld

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // XMLレイアウトを使ってビューをセット
        setContentView(R.layout.activity_main)

        // ComposeViewの設定
        val composeView = findViewById<ComposeView>(R.id.compose_view)

        // ボタンとカスタムビューの設定
        val myButton = findViewById<Button>(R.id.paint)
        val customView = findViewById<CustomView>(R.id.custom_view)

        val backButton: Button = findViewById(R.id.Back)
        backButton.setOnClickListener {
            // SecondActivityに遷移
            finish()
        } // ここで閉じる

        myButton.setOnClickListener {
            customView.visibility = View.VISIBLE // カスタムビューを表示
            customView.invalidate() // 再描画を要求
        }
    }

    fun Back(view:View){
        Toast.makeText(this, "ボタンがクリックされました！", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun Paint(view:View){
        Toast.makeText(this, "色ヌルボタンがクリックされました！", Toast.LENGTH_SHORT).show()
    }

    fun onClickMyButton(view: View) {
        Toast.makeText(this, "はずれ", Toast.LENGTH_LONG).show()
    }
}

// CustomViewの定義 (従来のビュー)
class CustomView(context: Context?, attrs: AttributeSet? = null) : View(context, attrs) {
    private var paint: Paint? = null

    init {
        init()
    }

    private fun init() {
        paint = Paint().apply {
            color = Color.RED // 四角形の塗りつぶし色
            style = Paint.Style.FILL // 塗りつぶしを有効化
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // カスタムビューの中央に赤い正方形を描画
        val size = 300f // 正方形のサイズ
        val left = (width / 2 - size / 2)
        val top = (height / 2 - size / 2)
        canvas.drawRect(left, top, left + size, top + size, paint!!) // 四角形を描画
    }
}
