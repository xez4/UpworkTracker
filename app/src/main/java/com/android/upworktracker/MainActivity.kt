package com.android.upworktracker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.upworktracker.intro.IntroActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFirstRun =
            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).getBoolean("isFirstRun", true)
        if (isFirstRun) {
            startActivity(Intent(this, IntroActivity::class.java))
        }
        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()

        introButton.setOnClickListener { startActivity(Intent(this, IntroActivity::class.java)) }
    }
}


