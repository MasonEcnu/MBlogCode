package com.mason.blog.compressor.apache

import com.mason.blog.compressor.MAX_BYTEARRAY_SIZE
import com.mason.blog.compressor.common.Compressor
import org.apache.commons.compress.utils.IOUtils.toByteArray
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream
import java.io.ByteArrayOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.ByteArrayInputStream
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream


/**
 * Created by mwu on 2018/9/12
 * apache Xz 压缩和解压缩
 */
class Xz : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val xcOutputStream = XZCompressorOutputStream(outputStream)
    xcOutputStream.write(data)
    xcOutputStream.close()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val xcInputStream = XZCompressorInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(MAX_BYTEARRAY_SIZE)
    while ((xcInputStream.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    xcInputStream.close()
    outputStream.close()
    return outputStream.toByteArray()
  }


}