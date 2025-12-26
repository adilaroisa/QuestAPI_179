package com.example.pertemuan12localrestapi.viewmodel.provider


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan12localrestapi.repositori.AplikasiDataSiswa
import com.example.pertemuan12localrestapi.viewmodel.EntryViewModel
import com.example.pertemuan12localrestapi.viewmodel.HomeViewModel

fun CreationExtras.aplikasiDataSiswa():AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
                AplikasiDataSiswa
        )
object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container
            .repositoryDataSiswa) }
        initializer { EntryViewModel(aplikasiDataSiswa().container
            .repositoryDataSiswa) }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa) }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa
            ) }
    }
}