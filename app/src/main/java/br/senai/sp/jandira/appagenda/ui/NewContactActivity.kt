package br.senai.sp.jandira.appagenda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.senai.sp.jandira.appagenda.databinding.ActivityNewContactBinding
import br.senai.sp.jandira.appagenda.model.Contact
import br.senai.sp.jandira.appagenda.repository.ContactRepository

class NewContactActivity : AppCompatActivity() {

  private lateinit var binding: ActivityNewContactBinding
  private var contactRepository = ContactRepository(this)
  private var id = 0
  private var contact = Contact()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityNewContactBinding.inflate(layoutInflater)

    setContentView(binding.root)

    binding.buttonSave.setOnClickListener {
      save()
    }

    binding.buttonDelete.setOnClickListener {
      delete()
    }

    id = intent.getIntExtra("contactId", 0)

    if (id > 0) {
      binding.buttonDelete.visibility = View.VISIBLE
      binding.buttonSave.text = "Atualizar"
      loadContact()
    }

  }

  private fun loadContact() {
    contact = contactRepository.getContactById(id)

    binding.editTextName.setText(contact.name)
    binding.editTextEmail.setText(contact.email)
    binding.editTextPhone.setText(contact.phone)
    binding.editTextDate.setText(contact.birthDate)
  }

  private fun save() {
    contact.birthDate = binding.editTextDate.text.toString()
    contact.name = binding.editTextName.text.toString()
    contact.phone = binding.editTextPhone.text.toString()
    contact.email = binding.editTextEmail.text.toString()

    if (id > 0) {
      contact.id = id
      contactRepository.update(contact)
    } else {
      val id = contactRepository.save(contact)
    }

    finish()
  }

  private fun delete() {

    val builder = AlertDialog.Builder(this)
    builder.setTitle("Exclusão")
    builder.setMessage("Confirma a exclusão do(a) ${contact.name}")
    builder.setPositiveButton("Sim"){ _, _ ->
      contactRepository.delete(contact)
      finish()
    }
    builder.setNegativeButton("Não"){ _, _ ->

    }

    builder.show()
  }

}