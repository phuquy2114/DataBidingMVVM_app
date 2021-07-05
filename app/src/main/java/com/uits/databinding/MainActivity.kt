package com.uits.databinding

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.uits.databinding.databinding.ActivityMainBinding
import java.io.IOException

private const val SOUNDS_FOLDER = "sound"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var mSoundAdapter: PersonAdapter
    private lateinit var mPersonViewModel: PersonViewModel
    private lateinit var mAssets: AssetManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        mPersonViewModel = ViewModelProvider(this).get(PersonViewModel(this)::class.java)
//        mPersonViewModel.loadSounds()

        loadSounds()
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mRecyclerView.itemAnimator = DefaultItemAnimator()
        binding.mRecyclerView.isNestedScrollingEnabled = false
        // mSoundAdapter = PersonAdapter();
    }

    fun loadSounds() {
        val soundNames: Array<String>?
        try {
            mAssets = this.resources.assets
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
