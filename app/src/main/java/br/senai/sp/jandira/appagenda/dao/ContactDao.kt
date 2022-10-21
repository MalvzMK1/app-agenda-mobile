package br.senai.sp.jandira.appagenda.dao

import androidx.room.*
import br.senai.sp.jandira.appagenda.model.Contact

@Dao
interface ContactDao {

  @Insert
  fun save(contact: Contact): Long

  @Delete
  fun delete(contact: Contact): Int

  @Update
  fun update(contact: Contact): Int

  @Query("SELECT * FROM tbl_contact ORDER BY name ASC")
  fun getAll(): List<Contact>

  // :id -> parametro da funcao
  @Query("SELECT * FROM tbl_contact WHERE id = :id")
  fun getContactById(id: Int): Contact

}