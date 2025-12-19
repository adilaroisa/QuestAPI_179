package com.example.pertemuan12localrestapi.viewmodel

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())

    private fun validasiInput(ui: DetailSiswa = uiStateSiswa.detailSiswa): Boolean =
        ui.nama.isNotBlank() && ui.alamat.isNotBlank() && ui.telpon.isNotBlank()

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa, validasiInput(detailSiswa))
    }

    suspend fun addSiswa() {
        if (validasiInput()) {
            repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}