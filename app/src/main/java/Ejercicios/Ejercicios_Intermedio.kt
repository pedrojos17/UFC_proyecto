package Pantallas_Ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

class Pantalla_ejercicios2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioI(navController = rememberNavController())  // Llamamos a la pantalla de ejercicios
        }
    }
}

@Composable
fun EjercicioI(navController: NavController) {
    val ejercicios = listOf(
        mapOf("nombre" to "Ganchos al cuerpo", "repeticiones" to 100, "series" to 3),
        mapOf("nombre" to "Croches de izquierda", "repeticiones" to 100, "series" to 3),
        mapOf("nombre" to "Patadas circulares altas", "repeticiones" to 60, "series" to 4),
        mapOf("nombre" to "Rodillazos en el saco", "repeticiones" to 40, "series" to 3),
        mapOf("nombre" to "Clinches y derribos", "repeticiones" to 30, "series" to 4),
        mapOf("nombre" to "Patadas frontales", "repeticiones" to 50, "series" to 4),
        mapOf("nombre" to "Combinación 1-2-3", "repeticiones" to 80, "series" to 3),
        mapOf("nombre" to "Uppercuts", "repeticiones" to 75, "series" to 3),
        mapOf("nombre" to "Golpes en sombra", "repeticiones" to 60, "series" to 4),
        mapOf("nombre" to "Derribo de doble pierna", "repeticiones" to 20, "series" to 4)
    )

    var currentExerciseIndex by remember { mutableStateOf(0) }
    var currentSeries by remember { mutableStateOf(ejercicios[currentExerciseIndex]["series"] as Int) }
    var isResting by remember { mutableStateOf(false) }
    var restTime by remember { mutableStateOf(60) }
    var isCompleted by remember { mutableStateOf(false) }

    val currentExercise = ejercicios[currentExerciseIndex]
    val nombre = currentExercise["nombre"] as String
    val repeticiones = currentExercise["repeticiones"] as Int

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.cuadrilatero), // Fondo decorativo
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        if (isCompleted) {
            // Mensaje final cuando la rutina se completa
            Text(
                text = "¡Enhorabuena! Has completado la rutina.",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )

            // Regresa a la pantalla anterior después de 3 segundos
            LaunchedEffect(isCompleted) {
                kotlinx.coroutines.delay(3000)
                navController.popBackStack()
            }
        } else {
            // Caja que muestra la información del ejercicio
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.8f)
                    .height(260.dp)
                    .background(Color.White.copy(alpha = 0.7f), shape = RoundedCornerShape(16.dp))
                    .padding(24.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = nombre, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
                    Text(text = "Repeticiones: $repeticiones", style = TextStyle(fontSize = 18.sp))
                    Text(text = "Series restantes: $currentSeries", style = TextStyle(fontSize = 18.sp))

                    if (isResting) {
                        Text(
                            text = "Tiempo de descanso: $restTime segundos",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                if (currentExerciseIndex > 0) {
                                    currentExerciseIndex--
                                    currentSeries = ejercicios[currentExerciseIndex]["series"] as Int
                                }
                                isResting = false
                                restTime = 60
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Anterior")
                        }

                        Button(
                            onClick = {
                                if (isResting) {
                                    isResting = false
                                } else {
                                    if (currentSeries > 1) {
                                        currentSeries--
                                        isResting = true
                                        restTime = 60
                                    } else if (currentExerciseIndex < ejercicios.size - 1) {
                                        currentExerciseIndex++
                                        currentSeries = ejercicios[currentExerciseIndex]["series"] as Int
                                        isResting = true
                                        restTime = 180
                                    } else {
                                        isCompleted = true
                                    }
                                }
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Siguiente")
                        }
                    }
                }
            }
        }

        if (isResting) {
            LaunchedEffect(restTime) {
                if (restTime > 0) {
                    kotlinx.coroutines.delay(1000L)
                    restTime--
                } else {
                    if (currentSeries > 1) {
                        currentSeries--
                    } else if (currentExerciseIndex < ejercicios.size - 1) {
                        currentExerciseIndex++
                        currentSeries = ejercicios[currentExerciseIndex]["series"] as Int
                    }
                    isResting = false
                    restTime = if (currentExerciseIndex == ejercicios.size - 1) 0 else 60
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EjercicioI(navController = rememberNavController())
}
