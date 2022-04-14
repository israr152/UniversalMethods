package com.isroid.app.studio.universalmethods

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast

fun Context.showToast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun showLog(message:String,tag:String = "TESTING"){
    if(BuildConfig.DEBUG){
        Log.d(tag,message)
    }
}

fun View.gone(){
    visibility = View.GONE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}