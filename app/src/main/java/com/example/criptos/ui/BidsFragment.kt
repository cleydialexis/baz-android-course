package com.example.criptos.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.criptos.databinding.FragmentBidsBinding
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.ui.viewModels.BidsViewModel
import com.example.criptos.util.Constants.COINKEY
import javax.inject.Inject


class BidsFragment : Fragment() {
    @Inject
    lateinit var booksDao: BooksDao
    private var _binding: FragmentBidsBinding? = null
    private val binding get() = _binding!!

    private val bidsViewmodel: BidsViewModel by viewModels()
    /*  {
          ViewModelFactorym(DetailCoinUseCase(DetailCoinRepositoryImpl(retrofit, booksDao)))
      }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var typeCoin = it.getString(COINKEY)
            Log.d("Mensaje", "type: $typeCoin")
            callServices()
            attachObservers()
        }
    }

    private fun attachObservers() {
        bidsViewmodel.bidsCoin.observe(viewLifecycleOwner) {

        }
    }

    private fun callServices() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBidsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}