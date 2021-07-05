package com.uits.databinding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uits.databinding.databinding.ViewholderItemBinding
import com.uits.databinding.model.Person
import com.uits.databinding.model.Sound

class PersonAdapter(val context: Context, val mListSound: List<Sound>) :
    RecyclerView.Adapter<PersonAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewholderItemBinding>(
            inflater,
            R.layout.viewholder_item,
            parent,
            false
        )

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mListSound.size
    }

    inner class ItemViewHolder(itemView: ViewholderItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private lateinit var mBiding: ViewholderItemBinding

        init {
            mBiding = itemView
            itemView.personViewModel = PersonViewModel(context)
        }

        fun bind(sound: Sound) {
            mBiding.personViewModel
        }
    }
}