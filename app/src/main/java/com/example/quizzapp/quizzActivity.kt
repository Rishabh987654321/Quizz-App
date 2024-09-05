package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzapp.databinding.ActivityQuizzBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class quizzActivity : AppCompatActivity() {
    private var count:Int=0
    private var score:Int=0
    private lateinit var binding: ActivityQuizzBinding
    private lateinit var list:ArrayList<QuestionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list=ArrayList<QuestionModel>()
        Firebase.firestore.collection("Quiz")
            .get().addOnSuccessListener {
                doct->
                list.clear()
                for(i in doct.documents){
                    val questionModel=i.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)

                }
                binding.question.setText(list.get(0).question)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }
//        list.add(QuestionModel("Who is the PM of India?","Narendra Modi","Amit Shah","Rahul Gandhi","Arvind Kejriwal","Narendra Modi"))
//        list.add(QuestionModel("Who is the PM of India?","Rahul Gandhi","Amit Shah","Narendra Modi","Arvind Kejriwal","Narendra Modi"))
//        list.add(QuestionModel("Who is the PM of India?","Narendra Modi","Amit Shah","Rahul Gandhi","Arvind Kejriwal","Narendra Modi"))
//        list.add(QuestionModel("Who is the PM of India?","Rahul Gandhi","Amit Shah","Narendra Modi","Arvind Kejriwal","Narendra Modi"))




        binding.option1.setOnClickListener{
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }


    }

    private fun nextData(i: String) {
        if(count<list.size){
            if(list.get(count).correctAnswer.equals(i)){
                score++
            }
        }

        count++
        if (count>=list.size){
            val intent=Intent(this,scoreActivity::class.java)
            intent.putExtra("score",score)
           startActivity(intent)
            finish()
        }else{
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }

    }
}