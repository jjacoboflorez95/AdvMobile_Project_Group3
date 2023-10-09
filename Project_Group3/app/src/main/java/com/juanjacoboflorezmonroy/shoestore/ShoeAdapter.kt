package com.juanjacoboflorezmonroy.shoestore

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ShoeAdapter (private val dataList: List<Shoe>) : RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val imgProduct: ImageView
        val txtProductName: TextView
        val txtProductPrice: TextView

        init {
            // Get widget references
            imgProduct = itemView.findViewById(R.id.imgProduct)
            txtProductName = itemView.findViewById(R.id.txtProductName)
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice)
            // We register the listener for the view.
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val currentShoe = dataList[adapterPosition]

            val intent: Intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("image", currentShoe.image)
            intent.putExtra("name", currentShoe.name)
            intent.putExtra("price", currentShoe.price)

            v.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.txtProductName.text = data.name
        holder.txtProductPrice.text = data.price

        if(data.image.indexOf("gs://")>-1) {
            var storage : FirebaseStorage = FirebaseStorage.getInstance()
            var storageReference : StorageReference = storage.getReferenceFromUrl(data.image)

            GlideApp.with(holder.imgProduct).load(storageReference).into(holder.imgProduct)
        } else {
            GlideApp.with(holder.imgProduct).load(data.image).into(holder.imgProduct)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}