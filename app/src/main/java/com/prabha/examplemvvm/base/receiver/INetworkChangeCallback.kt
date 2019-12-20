package com.prabha.examplemvvm.base.receiver

interface INetworkChangeCallback {
    fun onInternetConnected()
    fun onInternetDisconnected()
}