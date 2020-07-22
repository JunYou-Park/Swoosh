package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER) ?: Player("Null","Null")

    }

    fun skillClicked(view: View){
        when(view.id){
            R.id.btn_skill_finish->{
                if(toggle_skill_baller.isChecked||toggle_skill_beginner.isChecked){
                    val finishActivity = Intent(this, FinishActivity::class.java)
                    finishActivity.putExtra(EXTRA_PLAYER, player)
                    startActivity(finishActivity)
                }
                else{
                    Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
                }

            }
            R.id.toggle_skill_beginner->{
                toggle_skill_baller.isChecked = false
                player.skill = "beginner"
            }
            R.id.toggle_skill_baller->{
                toggle_skill_beginner.isChecked = false
                player.skill = "baller"
            }
        }
    }
}