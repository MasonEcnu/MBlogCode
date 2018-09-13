package com.mason.blog.compressor

import com.mason.blog.compressor.common.Compressor
import org.tukaani.xz.LZMA2Options
import org.tukaani.xz.XZOutputStream
import java.io.ByteArrayOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.ByteArrayInputStream
import org.tukaani.xz.XZInputStream


/**
 * Created by mwu on 2018/9/12
 * Xz 压缩和解压缩
 */
class Xz : Compressor {

  // 压缩
  override fun compress(data: ByteArray): ByteArray {
    val options = LZMA2Options()
    val outputStream = ByteArrayOutputStream(MAX_BYTEARRAY_SIZE)
    val xzOutput = XZOutputStream(outputStream, options)
    xzOutput.write(data)
    xzOutput.finish()
    xzOutput.close()
    outputStream.close()
    return outputStream.toByteArray()
  }

  // 解压缩
  override fun uncompress(data: ByteArray): ByteArray {
    val outputStream = ByteArrayOutputStream(8192)
    val xzInput = XZInputStream(ByteArrayInputStream(data))
    var count = 0
    val buffer = ByteArray(8192)
    while ((xzInput.read(buffer).also { count = it }) != -1) {
      outputStream.write(buffer, 0, count)
    }
    xzInput.close()
    outputStream.close()
    return outputStream.toByteArray()
  }
}