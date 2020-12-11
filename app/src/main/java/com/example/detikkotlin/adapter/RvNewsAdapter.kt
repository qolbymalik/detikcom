package com.example.detikkotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.example.detikkotlin.DetailActivity
import com.example.detikkotlin.databinding.CdvLayoutHeadlineBinding
import com.example.detikkotlin.pojo.ArticlesItem

class RvNewsAdapter : RecyclerView.Adapter<CdvNewsHeadline> (){

    private val listNews : ArrayList<ArticlesItem> = arrayListOf()

    fun addData(items : List<ArticlesItem>) {
        listNews.clear()
        listNews.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvNewsHeadline {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CdvLayoutHeadlineBinding.inflate(layoutInflater, parent, false)
        return CdvNewsHeadline(binding)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: CdvNewsHeadline, position: Int) {
        val data = listNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.date, data.publishedAt)
            intent.putExtra(DetailActivity.content, data.content)
            intent.putExtra(DetailActivity.image, data.urlToImage)
            it.context.startActivity(intent)
        }
    }
}

class CdvNewsHeadline(private val binding: CdvLayoutHeadlineBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ArticlesItem) {
        with(binding){
            txtTitle.text = item.title
            txtSubtitle.text = item.description
            imageView.load(item.urlToImage){
                scale(Scale.FILL)
            }
        }
    }
}
