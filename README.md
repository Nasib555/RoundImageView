# Round Corners ImageView
An awesome and lightweight library for android _(java/kotlin)_ for getting **ImageViews** in rounded corners or circular shapes with 
**CUSTOM RIPPLE COLORS**, **BORDER COLORS** and  **ROUNDNESS** Dimension. 
> You can even put other views or viewgroups inside it.

<img src="https://github.com/Nasib555/RoundImageView/blob/master/app/src/main/ss1.jpg?raw=true"
     alt="ScreenShot 1" />
     
<img src="https://github.com/Nasib555/RoundImageView/blob/master/app/src/main/ss2.jpg?raw=true"
     alt="ScreenShot 2" />

<img src="https://github.com/Nasib555/RoundImageView/blob/master/app/src/main/ss3.PNG?raw=true"
     alt="ScreenShot 3"/>

# Usage
> Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	} 
  ```




> Add the dependency
``` 
dependencies {
	        implementation 'com.github.Nasib555:RoundImageView:master-SNAPSHOT'
	}
  ```

# Add this view in your xml
```

<com.nasibhaider.roundimageview.RoundCornersImageView
        android:id="@+id/round_imageview"
        android:layout_width="250dp"
        android:layout_height="250dp"
        app:cardElevation="8dp"
        app:rippleColor="#000"
        app:roundness="250dp"
        app:src="@drawable/img_logo"
        app:strokeColor="#000"
        app:strokeWidth="7dp"/>
```

# Views Inside this imageview
>**You can add any viewgroup or view inside it, as this view extends android design library's CardView**

```
<com.nasibhaider.roundimageview.RoundCornersImageView
        android:id="@+id/corners"
        android:layout_width="250dp"
        android:layout_height="250dp"
        app:cardElevation="8dp"
        app:rippleColor="#000"
        app:roundness="250dp"
        app:src="@drawable/img_logo"
        app:strokeColor="#000"
        app:strokeWidth="0dp">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            android:background="#9E000000"
            android:padding="10dp"
            android:textSize="25dp"
            android:gravity="center_horizontal"
                android:text="Claire Z."
            android:textColor="#fff" />
    </com.nasibhaider.roundimageview.RoundCornersImageView>

```
# Java usage
You can do pretty much anything as you'd with a normal imageview but, there's  some points you need to keep in mind.
>As this this extends CardView and not an ImageView, you cannot cast it to an ImageView, if you want to cast it to an ImageView you'd do something like 
```RoundCornersImageView riv=findViewById(R.id.round_image_view);
ImageView imageView=riv.getImageView();
// now you can call all methods of imageview on this ```

> If you do not want to cast it, you can directly call methods of ImageView on it like
```
```
RoundCornersImageView riv=findViewById(R.id.round_image_view);
riv.getImageView.setImageResource(R.drawable.dp);
```
# Kotlin usage
Pretty much the same.
```
var ivRound: RoundCornersImageView? = findViewById(R.id.round_image_view)

//direct properties
ivRound?.strokeWidth =10f
ivRound?.roundness = 10f
ivRound?.rippleColor = Color.RED
ivRound?.strokeColor = Color.RED

//indirect properties
ivRound?.imageview.setImageResource(R.drawable.dp)
ivRound?.imageview.setBitmap(bitmap)
//and all other properties of imageview
```
