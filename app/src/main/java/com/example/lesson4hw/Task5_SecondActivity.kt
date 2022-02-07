package com.example.lesson4hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import java.lang.String
import java.lang.StringBuilder

class Task5_SecondActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var age: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5_second)

        name = findViewById(R.id.tv_recieved_name)
        age = findViewById(R.id.tv_recieved_age)

        val bundle = intent.extras
        val userParcelable = bundle!!.getParcelable<Parcelable>("User") as UserParcelable

        if (userParcelable != null) {
            name.setText(userParcelable.name)
        }
        age.setText(String.valueOf(userParcelable.age))
        findViewById<View>(R.id.button).setOnClickListener {
            val memberParcelable = MemberParcelable()
            memberParcelable.name = (
                StringBuilder(userParcelable.name).reverse().toString()
            )
            var newAge = 0
            var tempAge: Int = userParcelable.age
            while (tempAge != 0) {
                newAge *= 10
                newAge += tempAge % 10
                tempAge /= 10
            }
            memberParcelable.age = (newAge)
            val bundle2 = Bundle()
            bundle2.putParcelable("MemberParcelable", memberParcelable)
            val resultIntent = Intent()
            resultIntent.putExtras(bundle2)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}