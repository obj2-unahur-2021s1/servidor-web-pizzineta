package ar.edu.unahur.obj2.servidorWeb

class Modulo(val extensiones: List<String>, val body: String, val tiempo: Int) {
    fun puedeResponder(unPedido: Pedido) =
        extensiones.contains(unPedido.extencionUrl())
}