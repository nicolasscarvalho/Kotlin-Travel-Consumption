package com.nicolascarvalho.curso_android_iosi.kotlin_travel_consumption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nicolascarvalho.curso_android_iosi.kotlin_travel_consumption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textSendButton.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id  == R.id.text_sendButton) {
            calculate()
        }
    }

    private fun isNull(): Boolean {
        return(
            binding.editDistance.text.toString() == "" ||
            binding.editPrice.text.toString() == "" ||
            binding.editAutonomy.text.toString() == ""
        )
    }

    private fun calculate() {

        if (isNull()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
        else if (binding.editAutonomy.text.toString().toFloat() == 0f) {
            Toast.makeText(this, "Quilômetro por litro não pode ser igual a zero", Toast.LENGTH_SHORT).show()
        }
        else {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (price * distance) / autonomy
            binding.textResult.text = "R$ ${"%.2f".format(totalValue)}"
        }

    }
}