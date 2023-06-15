package com.example.composeapp.data.models

data class Resp(
    val events: List<Event>,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)
