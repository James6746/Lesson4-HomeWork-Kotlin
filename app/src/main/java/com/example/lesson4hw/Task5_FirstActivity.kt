package com.example.lesson4hw

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import java.lang.String

class Task5_FirstActivity : AppCompatActivity() {
    lateinit var et_name: EditText
    lateinit var et_age: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5_first)

        val userParcelable = UserParcelable()
        et_name = findViewById(R.id.et_name)
        et_age = findViewById(R.id.et_age)

        val someActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                assert(result.data != null)
                val memberParcelable: MemberParcelable =
                    result.data!!.extras!!.getParcelable<Parcelable>("MemberParcelable") as MemberParcelable
                et_name.setText(memberParcelable.name)
                et_age.setText(String.valueOf(memberParcelable.age))
            }
        }
        findViewById<View>(R.id.btn_send).setOnClickListener {
            userParcelable.name = (et_name.getText().toString())
            userParcelable.age = (et_age.getText().toString().toInt())
            val intent = Intent(applicationContext, Task5_SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("User", userParcelable)
            intent.putExtras(bundle)
            someActivityResultLauncher.launch(intent)
            Toast.makeText(applicationContext, userParcelable.name, Toast.LENGTH_SHORT).show()
        }
    }
}