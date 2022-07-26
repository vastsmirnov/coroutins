package com.vast.coroutines.presentation.animals.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vast.coroutines.databinding.FragmentAnimalListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalListFragment : Fragment() {
    lateinit var binding: FragmentAnimalListBinding

    private val animalListViewModel by viewModel<AnimalListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimalListBinding.inflate(
            inflater,
            container,
            false
        )

        val adapter = AnimalListAdapter()

        animalListViewModel.animalListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.apply {
            animalListRecycleView.layoutManager = LinearLayoutManager(this.root.context)
            animalListRecycleView.adapter = adapter
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnimalListFragment()
    }
}