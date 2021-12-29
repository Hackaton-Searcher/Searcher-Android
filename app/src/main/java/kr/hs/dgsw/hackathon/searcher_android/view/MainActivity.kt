package kr.hs.dgsw.hackathon.searcher_android.view

import android.view.MenuItem
import androidx.activity.viewModels
import kr.hs.dgsw.hackathon.searcher_android.R
import kr.hs.dgsw.hackathon.searcher_android.base.BaseActivity
import kr.hs.dgsw.hackathon.searcher_android.base.BaseViewModel
import kr.hs.dgsw.hackathon.searcher_android.databinding.ActivityMainBinding
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {

        }
    }
}