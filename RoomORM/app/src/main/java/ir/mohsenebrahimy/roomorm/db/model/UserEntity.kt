package ir.mohsenebrahimy.roomorm.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.mohsenebrahimy.roomorm.db.DBHandler

@Entity(tableName = DBHandler.USER_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val family: String,
    @ColumnInfo val phone: String,
    @ColumnInfo val age: Int
)
