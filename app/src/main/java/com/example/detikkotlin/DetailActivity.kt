package com.example.detikkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.example.detikkotlin.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    companion object {
        const val date = "date"
        const val content = "content"
        const val image = "image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val date = intent.getStringExtra(date)
        val contents = intent.getStringExtra(content)
        val imageDetail = intent.getStringExtra(image)

        txt_date.text = date
        txt_content.text = contents
        img_toolbar.load(imageDetail)

    }
}