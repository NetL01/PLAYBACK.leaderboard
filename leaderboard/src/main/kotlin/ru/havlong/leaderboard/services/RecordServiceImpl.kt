package ru.havlong.leaderboard.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.havlong.leaderboard.forms.RecordForm
import ru.havlong.leaderboard.models.RecordModel
import ru.havlong.leaderboard.repositories.RecordRepository
import kotlin.math.max

@Service
class RecordServiceImpl(private val recordRepository: RecordRepository) : RecordService {

    @Value("\${leaderboard.security.private-key}")
    private lateinit var privateKey: String

    override fun getAll(): List<RecordModel> = recordRepository.findAllByOrderByScoreDesc()

    override fun decryptScore(encryptedKey: String): Int = Integer.parseInt(encryptedKey)

    override fun saveRecord(form: RecordForm) {
        val score = decryptScore(form.score)
        val query = recordRepository.findRecordByUserName(form.userName)
        if (query != null) {
            query.score = max(score, query.score)
            recordRepository.saveAndFlush(query)
        } else {
            val model = RecordModel(null, score, form.userName)
            recordRepository.save(model)
        }
        if (recordRepository.count() > 1000)
            recordRepository.delete(recordRepository.findFirstByOrderByScoreAsc()!!)
    }
}