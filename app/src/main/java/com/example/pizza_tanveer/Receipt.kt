package com.example.pizza_tanveer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_tanveer.databinding.ActivityReceiptBinding

class Receipt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityReceiptBinding
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent != null){
            val pizzaOrder: PizzaOrder = intent.getSerializableExtra("EXTRA_PIZZA_ORDER") as PizzaOrder
            binding.textReceipt.setText(pizzaOrder.toString())
        }
    }
}