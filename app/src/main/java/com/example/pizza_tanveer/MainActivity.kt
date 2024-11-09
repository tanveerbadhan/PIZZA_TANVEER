package com.example.pizza_tanveer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_tanveer.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var isNonVeg: Boolean = true;
    var isVeg: Boolean = false;
    var noOfSlices: Int = 0;
    var isFullPizza: Boolean = false;
    var isNeedDelivery: Boolean = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rbVeg.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                isVeg = true
            } else {
                isVeg = false
            }
        }

        binding.rbNonVeg.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                isNonVeg = true
            } else {
                isNonVeg = false
            }
        }

        binding.switchFullPizza.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                isFullPizza = true
                binding.noOfSlices.isEnabled = false
                binding.noOfSlices.setText("8")
            } else {
                isFullPizza = false
                binding.noOfSlices.isEnabled = true
                binding.noOfSlices.setText("")
            }
        }

        binding.switchNeedDelivery.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                isNeedDelivery = true
            } else {
                isNeedDelivery = false
            }
        }

        binding.btnSubmit.setOnClickListener {
            if(binding.noOfSlices.text.toString() != "" && binding.noOfSlices.text.toString().toInt() != 0){
                noOfSlices = binding.noOfSlices.text.toString().toInt()
                val submitIntent: Intent = Intent(this@MainActivity, Receipt::class.java)

                submitIntent.putExtra("EXTRA_PIZZA_ORDER", PizzaOrder(isVeg, isNonVeg, noOfSlices, isFullPizza, isNeedDelivery))

                startActivity(submitIntent)
            } else {
                Toast.makeText(this@MainActivity, "Enter No Of Slices", Toast.LENGTH_SHORT).show()
            }
        }
    }

}