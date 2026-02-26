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
        nameTextView.text = getString(R.string.michelle_townsend)
        emailTextView.text = getString(R.string.michelle_email)
        emailTextView.setTextColor(Color.BLUE)
        extensionTextView.text = getString(R.string.michelle_extension)
        departmentTextView.text = getString(R.string.michelle_department)
        supervisorTextView.text = getString(R.string.michelle_supervisor)

        val staffList = arrayOf(
            getString(R.string.kate_sacloff),
            getString(R.string.andrew_klein),
            getString(R.string.maria_ortega),
            getString(R.string.brent_stevenson),
            getString(R.string.daniel_cho),
            getString(R.string.jorge_gomez)
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