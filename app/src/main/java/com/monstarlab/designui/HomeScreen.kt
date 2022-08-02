package com.monstarlab.designui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.adapter.TradeAdapter
import com.monstarlab.designui.model.TradeHistory
import com.monstarlab.designui.model.User
import com.monstarlab.designui.adapter.UserAdapter
import com.monstarlab.designui.my_interface.IClickUser

class HomeScreen : AppCompatActivity() {

    private lateinit var listUser: ArrayList<User>
    private lateinit var listTrade: ArrayList<TradeHistory>
    private lateinit var userAdapter: UserAdapter
    private lateinit var tradeAdapter: TradeAdapter
    private lateinit var recyclerViewUser: RecyclerView
    private lateinit var recyclerViewTrade: RecyclerView
    private lateinit var imgAvatar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        initView()

        imgAvatar.setOnClickListener {
            goToCard()
        }

    }

    private fun goToCard() {
        val intentCard :Intent = Intent(this, AddCardScrren::class.java)
        startActivity(intentCard)
    }

    private fun initView() {
        recyclerViewUser = findViewById(R.id.recyclerview_user)
        recyclerViewTrade = findViewById(R.id.recyclerview_trade_history)
        imgAvatar = findViewById(R.id.img_avatar_tollbar)
        recyclerViewUser.layoutManager = GridLayoutManager(this, 4, RecyclerView.VERTICAL, false)
        recyclerViewTrade.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        listUser = ArrayList()
        listTrade = ArrayList()
        addListUser()
        addListTrade()
        userAdapter = UserAdapter(listUser, object : IClickUser {
            override fun ClickUser(user: User) {
                onClickToPay(user)

            }
        })
        tradeAdapter = TradeAdapter(listTrade)
        recyclerViewUser.adapter = userAdapter
        recyclerViewTrade.adapter = tradeAdapter

    }

    private fun onClickToPay(user: User) {
        val intent : Intent = Intent(this, PayScreen::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun addListTrade() {
        listTrade.add(TradeHistory("El corte inglés", "Pago aceptado", -50))
        listTrade.add(TradeHistory("Maria Lujan", "Pago aceptado", 650))
        listTrade.add(TradeHistory("Maria Lujan", "Pago aceptado", 250))

    }

    private fun addListUser() {
        listUser.add(User(R.drawable.carlos_roca, "Carlos Roca"))
        listUser.add(User(R.drawable.ruby_sanz, "Ruby Sanz"))
        listUser.add(User(R.drawable.mary_rich, "Mary Rich"))
        listUser.add(User(R.drawable.jose_porto, "José Porto"))

    }

}
