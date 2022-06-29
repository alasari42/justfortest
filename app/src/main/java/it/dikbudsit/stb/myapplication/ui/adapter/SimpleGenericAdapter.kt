package it.dikbudsit.stb.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class SimpleGenericAdapter<T: Any>(
    private val list: List<T>,
    @LayoutRes private val lytId: Int,
    private val genericSimpleRecyclerBindingInterface: GenericSimpleRecyclerBindingInterface<T>
): RecyclerView.Adapter<SimpleGenericAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mViewItem = LayoutInflater.from(parent.context)
            .inflate(lytId, parent, false)
        return ViewHolder(mViewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, genericSimpleRecyclerBindingInterface)
    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(
        private val view: View
    ): RecyclerView.ViewHolder(view){
        fun <T: Any>bind(
            item: T,
            bindInterface: GenericSimpleRecyclerBindingInterface<T>
        ) = bindInterface.bindData(item, view)
    }




}