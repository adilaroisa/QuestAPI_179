package com.example.pertemuan12localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pertemuan12localrestapi.modeldata.DetailSiswa
import com.example.pertemuan12localrestapi.modeldata.UIStateSiswa
import com.example.pertemuan12localrestapi.modeldata.toDataSiswa
import com.example.pertemuan12localrestapi.modeldata.toUiStateSiswa
import com.example.pertemuan12localrestapi.repositori.RepositoryDataSiswa
import com.example.pertemuan12localrestapi.uicontroller.route.DestinasiDetail
import retrofit2.Response
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
                .toUiStateSiswa(true)
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun editSatuSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            val call: Response<Void> = repositoryDataSiswa.editSatuSiswa(
                idSiswa,
                uiStateSiswa.detailSiswa.toDataSiswa()
            )

            if (call.isSuccessful) {
                println("Update Sukses : ${call.message()}")
            } else {
                println("Update Error : ${call.errorBody()}")
            }
        }
    }
}