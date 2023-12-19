package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.EventDTO
import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsDTO
import javax.inject.Inject

class EventsLocalDataSourceImpl @Inject constructor() : EventsLocalDataSource {
    override fun getUpcomingEvents(): Result<UpcomingEventsDTO> {
        return Result.success(
            UpcomingEventsDTO(
                data = EventDTO(
                    title = "Bristol Audax",
                    date = "21/01/2024",
                    imageUrl = "https://theunknownaroundthecorner.files.wordpress" +
                            ".com/2020/09/20200927-10-edit.jpg?w=1000",
                    location = "Bristol",
                    distance = 150,
                    elevation = 2589
                )
            )
        )
    }
}