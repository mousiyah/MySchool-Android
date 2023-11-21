package com.example.MySchool.Screens

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object Main : Screens("main")
    object Dashboard : Screens("dashboard")
    object Timetable : Screens("timetable")
}