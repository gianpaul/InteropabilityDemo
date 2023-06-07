package surgir.pe.myapplication.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import surgir.pe.myapplication.di.IoDispatcher
import surgir.pe.myapplication.domain.entity.Character
import surgir.pe.myapplication.presentation.usecases.FetchCharacterUseCase
import javax.inject.Inject

sealed class MainState {
    object Loading : MainState()
    data class Success(val characters: List<Character>) : MainState()
    object Error : MainState()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchCharacterUseCase: FetchCharacterUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var _state = MutableLiveData<MainState>()
    val state get() = _state

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        _state.value = MainState.Loading
        viewModelScope.launch {
            runCatching {
                withContext(dispatcher) {
                    fetchCharacterUseCase.execute()
                }
            }.onSuccess {
                _state.value = MainState.Success(it)
            }.onFailure {
                _state.value = MainState.Error
            }
        }
    }
}