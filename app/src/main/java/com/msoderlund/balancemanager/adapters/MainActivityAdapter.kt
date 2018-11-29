package com.msoderlund.balancemanager.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.msoderlund.balancemanager.R
import com.msoderlund.balancemanager.entities.MoneyAccount

class MainActivityAdapter(private val moneyAccounts: Array<MoneyAccount>):
        RecyclerView.Adapter<MainActivityAdapter.CustomViewHolder>() {
    class CustomViewHolder(val constraintLayout: ConstraintLayout): RecyclerView.ViewHolder(constraintLayout)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MainActivityAdapter.CustomViewHolder {
        // create a new view
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false) as ConstraintLayout
        // set the view's size, margins, paddings and layout parameters
        return CustomViewHolder(constraintLayout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.constraintLayout.getViewById() = moneyAccounts[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = moneyAccounts.size

}