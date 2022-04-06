package com.tappyplay.mybasicbinding_2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tappyplay.mybasicbinding_2.databinding.ActivityMainBinding
import viewmodels.NotesViewModel

//import viewmodels.NotesViewModelFactory -- replaced with 'import viewmodels.NotesViewModel provided by dependency - androidx.activity:activity-ktx'
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: starts")

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        // Code is in onResume()
        //
    }

    //    Android Lifecycle overrides
    override fun onStop() {
        super.onStop()
//        Toast.makeText(this, getString(R.string.onStop), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
//        Toast.makeText(this, getString(R.string.onRestart), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
//        Toast.makeText(this, getString(R.string.onResume), Toast.LENGTH_SHORT).show()

//        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel: NotesViewModel by viewModels() // provided by dependency - androidx.activity:activity-ktx

        databinding.notesViewModel = viewModel

        databinding.lifecycleOwner = this

        viewModel.list.observe(this) { databinding.content.text = it.toString() }

        viewModel.isStringEmpty.observe(this) {
            if (it == false) {
                Toast.makeText(this, "No Notes Detected", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
//        Toast.makeText(this, getString(R.string.onStart), Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this, getString(R.string.onPause), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this, getString(R.string.onDestroy), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onDestroy()")
    }
}