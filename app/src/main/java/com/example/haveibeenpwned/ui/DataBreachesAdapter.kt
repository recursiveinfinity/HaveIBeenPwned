package com.example.haveibeenpwned.ui

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.haveibeenpwned.R
import com.example.haveibeenpwned.data.DataBreach
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_data_breach.*
import kotlinx.android.synthetic.main.item_data_breach.view.*

class DataBreachesAdapter : RecyclerView.Adapter<DataBreachesAdapter.BreachViewHolder>() {

    private val data = ArrayList<DataBreach>()


    fun setData(result: List<DataBreach>) {
        data.clear()
        data.addAll(result)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BreachViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_breach, parent, false)
        return BreachViewHolder(rootView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(breachViewHolder: BreachViewHolder, position: Int) {
        breachViewHolder.bind(data[position])
    }


    inner class BreachViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(dataBreach: DataBreach) {
            tvName.text = dataBreach.name
            tvDescription.text = dataBreach.description
        }
    }

}