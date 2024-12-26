package Pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.R

class Pantalla4(navHostController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreContent(navController = rememberNavController())
        }
    }
}

@Composable
fun StoreContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco de la pantalla
    ) {
        // Barra superior con logo e iconos
        TopBar()

        // Título de la sección "Store"
        Text(
            text = "Store",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 40.dp)
                .offset(40.dp)
        )

        // Botones con imágenes para las opciones
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            StoreButton(
                imageRes = R.drawable.nate,
                text = "Principiante",
                onClick = { navController.navigate("Ejercicios_Principiantes") } // Navega a ejercicios principiantes
            )

            Spacer(modifier = Modifier.height(16.dp))

            StoreButton(
                imageRes = R.drawable.mcgregor,
                text = "Intermedio",
                onClick = { navController.navigate("Ejercicios_Intermedio") } // Navega a ejercicios intermedios
            )

            Spacer(modifier = Modifier.height(16.dp))

            StoreButton(
                imageRes = R.drawable.cuadrilatero,
                text = "Avanzado",
                onClick = { navController.navigate("Ejercicios_Avanzados") } // Navega a ejercicios avanzados
            )

            Spacer(modifier = Modifier.height(16.dp))

            StoreButton(
                imageRes = R.drawable.jon,
                text = "Profesional",
                onClick = { navController.navigate("Ejercicios_Profesional") } // Navega a ejercicios profesionales
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), // Altura fija para la barra superior
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo del lado izquierdo
        Image(
            painter = painterResource(id = R.drawable.ufc),
            contentDescription = "UFC Logo",
            modifier = Modifier
                .size(40.dp) // Tamaño del logo
                .offset(40.dp) // Espaciado desde el borde izquierdo
        )

        // Iconos de notificaciones y usuario en la derecha
        Row(
            modifier = Modifier.padding(end = 20.dp) // Espaciado desde el borde derecho
        ) {
            IconButton(onClick = { /* Acción del icono de notificación */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notificar),
                    contentDescription = "Bell Icon",
                    modifier = Modifier.size(30.dp), // Tamaño del icono
                    tint = Color.Black
                )
            }
            IconButton(onClick = { /* Acción del icono de usuario */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.avatar1),
                    contentDescription = "User Icon",
                    modifier = Modifier.size(30.dp), // Tamaño del icono
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun StoreButton(imageRes: Int, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp) // Altura del botón
            .padding(bottom = 16.dp), // Espaciado entre botones
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent) // Fondo transparente
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Store Image",
                modifier = Modifier
                    .fillMaxSize() // La imagen ocupa todo el botón
                    .clip(RoundedCornerShape(16.dp)), // Bordes redondeados
                contentScale = androidx.compose.ui.layout.ContentScale.Crop // La imagen se ajusta al tamaño del botón
            )
            Text(
                text = text,
                style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.BottomStart) // Texto en la parte inferior izquierda
                    .padding(16.dp) // Espaciado del texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StorePreview() {
    StoreContent(navController = rememberNavController())
}
