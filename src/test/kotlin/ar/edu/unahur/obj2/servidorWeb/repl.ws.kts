import ar.edu.unahur.obj2.servidorWeb.Modulo
import ar.edu.unahur.obj2.servidorWeb.Pedido
import ar.edu.unahur.obj2.servidorWeb.ServidorWeb
import java.time.LocalDateTime

val pedido1 = Pedido("12.12.12.12", "http://unahur.edu.ar/campus.html", LocalDateTime.now())
val pedido2 = Pedido("8.8.8.8", "https://unahur.edu.ar/informatica.docx", LocalDateTime.now())
val servidor1 = ServidorWeb()
val modulo1 = Modulo(listOf("html", "docx"), "hola que tal", 10)
servidor1.agregarModulo(modulo1)
servidor1.realizarPedido(pedido1).tiempo
