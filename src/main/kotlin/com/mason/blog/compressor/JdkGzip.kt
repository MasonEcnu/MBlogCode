package com.mason.blog.compressor

import com.mason.blog.compressor.common.Compressor
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * Created by mwu on 2018/9/12
 * JDK Gzip压缩与解压缩
 */
class JdkGzip : Compressor {
  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val gzip = GZIPOutputStream(outputStream)
    gzip.write(data)
    gzip.finish()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val gzip = GZIPInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
    while ((gzip.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    outputStream.close()
    gzip.close()
    return outputStream.toByteArray()
  }

}