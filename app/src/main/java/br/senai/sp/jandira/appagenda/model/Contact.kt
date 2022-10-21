package br.senai.sp.jandira.appagenda.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

// Definindo a classe como uma entidade e renomeando ela
@Entity (tableName = "tbl_contact")
class Contact {

    // Definindo chave primária e auto increment
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var name = ""
    var telefone = ""
    var photo: Drawable? = null

    // renomeando a coluna do banco
    @ColumnInfo(name = "birth_date")
    var birthDate: LocalDate? = null
}