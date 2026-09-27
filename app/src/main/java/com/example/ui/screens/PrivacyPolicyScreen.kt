package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Privacy Policy - VaultSafe Offline",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.testTag("back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            )
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState)
                .testTag("privacy_policy_screen_content"),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(36.dp)
                    )
                    Column {
                        Text(
                            text = "VaultSafe Offline Security Guarantee",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "100% Local Storage & Zero Internet Permissions Required",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Text(
                text = "Last updated: September 2026",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            SectionTitle(title = "1. Introduction to VaultSafe Offline")
            Text(
                text = "Welcome to VaultSafe Offline. We prioritize your absolute privacy and data sovereignty. This Privacy Policy outlines how VaultSafe Offline protects your information when you use our mobile application.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "2. Local-Only Storage & Data Sovereignty")
            Text(
                text = "All data created, scanned, generated, or saved within VaultSafe Offline is stored exclusively on your local device. We utilize a secure local Room/SQLite database with optional AES-256 cryptographic protection. Your data never leaves your device, is never synced to external cloud servers, and is never accessible to us or any third parties.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "3. Absence of Internet Permissions")
            Text(
                text = "VaultSafe Offline does not request, require, or utilize any Internet or network access permissions (INTERNET, ACCESS_NETWORK_STATE) in its AndroidManifest.xml. Because the app has no network capability, it is technically impossible for data to be transmitted over the internet.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "4. Camera & Device Hardware Access")
            Text(
                text = "• Camera Permission: Required solely for real-time QR code and barcode scanning through your device camera viewfinder. Camera image buffers are processed entirely on-device in real time and are never recorded, cached, uploaded, or transmitted externally.\n\n• Storage Access: Used strictly when you choose to export generated QR codes or save secure items locally to your device storage.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "5. Third-Party Trackers & Analytics")
            Text(
                text = "Because VaultSafe Offline is fully offline and network-disabled, it contains no third-party analytics SDKs, advertising networks, crash reporters, or tracking beacons.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "6. Children's Privacy")
            Text(
                text = "VaultSafe Offline does not collect or solicit personal information from individuals of any age. Since all information remains 100% local to your device, no data is ever collected.",
                style = MaterialTheme.typography.bodyMedium
            )

            SectionTitle(title = "7. Contact & Support")
            Text(
                text = "If you have any questions regarding this Privacy Policy or VaultSafe Offline's security architecture, please contact us through our developer support channels.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}
