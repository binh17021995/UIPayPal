package com.monstarlab.designui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.monstarlab.designui.model.User

class PayScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay_screen)
        val imgAvatar : ImageView = findViewById(R.id.img_user_pay)
        val imgBackHome : ImageView = findViewById(R.id.img_back_home)

        val intent = intent
        val data : User = intent.getSerializableExtra("user") as User
        imgAvatar.setImageResource(data.avatar)

        imgBackHome.setOnClickListener {
            onBackPress()
        }


    }

    private fun onBackPress() {
            val intentBack : Intent = Intent(this, HomeScreen::class.java)
            startActivity(intentBack)

    }
}