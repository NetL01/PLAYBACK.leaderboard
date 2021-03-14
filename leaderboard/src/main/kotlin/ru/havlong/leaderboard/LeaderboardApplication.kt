package ru.havlong.leaderboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("ru.havlong.leaderboard.models")
@EnableJpaRepositories("ru.havlong.leaderboard.repositories")
class LeaderboardApplication

fun main(args: Array<String>) {
    runApplication<LeaderboardApplication>(*args)
}
