package com.example.laboratorio4.UIview.Concerts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            concert()
        }
    }
}

class ConcertList private constructor() {
    private val list= mutableListOf<event>()
    fun addConcert(event: event){
        list.add(event)
    }

    fun getConcerts(): List<event>{
        return list.toList()
    }
    companion object {
        @Volatile
        private var instance: ConcertList? = null

        fun getInstance(): ConcertList {
            return instance ?: synchronized(this) {
                instance ?: ConcertList().also { instance = it }
            }
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
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2196F3))
                    .padding(vertical = 16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Todos los eventos",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        val conciertos: MutableList<event> = mutableListOf();
        items(4) { index ->
                val imageId = when (index) {
                    0 -> R.drawable.wos
                    1 -> R.drawable.molotov
                    2 -> R.drawable.montaner
                    3 -> R.drawable.young
                    else -> R.drawable.wos
                }
                val name = when (index) {
                    0 -> "Wos"
                    1 -> "Molotov"
                    2 -> "Ricardo Montaner"
                    3 -> "Young Miko"
                    else -> "Artista desconocido"
                }
                val concert = event(imageId = imageId, artistName = name, place = "Majadas")
                val concertlist = ConcertList.getInstance()
                concertlist.addConcert(concert)
                ConcertCard(event = concert)
        }
    }
}

@Composable
fun addConcert(): List<event> {
    val conciertos = ConcertList.getInstance()
    for (i in 0 until 5){
        val imageId = when (i) {
            0 -> R.drawable.wos
            1 -> R.drawable.molotov
            2 -> R.drawable.montaner
            3 -> R.drawable.young
            else -> R.drawable.wos
        }
        val name = when (i) {
            0 -> "Wos"
            1 -> "Molotov"
            2 -> "Ricardo Montaner"
            3-> "Young Miko"
            else -> "Artista desconocido"
        }
        val concert = event(imageId = imageId, artistName = name, place = "Majadas")
        conciertos.addConcert(concert)
    }
    return conciertos.getConcerts()
}

public data class event(val imageId: Int, val artistName: String, val place: String)

@Composable
fun event.toConcertCard() {
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

@Composable
fun ConcertCard(event: event) {
    event.toConcertCard()
}