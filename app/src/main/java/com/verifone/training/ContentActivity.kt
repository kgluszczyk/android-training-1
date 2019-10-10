package com.verifone.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val title = intent.getStringExtra(MainActivity.EXTRA_TITLE_KEY)
        if(title != null) {
            title_label.text = title
        }

        intent.getStringExtra(MainActivity.EXTRA_TITLE_KEY)?.let {
            title_label.text = it
        }
    }
}
