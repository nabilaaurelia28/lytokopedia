package com.example.lytokopedia.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lytokopedia.data.Product
import com.example.lytokopedia.databinding.ItemHomeProdukTerbaruBinding


@SuppressLint("NotifyDataSetChanged")
class ProdukTerbaruAdapter : RecyclerView.Adapter<ProdukTerbaruAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    inner class ViewHolder(private val itemBinding: ItemHomeProdukTerbaruBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Product, position: Int) {
            itemBinding.apply {
                val harga = item.harga ?: 0
                tvName.text = item.name
                imageView.setImageResource(item.image)
                tvHarga.text = item.harga.toString()
                tvPengiriman.text = item.pengirirman
                tvReting.text = "" + item.rating + " | Terjual" + item.terjual

                if (item.discount != 0) {
                    lyGrosir.isGone
                    lyDiskon.isVisible
                    tvDiscount.text = "${item.discount}%"

                    tvHarga.text = (harga - ((item.discount.toDouble() / 100) * harga)).toString()
                    tvHargaAsli.text = item.harga.toString()
                    tvHargaAsli.toString().toLowerCase()
                }
            }
        }
    }

    fun addItems(items: List<Product>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHomeProdukTerbaruBinding.inflate(
            LayoutInflater.from(parent.context),
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