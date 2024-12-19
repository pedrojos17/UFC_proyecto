package Pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
            .background(Color.White)
    ) {
        // App Bar
        TopBar()

        // Store title
        Text(
            text = "Store",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 40.dp).offset(40.dp)
        )

        // Buttons with images
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // First Button: Training Plans
            StoreButton(
                imageRes = R.drawable.nate,
                text = "Principiante",
                onClick = { navController.navigate("Ejercicios_Principiantes") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Second Button: Supplements Plan
            StoreButton(
                imageRes = R.drawable.mcgregor,
                text = "Intermedio",
                onClick = { navController.navigate("Ejercicios_Intermedio") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Third Button: Diet Plan
            StoreButton(
                imageRes = R.drawable.cuadrilatero,
                text = "Avanzado",
                onClick = { /* Handle click for Diet Plan */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fourth Button: Meal Plan
            StoreButton(
                imageRes = R.drawable.jon,
                text = "Profesional",
                onClick = { /* Handle click for Meal Plan */ }
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), // Añade un tamaño fijo para las imágenes
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo Image on the left (larger size)
        Image(
            painter = painterResource(id = R.drawable.ufc),
            contentDescription = "UFC Logo",
            modifier = Modifier
                .size(40.dp) // Tamaño explícito para la imagen
                .offset(40.dp) // Larger logo size
        )

        // Icons (Bell and User) on the right with extra space
        Row(
            modifier = Modifier.padding(end = 20.dp) // Adding padding to separate from right edge
        ) {
            IconButton(onClick = { /* Handle Bell Icon Click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notificar),
                    contentDescription = "Bell Icon",
                    modifier = Modifier.size(30.dp), // Tamaño explícito del icono
                    tint = Color.Black
                )
            }
            IconButton(onClick = { /* Handle User Icon Click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.avatar1),
                    contentDescription = "User Icon",
                    modifier = Modifier.size(30.dp), // Tamaño explícito del icono
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
            .padding(bottom = 16.dp), // Espacio entre los botones
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente para el botón
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent) // Fondo transparente para el botón
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Store Image",
                modifier = Modifier
                    .fillMaxSize() // La imagen ocupa todo el botón
                    .clip(RoundedCornerShape(16.dp)), // Bordes redondeados para la imagen
                contentScale = androidx.compose.ui.layout.ContentScale.Crop // La imagen cubre todo el botón
            )
            Text(
                text = text,
                style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.BottomStart) // Alinea el texto en la parte inferior izquierda
                    .padding(16.dp) // Padding del texto
            )
        }
    }
}


// Preview for the screen
@Preview(showBackground = true)
@Composable
fun StorePreview() {
    StoreContent(navController = rememberNavController())
}
