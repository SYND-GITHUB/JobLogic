package com.synd.joblogic.view.productitem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synd.joblogic.databinding.RowProductItemBinding
import com.synd.joblogic.model.api.BaseItem


class ItemListAdapter(private val context: Context, private var dataList: MutableList<BaseItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(RowProductItemBinding.inflate(layoutInflater, parent, false))
    }

    fun updateNewData(newList: MutableList<BaseItem>) {
        dataList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewHolder).bind(dataList[position])
    }

    /** View Holders */
    inner class MyViewHolder(private val binding: RowProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BaseItem) {
            binding.item = item
        }
    }


}