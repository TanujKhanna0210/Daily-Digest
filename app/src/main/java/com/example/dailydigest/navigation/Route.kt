package com.example.dailydigest.navigation

sealed class Route(
    val route: String
) {
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")
    object DetailsScreen: Route(route = "detailsScreen")
    object NewsNavigation: Route(route = "newsNavigation")
    object NewsNavigatorScreen: Route(route = "newsNavigatorScreen")
}