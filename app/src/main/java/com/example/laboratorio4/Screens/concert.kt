package com.example.laboratorio4.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@Preview(showBackground = true)
@Composable
fun concert() {
    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ConcertCard(
                imageId = R.drawable.wos,
                artistName = "Wos"
            )
            Spacer(modifier = Modifier.width(16.dp))
            ConcertCard(
                imageId = R.drawable.molotov,
                artistName = "Molotov"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ConcertCard(
                imageId = R.drawable.montaner,
                artistName = "Ricardo Montaner"
            )
            Spacer(modifier = Modifier.width(16.dp))
            ConcertCard(
                imageId = R.drawable.wos,
                artistName = "Wos"
            )
        }
    }
}

@Composable
fun ConcertCard(imageId: Int, artistName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            val concertImage: Painter = painterResource(id = imageId)
            Image(painter = concertImage, contentDescription = "Concierto")

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = artistName,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(text = "Concierto")
            }
        }
    }
}




