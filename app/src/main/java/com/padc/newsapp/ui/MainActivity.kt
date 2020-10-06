package com.padc.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.newsapp.R
import com.padc.newsapp.adapter.MyAdapter
import com.padc.newsapp.adapter.NewsAdapter
import com.padc.newsapp.data.vos.Article
import com.padc.newsapp.databinding.ActivityMainBinding
import com.padc.newsapp.delegate.newItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),newItemClickListener {

    private val mViewModel: NewsViewModel by viewModels<NewsViewModel>()
   // private lateinit var mAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mViewModel
        binding.rvNews.adapter = MyAdapter()


    }



//    private fun setUpRecycler() {
//        mAdapter = NewsAdapter(this)
//        rvNews.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        rvNews.adapter = mAdapter
//    }

    override fun onTouchItem(article: Article) {

    }


}