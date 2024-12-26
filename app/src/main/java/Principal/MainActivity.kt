package Principal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.ufc_proyecto.R
import navigator.ClassNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassNavigator(rememberNavController()) // Navegación principal
        }
    }
}

@Composable
fun PantallaInicio(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Título principal
        Text(
            text = "KnockoutFit",
            color = Color.White,
            style = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        )

        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.israfondo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(1000.dp)
        )

        // Botón para comenzar
        Button(
            onClick = { navController.navigate("pantalla1") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 70.dp)
                .fillMaxWidth(0.8f)
                .height(60.dp)
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PantallaInicioPreview() {
    PantallaInicio(navController = rememberNavController())
}
