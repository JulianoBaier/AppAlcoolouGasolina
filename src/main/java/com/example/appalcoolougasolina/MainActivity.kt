package com.example.appalcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //função calcular onClick
    fun calcularPreco(view: View){
        val precoAlcool =edtPrecoAlcool.text.toString()
        val precoGasolina =edtPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool,precoGasolina)

        if (validaCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            txtResultado.text = "Preencha os preços primeiro"
        }

    }

    private fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        //Converter de string para Double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        // resultado ad formula
        val resultadoPreco = valorAlcool/valorGasolina

        //laço do resultado da conta
        if(resultadoPreco>=0.7){
            txtResultado.text = "Melhor usar Gasolina"
        }else{
            txtResultado.text = "Melhor usar Álcool"

        }
    }

    // Metodo Booleano para verificar se os campos estão vazios"false" ou preenchidos "true"
    private fun validarCampos(precoAlcool: String, precoGasolina: String):Boolean {

        // varialvel onde armazena  true ou false
        var camposValidados = true

        //veirificando se campo do preco alcool esta vazio
        if(precoAlcool==null||precoAlcool.equals("")){

            camposValidados=false
        }

        //veirificando se campo do preco gasolina esta vazio
        else if(precoGasolina==null||precoGasolina.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }


}
