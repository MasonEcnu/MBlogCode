package com.mason.blog.compressor.apache

import com.mason.blog.compressor.MAX_BYTEARRAY_SIZE
import com.mason.blog.compressor.common.Compressor
import java.io.ByteArrayOutputStream
import java.io.ByteArrayInputStream
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream


/**
 * Created by mwu on 2018/9/12
 * Bzip2 压缩和解压缩
 */
class Bzip2 : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val bzipOutput = BZip2CompressorOutputStream(outputStream)
    bzipOutput.write(data)
    bzipOutput.close()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val bzipInput = BZip2CompressorInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(8192)
    while ((bzipInput.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    bzipInput.close()
    outputStream.close()
    return outputStream.toByteArray()
  }
}