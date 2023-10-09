package com.juanjacoboflorezmonroy.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val database = Firebase.database

        //Databinding code:
        val dataList = ArrayList<Shoe>()
        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get data from the database and show it in the recyclerview
        database.reference.child("shoe").get().addOnSuccessListener {
            Log.i("ShowStore", "Value was: ${it.value}")
            val dataSnapshot: DataSnapshot = it

            dataList.clear()
            for (snapshot in dataSnapshot.children) {
                val key = snapshot.key.toString()
                val name = snapshot.child("name").value.toString()
                val image = snapshot.child("image").value.toString()
                val price = snapshot.child("price").value.toString()
                val shoe: Shoe = Shoe(name, image, price)
                shoe.key = key
                dataList.add(shoe)
            }
            val adapter = ShoeAdapter(dataList)
            recyclerView.adapter = adapter
        }
    }
}