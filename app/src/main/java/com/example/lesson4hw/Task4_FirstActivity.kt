package com.example.lesson4hw

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity

class Task4_FirstActivity : AppCompatActivity() {

    lateinit var et_name: EditText
    lateinit var et_age: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4_first)

        val user = User()
        et_name = findViewById(R.id.et_name)
        et_age = findViewById(R.id.et_age)

        val someActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val member: Member = result.data!!.extras!!.getSerializable("Member") as Member
                et_name.setText(member.name)
                et_age.setText(member.age.toString())
            }
        }

        findViewById<View>(R.id.btn_send).setOnClickListener {
            user.name = et_name.getText().toString()
            user.age = et_age.getText().toString().toInt()

            val intent = Intent(applicationContext, Task4_SecondActivity::class.java)
            val bundle = Bundle()

            bundle.putSerializable("User", user)
            intent.putExtras(bundle)
            someActivityResultLauncher.launch(intent)
            Toast.makeText(applicationContext, user.name, Toast.LENGTH_SHORT).show()
        }
    }
}