package com.vsmart.example.notificationmaker.activity

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vsmart.example.notificationmaker.R
import com.vsmart.example.notificationmaker.utils.*

class MainActivity : AppCompatActivity() {

    private val mContext = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        createNotificationChannels(mContext)
    }

    private fun initView() {
        mContext.findViewById<Button>(R.id.show_head_up_notification).apply {
            setOnClickListener {
                pushHeadUpNotification()
            }
        }

        mContext.findViewById<Button>(R.id.show_default_notification).apply {
            setOnClickListener {
                pushDefaultNotification()
            }
        }

        mContext.findViewById<Button>(R.id.show_silent_notification).apply {
            setOnClickListener {
                pushSilentNotification()
            }
        }

        mContext.findViewById<Button>(R.id.show_minimize_notification).apply {
            setOnClickListener {
                pushMinimizeNotification()
            }
        }
    }

    private fun pushHeadUpNotification() {
        val id = 1
        val channel = HIGH_IMPORTANCE_CHANNEL
        val icon = R.drawable.ic_pikachu_pokemon
        val notification = Notification.Builder(mContext, channel).run {
            setSmallIcon(icon)
            setContentTitle("ID = $id")
            setContentText("CHANNEL = $channel")
            build()
        }
        (mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).run {
            notify(id, notification)
        }
    }

    private fun pushDefaultNotification() {
        val id = 2
        val channel = DEFAULT_IMPORTANCE_CHANNEL
        val icon = R.drawable.ic_dropbox
        val notification = Notification.Builder(mContext, channel).run {
            setSmallIcon(icon)
            setContentTitle("ID = $id")
            setContentText("CHANNEL = $channel")
            build()
        }
        (mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).run {
            notify(id, notification)
        }
    }

    private fun pushSilentNotification() {
        val id = 3
        val channel = LOW_IMPORTANCE_CHANNEL
        val icon = R.drawable.ic_onedrive
        val notification = Notification.Builder(mContext, channel).run {
            setSmallIcon(icon)
            setContentTitle("ID = $id")
            setContentText("CHANNEL = $channel")
            build()
        }
        (mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).run {
            notify(id, notification)
        }
    }

    private fun pushMinimizeNotification() {
        val id = 4
        val channel = MIN_IMPORTANCE_CHANNEL
        val icon = R.drawable.ic_microsoft_edge
        val notification = Notification.Builder(mContext, channel).run {
            setSmallIcon(icon)
            setContentTitle("ID = $id")
            setContentText("CHANNEL = $channel")
            build()
        }
        (mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).run {
            notify(id, notification)
        }
    }
}