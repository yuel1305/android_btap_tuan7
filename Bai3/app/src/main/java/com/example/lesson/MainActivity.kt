package com.example.lesson

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson.ui.theme.LessonTheme

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var sinhVienAdapter: SinhVienAdapter
    private lateinit var searchEditText: EditText
    private lateinit var sinhVienList: List<SinhVien>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        recyclerView = findViewById(R.id.recyclerView)

        val sinhVienList = listOf(
            SinhVien("Nguyen Van H", "20211010"),
            SinhVien("Do Van O", "20211117"),
            SinhVien("Ngo Thi N", "20211600"),
            SinhVien("Dang Thi V", "20211302"),
            SinhVien("Pham Van C", "20211064"),
            SinhVien("Nguyen Van K", "20211161"),
            SinhVien("Ngo Thi D", "20211603"),
            SinhVien("Nguyen Van U", "20211113"),
            SinhVien("Vo Van H", "20211941"),
            SinhVien("Bui Van Z", "20211125"),
            SinhVien("Tran Thi X", "20211071"),
            SinhVien("Le Thi T", "20211498"),
            SinhVien("Hoang Thi R", "20211533"),
            SinhVien("Vo Van Q", "20211656"),
            SinhVien("Dang Thi M", "20211414"),
            SinhVien("Do Van P", "20211307"),
            SinhVien("Nguyen Van J", "20211585"),
            SinhVien("Le Thi A", "20211845"),
            SinhVien("Hoang Thi B", "20211231"),
            SinhVien("Pham Van Q", "20211401"),
            SinhVien("Dang Thi E", "20211022"),
            SinhVien("Ngo Thi G", "20211199"),
            SinhVien("Bui Van W", "20211455"),
            SinhVien("Vo Van A", "20211566"),
            SinhVien("Le Thi N", "20211788"),
            SinhVien("Tran Thi R", "20211643"),
            SinhVien("Hoang Thi Y", "20211298"),
            SinhVien("Nguyen Van L", "20211672"),
            SinhVien("Pham Van K", "20211339"),
            SinhVien("Tran Thi S", "20211547"),
            SinhVien("Le Thi F", "20211753"),
            SinhVien("Vo Van V", "20211920"),
            SinhVien("Hoang Thi T", "20211812"),
            SinhVien("Ngo Thi C", "20211303"),
            SinhVien("Do Van X", "20211837"),
            SinhVien("Nguyen Van E", "20211222"),
            SinhVien("Pham Van L", "20211765"),
            SinhVien("Le Thi P", "20211589"),
            SinhVien("Dang Thi Y", "20211234"),
            SinhVien("Vo Van F", "20211687"),
            SinhVien("Bui Van J", "20211811"),
            SinhVien("Do Van W", "20211992"),
            SinhVien("Pham Van S", "20211409"),
            SinhVien("Nguyen Van Q", "20211317"),
            SinhVien("Hoang Thi C", "20211504"),
            SinhVien("Bui Van T", "20211421"),
            SinhVien("Le Thi U", "20211740"),
            SinhVien("Dang Thi Z", "20211280"),
            SinhVien("Ngo Thi L", "20211719"),
            SinhVien("Tran Thi W", "20211253"),
            SinhVien("Do Van T", "20211182"),
            SinhVien("Nguyen Van V", "20211802"),
            SinhVien("Pham Van B", "20211964"),
            SinhVien("Le Thi Y", "20211698"),
            SinhVien("Tran Thi O", "20211934"),
            SinhVien("Vo Van B", "20211210"),
            SinhVien("Dang Thi K", "20211721"),
            SinhVien("Do Van Y", "20211349"),
            SinhVien("Pham Van Z", "20211114"),
            SinhVien("Hoang Thi L", "20211501"),
            SinhVien("Ngo Thi Q", "20211901"),
            SinhVien("Nguyen Van T", "20211527"),
            SinhVien("Bui Van H", "20211830"),
            SinhVien("Do Van V", "20211238"),
            SinhVien("Pham Van N", "20211372"),
            SinhVien("Ngo Thi X", "20211912"),
            SinhVien("Dang Thi B", "20211609"),
            SinhVien("Nguyen Van P", "20211781"),
            SinhVien("Le Thi D", "20211814"),
            SinhVien("Bui Van C", "20211398"),
            SinhVien("Vo Van U", "20211793"),
            SinhVien("Pham Van M", "20211158"),
            SinhVien("Do Van Q", "20211430"),
            SinhVien("Ngo Thi S", "20211311"),
            SinhVien("Dang Thi F", "20211645"),
            SinhVien("Hoang Thi H", "20211818"),
            SinhVien("Tran Thi Z", "20211476"),
            SinhVien("Nguyen Van F", "20211736"),
            SinhVien("Le Thi M", "20211120"),
            SinhVien("Ngo Thi T", "20211949"),
            SinhVien("Do Van M", "20211955"),
            SinhVien("Pham Van H", "20211299"),
            SinhVien("Vo Van D", "20211827"),
            SinhVien("Dang Thi C", "20211394"),
            SinhVien("Hoang Thi D", "20211171"),
            SinhVien("Bui Van O", "20211906"),
            SinhVien("Nguyen Van Z", "20211270"),
            SinhVien("Tran Thi E", "20211767"),
            SinhVien("Pham Van F", "20211664"),
            SinhVien("Dang Thi R", "20211148"),
            SinhVien("Nguyen Van S", "20211863"),
            SinhVien("Le Thi L", "20211560"),
            SinhVien("Bui Van M", "20211342"),
            SinhVien("Ngo Thi E", "20211434"),
            SinhVien("Vo Van E", "20211577"),
            SinhVien("Nguyen Van G", "20211910"),
            SinhVien("Do Van J", "20211227"),
            SinhVien("Pham Van T", "20211819"),
            SinhVien("Le Thi Q", "20211357"),
            SinhVien("Tran Thi G", "20211713"),
            SinhVien("Ngo Thi P", "20211447"),
            SinhVien("Bui Van I", "20211203"),
            SinhVien("Dang Thi J", "20211958"),
            SinhVien("Vo Van K", "20211595"),
            SinhVien("Hoang Thi M", "20211441"),
            SinhVien("Nguyen Van D", "20211889"),
            SinhVien("Do Van N", "20211684"),
            SinhVien("Pham Van U", "20211425"),
            SinhVien("Ngo Thi K", "20211776"),
            SinhVien("Bui Van Q", "20211923"),
            SinhVien("Le Thi G", "20211523"),
            SinhVien("Tran Thi I", "20211141"),
            SinhVien("Dang Thi P", "20211410"),
            SinhVien("Nguyen Van W", "20211975"),
            SinhVien("Hoang Thi W", "20211874"),
            SinhVien("Pham Van A", "20211505"),
            SinhVien("Vo Van X", "20211704"),
            SinhVien("Bui Van L", "20211420"),
            SinhVien("Do Van G", "20211591"),
            SinhVien("Le Thi B", "20211866"),
            SinhVien("Dang Thi L", "20211460"),
            SinhVien("Ngo Thi M", "20211952"),
            SinhVien("Nguyen Van M", "20211244"),
            SinhVien("Pham Van Y", "20211511"),
            SinhVien("Tran Thi K", "20211746"),
            SinhVien("Vo Van L", "20211853"),
            SinhVien("Dang Thi X", "20211931"),
            SinhVien("Bui Van R", "20211310"),
            SinhVien("Do Van B", "20211639"),
            SinhVien("Hoang Thi F", "20211284"),
            SinhVien("Ngo Thi F", "20211519"),
            SinhVien("Nguyen Van R", "20211485"),
            SinhVien("Tran Thi N", "20211880"),
            SinhVien("Pham Van E", "20211375"),
            SinhVien("Dang Thi A", "20211632"),
            SinhVien("Vo Van M", "20211538"),
            SinhVien("Le Thi K", "20211985"),
            SinhVien("Ngo Thi Y", "20211554"),
            SinhVien("Do Van L", "20211769"),
            SinhVien("Bui Van K", "20211890"),
            SinhVien("Nguyen Van I", "20211408"),
            SinhVien("Hoang Thi E", "20211250"),
            SinhVien("Tran Thi P", "20211347"),
            SinhVien("Vo Van S", "20211579"),
            SinhVien("Dang Thi U", "20211729"),
            SinhVien("Ngo Thi I", "20211206"),
            SinhVien("Do Van C", "20211873"),
            SinhVien("Pham Van D", "20211386"),
            SinhVien("Le Thi H", "20211913"),
            SinhVien("Vo Van Y", "20211852"),
            SinhVien("Bui Van Y", "20211744"),
            SinhVien("Dang Thi T", "20211582"),
            SinhVien("Ngo Thi Z", "20211491")
        )


        sinhVienAdapter = SinhVienAdapter(sinhVienList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = sinhVienAdapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString()
                if (keyword.length > 2) {
                    val filteredList = sinhVienList.filter {
                        it.hoTen.contains(keyword, ignoreCase = true) ||
                                it.mssv.contains(keyword, ignoreCase = true)
                    }
                    sinhVienAdapter.updateList(filteredList)
                } else {
                    sinhVienAdapter.updateList(sinhVienList)
                }
            }
        })
    }
}

