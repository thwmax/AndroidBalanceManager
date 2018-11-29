package com.msoderlund.balancemanager.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.msoderlund.balancemanager.R
import com.msoderlund.balancemanager.adapters.MainActivityAdapter
import com.msoderlund.balancemanager.entities.Currency
import com.msoderlund.balancemanager.entities.MoneyAccount
import com.msoderlund.balancemanager.utils.DatabaseObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val accountList = mutableListOf<MoneyAccount>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val fab: View = findViewById(R.id.add_transaction)
        fab.setOnClickListener { view ->
            thread {
                val currency = Currency(0, "CLP", 1.0f)
                val newMoneyAccount = MoneyAccount(0, "Test account", false, Date(), Date(), 30,
                    1, true, currency)
                DatabaseObject.getInstance(this).getMoneyAccountDao().insert(newMoneyAccount)
            }
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        val db = DatabaseObject.getInstance(this)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MainActivityAdapter(accountList)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_money_accounts).apply {
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        thread {
            accountList.addAll(db.getMoneyAccountDao().getAccounts())
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_set_current_month_period -> {
                if (!item.isChecked) item.isChecked = true
                return true
            }
            R.id.action_set_all_time_period -> return true
            R.id.action_set_custom_period -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_manage_accounts -> {
                // Handle the camera action
            }
            R.id.nav_manage_expenses -> {

            }
            R.id.nav_show_statistics -> {

            }
            R.id.nav_settings -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
