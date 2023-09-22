package com.gmail.piezo.quoterandomizer

import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.widget.TextView
import android.widget.Button
import kotlin.random.Random
import android.widget.Toast
import android.os.Bundle

class RandomQuote : AppCompatActivity() {
    private lateinit var randomQuoteTextView: TextView
    private lateinit var favoritesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_quote)

        randomQuoteTextView = findViewById(R.id.textView3)
        favoritesButton = findViewById(R.id.button6)

        val quoteType = intent.getStringExtra("quoteType")
        val quotes = getQuotesForCategory(quoteType)

        if (quotes.isNotEmpty()) {
            val randomIndex = Random.nextInt(quotes.size)
            val randomQuote = quotes[randomIndex]
            displayRandomQuote(randomQuote)

            favoritesButton.setOnClickListener {
                saveQuoteToSharedPreferences(quoteType, randomQuote)
                showToast("Quote Saved.")
            }
        }
    }

    private fun getQuotesForCategory(quoteType: String?): Array<String> {
        return when (quoteType) {
            "Motivational" -> arrayOf(
                "It’s not about perfect. It’s about effort. \n\n – Jillian Michaels",
                "Excellence is not a skill. It is an attitude. \n\n– Ralph Marston",
                "Focus on your goal. Don’t look in any direction but ahead. \n\n -Unknown",
                "You don’t get what you wish for. You get what you work for. \n\n– Daniel Milstein",
                "Do something now; your future self will thank you for later. \n\n – Unknown",
                "Don’t try to be perfect. Just try to be better than you were yesterday. \n\n– Unknown",
                "Keep going. Everything you need will come to you at the perfect time. \n\n – Unknown",
                "Even the greatest were beginners. Don’t be afraid to take that first step.\n\n – Unknown",
                "Everything you’ve ever wanted is on the other side of fear. \n\n – George Addair",
                "Your time is limited, so don’t waste it living someone else’s life. \n\n – Steve Jobs"
            )
            "Business" -> arrayOf(
                "Success is not final; failure is not fatal: it is the courage to continue that counts. \n\n– Winston Churchill",
                "Play by the rules, but be ferocious. \n\n – Phil Knight",
                "Business opportunities are like buses, there’s always another one coming. \n\n – Richard Branson",
                "Every problem is a gift—without problems we would not grow. \n\n – Anthony Robbins",
                "You only have to do a few things right in your life so long as you don’t do too many things wrong. \n\n – Warren Buffett",
                "Success usually comes to those who are too busy to be looking for it. \n\n – Henry David Thoreau",
                "And the day came when the risk to remain tight in a bud was more painful than the risk it took to blossom. \n\n – Anaïs Nin",
                "There’s no shortage of remarkable ideas, what’s missing is the will to execute them. \n\n – Seth Godin",
                "I owe my success to having listened respectfully to the very best advice, and then going away and doing the exact opposite. \n\n – G.K. Chesterton",
                "I don’t know the word ‘quit.’ Either I never did, or I have abolished it. \n\n – Susan Butcher",
            )

            "Gaming" -> arrayOf(
                "The only way to do great work is to love what you do. \n\n - Steve Jobs",
                "Winning isn't everything, but wanting to win is. \n\n - Vince Lombardi",
                "The best way to predict the future is to create it. \n\n - Abraham Lincoln",
                "The only limit to our realization of tomorrow will be our doubts of today. \n\n - Franklin D. Roosevelt",
                "Life is a game. Money is how we keep score. \n\n - Ted Turner",
                "The world is a game. Money is how we keep score. The game is constantly changing. So must we. \n\n - Robert Kiyosaki",
                "The game has its ups and downs, but you can never lose focus of your individual goals and you can't let yourself be beaten because of lack of effort. \n\n - Michael Jordan",
                "Video games are bad for you? That's what they said about rock-n-roll. \n\n - Shigeru Miyamoto",
                "The difference between try and triumph is just a little umph! \n\n - Marvin Phillips",
            )
            else -> arrayOf()
        }
    }

    private fun displayRandomQuote(quote: String) {
        randomQuoteTextView.text = quote
    }

    private fun saveQuoteToSharedPreferences(quoteType: String?, quote: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("MyQuotes", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val key = "$quoteType" + "_quote"
        editor.putString(key, quote)
        editor.apply()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
