package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * double-check的懒汉式
 * 多线程安全
 * 缺点：复杂，并且可被反射破坏
 */
class DoubleCheckSingleton {

  init {
    sum++
  }

  companion object {
    @Volatile
    private var instance: DoubleCheckSingleton? = null

    fun getInstance(): DoubleCheckSingleton? {
      if (instance == null) {
        synchronized(this) {
          if (instance == null) {
            instance = DoubleCheckSingleton()
          }
        }
      }
      return instance
    }
  }
}