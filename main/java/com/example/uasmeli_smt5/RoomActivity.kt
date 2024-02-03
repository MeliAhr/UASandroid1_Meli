package com.example.uasmeli_smt5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uasmeli_smt5.databinding.ActivityMainBinding
import com.example.uasmeli_smt5.db.NoteRoomDatabase
import com.example.uasmeli_smt5.model.Note
import com.example.uasmeli_smt5.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Cek apakah data sudah dimasukkan sebelumnya
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val isDataInserted = sharedPreferences.getBoolean("isDataInserted", false)

        if (!isDataInserted) {
            // Jika belum dimasukkan, maka masukkan data dan simpan status ke shared preferences
            addDummyData()
            sharedPreferences.edit().putBoolean("isDataInserted", true).apply()
        }

        // Menampilkan data dari database ke dalam RecyclerView
        getNotesDate()

        binding.floatingAdd.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun addDummyData() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()

        // Membuat 50 data dan memasukkannya ke dalam database
        // Data dummy
        val dummyDataList = listOf(
            Note(
                npm = "2169700018",
                nama = "Meli Ai Hayati Rahmah",
                nilai = "100",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700012",
                nama = "Ratu Nurul Fauziah",
                nilai = "100",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700028",
                nama = "Firman Tegar",
                nilai = "100",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700022",
                nama = "Toibul Khoiri",
                nilai = "95",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700024",
                nama = "Harys Haqim Kurniawan",
                nilai = "100",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700041",
                nama = "Ilham Rizky",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                npm = "2169700042",
                nama = "Wita Dwiyanti",
                nilai = "80",
                keterangan = "lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700044",
                nama = "Dwiki Wisnu Aji",
                nilai = "85",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700038",
                nama = "Kosmara",
                nilai = "65",
                keterangan = "Tidak Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700036",
                nama = "Ersa Putra Riano",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700037",
                nama = "Siti Muslihah",
                nilai = "90",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700036",
                nama = "Lina Faujiah",
                nilai = "85",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700035",
                nama = "Yusuf Ardiansyah",
                nilai = "45",
                keterangan = "Tidak Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700030",
                nama = "Lulu Fauziyah",
                nilai = "85",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700029",
                nama = "Chandra Yulistianto",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700008",
                nama = "Lukman Muhamad Syamil",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700013",
                nama = "Anna Silvana",
                nilai = "78",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700014",
                nama = "Adi Suharyadi",
                nilai = "60",
                keterangan = "Tidak lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700015",
                nama = "Dani Ramadon",
                nilai = "55",
                keterangan = "Tidak lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700019",
                nama = "Duta Rizky Darmawan",
                nilai = "85",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700020",
                nama = "Wahyu Hidayat",
                nilai = "45",
                keterangan = "Tidak lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700021",
                nama = "Riska Yulinar",
                nilai = "75",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700025",
                nama = "Gilang Pramudya Asega",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "75"
            ),
            Note(
                npm = "2169700027",
                nama = "Tapan Nurzaman Malik",
                nilai = "60",
                keterangan = "Tidak lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700001",
                nama = "Salsa Dwiyanti",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700004",
                nama = "Yeni Nuraeni",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700005",
                nama = "Tiara Agustin",
                nilai = "85",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700006",
                nama = "Listiani Lesveva Setiawan",
                nilai = "80",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2169700007",
                nama = "Sendi Rahman Huda",
                nilai = "70",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
            Note(
                npm = "2069700002",
                nama = "Tomi Riki Saputra",
                nilai = "60",
                keterangan = "Tidak Lulus",
                jumlahsks = "21",
                hargasks = "20000"
            ),
        )

        // Menambahkan data ke dalam database
        for (dummyNote in dummyDataList) {
            dao.insert(dummyNote)
        }
    }


    private fun getNotesDate() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()
        val listItems = arrayListOf<Note>()
        listItems.addAll(dao.getAll())
        setupRecyclerView(listItems)
    }

    private fun setupRecyclerView(listItems: ArrayList<Note>) {
        binding.recycleViewMain.apply {
            adapter = NoteAdapter(listItems, object : NoteAdapter.NoteListener {
                override fun OnItemClicked(note: Note) {
                    val intent = Intent(this@RoomActivity, EditActivity::class.java)
                    intent.putExtra(EditActivity().EDIT_NOTE_EXTRA, note)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@RoomActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getNotesDate()
    }
}