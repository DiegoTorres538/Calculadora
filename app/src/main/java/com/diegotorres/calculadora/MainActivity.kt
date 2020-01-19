package com.diegotorres.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private var expresion:String = ""
    private var operador:String = ""
    private var aux:String = ""
    private var aux2:String = ""
    private var aux3:String = ""
    private var sol = 0.0
    private var cont:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uno.setOnClickListener {addItem("1")}
        dos.setOnClickListener {addItem("2")}
        tres.setOnClickListener {addItem("3")}
        cuatro.setOnClickListener {addItem("4")}
        cinco.setOnClickListener {addItem("5")}
        seis.setOnClickListener {addItem("6")}
        siete.setOnClickListener {addItem("7")}
        ocho.setOnClickListener {addItem("8")}
        nueve.setOnClickListener {addItem("9")}
        cero.setOnClickListener {addItem("0")}
        punto.setOnClickListener {addItem(".")}

        suma.setOnClickListener {
            addItem("+")
        }

        resta.setOnClickListener {
            addItem("-")
        }

        multiplicar.setOnClickListener {
            addItem("*")
        }

        dividir.setOnClickListener {
            addItem("/")
        }

        clean.setOnClickListener {revOneItem()}
        delete.setOnClickListener {delItem()}

        igual.setOnClickListener { solEq() }

    }

    fun addItem(item:String){
        expresion = expresion.plus(item)
        pantalla.text = expresion
        }


    fun revOneItem(){
        if(expresion.length > 1){
            expresion = expresion.substring(0,expresion.length-1)
            pantalla.text = expresion
        }
        else{
            expresion = ""
            pantalla.text = expresion
        }
    }

    fun delItem(){
        expresion = ""
        pantalla.text = expresion
    }

    fun solEq(){
        aux = pantalla.text.toString()
        for(i in aux.indices){
            operador = aux[i].toString()
            cont++
            if(operador=="+"){
                aux2 = aux.substring(0,cont-1)
                aux3 = aux.substring(cont,aux.length)
                sol = aux2.toDouble()+aux3.toDouble()
                expresion = sol.toString()
                println(aux2)
            }
            if(operador=="-"){
                aux2 = aux.substring(0,cont-1)
                aux3 = aux.substring(cont,aux.length)
                sol = aux2.toDouble()-aux3.toDouble()
                expresion = sol.toString()
            }
            if(operador=="*"){
                aux2 = aux.substring(0,cont-1)
                aux3 = aux.substring(cont,aux.length)
                sol = aux2.toDouble()*aux3.toDouble()
                expresion = sol.toString()
            }
            if(operador=="/"){
                aux2 = aux.substring(0,cont-1)
                aux3 = aux.substring(cont,aux.length)
                sol = aux2.toDouble()/aux3.toDouble()
                expresion = sol.toString()
            }
        }
        pantalla.text = expresion
        cont = 0
    }
}
