package com.mason.blog.compressor.apache

import com.mason.blog.compressor.MAX_BYTEARRAY_SIZE
import com.mason.blog.compressor.common.Compressor
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream
import org.apache.commons.compress.compressors.deflate.DeflateParameters
import java.io.ByteArrayOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.ByteArrayInputStream
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream


/**
 * Created by mwu on 2018/9/12
 * apache Deflate 压缩和解压缩
 */
class Deflate : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val dfParams = DeflateParameters()
    dfParams.compressionLevel = 5
    val dfOutputStream = DeflateCompressorOutputStream(outputStream, dfParams)
    dfOutputStream.write(data)
    dfOutputStream.close()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val dfInputStream = DeflateCompressorInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
    while ((dfInputStream.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    dfInputStream.close()
    outputStream.close()
    return outputStream.toByteArray()
  }
}