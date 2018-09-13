package com.mason.blog.compressor

import com.mason.blog.compressor.common.Compressor
import org.xerial.snappy.Snappy

/**
 * Created by mwu on 2018/9/12
 * Snappy 压缩和解压缩
 */
class Snappy : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    return Snappy.compress(data)
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    return Snappy.uncompress(data)
  }
}