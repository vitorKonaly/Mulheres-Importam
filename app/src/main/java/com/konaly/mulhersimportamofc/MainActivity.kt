package com.konaly.mulhersimportamofc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class MainActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
       // setContentView(R.layout.activity_main)

        isSkipButtonEnabled = false



        addSlide(AppIntroFragment.newInstance(
                title = "Mulheres Importam",

                backgroundDrawable = R.drawable.back_ground,
                description = "placeholder placeholder placeholder placeholder placeholder placeholder",
                imageDrawable = R.drawable.logo
        ))

        addSlide(AppIntroFragment.newInstance(
                title = "Mulheres Importam",


                backgroundDrawable = R.drawable.back_ground2,
                description = "placeholder placeholder placeholder placeholder placeholder placeholder",
                imageDrawable = R.drawable.logo
        ))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        val intent = Intent(this,Login::class.java)
        startActivity(intent)
        super.onDonePressed(currentFragment)
    }
}