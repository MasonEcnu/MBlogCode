package com.mason.blog.singleton

/**
 * Created by mwu on 2018/9/11
 */

@Volatile
var sum = 0

const val MAX_THREAD_NUM = 1000000

const val MAX_SLEEP_TIME = 10000L