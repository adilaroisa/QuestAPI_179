package com.example.pertemuan12localrestapi.viewmodel

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())


}