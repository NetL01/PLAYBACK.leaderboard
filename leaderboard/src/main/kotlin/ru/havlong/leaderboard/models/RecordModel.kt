package ru.havlong.leaderboard.models

import javax.persistence.*

/**
 * 26.10.2020
 * Record
 *
 * @author Havlong
 * @version v1.0
 */
@Entity
@Table(name = "record")
data class RecordModel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
        @Basic(optional = false) var score: Int,
        @Column(unique = true, nullable = false) val userName: String
)