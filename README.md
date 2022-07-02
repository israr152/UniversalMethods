# Common Functionality

```
Common Extension Functions:

1- Context.isInternetConnected():Boolean -> checks internet connection
2- Context.showToast(message:String) //shows toast message
3- Context.getWindowWidth(percent:Float = 1.0f):Int //returns window width based on percentage
4- Context.copyText(text:String, showToastMessage:Boolean = true) //copies text in clipboard
5- Context.shareText(text:String) //opens chooser to share text
6- Context.rateApp(packageName:String) //opens play store url of app to rate.
7- Context.gotoFeedback(email:String,subject:String="Feedback Email!",extraText:String="Please tell us about your problems and concerns so that we can address them in 	  later app updates!") //opens email client and composes email
8- Context.openUrl(url:String) //opens url passed in String
9- Context.shareApp(packageName:String,subject:String) //opens share app intent with app package name passed.
10- Context.getColorFromId(id:Int):Int //returns color of passed color id
11- Context.getDrawableFromId(id:Int):Drawable //returns drawable of passed drawable id

12- View.gone() //set View's visibility to GONE
13- View.show() //set View's visibility to VISIBLE
14- View.invisible() //set View's visibility to INVISIBLE

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
