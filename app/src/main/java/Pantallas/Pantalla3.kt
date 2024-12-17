package com.example.ufc_finalproyect.ui.theme

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Pantalla3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var auth = FirebaseAuth.getInstance() // Obtener instancia de FirebaseAuth
            LoginScreen(navController = rememberNavController())
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current
    val estadoErrorMensaje = remember { mutableStateOf<String?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo con la imagen octogono.jpg
        Image(
            painter = painterResource(id = R.drawable.octogono),  // Imagen de fondo
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .background(Color(0xAAFFFFFF), shape = RoundedCornerShape(20.dp)) // Fondo blanco con bordes redondeados
                .padding(24.dp) // Espaciado interior
        ) {
            TextFieldWithIcon(value = email.value, onValueChange = { email.value = it }, placeholder = "Email", icon = R.drawable.avatar1)
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldWithIcon(value = password.value, onValueChange = { password.value = it }, placeholder = "Password", isPassword = true, icon = R.drawable.candado)
            Spacer(modifier = Modifier.height(24.dp))

            // Mostrar mensaje de error si existe
            estadoErrorMensaje.value?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            // Botones para registro e inicio de sesión
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { loginUser(email.value, password.value, navController, context, estadoErrorMensaje) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Log In")
                }

                Button(
                    onClick = { registerUser(email.value, password.value, context, estadoErrorMensaje) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Sign In")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcon(value: String, onValueChange: (String) -> Unit, placeholder: String, isPassword: Boolean = false, icon: Int) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier.size(24.dp)  // Ajustar tamaño del icono
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xAAFFFFFF)  // Fondo semitransparente para los campos de texto
        )
    )
}

fun registerUser(email: String, password: String, context: Context, estadoErrorMensaje: MutableState<String?>) {
    if (email.isNotEmpty() && password.isNotEmpty()) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                    Toast.makeText(context, "Registration successful. Welcome ${user?.email}", Toast.LENGTH_SHORT).show()
                    estadoErrorMensaje.value = null
                } else {
                    estadoErrorMensaje.value = "Registration failed: ${task.exception?.message}"
                }
            }
    } else {
        estadoErrorMensaje.value = "Please fill in both fields"
    }
}

fun loginUser(email: String, password: String, navController: NavController, context: Context, estadoErrorMensaje: MutableState<String?>) {
    if (email.isEmpty() || password.isEmpty()) {
        estadoErrorMensaje.value = "Please fill in both fields"
        return
    }

    // Validación de formato de correo electrónico
    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        estadoErrorMensaje.value = "Please enter a valid email address."
        return
    }

    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate("Pantalla4") // Redirige a la Pantalla4
                estadoErrorMensaje.value = null
            } else {
                val error = task.exception?.message ?: "Login failed"
                estadoErrorMensaje.value = error
            }
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen(navController = rememberNavController())  // Pasar el navController a la vista previa
}
