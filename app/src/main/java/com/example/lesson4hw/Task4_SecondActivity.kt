package com.example.lesson4hw

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String


class Task4_SecondActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var age: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4_second)


        name = findViewById(R.id.tv_recieved_name)
        age = findViewById(R.id.tv_recieved_age)
        val bundle: Bundle = intent.extras!!
        val user = bundle.getSerializable("User") as User

        name.setText(user.name)
        age.setText(String.valueOf(user.age))

        findViewById<View>(R.id.button).setOnClickListener(View.OnClickListener {
            val member = Member()
            member.name = StringBuilder(user.name!!).reverse().toString()
            var newAge = 0
            var tempAge: Int = user.age

            while (tempAge != 0) {
                newAge *= 10
                newAge += tempAge % 10
                tempAge /= 10
            }
            member.age = newAge
            val bundle2 = Bundle()
            bundle2.putSerializable("Member", member)
            val resultIntent = Intent()
            resultIntent.putExtras(bundle2)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        })
    }
}
