package edu.temple.fancyscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profilePhoto = findViewById<ImageView>(R.id.profile_photo)
        val nameTextView = findViewById<TextView>(R.id.name)
        val emailTextView = findViewById<TextView>(R.id.email)
        val extensionTextView = findViewById<TextView>(R.id.extension)
        val departmentTextView = findViewById<TextView>(R.id.department)
        val supervisorTextView = findViewById<TextView>(R.id.supervisor)
        val directReportsRecyclerView = findViewById<RecyclerView>(R.id.directReportsRecyclerView)

        profilePhoto.setImageResource(R.drawable.istockphoto)
        nameTextView.text = "Michelle Townsend"
        emailTextView.text = "mt@ourcompany.com"
        emailTextView.setTextColor(Color.BLUE)
        extensionTextView.text = "2253"
        departmentTextView.text = "Design"
        supervisorTextView.text = "Gail Davers"

        val staffList = arrayOf(
            "Kate Sacloff",
            "Andrew Klein",
            "Maria Ortega",
            "Brent Stevenson",
            "Daniel Cho",
            "Jorge Gomez"
        )

        directReportsRecyclerView.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.grid_columns))
        directReportsRecyclerView.adapter = RecyclerViewAdapter(staffList)
    }
}

class RecyclerViewAdapter (private val staffList: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.StaffListViewHolder>() {
    class StaffListViewHolder(val textView: TextView) : ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffListViewHolder {
        val textView = TextView(parent.context).apply {
            textSize = 22f
            setTextColor(Color.BLUE)
            setPadding(50, 8, 0, 8)
        }
        return StaffListViewHolder(textView)
    }

    override fun getItemCount() = staffList.size

    override fun onBindViewHolder(holder: StaffListViewHolder, position: Int) {
        holder.textView.text = staffList[position]
    }
}