package com.example.paging3.Navigation

sealed class Screen(val route: String) {
    object Home:Screen("Home_screen")
    object Search:Screen("Search_screen")
}