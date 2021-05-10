package com.uveous.loopfoonpay

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uveous.taximohdriver.Api.Model.tripresult
import com.uveous.taximohdriver.R

internal class TripListAdapter(private var tripList: List<tripresult>, var currency:String, val context :Context) :
        RecyclerView.Adapter<TripListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var time: TextView = view.findViewById(R.id.time)
        var vechileno: TextView = view.findViewById(R.id.vechileno)
        var origin: TextView = view.findViewById(R.id.origin)
        var destination: TextView = view.findViewById(R.id.destination)
        var fare: TextView = view.findViewById(R.id.fare)
        var status: TextView = view.findViewById(R.id.status)
        var image: ImageView = view.findViewById(R.id.image)
        var cancel: ImageView = view.findViewById(R.id.cancel)

        var card1: CardView = view.findViewById(R.id.card1)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.triplayout, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tripresult = tripList[position]
        holder.time.text = tripresult.request_date+","+tripresult.request_time

        if(tripresult.status!!.contentEquals("ongoing") || tripresult.status!!.contentEquals("completed")|| tripresult.status!!.contentEquals("schedule")){
            holder.cancel.visibility= GONE
            holder.status.visibility= VISIBLE
        }else{
            holder.cancel.visibility= VISIBLE
            holder.status.visibility= GONE
        }


        holder.origin.text = tripresult.origin_address
        holder.vechileno.text = "CRN No - "+tripresult.request_id.toString()
        holder.destination.text = tripresult.destination_address
        holder.fare.text = currency+tripresult.total_trip_price

        holder.status.text=tripresult.status

        holder.card1.setOnClickListener(View.OnClickListener {
            context.startActivity(Intent(context,TripDetail::class.java).putExtra("requestid",tripresult.request_log_id))
        })


    }

    override fun getItemCount(): Int {
        return tripList.size
    }
}
