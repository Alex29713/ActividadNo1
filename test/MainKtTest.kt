import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun testCrearCabina() {
        val listaCabinas = mutableListOf<String>()
        val preciosCabinas = mutableListOf<Int>()
        val llamadasCabinas = mutableListOf<Int>()

        // Acción: Crear una nueva cabina
        val nuevaCabina = "Cabina 1"
        listaCabinas.add(nuevaCabina)
        preciosCabinas.addAll(listOf(0, 0, 0))
        llamadasCabinas.addAll(listOf(0, 0, 0))

        // Comprobación: Verificar que la cabina fue creada correctamente
        assertEquals(1, listaCabinas.size)
        assertEquals("Cabina 1", listaCabinas[0])
        assertEquals(3, preciosCabinas.size)
        assertEquals(3, llamadasCabinas.size)
    }

    @Test
    fun testBorrarCabina() {
        val listaCabinas = mutableListOf("Cabina 1")
        val preciosCabinas = mutableListOf(0, 0, 0)
        val llamadasCabinas = mutableListOf(0, 0, 0)

        // Acción: Borrar la cabina
        val borrarCabina = 1
        if (borrarCabina in 1..listaCabinas.size) {
            val index = (borrarCabina - 1) * 3
            listaCabinas.removeAt(borrarCabina - 1)
            for (i in 0..2) {
                preciosCabinas.removeAt(index)
                llamadasCabinas.removeAt(index)
            }
        }

        // Comprobación: Verificar que la cabina fue borrada correctamente
        assertTrue(listaCabinas.isEmpty())
        assertTrue(preciosCabinas.isEmpty())
        assertTrue(llamadasCabinas.isEmpty())
    }

    @Test
    fun testRealizarLlamadaLocal() {
        val listaCabinas = mutableListOf("Cabina 1")
        val preciosCabinas = mutableListOf(0, 0, 0)
        val llamadasCabinas = mutableListOf(0, 0, 0)

        val o2 = 1 // Seleccionar la primera cabina
        val min = 10 // Simulación de minutos

        // Acción: Realizar una llamada local
        val local = 50
        preciosCabinas[3 * (o2 - 1)] += min * local
        llamadasCabinas[3 * (o2 - 1)] += 1

        // Comprobación: Verificar que los valores se actualizaron correctamente
        assertEquals(500, preciosCabinas[0])
        assertEquals(1, llamadasCabinas[0])
    }

    @Test
    fun testRealizarLlamadaDistancia() {
        val listaCabinas = mutableListOf("Cabina 1")
        val preciosCabinas = mutableListOf(0, 0, 0)
        val llamadasCabinas = mutableListOf(0, 0, 0)

        val o2 = 1 // Seleccionar la primera cabina
        val min = 20 // Simulación de minutos

        // Acción: Realizar una llamada de larga distancia
        val distancia = 350
        preciosCabinas[3 * (o2 - 1) + 1] += min * distancia
        llamadasCabinas[3 * (o2 - 1) + 1] += 1

        // Comprobación: Verificar que los valores se actualizaron correctamente
        assertEquals(7000, preciosCabinas[1])
        assertEquals(1, llamadasCabinas[1])
    }

    @Test
    fun testRealizarLlamadaCelular() {
        val listaCabinas = mutableListOf("Cabina 1")
        val preciosCabinas = mutableListOf(0, 0, 0)
        val llamadasCabinas = mutableListOf(0, 0, 0)

        val o2 = 1 // Seleccionar la primera cabina
        val min = 15 // Simulación de minutos

        // Acción: Realizar una llamada a celular
        val celular = 150
        preciosCabinas[3 * (o2 - 1) + 2] += min * celular
        llamadasCabinas[3 * (o2 - 1) + 2] += 1

        // Comprobación: Verificar que los valores se actualizaron correctamente
        assertEquals(2250, preciosCabinas[2])
        assertEquals(1, llamadasCabinas[2])
    }

    @Test
    fun testFormatearInformacion() {
        val listaCabinas = mutableListOf("Cabina 1")
        val preciosCabinas = mutableListOf(1000, 2000, 3000)
        val llamadasCabinas = mutableListOf(10, 20, 30)

        val o2 = 1 // Seleccionar la primera cabina
        if (o2 in 1..listaCabinas.size) {
            val index = 3 * (o2 - 1)
            for (i in 0..2) {
                preciosCabinas[index + i] = 0
                llamadasCabinas[index + i] = 0
            }
        }

        // Comprobación: Verificar que la información se formateó correctamente
        assertEquals(0, preciosCabinas[0])
        assertEquals(0, preciosCabinas[1])
        assertEquals(0, preciosCabinas[2])
        assertEquals(0, llamadasCabinas[0])
        assertEquals(0, llamadasCabinas[1])
        assertEquals(0, llamadasCabinas[2])
    }
}
