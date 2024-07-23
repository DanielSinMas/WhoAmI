@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.danielgimenez.whoami.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.danielgimenez.domain.model.Response
import com.danielgimenez.domain.model.UserUiModel
import com.danielgimenez.domain.model.fullName
import com.danielgimenez.whoami.MainViewModel
import com.danielgimenez.whoami.R

@Composable
fun SharedTransitionScope.UsersScreen(
    viewModel: MainViewModel,
    scope: AnimatedVisibilityScope,
    onNavigateToDetailsScreen: (String) -> Unit
) {
    val users by viewModel.users.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        UsersScreenContent(
            modifier = Modifier.padding(innerPadding),
            users = users,
            onNavigateToDetailsScreen,
            scope
        )
    }
}

@Composable
fun SharedTransitionScope.UsersScreenContent(
    modifier: Modifier,
    users: Response<List<UserUiModel>>,
    onNavigateToDetailsScreen: (String) -> Unit,
    scope: AnimatedVisibilityScope
) {
    when(users) {
        is Response.Success -> {
            UsersList(list = users.data, modifier, onNavigateToDetailsScreen, scope)
        }
        is Response.Error -> {
            Text(text = stringResource(id = R.string.error))
        }
        is Response.Loading -> {
            Text(text = stringResource(id = R.string.loading))
        }
    }
}

@Composable
fun SharedTransitionScope.UsersList(
    list: List<UserUiModel>,
    modifier: Modifier,
    onNavigateToDetailsScreen: (String) -> Unit,
    scope: AnimatedVisibilityScope
) {
    LazyColumn(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list) { user ->
            UserItem(user = user, onNavigateToDetailsScreen, scope)
        }
    }
}

@Composable
fun SharedTransitionScope.UserItem(
    user: UserUiModel,
    onNavigateToDetailsScreen: (String) -> Unit,
    scope: AnimatedVisibilityScope
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.clickable { onNavigateToDetailsScreen(user.email ?: "") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            AsyncImage(
                model = user.picture?.medium,
                contentDescription = "User thumbnail",
                modifier = Modifier
                    .size(80.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = "userImage/$user.picture?.medium"),
                        animatedVisibilityScope = scope,
                    )
            )

            Column(
                modifier = Modifier.padding(horizontal = 30.dp)
            ) {
                Text(text = user.fullName(), fontSize = 22.sp)
                Text(text = user.location?.city ?: "")
                Text(text = user.dob?.age.toString())
            }
        }
    }
}
