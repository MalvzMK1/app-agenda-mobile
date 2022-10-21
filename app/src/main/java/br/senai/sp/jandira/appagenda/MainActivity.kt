package br.senai.sp.jandira.appagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Entity
import br.senai.sp.jandira.appagenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}