package com.example.laboratorio4.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.laboratorio4.UIview.Concerts.Events
import com.example.laboratorio4.UIview.Concerts.concert
import com.example.laboratorio4.UIview.profile.User
import com.example.my.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun PrincipalTabs(navController: NavController){
    val tabs = listOf(
        Tabs_screens.Tab_concert,
        Tabs_screens.Tab_events,
        Tabs_screens.Tab_user,
    )
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState, navController)

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs:List<Tabs_screens>, pagerState: PagerState){
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White,
        indicator = {
                tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed{index, tabsScreens ->
            LeadingIconTab(
                selected = pagerState.currentPage==index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    } },
                icon = { Icon(painter = painterResource(id = tabsScreens.icon), contentDescription = "") },
                text = { Text(tabsScreens.title)})
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs_content(tabs:List<Tabs_screens>, pagerState: PagerState, navController: NavController){
    HorizontalPager(
        state = pagerState,
        count = tabs.size)
    {
            page ->
        if (tabs[page].title == "Conciertos"){
            concert(navController = navController)
        }
        if (tabs[page].title == "Eventos"){
            Events()
        }
        if (tabs[page].title == "Usuario"){
            User(navController = navController)
        }
    }
}