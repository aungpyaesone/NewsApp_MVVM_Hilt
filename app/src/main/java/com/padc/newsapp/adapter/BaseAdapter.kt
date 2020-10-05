package com.padc.newsapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.padc.newsapp.ui.viewholder.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mDataList  = mutableListOf<W>()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mDataList[position])
    }
    override fun getItemCount(): Int {
       return mDataList.size
    }

    fun bindDataList(dataList:List<W>){
        mDataList.clear()
        mDataList.addAll(dataList)
        notifyDataSetChanged()
    }
}