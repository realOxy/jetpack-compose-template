package com.sortby.composetemplate.data.source

import androidx.work.*
import com.sortby.composetemplate.data.source.worker.RefreshLatestUserWorker
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val REFRESH_RATE_HOURS = 4L
private const val FETCH_LATEST_USERS_TASK = "FetchLatestUsersTask"
private const val TAG_FETCH_LATEST_USERS = "FetchLatestUsersTaskTag"

class UserRemoteDataSource @Inject constructor(
    private val workManager: WorkManager
) {
    fun fetchUsersPeriodically() {
        val fetchNewsRequest = PeriodicWorkRequestBuilder<RefreshLatestUserWorker>(
            REFRESH_RATE_HOURS, TimeUnit.HOURS
        ).setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(NetworkType.TEMPORARILY_UNMETERED)
                .setRequiresCharging(true)
                .build()
        )
            .addTag(TAG_FETCH_LATEST_USERS)

        workManager.enqueueUniquePeriodicWork(
            FETCH_LATEST_USERS_TASK,
            ExistingPeriodicWorkPolicy.KEEP,
            fetchNewsRequest.build()
        )
    }

    fun cancelFetchingUsersPeriodically() {
        workManager.cancelAllWorkByTag(TAG_FETCH_LATEST_USERS)
    }
}