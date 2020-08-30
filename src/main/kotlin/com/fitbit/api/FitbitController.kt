package com.fitbit.api

import com.fitbit.model.Activities
import com.fitbit.model.SleepList
import com.fitbit.model.Weight
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FitbitController(val fitbitClient: FitbitClient, val userService: UserService) {

  @GetMapping("/test")
  fun helloFitbit(): String {
    return "App is now authorized to use user data. Yay ! "
  }

  @GetMapping("/token")
  fun hello(): String {
    return userService.accessToken
  }

  @GetMapping("/fitbit/heartRate/{date}/{period}")
  fun getHearRate(
    @PathVariable("date") date: String? = "today",
    @PathVariable("period") period: String? = "1d"
  ): Activities {
    return fitbitClient.getHeartRate(userService.accessToken, date, period)
  }

  @GetMapping("/fitbit/sleep/{date}")
  fun getSleepData(
    @PathVariable("date") date: String? = "2020-06-02"
  ): SleepList? {
    return fitbitClient.getSleepData(userService.accessToken, date)
  }

  @GetMapping("/fitbit/weight/{date}/{period}")
  fun getWeightData(
    @PathVariable("date") date: String? = "2020-06-02",
    @PathVariable("period") period: String? = "1d"
  ): Weight {
    return fitbitClient.getUserWeight(date, period, userService.accessToken)
  }
}
