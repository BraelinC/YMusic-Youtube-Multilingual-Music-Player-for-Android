package com.peecock.ymusic.ui.screens.home

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

// TODO: Replace PLACEHOLDER_PLAYLIST_ID with the real "AI Daily Mix" YouTube playlist ID
// curated by the Hermes daily cron via Composio YouTube.
const val AI_DAILY_PLAYLIST_URL = "https://www.youtube.com/playlist?list=PLACEHOLDER_PLAYLIST_ID"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun HomeAIDaily(navController: NavController, onSettingsClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "AI Daily Mix",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(AI_DAILY_PLAYLIST_URL)
                }
            }
        )
    }
}
