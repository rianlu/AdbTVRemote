package com.wzl.adbtvremote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.wzl.adbtvremote.databinding.ActivityCommandBinding
import com.wzl.adbtvremote.databinding.ActivityConnectBinding

class CommandActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommandBinding
    private val viewModel: AdbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeCommandBtn.setOnClickListener {
            val command = binding.commandTextField.editText?.text.toString()
            if (command.isEmpty()) return@setOnClickListener
            val response = viewModel.execyte(command)
            binding.outputText.append(response)
            binding.commandTextField.editText?.setText("")
        }
    }
}