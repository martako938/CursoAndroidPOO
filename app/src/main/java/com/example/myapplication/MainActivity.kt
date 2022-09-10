package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object{
        const val moneda = "DOL"
    }
    var saldo : Float = 300.54f
    var sueldo: Float = 764.82f
    var entero: Int = 62

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fecha = "01/09/1990"
        //           0123456789

        var nombre: String= "Brayan"
        var vip: Boolean = false
        var inicial: Char = 'B'

        var saludo = "Hola " + nombre


        if (vip == true) saludo+= ", te queremos mucho"
        else saludo += ", quieres ser vip? paga el precio"

        mostrar_saldo()
        var dia = fecha.subSequence(0,2).toString().toInt()
        if (dia == 1)ingresar_sueldo()

        var mes = fecha.subSequence(3,5).toString().toInt()

        when(mes){
            1 -> println("\n En Enero hay la super oferta 7% de interes")
            2, 3 -> println("\n En invierno no hay ofertas de inversiones")
            4, 5, 6 -> println("\n En primavera hay ofertas de inversiones con el 1.5% de interes")
            7, 8, 9 -> println("\nEn verano hay ofertas de inversiones con el 2.5% de interes")
            10, 11, 12 -> println("\n En otoño hay ofertas de inversiones con el 3.5% de interes")
            else -> println("\n La fecha es erronea")
        }

        println(saludo)

        var pin: Int = 1234
        var intentos: Int = 0

        var clave_ingresada: Int = 1234

        do{
            println("Ingresa el PIN: ")
            println("Clave ingresada: ${clave_ingresada}")
            if (clave_ingresada == pin) break
            intentos ++
        }while(intentos < 3 && clave_ingresada != pin)

        if (intentos >= 3) println("Tarjeta bloqueada")

        mostrar_saldo()
        ingresar_dinero(50.5f)
        retirar_dinero(40f)
        retirar_dinero(50f)
        retirar_dinero(800f)

        var recibos: Array<String> = arrayOf("Luz","Agua","Gas")
        recibos.set(2, "Internet Telmex")
        recorrer_array(recibos)

        var matriz = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6,7,8,9,10),
            intArrayOf(11,12,13)
        )

        for (i in (0 until matriz.size)){
            println()
            for ( j in (0 until matriz[i].size))
            println("Posicion[$i][$j] : ${matriz[i][j]}")
        }

        /*COLECCIONES*/

        var clientesVIP: Set<Int> = setOf (1234, 5678, 5050)
        val setMezclado = setOf(2, 4,54, "casa", 'c')

        println("Clientes VIP: ")
        println(clientesVIP)
        println("Numero de clientes VIP: ${clientesVIP.size}")

        /*Preguntar si hay un valor en el conjunto*/
        if (clientesVIP.contains(1234)) println("1234 es VIP")
        if (clientesVIP.contains(1235)) println("1235 es VIP")


        var clientes: MutableSet<Int> = mutableSetOf(1234,5678,4040,8970)
        println("Clientes: ")
        println(clientes)

        clientes.add(3026)
        println(clientes)

        clientes.remove( 5678)
        println(clientes)

        clientes.clear()
        println(clientes)

        println("Numero de clientes: ${clientes.size}")

        var divisas: List<String> = listOf("USD", "EUR", "MXN")
        println(divisas)

        var bolsa: MutableList<String> = mutableListOf("Coca-Cola", "Addidas", "Amazon", "Pfizer")
        /*modificar_lista(bolsa)*/

        var mapa: Map<Int, String> = mapOf(
            1 to "Mexico",
            2 to "España",
            3 to "Colombia"
        )

        println(mapa)

        var inversiones = mutableMapOf<String, Float>()
        println(inversiones)

        var empresa: String? = null

        mostrar_saldo()
        var cantidad_a_invertir = 90f
        var index = 0

        while (saldo >= cantidad_a_invertir){
            empresa = bolsa.elementAtOrNull(index)
            if (empresa != null){
                saldo -= cantidad_a_invertir

                println("Se ha invertido $cantidad_a_invertir $moneda en $empresa")
                inversiones.put(empresa, cantidad_a_invertir)
            }
            else break
            index++
        }




        var platillos = arrayOf(
            arrayOf("Pizza",150, arrayOf("Harina","Peperoni","Jamon","Salsa","Queso","Pimiento")),
            arrayOf("Hamburguesa",60, arrayOf("Pan","Queso amarillo","Carne","Jitomate","Cebolla","Pepinillos","Catsup")),
            arrayOf("Tacos",90, arrayOf("Tortillas","Carne","Cilantro","Cebolla","Salsa","Limon"))
        )
        println("----MENU----")
        for (i in (0 until platillos.size)){
            for ( j in (0 until platillos[i].size)) {
                if (j == 0)
                    print("Platillo: ${platillos[i][j]} ")
                else if (j == 1)
                    println("Precio: $${platillos[i][j]} MXN")
                    else{
                        var ingredientes: Array<String> = platillos[i][j] as Array<String>
                        println("Ingredientes: ")
                        for ( i in (0 until  ingredientes.size))
                            println("${i+1}- ${ingredientes[i]}")
                    }
            }
        }







        /*OPERADORES LOGICOS
        var a: Boolean = true
        var b: Boolean = true
        var c: Boolean = false
        var d: Boolean = false

        a && b // && = AND    CONDICION && CONDICION
               //           A == 5      3<= VALOR
        a || b // || = OR     CONDICION || CONDICION

        a && c
        a && c

        !d      // ! = NEGACION
        */
        /*OPERADORES DE CALCULO
        var a:Int = 5 + 5 // 10
        val b:Int = 10 - 2 // 8
        val c:Int = 3 * 4 // 12
        val d:Int = 10 / 5 // 2
        val e:Int = 10 % 3 // 1 no se puede dividir se queda con el resto
        val f:Int = 10 /6 // 1 division infinita solo s mantiene la parte entera

        var aPreIncremento: Int = 5
        var bPreDecremento: Int = 5
        var cPostIncremento: Int = 5
        var dPostDecremento: Int = 5

        println(aPreIncremento)
        println(++aPreIncremento)// Incrementa primero luego regresa Salida 6
        println(aPreIncremento)

        println(bPreDecremento)
        println(--bPreDecremento) //Decrementa primero luego regresa Salida 4
        println(bPreDecremento)

        println(cPostIncremento)
        println(cPostIncremento++)// primero regresa luego incrementa Salida 5
        println(cPostIncremento)

        println(dPostDecremento)
        println(dPostDecremento--) // primero regresa luego decrementa Salida 5
        println(dPostDecremento)

        saldo += sueldo
        saldo ++

         */
        /*
        OPERADORES DE COMPARACION

        var res = true
        res = a == b
        res = a != b
        res = a > b
        res = a < b
        res = a >= b
        res = a <= b


         */

    }

    fun mostrar_saldo(){
        println("Tienes $saldo $moneda")
    }
    fun ingresar_sueldo(){
        saldo += sueldo
        println("Se ha ingresado tu sueldo de $sueldo $moneda")
        mostrar_saldo()
    }

    fun ingresar_dinero(cantidad : Float){
        saldo += cantidad
        println("Se ha ingresado $cantidad $moneda")
        mostrar_saldo()
    }

    fun retirar_dinero(cantidad : Float){
        if ( verificarCantidad(cantidad) ){
            saldo -= cantidad
            println("Se ha retirado $cantidad $moneda")
            mostrar_saldo()
        }
        else println("Cantidad superior al saldo. Es imposible realizar la operacion")
    }

    fun verificarCantidad(cantidad_a_retirar: Float): Boolean{
        if (cantidad_a_retirar > saldo) return false
        else return true
    }

    fun recorrer_array(array: Array<String>){

        for ( i in array )
            println(i)

        for (i in array.indices)
            println (array.get(i))

        for (i in 0 .. array.size -1)
            println("${i+1}: ${array.get(i)}")

    }

    fun modificar_lista(mutableList: MutableList<String>){
        println(mutableList)

        mutableList.add("Adobe")
        println(mutableList)

        mutableList.add("NVidia")
        println(mutableList)

        mutableList.removeAt(3)
        println(mutableList)

        println(mutableList.first())
        println(mutableList.last())
        println(mutableList.elementAt(4))
        println(mutableList.none())

        println( mutableList.firstOrNull())
        mutableList.clear()
        println(mutableList)

        println(mutableList.none())
        println(mutableList.firstOrNull())
    }

}