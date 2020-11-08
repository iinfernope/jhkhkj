package com.cis2818.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setTitle("Conversion App")
        setContentView(R.layout.activity_main)
        val fragment = Temperatures()
        if (savedInstanceState == null) {
            replaceFragment(fragment)
        }
   }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.temperatureMenu -> {
                val fragment = Temperatures()
                replaceFragment(fragment)
                true
            }
            R.id.distanceMenu -> {
                val fragment = DistanceFragment()
                replaceFragment(fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){
        var fragmentManager = supportFragmentManager;
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment,fragment, "TAG")
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
