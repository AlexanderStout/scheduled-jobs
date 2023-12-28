package io.sasha.shedlock.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "shedlock")
class Shedlock {

  @Id
  var name: String? = null

  @Column(name = "locked_at")
  var lockedAt: LocalDateTime? = null

  @Column(name = "lock_until")
  var lockedUntil: LocalDateTime? = null

  @Column(name = "locked_by")
  var lockedBy: String? = null
}