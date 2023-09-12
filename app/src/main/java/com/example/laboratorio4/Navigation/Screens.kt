package com.example.laboratorio4.Navigation

sealed class Screens(val route: String){
    object Concertscards: Screens("concert");
    object Events: Screens("events");
    object information: Screens("information");
    object User: Screens("user");
    object Login: Screens("MainActivity");
}
