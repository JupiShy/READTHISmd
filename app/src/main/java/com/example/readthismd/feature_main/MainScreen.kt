package com.example.readthismd.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import com.example.readthismd.R
import com.example.readthismd.core.navigation.EditorRoute
import com.example.readthismd.core.navigation.ExplorerRoute
import com.example.readthismd.core.navigation.ProfileRoute
import com.example.readthismd.feature_auth.presentation.LoginScreen
import com.example.readthismd.feature_editor.presentation.EditorScreen

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentDestination?.hasRoute<ProfileRoute>() == true,
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    onClick = {
                        navController.navigate(ProfileRoute){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    label = { Text (stringResource(id = R.string.profile),)}
                )

                NavigationBarItem(
                    selected = currentDestination?.hasRoute<EditorRoute>() == true,
                    onClick = {
                        navController.navigate(EditorRoute){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(Icons.Default.Create, contentDescription = "Editor") },
                    label = { Text (stringResource(id = R.string.editor),) }
                )

                NavigationBarItem(
                    selected = currentDestination?.hasRoute<ExplorerRoute>() == true,
                    onClick = {
                        navController.navigate(ExplorerRoute){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Explorer") },
                    label = { Text (stringResource(id = R.string.explorer),) }
                )
            }
        }
    ) {
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = EditorRoute,
            modifier = Modifier.padding(paddingValues)
        ){
            composable<ProfileRoute> {
                LoginScreen()
            }
            composable<EditorRoute> {
                EditorScreen()
            }
            composable<ExplorerRoute>
            {
                Box(Modifier.fillMaxSize()){
                    Text ("Soon there will be Explorer")
                }
            }
        }
    }
}