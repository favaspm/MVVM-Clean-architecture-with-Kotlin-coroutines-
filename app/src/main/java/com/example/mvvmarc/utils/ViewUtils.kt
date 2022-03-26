package com.example.mvvmarc.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.mvvmarc.R
import com.example.mvvmarc.utils.GeneralUtils.toDefault
import com.google.android.material.snackbar.Snackbar

/**
 * This class use for view related common methods as well as which is an static class.
 */
object ViewUtils {

    fun Context.showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun View.showErrorSnackBar( message: String?, action: String? = null
                     ) {
        val snackBar = Snackbar.make(this, message.toDefault(), Snackbar.LENGTH_SHORT)
            .setBackgroundTint(ContextCompat.getColor(this.context, R.color.error_back_color))
            .setTextColor(Color.WHITE)
        snackBar.show()
    }
}