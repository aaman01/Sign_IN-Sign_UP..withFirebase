package com.example.database_with_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {

    companion object{
        const val KEY1="com.example.database_with_ui.name"
        const val KEY2="com.example.database_with_ui.mail"
        const val KEY3="com.example.database_with_ui.uniqueid"
    }
    //firebase class
    lateinit var databasefetch: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val SigninBtn = findViewById<Button>(R.id.signin)

        val userName = findViewById<TextInputEditText>(R.id.uniqueid)


        SigninBtn.setOnClickListener {

            //tak reference till users-> apartment tak poch gaye phir flat dhudehenga

            val usernamestring = userName.text.toString()

            if (!usernamestring.isEmpty()) {

                readData(usernamestring);


            } else {

                Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show()
            }


        }


    }

    private fun readData(usernamestring: String) {

        databasefetch=FirebaseDatabase.getInstance().getReference("Users")
        databasefetch.child(usernamestring).get().addOnSuccessListener {

            // does the child exists in database
            if(it.exists()){
                // if yes then take user to home screen ->use intent and all
                var email=it.child("email").value
                var name =it.child("name").value
                var UserID =it.child("userID").value

              val intent= Intent(this,ValueShow::class.java)
                intent.putExtra(KEY1,name.toString())
                intent.putExtra(KEY2,email.toString())
                intent.putExtra(KEY3,UserID.toString())
                startActivity(intent)





            }else{

                Toast.makeText(this,"User Not Found, Please Sign Up",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Connection Failed",Toast.LENGTH_SHORT).show()
        }

    }
}