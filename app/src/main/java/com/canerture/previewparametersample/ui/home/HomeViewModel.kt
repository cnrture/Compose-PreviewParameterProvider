package com.canerture.previewparametersample.ui.home

import androidx.lifecycle.ViewModel
import com.canerture.previewparametersample.ui.home.HomeContract.UiAction
import com.canerture.previewparametersample.ui.home.HomeContract.UiEffect
import com.canerture.previewparametersample.ui.home.HomeContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    fun onAction(uiAction: UiAction) {

    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
        val contactList: List<Contact> = listOf(),
    )

    sealed class UiAction {

    }

    sealed class UiEffect {

    }
}