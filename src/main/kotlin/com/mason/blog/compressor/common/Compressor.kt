package com.mason.blog.compressor.common

import java.io.IOException

/**
 * Created by mwu on 2018/9/12
 * 压缩与解压缩接口
 */
interface Compressor {

  // 压缩
  @Throws(IOException::class)
  fun compress(data: ByteArray): ByteArray

  // 解压缩
  @Throws(IOException::class)
  fun uncompress(data: ByteArray): ByteArray
}