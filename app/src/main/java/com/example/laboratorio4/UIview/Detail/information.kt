package com.example.laboratorio4.UIview.Detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.R
import com.example.laboratorio4.UIview.Concerts.event

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            information(concert = event(R.drawable.wos, "Wos", "Majadas"))
        }
    }
}

@Composable
fun information(concert: event){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            val concertImage: Painter = painterResource(id = concert.imageId)
            Image(
                painter = concertImage,
                contentDescription = "Concierto",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 20f)
            )
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = concert.artistName,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = concert.place,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.CenterStart,
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.calendar),
                                    contentDescription = "Calendar",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(8.dp)
                                )
                            }
                            Text(text = "Fecha", color = Color.Black)
                            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre los elementos
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.watch),
                                    contentDescription = "reloj",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(8.dp)
                                )
                            }
                            Text(text = "Hora", color = Color.Black)
                        }
                    }
                )


                Text(text = "About",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight= FontWeight.Bold,
                        color = Color.Black
                    ))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sagittis nunc vitae eleifend iaculis. Maecenas ornare arcu erat, a tincidunt erat egestas eu. Aenean pretium lacinia ultrices. Donec eu aliquam tellus, eu consequat ante. Duis vehicula pretium lorem id condimentum. Sed nec erat id libero laoreet malesuada id eget justo. Quisque pulvinar a metus et tincidunt. Suspendisse vel iaculis sapien. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus feugiat tempor rutrum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam a ultricies dui, a condimentum tortor. Suspendisse rhoncus eros vitae lectus euismod pulvinar. Pellentesque ultricies purus quis metus vestibulum, et sagittis purus tempor.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                )
            }
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                    ) {
                        Text(text = "Favorite")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                    ) {
                        Text(text = "BUY")
                    }
                }
            }
        }
    }
}
