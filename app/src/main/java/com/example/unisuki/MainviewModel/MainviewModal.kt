package com.example.unisuki.MainviewModelimport

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unisuki.domain.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener // Import the correct listener

class MainviewModal : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _category = MutableLiveData<List<CategoryModel>>()
    val category: LiveData<List<CategoryModel>> = _category

    fun loadCategory() {
        val ref = firebaseDatabase.getReference("Category")
        // Use ValueEventListener here, not DataSnapshot
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                for (child in snapshot.children) {
                    val model = child.getValue(CategoryModel::class.java)
                    if (model != null) {
                        list.add(model)
                    }
                }
                // Update the LiveData with the new list
                _category.value = list
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error properly, e.g., log it or show a message
                // For now, you can leave the TODO or log the error
            }
        })
    }
}
