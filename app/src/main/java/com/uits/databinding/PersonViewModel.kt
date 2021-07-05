package com.uits.databinding

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.uits.databinding.model.Person
import com.uits.databinding.model.Sound
import java.io.IOException

private const val SOUNDS_FOLDER = "sound"
private const val TAG = "PersonViewModel"

class PersonViewModel(val context: Context) : BaseObservable() {

    var mListPerson = mutableListOf<Person>()
    var mListSound = mutableListOf<Sound>()
    var mAssets: AssetManager = context.assets
    private var mSound: Sound? = null

    val sound: Sound?
        get() = mSound

    val title: String?
        get() = mSound?.name

    fun loadSounds() {
        val soundNames: Array<String>?
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER)
            Log.i(TAG, "Found " + soundNames!!.size + " sounds")
        } catch (ioe: IOException) {
            Log.e(TAG, "Could not list assets", ioe)
            return
        }

        for (filename in soundNames) {
            Log.d(TAG, filename)
        }
    }
}
