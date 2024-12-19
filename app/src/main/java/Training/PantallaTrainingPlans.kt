package com.example.ufc_proyecto.ui.general

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.R

class PantallaTrainingPlan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingPlanScreen(navController = rememberNavController())
        }
    }
}

@Composable
fun TrainingPlanScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // App Bar (UFC logo and notifications icon)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ufc), // Reemplaza con tu recurso de imagen UFC
                contentDescription = "UFC Logo",
                modifier = Modifier.size(40.dp)
            )

            IconButton(onClick = { /* Maneja el click en el icono de notificación */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notificar), // Reemplaza con tu ícono de notificación
                    contentDescription = "Notifications",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }

            IconButton(onClick = { /* Maneja el click en el icono de usuario */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.avatar1), // Reemplaza con tu ícono de usuario
                    contentDescription = "User Icon",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Título
        Text(
            text = "Training Plans",
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de planes de entrenamiento (con imágenes y textos)
//        TrainingPlanButton(
//            imageRes = R.drawable.golpeo, // Reemplaza con la imagen golpeoSaco.jpg
//            title = "Principiant",
//            onClick = { navController.navigate("Pantalla1") } // Redirige a Pantalla1
//        )
        Spacer(modifier = Modifier.height(16.dp))

        TrainingPlanButton(
            imageRes = R.drawable.paos, // Reemplaza con la imagen paos.jpg
            title = "Intermedium",
            onClick = { navController.navigate("Pantalla2") } // Redirige a Pantalla2
        )
        Spacer(modifier = Modifier.height(16.dp))

        TrainingPlanButton(
            imageRes = R.drawable.sparring, // Reemplaza con la imagen sparring.jpg
            title = "Professional",
            onClick = { navController.navigate("Pantalla3") } // Redirige a Pantalla3
        )
    }
}

@Composable
fun TrainingPlanButton(imageRes: Int, title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Ajustar el tamaño de la imagen para que se vea bien
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp), // Borde redondeado
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente para el botón
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)) // Asegura que la imagen tenga bordes redondeados
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(), // La imagen ocupa todo el botón
                contentScale = androidx.compose.ui.layout.ContentScale.Crop // La imagen cubre todo el botón
            )
            Text(
                text = title,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp) // Padding del texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingPlanScreen(navController = rememberNavController()) // Vista previa de la pantalla de planes de entrenamiento
}
