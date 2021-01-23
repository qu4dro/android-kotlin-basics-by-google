package ru.orlovvv.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.orlovvv.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        if (cost == null) {
            binding.tipResultTextView.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptionsRadioGroup.checkedRadioButtonId) {
            R.id.option_15_radio_button -> 0.15
            R.id.option_18_radio_button -> 0.18
            else -> 0.20
        }
        var tip = tipPercentage * cost

        if (binding.roundUpSwitch.isChecked) tip = kotlin.math.ceil(tip)

        val formattedTip = NumberFormat.getCurrencyInstance().format(0.0)
        binding.tipResultTextView.text = getString(R.string.tip_amount, formattedTip)
    }
}