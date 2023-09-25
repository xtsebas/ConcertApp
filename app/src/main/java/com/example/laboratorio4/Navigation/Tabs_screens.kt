package com.example.laboratorio4.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.UIview.Concerts.Events
import com.example.laboratorio4.UIview.Concerts.concert
import com.example.laboratorio4.UIview.profile.User
import com.example.my.R

sealed class Tabs_screens(
    var icon: Int,
    var title: String,
){
    object Tab_concert: Tabs_screens(R.drawable.lock, "Conciertos")
    object Tab_events: Tabs_screens(R.drawable.lock, "Eventos")
    object Tab_user: Tabs_screens(R.drawable.iconuser, "Usuario")
}
