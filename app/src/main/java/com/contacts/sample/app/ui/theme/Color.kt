package com.contacts.sample.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Mystic = Color(0xFFD7DFE8)
val PaleSky = Color(0xFF5F7081)
val CatskillWhite = Color(0xFFF2F4F8)

val LightColorScheme = lightColorScheme(
  primary = Color.White,
  secondary = CatskillWhite,
  tertiary = Mystic,
  surface = CatskillWhite,
  background = Color.White,
  onBackground = Color.Black,
  onPrimary = Color.Black,
  onSecondary = PaleSky,
  onSurface = Color.Black
)

@Composable
fun createColorScheme(): ColorScheme {
  return LightColorScheme
}