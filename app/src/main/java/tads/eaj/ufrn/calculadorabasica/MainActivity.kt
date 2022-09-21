package tads.eaj.ufrn.calculadorabasica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var variavelX:Int = 0
    var variavelY:Int = 0
    var resultado:Int = 0

    val setVariavelXlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){

            variavelX = result.data!!.getIntExtra("VALOR", 0)
            val textViewValorX = findViewById<TextView>(R.id.textViewValorX)
            Log.i("x", variavelX.toString())
            textViewValorX.text ="${variavelX}"

        }else{
            Toast.makeText(this, "Operação Cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    val setVariavelYlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){

            variavelY = result.data!!.getIntExtra("VALOR", 0)
            val textViewValorY = findViewById<TextView>(R.id.textViewValorY)
            textViewValorY.text ="${variavelY}"

        }else {
            Toast.makeText(this, "Operação Cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textViewValorX = findViewById<TextView>(R.id.textViewValorX)
        var textViewValorY = findViewById<TextView>(R.id.textViewValorY)
        var textViewResultSoma = findViewById<TextView>(R.id.textViewResultSoma)

        var buttonSetVariavelX = findViewById<Button>(R.id.buttonSetVariavelX)
        var buttonSetVariavelY = findViewById<Button>(R.id.buttonSetVariavelY)
        var buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        textViewValorX.text = "${variavelX}"
        textViewValorY.text = "${variavelY}"
        textViewResultSoma.text = "${resultado}"


        buttonSetVariavelX.setOnClickListener {
            val intent = Intent(this, RecebeActivity::class.java)
            val bundle = Bundle()
            bundle.putString("LABEL", "variavel X")
            bundle.putInt("VALOR", variavelX)
            intent.putExtras(bundle)
            setVariavelXlauncher.launch(intent)
        }

        buttonSetVariavelY.setOnClickListener{
            val intent = Intent(this, RecebeActivity::class.java)
            val bundle = Bundle()

            bundle.putString("LABEL", "Variavel Y")
            bundle.putInt("VALOR", variavelY)
            intent.putExtras(bundle)

            setVariavelYlauncher.launch(intent)
        }

        buttonCalcular.setOnClickListener {
            textViewResultSoma.text = (variavelX + variavelY).toString()
        }

    }
}
