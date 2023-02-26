package com.example.database_with_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ValueShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_show)

        val name= intent.getStringExtra(Signin.KEY1);
        val email=intent.getStringExtra(Signin.KEY2)
        val ID= intent.getStringExtra(Signin.KEY3)

        val nametv=findViewById<TextView>(R.id.nametv)
        val mailtv=findViewById<TextView>(R.id.mail)
        val IDtv=findViewById<TextView>(R.id.ID1)

        nametv.text="Welcome $name"
        mailtv.text="$email"
        IDtv.text="$ID"
    }
}