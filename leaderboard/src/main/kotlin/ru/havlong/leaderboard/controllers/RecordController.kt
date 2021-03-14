package ru.havlong.leaderboard.controllers

import org.springframework.web.bind.annotation.*
import ru.havlong.leaderboard.forms.RecordForm
import ru.havlong.leaderboard.services.RecordService
import ru.havlong.leaderboard.transfer.RecordDTO

/**
 * 26.10.2020
 * RecordController
 *
 * @author Havlong
 * @version v1.0
 */

@RestController
class RecordController(private val recordService: RecordService) {

    @GetMapping("/api/record")
    fun getAll(): List<RecordDTO> {
        return recordService.getAll().map(RecordDTO.Companion::from)
    }

    @GetMapping("/api/record/{count}")
    fun getNumber(@PathVariable count: Int): List<RecordDTO> {
        return recordService.getAll().take(count).map(RecordDTO.Companion::from)
    }

    @PostMapping("/api/record")
    fun postScore(@RequestBody record: RecordForm) {
        recordService.saveRecord(record)
    }
}