package sofias.app.bookstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnterror = findViewById<Button>(R.id.button4)
        btnterror.setOnClickListener {
            val intent = Intent(this, Terror::class.java)
            startActivity(intent)
        }
        var btnromance = findViewById<Button>(R.id.button7)
        btnterror.setOnClickListener {
            val intent = Intent(this, Romance::class.java)
            startActivity(intent)
        }
        var btnaccion = findViewById<Button>(R.id.button6)
        btnaccion.setOnClickListener {
            val intent = Intent(this, Accion::class.java)
            startActivity(intent)
        }
    }
}
