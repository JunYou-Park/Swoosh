package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
        println(league)

    }

    fun skillClicked(view: View){
        when(view.id){
            R.id.btn_skill_finish->{
                if(toggle_skill_baller.isChecked||toggle_skill_beginner.isChecked){
                    val finishActivity = Intent(this, FinishActivity::class.java)
                    finishActivity.putExtra(EXTRA_LEAGUE, league)
                    finishActivity.putExtra(EXTRA_SKILL, skill)
                    startActivity(finishActivity)
                }
                else{
                    Toast.makeText(this, "Please select a skill.", Toast.LENGTH_SHORT).show()
                }

            }
            R.id.toggle_skill_beginner->{
                toggle_skill_baller.isChecked = false
                skill = "beginner"
            }
            R.id.toggle_skill_baller->{
                toggle_skill_beginner.isChecked = false
                skill = "baller"
            }
        }
    }
}