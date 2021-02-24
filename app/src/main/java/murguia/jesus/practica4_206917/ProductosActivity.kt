package murguia.jesus.practica4_206917

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textservice.TextInfo
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_productos.*


class ProductosActivity : AppCompatActivity() {
    var coldDrinks =  ArrayList<Product>()
    var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var listview: ListView= findViewById<ListView>(R.id.listview)
        val choice=intent.getStringExtra("title")
        var ivTitle:ImageView= findViewById<ImageView>(R.id.ivtitle)


        var adaptador: AdaptadorProductos= AdaptadorProductos(this, agregarProductos(choice))
        listview.adapter=adaptador
    }



    fun agregarProductos(choice:String):ArrayList<Product>{

        when(choice){
            "coldDrinks" -> {
                ivtitle.setImageResource(R.drawable.colddrinks)
                coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.00))
                coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.00))
                coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.00))
                coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.00))
                coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.00))
                coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.00))
                return coldDrinks
            }
            "hotDrinks" -> {
                ivtitle.setImageResource(R.drawable.hotdrinks)
                hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.00))
                hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.00))
                hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.00))
                hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.00))
                hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.00))
                hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.00))
                return hotDrinks
            }
            "sweets" -> {
                ivtitle.setImageResource(R.drawable.sweets)
                sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.00))
                sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.00))
                sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.00))
                sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.00))
                sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.00))
                sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.00))
                return sweets
            }
            else -> {
                salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.00))
                salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.00))
                salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.00))
                salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.00))
                salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.00))

                ivtitle.setImageResource(R.drawable.salties)
                return salties
            }

        }




    }



}
private class AdaptadorProductos: BaseAdapter{
    var productos= ArrayList<Product>()
    var contexto: Context? =null
    constructor(contexto:Context, productos:ArrayList<Product>){
        this.contexto=contexto
        this.productos=productos
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var prod=productos[p0]
        var inflador=LayoutInflater.from(contexto)
        var vista=inflador.inflate(R.layout.producto_view,null)

        var product_img:ImageView=vista.findViewById(R.id.producto_img)
        var product_nombre:TextView=vista.findViewById(R.id.producto_nombre)
        var product_desc:TextView=vista.findViewById(R.id.producto_desc)
        var product_precio:TextView=vista.findViewById(R.id.producto_precio)


        product_img.setImageResource(prod.image)
        product_nombre.setText(prod.name)
        product_desc.setText(prod.description)
        product_precio.setText(prod.price.toString())

        return vista
    }

    override fun getItem(p0: Int): Any {
        return productos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return productos.size
    }
}