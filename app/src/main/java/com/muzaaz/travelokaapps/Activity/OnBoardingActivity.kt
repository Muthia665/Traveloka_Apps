package com.muzaaz.travelokaapps.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.muzaaz.travelokaapps.Adapter.AdapterSlide
import com.muzaaz.travelokaapps.R
import com.muzaaz.travelokaapps.data.DataSlide
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    private val slideAdapter = AdapterSlide(
        listOf(
            DataSlide(
                "Title : More than a travel platform",
                "Desc = Explore activities near your with Xperience, and try out Airport Transport, Eats, Car Rental, and many more",
                R.drawable.satu
            ),

            DataSlide(
                "title : Packed with helpful features",
                "Desc : Online Check-in and Easy Reschedule let you travel with ease. Want to save more? We have Price Alerts and PayLater",
                R.drawable.dua
            ),

            DataSlide(
                "title : Unlock full member experience",
                "desc : On top of the benefits, we have special member-only discounts waiting when you log in.Join us now!",
                R.drawable.tiga
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        viewPager.adapter = slideAdapter

        setUpIndicators()

        setCurrentIndicators(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                setCurrentIndicators(position)
            }
        })

        text_next.setOnClickListener {
            if(viewPager.currentItem +1 < slideAdapter.itemCount) {
                viewPager.currentItem += 1
            } else{
                Intent(applicationContext, LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        text_skip.setOnClickListener {
            Intent(applicationContext, LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }

    private fun setCurrentIndicators(index: Int) {
        val childCount = dots.childCount

        for (i in 0 until childCount) {
            val imageView = dots.get(i) as ImageView

            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,
                    R.drawable.indicator_active
                ))

            } else{
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,
                    R.drawable.indicator_inactive
                ))
            }
        }
    }

    private fun setUpIndicators() {
        val indicators = arrayOfNulls<ImageView>(slideAdapter.itemCount)
        val layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)

        for(i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(ContextCompat.getDrawable(applicationContext,
                    R.drawable.indicator_inactive
                ))
                this?.layoutParams = layoutParams
            }
            dots.addView(indicators[i])
        }
    }
}
