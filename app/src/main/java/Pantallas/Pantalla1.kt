package Pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.R

@Composable
fun Pantalla1Content(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111)) // Fondo oscuro
    ) {
        // Imagen de fondo que ocupa toda la pantalla
        Image(
            painter = painterResource(id = R.drawable.lyotomachida),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenedor principal con los elementos
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(60f)) // Espacio para empujar el título hacia abajo

            // Título principal
            Text(
                text = "Training",
                color = Color.White,
                style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.offset(15.dp)
            )

            // Descripción del contenido
            Text(
                text = "KnockoutFit enhances your fighting skills and endurance through high-intensity training.",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp, lineHeight = 24.sp),
                modifier = Modifier.padding(top = 10.dp).offset(15.dp)
            )

            // Puntos decorativos como separación
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

            Spacer(modifier = Modifier.weight(1f)) // Espacio para empujar los botones hacia abajo

            // Botones para "Log In" y "Sign In"
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 45.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate("Pantalla2") // Navega a Pantalla2
                    },
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
                    onClick = {
                        navController.navigate("Pantalla2") // También navega a Pantalla2
                    },
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Pantalla1Preview() {
    val fakeNavController = rememberNavController() // Controlador falso para la vista previa
    Pantalla1Content(navController = fakeNavController)
}
