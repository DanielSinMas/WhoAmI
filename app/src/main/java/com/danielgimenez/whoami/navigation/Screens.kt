package com.danielgimenez.whoami.navigation

enum class Screen {
    USERS,
    DETAILS,
}
sealed class NavigationItem(val route: String) {
    object Users : NavigationItem(Screen.USERS.name)
    object Detail : NavigationItem(Screen.DETAILS.name)
}