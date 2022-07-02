package com.isroid.app.studio.universalmethods

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import java.util.regex.Pattern


fun Context.dpToPixels(dp:Float):Int{
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        resources.displayMetrics
    ).toInt()
}

fun Context.spToPixels(sp:Float):Int{
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        resources.displayMetrics
    ).toInt()
}

fun Context.isInternetConnected():Boolean{
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    } else {
        val nwInfo = connectivityManager.activeNetworkInfo ?: return false
        return nwInfo.isConnected
    }
}

fun Context.getWindowWidth(percent:Float = 1.0f) :Int = (resources.displayMetrics.widthPixels*percent).toInt()

fun Context.getWindowHeight(percent:Float = 1.0f) :Int = (resources.displayMetrics.heightPixels*percent).toInt()

fun View.hideKeyboard(){
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken,0)
}

fun Context.copyText(text:String,showSuccessMessage:Boolean=true){
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clipboard.setPrimaryClip(
        ClipData.newPlainText("copied text",text)
    )
    if(showSuccessMessage){
        showToast("Text Copied!")
    }
}

fun Context.rateApp(packageName:String){
    try{
        val url = "https://play.google.com/store/apps/details?id=$packageName"
        val intent = Intent(Intent.ACTION_VIEW).also {
            it.data = Uri.parse(url)
        }
        startActivity(intent)
    }catch (e:Exception){
        showToast("Something went wrong, Please try again!")
    }
}

fun Context.gotoFeedback(email:String, subject:String = "Feedback Email!", text:String = "Please tell us about your problems and concerns so that we can address them in later app updates!"){
    try {
        val mailTo = "mailto:" + email +
                "?&subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(text)
        val emailIntent = Intent(Intent.ACTION_VIEW)
        emailIntent.data = Uri.parse(mailTo)
        startActivity(emailIntent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.openUrl(url:String){
    try{
        val intent = Intent(Intent.ACTION_VIEW).also {
            it.data = Uri.parse(url)
        }
        startActivity(Intent.createChooser(intent,"Open link:"))
    }catch (e:Exception){
        showToast("Something went wrong, Please try again!")
    }
}

fun Context.shareApp(packageName:String,subject:String="Share app"){
    val url = "https://play.google.com/store/apps/details?id=$packageName"
    val text = "Hey! check out this app at:\n$url"
    shareText(text,subject)
}

private const val doubleQuote = "\""
private const val singleQuote = "\'"
private var special: Pattern = Pattern.compile("[!@#\$%&*()_+=|<>?{}/;:.,$singleQuote$doubleQuote\\[\\]~-]")
private var digits: Pattern = Pattern.compile("[0-9]")
fun String.hasSpecialOrDigits(): Boolean {
    if(special.matcher(this).find() || digits.matcher(this).find()){
        return true
    }

    val charArr = toCharArray()
    for (element in charArr) {
        val type: Int = Character.getType(element)
        if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
            return true
        }
    }
    return false
}

fun Context.shareText(text:String,subject:String="share text",intentTitle:String = "Share using:"){
    try{
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(
            Intent.EXTRA_SUBJECT,
            subject
        )
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, intentTitle))
    }catch (e:Exception){
        showToast("Something went wrong, Please try again!")
    }
}

private var toast: Toast?=null
fun Context.showToast(msg:String){
    cancelToast()
    toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT)
    toast?.show()
}

fun cancelToast(){
    toast?.cancel()
    toast = null
}

fun Context.getColorFromId(id:Int):Int{
    return ResourcesCompat.getColor(resources,id,theme)
}

fun Context.getDrawableFromId(id:Int): Drawable?{
    return ResourcesCompat.getDrawable(resources,id,theme)
}