package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.Auth
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

//#482D28
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed(3000){
            if(Firebase.auth.currentUser!=null){
                val intent= Intent(this,quizzActivity::class.java)
                startActivity(intent)
            }else{
                val intent= Intent(this,LoginActivity::class.java)
                intent.putExtra("MODE","SIGNUP")
                startActivity(intent)
            }


        }
    }
}