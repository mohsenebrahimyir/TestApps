package ir.mohsenebrahimy.roomorm.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Flowable
import ir.mohsenebrahimy.roomorm.db.DBHandler
import ir.mohsenebrahimy.roomorm.db.model.UserEntity

@Dao
interface UserDAO {

    @Insert
    fun insertUser(user: UserEntity)

    @get:Query("SELECT * FROM ${DBHandler.USER_TABLE}")
    val getUsers : Flowable<List<UserEntity>>
}