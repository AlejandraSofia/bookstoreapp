package sofias.app.bookstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class ActivityRegistro : AppCompatActivity() {

    val baseRegistro = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        var btnRegistrarse = findViewById<Button>(R.id.button3)

        btnRegistrarse.setOnClickListener {
            registrarse()
        }
    }

    private fun registrarse() {
        val user = findViewById(R.id.editText7) as EditText
        val password = findViewById(R.id.editText8) as EditText

        val usuario = user.text.toString()
        val contraseña = password.text.toString()

        if(!usuario.isEmpty() && !contraseña.isEmpty())
        {
            baseRegistro.createUserWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful)
                {
                    val usuar = baseRegistro.currentUser
                    Toast.makeText(this, "Ahora, ya estas registrado!!!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "Algo ha salido mal", Toast.LENGTH_SHORT).show()
                }
            })
        }
        else
        {
            Toast.makeText(this, "Completa el formulario", Toast.LENGTH_SHORT).show()
        }
    }
}
