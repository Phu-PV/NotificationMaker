package com.vsmart.example.notificationmaker.activity

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vsmart.example.notificationmaker.R
import com.vsmart.example.notificationmaker.utils.HIGH_IMPORTANCE_CHANNEL
import com.vsmart.example.notificationmaker.utils.createNotificationChannels

class MainActivity : AppCompatActivity() {

    private val mContext = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        createNotificationChannels(mContext)
    }

    private fun initView() {
        val buttonShowNotification = mContext.findViewById<Button>(R.id.show_notification)
        buttonShowNotification.setOnClickListener {
            val headUpNotification = createHeadUpNotification()
            with(mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager) {
                notify(1, headUpNotification)
            }
        }
    }

    private fun createHeadUpNotification(): Notification {
        val builder = Notification.Builder(mContext, HIGH_IMPORTANCE_CHANNEL)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Content title")
                .setContentText("Content text")
        return builder.build()
    }
}