package com.prabha.smi.base.receiver

interface INetworkChangeCallback {
    fun onInternetConnected()
    fun onInternetDisconnected()
}