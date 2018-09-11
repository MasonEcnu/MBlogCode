package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * 饿汉式：类初始化时创建
 * 优点：简单
 * 缺点：可被反射破坏
 */
class HungrySingleton private constructor() {

  init {
    sum++
  }

  companion object {
    private var instance: HungrySingleton = HungrySingleton()

    fun getInstance(): HungrySingleton {
      return instance
    }
  }
}