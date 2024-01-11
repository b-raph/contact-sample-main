package com.contacts.sample.data.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET

object ConnectedCompat {

  private val IMPL: ConnectedCompat

  init {
    IMPL = MarshMallowImpl
  }

  fun isConnected(connectivityManager: ConnectivityManager) =
    IMPL.isConnected(connectivityManager)

  internal interface ConnectedCompat {
    fun isConnected(connectivityManager: ConnectivityManager): Boolean
  }
  object MarshMallowImpl : ConnectedCompat {
    override fun isConnected(connectivityManager: ConnectivityManager): Boolean =
      connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        ?.hasCapability(NET_CAPABILITY_INTERNET) == true
  }
}