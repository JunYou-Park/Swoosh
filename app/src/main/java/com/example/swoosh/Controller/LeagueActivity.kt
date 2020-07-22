package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER) ?: player
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueClicked(view: View){
        when(view.id){
            R.id.btn_league_next ->{
                if(toggle_league_mens.isChecked||toggle_league_womens.isChecked||toggle_league_coed.isChecked) {
                    val skillActivity = Intent(this, SkillActivity::class.java)
                    skillActivity.putExtra(EXTRA_PLAYER, player)
                    startActivity(skillActivity)
                }
                else{
                    Toast.makeText(this, "Please select a league." , Toast.LENGTH_SHORT).show()
                }
            }
            R.id.toggle_league_mens ->{
                toggle_league_womens.isChecked = false
                toggle_league_coed.isChecked = false
                player.league = "mens"
            }
            R.id.toggle_league_womens ->{
                toggle_league_coed.isChecked = false
                toggle_league_mens.isChecked = false
                player.league = "womens"
            }
            R.id.toggle_league_coed ->{
                toggle_league_mens.isChecked = false
                toggle_league_womens.isChecked = false
                player.league = "co-ed"
            }
        }
    }
}