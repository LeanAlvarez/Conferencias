package com.mirai.platziconf.view.adapter

import com.mirai.platziconf.model.Speaker


interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}