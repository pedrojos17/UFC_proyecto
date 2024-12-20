package navigator

import Pantallas.Pantalla1Content
import Pantallas.Pantalla2
import Pantallas.StoreContent
import Pantallas_Ejercicios.EjercicioI
import Pantallas_Ejercicios.EjercicioProfesional
import Pantallas_Ejercicios.Ejercicio_p
import Pantallas_Ejercicios.EjerciciosA
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ufc_finalproyect.ui.theme.LoginScreen
import Principal.PantallaInicio

@Composable
fun ClassNavigator(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "PantallaInicio"  // La pantalla de inicio es el punto de partida
    ) {
        // Pantalla de inicio
        composable("PantallaInicio") {
            PantallaInicio(navHostController)
        }

        // Pantalla 1
        composable("Pantalla1") {
            Pantalla1Content(navHostController)  // Contenido de la pantalla 1
        }

        // Pantalla 2
        composable("Pantalla2") {
            Pantalla2(navHostController) // Componente de Pantalla2
        }

        // Pantalla de Login
        composable("Pantalla3") {
            LoginScreen(navHostController) // Componente de LoginScreen
        }

        // Pantalla 4 (Pantalla a la que se redirige después de un login exitoso)
        composable("Pantalla4") {
            StoreContent(navHostController)  // Componente de la Pantalla4
        }
        composable("Ejercicios_Principiantes") {
            Ejercicio_p(navHostController)  // Componente de la Pantalla4
        }
        composable("Ejercicios_Intermedio") {
            EjercicioI(navHostController)  // Componente de la Pantalla4
        }
        composable("Ejercicios_Avanzados") {
            EjerciciosA(navHostController)  // Componente de la Pantalla4
        }
        composable("Ejercicios_Profesional") {
            EjercicioProfesional(navHostController)  // Componente de la Pantalla4
        }
    }
}