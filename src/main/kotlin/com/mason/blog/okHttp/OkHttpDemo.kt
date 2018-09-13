package com.mason.blog.okHttp

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

/**
 * Created by mwu on 2018/9/13
 */
fun main(args: Array<String>) {
  val client = OkHttpClient()

  val request = Request.Builder()
      .url("http://172.25.49.71:10188/ban")
      .post(RequestBody.create(MediaType.get("application/json"), "{\"name\": \"Mason\"}"))
      .addHeader("content-type", "application/x-www-form-urlencoded")
      .addHeader("cache-control", "no-cache")
      .addHeader("postman-token", "40dedb38-e243-2d19-ff08-5d8f862f4f91")
      .build()

  val response = client.newCall(request).execute()

  println(String(response.body()?.bytes() ?: byteArrayOf(1)))
}