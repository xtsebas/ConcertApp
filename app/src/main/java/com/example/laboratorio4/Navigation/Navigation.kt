package com.example.laboratorio4.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.UIview.Concerts.Events
import com.example.laboratorio4.UIview.Concerts.concert
import com.example.laboratorio4.UIview.Concerts.event
import com.example.laboratorio4.UIview.Detail.information
import com.example.laboratorio4.UIview.profile.User
import com.example.laboratorio4.UIview.profile.login
import com.example.my.R


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route,){
        composable(route = Screens.Login.route){
            login(navController);
        }
        composable(route=Screens.Concertscards.route){
            concert(navController);
        }
        composable(route=Screens.information.route){
            Log.d("HOLA", "LLeGO")
            information(concert = event(R.drawable.wos, "Wos", "Majadas"), navController)
        }
        composable(route=Screens.User.route){
            val name = it.arguments?.getString("name") ?: ""
            val lastname = it.arguments?.getString("lastname") ?: ""
            User(navController);
        }
        composable(Screens.tabs.route){
            PrincipalTabs(navController);
        }
    }
}
