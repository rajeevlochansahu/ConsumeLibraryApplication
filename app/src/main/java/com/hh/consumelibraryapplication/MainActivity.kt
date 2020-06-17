package com.hh.consumelibraryapplication

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.hh.myapplication.MyCareTeamConsult
import com.hh.myapplication.MyCareTeamConsult.VolleyCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            val myCareTeamConsult = MyCareTeamConsult()
            myCareTeamConsult.handleNetworkCall(object : VolleyCallback {

                override fun onSuccess(successResponse: String?) {
                    Log.d("MainActivity", "Response is: $successResponse")
                }

                override fun onError(errorResponse: String?) {
                    Log.d("MainActivity", "Response is: $errorResponse")
                }

            })

            /*val myCareTeamConsult = MyCareTeamConsult()
            try {
                val myCareTeam: JSONObject = myCareTeamConsult.getMyCareTeam()
                Log.d("MainActivity123" , "myCareTeam response: $myCareTeam")
            } catch (e: Exception) {
                Log.d("MainActivity123" , "Exception: ${e.message}")
                e.printStackTrace()
            } catch (e: ResponseException) {
                Log.d("MainActivity123" , "ResponseException: ${e.message}")
                e.printStackTrace()
            } catch (e: InternetException) {
                Log.d("MainActivity123" , "InternetException: ${e.message}")
                e.printStackTrace()
            }*/

            //handleNetworkCall()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()


        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*private fun handleNetworkCall() {
        val url = "https://api.ipify.org/?format=json"

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("MainActivity", "Response is: ${response}")
            },
            Response.ErrorListener { Log.d("MainActivity", "That didn't work!") })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }*/
}
