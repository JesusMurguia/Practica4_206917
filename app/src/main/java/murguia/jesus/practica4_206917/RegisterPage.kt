package murguia.jesus.practica4_206917

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)
        val button: Button =findViewById(R.id.sign_in_button)
        button.setOnClickListener {
            var intent: Intent =  Intent(this,menu_activity::class.java)
            startActivity(intent)
        }
    }
}