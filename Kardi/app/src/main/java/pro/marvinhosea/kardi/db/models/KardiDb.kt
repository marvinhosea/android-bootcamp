package pro.marvinhosea.kardi.db.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pro.marvinhosea.kardi.db.models.dao.*

@Database(
    entities = [
        Card::class,
        Deck::class,
        Game::class,
        GameResult::class,
        Player::class,
        PlayerHand::class,
        Table::class,
        GamePlayer::class
    ],
    version = 3)
abstract class KardiDb : RoomDatabase() {
    abstract fun cardDao() : CardDao
    abstract fun deckDao() : DeckDao
    abstract fun gameDao() : GameDao
    abstract fun playerDao() : PlayerDao
    abstract fun playerHandDao() : PlayerHandDao
    abstract fun tableDao() : TableDao
    abstract fun gamePlayerDao() : GamePlayerDao
    companion object {
        @Volatile
        private var INSTANCE : KardiDb? = null
        fun getInstance(context: Context) : KardiDb {
            var instance : KardiDb? = INSTANCE
            if (instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    KardiDb::class.java,
                    "kardi"
                ).build()
            }

            return instance
        }
    }
}