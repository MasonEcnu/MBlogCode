package com.mason.blog.singleton

import org.junit.Test

/**
 * Created by mwu on 2018/9/11
 * 测试类
 */
class TestSingleton {
  @Test
  fun test() {
    // 单线程懒汉式
    runDemo(LazySingleton::class.simpleName ?: "Error")
    // 同步懒汉式
    runDemo(SyncLazySingleton::class.simpleName ?: "Error")
    // 单线程饿汉式
    runDemo(HungrySingleton::class.simpleName ?: "Error")
    // 同步饿汉式
    runDemo(SyncHungrySingleton::class.simpleName ?: "Error")
    // double-check懒汉式
    runDemo(DoubleCheckSingleton::class.simpleName ?: "Error")
    // 静态内部类
    runDemo(StaticInnerSingleton::class.simpleName ?: "Error")
    // 枚举
    runDemo(EnumSingleton::class.simpleName ?: "Error")
  }
}