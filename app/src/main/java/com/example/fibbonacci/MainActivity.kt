package com.example.fibbonacci

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fibbonacci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fibonacciGenerator = FibonacciGenerator()
        val fibonacciNumbers = fibonacciGenerator.generateFibonacciSequence(100)
        binding.rvFibbonacci.layoutManager = LinearLayoutManager(this)
       val fibonacciAdapter = FibonacciRecyclerViewAdapter(fibonacciNumbers)
       binding.rvFibbonacci.adapter = fibonacciAdapter
    }
}

class FibonacciGenerator {
    fun generateFibonacciSequence(n: Int): List<Int> {
        val fibSequence = mutableListOf(0, 1)
        var a = 0
        var b = 1
        for (i in 2 until n) {
            val sum = a + b
            fibSequence.add(sum)
            a = b
            b = sum
        }
        return fibSequence
    }
}

