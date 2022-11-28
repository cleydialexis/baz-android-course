package com.example.criptos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.criptos.R
import com.example.criptos.data.utils.toast
import com.example.criptos.databinding.FragmentAvailableBooksBinding

import com.example.criptos.domain.repository.model.AvailableBook
import com.example.criptos.ui.adapter.AvailableBooksListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvailableBooksFragment : Fragment() {

    private val availableBooksVM by viewModels <AvailableBooksViewModel>()
    private lateinit var binding: FragmentAvailableBooksBinding
    private val availableBooksAdapterList: AvailableBooksListAdapter by lazy {
        AvailableBooksListAdapter(  emptyList(),
            goToDetail = { availableBook, coinName ->
                val bundle = bundleOf(
                    "book_code" to availableBook?.book.orEmpty(),
                    "coin_code" to coinName
                )
                findNavController().navigate(R.id.orderBookDetailFragment, bundle)

            })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvailableBooksBinding.inflate(
            layoutInflater,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        availableBooksVM.getAvailableBooks()

        binding.apply {

            rvBooks.adapter = availableBooksAdapterList

            availableBooksVM.isLoading.observe(viewLifecycleOwner) {
                if (it) {
                    progressCircular.visibility=View.VISIBLE
                } else {
                    progressCircular.visibility=View.GONE
                }
            }
            availableBooksVM.availableOrderBookList.observe(viewLifecycleOwner) {
                availableBooksAdapterList.submitList(it)

            }

            availableBooksVM.error.observe(viewLifecycleOwner) {
                toast(it)
            }
        }
    }
}


