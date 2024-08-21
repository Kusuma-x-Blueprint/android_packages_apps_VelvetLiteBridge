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
            action = GSA_LITE_PACKAGE + ".SEARCH"
            putExtra("openMic", true)
            putExtra(GSA_LITE_PACKAGE + ".SKIP_BYPASS_AND_ONBOARDING", true)
            `package` = GSA_LITE_PACKAGE
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
