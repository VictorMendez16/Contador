package victor.mendez.contador

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var cuenta = 0
    lateinit var contador: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contador = findViewById(R.id.contador)
        val bttn_mas: ImageView = findViewById(R.id.bttn_mas)
        val bttn_menos: ImageView = findViewById(R.id.bttn_menos)
        val bttn_reset: ImageView = findViewById(R.id.bttn_reset)

        bttn_mas.setOnClickListener{
            cuenta++
            contador.setText("$cuenta")
        }

        bttn_menos.setOnClickListener{
            cuenta--
            contador.setText("$cuenta")
        }

        bttn_reset.setOnClickListener{
            cuenta = 0
            contador.setText("$cuenta")
        }
    }

    override fun onPause(){
        super.onPause()
        Toast.makeText(this, "Metodo Pause", Toast.LENGTH_SHORT).show()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putInt("contador", cuenta)
        editor?.apply()
    }

    override fun onStart(){
        super.onStart()
        Toast.makeText(this, "Metodo on Start", Toast.LENGTH_SHORT).show()

        val sharedPref = this?.getPreferences(MODE_PRIVATE)?:return
        val cont = sharedPref.getInt("contador", 0)
        cuenta = cont
        contador.setText("$cuenta")
    }

}