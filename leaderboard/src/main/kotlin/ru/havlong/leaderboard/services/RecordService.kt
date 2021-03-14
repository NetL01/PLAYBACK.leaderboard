package ru.havlong.leaderboard.services

import ru.havlong.leaderboard.forms.RecordForm
import ru.havlong.leaderboard.models.RecordModel

/**
 * 26.10.2020
 * RecordService
 *
 * @author Havlong
 * @version v1.0
 */

interface RecordService {
    fun getAll(): List<RecordModel>
    fun decryptScore(encryptedKey: String): Int
    fun saveRecord(form: RecordForm)
}