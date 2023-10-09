package com.juanjacoboflorezmonroy.shoestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.UUID

//Firebase console:
//https://console.firebase.google.com/u/0/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Insert a new shoes (Commented out and run the code to insert the data)
        //createInitialDataDb()

        Handler().postDelayed({
            val i = Intent(this, ProductActivity::class.java)
            startActivity(i)
            //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 2500)
    }

    fun createInitialDataDb() {
        // Insert a new shoes
        var shoe: Shoe = Shoe("Nike shoe","gs://shoestore-4394f.appspot.com/nike_shoe.jpg","275")
        val database = Firebase.database
        database.reference.child("shoe").child(
            UUID.randomUUID().toString()
        ).setValue(shoe)

        shoe = Shoe("Adidas shoe","gs://shoestore-4394f.appspot.com/adidas_shoe.jpg","189")
        database.reference.child("shoe").child(
            UUID.randomUUID().toString()
        ).setValue(shoe)

        shoe = Shoe("Converse shoe","gs://shoestore-4394f.appspot.com/converse_shoe.webp","150")
        database.reference.child("shoe").child(
            UUID.randomUUID().toString()
        ).setValue(shoe)

    }
}