import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.2.1"
  id("io.spring.dependency-management") version "1.1.4"
  kotlin("jvm") version "1.9.21"
  kotlin("plugin.spring") version "1.9.21"
}

group = "io.sasha"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
  mavenCentral()
}

dependencies {
  // Spring
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.springframework.boot:spring-boot-starter-web") {
    exclude(group = "org.yaml", module = "snakeyaml")
  }
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  // H2
  runtimeOnly("com.h2database:h2")


  testImplementation("org.springframework.boot:spring-boot-starter-test")

  // Shedlock
  implementation("net.javacrumbs.shedlock:shedlock-spring:5.10.2")
  implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:5.10.0")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs += "-Xjsr305=strict"
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
