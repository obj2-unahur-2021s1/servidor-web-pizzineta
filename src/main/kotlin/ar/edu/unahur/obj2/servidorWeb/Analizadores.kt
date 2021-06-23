package ar.edu.unahur.obj2.servidorWeb

abstract class Analizador {
    val respuestas = mutableListOf<Respuesta>()
    val modulos = mutableListOf<Modulo>()
}

class DeteccionDeDemoraEnRespuesta: Analizador() {


}

class IpSospechosa: Analizador() {

}

class Estadistica: Analizador() {

}