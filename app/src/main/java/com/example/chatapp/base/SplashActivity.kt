package com.example.chatapp.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.chatapp.R
import com.example.chatapp.userAction.UserActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(
            {
startActivity(Intent(this,UserActivity::class.java))
                finishAffinity()
            },4000
        )

    }
}