package com.tappyplay.mybasicbinding_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ContentInfoCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.tappyplay.mybasicbinding_2.databinding.ActivityMainBinding
import viewmodels.NotesViewModel

//import viewmodels.NotesViewModelFactory -- replaced with 'import viewmodels.NotesViewModel provided by dependency - androidx.activity:activity-ktx'

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NotesViewModel
    private lateinit var databinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel: NotesViewModel by viewModels() // provided by dependency - androidx.activity:activity-ktx

        databinding.notesViewModel = viewModel

        databinding.lifecycleOwner = this

        viewModel.list.observe(this, Observer {
            databinding.content.text = it.toString()
        })
        viewModel.isStringEmpty.observe(this, Observer {
            if (it == false) {
                Toast.makeText(this, "No Notes Detected", Toast.LENGTH_LONG).show();
            }
        })
    }
}