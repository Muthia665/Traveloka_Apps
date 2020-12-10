package com.muzaaz.travelokaapps.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muzaaz.travelokaapps.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txt_belum_punya_akun.setOnClickListener {
            Intent(applicationContext, RegisterActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        btn_login.setOnClickListener {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}
