package tads.eaj.ufrn.calculadorabasica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RecebeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        var label = intent.extras?.getString("LABEL")
        val valor = intent.extras?.getInt("VALOR")

        val textViewLabelVariavel = findViewById<TextView>(R.id.textViewLabelVariavel)
        val editTextVariavel = findViewById<TextView>(R.id.editTextVariavel)

        textViewLabelVariavel.text = label
        editTextVariavel.setText(valor.toString())

        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)


        buttonOk.setOnClickListener{
            val intent = Intent()
            val bundle = Bundle()
            val editTextView = findViewById<EditText>(R.id.editTextVariavel)
            bundle.putInt("VALOR", editTextView.text.toString().toInt())
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonCancel.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }
    }

}