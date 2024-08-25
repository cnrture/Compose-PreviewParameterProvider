package com.canerture.previewparametersample.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.previewparametersample.ui.home.HomeContract.UiAction
import com.canerture.previewparametersample.ui.home.HomeContract.UiState

@Composable
fun HomeScreen(
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingContent()
        uiState.contactList.isNotEmpty() -> ContactList(uiState.contactList)
        else -> EmptyScreen()
    }
}

@Composable
fun ContactList(
    contacts: List<Contact>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(contacts) { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Name: ${item.name}",
                    color = Color.White,
                )
                Text(
                    text = "Email: ${item.email}",
                    color = Color.White,
                )
                Text(
                    text = "Phone: ${item.phoneNumber}",
                    color = Color.White,
                )
                Text(
                    text = "Address: ${item.address}",
                    color = Color.White,
                )
            }
        }
    }
}

@Composable
fun LoadingContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun EmptyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = "Warning",
        )
        Text(
            text = "No contacts found",
            color = Color.Black,
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        onAction = {},
    )
}