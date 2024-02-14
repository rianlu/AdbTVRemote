package com.wzl.adbtvremote

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wzl.adbtvremote.databinding.ActivityConnectBinding

class ConnectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConnectBinding
    private val viewModel: AdbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.initAdbServer()

        binding.connectBtn.setOnClickListener {
            val ip = binding.ipTextField.editText?.text.toString()
            val port = binding.portTextField.editText?.text.toString()
            if (ip.isEmpty() || port.isEmpty()) {
                return@setOnClickListener
            }
            val response = viewModel.connect(ip, port)
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            if (response.contains("already connected")) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}