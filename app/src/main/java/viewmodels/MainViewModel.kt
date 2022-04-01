package viewmodels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.NoteItem
class NotesViewModel : ViewModel(), Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val inputTitle = MutableLiveData<String>()
    @Bindable
    val inputDescription = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<NoteItem>>()
    private val arraylst = ArrayList<NoteItem>()

    init {
        isStringEmpty.value = false
    }

    fun addData() {
        val title = inputTitle.value!!
        val description = inputDescription.value!!
        if(title.isBlank()|| description.isBlank()){
            isStringEmpty.value = true
        }else{
            inputTitle.value = " "
            inputDescription.value = " "
            var noteItem =NoteItem(title, description)
            arraylst.add(noteItem)
            list.value = arraylst
        }

    }

    fun clearData(){
        arraylst.clear()
        list.value = arraylst
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}