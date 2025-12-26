package com.example.pertemuan12localrestapi.uicontroller.route

import com.example.pertemuan12localrestapi.R

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa

    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}