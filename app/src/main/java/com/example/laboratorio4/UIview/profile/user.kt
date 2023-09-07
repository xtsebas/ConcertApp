package com.example.laboratorio4.UIview.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.R

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            User()
        }
    }
}

val first= user("Sebastian", "huertas")
@Preview(showBackground = true)
@Composable
fun User(){
    userlist.addUser(first)
    val users= userlist.userList
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fondo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(182.dp)
                            .background(Color.Gray, shape = CircleShape)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = users[0].name.first().toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 70.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = users[0].name + " " + users[0].lastName,
                fontSize = 20.sp,
                color = Color.Black
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
        }

        item{
            Row() {
                Image(painter = painterResource(id = R.drawable.iconuser), contentDescription = "user",
                    modifier = Modifier
                        .padding(10.dp)
                        .width(22.dp)
                        .height(22.dp))
                ProfileMenuItem("Edit Profile")
            }
            Row() {
                Image(painter = painterResource(id = R.drawable.lock), contentDescription = "lock",
                    modifier = Modifier
                        .padding(10.dp)
                        .width(22.dp)
                        .height(22.dp))
                ProfileMenuItem("Reset Password")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Image(painter = painterResource(id = R.drawable.notification), contentDescription = "user",
                    modifier = Modifier
                        .padding(10.dp)
                        .width(22.dp)
                        .height(22.dp))
                ProfileMenuItem("Notification")

            }
            Row() {
                Image(painter = painterResource(id = R.drawable.favorite), contentDescription = "user",
                    modifier = Modifier
                        .padding(10.dp)
                        .width(22.dp)
                        .height(22.dp))
                ProfileMenuItem("Favorites")
            }
        }
    }
}

@Composable
fun ProfileMenuItem(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.padding(start = 8.dp)
        )
        if (title == "Notification"){
            Button(
                onClick = {
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Enable")
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}