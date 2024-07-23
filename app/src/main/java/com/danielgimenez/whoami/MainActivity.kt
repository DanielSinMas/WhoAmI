package com.danielgimenez.whoami

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danielgimenez.whoami.navigation.NavigationItem
import com.danielgimenez.whoami.screens.DetailsScreen
import com.danielgimenez.whoami.screens.UsersScreen
import com.danielgimenez.whoami.ui.theme.WhoAmITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getUsers()
        setContent {
            val navController = rememberNavController()

            WhoAmITheme {
                SharedTransitionLayout {
                    NavHost(navController = navController, startDestination = NavigationItem.Users.route) {
                        composable(NavigationItem.Users.route) {
                            UsersScreen(
                                viewModel = viewModel,
                                scope = this,
                            ) {
                                navController.navigate("${NavigationItem.Detail.route}/$it")
                            }
                        }
                        composable(
                            "${NavigationItem.Detail.route}/{userEmail}",
                            arguments = listOf(navArgument("userEmail") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            backStackEntry.arguments?.getString("userEmail")?.let {
                                DetailsScreen(viewModel = viewModel, userEmail = it, scope = this)
                            }
                        }
                    }
                }
            }
        }
    }
}