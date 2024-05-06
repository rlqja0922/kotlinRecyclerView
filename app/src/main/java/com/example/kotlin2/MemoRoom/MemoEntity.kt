package com.example.kotlin2.MemoRoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Long?,
    var memo : String =""
)
