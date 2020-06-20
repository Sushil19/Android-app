package com.example.lanisters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.btn_scan) {
            Toast.makeText(this, "The scanner runs here", Toast.LENGTH_LONG).show()

            val scanner = IntentIntegrator(this)

            scanner.initiateScan()

            fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent?) {
                val result : IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if(result != null) {
                    if(result.getContents() == null) {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    super.onActivityResult(requestCode, resultCode, data);
                }
            }

            return true
        }
        if (id == R.id.action_two) {
            val intent = Intent(this , generator :: class.java)
            startActivity(intent)
            Log.i( "Activity open" , "The generator activity opened")

            Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_three) {
            Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
            return true
        }


    return super.onOptionsItemSelected(item)
    }
}
