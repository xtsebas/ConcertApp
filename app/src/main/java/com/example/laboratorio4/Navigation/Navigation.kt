package com.example.laboratorio4.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.R
import com.example.laboratorio4.UIview.Concerts.Events
import com.example.laboratorio4.UIview.Concerts.concert
import com.example.laboratorio4.UIview.Concerts.event
import com.example.laboratorio4.UIview.Detail.information
import com.example.laboratorio4.UIview.profile.User

@Composable
fun Navigation(){
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = Screens.Concertscards.route,){
        composable(route=Screens.Concertscards.route){
            concert(navController);
        }
        composable(route=Screens.Events.route){
            Events(navController);
        }
        composable(route=Screens.information.route){
            information(concert = event(R.drawable.wos, "Wos", "Majadas"), navController)
        }
        composable(route=Screens.User.route){
            User(navController);
        }
    }
}