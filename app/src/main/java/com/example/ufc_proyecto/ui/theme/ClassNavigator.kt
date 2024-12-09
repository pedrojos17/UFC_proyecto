package com.example.ufc_proyecto.ui.theme

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ufc_proyecto.PantallaInicio

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
            Pantalla4(navHostController)  // Componente de la Pantalla4
        }
    }
}