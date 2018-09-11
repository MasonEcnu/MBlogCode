package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * 同步的饿汉式
 * 线程安全
 * 缺点：可被反射破坏
 */
class SyncHungrySingleton private constructor() {

  init {
    sum++
  }

  companion object {
    private val instance: SyncHungrySingleton = SyncHungrySingleton()

    @Synchronized
    fun getInstance(): SyncHungrySingleton {
      return instance
    }
  }
}