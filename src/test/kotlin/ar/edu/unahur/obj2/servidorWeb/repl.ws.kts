import ar.edu.unahur.obj2.servidorWeb.Pedido
import ar.edu.unahur.obj2.servidorWeb.ServidorWeb
import java.time.LocalDateTime

val pedido1 = Pedido("12.12.12.12", "http://unahur.edu.ar/campus.html", LocalDateTime.now())
val pedido2 = Pedido("8.8.8.8", "https://unahur.edu.ar/informatica.jpg", LocalDateTime.now())
val servidor1 = ServidorWeb()

pedido1.url.substringBeforeLast(".")