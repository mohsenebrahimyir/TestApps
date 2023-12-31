package ir.mohsenebrahimy.roomorm.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Flowable
import ir.mohsenebrahimy.roomorm.db.DBHandler
import ir.mohsenebrahimy.roomorm.db.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Insert
    fun insertUser(vararg user: UserEntity)

    @get:Query("SELECT * FROM ${DBHandler.USER_TABLE}")
    val getUsers : Flow<List<UserEntity>>
}