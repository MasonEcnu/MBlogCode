package com.mason.blog.compressor

import com.mason.blog.compressor.common.Compressor
import java.io.ByteArrayOutputStream
import java.util.zip.Deflater
import java.util.zip.Inflater

/**
 * Created by mwu on 2018/9/12
 * JDK Deflate压缩与解压缩
 */
class JdkDeflate : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val deflater = Deflater()
    deflater.setLevel(1)
    deflater.setInput(data)
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    // 这句不明所以啊
    deflater.finish()
    while (!deflater.finished()) {
      val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
      val count = deflater.deflate(buffer)
      outputStream.write(buffer, 0, count)
    }
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val inflater = Inflater()
    inflater.setInput(data)
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    while (!inflater.finished()) {
      val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
      val count = inflater.inflate(buffer)
      outputStream.write(buffer, 0, count)
    }
    outputStream.close()
    return outputStream.toByteArray()
  }


}