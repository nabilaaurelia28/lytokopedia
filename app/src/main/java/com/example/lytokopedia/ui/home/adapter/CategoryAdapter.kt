package com.example.lytokopedia.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lytokopedia.data.Category
import com.example.lytokopedia.databinding.ItemHomeCategoryBinding

@SuppressLint("NotifyDataSetChanged")
class CategoryAdapter:RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    private var data = ArrayList<Category>()
    inner class ViewHolder(private val itemBining: ItemHomeCategoryBinding):RecyclerView.ViewHolder(itemBining.root){

        fun bind(item:Category, position: Int){
            itemBining.apply {
                tvName.text = item.name
                imageView.setImageResource(item.image)
            }
        }

    }

    fun addItem(items:List<Category>){
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}