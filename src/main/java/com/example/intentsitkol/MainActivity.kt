package com.example.intentsitkol

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_move_with_result)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        ProdiReceived()
    }
    override fun onClick(view: View) {
        if (view!=null) {
            when(view.id) {
                R.id.btn_move_activity -> kotlin.run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_with_data -> kotlin.run {
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "Olip")
                    bundle.putString("Alamat", "Tgalek")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> kotlin.run {
                    var dialNumber = "085895789335"
                   val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_move_with_result -> {
                    val intent = Intent(this, MoveForResult::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    private fun ProdiReceived() {
        val bundle = intent.extras
        val prodi = bundle?.getString("Prodi")
        tvResult.text = prodi
    }
}