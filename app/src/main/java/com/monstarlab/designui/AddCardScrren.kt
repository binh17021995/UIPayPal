package com.monstarlab.designui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.model.Card
import com.monstarlab.designui.adapter.CardAdapter

class AddCardScrren : AppCompatActivity() {

     private lateinit var listCard: ArrayList<Card>
     private lateinit var recyclerViewCard: RecyclerView
     private lateinit var cardAdapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_card_scrren)
        initView()

    }

    private fun initView() {
        recyclerViewCard = findViewById(R.id.recyclerview_addcard)
        recyclerViewCard.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        listCard = ArrayList()
        addCard()
        cardAdapter = CardAdapter(this, listCard)
        recyclerViewCard.adapter = cardAdapter

    }

    private fun addCard() {
        listCard.add(Card(R.drawable.mastercard_2, "Mastercard", "****9889"))
        listCard.add(Card(R.drawable.visa_card, "Visa black", "****8764"))
        listCard.add(Card(R.drawable.visa_card, "Visa black", "****8764"))
    }
}


