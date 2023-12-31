package ir.mohsenebrahimy.roomorm.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

    @Update
    fun updateUser(vararg users: UserEntity)

    @Delete
    fun deleteUser(vararg users: UserEntity)

    @Query("DELETE FROM ${DBHandler.USER_TABLE}")
    fun deleteAllUsers()
}