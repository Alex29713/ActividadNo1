import kotlin.random.Random

fun main() {
    val listaCabinas: MutableList<String> = mutableListOf() //almacena nombres de las cabinas
    val preciosCabinas: MutableList<Int> = mutableListOf() // almacena los valores de la plata cobrada por cabina
    val llamadasCabinas: MutableList<Int> = mutableListOf() // almacena la cantidad de llamadas de cada cabina
    var o1 = 0


    val local = 50
    val distancia = 350
    val celular = 150


    var min : Int
    do{
        println()
        println("   Cabinas Telefónicas")
        println("---------------------------------")
        println("1. Listar Cabinas")
        println("2. Crear Cabina")
        println("3. Borrar Cabina")
        println("4. Informe Cabinas")
        println("5. Salir")
        println("---------------------------------")
        print("Digite una opción -> ")

        try {
            o1 = readln().toInt()                   // pide el dato y comprueba que sea un numero
        } catch (e: NumberFormatException) {
            println("Error: Entrada inválida. Por favor, digite un número.")
            continue
        }

        println("")
        when(o1) {
            1 -> {
                println("-------Listado de Cabinas--------")
                if (listaCabinas.isEmpty()) {   //comprueba que si haya cabinas
                    println("No hay cabinas creadas.")
                    println()
                }else {
                    listaCabinas.forEachIndexed { index, cabina -> //funcion que se ejecuta segun la cantidad
                        println("${index + 1}. $cabina")           //de elementos que contenga la lista
                    }

                    println("---------------------------------")
                    println("Seleccione La Cabina a ingresar")
                    println("Digite un numero negativo para salir")

                    var o2 : Int
                    try {
                        o2  = readln().toInt()
                    } catch (e: NumberFormatException) {
                        println("Error: Entrada inválida. Por favor, digite un número.")
                        continue
                    }

                    if (o2 > 0 && o2 <= listaCabinas.size) {  //comprueba que el dato este dentro del rango de 0 y el tamaño de la lista
                        println("1. Realizar llamada")
                        println("2. Mostrar Información")
                        println("3. Formatear Informacion")
                        println("Digite una opcion")


                        var o3 : Int
                        try {
                            o3  = readln().toInt()
                        } catch (e: NumberFormatException) {
                            println("Error: Entrada inválida. Por favor, digite un número.")
                            continue
                        }

                        when(o3){
                            1 ->{
                                var llam1: Int = 0
                                var llam2: Int = 0
                                var llam3: Int = 0

                                var LlamadaLocal : Int = 0
                                var LlamadaDistancia : Int = 0
                                var LlamadaCelular : Int = 0

                                var o4  = 0

                                do {
                                    println("=========== TARIFAS DE LLAMADAS ===========")
                                    println("1. Minuto Llamada Local: $50 pesos")
                                    println("2. Minuto Llamada Larga Distancia: $350 pesos")
                                    println("3. Minuto Llamada Celular: 150 pesos")
                                    println("4. Cobrar")
                                    println("-------------------------------------------")
                                    println("Digite una opcion -> ")


                                    try {
                                        o4 = readln().toInt()
                                    } catch (e: NumberFormatException) {
                                        println("Error: Entrada inválida. Por favor, digite un número.")
                                        continue
                                    }

                                    min = Random.nextInt(1,101) // asigna un numero al azar entre 1 y 100 para los minutos

                                    if(o4 !in 1..4) {println("Numero Invalido! Vuelva a Digitar")} // muestra el error si el dato no esta en el rango de la lista

                                    when(o4){
                                        1 -> {
                                            LlamadaLocal += min * local  // crea una variable local y multiplica el valor de la llamada por el costo
                                            llam1 += 1 // incrementa en 1 cada vez que se vuelve a llamar por la misma opcion
                                            preciosCabinas[3 * (o2 - 1)] += LlamadaLocal // se realiza un guardado segun el numero de cabina almacenado en listaCabinas de los precios de cada llamada por cabina
                                            llamadasCabinas[3 * (o2 - 1)] += 1          // se guarda de igual forma la cantidad de llamadas segun tipo local,distancia o celular
                                        }
                                        2 -> {
                                            LlamadaDistancia += min * distancia
                                            llam2 += 1
                                            preciosCabinas[3 * (o2 - 1) + 1] += LlamadaDistancia
                                            llamadasCabinas[3 * (o2 - 1) + 1] += 1
                                        }
                                        3 -> {
                                            LlamadaCelular += min * celular
                                            llam3 += 1
                                            preciosCabinas[3 * (o2 - 1) + 2] += LlamadaCelular
                                            llamadasCabinas[3 * (o2 - 1) + 2] += 1
                                        }
                                    }
                                }while (o4 != 4)
                                val nombre = listaCabinas[o2 - 1]
                                println()
                                println("================= FACTURA LLAMADAS $nombre ===========================")
                                println("Llamadas  |   Precio    | No. Minutos  |  Cantidad LLam |  Total")
                                val pag = LlamadaLocal + LlamadaDistancia + LlamadaCelular
                                val llam = llam1 + llam2 + llam3
                                val m = (LlamadaLocal/local) + (LlamadaDistancia/distancia) + (LlamadaCelular/celular)
                                println("---------------------------------------------------------------------")
                                println("Locales   |     $local      |      ${LlamadaLocal/local}       |       $llam1        |    $LlamadaLocal")
                                println("Distancia |     $distancia     |      ${LlamadaDistancia/distancia}       |       $llam2         |    $LlamadaDistancia")
                                println("Celular   |     $celular     |      ${LlamadaCelular/celular}       |       $llam3         |    $LlamadaCelular")
                                println("=======================================================================")
                                println(" TOTAL A PAGAR: $pag  |  TOTAL MINUTOS: $m  |  TOTAL LLAMADAS: $llam")

                            }

                            2 -> {
                                println()
                                val nombre: String = listaCabinas[o2 - 1]
                                println("================= INFORMACION CABINA $nombre ================================")
                                val index = 3 * (o2 - 1)
                                val llamadas = llamadasCabinas[index] + llamadasCabinas[index + 1] + llamadasCabinas[index + 2]
                                val cobrado = preciosCabinas[index] + preciosCabinas[index + 1] + preciosCabinas[index + 2]
                                val minutos = (preciosCabinas[index] / local) + (preciosCabinas[index + 1] / distancia) + (preciosCabinas[index + 2] / celular)

                                println("Llamadas  |   Precio    | No. Minutos  |  Cantidad LLam |  Total")
                                println("-----------------------------------------------------------------------------")
                                println("Locales   |     $local      |      ${preciosCabinas[index] / local}       |       ${llamadasCabinas[index]}        |   ${preciosCabinas[index]}")
                                println("Distancia |     $distancia     |      ${preciosCabinas[index + 1] / distancia}       |       ${llamadasCabinas[index + 1]}        |   ${preciosCabinas[index + 1]}")
                                println("Celular   |     $celular     |      ${preciosCabinas[index + 2] / celular}       |       ${llamadasCabinas[index + 2]}        |   ${preciosCabinas[index + 2]}")
                                println("=============================================================================")
                                println(" TOTAL COBRADO: $cobrado  |  TOTAL MINUTOS: $minutos  |  TOTAL LLAMADAS: $llamadas")
                            }
                            3 -> {
                                if (o2 in 1..listaCabinas.size) {
                                    val index = 3 * (o2 - 1)
                                    for (i in 0..2) {
                                        preciosCabinas[index + i] = 0 // resetea los valores de los precios segun la posicion
                                        llamadasCabinas[index + i] = 0
                                    }
                                    println("Información de la cabina #$o2 ha sido formateada.")
                                } else {
                                    println("Número de cabina no válido. Verifique el número e intente nuevamente.")
                                }

                            }
                        }
                    }else  if(Math.abs(o2) > listaCabinas.size && o2 > 0) println(" Error, no existe ese numero de Cabina") // si el valor es positivo y excede al numero maximo de cabinas, produce un error



                }
            }
            2 -> {
                print("Ingrese el nombre de la nueva cabina: ")
                val nuevaCabina = readln()
                listaCabinas.add(nuevaCabina)
                preciosCabinas.addAll(listOf(0, 0, 0))
                llamadasCabinas.addAll(listOf(0, 0, 0))
                println("La Cabina '$nuevaCabina' fue creada exitosamente.")
                println()
            }
            3 -> {
                print("Digite el número de la cabina a borrar: ")
                val borrarCabina = readln().toInt()

                if (borrarCabina in 1..listaCabinas.size) {
                    val nombreCabina = listaCabinas[borrarCabina - 1]
                    val index = (borrarCabina - 1) * 3

                    listaCabinas.removeAt(borrarCabina - 1)

                    for (i in 0..2) {
                        preciosCabinas.removeAt(index)
                        llamadasCabinas.removeAt(index)
                    }

                    println("La cabina '$nombreCabina' ha sido borrada.")
                } else {
                    println("Error: Cabina no existe.")
                }
                println()
            }
            4 -> {
                if (listaCabinas.isEmpty()) {
                    println("No hay cabinas creadas.")
                    println()
                }else{

                    println("====================================== Informe de Cabinas  ===========================================")
                    println("  Nombre   | Loc | Dis | Cel | Total Min | Total Cobrado |  Cantidad LLam |   Costo Promedio")
                    println("------------------------------------------------------------------------------------------------------")
                    var TotalLLamadas : Int = 0
                    var TotalCobrado : Int = 0
                    var TotalMinutos : Int = 0
                    var TotalProm : Double = 0.0


                    listaCabinas.forEachIndexed { index, cabina ->
                        val idx = index * 3

                        val totalLlamadas = llamadasCabinas[idx] + llamadasCabinas[idx + 1] + llamadasCabinas[idx + 2]
                        val totalCobrado = preciosCabinas[idx] + preciosCabinas[idx + 1] + preciosCabinas[idx + 2]
                        val totalminutos = llamadasCabinas[idx] + llamadasCabinas[idx + 1] + llamadasCabinas[idx + 2]
                        val prom : Double = if(totalminutos == 0) 0.0 else totalCobrado.toDouble()/totalminutos // comprueba que la division no este indeterminada

                        TotalLLamadas += totalLlamadas
                        TotalCobrado += totalCobrado
                        TotalMinutos += totalminutos
                        TotalProm += prom

                        println("${index + 1}. $cabina|  ${llamadasCabinas[idx]}  |  ${llamadasCabinas[idx + 1]}  |  ${llamadasCabinas[idx + 2]}  |" +
                                "    $totalminutos      |     $totalCobrado      |       $totalLlamadas        |         $prom")
                    }
                    println("=====================================================================================================")
                    println(" TOTAL COBRADO: $TotalCobrado |  TOTAL MINUTOS: $TotalMinutos  |  TOTAL LLAMADAS: $TotalLLamadas | Promedio Total: $TotalProm")
                }
            }
            5 -> println("Saliendo....")
            else -> {
                println(" Error! Digite nuevamente")
            }

        }
    }while (o1 != 5)
}