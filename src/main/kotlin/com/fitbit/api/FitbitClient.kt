package com.fitbit.api

import com.fitbit.model.Activities
import com.fitbit.model.SleepList
import com.fitbit.model.Weight
import feign.Logger
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader


@FeignClient("fitbit-feign-client", url = "https://api.fitbit.com/", configuration = [FeignConfiguration::class])
interface FitbitClient {

  @GetMapping(path = ["/1/user/-/activities/heart/date/{date}/{period}.json"])
  fun getHeartRate(
    @RequestHeader(name = "Authorization") oauthToken: String?,
    @PathVariable("date") date: String?,
    @PathVariable("period") period: String?
  ): Activities


  @GetMapping(path = ["/1.2/user/-/sleep/date/{date}.json"])
  fun getSleepData(
    @RequestHeader(name = "Authorization") oauthToken: String,
    @PathVariable("date") date: String?
  ): SleepList

  @GetMapping(path = ["/1/user/-/body/log/weight/date/{date}/{period}.json"])
  fun getUserWeight(
    @PathVariable("date") date: String?,
    @PathVariable("period") period: String?,
    @RequestHeader(name = "Authorization") oauthToken: String
  ): Weight
}

@Configuration
class FeignConfiguration {
  @Bean
  fun feignLoggerLevel(): Logger.Level {
    return Logger.Level.FULL
  }
}
