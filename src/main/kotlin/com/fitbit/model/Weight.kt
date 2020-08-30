package com.fitbit.model

data class Weight (
  val weight: List<WeightDetails>
)

data class WeightDetails(
  val bmi: Long,
  val date: String,
  val time: String,
  val weight: Long
)
