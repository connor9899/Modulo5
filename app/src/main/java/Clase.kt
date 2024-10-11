class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: Usuario? = null
) {

    override fun toString(): String {
        val sb = StringBuilder("$nombre ($edad años)")
        if (trabajo != null) sb.append(", $trabajo")
        if (referencia != null) sb.append(", referido por ${referencia.nombre}")
        return sb.toString()
    }


}

 class GestorUsuarios{

     private val usuarios = mutableListOf<Usuario>()

     fun agregarUsuario(usuario: Usuario) {
         usuarios.add(usuario)
         println("Usuario ${usuario.nombre} agregado.")
     }


     fun eliminarUsuario(nombre: String) {
         val usuario = usuarios.find { it.nombre == nombre }
         if (usuario != null) {
             usuarios.remove(usuario)
             println("Usuario $nombre eliminado.")
         } else {
             println("Usuario $nombre no encontrado.")
         }
     }

     fun mostrarLista() {
         if (usuarios.isEmpty()) {
             println("La lista de usuarios está vacía.")
         } else {
             println("Lista de usuarios:")
             usuarios.forEachIndexed { index, usuario ->
                 println("${index + 1}. $usuario")
             }
         }
         println()
     }

     fun filtrarPorEdadMayor(edad: Int): List<Usuario> {
         return usuarios.filter { it.edad > edad }
     }

     fun mostrarUsuariosFiltrados(edad: Int) {
         val usuariosFiltrados = filtrarPorEdadMayor(edad)
         println("Usuarios mayores de $edad años:")
         usuariosFiltrados.forEach { usuario ->
             println("${usuario.nombre}: ${usuario.edad} años")
         }
         println()
     }
 }

fun main() {

    val gestor = GestorUsuarios()
    val usuario1 = Usuario("Ana", 28, "Ingeniera")
    val usuario2 = Usuario("Carlos", 35, "Profesor", usuario1)
    val usuario3 = Usuario("María", 22)


    gestor.agregarUsuario(usuario1)
    gestor.agregarUsuario(usuario2)
    gestor.agregarUsuario(usuario3)

    println("Lista completa de usuarios:")
    gestor.mostrarLista()

    gestor.mostrarUsuariosFiltrados(30)

}

