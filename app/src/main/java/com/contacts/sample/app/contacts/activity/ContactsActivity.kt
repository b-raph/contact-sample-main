package com.contacts.sample.app.contacts.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.contacts.sample.app.contacts.navigation.AppNavHost
import com.contacts.sample.app.ui.theme.AppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        val systemUiController = rememberSystemUiController()
        SideEffect {
          systemUiController.setStatusBarColor(color = Color.White, darkIcons = true)
          systemUiController.setNavigationBarColor(color = Color.White, darkIcons = true)
        }
        AppNavHost()
      }
    }
  }
}