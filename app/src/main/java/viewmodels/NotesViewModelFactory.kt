package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
// NOT NEEDED
//class NotesViewModelFactory(): ViewModelProvider.Factory{
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(NotesViewModel::class.java)){
//            return NotesViewModel() as T
//        }
//        throw IllegalArgumentException ("UnknownViewModel")
//    }
//}