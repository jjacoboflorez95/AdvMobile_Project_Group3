package com.juanjacoboflorezmonroy.shoestore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get the information from the intent

        // We get the information from the intent
        val intent = intent
        val productImage: String = intent.getStringExtra("image") ?: ""
        val productName: String = intent.getStringExtra("name") ?: ""
        val productPrice: String = intent.getStringExtra("price") ?: ""

        Log.i("Intent information", "productImage: " + productImage)
        Log.i("Intent information", "productName: " + productName)
        Log.i("Intent information", "productPrice: " + productPrice)
    }
}