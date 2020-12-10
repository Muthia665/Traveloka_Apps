package com.muzaaz.travelokaapps.Fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.muzaaz.travelokaapps.Adapter.AdapterHeader

import com.muzaaz.travelokaapps.R
import com.muzaaz.travelokaapps.data.DataHeader
import kotlinx.android.synthetic.main.activity_on_boarding.*
import kotlinx.android.synthetic.main.fragment_awal.*

/**
 * A simple [Fragment] subclass.
 */
class AwalFragment : Fragment() {

    private val headerAdapter = AdapterHeader(
        listOf(
            DataHeader(
                R.drawable.g1
            ),

            DataHeader(
                R.drawable.g2
            ),

            DataHeader(
                R.drawable.g3
            ),

            DataHeader(
                R.drawable.g4
            ),

            DataHeader(
                R.drawable.g5
            )
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_awal, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vp_header.adapter = headerAdapter

        IndicatorUp()

        setIndicatorCurrent(0)

        vp_header.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                setIndicatorCurrent(position)
            }

        })
    }

    private fun setIndicatorCurrent(index : Int) {
        val childCount = dots_header.childCount

        for (i in 0 until childCount) {
            val context : Context = this.context ?: return
            val imageView = dots_header.get(i) as ImageView

            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_active_header))

                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_inactive_header))

            }
        }
    }

    private fun IndicatorUp() {
        val indicators = arrayOfNulls<ImageView>(headerAdapter.itemCount)
        val params = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(context)
            indicators[i].apply {
                this?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_inactive_header))
                this?.layoutParams = params
            }
            dots_header.addView(indicators[i])
        }
    }

}