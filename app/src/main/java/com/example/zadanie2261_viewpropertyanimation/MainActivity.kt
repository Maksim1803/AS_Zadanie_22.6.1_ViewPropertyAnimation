package com.example.zadanie2261_viewpropertyanimation

import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie2261_viewpropertyanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startRocketAnimation()
        }
    }
    private fun startRocketAnimation() {
        // Исчезновение ракеты
        binding.rocketView.animate()
            .setDuration(4000)
            .setInterpolator(DecelerateInterpolator())
            .alpha(0f)
            .withStartAction {
                Log.d("Animation", "Исчезновение ракеты")
                Toast.makeText(this@MainActivity, "Исчезновение ракеты", Toast.LENGTH_SHORT).show()
            }
            .withEndAction {
                // Появление ракеты (после исчезновения)
                binding.rocketView.animate()
                    .setDuration(4000)
                    .alpha(1f)
                    .withStartAction {
                        Log.d("Animation", "Появление ракеты")
                        Toast.makeText(this@MainActivity, "Появление ракеты", Toast.LENGTH_SHORT).show()
                    }
                    .start()
            }
            .start()
    }
}