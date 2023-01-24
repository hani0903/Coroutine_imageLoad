package com.metacoding.coroutine_ex_1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL

lateinit var stream2 : InputStream

object ImageLoader {

    //top-level 함수로 작성
    suspend fun loadImage(imageUrl: String): Bitmap? {

        val bmp: Bitmap? = null

        try {

            val url = URL(imageUrl)
            val stream = url.openStream()
            stream2 = stream

            return BitmapFactory.decodeStream(stream)

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmp
    }
}