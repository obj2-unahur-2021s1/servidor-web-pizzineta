
package ar.edu.unahur.obj2.servidorWeb

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class ServidorWebTest : DescribeSpec({
  describe("Un servidor web"){
    val pedido1 = Pedido("12.12.12.12", "http://unahur.edu.ar/campus.html", LocalDateTime.now())
    val pedido2 = Pedido("8.8.8.8", "https://unahur.edu.ar/informatica.jpg", LocalDateTime.now())
    val servidor1 = ServidorWeb()

    it("debe devolver 501 si el protocolo no es http"){
      servidor1.realizarPedido(pedido2).codigo.shouldBe(CodigoHttp.NOT_IMPLEMENTED)
    }
    it("debe devolver 200 si el protocolo es http"){
      servidor1.realizarPedido(pedido1).codigo.shouldBe(CodigoHttp.OK)
    }
  }
})