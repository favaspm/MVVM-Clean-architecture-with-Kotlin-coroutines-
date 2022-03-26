package com.example.mvvmarc.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.example.mvvmarc.R

class ProgressLoader(var context: Context) {
    private var dialog: Dialog = Dialog(context)

    init {
        val v=LayoutInflater.from(context).inflate(R.layout.layout_progress_bar,null,false)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.window?.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(v)
    }
    fun show(){
        dialog.show()
    }
    fun dismiss(){
        dialog.hide()
    }
}