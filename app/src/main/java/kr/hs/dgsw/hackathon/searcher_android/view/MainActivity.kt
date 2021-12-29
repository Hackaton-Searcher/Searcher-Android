package kr.hs.dgsw.hackathon.searcher_android.view

import android.app.Activity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import kr.hs.dgsw.hackathon.searcher_android.R
import kr.hs.dgsw.hackathon.searcher_android.base.BaseActivity
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.databinding.ActivityMainBinding
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {

        }
    }
}