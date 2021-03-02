package br.com.renatarene.coversordekm

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calcular.setOnClickListener {
            try {

                val numberFormat = NumberFormat.getNumberInstance()
                val percursoKm = edt_caixa_km.text.toString().toDouble()
                val percursoMetros = percursoKm * 1000
                val percursoCentimetros = percursoMetros * 100

                val percursoMetrosFormatado = numberFormat.format(percursoMetros)
                val percursoCentimetrosFormatado = numberFormat.format(percursoCentimetros)

                txv_resultado_metros.text = getString(R.string.txv_resultado_metros_text, percursoMetrosFormatado)
                txv_resultado_centimetros.text = getString(R.string.txv_resultado_centimetros_text, percursoCentimetrosFormatado)
            } catch (error: NumberFormatException){
                Toast.makeText(this,"Digite apenas números!", Toast.LENGTH_LONG).show()
                txv_resultado_metros.text = ""
                txv_resultado_centimetros.text = ""
            }
        }
    }
}