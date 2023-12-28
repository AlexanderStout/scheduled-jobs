package io.sasha.shedlock.jobs

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

@Component
class ScheduledTasks {

  private val dateTimeFormatter = DateTimeFormatterBuilder().appendPattern("HH:mm:ss").toFormatter()

  @SchedulerLock(name = "hello")
  @Scheduled(cron = "*/1 * * * * *") // every second
  fun clockTicker() {
    println(LocalDateTime.now().format(dateTimeFormatter))
  }
}