package com.nasibhaider.roundimageview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import top.defaults.drawabletoolbox.DrawableBuilder


/*created by Nasib Zada Haider, @github:nasib555 on December 19, 2020*/
/*Everything pretty much explains itself, so not many comments are needed :P*/
class RoundCornersImageView(context: Context, attrs: AttributeSet) : CardView(context, attrs) {
    var changed = true
    private val TAG = "Round"

    var roundness: Float = 0f
        set(value) {
            field = value;
            changed = true
            invalidate()
        }
    var src: Int = 0
    var imageView: ImageView? = null
    var strokeWidth: Float = 0f
        set(value) {
            field = value
            changed = true
            invalidate()
        }
    var rippleColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            changed = true
            invalidate()
        }
    var strokeColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            changed = true
            invalidate()
        }
    var isInnerStroke: Boolean = true
        set(value) {
            field = value
            changed = true
            invalidate()
        }
    private val builder = DrawableBuilder()

    init {
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        imageView = ImageView(context)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RoundCornersImageView,
            0, 0
        ).apply {

            try {
                src = getResourceId(R.styleable.RoundCornersImageView_src, 0)
                roundness = getDimension(R.styleable.RoundCornersImageView_roundness, 0f)
                strokeWidth = getDimension(R.styleable.RoundCornersImageView_strokeWidth, 0f)
                rippleColor =
                    getColor(R.styleable.RoundCornersImageView_rippleColor, Color.TRANSPARENT)
                strokeColor =
                    getColor(R.styleable.RoundCornersImageView_strokeColor, Color.TRANSPARENT)
                isInnerStroke = getBoolean(R.styleable.RoundCornersImageView_isInnerStroke, true)
            } finally {
                recycle()
            }
        }
        radius = roundness
        imageView?.setImageResource(src)
        imageView?.scaleType = ImageView.ScaleType.CENTER_CROP
        addView(imageView, 0, params)
        Log.d(TAG, "initialized : ")

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (changed) {
            radius = roundness
            val stroke = builder
                .rectangle()
                .hairlineBordered()
                .strokeWidth(strokeWidth.toInt())
                .strokeColor(strokeColor)
                .cornerRadius(roundness.toInt() - 4)
                .ripple(true)
                .rippleColor(rippleColor)
                .build()
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                imageView?.foreground = stroke
                if (!isInnerStroke) {
                    imageView?.setPadding(
                        strokeWidth.toInt(),
                        strokeWidth.toInt(),
                        strokeWidth.toInt(),
                        strokeWidth.toInt()
                    )
                }
            }
            changed = false
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        //imageView?.setOnClickListener(l)
    }
}