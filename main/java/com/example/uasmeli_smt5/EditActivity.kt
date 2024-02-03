package com.example.uasmeli_smt5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.uasmeli_smt5.databinding.ActivityEditBinding
import com.example.uasmeli_smt5.db.NoteDao
import com.example.uasmeli_smt5.db.NoteRoomDatabase
import com.example.uasmeli_smt5.model.Note

@Suppress("DEPRECATION")
class EditActivity : AppCompatActivity() {

    val EDIT_NOTE_EXTRA = "edit_note_extra"
    private  lateinit var note: Note
    private var isUpdate = false
    private lateinit var database: NoteRoomDatabase
    private lateinit var dao: NoteDao


    private lateinit var binding: ActivityEditBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = NoteRoomDatabase.getDatabase(applicationContext)
        dao = database.getNoteDao()


        if (intent.getParcelableExtra<Note>(EDIT_NOTE_EXTRA) != null) {
            binding.buttonDelete.visibility = View.VISIBLE
            isUpdate = true
            note = intent.getParcelableExtra(EDIT_NOTE_EXTRA)!!
            binding.editTextTitle.setText(note.npm)
            binding.editTextBody2.setText(note.nama)
            binding.editTextBody3.setText(note.nilai)
            binding.editTextBody4.setText(note.keterangan)
            binding.editTextBody5.setText(note.jumlahsks)
            binding.editTextBody6.setText(note.hargasks)

            binding.editTextTitle.setSelection(note.npm.length)

        }

        binding.buttonSave.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val body = binding.editTextBody2.text.toString()
            val nilai = binding.editTextBody3.text.toString()
            val keterangan = binding.editTextBody4.text.toString()
            val jumlahsks = binding.editTextBody5.text.toString()
            val hargasks = binding.editTextBody6.text.toString()

            if (title.isEmpty() && body.isEmpty()) {
                Toast.makeText(applicationContext, "Note cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (isUpdate) {
                    saveNote(
                        Note(
                            id = note.id,
                            npm = title,
                            nama = body,
                            nilai = nilai,
                            keterangan = keterangan,
                            jumlahsks = jumlahsks,
                            hargasks = hargasks
                        )
                    )
                } else {
                    saveNote(Note(npm = title,
                        nama = body,
                        nilai = nilai,
                        keterangan = keterangan,
                        jumlahsks = jumlahsks,
                        hargasks = hargasks))
                }
            }

            finish()
        }

        binding.buttonDelete.setOnClickListener {
            deleteNote(note)
            finish()
        }
    }
        private fun saveNote(note: Note){

            if (isUpdate) {
                dao.update(note)
            } else {
                dao.insert(note)
            }

            Toast.makeText(applicationContext, "Note saved", Toast.LENGTH_SHORT).show()
        }

        private fun deleteNote(note: Note){
            dao.delete(note)
            Toast.makeText(applicationContext, "Note remove", Toast.LENGTH_SHORT).show()
        }
    }