package com.example.laboratorio4.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.R
import com.example.laboratorio4.UIview.Concerts.Events
import com.example.laboratorio4.UIview.Concerts.concert
import com.example.laboratorio4.UIview.profile.User


typealias function = @Composable () -> Unit

sealed class Tabs_screens(
    var icon: Int,
    var title: String,
    var screen: function
){
    object Tab_concert: Tabs_screens(R.drawable.lock, "Todos los eventos", { concert(
        rememberNavController()
    )})
    object Tab_events: Tabs_screens(R.drawable.lock, "Eventos", { Events(rememberNavController())})
    object Tab_user: Tabs_screens(R.drawable.iconuser, "Usuario", { User( rememberNavController())})
}
