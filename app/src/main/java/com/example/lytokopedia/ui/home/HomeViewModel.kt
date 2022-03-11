package com.example.lytokopedia.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lytokopedia.data.Category
import com.example.lytokopedia.data.DummyData
import com.example.lytokopedia.data.Product
import com.example.lytokopedia.data.Slider

class HomeViewModel : ViewModel() {

    val listCategory: LiveData<List<Category>> = MutableLiveData<List<Category>>().apply {
        value = DummyData.listCategory
    }

    val listSlider: LiveData<List<Slider>> = MutableLiveData<List<Slider>>().apply {
        value = DummyData.listSlider
    }

    val listProduct: LiveData<List<Product>> = MutableLiveData<List<Product>>().apply {
        value = DummyData.listProduct
    }
}