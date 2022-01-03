package com.mirai.platziconf.view.adapter

import com.mirai.platziconf.model.Conference


interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}