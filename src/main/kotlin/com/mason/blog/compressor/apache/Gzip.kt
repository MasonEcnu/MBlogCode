package com.mason.blog.compressor.apache

import com.mason.blog.compressor.MAX_BYTEARRAY_SIZE
import com.mason.blog.compressor.common.Compressor
import org.apache.commons.compress.utils.IOUtils.toByteArray
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream
import java.io.ByteArrayOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.ByteArrayInputStream
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream


/**
 * Created by mwu on 2018/9/12
 * apache Gzip 压缩和解压缩
 */
class Gzip : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val gcOutputStream = GzipCompressorOutputStream(outputStream)
    gcOutputStream.write(data)
    gcOutputStream.close()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val gcInputStream = GzipCompressorInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
    while ((gcInputStream.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    gcInputStream.close()
    return outputStream.toByteArray()
  }
}