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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ufc_proyecto.R
import com.google.firebase.auth.FirebaseAuth

class Pantalla3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(rememberNavController())
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") } // Campo de texto para el email
    val password = remember { mutableStateOf("") } // Campo de texto para la contraseña
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.octogono),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        // Contenedor principal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .background(Color(0xAAFFFFFF), RoundedCornerShape(20.dp))
                .padding(24.dp)
        ) {
            // Campo para ingresar el email
            CustomTextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = "Email",
                icon = R.drawable.avatar1
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo para ingresar la contraseña
            CustomTextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = "Password",
                isPassword = true,
                icon = R.drawable.candado
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botones de acción: Log In y Sign In
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { login(email.value, password.value, navController, context) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Log In")
                }

                Button(
                    onClick = { register(email.value, password.value, context) },
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
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    icon: Int
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp) // Ajustar el tamaño de las imágenes a 20.dp
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xAAFFFFFF)
        )
    )
}

// Función para registrar un usuario
fun register(email: String, password: String, context: Context) {
    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            Toast.makeText(context, if (task.isSuccessful) "Registro exitoso" else "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
        }
}

// Función para iniciar sesión
fun login(email: String, password: String, navController: NavController, context: Context) {
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) navController.navigate("Pantalla4")
            else Toast.makeText(context, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen(navController = rememberNavController()) }
