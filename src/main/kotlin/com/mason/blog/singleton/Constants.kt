package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/11
 * 公共常量及方法
 */

@Volatile
var sum = 0

const val MAX_THREAD_NUM = 1000000

const val MAX_SLEEP_TIME = 5000L

fun runDemo(clzz: String) {
  val start = System.currentTimeMillis()
  (1..MAX_THREAD_NUM).forEach {
    when (clzz) {
      "LazySingleton" -> {
        Thread { LazySingleton.getInstance() }.start()
      }
      "SyncLazySingleton" -> {
        Thread { SyncLazySingleton.getInstance() }.start()
      }
      "HungrySingleton" -> {
        Thread { HungrySingleton.getInstance() }.start()
      }
      "SyncHungrySingleton" -> {
        Thread { SyncHungrySingleton.getInstance() }.start()
      }
      "DoubleCheckSingleton" -> {
        Thread { DoubleCheckSingleton.getInstance() }.start()
      }
      "EnumSingleton" -> {
        // 枚举类天生线程安全
        Thread { EnumSingleton.INSTANCE }.start()
      }
      "StaticInnerSingleton" -> {
        Thread { StaticInnerSingleton.getInstance() }.start()
      }
      else -> {
        println("Input Error")
        return
      }
    }
  }
  Thread.sleep(MAX_SLEEP_TIME)
  val end = System.currentTimeMillis()
  println("类：$clzz, 计数器总和：$sum, 耗时：${end - start - MAX_SLEEP_TIME}")
}