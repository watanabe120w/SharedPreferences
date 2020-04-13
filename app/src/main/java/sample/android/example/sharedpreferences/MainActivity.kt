package sample.android.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("file_name", Context.MODE_PRIVATE)

        //プリファレンスから保存されている文字列を取得
        //まだ保存されていない場合"未登録"
        val storedText = pref.getString("key","未登録")

        val editText = findViewById<EditText>(R.id.editText)
        editText.setText(storedText)

        val button = findViewById<Button>(R.id.store)

        //ボタンタップ時処理
        button.setOnClickListener {
            //テキストボックスに入力されている文字列
            val inputText = editText.text.toString()
            //プリファレンスに保存
            pref.edit().putString("key",inputText).apply()

        }
    }
}
