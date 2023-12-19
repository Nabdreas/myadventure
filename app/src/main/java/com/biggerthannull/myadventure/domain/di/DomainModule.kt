package com.biggerthannull.myadventure.domain.di

import com.biggerthannull.myadventure.domain.usecase.GetUpcomingEventsUseCase
import com.biggerthannull.myadventure.domain.usecase.GetUpcomingEventsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DomainModule {
    @Binds
    fun bindGetUpcomingEventsUseCase(impl: GetUpcomingEventsUseCaseImpl): GetUpcomingEventsUseCase
}