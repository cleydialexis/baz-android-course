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
import com.example.criptos.databinding.FragmentCoinsBinding
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.domain.repository.model.Book
import com.example.criptos.ui.adapter.CoinsAdapter
import com.example.criptos.ui.viewModels.CoinViewModel
import com.example.criptos.util.Constants.BOOKSKEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CoinsFragment : Fragment() {
    @Inject
    lateinit var booksDao: BooksDao
    private var _binding: FragmentCoinsBinding? = null
    private val binding get() = _binding!!
    var bundle = bundleOf()

    private val coinViewModel: CoinViewModel by viewModels()


    private val adapter by lazy {
        CoinsAdapter {
            onBookClick(it)
        }
    }

    private fun onBookClick(book: Book) {
        bundle.putSerializable(BOOKSKEY, book)
     //   findNavController().navigate(R.id.action_coinsFragment_to_detailCoinFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoinsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callServices()
        attachObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCoins.adapter = adapter
    }

    private fun attachObservers() {
        coinViewModel.cryptoBook.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun callServices() {
        coinViewModel.getAvailableBooks()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}