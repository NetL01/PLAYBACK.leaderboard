package ru.havlong.leaderboard.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.havlong.leaderboard.models.RecordModel

/**
 * 26.10.2020
 * RecordRepository
 *
 * @author Havlong
 * @version v1.0
 */
interface RecordRepository : JpaRepository<RecordModel, Long> {
    fun findAllByOrderByScoreDesc(): List<RecordModel>
    fun findRecordByUserName(userName: String): RecordModel?
    fun findFirstByOrderByScoreAsc(): RecordModel?
}