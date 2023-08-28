package com.example.laboratorio4.Screens

sealed class Screen(val route: String) {
    object Events : Screen("events")
    object information : Screen("information")
}