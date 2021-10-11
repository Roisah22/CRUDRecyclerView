package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNIS : EditText
    private lateinit var inputNama : EditText
    private lateinit var jkLakiLaki : RadioButton
    private lateinit var jkPerempuan : RadioButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnTambah : Button
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById(R.id.txtInputNIS)
        inputNama = findViewById(R.id.txtInputNama)
        jkLakiLaki = findViewById(R.id.rbLakiLaki)
        jkPerempuan= findViewById(R.id.rbPerempuan)
        btnTambah = findViewById(R.id.btnTambah)
        recyclerView = findViewById(R.id.listData)
        val data = mutableListOf<SiswaData>()
        viewManager =LinearLayoutManager(this)
        recyclerAdapter = SiswaAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
        btnTambah.setOnClickListener{  //1.membuat variabel penyimpan data
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jk = ""
            if(jkLakiLaki.isChecked){
                jk = "Laki-Laki"
            }else {
                jk = "Perempuan"
            }
            // simpan data ke array mutableList
            val dataSiswa = SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()}

    }
}