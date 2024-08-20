package com.kusumaos.searchlitebridge

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class MainActivity : Activity() {

    companion object {
        private const val GSA_LITE_PACKAGE = "com.google.android.apps.searchlite"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchAssistantActivity()
    }

    private fun launchAssistantActivity() {
        val intent = Intent().apply {
            action = Intent.ACTION_MAIN
            addCategory(Intent.CATEGORY_LAUNCHER)
            component =
                ComponentName(GSA_LITE_PACKAGE, 
                        "com.google.android.apps.searchlite.assistant.widgetentry.AssistantActivity")
        }
        try {
            startActivity(intent)
            finish()
        } catch (e: ActivityNotFoundException) {
            handleAssistantAppNotInstalled()
        }
    }

    private fun handleAssistantAppNotInstalled() {
        Toast.makeText(applicationContext, R.string.not_found, Toast.LENGTH_SHORT).show()
        finish()
    }
}
