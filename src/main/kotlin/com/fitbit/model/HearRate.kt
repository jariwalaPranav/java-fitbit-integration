package com.fitbit.model

data class Activities(
  val `activities-heart`: List<Activity>
)

data class Activity(
  val dateTime: String,
  val value: HeartRateZones
)

data class HeartRateZones(
  val heartRateZones: List<HeartRate>
)

data class HeartRate(
  val max: Int,
  val min: Int,
  val name: String
)
