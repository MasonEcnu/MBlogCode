package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/11
 * 静态内部类单例
 * 缺点：可被反射破坏
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