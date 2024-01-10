package com.contacts.sample.data.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NetworkMonitor @Inject constructor(
  private val connectivityManager: ConnectivityManager
) {

  private val _isConnectedFlow = MutableStateFlow(false)
  val isConnectedFlow: StateFlow<Boolean> get() = _isConnectedFlow

  init {
    val callback = object : ConnectivityManager.NetworkCallback() {
      override fun onAvailable(network: Network) {
        super.onAvailable(network)
        _isConnectedFlow.value = true
      }

      override fun onLost(network: Network) {
        _isConnectedFlow.value = false
        super.onLost(network)
      }
    }

    val request = NetworkRequest.Builder()
      .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
      .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
      .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
      .build()

    connectivityManager.registerNetworkCallback(request, callback)

    CoroutineScope(Dispatchers.Main).launch {
      flow {
        emit(ConnectedCompat.isConnected(connectivityManager))
      }.collect {
        _isConnectedFlow.value = it
      }
    }
  }

  fun getInitializedIsConnected(): Boolean {
    return isConnectedFlow.value
  }
}