package com.sortby.composetemplate.data.source.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.sortby.composetemplate.data.repository.UserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class RefreshLatestUserWorker @AssistedInject constructor(
    private val userRepository: UserRepository,
    @Assisted context: Context,
    @Assisted params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = try {
        userRepository.refreshLatestUsers()
        Result.success()
    } catch (e: Exception) {
        Result.failure()
    }
}