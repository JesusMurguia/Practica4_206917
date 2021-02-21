package murguia.jesus.practica4_206917

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class welcome_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page)
        val button: Button =findViewById(R.id.button_get_started)
        button.setOnClickListener {
            var intent: Intent =  Intent(this,RegisterPage::class.java)
            startActivity(intent)
        }
    }
}