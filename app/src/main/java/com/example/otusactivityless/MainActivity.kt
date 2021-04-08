package com.example.otusactivityless

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.icu.util.TimeUnit.values
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.otusactivityless.SecondActivity.Companion.EXTRA_NAME
import org.w3c.dom.Text
import java.time.chrono.JapaneseEra.values

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TEXT = "EXTRA_TEXT"
        const val REQUEST_CODE = 1
    }

//    private val textView by lazy {
//        findViewById<TextView>(R.id.textView)
//    }

    fun ClearSelection () {
        findViewById<TextView>(R.id.FilmName1).setBackgroundColor(Color.WHITE)
        findViewById<TextView>(R.id.FilmName2).setBackgroundColor(Color.WHITE)
        findViewById<TextView>(R.id.FilmName3).setBackgroundColor(Color.WHITE)
        findViewById<TextView>(R.id.FilmName4).setBackgroundColor(Color.WHITE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewById<ImageView>(R.id.imageView).setImageResource(R.mipmap.ic_launcher)

        findViewById<Button>(R.id.FilmDesc1).setOnClickListener{
            ClearSelection()
             findViewById<TextView>(R.id.FilmName1).setBackgroundColor(Color.RED)
            Intent ( this, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, FilmData(getString(R.string.FilmName1), getString(R.string.FilmDesc1), R.drawable.heat   ))
                startActivityForResult(this, REQUEST_CODE)
            }
        }

        findViewById<Button>(R.id.FilmDesc2).setOnClickListener{
            ClearSelection()
            findViewById<TextView>(R.id.FilmName2).setBackgroundColor(Color.RED)
            Intent ( this, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, FilmData(getString(R.string.FilmName2), getString(R.string.FilmDesc2), R.drawable.ohota2   ))
                startActivityForResult(this, REQUEST_CODE)
            }
        }

        findViewById<Button>(R.id.FilmDesc3).setOnClickListener{
            ClearSelection()
            findViewById<TextView>(R.id.FilmName3).setBackgroundColor(Color.RED)
            Intent ( this, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, FilmData(getString(R.string.FilmName3), getString(R.string.FilmDesc3), R.drawable.project_x ))
                startActivityForResult(this, REQUEST_CODE)
            }
        }

        findViewById<Button>(R.id.FilmDesc4).setOnClickListener{
            ClearSelection()
            findViewById<TextView>(R.id.FilmName4).setBackgroundColor(Color.RED)
            Intent ( this, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, FilmData(getString(R.string.FilmName4 ), getString(R.string.FilmDesc4), R.drawable.breakfast    ))
                startActivityForResult(this, REQUEST_CODE)
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            //Toast.makeText(this, "I am here", Toast.LENGTH_LONG).show()
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString(EXTRA_NAME, findViewById<TextView>(R.id.textView).text.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                //val someData = data?.getParcelableExtra<SomeData>(SecondActivity.EXTRA_NAME)
                val someData = data?.getParcelableExtra<ReturnValue>(SecondActivity.EXTRA_NAME)
                someData?.let {
                    Log.d("deb",  "${it.Is_liked.toString()}, ${it.comment}")
                    Toast.makeText(this, "${it.Is_liked.toString()}, ${it.comment}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}