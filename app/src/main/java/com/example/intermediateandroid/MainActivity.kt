package com.example.intermediateandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.intermediateandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                Toast.makeText(this@MainActivity, "Web Dicoding berhasil dimuat", Toast.LENGTH_LONG).show()
                view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
            }
        }

        binding.webView.webChromeClient = WebChromeClient()

        binding.webView.loadUrl("https://www.dicoding.com")
    }
}