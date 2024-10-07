package com.isczaragoza.dogsapp.listOfDogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import com.isczaragoza.dogsapp.domain.resultHandler.Result
import com.isczaragoza.dogsapp.domain.useCases.GetListOfDogsUseCase
import com.isczaragoza.dogsapp.framework.mappers.asUiModel
import com.isczaragoza.dogsapp.framework.models.DogUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListOfDogsViewModel(private val getListOfDogsUseCase: GetListOfDogsUseCase) : ViewModel() {
    init {
        println("Init List Of Dogs VM")
    }

    /**Este MutableStateFlow y StateFlow pueden ser utilizados para un enfoque diferente, por ejemplo
     * si los metodos para obtener información todos de tipos "suspend" y no regresan un flow, entonces
     * se puede usar un scope de corrutina como viewModelScope.launch(Dispatchers.IO){} para ejecutar
     * las llamdas a metodos "suspend" y posteriormete actualizar el estado mutable y escucharlo en la vista
     * de la misma manera .collectAsStateWithLifeCycle()*/
    private val _stateAlternative: MutableStateFlow<ListOfDogsState> = MutableStateFlow(
        ListOfDogsState(
            isLoading = true,
            listOfDogs = emptyList(),
            error = ""
        )
    )
    val stateAlternative: StateFlow<ListOfDogsState> = _stateAlternative.asStateFlow()

    /**Las buenas prácticas de Google sugieren el uso de este enfoque para carga de datos que se muestran
     * al inicio de la pantalla, sin embargo no es necesario y se pueden usar otras técnicas, dependiendo
     * de la complejidad de la pantalla y datos.*/
    val uiState: StateFlow<ListOfDogsUiState> =
        getListOfDogsUseCase().map { resultListOfDogEntity ->
            when (resultListOfDogEntity) {
                is Result.Success -> {
                    val listOfDogsUi = resultListOfDogEntity.data.map { dogEntity: DogEntity ->
                        dogEntity.asUiModel()
                    }
                    ListOfDogsUiState.Success(listOfDogsUi)
                }

                is Result.Error -> {
                    ListOfDogsUiState.LoadFailed(resultListOfDogEntity.baseError)
                }
            }

        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ListOfDogsUiState.Loading
        )


    /**Ejemplo del enfoque mencionado en la sección superior.*/
    var getListOfDogsJob: Job? = null
    fun getListOfDogs() {
        if (getListOfDogsJob != null) {
            /*previene multiples llamadas al caso de uso*/
            return
        }
        getListOfDogsJob = viewModelScope.launch(Dispatchers.IO) {
            val data = emptyList<DogUiModel>()
            _stateAlternative.update {
                it.copy(isLoading = false, listOfDogs = data)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("On Cleared List Of Dogs VM")
    }
}