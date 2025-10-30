package com.example.unisuki.adapter

//noinspection SuspiciousImport
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.unisuki.R
import com.example.unisuki.databinding.ViewholderCategoryBinding
import com.example.unisuki.domain.CategoryModel

class CategoryAdapter(val items: List<CategoryModel>):
RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    private var selectedPosotion = -1
    private var lastselectedPosition = -1

    class Viewholder(val binding: ViewholderCategoryBinding):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.Viewholder {
        val binding= ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleTxt.text = item.title
        if (selectedPosotion == position) {
            holder.binding.titleTxt.setBackgroundColor(R.drawable.grey_bg)
            holder.binding.titleTxt.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.slate600
                )
            )
    } else {
            holder.binding.titleTxt.setBackgroundColor(R.drawable.grey_bg)
            holder.binding.titleTxt.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.black
                )
            )
        }

        holder.binding.root.setOnClickListener {
            val position = position
            if(position!= RecyclerView.NO_POSITION){
                lastselectedPosition = selectedPosotion
                selectedPosotion=position
                notifyItemChanged(lastselectedPosition)
                notifyItemChanged(selectedPosotion)
            }
        }
    }

    override fun getItemCount(): Int = items.size

}



