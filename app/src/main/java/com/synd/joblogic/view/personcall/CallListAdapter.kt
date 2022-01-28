package com.synd.joblogic.view.personcall

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synd.joblogic.databinding.RowPersonBinding
import com.synd.joblogic.model.api.Person


class CallListAdapter(private val context: Context, private var dataList: MutableList<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(RowPersonBinding.inflate(layoutInflater, parent, false))
    }

    fun updateNewData(newList: MutableList<Person>) {
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
    inner class MyViewHolder(private val binding: RowPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person) {
            binding.person = item
        }
    }


}