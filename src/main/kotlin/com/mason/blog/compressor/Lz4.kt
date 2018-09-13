package com.mason.blog.compressor

import com.mason.blog.compressor.common.Compressor
import net.jpountz.lz4.LZ4BlockInputStream
import net.jpountz.lz4.LZ4BlockOutputStream
import net.jpountz.lz4.LZ4Factory
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Created by mwu on 2018/9/12
 * Lz4压缩与解压缩数据
 */
class Lz4 : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val factory = LZ4Factory.fastestInstance()
    val byteOutput = ByteArrayOutputStream()
    val compressor = factory.fastCompressor()
    val compressedOutput = LZ4BlockOutputStream(byteOutput, MAX_BYTEARRAY_SIZE, compressor)
    compressedOutput.write(data)
    compressedOutput.close()
    return byteOutput.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val factory = LZ4Factory.fastestInstance()
    val byteOutput = ByteArrayOutputStream()
    val uncompress = factory.fastDecompressor()
    val compressedInput = LZ4BlockInputStream(ByteArrayInputStream(data), uncompress)
    var count = 0
    val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
    while (compressedInput.read(data).also { count = it } != -1) {
      byteOutput.write(buffer, 0, count)
    }
    compressedInput.close()
    return byteOutput.toByteArray()
  }
}