package it.dikbudsit.stb.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import it.dikbudsit.stb.myapplication.R
import it.dikbudsit.stb.myapplication.databinding.CardNewsListItemBinding
import it.dikbudsit.stb.myapplication.databinding.FragmentHomeBinding
import it.dikbudsit.stb.myapplication.ui.adapter.GenericListAdapter
import it.dikbudsit.stb.myapplication.ui.adapter.GenericSimpleRecyclerBindingInterface
import it.dikbudsit.stb.myapplication.ui.dataModel.NewsDataModel

class HomeFragment : Fragment(), GenericSimpleRecyclerBindingInterface<NewsDataModel> {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val  simpleGenericAdapter = GenericListAdapter(R.layout.card_news_list_item, this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
            simpleGenericAdapter.submitList(it)
            applay()
        }


        return root
    }

    private fun applay() = binding.recNews.apply {
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = simpleGenericAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun bindData(item: NewsDataModel, view: View) {
        val binding = CardNewsListItemBinding.bind(view)
        binding.newsTitle.text = item.news_title
        binding.newsDesc.text = item.news_desc
        binding.newsDate.text = item.news_time
        binding.imNews.setImageResource(item.news_image)
        binding.newsAuthor.text = item.news_author

//        binding.root.setOnClickListener{
//            when(it){
//                binding.imNews -> {
//                    Toast.makeText(requireContext(), "Clicked Image ${item.news_title}", Toast.LENGTH_SHORT).show()
//
//                }
//            }
//        }
        binding.imNews.setOnClickListener{
            Toast.makeText(requireContext(), "Clicked Image ${item.news_title}", Toast.LENGTH_SHORT).show()

        }

    }

}