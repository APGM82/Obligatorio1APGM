import kotlin.random.Random

fun main(args: Array<String>) {
    Tet.meterDron()
    var auxArray:ArrayList<Any> = ArrayList()
    var auxArray2:ArrayList<Any> = ArrayList()
    var tierra:ArrayList<ArrayList<Any>> = ArrayList()
    var fila1:ArrayList<Any> = ArrayList(3)
    var fila2:ArrayList<Any> = ArrayList(3)
    var fila3:ArrayList<Any> = ArrayList(3)

    tierra.add(fila1)
    tierra.add(fila2)
    tierra.add(fila3)

    var time:Int=0
    var r:Int=Random.nextInt(0,2)
    var r2:Int=Random.nextInt(1,5)
    var descAz:Int=Random.nextInt(1,3)
    var desc:String= when(descAz){
        1 -> "Vegetal"
        2 -> "Animal"
        3 -> "Radiacion"
        else -> "Sin nombre"
    }
    //var s:Int=0
    var contadorMisiones=0;
    for (i in 0..2){
        for (j in 0..2){
            var Ja:Persona = Factoria.generarJack()
            var Vi:Persona = Factoria.generarVika()
            auxArray.add(Ja)
            auxArray.add(Vi)
            for (i in 0..r){
                if (Tet.arrayDron.size!=0){
                    auxArray.add(Tet.arrayDron[0])
                    Tet.arrayDron.removeAt(0)
                }
            }
            if (i==0){
                for (g in 0..auxArray.size-1){
                    auxArray2.add(auxArray[g])
                }
                fila1.add(auxArray2)
                for (g in 0..auxArray.size-1){
                    auxArray.removeAt(0)
                }
            }
            if (i==1){
                fila2.add(auxArray)
                //for (g in 0..auxArray.size-1){
                    //auxArray.removeAt(0)
                //}
            }
            if (i==2){
                fila3.add(auxArray)
                //for (g in 0..auxArray.size-1){
                    //auxArray.removeAt(0)
                //}
            }
        }

    }
    tierra.add(fila1)
    tierra.add(fila2)
    tierra.add(fila3)




    do {
        if (time%4==0){
            for (i in 0..2){
                for(j in 0..2){
                    var aux:ArrayList<Any>
                    aux= tierra[i][j] as ArrayList<Any>
                    for (k in 0..6){
                        if (aux[k] is Dron){
                            var d:Dron= aux[k] as Dron
                            if (d.estado==false){
                                if (r2==1){
                                    d.estado=true
                                }
                            }
                        }
                    }
                }
            }
        }
        if (time%10==0){
            for (i in 0..2){
                for (j in 0..2){
                    var aux:ArrayList<Any> = ArrayList()
                    aux= tierra[i][j] as ArrayList<Any>
                    for (k in 0..6){
                        if (aux[k] is Dron){
                            var d:Dron= aux[k] as Dron
                            if (d.estado==true){
                                var t:Reparacion = Tet.generarOrdenRepara()
                                t.destino= ""+i+","+j
                                aux.add(t)
                            }
                        }
                        var auxb:Boolean=false;
                        if (aux[k] is Reconocimiento){
                            println("Ya se ha establecido una orden de reconocimiento")
                            auxb=true
                        }
                        if (auxb==true){
                            var t:Reconocimiento= Tet.generarOrdenReco()
                            t.destino= "$i,$j"
                            aux.add(t)
                        }
                    }
                }
            }
        }
        var p:Boolean=false
        if(time%20==0){
            for (i in 0..2){
                for(j in 0..2){
                    var aux:ArrayList<Any> = ArrayList()
                    aux= tierra[i][j] as ArrayList<Any>
                    for (k in 0..6){
                        if (aux[k] is Orden){
                            if (aux[k] is Reparacion){
                                var d:Reparacion= aux[k] as Reparacion
                                if (Random.nextInt(0,1)==0){
                                    d.completada=true
                                    Tet.ArrayOrdenes.add(d)
                                    contadorMisiones++
                                }else{
                                    for (k in 0..6){
                                        if (aux[k] is Dron && p==false){
                                            var d:Dron= aux[k] as Dron
                                            if (d.estado==true){
                                                aux.removeAt(k)
                                                if (Tet.arrayDron.size!=0){
                                                    auxArray.add(Tet.arrayDron[0])
                                                    Tet.arrayDron.removeAt(0)

                                                    p=true
                                                }
                                            }
                                        }
                                    }
                                    Tet.ArrayOrdenes.add(d)
                                }
                            }
                            if (aux[k] is Reconocimiento){
                                var d:Reconocimiento= aux[k] as Reconocimiento
                                d.completada=true
                                d.descripcion=desc
                                Tet.ArrayOrdenes.add(d)
                                contadorMisiones++
                                d.resumenOrden()
                            }
                        }
                    }
                }
            }
        }

        time++
    }while (time<1000)
    println("Se han completado "+contadorMisiones+" órdenes")
    println(tierra[0])
    println("Han pasado $time segundos")



//rellenar tet, crear 200 drones--builder
    //rellenar cuadrantes con:
        //Dron del tet(-1)
        //enviar 1 jack y una vika(nombre se ajusta al cuadrante)
    //cada 4 segundos se recorren los cuadrantes y:
        //for cada dron en el cuadrante:
            //20% de las veces dron pasa a estar estropeado(dron.estropeado=true)
    //cada 10 segundos se recorren los cuadantes y:
        //se envian ordenes a cada cuadrante y se catalogan como pendientes de hacer
            //ordenes de reparacion
            //ordenes de observación(entre 5 y 10? no lo entiendo)
            //tet.guardarcopias
    //cada 20 segundosse resuelven las ordenes:
        //if si es reparación:
            //50% (dron.estropeado=false)
        //else
            //50%(dron.borrar)
            //if tet.array de drones.legth>0 pedir otro al tet
        //marcar como completada (Orden.completada=true)
    //Si es de Observación:
        //reconocimiento.descripcion (random 3: vegetal, animal o radiación.
        //marcar como completada (Orden.completada=true)





}