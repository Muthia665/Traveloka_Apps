package com.muzaaz.travelokaapps.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.muzaaz.travelokaapps.R

class SplashScreenActivity : AppCompatActivity() {

    private val splashTime = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            Intent(applicationContext, OnBoardingActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }, splashTime.toLong())
    }
}
