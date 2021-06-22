package ar.edu.unahur.obj2.servidorWeb

import java.time.LocalDateTime

// Para no tener los códigos "tirados por ahí", usamos un enum que le da el nombre que corresponde a cada código
// La idea de las clases enumeradas es usar directamente sus objetos: CodigoHTTP.OK, CodigoHTTP.NOT_IMPLEMENTED, etc
enum class CodigoHttp(val codigo: Int) {
  OK(200),
  NOT_IMPLEMENTED(501),
  NOT_FOUND(404),
}

class Pedido(val ip: String, val url: String, val fechaHora: LocalDateTime){
  fun protocoloUrl() =
    url.substringBefore(":")
  fun extencionUrl() =
    url.substringAfterLast(".")

}
class Respuesta(val codigo: CodigoHttp, val body: String, val tiempo: Int, val pedido: Pedido)
class ServidorWeb{

  val modulos = mutableListOf<Modulo>()


  fun realizarPedido(unPedido: Pedido) =
    when{
      this.algunModuloPuedeResponder(unPedido) && (unPedido.protocoloUrl() == "http")->
      Respuesta(CodigoHttp.OK, this.moduloQuePuedeResponder(unPedido)!!.body, this.moduloQuePuedeResponder(unPedido)!!.tiempo, unPedido)
      this.algunModuloPuedeResponder(unPedido) && (unPedido.protocoloUrl() != "http") ->
        Respuesta(CodigoHttp.NOT_IMPLEMENTED, "", 10, unPedido)
      else ->
        Respuesta(CodigoHttp.NOT_FOUND, "", 10, unPedido)
      }


  fun agregarModulo(unModulo: Modulo) =
    modulos.add(unModulo)

  fun removerModulo(unModulo: Modulo) =
    modulos.remove(unModulo)

  fun moduloQuePuedeResponder(unPedido: Pedido) =
    modulos.find{ it.puedeResponder(unPedido) }

  fun algunModuloPuedeResponder(unPedido: Pedido) =
    modulos.any{ it.puedeResponder(unPedido) }
}