package com.msoderlund.balancemanager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.msoderlund.balancemanager.R
import com.msoderlund.balancemanager.entities.MoneyAccount

class MainActivityAdapter(private val moneyAccounts: List<MoneyAccount>):
        RecyclerView.Adapter<MainActivityAdapter.CustomViewHolder>() {
    class CustomViewHolder(val constraintLayout: ConstraintLayout): RecyclerView.ViewHolder(constraintLayout)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MainActivityAdapter.CustomViewHolder {
        // create a new view
        val constraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.money_account_listitem, parent, false) as ConstraintLayout
        // set the view's size, margins, paddings and layout parameters
        return CustomViewHolder(constraintLayout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val moneyAccount = moneyAccounts[position]
        val colorIndicatorView = holder.constraintLayout.getViewById(R.id.item_color_indicator) as View
        val accountIconView = holder.constraintLayout.getViewById(R.id.account_icon) as ImageView
        val accountNameView = holder.constraintLayout.getViewById(R.id.account_name) as TextView
        val accountDescriptionView = holder.constraintLayout.getViewById(R.id.account_description) as TextView
        val accountBalanceView = holder.constraintLayout.getViewById(R.id.account_balance) as TextView

        val color = if (moneyAccount.isCredit) {
            ContextCompat.getColor(holder.constraintLayout.context, R.color.creditColor)
        } else {
            ContextCompat.getColor(holder.constraintLayout.context, R.color.nonCreditColor)
        }
        colorIndicatorView.setBackgroundColor(color)

        accountNameView.text = moneyAccount.name
        accountDescriptionView.text = ""
        accountBalanceView.text = "CLP 0"
        accountIconView.setImageDrawable(holder.constraintLayout.context.getDrawable(R.drawable.ic_manage_accounts))
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = moneyAccounts.size

}