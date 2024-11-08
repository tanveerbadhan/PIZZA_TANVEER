package com.example.pizza_tanveer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_tanveer.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val submitIntent: Intent = Intent(this@MainActivity, Receipt::class.java)
            startActivity(submitIntent)
        }
    }

}