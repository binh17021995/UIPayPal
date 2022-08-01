package com.monstarlab.designui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.R
import com.monstarlab.designui.model.TradeHistory

class TradeAdapter(private var listTrade: ArrayList<TradeHistory>) :
    RecyclerView.Adapter<TradeAdapter.TradeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TradeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_trade_history, parent, false)
        return TradeViewHolder(view)
    }

    override fun onBindViewHolder(holder: TradeViewHolder, position: Int) {
        val tradeHistory = listTrade[position]
        holder.titleTrade.text = tradeHistory.titleTrade
        holder.contentTrade.text = tradeHistory.contentTrade
        if (tradeHistory.valueTrade >= 0) {
            holder.valueTrade.text = tradeHistory.valueTrade.toString() + "€"
            holder.valueTrade.setTextAppearance(R.style.TextStyle13)
        } else {
            holder.valueTrade.text = tradeHistory.valueTrade.toString() + "€"
            holder.valueTrade.setTextAppearance(R.style.TextStyle10)
        }

        if(position == listTrade.size -1){
            holder.dotted.background = null
        } else{
            holder.dotted.setBackgroundResource(R.drawable.dotted)
        }

    }

    override fun getItemCount(): Int {
        return listTrade.size
    }

    inner class TradeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTrade: TextView
        var contentTrade: TextView
        var valueTrade: TextView
        var dotted : ImageView

        init {
            titleTrade = itemView.findViewById(R.id.tv_title_trade_history)
            contentTrade = itemView.findViewById(R.id.tv_content_trade_history)
            valueTrade = itemView.findViewById(R.id.tv_value_trade_history)
            dotted = itemView.findViewById(R.id.img_dotted)
        }

    }
}
