package br.senai.sp.jandira.appagenda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.appagenda.databinding.ActivityMainBinding
import br.senai.sp.jandira.appagenda.databinding.ActivityNewContactBinding

class NewContactActivity : AppCompatActivity() {

  private lateinit var binding: ActivityNewContactBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityNewContactBinding.inflate(layoutInflater)

    setContentView(binding.root)
  }
}