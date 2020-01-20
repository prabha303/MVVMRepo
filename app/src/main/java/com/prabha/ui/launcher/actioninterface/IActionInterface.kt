package com.lynk.cardlibrary.actioninterface

import com.prabha.ui.launcher.model.SubCategory


interface IActionInterface {
    fun onAction(action: Boolean, model: SubCategory, category: String)
}