package uz.hamroh.ui.base


import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseMviViewModel<State, Event, Effect >(
    initialState: State,
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<Effect>()
    val effect: SharedFlow<Effect> = _effect.asSharedFlow()

    fun setEvent(event: Event) {
        handleEvent(event)
    }
    protected fun setState(state: State) {
        _state.value = state
    }

    protected fun setEffect(effect: Effect) {
        _effect.tryEmit(effect)
    }
    abstract fun handleEvent(event: Event)
}

sealed class ViewState {
    data object Loading : ViewState()
    data class Content(val data: Any) : ViewState()
    data class Error(val message: String) : ViewState()
}

sealed class ViewEffect {
    data class ShowToast(val message: String) : ViewEffect()
    data class NavigateTo(val destination: Screen) : ViewEffect()
}