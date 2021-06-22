
package ar.edu.unahur.obj2.servidorWeb

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class ServidorWebTest : DescribeSpec({
  val pedido1 = Pedido("12.12.12.12", "http://unahur.edu.ar/campus.html", LocalDateTime.now())
  val pedido2 = Pedido("8.8.8.8", "https://unahur.edu.ar/informatica.docx", LocalDateTime.now())
  val servidor1 = ServidorWeb()
  val modulo1 = Modulo(listOf("html", "docx"), "hola que tal", 10)
  servidor1.agregarModulo(modulo1)
  describe("Un servidor web"){
    it("debe devolver 501 si el protocolo no es http"){
      servidor1.realizarPedido(pedido2).codigo.shouldBe(CodigoHttp.NOT_IMPLEMENTED)
    }
    it("debe devolver 200 si el protocolo es http"){
      servidor1.realizarPedido(pedido1).codigo.shouldBe(CodigoHttp.OK)
    }
  }
  describe("Un servidor web con modulos"){
    it("buscar si algun modulo responde al pedido"){
      servidor1.moduloQuePuedeResponder(pedido1).shouldBe(modulo1)
    }
  }
})