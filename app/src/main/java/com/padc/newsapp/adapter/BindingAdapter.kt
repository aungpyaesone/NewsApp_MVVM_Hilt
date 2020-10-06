package com.padc.newsapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padc.newsapp.R
import com.padc.newsapp.data.models.Resource
import com.padc.newsapp.data.vos.Article

@BindingAdapter("listItem")
fun bindNewsItem(recyclerView: RecyclerView,dataList:List<Article>?){
  val adapter = recyclerView.adapter as MyAdapter
  adapter.submitList(dataList)

}

@BindingAdapter("status")
fun bindStatus(progressBar:ProgressBar,apiStatus : Resource.Status){
    when(apiStatus){
        Resource.Status.LOADING ->{progressBar.visibility = View.VISIBLE}
        Resource.Status.ERROR ->{progressBar.visibility = View.GONE}
        Resource.Status.SUCCESS ->{
            progressBar.visibility =View.GONE
        }
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl : String) {
    imgUrl?.let {
       // val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(it)
            .apply(
                RequestOptions().placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(imageView)
    }
}
