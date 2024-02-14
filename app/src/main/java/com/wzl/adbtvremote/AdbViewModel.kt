package com.wzl.adbtvremote

import android.app.Application
import android.content.Context
import android.view.KeyEvent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class AdbViewModel(application: Application): AndroidViewModel(application) {

    private var adb: ADB? = null
    private val context = application.applicationContext

    init {
        adb = ADB.getInstance(context)
    }

    fun initAdbServer(): String {
        return adb?.runCommand(listOf("start-server")) ?: ""
    }

    fun connect(ip: String, port: String = "5555"): String {
        val commandList = mutableListOf<String>()
        commandList.add("connect")
        commandList.add("$ip:$port")
        return adb?.runCommand(commandList) ?: ""
    }

    fun execyte(command: String): String {
        return adb?.runCommand(command.removePrefix("adb ").split(" ").toList()) ?: ""
    }

    fun keyEvent(keyCode: Int) {
        val commandList = mutableListOf<String>()
        commandList.add("shell")
        commandList.add("input")
        commandList.add("keyevent")
        commandList.add(keyCode.toString())
        adb?.runCommand(commandList)
    }

    /**
     * 输入文本
     */
    fun text(text: String) {
        val commandList = mutableListOf<String>()
        commandList.add("shell")
        commandList.add("input")
        commandList.add("text")
        commandList.add(text)
        adb?.runCommand(commandList)
    }
}