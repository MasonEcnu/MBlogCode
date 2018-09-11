package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/11
 * 静态内部类单例
 * 优点：延迟加载+线程安全+使用时才创建
 */
class StaticInnerSingleton private constructor() {

  init {
    sum++
  }

  companion object {
    private class SingletonHolder {
      companion object {
        val instance = StaticInnerSingleton()
      }
    }

    fun getInstance(): StaticInnerSingleton {
      return SingletonHolder.instance
    }
  }
}