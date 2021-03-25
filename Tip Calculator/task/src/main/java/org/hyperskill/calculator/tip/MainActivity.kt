package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.edit_text)
        var slider = findViewById<Slider>(R.id.slider)
        var textView = findViewById<TextView>(R.id.text_view)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString() != "") {
                    textView.text = changeText(s.toString(), slider.value.toInt())
                } else {
                    textView.text = ""
                }
            }
        })

        slider.addOnChangeListener(object : Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                if (editText.text.toString() != "") {
                    textView.text = changeText(editText.text.toString(), value.toInt())
                }
            }
        })
    }


    fun changeText (valueOfSum: String, valueOfPercentage: Int): String {
        var amount: Float = valueOfSum.toFloat() * valueOfPercentage / 100
        return "Tip amount: %.2f".format(amount)
    }
}