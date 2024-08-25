## Youtube Video
[Link](https://youtu.be/dGJJurVWYaw?si=lVfl9J86Y7RLbJaR)

## Code
```kotlin
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
```

```kotlin
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
```

## Result
![image](https://github.com/user-attachments/assets/6ebbf66e-6783-4892-8f24-94fcaacf3769)
