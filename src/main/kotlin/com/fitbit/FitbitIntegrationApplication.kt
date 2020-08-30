package com.fitbit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class FitbitIntegrationApplication

fun main(args: Array<String>) {
	runApplication<FitbitIntegrationApplication>(*args)
}
