package com.example.criptos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.criptos.data.models.CoinOrderDTO.Ask
import com.example.criptos.databinding.ItemAskBinding


class AsksAdapter(itemClick: (Ask) -> Unit) :
    ListAdapter<Ask, AsksAdapter.ViewHolder>(comparator) {
    object comparator : DiffUtil.ItemCallback<Ask>() {
        override fun areItemsTheSame(oldItem: Ask, newItem: Ask): Boolean {
            return oldItem.book == newItem.book
        }

        override fun areContentsTheSame(oldItem: Ask, newItem: Ask): Boolean {
            return oldItem == newItem
        }

    }

    //Todo Imagenes de CriptoMonedas
    inner class ViewHolder(private val binding: ItemAskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ask: Ask) = with(binding) {
            tvAmountA.text = "Amount: " + ask.amount
            // tvBookA.text = ask.book
            tvPriceA.text = "Price: " + ask.price
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =
            LayoutInflater.from(viewGroup.context)

        val binding = ItemAskBinding.inflate(layoutInflater, viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsksAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
