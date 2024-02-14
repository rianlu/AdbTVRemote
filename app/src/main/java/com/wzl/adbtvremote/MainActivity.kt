package com.wzl.adbtvremote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import com.wzl.adbtvremote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: AdbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.upBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_DPAD_UP)
        }
        binding.downBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_DPAD_DOWN)
        }
        binding.leftBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_DPAD_LEFT)
        }
        binding.rightBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_DPAD_RIGHT)
        }
        binding.homeBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_HOME)
        }
        binding.menuBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_MENU)
        }
        binding.backBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_BACK)
        }
        binding.volumeUpBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_VOLUME_UP)
        }
        binding.volumeDownBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_VOLUME_DOWN)
        }
        binding.muteVolumeBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_VOLUME_MUTE)
        }
        binding.switchAppBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_APP_SWITCH)
        }
        binding.settingsBtn.setOnClickListener {
            viewModel.keyEvent(KeyEvent.KEYCODE_SETTINGS)
        }
    }
}