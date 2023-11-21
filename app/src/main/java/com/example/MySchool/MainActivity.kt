package com.example.MySchool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.MySchool.Navigation.AppNavigation
import com.example.MySchool.ui.theme.MySchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySchoolTheme {
                AppNavigation()
            }
        }
    }
}