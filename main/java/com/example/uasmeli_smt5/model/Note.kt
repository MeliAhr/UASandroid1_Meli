package com.example.uasmeli_smt5.model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "npm")
    var npm: String = "",

    @ColumnInfo(name = "nama")
    var nama: String = "",

    @ColumnInfo(name = "nilai")
    var nilai: String = "",

    @ColumnInfo(name = "keterangan")
    var keterangan: String = "",

    @ColumnInfo(name = "jumlahsks")
    var jumlahsks: String = "",

    @ColumnInfo(name = "hargasks")
    var hargasks: String ="",
):Parcelable