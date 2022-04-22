import androidx.compose.runtime.Immutable
import kotlinx.datetime.*

object MonthStateGenerator {
    fun getState(): MonthState {
        val now: Instant = Clock.System.now()
        val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return MonthState(
            today.month.name,
            today.month.length(false)
        )
    }
}

@Immutable
data class MonthState(val name: String, val length: Int)