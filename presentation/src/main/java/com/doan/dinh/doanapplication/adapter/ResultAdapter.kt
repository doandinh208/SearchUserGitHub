package com.doan.dinh.doanapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doan.dinh.doanapplication.databinding.ItemResultLayoutBinding
import com.doan.dinh.domain.model.SearchModel

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    var data: List<SearchModel.ItemModel> = arrayListOf()
    private var listener: ((SearchModel.ItemModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
                ItemResultLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(data[position])

    override fun getItemCount() = data.size

    fun setItemClick(listener: (SearchModel.ItemModel) -> Unit) {
        this.listener = listener
    }

    inner class ViewHolder(private val binding: ItemResultLayoutBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SearchModel.ItemModel) {
            itemView.apply {
                binding.tvNameSearch.text = item.login
                if (!item.avatarUrl.isNullOrEmpty()) {
                    Glide.with(context).load(item.avatarUrl).into(binding.ivAvatar)
                }
                setOnClickListener { listener?.invoke(item) }
            }
        }
    }

    fun setItems(items: List<SearchModel.ItemModel>) {
        this.data = items
        notifyDataSetChanged()
    }
}
