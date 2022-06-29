package it.dikbudsit.stb.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import it.dikbudsit.stb.myapplication.R
import it.dikbudsit.stb.myapplication.ui.dataModel.NewsDataModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<List<NewsDataModel>>().apply {
        val data = ArrayList<NewsDataModel>()
        for (i in 0 until  10){
            val dataModel = NewsDataModel(
                news_title = "Judul Berita $i",
                news_desc = "INi DESCripsi  Berita $i",
                news_image = R.drawable.side_nav_bar,
                news_time = "2022-12-$i",
                news_author = "ADmin"
            )
            data.add(dataModel)
        }
        value = data
    }



    val text: LiveData<List<NewsDataModel>> = _text
}