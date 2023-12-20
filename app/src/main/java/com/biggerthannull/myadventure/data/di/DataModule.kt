package com.biggerthannull.myadventure.data.di

import com.biggerthannull.myadventure.data.datasource.EventsDataSource
import com.biggerthannull.myadventure.data.datasource.EventsDataSourceImpl
import com.biggerthannull.myadventure.data.datasource.EventsLocalDataSource
import com.biggerthannull.myadventure.data.datasource.EventsLocalDataSourceImpl
import com.biggerthannull.myadventure.data.repository.EventsRepositoryImpl
import com.biggerthannull.myadventure.domain.repository.EventsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindEventsRepository(impl: EventsRepositoryImpl): EventsRepository


    @Binds
    fun bindEventsLocalDataSource(impl: EventsLocalDataSourceImpl): EventsLocalDataSource

    @Binds
    fun bindEventsDataSource(impl: EventsDataSourceImpl): EventsDataSource

}