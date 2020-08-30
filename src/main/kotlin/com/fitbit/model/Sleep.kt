package com.fitbit.model


data class SleepList(
  val sleep: List<Sleep>
)

data class Sleep(
  val dateOfSleep: String,
  val duration: String,
  val levels: SleepLevels,
  val minutesAfterWakeup: Int,
  val minutesAsleep: Int,
  val minutesAwake: Int,
  val minutesToFallAsleep: Int,
  val startTime: String,
  val timeInBed: Int
)

data class SleepLevels(
  val summary: SleepSummary,
  val data: List<SleepData>
)

data class SleepSummary(
  val deep: SleepDetails,
  val light: SleepDetails,
  val rem: SleepDetails,
  val wake: SleepDetails
)

data class SleepDetails(
  val count: Int,
  val minutes: Int,
  val thirtyDayAvgMinutes: Int
)

data class SleepData(
  val dateTime: String,
  val level: String,
  val seconds: Int
)
