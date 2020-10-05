package com.padc.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.newsapp.R
import com.padc.newsapp.adapter.NewsAdapter
import com.padc.newsapp.data.models.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mViewModel: NewsViewModel by viewModels()
    private lateinit var mAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecycler()
        setUpObserver()
    }

    private fun setUpObserver() {
        mViewModel.news.observe(this, Observer {
            when(it.status){
                Resource.Status.SUCCESS ->{
                    progress_circular.visibility = View.GONE
                    if(it.data?.isNotEmpty()!!){
                        val dataList = it.data.toMutableList()
                        mAdapter.bindDataList(dataList)
                    }
                }
                Resource.Status.ERROR ->{
                    progress_circular.visibility = View.GONE
                    Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->{
                    progress_circular.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun setUpRecycler() {
        mAdapter = NewsAdapter()
        rvNews.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvNews.adapter = mAdapter
    }


}