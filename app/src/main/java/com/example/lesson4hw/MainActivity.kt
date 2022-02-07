package com.example.lesson4hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun task4(view: View?) {
        val intent = Intent(applicationContext, Task4_FirstActivity::class.java)
        startActivity(intent)
    }

    fun task5(view: View?) {
        val intent = Intent(applicationContext, Task5_FirstActivity::class.java)
        startActivity(intent)
    }
}