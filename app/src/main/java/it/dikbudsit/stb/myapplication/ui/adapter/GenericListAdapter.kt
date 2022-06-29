package it.dikbudsit.stb.myapplication.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import it.dikbudsit.stb.myapplication.ui.adapter.GenericListAdapter.ListViewHolder


class GenericListAdapter<T: Any>(
    @LayoutRes private val lytId: Int,
    private val bindingInterface: GenericSimpleRecyclerBindingInterface<T>,
): ListAdapter<T, ListViewHolder>(GenericDifferCallback()) {
    class ListViewHolder(
        private val newsItemBinding: View,
    ): RecyclerView.ViewHolder(newsItemBinding){
        fun <T: Any>bind(
            item: T,
            bindingInterface: GenericSimpleRecyclerBindingInterface<T>,
        ) = bindingInterface.bindData(item, newsItemBinding)
    }

    class GenericDifferCallback<T: Any>: DiffUtil.ItemCallback<T>(){
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.toString() == newItem.toString()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val mViewItem = LayoutInflater.from(parent.context)
            .inflate(lytId, parent, false)
        return ListViewHolder(mViewItem)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item,bindingInterface)
    }

}