package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * 懒汉式：在需要使用到类的实例时，才去创建
 * 优点：简单
 * 缺点：非线程安全，多线程下可能会创建多个实例
 */
class LazySingleton private constructor() {

  init {
    sum++
  }

  companion object {
    private var instance: LazySingleton? = null

    fun getInstance(): LazySingleton? {
      // 多线程下，假如此时有多个线程都判断instance == null为true
      // 则都会进入到if代码块中，从而创建多个实例
      if (instance == null) {
        instance = LazySingleton()
      }
      return instance
    }
  }
}