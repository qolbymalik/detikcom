package com.example.detikkotlin.service

import com.example.detikkotlin.pojo.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuilder {

    private val client: OkHttpClient = OkHttpClient.Builder().build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadlines::class.java)
}

interface TopHeadlines {
    @Headers("Authorization: ef06a1d768384d74a12470d070712808")
    @GET("v2/top-headlines?country=id")

    fun feachHeadlines() : Call<ResponseNews>
}