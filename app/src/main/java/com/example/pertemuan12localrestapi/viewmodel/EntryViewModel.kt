package com.example.pertemuan12localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pertemuan12localrestapi.modeldata.DetailSiswa
import com.example.pertemuan12localrestapi.modeldata.UIStateSiswa
import com.example.pertemuan12localrestapi.modeldata.toDataSiswa
import com.example.pertemuan12localrestapi.repositori.RepositoryDataSiswa

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
    private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ):
            Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa, validasiInput(detailSiswa))
    }

    suspend fun addSiswa() {
        if (validasiInput()) {
            repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}