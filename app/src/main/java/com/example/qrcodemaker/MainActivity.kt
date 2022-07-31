package com.example.qrcodemaker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image = findViewById<ImageView>(R.id.imageview)
        var button = findViewById<Button>(R.id.button)
        var text = findViewById<EditText>(R.id.editText)
        button.setOnClickListener{
            Picasso.with(this).load("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${text.text}").into(image)
            hideKeyboardFrom(this,it)
        }

    }
    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}