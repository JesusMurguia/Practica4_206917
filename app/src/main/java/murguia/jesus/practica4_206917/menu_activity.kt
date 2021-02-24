package murguia.jesus.practica4_206917

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_activity)


        var btn_ColdDrinks:Button=findViewById(R.id.button_cold_drinks)
        var btn_HotDrinks:Button=findViewById(R.id.button_hot_drinks)
        var btn_sweets:Button=findViewById(R.id.button_cold_sweets)
        var btn_salties:Button=findViewById(R.id.button_hot_salties)

        btn_ColdDrinks.setOnClickListener {
            var intent =Intent(this,ProductosActivity::class.java)
            intent.putExtra("title","coldDrinks")
            startActivity(intent)

        }

        btn_HotDrinks.setOnClickListener {
            var intent =Intent(this,ProductosActivity::class.java)
            intent.putExtra("title","hotDrinks")
            startActivity(intent)

        }
        btn_sweets.setOnClickListener {
            var intent =Intent(this,ProductosActivity::class.java)
            intent.putExtra("title","sweets")
            startActivity(intent)

        }

        btn_salties.setOnClickListener {
            var intent =Intent(this,ProductosActivity::class.java)
            intent.putExtra("title","salties")
            startActivity(intent)

        }
    }
}