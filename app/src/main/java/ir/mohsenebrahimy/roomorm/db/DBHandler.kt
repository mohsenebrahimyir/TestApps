package ir.mohsenebrahimy.roomorm.db

import androidx.room.Database
import ir.mohsenebrahimy.roomorm.db.dao.UserDAO
import ir.mohsenebrahimy.roomorm.db.model.UserEntity

@Database(
    entities = [UserEntity::class],
    version = DBHandler.DATABASE_VERSION
)
abstract class DBHandler {

    abstract fun userDao(): UserDAO

    companion object {
        const val DATABASE_NAME = "main_database"
        const val DATABASE_VERSION = 1

        const val USER_TABLE = "userTable"
    }
}