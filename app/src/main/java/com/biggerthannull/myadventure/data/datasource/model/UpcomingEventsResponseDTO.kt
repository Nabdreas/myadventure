package com.biggerthannull.myadventure.data.datasource.model

import com.google.firebase.Timestamp

data class UpcomingEventsResponseDTO(
    val _id: String? = null,
    var audaxPoints: String? = null,
    var category: String? = null,
    var climb: String? = null,
    var date: Timestamp? = null,
    var description: String? = null,
    var distance: String? = null,
    var eventType: String? = null,
    var eventUrl: String? = null,
    var finishBy: Timestamp? = null,
    var imageUrl: String? = null,
    var price: String? = null,
    var speed: String? = null,
    var startingLocation: String? = null,
    var title: String? = null,
)
