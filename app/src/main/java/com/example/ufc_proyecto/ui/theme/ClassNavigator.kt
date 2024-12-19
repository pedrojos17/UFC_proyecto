package com.example.ufc_proyecto.ui.theme

import Pantallas.Pantalla1Content
import Pantallas.Pantalla2
import Pantallas.StoreContent
//import Pantallas_Ejercicios.EjercicioScreen
//import Pantallas_Ejercicios.Pantalla_ejercicios2
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
//        composable("Pantalla_ejercicios1") {
//            EjercicioScreen(navHostController)  // Componente de la Pantalla4
//        }
//        composable("Pantalla_ejercicios2") {
//            Pantalla_ejercicios2(navHostController)  // Componente de la Pantalla4
//        }
    }
}