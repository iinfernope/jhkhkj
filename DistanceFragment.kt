package com.cis2818.project2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_distance.*
import java.math.RoundingMode

class DistanceFragment : Fragment() {

    var resultNum2 : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_distance, container, false)

        val convertMilesButton : Button = view.findViewById<Button>(R.id.convertMilesButton)
        val convertKilometersButton : Button = view.findViewById<Button>(R.id.convertKilometersButton)



        convertMilesButton.setOnClickListener {
            if (numberToConvertDistance.text.isNotEmpty()) {
                val num = convertToMiles()

                resultNum2 = num.toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
                resultDistance.text = "$resultNum2 miles"
            }
        }

        convertKilometersButton.setOnClickListener {
            if (numberToConvertDistance.text.isNotEmpty()) {
                val num = convertToKilometers()

                resultNum2 = num.toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
                resultDistance.text = "$resultNum2 kilometers"
            }
        }
        return view
    }


    private fun convertToMiles() : Double {
        val distance = numberToConvertDistance.text.toString().toDouble()
        return distance / 1.609
    }

    private fun convertToKilometers() : Double {
        val distance = numberToConvertDistance.text.toString().toDouble()
        return distance * 1.609
    }

}