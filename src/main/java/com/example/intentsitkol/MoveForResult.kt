package com.example.intentsitkol

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MoveForResult : AppCompatActivity() {
    var rgProdi: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var btnChoose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        rgProdi = findViewById(R.id.rg_prodi)
        btnChoose = findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener {
            val selectedOption: Int = rgProdi!!.checkedRadioButtonId
            radioButton = findViewById(selectedOption)

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Prodi", radioButton.text as String?)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}