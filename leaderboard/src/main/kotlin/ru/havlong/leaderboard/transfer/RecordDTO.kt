package ru.havlong.leaderboard.transfer

import ru.havlong.leaderboard.models.RecordModel

/**
 * 26.10.2020
 * RecordDTO
 *
 * @author Havlong
 * @version v1.0
 */
data class RecordDTO(val score: Int, val userName: String) {
    companion object {
        fun from(recordModel: RecordModel): RecordDTO = RecordDTO(recordModel.score, recordModel.userName)
    }
}