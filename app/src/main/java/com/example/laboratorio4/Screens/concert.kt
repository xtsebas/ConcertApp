package com.example.laboratorio4.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio4.R
import com.example.laboratorio4.login


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            concert()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun concert() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(4) { index ->
            val imageId = when (index) {
                0 -> R.drawable.wos
                1 -> R.drawable.molotov
                2 -> R.drawable.montaner
                else -> R.drawable.wos
            }
            val name = when (index) {
                0 -> "Wos"
                1 -> "Molotov"
                2 -> "Ricardo Montaner"
                else -> "Artista desconocido"
            }
            ConcertCard(imageId = imageId, artistName = name, place = "Majadas")
        }
    }
}

@Composable
fun ConcertCard(imageId: Int, artistName: String, place: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val concertImage: Painter = painterResource(id = imageId)
            Image(painter = concertImage, contentDescription = "Concierto")

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = artistName,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = place,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}





