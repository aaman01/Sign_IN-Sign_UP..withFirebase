package com.example.database_with_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var DataBase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SignUp = findViewById<Button>(R.id.signup)
        val etname = findViewById<TextInputEditText>(R.id.etname)
        val etemail = findViewById<TextInputEditText>(R.id.etmail)
        val etpassword = findViewById<TextInputEditText>(R.id.etpassword)
        val etuserID = findViewById<TextInputEditText>(R.id.etuser)
        val nextpage=findViewById<TextView>(R.id.register)


        SignUp.setOnClickListener {
            val Name = etname.text.toString()
            val mail = etemail.text.toString()
            val ID = etuserID.text.toString()
            val password = etpassword.text.toString()

            val User = User(Name, mail, ID, password)
            DataBase = FirebaseDatabase.getInstance().getReference("Users")
           DataBase.child(ID).setValue(User).addOnSuccessListener {
               Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
           }.addOnFailureListener {
               Toast.makeText(this,"Registeration Failed",Toast.LENGTH_SHORT).show()
           }
        }

        nextpage.setOnClickListener{
            val intent1=Intent(this,Signin::class.java)
            startActivity(intent1)
            finish()
        }



    }
}