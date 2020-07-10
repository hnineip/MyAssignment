package com.hnineiphyu.myassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.myassignment.adapter.ArrivalAdapter
import com.hnineiphyu.myassignment.adapter.CartActivity
import com.hnineiphyu.myassignment.adapter.OnItemClickListener
import com.hnineiphyu.myassignment.adapter.PopularAdapter
import com.hnineiphyu.myassignment.model.Arrival
import com.hnineiphyu.myassignment.model.Product
import java.util.ArrayList

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun OnItemClicked(arrival: Arrival) {

        Toast.makeText(this, "${arrival.firstName}", Toast.LENGTH_LONG).show()

        val intent = Intent(this, CartActivity::class.java).apply {

            putExtra("ARRIVAL_FIRST_NAME", arrival.firstName)
            putExtra("ARRIVAL_SECOND_NAME", arrival.price)
            putExtra("ARRIVAL_IMAGE", arrival.image)
        }

        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        latestArrival()
        popularProduct()
    }

    fun latestArrival(){

        var arrivalRecyclerView: RecyclerView = findViewById(R.id.recycler_arrival)

        var arrivalList = ArrayList<Arrival>()

        arrivalList.add(Arrival("HChairs", 109500.00 , R.drawable.chairs))
        arrivalList.add(Arrival("Sofa",209000.00,R.drawable.sofa))
        arrivalList.add(Arrival("Tables",18900.00,R.drawable.tables))

        var arrivalAdapter = ArrivalAdapter(arrivalList, this)

        arrivalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        arrivalRecyclerView.adapter = arrivalAdapter

    }

    fun popularProduct(){
        var productRecyclerView: RecyclerView = findViewById(R.id.recycler_popular)

        var popularList = ArrayList<Product>()

        popularList.add(Product("NEW","30% off", "Iphone 11 pro max", "Apple", 980000.0, R.drawable.chairone,"110000KS", 5.0))
        popularList.add(Product("NEW","34% off", "GhostedBed 11 inch Cooling Gel Memory Foam......", "GhostBed", 359000.0, R.drawable.chairtwo, "49600KS", 5.0))
        popularList.add(Product("0", "0", "Nintendo Switch-Neon Blue and Red Joy-Con", "Nintendo", 359000.0, R.drawable.bestchairone, "", 4.0))
        popularList.add(Product("NEW", "0","BELAROI Womens Comfy Swing Tunic Short.....", "Belaroi", 18990.0, R.drawable.bestchairtwo, "", 4.0))

        var popularAdapter = PopularAdapter(popularList )

        productRecyclerView.layoutManager = LinearLayoutManager(this)

        productRecyclerView.adapter = popularAdapter
    }
}
