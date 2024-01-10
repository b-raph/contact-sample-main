package com.contacts.sample.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun getTypography(colorScheme: ColorScheme) =
    Typography(
        headlineSmall = MaterialTheme.typography.headlineSmall.copy(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.onBackground
        ),
        titleLarge = MaterialTheme.typography.titleLarge.copy(
            fontSize = 20.sp,
            color = colorScheme.onSurface
        ),
        labelMedium = MaterialTheme.typography.labelMedium.copy(
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = colorScheme.onSecondary
        )
    )