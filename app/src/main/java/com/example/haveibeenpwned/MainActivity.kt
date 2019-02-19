package com.example.haveibeenpwned

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.haveibeenpwned.ui.DataBreachesAdapter
import com.example.haveibeenpwned.ui.HomeViewModel
import com.example.haveibeenpwned.ui.di.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    private val dataBreachesAdapter = DataBreachesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerHomeComponent.builder()
                .appComponent((application as App).getAppComponent())
                .build()
                .inject(this)

        val layoutManager = LinearLayoutManager(this)

        rvData.layoutManager = layoutManager
        rvData.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        rvData.adapter = dataBreachesAdapter

        homeViewModel.getData().observe(this, Observer { handleEvent(it) })

        btnGetData.setOnClickListener {
            homeViewModel.getDomainDetails(etDomainName.text.toString())
        }
    }

    private fun handleEvent(event: HomeViewModel.Event?) {
        when(event?.status) {
            HomeViewModel.TYPE.SUCCESS -> dataBreachesAdapter.setData(event.payload)
            HomeViewModel.TYPE.FAILURE -> Toast.makeText(this, event.message, Toast.LENGTH_LONG).show()
        }
    }
}