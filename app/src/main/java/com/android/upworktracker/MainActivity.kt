package com.android.upworktracker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.upworktracker.entity.Request
import com.android.upworktracker.entity.Response
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someResponse()
        initIntroActivity()
    }

    private fun initIntroActivity(){
        Intro()
    }

    private fun serviceRetrofit() = Retrofit.Builder()
        .baseUrl("https://upwork-tracker.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(SomeRequest::class.java)

    private fun someResponse() = serviceRetrofit().post(Request())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ Log.e("response", it.first().toString())}, {})

}

interface SomeRequest {
    @POST("tracker/orders")
    fun post(@Body body: Request): Single<List<Response>>
}



