package com.example.mvvmarc.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.mvvmarc.widgets.ProgressLoader

/**
 * @param BaseActivity is base class of activity which contains some common methods and
 * variables for access entire activities.
 * It is an injected activity.
 */

abstract class BaseActivity <B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity() {
   lateinit var binding: B
   lateinit var progressDialog: ProgressLoader
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
//    window.setFlags(
//      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    progressDialog= ProgressLoader(this)
    binding = bindingFactory(layoutInflater)
    setContentView(binding.root)
    observeViewModel()
  }

  abstract fun observeViewModel()

}