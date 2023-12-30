package ir.mohsenebrahimy.roomorm.db.dao

import androidx.room.Dao
import androidx.room.Insert
import ir.mohsenebrahimy.roomorm.db.model.UserEntity

@Dao
interface UserDAO {

    @Insert
    fun insertUser(user: UserEntity)
}