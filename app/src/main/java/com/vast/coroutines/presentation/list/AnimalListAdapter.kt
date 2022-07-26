package com.vast.coroutines.presentation.animals.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vast.coroutines.R
import com.vast.coroutines.databinding.AnimalListItemBinding
import com.vast.coroutines.domain.animals.Animal

class AnimalListAdapter : ListAdapter<Animal, AnimalListAdapter.AnimalListHolder>(diffCallback) {
    companion object {
        private val diffCallback
            get() = object : DiffUtil.ItemCallback<Animal>() {
                override fun areItemsTheSame(
                    oldItem: Animal,
                    newItem: Animal
                ): Boolean = (oldItem.id == newItem.id)

                override fun areContentsTheSame(
                    oldItem: Animal,
                    newItem: Animal
                ): Boolean = (oldItem == newItem)
            }
    }

    class AnimalListHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = AnimalListItemBinding.bind(item)
        fun bind(animal: Animal) = with(binding) {
            animalName.text = animal.name
            animalId.text = animal.id.toString()
            animalImage.contentDescription = animal.name
            Picasso.get().load(animal.imageLink).into(animalImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalListHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_list_item, parent, false)

        return AnimalListHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalListHolder, position: Int) {
        holder.bind(getItem(position))
    }
}