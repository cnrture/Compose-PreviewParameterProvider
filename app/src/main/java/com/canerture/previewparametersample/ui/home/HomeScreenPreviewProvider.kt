package com.canerture.previewparametersample.ui.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HomeScreenPreviewProvider : PreviewParameterProvider<HomeContract.UiState> {
    override val values: Sequence<HomeContract.UiState>
        get() = sequenceOf(
            HomeContract.UiState(
                isLoading = true,
                contactList = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                contactList = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                contactList = listOf(
                    Contact(
                        name = "Caner",
                        phoneNumber = "1234567890",
                        email = "cnrture@gmail.com",
                        address = "Istanbul"
                    ),
                    Contact(
                        name = "Ayşe",
                        phoneNumber = "1234567890",
                        email = "ayse@gmail.com",
                        address = "Ankara"
                    ),
                    Contact(
                        name = "Ahmet",
                        phoneNumber = "1234567890",
                        email = "ahmet@gmail.com",
                        address = "İzmir"
                    ),
                ),
            ),
        )
}