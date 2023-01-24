package com.metacoding.coroutine_ex_1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.metacoding.coroutine_ex_1.ImageLoader.loadImage
import com.metacoding.coroutine_ex_1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //저장 버튼
        binding.run {
            buttonDownload.setOnClickListener {
                Log.d("URL", "hello")

                CoroutineScope(Dispatchers.Main).launch {

                    progressBar.isVisible = true
                    var url = editUrl.text.toString()
                    url = "https://ifh.cc/g/FdXhts.png"
                    //val url = "https://raw.githubusercontent.com/DevTides/JetpackDogsApp/master/app/src/main/res/drawable/dog.png"
                    Log.d("URL", url)

                    //bitmap: 결괏값 저장
                    val bitmap = withContext(Dispatchers.IO) {
                        ImageLoader.loadImage(url)
                    }
                    imagePreview.setImageBitmap(bitmap)
                    progressBar.isVisible = false
                }
            }
        }
    }
}

