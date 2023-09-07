package com.example.laboratorio4.UIview.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }
}
data class user(val name: String, val lastName: String)

object userlist {
    val userList = mutableListOf<user>()
    fun addUser(user: user) {
        userList.add(user)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun login() {
    var username by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var showMessage = false

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nombre") },
            modifier = Modifier.padding(top = 16.dp)
        )

        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Apellido") },
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(
            onClick = {
                val user = user(name = username, lastName = lastName)
                userlist.addUser(user = user)
                showMessage = true
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Registarse")
        }

    }
}