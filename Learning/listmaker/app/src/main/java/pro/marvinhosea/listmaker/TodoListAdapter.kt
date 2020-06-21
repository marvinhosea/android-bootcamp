package pro.marvinhosea.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter: RecyclerView.Adapter<TodoListViewHolder>() {
    var todoListItems = mutableListOf("Android development", "House work", "Errands", "Marvin Lab", "Marvin Collins", "Recycle view");

    fun addItem(){
        todoListItems.add("Todo list " + (todoListItems.size +1))
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lis_view_holder, parent, false)

        return TodoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoListItems.size
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.listPositionTexView.text = (position + 1).toString()
        holder.listTitleTextView.text = todoListItems[position]
    }

}