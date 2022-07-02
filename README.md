# Common Functionality

```
Common Extension Functions:

1- Context.isInternetConnected():Boolean -> checks internet connection
2- Context.showToast(message:String) //shows toast message
3- Context.getWindowWidth(percent:Float = 1.0f):Int //returns window width based on percentage
4- Context.getWindowheight(percent:Float = 1.0f):Int //returns window height based on percentage
5- Context.copyText(text:String, showToastMessage:Boolean = true) //copies text in clipboard
6- Context.shareText(text:String) //opens chooser to share text
7- Context.rateApp(packageName:String) //opens play store url of app to rate.
8- Context.gotoFeedback(email:String,subject:String="Feedback Email!",extraText:String="Please tell us about your problems and concerns so that we can address them in 	  later app updates!") //opens email client and composes email
9- Context.openUrl(url:String) //opens url passed in String
10- Context.shareApp(packageName:String,subject:String) //opens share app intent with app package name passed.
11- Context.getColorFromId(id:Int):Int //returns color of passed color id
12- Context.getDrawableFromId(id:Int):Drawable //returns drawable of passed drawable id

13- View.gone() //set View's visibility to GONE
14- View.show() //set View's visibility to VISIBLE
15- View.invisible() //set View's visibility to INVISIBLE

```


> Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
		repositories {
	
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  > Step 2. Add the dependency
  ```gradle
  	dependencies {
	       implementation 'com.github.israr152:UniversalMethods:1.0.1'
	}
  ```
