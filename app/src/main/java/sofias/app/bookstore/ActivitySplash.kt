package sofias.app.bookstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class ActivitySplash : AppCompatActivity() {
    var elhandler : Handler? = null

    val tiempo : Long = 3100

    val corriendo: Runnable = Runnable()
    {
        if (!isFinishing)
        {
            val intent = Intent(applicationContext, Romance::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        elhandler = Handler()
        elhandler!!.postDelayed(corriendo, tiempo)
    }
    override fun onDestroy()
    {
        if (true)
        {
            elhandler!!.removeCallbacks(corriendo)
        }
        super.onDestroy()
    }



}
