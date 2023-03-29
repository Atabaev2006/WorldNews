//package com.example.worldnews.ui.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.StaggeredGridLayoutManager
//import com.example.worldnews.R
//import com.example.worldnews.data.local.NewsRepository
//import com.example.worldnews.data.remote.ApiClient
//import com.example.worldnews.databinding.FragmentSaveBinding
//import com.example.worldnews.model.news.Article
//import com.example.worldnews.utils.viewBinding
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//
//class SaveFragment : Fragment(R.layout.fragment_save) {
//    lateinit var adapter: SaveFragment
//    lateinit var saveNews:ArrayList<Article>
//    lateinit var repository: NewsRepository
//    lateinit var list: ArrayList<Article>
//   private val binding by viewBinding { FragmentSaveBinding.bind(it) }
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_save,container,false)
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupUi(view)
//        loadNews()
//
//    }
//
//
//
//    private fun setupUi(view: View) {
//    binding.apply {
//     rvSave.setOnClickListener {
//         repository = NewsRepository(requireActivity().application)
//         saveNews = repository.getAllNews() as ArrayList
//         for (i in saveNews.size - 1 downTo 0){
//             saveNews[i].url
//         }
//         val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//         adapter = SaveFragment()
//         rvSave.adapter = adapter
//         rvSave.layoutManager = manager
//         adapter.detail = {
//             val bundle = Bundle()
//             bundle.putString("main","save")
//         }
//     }
//        private fun loadNews(url: String) {
//            ApiClient.apiService.getNews(url).enqueue(object : Callback<Article> {
//                override fun onResponse(call: Call<Article>, response: Response<Article>) {
//                    if (response.isSuccessful){
//                        adapter.(response.body()!!)
//                    }
//                }
//
//                override fun onFailure(call: Call<Article>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            }
//
//
//        }
//
//}
//    }
//
//}