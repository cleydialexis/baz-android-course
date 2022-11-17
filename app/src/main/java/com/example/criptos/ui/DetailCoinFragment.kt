package com.example.criptos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.criptos.R
import com.example.criptos.databinding.FragmentDetailCoinBinding
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.domain.repository.model.Book
import com.example.criptos.domain.repository.model.BookDetail
import com.example.criptos.ui.adapter.AsksAdapter
import com.example.criptos.ui.adapter.BidsAdapter
import com.example.criptos.ui.viewModels.DetailCoinViewModel
import com.example.criptos.util.Constants.BOOKSKEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailCoinFragment : Fragment() {
    @Inject
    lateinit var booksDao: BooksDao
    private var _binding: FragmentDetailCoinBinding? = null
    private val binding get() = _binding!!
    var type: String = ""

    private val adapter by lazy {
        BidsAdapter { bid ->
            bid
        }
    }

    private val adapterAsks by lazy {
        AsksAdapter { asks ->
            asks
        }
    }

    private val detailCoinViewModel: DetailCoinViewModel by viewModels()
    /* {
         ViewModelFactorym(DetailCoinUseCase(DetailCoinRepositoryImpl(retrofit, booksDao)))
     }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailCoinBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var typeCoin = it.getSerializable(BOOKSKEY)
            type = typeCoin.toString()
            if (typeCoin is Book) {
                callServices(typeCoin.id)
                attachObservers()
                binding.lvBids.adapter = adapter
                binding.lvAsks.adapter = adapterAsks
            }
        }
    }

    private fun attachObservers() {
        detailCoinViewModel.detailCoin.observe(viewLifecycleOwner) {
            showDetailInfo(it)
        }

        detailCoinViewModel.bidsAsksCoin.observe(viewLifecycleOwner) {
            adapter.submitList(it.payload.bids)
            adapterAsks.submitList(it.payload.asks)
        }
    }


    private fun showDetailInfo(detail: BookDetail) = with(binding) {
        tvMaxPrice.text = getString(R.string.max_price, detail.high)
        tvLowerPrice.text = getString(R.string.min_price, detail.low)
        tvLastPrice.text = getString(R.string.last_price, detail.last)
    }

    private fun callServices(typeCoin: String) {
        detailCoinViewModel.getDetailCoin(typeCoin)
        detailCoinViewModel.getBidsAsksCoin(typeCoin)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}