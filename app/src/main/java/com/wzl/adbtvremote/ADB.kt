package com.wzl.adbtvremote

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class ADB(private val context: Context) {

    companion object {

        private var instance: ADB? = null

        fun getInstance(context: Context): ADB = instance ?: synchronized(this) {
            instance ?: ADB(context).also { instance = it }
        }
    }

    private val adbPath = "${context.applicationInfo.nativeLibraryDir}/libadb.so"

    fun runCommand(commandList: List<String>): String {
        val adbList = commandList.toMutableList()
        adbList.add(0, adbPath)
        val processBuilder = ProcessBuilder()
        .apply {
            directory(context.filesDir)
            apply {
                environment().apply {
                    put("HOME", context.filesDir.path)
                    put("TMPDIR", context.cacheDir.path)
                }
            }
            redirectErrorStream(true)
        }
        processBuilder.command(adbList)
        val process = processBuilder.start()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        return reader.buffered().use { it.readText() }
    }
}