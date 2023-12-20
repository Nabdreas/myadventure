package com.biggerthannull.myadventure.data.datasource

import com.biggerthannull.myadventure.data.datasource.model.UpcomingEventsResponseDTO
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class EventsDataSourceImpl @Inject constructor(
    @Named("EVENTS") private val eventsCollection: CollectionReference
) : EventsDataSource {
    override suspend fun getUpcomingEvents(): Result<List<UpcomingEventsResponseDTO>> {
        return try {
            val snapshot = eventsCollection.get().await()
            val result = parseToDTO(snapshot)
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun parseToDTO(snapshot: QuerySnapshot): List<UpcomingEventsResponseDTO> {
        return snapshot.map { document ->
            document.toObject(UpcomingEventsResponseDTO::class.java)
        }
    }
}
