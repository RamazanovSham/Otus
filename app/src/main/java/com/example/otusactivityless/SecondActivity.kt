package com.example.otusactivityless

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity:AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        fun launchActivity(activity : Activity, name : String) {
            Intent(activity, SecondActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
                activity.startActivity(this)
            }
        }
    }

    //            savedInstanceState?.putBoolean("Check")?.let {
//                findViewById<CheckBox>(R.id.checkBox).isChecked = it
//            }

    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        intent?.getBooleanExtra("Check").let {
//            findViewById<CheckBox>(R.id.checkBox).isChecked = it as Boolean
//        }
        findViewById<CheckBox>(R.id.checkBox).setOnClickListener{


        }



        intent.getParcelableExtra<FilmData>(MainActivity.EXTRA_TEXT)?.let {
            val someData = it as FilmData
            findViewById<TextView>(R.id.Name).text = "${someData.name}"
            findViewById<TextView>(R.id.Description).text = "${someData.description}"
            findViewById<ImageView>(R.id.FilmImage).setImageResource(someData.Image)
        }

        findViewById<Button>(R.id.Back).setOnClickListener{
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(EXTRA_NAME, ReturnValue(findViewById<EditText>(R.id.Et).getText().toString(), findViewById<CheckBox>(R.id.checkBox).isChecked()))
            })

//            savedInstanceState?.putBoolean("Check")?.let {
//                findViewById<CheckBox>(R.id.checkBox).isChecked = it
//            }

            finish()
        }

        fun onSaveInstanceState(outState: Bundle ) {
            super.onSaveInstanceState(outState)
            outState.putBoolean("Check", findViewById<CheckBox>(R.id.checkBox).isChecked )
        }

//        override fun onSaveInstanceState(outState: Bundle) {
//            super.onSaveInstanceState(outState)
//            outState.putString(EXTRA_NAME, findViewById<TextView>(R.id.textView).text.toString())
//        }
    }
}
