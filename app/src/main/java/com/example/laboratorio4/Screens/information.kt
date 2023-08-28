package com.example.laboratorio4.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio4.R


@Preview(showBackground = true)
@Composable
fun information(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
        item{
            val concertImage: Painter = painterResource(id = R.drawable.wos)
            Image(painter = concertImage, contentDescription = "Concierto",
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
                contentScale = ContentScale.Crop
            )
        }
    }
}