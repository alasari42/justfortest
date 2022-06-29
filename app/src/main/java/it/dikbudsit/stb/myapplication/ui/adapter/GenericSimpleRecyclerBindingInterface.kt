package it.dikbudsit.stb.myapplication.ui.adapter

import android.view.View

interface GenericSimpleRecyclerBindingInterface<T: Any>{
    fun bindData(item: T, view: View)
}
