package ar.edu.unahur.obj2.servidorWeb

abstract class Analizador {
    val moduloYRespuestaAsignadosxServidorWeb = mutableMapOf<Modulo, MutableList<Respuesta>>()
}

class DeteccionDeDemoraEnRespuesta: Analizador() {


}

class IpSospechosa: Analizador() {

}

class Estadistica: Analizador() {

}