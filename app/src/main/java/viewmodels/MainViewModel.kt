package viewmodels

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.NoteItem
import java.util.*
import kotlin.collections.ArrayList

private const val TAG = "NotesViewModel"

class NotesViewModel : ViewModel(), Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val inputTitle = MutableLiveData<String>()
    @Bindable
    val inputDescription = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<NoteItem>>()
    private val arraylst = ArrayList<NoteItem>()

    init {
        Log.d(TAG, "NotesViewModel: init")
        isStringEmpty.value = false
    }

    fun addData() {
        Log.d(TAG, "NotesViewModel: addData()")

        val title = inputTitle.value!!
        val description = inputDescription.value!!
        if(title.isBlank()|| description.isBlank()){
            isStringEmpty.value = true
        }else{
            inputTitle.value = " "       // Clear the inputTitle field in the layout
            inputDescription.value = " " // Clear the inputDescription field in the layout
            var noteItem =NoteItem(title, description) // get title and description from the layout into a noteItem
            arraylst.add(noteItem) // add the noteItem to the arraylst
            list.value = arraylst // Put the arrayLst in the list
        }

    }

    fun clearData(){
        Log.d(TAG, "NotesViewModel: clearData()")

        arraylst.clear()
        list.value = arraylst
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}