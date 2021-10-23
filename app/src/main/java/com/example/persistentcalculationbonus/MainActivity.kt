package com.example.persistentcalculationbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var button:Button
    lateinit var tv:TextView

    var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        button = findViewById(R.id.button)
        tv = findViewById(R.id.tv)

        button.setOnClickListener { // Hide Keyboard
            val imm = ContextCompat.getSystemService(this, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
            multiply() }

    }

    fun multiply(){
        result = et1.text.toString().toDouble() * et2.text.toString().toFloat()
        tv.text = result.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("result", result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result= savedInstanceState.getDouble("result", 0.0)
        tv.text = result.toString()
    }

}