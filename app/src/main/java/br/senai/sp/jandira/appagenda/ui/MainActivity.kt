package br.senai.sp.jandira.appagenda.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.appagenda.adapter.ContactAdapter
import br.senai.sp.jandira.appagenda.databinding.ActivityMainBinding
import br.senai.sp.jandira.appagenda.repository.ContactRepository

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var contactAdapter: ContactAdapter
  private lateinit var contactRepository: ContactRepository

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.fbNewContact.setOnClickListener {
      val openRegister = Intent(this, NewContactActivity::class.java)
      startActivity(openRegister)
    }
  }

  override fun onResume() {
    super.onResume()
    loadRecyclerView()
  }

  private fun loadRecyclerView() {

    contactRepository = ContactRepository(this)

    val contacts = contactRepository.getAll()
    contactAdapter = ContactAdapter(contacts, this)
    binding.rvContacts.adapter = contactAdapter

    binding.rvContacts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    contactAdapter.updateContactList(contactRepository.getAll())
  }
}