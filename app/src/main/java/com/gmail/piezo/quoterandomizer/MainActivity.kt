package com.gmail.piezo.quoterandomizer
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity()
    {
    private lateinit var motivationalButton: Button
    private lateinit var businessButton: Button
    private lateinit var gamingButton: Button
    private lateinit var favoritesButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        motivationalButton = findViewById(R.id.button)
        businessButton = findViewById(R.id.button2)
        gamingButton = findViewById(R.id.button3)
        favoritesButton = findViewById(R.id.button4)


        motivationalButton.setOnClickListener {
            startRandomQuote("Motivational")
        }
        businessButton.setOnClickListener {
            startRandomQuote("Business")
        }
        gamingButton.setOnClickListener {
            startRandomQuote("Gaming")
        }
        favoritesButton.setOnClickListener {

            startFavoriteSave()
        }
    }
    private fun startRandomQuote(quoteType: String) {
        val intent = Intent(this, RandomQuote::class.java)
        intent.putExtra("quoteType", quoteType)
        startActivity(intent)
    }
    private fun startFavoriteSave() {
        val intent = Intent(this, FavoriteSave::class.java)
        startActivity(intent)
    }
}