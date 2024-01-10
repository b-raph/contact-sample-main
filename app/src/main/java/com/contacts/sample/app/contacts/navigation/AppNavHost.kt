package com.contacts.sample.app.contacts.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.contacts.sample.app.contacts.ContactsScreen


object ContactListNavigation {
     val route: String
        get() = "contact_list_route"
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) =
    NavHost(
        navController = navController,
        startDestination = ContactListNavigation.route
    ) {
        composable(
            route = ContactListNavigation.route
        ) {
            ContactsScreen(
                viewModel = hiltViewModel()
            )
        }
    }