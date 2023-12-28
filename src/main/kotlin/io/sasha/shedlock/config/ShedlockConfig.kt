package io.sasha.shedlock.config

import net.javacrumbs.shedlock.core.LockProvider
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class ShedlockConfig {


  @Bean
  fun jdbcLockProvider(dataSource: DataSource): LockProvider = JdbcTemplateLockProvider(dataSource, "shedlock")

}