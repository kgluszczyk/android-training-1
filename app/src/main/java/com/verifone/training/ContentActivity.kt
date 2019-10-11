package com.verifone.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val title = intent.getStringExtra(MainActivity.EXTRA_TITLE_KEY)
        if (title != null) {
            title_label.text = title
        }

        intent.getStringExtra(MainActivity.EXTRA_TITLE_KEY)?.let {
            title_label.text = it
        }

        val itemList = listOf(
            MenuItem(
                title = "Piers",
                description = "Fajna piers",
                price = 12.0,
                fullDescription = "Full piers"
            ), MenuItem(
                title = "Piers1",
                description = "Fajna piers2",
                price = 11.0,
                fullDescription = "Full piers2"
            ), MenuItem(
                title = "Piers2",
                description = "Fajna piers2",
                price = 10.0,
                fullDescription = "Full piers2"
            )
        )
        val adapter = ListAdapter(itemList)
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 1)
    }
}
