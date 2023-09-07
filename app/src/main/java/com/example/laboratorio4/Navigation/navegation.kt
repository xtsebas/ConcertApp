package com.example.laboratorio4.Navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.Navigation.MainConfigurationNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomTabNavigation() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(BottomNavigationScreens.Events,
        BottomNavigationScreens.Books,
        BottomNavigationScreens.Profile)
    val pagerState = rememberPagerState { bottomNavigationItems.count() }
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        MainConfigurationNavigation(navController)
    }
}