package com.example.ufc_proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.ui.theme.ClassNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ClassNavigator(navController) // Configuración de navegación
        }
    }
}


@Composable
fun PantallaInicio(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fondo negro
    ) {
        // Título "KnockoutFit"
        Text(
            text = "KnockoutFit",
            color = Color.White,
            style = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp) // Padding superior
        )

        // Imagen en el centro de la pantalla
        Image(
            painter = painterResource(id = R.drawable.ufc), // Asegúrate de tener la imagen ufc en res/drawable
            contentDescription = "UFC Logo",
            modifier = Modifier
                .align(Alignment.Center) // Centrar la imagen
                .size(1000.dp) // Tamaño de la imagen
        )

        // Botón "Get Started"
        Button(
            onClick = { navController.navigate("pantalla1") }, // Navega a pantalla1
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 70.dp) // Padding inferior
                .fillMaxWidth(0.8f) // Botón ocupa el 80% del ancho
                .height(60.dp) // Altura del botón
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp) // Tamaño del texto
            )
        }
    }
}

// Preview para visualizar en Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaInicioPreview() {
    val fakeNavController = rememberNavController() // Controlador de navegación falso para la vista previa
    PantallaInicio(navController = fakeNavController)
}
