package com.mirai.platziconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mirai.platziconf.R

import com.mirai.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_speaker_detail_dialog.*

class SpeakerDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speaker_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarSpeaker.setTitleTextColor(Color.WHITE)
        toolbarSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speakers") as Speaker
        toolbarSpeaker.title = speaker.name

        //objeto para cargar la imagen
        Glide.with(ivSpeakerDetail.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivSpeakerDetail)

        tvDetailCoferenceSpeaker.text = speaker.name
        tvDetailCoferenceSpeakerJob.text = speaker.jobtitle
        tvDetailCoferenceTag.text = speaker.workplace
        ivTwDetailSpeaker.setOnClickListener {
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/"+url)
            val lauchBrowser = Intent(Intent.ACTION_VIEW, uri)
                startActivity(lauchBrowser)
        }

        tvDetailCoferenceDescription.text = speaker.biography

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}