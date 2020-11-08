package com.cis2818.project2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_temperatures.*
import java.math.RoundingMode

class Temperatures : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_temperatures, container, false)

        val fahrenheitButton = view.findViewById<Button>(R.id.convertFahrenheitButton)
        val celciusButton = view.findViewById<Button>(R.id.convertCelsiusButton)

        fahrenheitButton.setOnClickListener {
            if (numberToConvert.text.isNotEmpty()) {
                val num = convertToFahrenheit()
                resultNum = num.toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
                resultTextView.text = "$resultNum degrees/f"
            }
        }

        celciusButton.setOnClickListener {
            if (numberToConvert.text.isNotEmpty()) {
                val num = convertToCelcius()

                resultNum = num.toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
                resultTextView.text = "$resultNum degrees/c"
            }

        }
        //inflate view
        return view
    }

    var resultNum : String? = null

    fun convertToFahrenheit(): Double {
        var temperature = numberToConvert.text.toString().toDouble()

        return (temperature * 1.8) + 32
    }

    fun convertToCelcius(): Double {
        var temperature = numberToConvert.text.toString().toDouble()

        return (temperature - 32) / 1.8
    }

}

