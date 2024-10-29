package com.example.bai1

import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val radioPerfectSquare = findViewById<RadioButton>(R.id.radioPerfectSquare)
        val buttonShow = findViewById<Button>(R.id.buttonShow)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textViewError = findViewById<TextView>(R.id.textViewError)

        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonShow.setOnClickListener {
            val inputText = editTextNumber.text.toString()

            if (inputText.isEmpty()) {
                textViewError.text = "Vui lòng nhập số nguyên dương"
                return@setOnClickListener
            }

            val n = inputText.toIntOrNull()
            if (n == null || n <= 0) {
                textViewError.text = "Vui lòng nhập số nguyên dương hợp lệ"
                return@setOnClickListener
            }

            textViewError.text = "" // Xóa thông báo lỗi nếu dữ liệu hợp lệ
            val numberList = mutableListOf<Int>()

            // Xử lý theo lựa chọn của người dùng
            when {
                radioEven.isChecked -> {
                    for (i in 0..n step 2) {
                        numberList.add(i)
                    }
                }
                radioOdd.isChecked -> {
                    for (i in 1..n step 2) {
                        numberList.add(i)
                    }
                }
                radioPerfectSquare.isChecked -> {
                    for (i in 0..n) {
                        val sqrtVal = sqrt(i.toDouble())
                        if (sqrtVal == sqrtVal.toInt().toDouble()) {
                            numberList.add(i)
                        }
                    }
                }
                else -> {
                    textViewError.text = "Vui lòng chọn loại số"
                    return@setOnClickListener
                }
            }

            // Hiển thị danh sách kết quả trong RecyclerView
            recyclerView.adapter = NumberAdapter(numberList)
        }
    }
}

// Adapter cho RecyclerView để hiển thị danh sách số
class NumberAdapter(private val numberList: List<Int>) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    class NumberViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val textView = TextView(parent.context)
        textView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.setPadding(16, 16, 16, 16)
        return NumberViewHolder(textView)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numberList[position].toString()
    }

    override fun getItemCount() = numberList.size
}
