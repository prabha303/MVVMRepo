package com.match.matchmakers.base.receiver

interface INetworkChangeCallback {
    fun onInternetConnected()
    fun onInternetDisconnected()
}