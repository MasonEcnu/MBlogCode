package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * 同步的懒汉式：多线程安全
 * 原理：在生成实例的方法上加@Synchronized注解，相当于Java中的synchronized关键字
 * 缺点：牺牲性能
 */

class SyncLazySingleton private constructor() {

  companion object {
    private var instance: SyncLazySingleton? = null

    @Synchronized
    fun getInstance(): SyncLazySingleton? {
      if (instance == null) {
        sum++
        instance = SyncLazySingleton()
      }
      return instance
    }
  }

}

fun main(args: Array<String>) {
  val start = System.currentTimeMillis()
  (1..MAX_THREAD_NUM).forEach {
    Thread { SyncLazySingleton.getInstance() }.start()
  }
  Thread.sleep(MAX_SLEEP_TIME)
  val end = System.currentTimeMillis()
  println(sum)
  println("Cost: ${end - start - MAX_SLEEP_TIME}")
}