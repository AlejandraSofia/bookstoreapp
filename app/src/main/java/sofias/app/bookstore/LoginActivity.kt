package sofias.app.bookstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var baseDatos: FirebaseAuth
    lateinit var user: TextView
    lateinit var pass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ingreso = findViewById<Button>(R.id.btnIniciar_login)
        ingreso.setOnClickListener {
            Ingreso()
        }
        val btnRegistro = findViewById<TextView>(R.id.lblVolverRegistro_login)

        btnRegistro.setOnClickListener {
            val intent = Intent(this, ActivityRegistro::class.java)
            startActivity(intent)
        }
    }

    private fun Ingreso() {
        baseDatos = FirebaseAuth.getInstance()
        user = findViewById(R.id.txtCorreo_login)
        pass = findViewById(R.id.txtPassword_login)


        var usuario = user.text.toString()
        var contraseña = pass.text.toString()
        if(!usuario.isEmpty() && !contraseña.isEmpty())
        {
            baseDatos.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(this){
                    task ->
                if (task.isSuccessful)
                {
                    val intent = Intent(this, ActivityMenu::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "Error :(", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else
        {
            Toast.makeText(this, "Complete el formulario", Toast.LENGTH_SHORT).show()
        }
    }
}
