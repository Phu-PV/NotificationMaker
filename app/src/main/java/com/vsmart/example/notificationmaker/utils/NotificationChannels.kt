package com.vsmart.example.notificationmaker.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

const val HIGH_IMPORTANCE_CHANNEL = "high_importance_channel"
const val DEFAULT_IMPORTANCE_CHANNEL = "default_importance_channel"
const val LOW_IMPORTANCE_CHANNEL = "low_importance_channel"
const val MIN_IMPORTANCE_CHANNEL = "min_importance_channel"
const val NONE_IMPORTANCE_CHANNEL = "none_importance_channel"

fun createNotificationChannels(context: Context) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val channelList = listOf(
        NotificationChannel(
            HIGH_IMPORTANCE_CHANNEL,
            "High importance (4)",
            NotificationManager.IMPORTANCE_HIGH
        ),
        NotificationChannel(
            DEFAULT_IMPORTANCE_CHANNEL,
            "Default importance (3)",
            NotificationManager.IMPORTANCE_DEFAULT
        ),
        NotificationChannel(
            LOW_IMPORTANCE_CHANNEL,
            "Low importance (2)",
            NotificationManager.IMPORTANCE_LOW
        ),
        NotificationChannel(
            MIN_IMPORTANCE_CHANNEL,
            "Min importance (1)",
            NotificationManager.IMPORTANCE_MIN
        ),
        NotificationChannel(
            NONE_IMPORTANCE_CHANNEL,
            "None importance (0)",
            NotificationManager.IMPORTANCE_NONE
        )
    )
    notificationManager.createNotificationChannels(channelList)
}