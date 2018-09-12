package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/10
 * 同步的懒汉式：多线程安全
 * 原理：在生成实例的方法上加@Synchronized注解，相当于Java中的synchronized关键字
 * 缺点：牺牲性能--发现也没牺牲啥性能，难道是我用的方式不对？
 */
class SyncLazySingleton private constructor() {

  init {
    sum++
  }

  companion object {
    private var instance: SyncLazySingleton? = null

    @Synchronized
    fun getInstance(): SyncLazySingleton? {
      if (instance == null) {
        instance = SyncLazySingleton()
      }
      return instance
    }
  }
}