@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.danielgimenez.whoami.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.danielgimenez.domain.model.fullName
import com.danielgimenez.domain.model.parseDate
import com.danielgimenez.whoami.MainViewModel
import com.danielgimenez.whoami.R

@Composable
fun SharedTransitionScope.DetailsScreen(
    viewModel: MainViewModel,
    userEmail: String,
    scope: AnimatedVisibilityScope
) {
    val user = viewModel.getUserByEmail(userEmail)

    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user != null) {
            AsyncImage(
                model = user.picture?.large,
                contentDescription = "User image",
                modifier = Modifier
                    .size(200.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = "userImage/$user.picture?.medium"),
                        animatedVisibilityScope = scope,
                    )
            )
            NonEditableTextField(
                label = stringResource(id = R.string.name),
                text = user.fullName()
            )
            NonEditableTextField(
                label = stringResource(id = R.string.email),
                text = user.email ?: ""
            )
            NonEditableTextField(
                label = stringResource(id = R.string.phone_number),
                text = user.cell ?: ""
            )
            NonEditableTextField(
                label = stringResource(id = R.string.city),
                text = user.location?.city ?: ""
            )
            NonEditableTextField(
                label = stringResource(id = R.string.state),
                text = user.location?.state ?: ""
            )
            NonEditableTextField(
                label = stringResource(id = R.string.birth_date),
                text = user.dob?.parseDate() ?: ""
            )
        } else {
            Text(text = stringResource(id = R.string.error_user))
        }
    }
}

@Composable
fun NonEditableTextField(
    label: String,
    text: String
) {
    OutlinedTextField(
        value = text,
        onValueChange = {},
        label = { Text(text = label) },
        readOnly = true,
        enabled = false,
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = MaterialTheme.colorScheme.secondary,
            disabledTrailingIconColor = MaterialTheme.colorScheme.secondary,
            disabledBorderColor = MaterialTheme.colorScheme.secondary,
            disabledLabelColor = MaterialTheme.colorScheme.primary,
            disabledPlaceholderColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = Modifier.padding(10.dp)
    )
}