package com.verifone.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_content.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ContentActivity : AppCompatActivity(), OnMenuItemClickListener {

    val compositeDisposable = CompositeDisposable()
    override fun onMenuItemClicked(menuItem: MenuItem) {
        //Toast.makeText(this, "Kliknieto ${menuItem.title} za ${menuItem.price}", Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, MenuItemFragment.newInstance(menuItem))
            .addToBackStack("")
            .commit()
    }

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

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        val menuService = retrofit.create(MenuService::class.java)

        compositeDisposable.add(menuService.getMenu()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                with(list) {
                    adapter = ListAdapter(it, this@ContentActivity)
                    layoutManager =
                        androidx.recyclerview.widget.GridLayoutManager(this@ContentActivity, 1)
                }
            }, {})
        )
    }
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
