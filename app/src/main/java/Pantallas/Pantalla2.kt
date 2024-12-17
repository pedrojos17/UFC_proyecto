package Pantallas

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.ufc_proyecto.R

// Pantalla 2
@Composable
fun Pantalla2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111)) // Fondo oscuro
    ) {
        Image(
            painter = painterResource(id = R.drawable.israel), // Imagen de fondo
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(60f)) // Espacio para el título

            Text(
                text = "Training",
                color = Color.White,
                style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.offset(15.dp)
            )

            Text(
                text = "KnockoutFit enhances your fighting skills and endurance through high-intensity training.",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp, lineHeight = 24.sp),
                modifier = Modifier.padding(top = 10.dp).offset(15.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 167.dp, top = 20.dp)
            ) {
                Text(
                    text = " • • ",
                    color = Color.White,
                    style = TextStyle(fontSize = 30.sp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 45.dp)
            ) {
                Button(
                    onClick = { navController.navigate("Pantalla3") }, // Navegar a Pantalla3
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .width(180.dp)
                        .height(70.dp)
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = "Log In",
                        color = Color.Black,
                        style = TextStyle(fontSize = 20.sp)
                    )
                }

                OutlinedButton(
                    onClick = { navController.navigate("Pantalla3") }, // Navegar a Pantalla3
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    modifier = Modifier
                        .width(180.dp)
                        .height(70.dp)
                ) {
                    Text(
                        text = "Sign In",
                        color = Color.White,
                        style = TextStyle(fontSize = 20.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla2Preview() {
    val navController = rememberNavController() // Crea un controlador de navegación para la vista previa
    Pantalla2(navController)  // Usando la función de Pantalla 2 para la vista previa
}
