package com.example.quizzapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzapp.databinding.ActivityScoreBinding

class scoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score=intent.getIntExtra("score",0)
        if (score == 0) {
            binding.score.text = "Your score is 0"
        }else{
            binding.score.setText("Congrats your score is ${intent.getIntExtra("score",0)}")
        }


    }
}