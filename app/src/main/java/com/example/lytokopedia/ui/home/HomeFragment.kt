package com.example.lytokopedia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lytokopedia.databinding.FragmentHomeBinding
import com.example.lytokopedia.ui.home.adapter.CategoryAdapter
import com.example.lytokopedia.ui.home.adapter.DiskonAdapter
import com.example.lytokopedia.ui.home.adapter.ProdukTerbaruAdapter
import com.example.lytokopedia.ui.home.adapter.SliderAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var adapterCategory = CategoryAdapter()
    private var adapterSlider = SliderAdapter()
    private var adapterDiskon = DiskonAdapter()
    private var adapterProdukTerbaru = ProdukTerbaruAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupAdapter()
        setData()
        mainButton()
        return root
    }

    private fun setupAdapter(){
        binding.rvCategory.adapter = adapterCategory
        binding.rvSlider.adapter = adapterSlider
        binding.rvDiskon.adapter = adapterDiskon
        binding.rvProductTerbaru.adapter = adapterProdukTerbaru
    }

    private fun setData(){
        viewModel.listCategory.observe(requireActivity(), {
            adapterCategory.addItem(it)
        })

        viewModel.listSlider.observe(requireActivity(), {
            adapterSlider.addItem(it)
        })

        viewModel.listProduct.observe(requireActivity(), {
            adapterDiskon.addItem(it)
        })

        viewModel.listProduct.observe(requireActivity(), {
            adapterProdukTerbaru.addItems(it)
        })
    }

    fun mainButton() {

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}